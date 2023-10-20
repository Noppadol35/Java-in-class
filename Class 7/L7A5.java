class Address {
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressInfo() {
        return "Street : " + this.street + " City : " + this.city;
    }

}

class Employee {
    int id;
    String name;
    double salary;
    Address address;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getDetails() {
        return "Id : " + this.id + "name : " + this.name + " salary : " + this.salary + " address : "
                + this.address.getAddressInfo();
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

class Manager extends Employee {
    String parkingNo;

    public Manager(int id, String name, double salary, String parkingNo) {
        super(id, name, salary);
        this.parkingNo = parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public String getParkingNo() {
        return this.parkingNo;
    }

    public String getDetails() {
        return "name : " + this.name + " salary : " + this.salary + " parkingNo : " + this.parkingNo + " address : "
                + this.address.getAddressInfo();
    }
}

public class L7A5 {
    public static void main(String[] args) {
        Employee emp = new Manager(001, "Somchai", 100000, "A1");
        emp.setAddress(new Address("Wongsawang", "Bangkok"));
        System.out.println(emp.getDetails());
    }
}
