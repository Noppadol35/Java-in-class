import java.util.Scanner;

public class Euclidean_distance {
    public static void main(String[] args) {
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;
        double s;

        Scanner point = new Scanner(System.in);
        System.out.print("Enter x1 and y1: ");
        x1 = point.nextDouble();
        y1 = point.nextDouble();
        System.out.print("Enter x2 and y2: ");
        x2 = point.nextDouble();
        y2 = point.nextDouble();
        System.out.print("Enter x3 and y3: ");
        x3 = point.nextDouble();
        y3 = point.nextDouble();

        double side1;
        double side2;
        double side3;

        side1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        side2 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        side3 = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));

        s = (side1 + side2 + side3) / 2;
        double distance = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        System.out.println("The distance between the three points is " + String.format("%.1f", distance));
    }
}
