import java.util.Scanner;

public class calculate_nterest {
    public static void main(String[] args) {
        double balance; 
        double rate;
        double interest;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
        balance = input.nextDouble();
        rate = input.nextDouble();

        interest = balance * (rate / 1200);

        System.out.println("The interest is " + String.format("%.2f", interest));
    }
}