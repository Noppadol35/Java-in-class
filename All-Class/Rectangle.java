import java.util.Scanner;

class Rectangle{
    private double x ;
    private double y ;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height)
    {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    public boolean isInsideOROverside(Rectangle other)
    {
        double x1 = this.x - this.width / 2;
        double x2 = this.x + this.width / 2;
        double y1 = this.y - this.height / 2;
        double y2 = this.y + this.height / 2;

        double otherX1 = other.x - other.width / 2;
        double otherX2 = other.x + other.width / 2;
        double otherY1 = other.y - other.height / 2;
        double otherY2 = other.y + other.height / 2;

        return (x1 <= otherX1 && x2 >= otherX2 && y1 <= otherY1 && y2 >= otherY2);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter r1's x y width height : ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double width1 = input.nextDouble();
        double height1 = input.nextDouble();
        Rectangle r1 = new Rectangle(x1, y1, width1, height1);

        System.out.print("Enter r2's x y width height: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double width2 = input.nextDouble();
        double height2 = input.nextDouble();
        Rectangle r2 = new Rectangle(x2, y2, width2, height2);

        if(r2.isInsideOROverside(r1))
        {
            System.out.println("r2 is inside r1");
        }
        else
        {
            System.out.println("r1 is inside r2");
        }
    }
}