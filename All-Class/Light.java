import java.util.Scanner;

public class Light {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // อ่านจำนวนยานบิน (N) และจำนวนจุดที่เกิดแสง (M)
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // อ่านตำแหน่งของยานบินและจุดสิ้นสุดของยาน
        int[][] airplanes = new int[N][2];
        for (int i = 0; i < N; i++) {
            airplanes[i][0] = scanner.nextInt(); // ตำแหน่งเริ่มต้นของยาน
            airplanes[i][1] = scanner.nextInt(); // ตำแหน่งสิ้นสุดของยาน
        }
        
        // อ่านตำแหน่งของจุดที่แสงเกิด
        int[] lightPoints = new int[M];
        for (int i = 0; i < M; i++) {
            lightPoints[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        // คำนวณจำนวนจุดที่แสงส่งผ่านยานบิน
        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean passedThrough = false;
            for (int j = 0; j < N; j++) {
                // ตรวจสอบว่าแสงส่งผ่านยานบินหรือไม่
                if (lightPoints[i] > Math.min(airplanes[j][0], airplanes[j][1]) &&
                    lightPoints[i] < Math.max(airplanes[j][0], airplanes[j][1])) {
                    passedThrough = true;
                    break; // ไม่ต้องตรวจสอบยานบินอื่นต่อ
                }
            }
            if (!passedThrough) {
                count++;
            }
        }
        
        // แสดงผลลัพธ์
        System.out.println(count);
    }
}
