import java.util.ArrayList;

abstract class Employee {
    private String firstname;
    private String lastname;
    private String id;

    public Employee(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public abstract double earning();

    public abstract double bonus(int year);
}

class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String firstname,String lastname,String id, double sal){
        super(firstname,lastname,id);
        this.salary = sal;
    }
    @Override
    public double bonus(int year){
        double bonus = 0;
        if(year > 5){
            bonus = 12*salary;
        }
        else{
            bonus = 6*salary;
        }
        return bonus;
    }

    @Override
    public double earning(){
        double vat = 0.05;
        return salary - (salary*vat);
    }
}

class ComEmployee extends Employee{
    private int grossSale;
    private int ComRate;

    public ComEmployee(String firstname,String lastname,String id, int sales, int percent){
        super(firstname,lastname,id);
        this.grossSale = sales;
        this.ComRate = percent;
    }
    @Override
    public double bonus(int year){
        double bonus = 0;
        if(year > 5){
            bonus = 6*grossSale;
        }
        else{
            bonus = 6*grossSale;
        }
        return bonus;
    }

    @Override
    public double earning(){
        return grossSale * ComRate;
    }
}



public class C8_lab4 {
    public static void main(String[] args) {

        ArrayList<Employee> emp = new ArrayList<Employee>();

        emp.add(new SalariedEmployee("Ohm","my","1",10000));
        emp.add(new SalariedEmployee("Pnpg","pp","2",15000));
        emp.add(new ComEmployee("Ohm","my","4",10000,10));
        emp.add(new ComEmployee("Pnpg","pp","5",15000,10));
        printEmployee(emp);

    }
    public static void printEmployee(ArrayList<Employee> emp){
        double[] arrEarn = new double[emp.size()];
        double[] arrBonus = new double[emp.size()];
        for(int i = 0 ; i < emp.size() ; i++){
            Employee e = emp.get(i);
            arrEarn[i] = e.earning();
            arrBonus[i] = e.bonus(5);

            System.out.println("Employee ID : "+e.getId()+"\nName : "+e.getFirstname()+" "+e.getLastname()+"\nEarning : "+arrEarn[i]+"\nBonus : "+arrBonus[i]+"\n");
        }
    }
}
