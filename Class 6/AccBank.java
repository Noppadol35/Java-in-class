
class Date {
    private int day;
    private String month;
    private int year;

    Date() {
    }

    Date(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public String getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }
}

class Person {
    private String name;
    private String surname;
    private int age;
    private Date bDate = new Date();
    private Date dateCreated = new Date();

    Person() {
    }

    Person(String name, String surname, int age, Date bDate, Date dateCreated) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bDate = bDate;
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }

    public Date getBDate() {
        return this.bDate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBDate(Date bDate) {
        this.bDate = bDate;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}

class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    Date dateCreated = new Date();
    Person objPerson = new Person();

    Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getID() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public Date getDate() {
        return this.dateCreated;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setDate(int dat, String month, int year) {
        this.dateCreated.setDay(dat);
        this.dateCreated.setMonth(month);
        this.dateCreated.setYear(year);
    }

    public void setPerson(String name, String surname, int age, Date bDate, Date dateCreated) {
        this.objPerson.setName(name);
        this.objPerson.setSurname(surname);
        this.objPerson.setAge(age);
        this.objPerson.setBDate(bDate);
        this.objPerson.setDateCreated(dateCreated);
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return this.balance * dateCreated.getYear();
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
        System.out.println("ถอนเงิน " + amount + " บาท");
        System.out.println("ยิดเงินคงเหลือ " + this.balance + " บาท");
        System.out.println("ดอกเบี้ยที่ได้รับต่อเดือน " + getAnnualInterestRate() + " %");
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
        System.out.println("ฝากงิน " + amount + " บาท");
        System.out.println("ยิดเงินคงเหลือ " + this.balance + " บาท");
        System.out.println("ดอกเบี้ยที่ได้รับต่อเดือน " + getAnnualInterestRate() + " %");
    }

    public void transferMoney(Account acc, double amount) {
        this.setBalance(this.getBalance() - amount);
        acc.setBalance(acc.getBalance() + amount);

    }

}

class SavingAccount extends Account {
    public SavingAccount() {
        super();
    }

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    public void setName(String name) {
        this.objPerson.setName(name);
    }

    public void setSurname(String surname) {
        this.objPerson.setSurname(surname);
    }

    public void setAge(int age) {
        this.objPerson.setAge(age);
    }

    public void setBDate(int day, String month, int year) {
        this.objPerson.setBDate(new Date(day, month, year));
    }

    public void printt() {
        System.out.println("ชื่อ : " + this.objPerson.getName());
        System.out.println("นามสกุล : " + this.objPerson.getSurname());
        System.out.println("อายุ : " + this.objPerson.getAge());
        System.out.println("วันเกิด : " + this.objPerson.getBDate());
        System.out.println("วันที่เปิดบัญชี : " + this.objPerson.getDateCreated());
    }

    @Override
    public void transferMoney(Account acc, double amount) {
        super.transferMoney(acc, amount);
        this.setBalance(this.getBalance() - 20);
        System.out.println("โอนเงิน " + amount + " บาท");
        System.out.println("ยอดเงินคงเหลือ " + this.getBalance() + " บาท");
        System.out.println("ดอกเบี้ยที่ได้รับต่อเดือน " + getAnnualInterestRate() + " %");
    }
}

class FixAccount extends Account {
    public FixAccount() {
        super();
    }

    public FixAccount(int id, double balance) {
        super(id, balance);
    }

    public void setName(String name) {
        this.objPerson.setName(name);
    }

    public void setSurname(String surname) {
        this.objPerson.setSurname(surname);
    }

    public void setAge(int age) {
        this.objPerson.setAge(age);
    }

    public void setBDate(int day, String month, int year) {
        this.objPerson.setBDate(new Date(day, month, year));
    }

    @Override
    public void transferMoney(Account acc, double amount) {
        Date currDate = new Date(22, "November", 2020);
        int year = this.objPerson.getDateCreated().getYear();
        if (currDate.getYear() - year >= 1) {
            super.transferMoney(acc, amount);
            System.out.println("โอนเงิน " + amount + " ฿");
            System.out.println("ยอดเงินคงเหลือ " + this.getBalance() + " ฿");
            System.out.println("ดอกเบี้ยที่ได้รับต่อเดือน " + getAnnualInterestRate() + " %");
        } else {
            System.out.println("ไม่สามารถโอนเงินได้");
        }
    }

    @Override
    public void withdraw(double amount) {
        Date currDate = new Date(19, "June", 2021);

        int year = this.objPerson.getDateCreated().getYear();
        if (currDate.getYear() - year >= 1) {
            super.withdraw(amount);
        } else {
            System.out.println("ไม่สามารถถอนเงินได้");
        }
    }

    public void printt() {
        System.out.println("ชื่อ : " + this.objPerson.getName());
        System.out.println("นามสกุล : " + this.objPerson.getSurname());
        System.out.println("อายุ : " + this.objPerson.getAge());
        System.out.println("วันเกิด : " + this.objPerson.getBDate());
        System.out.println("วันที่เปิดบัญชี : " + this.objPerson.getDateCreated());
    }
}

public class AccBank {
    public static void main(String[] args) {
        SavingAccount AccT = new SavingAccount(1100, 0);

        SavingAccount Acc1 = new SavingAccount(1123, 20000);
        Acc1.setAnnualInterestRate(4.5);
        Person person = new Person("Purm", "Poon", 20, new Date(16, "ธันวาคม", 2003), new Date(6, "กันยายน", 2021));
        Acc1.setPerson(person.getName(), person.getSurname(), person.getAge(), person.getBDate(), person.getDateCreated());
        Acc1.printt();
        Acc1.withdraw(2500);
        Acc1.deposit(3000);
        Acc1.transferMoney(AccT, 5000);

        System.out.println("--------------------------------------------------");
        FixAccount Acc2 = new FixAccount(1124, 20000);
        Acc2.setAnnualInterestRate(7);
        Person person2 = new Person("Noppadol", "Promtas", 20, new Date(22, "November", 2003), new Date(6, "กันยายน", 2021));
        Acc2.setPerson(person2.getName(), person2.getSurname(), person2.getAge(), person2.getBDate(), person2.getDateCreated());
        Acc2.printt();

        Acc2.withdraw(2500);
        Acc2.deposit(3000);
        Acc2.transferMoney(AccT, 5000);
    }
}
