import java.util.Scanner;

public class L9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the numbers: ");
        int num;
        int max = Integer.MIN_VALUE;
        int count = 0;

        do {
            num = input.nextInt();

            if (num > max) {
                count = 1;
                max = num;
            } else if (num == max) {
                count++;
            }
        } while (num != 0);

        System.out.println("The largest number is " + max);
        System.out.println("Count: " + count);
    }
}
