
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;


    /** Default constructor */
    protected GeometricObject() {
    }

    /** Convenience constructor */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double findArea();

    public abstract double findPerimeter();
}

class Circle extends GeometricObject {
    private double radius;

    /** Default constructor */
    public Circle() {
        this(1.0);
    }

    /** Radius convenience constructor */
    public Circle(double radius) {
        this(radius, "white", false);
    }

    /** Convenience constructor for all properties */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Return the radius
     * 
     * @return radius Current radius of Circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the area of the current circle
     * Implemention of abstract method in GeometricObject
     * 
     * @return area of the circle
     */
    public double findArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Returns the perimeter of the current circle
     * Implemention of abstract method in GeometricObject
     * 
     * @return perimeter of the circle
     */
    public double findPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Provide a string representation of the object
     */
    public String toString() {
        return "Circle: radius = " + radius;
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    /** Default constructor */
    public Rectangle() {
        this(1.0, 1.0);
    }

    /** Convenience constructor */
    public Rectangle(double width, double height) {
        this(width, height, "white", false);
    }

    /** Convenience constructor for all properties */
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    /**
     * Return the width
     * 
     * @return width Current width of Rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set the width of the rectangle
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return the height
     * 
     * @return height Current height of Rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height of the rectangle
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Returns the area of the current rectangle
     * Implemention of abstract method in GeometricObject
     * 
     * @return area of the rectangle
     */
    public double findArea() {
        return width * height;
    }

    /**
     * Returns the perimeter of the current rectangle
     * Implemention of abstract method in GeometricObject
     * 
     * @return perimeter of the rectangle
     */
    public double findPerimeter() {
        return 2 * (width + height);
    }

    /**
     * Provide a string representation of the object
     */
    public String toString() {
        return "Rectangle: width = " + width + " height = " + height;
    }
}

public class Test1 {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        // สร้างวงกลม C1 โดยใช้ Default Constructor 
        // Radius = 1.0 Color = "white" Filled = false
        Circle c2 = new Circle(2.0);
        // สร้างวงกลม C2 โดยใช้ Radius convenience constructor 
        //Radius = 2.0 Color = "white" Filled = false
        Circle c3 = new Circle(3.0, "red", true);
        // สร้างวงกลม C3 โดยใช้ Convenience constructor for all properties
        //Radius = 3.0 Color = "red" Filled = true
    }
}
