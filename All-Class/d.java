import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1 = Add new account, 2 = Transfer money, 3 = Exit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an account ID: ");
                    int id = input.nextInt();
                    System.out.print("Enter a balance: ");
                    double balance = input.nextDouble();
                    System.out.print("Enter an annual interest rate: ");
                    double annualInterestRate = input.nextDouble();

                    System.out.print("Select account type (1 = Savings, 2 = Fixed): ");
                    int accountType = input.nextInt();

                    if (accountType == 1) {
                        Account account = new SavingAccount(id, balance, annualInterestRate, null, null);
                        System.out.println("Account ID: " + account.getId());
                        System.out.println("Balance: $" + account.getBalance());
                        System.out.println("Annual Interest Rate: " + account.getAnnualInterestRate() + "%");
                        System.out.println("Years Open: " + account.getYearsOpenAcc() + " years");
                        System.out.println("Monthly Interest Rate: " + account.getAnnualInterestRate() + "%");
                        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
                    } else if (accountType == 2) {
                        Account account = new FixAccount(id, balance, annualInterestRate, null, null);
                        System.out.println("Account ID: " + account.getId());
                        System.out.println("Balance: $" + account.getBalance());
                        System.out.println("Annual Interest Rate: " + account.getAnnualInterestRate() + "%");
                        System.out.println("Years Open: " + account.getYearsOpenAcc() + " years");
                        System.out.println("Monthly Interest Rate: " + account.getAnnualInterestRate() + "%");
                        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
                    } else {
                        System.out.println("Invalid account type.");
                    }
                    break;

                case 2:
                    // โอนเงิน
                    System.out.print("Enter the source account ID: ");
                    int sourceId = input.nextInt();
                    System.out.print("Enter the destination account ID: ");
                    int destId = input.nextInt();
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = input.nextDouble();

                    // สร้างบัญชีและโอนเงิน
                    Account sourceAccount = new Account(sourceId, 0, 0, null, null);
                    Account destAccount = new Account(destId, 0, 0, null, null);

                    sourceAccount.withdraw(transferAmount);
                    destAccount.deposit(transferAmount);

                    System.out.println("Transfer complete.");
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
