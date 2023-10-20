import java.util.Scanner;

public class ConsecutiveFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับขนาดของอาร์เรย์สองมิติ
        System.out.print("ป้อนจำนวนแถว: ");
        int rows = scanner.nextInt();
        System.out.print("ป้อนจำนวนคอลัมน์: ");
        int cols = scanner.nextInt();

        // สร้างและรับค่าในอาร์เรย์
        int[][] values = new int[rows][cols];
        System.out.println("ป้อนค่าในอาร์เรย์:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                values[i][j] = scanner.nextInt();
            }
        }

        // เรียกใช้เมธอด isConsecutiveFour และแสดงผลลัพธ์
        boolean result = isConsecutiveFour(values);
        System.out.println("ผลลัพธ์: " + result);

        scanner.close();
    }

    public static boolean isConsecutiveFour(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;

        // ตรวจสอบแนวนอน
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (values[i][j] == values[i][j + 1] &&
                    values[i][j] == values[i][j + 2] &&
                    values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }

        // ตรวจสอบแนวตั้ง
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j < cols; j++) {
                if (values[i][j] == values[i + 1][j] &&
                    values[i][j] == values[i + 2][j] &&
                    values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }

        // ตรวจสอบแนวทะแยงจากซ้ายลงขวา
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (values[i][j] == values[i + 1][j + 1] &&
                    values[i][j] == values[i + 2][j + 2] &&
                    values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        // ตรวจสอบแนวทะแยงจากขวาลงซ้าย
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 3; j < cols; j++) {
                if (values[i][j] == values[i + 1][j - 1] &&
                    values[i][j] == values[i + 2][j - 2] &&
                    values[i][j] == values[i + 3][j - 3]) {
                    return true;
                }
            }
        }

        return false;
    }
}
