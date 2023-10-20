import java.util.Scanner;

public class ClosestPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // อ่านจำนวนจุด
        int n = scanner.nextInt();
        double[][] points = new double[n][2];

        // อ่านพิกัดของจุดแต่ละจุด
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextDouble(); // พิกัด x
            points[i][1] = scanner.nextDouble(); // พิกัด y
        }

        scanner.close();

        double minDistance = Double.MAX_VALUE;

        // คำนวณระยะทางระหว่างจุดทุกคู่และหาคู่จุดที่ใกล้เคียงกันมากที่สุด
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = calculateDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        System.out.println(minDistance);
    }

    // คำนวณระยะทางระหว่างจุดสองจุด
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
