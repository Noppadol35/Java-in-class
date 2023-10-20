import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class L8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of n, a0, a1: ");
        int n = input.nextInt();
        int a0 = input.nextInt();
        int a1 = input.nextInt();

        double ak = 0;

        System.out.println("The values of a0, a1, ..., an are:");

        for (int k = 0; k <= n; k++) {
            if(k == 0)
            {
                System.out.print(a0 + " ");
            }
            else if(k == 1)
            {
                System.out.print(a1 + " ");
            }
            else
            {
                ak = (Math.pow(k, 2) *a1) - a0 + Math.pow(3,k);
                a0 = a1;
                a1 = (int)ak;
            }

            System.out.print(" " + ak);
        }
    }
}