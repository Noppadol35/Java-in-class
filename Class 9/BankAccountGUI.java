import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BankAccountGUI extends JFrame {
    private List<Account> accounts = new ArrayList<>();
    private JTextField idField, moneyField, firstNameField, lastNameField, ageField;
    private JTextField annualInterestRateField, dayOpenField, birthDayField;

    public BankAccountGUI() {
        setTitle("Bank Account System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel moneyLabel = new JLabel("Money (Baht):");
        moneyField = new JTextField();
        JLabel annualInterestRateLabel = new JLabel("Annual Interest Rate:");
        annualInterestRateField = new JTextField();
        JLabel dayOpenLabel = new JLabel("Day Open Account:");
        dayOpenField = new JTextField();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        JLabel birthDayLabel = new JLabel("Birth Day:");
        birthDayField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JButton saveButton = new JButton("Save");
        JButton displayButton = new JButton("Display");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAccount();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAccounts();
            }
        });

        add(idLabel);
        add(idField);
        add(moneyLabel);
        add(moneyField);
        add(annualInterestRateLabel);
        add(annualInterestRateField);
        add(dayOpenLabel);
        add(dayOpenField);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(birthDayLabel);
        add(birthDayField);
        add(ageLabel);
        add(ageField);
        add(saveButton);
        add(displayButton);

        pack();
    }

    private void saveAccount() {
        try {
            int id = Integer.parseInt(idField.getText());
            double money = Double.parseDouble(moneyField.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateField.getText());
            String dayOpen = dayOpenField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String birthDay = birthDayField.getText();
            int age = Integer.parseInt(ageField.getText());

            Account account = new Account(id, money, annualInterestRate, dayOpen, firstName, lastName, birthDay, age);
            accounts.add(account);

            clearFields();
            JOptionPane.showMessageDialog(this, "Account saved successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid data.");
        }
    }

    private void clearFields() {
        idField.setText("");
        moneyField.setText("");
        annualInterestRateField.setText("");
        dayOpenField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        birthDayField.setText("");
        ageField.setText("");
    }

    private void displayAccounts() {
        StringBuilder accountsInfo = new StringBuilder("Bank Accounts:\n");

        for (Account account : accounts) {
            accountsInfo.append(account.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, accountsInfo.toString());
    }

    public static void main(String[] args) {
        BankAccountGUI bankAccountGUI = new BankAccountGUI();
        bankAccountGUI.setVisible(true);
    }
}

class Account {
    private int id;
    private double money;
    private double annualInterestRate;
    private String dayOpen;
    private String firstName;
    private String lastName;
    private String birthDay;
    private int age;

    public Account(int id, double money, double annualInterestRate, String dayOpen, String firstName, String lastName, String birthDay, int age) {
        this.id = id;
        this.money = money;
        this.annualInterestRate = annualInterestRate;
        this.dayOpen = dayOpen;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Money: " + money + " Baht, Annual Interest Rate: " + annualInterestRate
                + ", Day Open Account: " + dayOpen + ", First Name: " + firstName + ", Last Name: " + lastName
                + ", Birth Day: " + birthDay + ", Age: " + age + " years";
    }
}
