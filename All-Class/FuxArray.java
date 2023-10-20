import java.util.Scanner;

public class FuxArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = input.nextInt();
        double[] x = new double[n];
        System.out.println("Enter numbers: ");
        double sum = 0;
        double sumSD = 0;
        double mean;
        double SD;
        double max;

        for (int i = 0; i < x.length; i++) {
            x[i] = input.nextDouble();
        }
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        mean = sum / n;

        for (int i = 0; i < x.length; i++) {
            sumSD += Math.pow(x[i] - mean, 2);
        }
        SD = Math.sqrt(sumSD / (n - 1));

        max = calmax(x);

        double min = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }

        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + mean);
        System.out.println("SD: " + SD);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        double[] ans = reverse(x); // Corrected the function call and variable name
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static double calmax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static double[] reverse(double[] arr) {
        double[] reverseArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArr[i] = arr[arr.length - 1 - i];
        }
        return reverseArr;
    }
}