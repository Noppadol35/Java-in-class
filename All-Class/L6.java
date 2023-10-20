import java.util.Scanner;

public class L6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please input number of columns and rows: ");
        int column = sc.nextInt();
        int row = sc.nextInt();

        int fisrtRow = 2;
        int firstColumn = 1;

        for (int i = 1; i <= column; i++) {
            if (i == 1) {
                System.out.print("  ");
            } else {
                System.out.print("" + firstColumn + " ");
            }
            firstColumn++;
        }
        System.out.println();

        for (int i = 2; i <= row; i++) {
            System.out.print("" + fisrtRow + " ");
            for (int j = 2; j <= column; j++) {

                System.out.print("" + i * j + " ");
            }
            System.out.println();
            fisrtRow++;

        }

    }

}