import java.util.Scanner;

public class Fahrenheit {
    public static void main(String[] args) {
        double fahrenheit;

        Scanner cel = new Scanner(System.in);
        System.out.print("Enter a degree in Fahrenheit: ");
        fahrenheit = cel.nextDouble();

        double celsius = (5.0 / 9) * (fahrenheit - 32);
        System.out.println("Fahrenheit " + fahrenheit + " is " + String.format("%.3f",(celsius)) + " in Celsius");
    }
}
