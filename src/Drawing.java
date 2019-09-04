/*
 * @Program: Homework 1 @ Lehman CS 711 Video Game Programming
 * @Description: Use the method drawLine to create a vertical, horizontal and a line at any angle
 * @Programmer: M Sanchez @mozpit777
 * @Date: Aug 28 2019
 * TEMP Code: This value belongs to build in xcode --> $(FLUTTER_BUILD_NUMBER)
 * 
 */
import java.awt.*;
import java.applet.Applet;


@SuppressWarnings("serial")
public class Drawing extends Applet implements Runnable
{
	Graphics g;
	Thread t;

	/* the init method of an applet is sort of the main mehtod of a regular function. If a class implements Runnable, it must have a
		run mehtod.
	 */
	public void init(){
		//create the thread
		t = new Thread(this);

		t.start();
	}

	public void run(){
		while(true){

			repaint();

			try{
				t.sleep(16);
			}
			catch(Exception x) {};


		}
	}

	public void paint(Graphics g) {
		this.g = g;

		int [] xpoints = {100, 200, 240, 110, 60};
		int [] ypoints = {100, 80, 200, 210, 180};

		//g.drawPolygon(xpoints, ypoints, 5);

		drawPolyProf(xpoints, ypoints, 5);

		/*drawPoint(30, 50);
		drawHLine(300, 200, 600);
		drawVline(500, 0, 500);
		drawVLine(500, 0, 500);
		drawLineAtAngle(50, 50, 50, 5);
		drawRect(5, 200, 5, 100);
		drawLineProf(30, 50, 100, 490);
		drawRectProf(100, 200, 300, 100); */ //not working please revise
	}

	public void drawPolyProf(int xpoints[], int ypoints[], int n){
		for(int i = 0; i < n-1; i++){
			g.drawLine(xpoints[i], ypoints[i], xpoints[i+1], ypoints[i+1]);
		}
		g.drawLine(xpoints[n-1], ypoints[n-1], xpoints[0], ypoints[0]);

	}

	public void drawLineProf(int x1, int y1, int x2, int y2){
		//calculate slope
		int dx = x2 - x1;
		int dy = y2 - y1;

		if( dx == 0 ) drawVLine(x1, y1, y2);
		else if(dy == 0) drawHLine(x1, x2, y1);
		else
		{
			double m = (double)dy /dx;

			if( m <= 1 ) {
				//dividing ints is going to truncate a lot of information to calculate our slope
				double y = y1;

				for (int x = x1; x <= x2; x++) {
					drawPoint(x, (int) y);

					y += m;
				}
			}else{
				double x = x1;

				for(int y = y1; y <= y2; y++){
					drawPoint((int)x, y);

					x += 1/m;
				}
			}
		}
	}

	public void drawRectProf(int x, int y, int w, int h){
		drawHLineProf(x, x+w, y); //coordinate on top
		drawHLineProf(x, x+w, y+h); //coordinate on bottom

		drawVLine(x, y, y+h); //vertical on the left
		drawVLine(x+w, y, y+h); //vertical on the right
	}

	public void drawPoint(int x, int y) {
		g.drawLine(x, y, x, y);
	}

	public void drawRect(int x, int y, int w, int h){
		g.drawRect(x, w, y, h);
	}

	public void drawHLine(int x, int y, int x1) {
		for(; x < x1; x++) {
			drawPoint(x, y);
		}
	}
	
	public void drawVLine1(int x, int y, int y1) {
		for(; y < y1; y++) {
			drawPoint(x, y);
		}
	}

	/* prof function */
	public void drawHLineProf(int x, int y, int x1){
		for(int i = x; i < x1; i++){
			drawPoint(i, y);
		}
	}

	public void drawVLine(int x, int y1, int y2){
		for(int y = min(y1, y2); y <= max(y1, y2); y++){
			drawPoint(x, y);
		}
	}
	
	public void drawLineAtAngle(int x, int y, int len, double angle) {
		int startX = x;
		int startY = y;
		angle = angle * Math.PI / 180;
		
		int endX = (int) (x + len * Math.sin(angle));
		int endY = (int) (y + len * Math.cos(angle));
		
		g.drawLine(startX, startY, endX, endY);
	}

	public int min(int a, int b){
		if (a < b ) return a;
		else		return b;
	}

	public int max(int a, int b){
		if (a > b ) return a;
		else		return b;
	}

	/*
		When you copy an array you copy a reference to the array. This only happens with objects. It does not happen with primitive data.

	* */
	public void swap(int []list, int A, int B){
		int temp = list[A];
		list[A] = list[B];
		list[B] = temp;
	}
}