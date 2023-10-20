import java.util.Arrays;
import java.util.Scanner;

public class MinTwoSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // อ่านค่า n
        int n = scanner.nextInt();

        // อ่านค่า Wi
        int[] Wi = new int[n];
        for (int i = 0; i < n; i++) {
            Wi[i] = scanner.nextInt();
        }

        // เรียงลำดับค่า Wi ให้เรียงจากน้อยไปหามาก
        Arrays.sort(Wi);

        // คำนวณผลรวมในกลุ่ม A (m จำนวน)
        int sumA = 0;
        for (int i = 0; i < n / 2; i++) {
            sumA += Wi[i];
        }

        // คำนวณผลรวมในกลุ่ม B (n - m จำนวน)
        int sumB = 0;
        for (int i = n / 2; i < n; i++) {
            sumB += Wi[i];
        }

        // คำนวณและแสดงผลผลต่างของผลรวมในแต่ละกลุ่มที่น้อยที่สุด
        int minDifference = Math.abs(sumA - sumB);
        System.out.println(minDifference);

        scanner.close();
    }
}
