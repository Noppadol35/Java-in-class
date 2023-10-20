import java.util.Scanner;

class RoachPopulation {
    private int population;

    public RoachPopulation(int initialPopulation) {
        population = initialPopulation;
    }

    public void waitR() {
        population *= 2;
    }

    public void spray() {
        population = population - (population / 10); // แก้ไขเป็นการลดลง 10%
    }

    public int getRoaches() {
        return population;
    }
}

public class RoachPopulationTest {
    public static void main( String[] args) {
        // รับข้อมูลเริ่มต้นจากผู้ใช้
        Scanner input = new Scanner(System.in);
        System.out.print("Enter initial roach population: ");
        int initialPopulation = input.nextInt();
        System.out.print("Enter number of rounds: ");
        int rounds = input.nextInt();
        
        // สร้างวัตถุ RoachPopulation
        RoachPopulation roachPopulation = new RoachPopulation(initialPopulation);

        // ทดลองเรียกใช้เมธอด wait, spray และพิมพ์จำนวนแมลงสาบที่มีในแต่ละรอบ
        for (int i = 1; i <= rounds; i++) {
            roachPopulation.waitR();
            roachPopulation.spray();
            
        }
        System.out.println(roachPopulation.getRoaches());
    }
}
