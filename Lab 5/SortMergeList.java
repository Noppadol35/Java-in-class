import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortMergeList {
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            
            if (num1 == num2) {
                result.add(num1);
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        // รับข้อมูลจากอินพุต
        Scanner scanner = new Scanner(System.in);
        System.out.println("ป้อนรายการตัวเลขในรายการแรก (0 เพื่อสิ้นสุด):");
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            list1.add(num);
        }

        System.out.println("ป้อนรายการตัวเลขในรายการที่สอง (0 เพื่อสิ้นสุด):");
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            list2.add(num);
        }

        // เรียกใช้เมธอด intersect และแสดงผลลัพธ์
        ArrayList<Integer> result = intersect(list1, list2);
        System.out.println("ผลลัพธ์:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
