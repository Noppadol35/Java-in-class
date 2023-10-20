import java.util.Scanner;

public class fxn {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value x,n: ");

        double x = input.nextDouble();
        double n = input.nextDouble();

        double f = 0.0;
        for(int i = 0; i <= n; i++)
        {
            f += Math.pow(x,i);
        }

        System.out.println("f(" + x + ", " + n + ") = " + f);
    }
    
    
}
