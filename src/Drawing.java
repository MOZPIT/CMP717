/*
 * @Program: Homework 1 @ Lehman CS 711 Video Game Programming
 * @Description: Use the method drawLine to create a vertical, horizontal and a line at any angle
 * @Programmer: Jhon Sanchez @mozpit777
 * @Date: Aug 28 2019
 * 
 */
import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("serial")
public class Drawing extends Applet{
	public void paint(Graphics g) {
		drawPoint(30, 50, g);
		drawHLine(50, 80, 100, g);
		drawVLine(80, 50, 150, g);
		drawLineAtAngle(50, 50, 50, 5, g);
	}
	
	public void drawPoint(int x, int y, Graphics g) {
		g.drawLine(x, y, x, y);
	}
	
	public void drawHLine(int x, int y, int x1, Graphics g) {
		for(; x < x1; x++) {
			drawPoint(x, y, g);
		}
	}
	
	public void drawVLine(int x, int y, int y1, Graphics g) {
		for(; y < y1; y++) {
			drawPoint(x, y, g);
		}
	}
	
	public void drawLineAtAngle(int x, int y, int len, double angle, Graphics g) {
		int startX = x;
		int startY = y;
		angle = angle * Math.PI / 180;
		
		int endX = (int) (x + len * Math.sin(angle));
		int endY = (int) (y + len * Math.cos(angle));
		
		g.drawLine(startX, startY, endX, endY);
	}
}