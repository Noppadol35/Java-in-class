import java.util.Scanner;

public class Circle {
    double radius;
    double area;

    //medthod

    public double calArea() {
        area = 3.14 * radius * radius;
        return area;
    }

    public double printCircle()
    {
        System.out.println("Radius: " + radius + "Area: " + calArea());
        return area;
    }
}
