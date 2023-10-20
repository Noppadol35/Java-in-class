import java.util.Scanner;

public class Estimate {
    private double i;

    public Estimate(double i) {
        this.i = i;
    }

    static double InEstimate(double i) {
        return 4 * (1 + Math.pow(-1, (i + 1)) / ((2 * i) - 1));
    }

    public double getI() {
        return i;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter i: ");

        double i = input.nextDouble();

        System.out.println("i = " + i);
        System.out.println("Estimate = " + InEstimate(i));
    }
}
