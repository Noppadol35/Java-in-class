import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(); // จำนวนเลน
        int startLane = scanner.nextInt(); // เลนเริ่มต้น
        int t = scanner.nextInt(); // ระยะเวลา
        int[] road = new int[t]; // สถานะของถนนในแต่ละช่วงเวลา

        // อ่านสถานะของถนนในแต่ละช่วงเวลา
        for (int i = 0; i < t; i++) {
            road[i] = scanner.nextInt();
        }

        // คำนวณการบังคับรถ
        int currentLane = startLane;
        for (int i = 0; i < t; i++) {
            if (road[i] == 1) {
                // มีสิ่งกีดขวาง บังคับรถเปลี่ยนเลน
                if (currentLane == 1) {
                    currentLane = 2;
                } else {
                    currentLane = 1;
                }
            }
            System.out.println(currentLane);
        }

        scanner.close();
    }
}
