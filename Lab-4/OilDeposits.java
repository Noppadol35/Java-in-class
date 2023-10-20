import java.util.Scanner;

public class OilDeposits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            char[][] grid = new char[m][n];

            for (int i = 0; i < m; i++) {
                String row = scanner.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = row.charAt(j);
                }
            }

            int oilDeposits = countOilDeposits(grid);
            System.out.println(oilDeposits);
        }

        scanner.close();
    }

    private static int countOilDeposits(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // ตรวจสอบทุกช่องในตาราง
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '@') {
                    // หา pocket ใหม่และเพิ่มจำนวนบ่อน้ำมัน
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        // ตรวจสอบเซลล์ที่ใกล้เคียงทั้งหมด
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            // ตรวจสอบเซลล์ใกล้เคียง
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] == '@') {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
