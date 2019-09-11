import java.awt.*;


public class Rect {
    int x;
    int y;

    int w;
    int h;

    //Constructor. The job of a constructor is to initialize the object with a valid state. This is based on the idea of
    // mathematical induction. If n is true therefore n + 1 is also true up to infinity.
    public Rect(int x, int y, int w, int h){
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void moveBy(int dx, int dy){
        x += dx;
        y += dy;
    }
    public void draw(Graphics g){
        g.drawRect(x, y, w, h);
    }
}
