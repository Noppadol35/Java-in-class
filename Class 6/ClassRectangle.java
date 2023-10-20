class Rectangle {
    private double width;
    private double height;
    private double x;
    private double y;

    public Rectangle(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Line {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}

public class ClassRectangle {
    public static int contains(Line a, Rectangle b) {
        double lineX1 = a.getX1();
        double lineY1 = a.getY1();
        double lineX2 = a.getX2();
        double lineY2 = a.getY2();

        double rectX1 = b.getX();
        double rectY1 = b.getY();
        double rectX2 = b.getX() + b.getWidth();
        double rectY2 = b.getY() + b.getHeight();

        if (lineX1 >= rectX1 && lineX1 <= rectX2 && lineY1 >= rectY1 && lineY1 <= rectY2 &&
            lineX2 >= rectX1 && lineX2 <= rectX2 && lineY2 >= rectY1 && lineY2 <= rectY2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int cross(Line a, Line b) {
        double aX1 = a.getX1();
        double aY1 = a.getY1();
        double aX2 = a.getX2();
        double aY2 = a.getY2();

        double bX1 = b.getX1();
        double bY1 = b.getY1();
        double bX2 = b.getX2();
        double bY2 = b.getY2();

        if ((aX1 >= bX1 && aX1 <= bX2 && aY1 >= bY1 && aY1 <= bY2) ||
            (aX2 >= bX1 && aX2 <= bX2 && aY2 >= bY1 && aY2 <= bY2)) {
            return 1; 
        } else {
            return 0; 
        }
    }

    public static int overlaps(Rectangle a, Rectangle b) {
        double aX1 = a.getX();
        double aY1 = a.getY();
        double aX2 = a.getX() + a.getWidth();
        double aY2 = a.getY() + a.getHeight();

        double bX1 = b.getX();
        double bY1 = b.getY();
        double bX2 = b.getX() + b.getWidth();
        double bY2 = b.getY() + b.getHeight();

        if (aX1 < bX2 && aX2 > bX1 && aY1 < bY2 && aY2 > bY1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
