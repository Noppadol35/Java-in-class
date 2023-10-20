import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // รับข้อมูลจากผู้ใช้
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] population = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                population[i][j] = scanner.nextInt();
            }
        }
        
        // หาจำนวนประชากรรวมในพื้นที่บริการที่ดีที่สุด
        int maxPopulation = 0;
        
        for (int i = 0; i <= M - K; i++) {
            for (int j = 0; j <= N - K; j++) {
                int sum = 0;
                for (int x = i; x < i + K; x++) {
                    for (int y = j; y < j + K; y++) {
                        sum += population[x][y];
                    }
                }
                maxPopulation = Math.max(maxPopulation, sum);
            }
        }
        
        // แสดงผลลัพธ์
        System.out.println(maxPopulation);
    }
}
