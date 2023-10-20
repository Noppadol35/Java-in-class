import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // อ่านขนาดของเมทริกซ์ A
        int n = scanner.nextInt();
        int l = scanner.nextInt();

        // สร้างเมทริกซ์ A
        int[][] matrixA = new int[n][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // อ่านขนาดของเมทริกซ์ B
        int l2 = scanner.nextInt();
        int m = scanner.nextInt();

        // สร้างเมทริกซ์ B
        int[][] matrixB = new int[l2][m];
        for (int i = 0; i < l2; i++) {
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // ตรวจสอบว่าสามารถคูณเมทริกซ์ A และ B ได้หรือไม่
        if (l != l2) {
            System.out.println("ไม่สามารถคูณเมทริกซ์ A และ B ได้");
            return;
        }

        // สร้างเมทริกซ์ C ขนาด NxM
        int[][] matrixC = new int[n][m];

        // คำนวณผลคูณของเมทริกซ์ A และ B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // แสดงผลลัพธ์ในเมทริกซ์ C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
