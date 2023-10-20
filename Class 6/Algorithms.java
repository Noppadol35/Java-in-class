import java.util.Scanner;

class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return (x >= this.x - width) && (x <= this.x + width) &&
                (y >= this.y - height) && (y <= this.y + height);
    }

    public boolean contains(MyRectangle2D r) {
        double x1 = this.x - this.width;
        double y1 = this.y - this.height;
        double x2 = this.x + this.width;
        double y2 = this.y + this.height;

        double rX1 = r.getX() - r.getWidth();
        double rY1 = r.getY() - r.getHeight();
        double rX2 = r.getX() + r.getWidth();
        double rY2 = r.getY() + r.getHeight();

        return (x1 <= rX1) && (y1 <= rY1) && (x2 >= rX2) && (y2 >= rY2);
    }

    public boolean overlaps(MyRectangle2D r) {
        double x1 = this.x - this.width;
        double y1 = this.y - this.height;
        double x2 = this.x + this.width;
        double y2 = this.y + this.height;

        double rX1 = r.getX() - r.getWidth();
        double rY1 = r.getY() - r.getHeight();
        double rX2 = r.getX() + r.getWidth();
        double rY2 = r.getY() + r.getHeight();

        return !(x1 >= rX2 || x2 <= rX1 || y1 >= rY2 || y2 <= rY1);
    }
}

public class Algorithms {
    
}
