import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class Location {
    public int r;
    public int c;

    Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class L7P6 {
    private static final int WALL = 0;
    private static final int EXIT = 3;
    private static int shortestPath = Integer.MAX_VALUE;
    private static ArrayList<Location> wallAroundPlayer = new ArrayList<Location>();
    private static ArrayList<Location> wallPlayerCanBomb = new ArrayList<Location>();

    private static void findWallAroundPlayer(int[][] maze, boolean[][] visited, int row, int col) {
        int m = maze.length;
        int n = maze[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return;
        }

        if (maze[row][col] == WALL) {
            boolean duplicate = false;

            for (int i = 0; i < wallAroundPlayer.size(); i++) {
                if (wallAroundPlayer.get(i).r == row && wallAroundPlayer.get(i).c == col) {
                    duplicate = true;
                }
            }

            if (!duplicate) {
                wallAroundPlayer.add(new Location(row, col));
            }

            return;
        }

        visited[row][col] = true;

        findWallAroundPlayer(maze, visited, row + 1, col);
        findWallAroundPlayer(maze, visited, row - 1, col);
        findWallAroundPlayer(maze, visited, row, col + 1);
        findWallAroundPlayer(maze, visited, row, col - 1);

        visited[row][col] = false;
    }

    public static boolean findWallPlayerCanBomb(int maze[][], int r, int c) {
        Queue<Location> q = new LinkedList<>();

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (maze[i][j] == 4) {
                    q.add(new Location(i, j));

                    break;
                }
            }
        }

        while (q.size() != 0) {
            Location x = q.peek();
            q.remove();
            int i = x.r;
            int j = x.c;

            if (i < 0 || i >= r || j < 0 || j >= c)
                continue;

            if (maze[i][j] == 0)
                continue;

            if (maze[i][j] == 3) {
                return true;
            }

            maze[i][j] = 0;

            for (int k = -1; k <= 1; k += 2) {
                q.add(new Location(i + k, j));
                q.add(new Location(i, j + k));
            }
        }

        return false;
    }

    private static void findShortestPath(int[][] maze, boolean[][] visited, int row, int col, int distance) {
        int m = maze.length;
        int n = maze[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || maze[row][col] == 0 || visited[row][col]) {
            return;
        }

        if (maze[row][col] == EXIT) {
            shortestPath = Math.min(shortestPath, distance);

            return;
        }

        visited[row][col] = true;

        findShortestPath(maze, visited, row + 1, col, distance + 1);
        findShortestPath(maze, visited, row - 1, col, distance + 1);
        findShortestPath(maze, visited, row, col + 1, distance + 1);
        findShortestPath(maze, visited, row, col - 1, distance + 1);

        visited[row][col] = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int exit[] = new int[2];
        int player[] = new int[2];

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int maze[][] = new int[m][n];

        for (int i = 0; i < 2; i++) {
            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt() - 1;

            if (i == 0) {
                player[0] = r;
                player[1] = c;
            }

            if (i == 1) {
                exit[0] = r;
                exit[1] = c;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        maze[exit[0]][exit[1]] = 3;
        maze[player[0]][player[1]] = 2;

        boolean[][] visited = new boolean[m][n];

        findWallAroundPlayer(maze, visited, player[0], player[1]);

        for (int i = 0; i < wallAroundPlayer.size(); i++) {
            int row = wallAroundPlayer.get(i).r;
            int col = wallAroundPlayer.get(i).c;

            maze[row][col] = 4;

            int[][] matrix = new int[maze.length][];

            for (int j = 0; j < maze.length; j++) {
                matrix[j] = maze[j].clone();
            }

            boolean bombCanGoToExit = findWallPlayerCanBomb(matrix, m, n);

            if (bombCanGoToExit) {
                wallPlayerCanBomb.add(new Location(row, col));
            }

            maze[row][col] = 0;
        }

        for (int i = 0; i < wallPlayerCanBomb.size(); i++) {
            maze[wallPlayerCanBomb.get(i).r][wallPlayerCanBomb.get(i).c] = 1;
        }

        findShortestPath(maze, visited, player[0], player[1], 0);

        System.out.println(wallPlayerCanBomb.size());
        System.out.println(shortestPath == Integer.MAX_VALUE ? -1 : shortestPath + 1);

        scanner.close();
    }
}