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
public class Drawing extends Applet{
	Graphics g;

	public void paint(Graphics g) {
		this.g = g;
		/*drawPoint(30, 50);*/
		/*
		drawHLine(300, 200, 600);
		drawVline(500, 0, 500);
		drawVLine(500, 0, 500);
		drawLineAtAngle(50, 50, 50, 5);
		drawRect(5, 200, 5, 100);
		*/
		drawLineProf(30, 50, 100, 190);
		//drawRectProf(100, 200, 300, 100); //not working please revise
	}

	public void drawLineProf(int x1, int y1, int x2, int y2){
		//calculate slope
		int dx = x2 - x1;
		int dy = y2 - y1;

		if( dx == 0 ) drawVLine(x1, y1, y2);
		else
			if(dy == 0) drawHLine(x1, x2, y1);
		else
		{
			double m = (double)dy /dx;
		}
		//dividing ints is going to truncate a lot of information to calculate our slope
		double m = (double) dy / dx;

		double y = y1;

		for(int x = x1; x <= x2; x++){
			drawPoint(x, (int)y);

			y += m;
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
}