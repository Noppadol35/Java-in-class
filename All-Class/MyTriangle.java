import java.util.Scanner;

class MyTriangle {
    public static boolean isValid(double side1, double side2, double side3) {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three sides of a triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        if (MyTriangle.isValid(side1, side2, side3)) {
            System.out.println("1 " + MyTriangle.area(side1, side2, side3));
        } else {
            System.out.println("0");
        }
    }
}
