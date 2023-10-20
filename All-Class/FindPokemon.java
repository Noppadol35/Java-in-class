import java.util.Scanner;

public class FindPokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // อ่านขนาดของตาราง HxW
        int h = scanner.nextInt();
        int w = scanner.nextInt();

        // สร้างตารางความถี่ A
        int[][] table = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                table[i][j] = scanner.nextInt();
            }
        }

        int maxSum = -1;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < h - 1; i++) {
            for (int j = 0; j < w - 1; j++) {
                int sum = table[i][j] + table[i][j + 1] + table[i + 1][j] + table[i + 1][j + 1];
                int maxDiff = getMaxDiff(table, i, j);

                if (maxDiff <= 10 && sum > maxSum) {
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println((maxRow + 1) + " " + (maxCol + 2));

        scanner.close();
    }

    private static int getMaxDiff(int[][] table, int row, int col) {
        int maxDiff = 0;

        for (int i = row; i < row + 2; i++) {
            for (int j = col; j < col + 2; j++) {
                for (int x = row; x < row + 2; x++) {
                    for (int y = col; y < col + 2; y++) {
                        maxDiff = Math.max(maxDiff, Math.abs(table[i][j] - table[x][y]));
                    }
                }
            }
        }

        return maxDiff;
    }
}
