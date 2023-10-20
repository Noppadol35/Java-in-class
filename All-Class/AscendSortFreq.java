import java.util.Scanner;
import java.util.Arrays;

public class AscendSortFreq {
    private double[] A;

    // Constructor
    public AscendSortFreq(double[] arr) {
        A = new double[arr.length];
        for (int i = 0; i < A.length; i++) {
            this.A[i] = arr[i];
        }
    }

    public double[] AscenSort(double[] A) {
        // Sorting in ascending order
        Arrays.sort(A);
        return A;
    }

    public void SortCommuFreq(double[] B) {
        Arrays.sort(B);
        int n = B.length;
        for (int i = 0; i < n; i++) {
            if (B[i] != 0) {
                int freq = 1; // Start frequency at 1
                for (int j = i + 1; j < n; j++) {
                    if (B[i] == B[j]) {
                        freq++;
                        B[j] = 0; // Mark as counted
                    }
                }
                System.out.println(B[i] + ": " + freq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        AscendSortFreq asf = new AscendSortFreq(a);
        double[] sortedArray = asf.AscenSort(a);
        
        System.out.println("Sorted Array:");
        for (int i = 0; i < n; i++) {
            System.out.println(sortedArray[i] + " ");
        }
        
        System.out.println("\nCumulative Frequencies:");
        asf.SortCommuFreq(sortedArray);
        
        sc.close();
    }
}
