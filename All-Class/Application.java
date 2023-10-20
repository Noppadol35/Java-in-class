import java.util.Date;
import java.util.Scanner;

class Person {
    private String name;
    private String surname;
    private int age;
    private Date bDate;

    public Person() {
        name = "";
        surname = "";
        age = 0;
        bDate = new Date();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        age = 0;
        bDate = new Date();
    }

    @Override
    public String toString() {
        return "Name: " + name + " " + surname + "\nAge: " + age + "\nBirthdate: " + bDate;
    }
}

class Account {
    private int id;
    protected double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private double yearsOpenAcc;
    private Person objPerson;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
        yearsOpenAcc = 0;
        objPerson = new Person();
    }

    public Account(int id, double balance, double annualInterestRate, String name, String surname) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        dateCreated = new Date();
        yearsOpenAcc = 0;
        objPerson = new Person(name, surname);
    }

    public double getMonthlyInterest() {
        double monthlyInterestRate = annualInterestRate / 12;
        return balance * (monthlyInterestRate / 100);
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getYearsOpenAcc() {
        Date currentDate = new Date();
        long millisecondsDiff = currentDate.getTime() - dateCreated.getTime();
        double yearsDiff = millisecondsDiff / (365);
        return yearsDiff;
    }

    @Override
    public String toString() {
        return "Account ID: " + id + "\nBalance: $" + balance + "\nAnnual Interest Rate: " + annualInterestRate
                + "%\nYears Open: " + getYearsOpenAcc() + " years\nMonthly Interest Rate: " + annualInterestRate / 12
                + "%\nMonthly Interest: $" + getMonthlyInterest() + "\n" + objPerson.toString();
    }

    public void transferMoney(Account acc1, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            acc1.deposit(amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance for transfer!");
        }
    }

    public String getId() {
        return null;
    }

    public String getBalance() {
        return null;
    }

    public String getAnnualInterestRate() {
        return null;
    }
}

class SavingAccount extends Account {
    public SavingAccount() {
        super();
    }

    public SavingAccount(int id, double balance, double annualInterestRate, String name, String surname) {
        super(id, balance, annualInterestRate, name, surname);
    }

    @Override
    public void transferMoney(Account acc1, double amount) {
        if (balance >= amount + 20) {
            withdraw(amount + 20);
            acc1.deposit(amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance for transfer!");
        }
    }
}

class FixAccount extends Account {
    public FixAccount() {
        super();
    }

    public FixAccount(int id, double balance, double annualInterestRate, String name, String surname) {
        super(id, balance, annualInterestRate, name, surname);
    }

    @Override
    public void transferMoney(Account acc1, double amount) {
        System.out.println("Cannot transfer from a Fixed Account!");
    }
}

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1 = Add new account, 2 = Transfer money, 3 = Exit");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter an account ID: ");
                int id = input.nextInt();
                System.out.print("Enter a balance: ");
                double balance = input.nextDouble();
                System.out.print("Enter an annual interest rate: ");
                double annualInterestRate = input.nextDouble();
                input.nextLine(); // Consume the newline character

                System.out.print("Enter your name: ");
                String name = input.nextLine();
                System.out.print("Enter your surname: ");
                String surname = input.nextLine();

                System.out.print("Enter the number of years the account has been open: ");
                double yearsOpenAcc = input.nextDouble();

                Account account = new Account(id, balance, annualInterestRate, name, surname);

                System.out.print("Enter the amount to deposit: ");
                double depositAmount = input.nextDouble();
                account.deposit(depositAmount);

                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = input.nextDouble();
                account.withdraw(withdrawAmount);

                System.out.println(account.toString());

                // Example of transferring money between accounts
                System.out.println("\nTransferring money between accounts:");
                System.out.print("Enter target account ID: ");
                int targetId = input.nextInt();
                System.out.print("Enter transfer amount: ");
                double transferAmount = input.nextDouble();

                Account targetAccount = new Account(targetId, 0, 0, "", "");
                account.transferMoney(targetAccount, transferAmount);

                System.out.println("Updated account information:");
                System.out.println(account.toString());
                System.out.println(targetAccount.toString());
            } else if (choice == 2) {
                // โอนเงิน
                System.out.print("Enter the source account ID: ");
                int sourceId = input.nextInt();
                System.out.print("Enter the destination account ID: ");
                int destId = input.nextInt();
                System.out.print("Enter the amount to transfer: ");
                double transferAmount = input.nextDouble();

                Account sourceAccount = new Account(sourceId, 0, 0, "", "");
                Account destAccount = new Account(destId, 0, 0, "", "");

                sourceAccount.transferMoney(destAccount, transferAmount);

                System.out.println("Transfer complete.");
            } else if (choice == 3) {
                exit = true;
                System.out.println("Exiting the program.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}