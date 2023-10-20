import java.util.Scanner;

public class Compound_Value {
    public static void main(String[] args) {
        double amount;
        Scanner money = new Scanner(System.in);
        System.out.print("Enter an amount: ");
        amount = money.nextDouble();

        double rate = 0.00417;
        double sum = 0; // กำหนดค่าเริ่มต้นของ sum เป็น amount

        // loop
        for (int i = 0; i < 6; i++) {
            sum = (amount + sum)*(1 + rate); // คำนวณค่ารวม sum
        }

        System.out.println("Output = " + String.format("%.3f", sum));
    }
}
