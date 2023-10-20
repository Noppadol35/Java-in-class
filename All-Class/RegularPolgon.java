import java.util.Scanner;

class RegularPolgon {
    private int n;
    private double side;
    private double x;
    private double y;

    public RegularPolgon() {
        this.n = 3;
        this.side = 1;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolgon(int n , double side, double x, double y)
    {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN() {return n;}
    public double getSide() {return side;}
    public double getX() {return x;}
    public double getY() {return y;}
    // Method to calculate the area of a regular polygon using Heron's formula
    public double getPerimeter()
    {
        return n * side;
    }


    public double getArea()
    {
        double Pi = 3.142;
        return getPerimeter() / 4 * Math.tan(Pi/n);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number n side x y: ");
        int n = input.nextInt();
        double side = input.nextDouble();
        double x = input.nextDouble();
        double y = input.nextDouble();
        RegularPolgon regularPolgon1 = new RegularPolgon(n, side, x, y);
        System.out.println("The area of the polygon is " + regularPolgon1.getArea());
        System.out.println("The perimeter of the polygon is " + regularPolgon1.getPerimeter());

    }
}
