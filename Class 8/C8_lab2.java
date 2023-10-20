
// สร้าง class ชื่อว่า House โดยมีการ implements 2 ตัว คือ Cloneable และ Comparable<House>
class House implements Cloneable, Comparable<House> {
    // สร้างตัวแปร id เป็น private และเป็น int
    private int id;
    // สร้างตัวแปร area เป็น private และเป็น double
    private double area;
    // สร้างตัวแปร whenBuilt เป็น private และเป็น java.util.Date
    private java.util.Date whenBuilt;

    // สร้าง constructor โดยมีการรับค่า id และ area และมีการกำหนดค่าให้กับ whenBuilt
    // เป็นเวลา ณ ปัจจุบัน
    public House(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new java.util.Date();
    }

    // สร้าง getter ของ id, area และ whenBuilt
    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public java.util.Date getWhenBuilt() {
        return whenBuilt;
    }

    // Override method clone ใน class Cloneable โดยใช้ try catch ถ้าเกิด error ให้
    // return null แต่ถ้าไม่เกิด error ให้ return super.clone()
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    // Override method compareTo ใน class Comparable โดยเปรียบเทียบ area ของ object
    // ที่เรียก method กับ object ที่รับเข้ามา
    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
        if (area > o.area)
            return 1;
        else if (area < o.area)
            return -1;
        else
            return 0;
    }

}

public class C8_lab2 {
    public static void main(String[] args) {
        House house1 = new House(1, 1750.50);
        House house2 = (House)house1.clone();

        System.out.println("houes1 \nid : "+ house1.getId()+"\narea : "+ house1.getArea()+"\nwhenBuilt : "+house1.getWhenBuilt());
        System.out.println("houes2 \nid : "+ house2.getId()+"\narea : "+ house2.getArea()+"\nwhenBuilt : "+house2.getWhenBuilt());
        if (house1.compareTo(house2) == 0)
            System.out.println("house1 is the same as house2");
        else
            System.out.println("house1 is not the same as house2");
    }
}