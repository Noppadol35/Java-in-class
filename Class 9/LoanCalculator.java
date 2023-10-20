import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Date;

public class LoanCalculator extends JFrame {

    private JTextField jtfAnnualInterestRate = new JTextField();
    private JTextField jtfNumberOfYears = new JTextField();
    private JTextField jtfLoanAmount = new JTextField();
    private JTextField jtfMonthlyPayment = new JTextField();
    private JTextField jtfTotalPayment = new JTextField();
    private JButton jbtComputeLoan = new JButton("Compute Payment");

    public LoanCalculator() {
        JPanel p1 = new JPanel(new GridLayout(5, 2));
        p1.add(new JLabel("Annual Interest Rate"));
        p1.add(jtfAnnualInterestRate);
        p1.add(new JLabel("Number of Years"));
        p1.add(jtfNumberOfYears);
        p1.add(new JLabel("Loan Amount"));
        p1.add(jtfLoanAmount);
        p1.add(new JLabel("Monthly Payment"));
        p1.add(jtfMonthlyPayment);
        p1.add(new JLabel("Total Payment"));
        p1.add(jtfTotalPayment);
        p1.setBorder(new TitledBorder("Enter loan amount, interest rate, and years"));

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(jbtComputeLoan);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        jbtComputeLoan.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double interest = Double.parseDouble(jtfAnnualInterestRate.getText());
            int year = Integer.parseInt(jtfNumberOfYears.getText());
            double loanAmount = Double.parseDouble(jtfLoanAmount.getText());

            Loan loan = new Loan(interest, year, loanAmount);

            jtfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
            jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
        }
    }

    public static void main(String[] args) {
        LoanCalculator frame = new LoanCalculator();
        frame.pack();
        frame.setTitle("LoanCalculator");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class Loan {
        private double annualInterestRate;
        private int numberOfYears;
        private double loanAmount;
        private Date loanDate;

        public Loan() {
            this(2.5, 1, 1000);
        }

        public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
            this.annualInterestRate = annualInterestRate;
            this.numberOfYears = numberOfYears;
            this.loanAmount = loanAmount;
            loanDate = new Date();
        }

        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        public int getNumberOfYears() {
            return numberOfYears;
        }

        public void setNumberOfYears(int numberOfYears) {
            this.numberOfYears = numberOfYears;
        }

        public double getMonthlyPayment() {
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                    (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
            return monthlyPayment;
        }

        public double getTotalPayment() {
            double totalPayment = getMonthlyPayment() * numberOfYears * 12;
            return totalPayment;
        }

    }
}
