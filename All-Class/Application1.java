import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String firstname;
    private String lastname;
    private String id;
    private double salary;
    private int year;

    public Employee(String firstname, String lastname, String id, double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.salary = salary;
        this.year = year;
    }

    public double earning() {
        double tax = salary * 0.05;
        return salary - tax;
    }

    public double bonus(int year) {
        if (year >= 5) {
            return salary * 12;
        } else {
            return salary * 6;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }
}

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> arrayEarn = new ArrayList<>();

        // รับข้อมูลจากผู้ใช้
        System.out.print("ป้อนจำนวนพนักงาน: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // ล้างบรรทัดว่าง

        for (int i = 1; i <= n; i++) {
            System.out.println("พนักงานที่ " + i);
            System.out.print("firstname: ");
            String firstname = scanner.nextLine();
            System.out.print("Lastname: ");
            String lastname = scanner.nextLine();
            System.out.print("id: ");
            String id = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            System.out.println("Yrea: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // ล้างบรรทัดว่าง
            



            Employee emp = new Employee(firstname, lastname, id, salary);
            arrayEarn.add(emp);
        }

        // เรียก method printEmp เพื่อพิมพ์รายงานพนักงาน
        printEmp(arrayEarn);
    }

    public static void printEmp(ArrayList<Employee> a) {
        for (Employee emp : a) {
            double earning = emp.earning();
            double bonus = emp.bonus(emp.getYear()); // Pass the employee's year parameter
            System.out.println(emp.getFirstname() + "\t" + emp.getLastname() + "\t" + earning + "\t" + bonus);
        }
    }
    
}
