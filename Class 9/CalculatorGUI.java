import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JButton[] buttons;

    private double currentNumber;
    private String currentOperator;
    private boolean newNumberInput;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[16];

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(new ButtonListener());
        }

        buttons[0].setText("7");
        buttons[1].setText("8");
        buttons[2].setText("9");
        buttons[3].setText("C");
        buttons[4].setText("4");
        buttons[5].setText("5");
        buttons[6].setText("6");
        buttons[7].setText("x");
        buttons[8].setText("1");
        buttons[9].setText("2");
        buttons[10].setText("3");
        buttons[11].setText("+");
        buttons[12].setText("-");
        buttons[13].setText("0");
        buttons[14].setText("+/-");
        buttons[15].setText("=");

        for (int i = 0; i < 16; i++) {
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        currentNumber = 0;
        currentOperator = "";
        newNumberInput = true;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            if (isNumeric(buttonText)) {
                if (newNumberInput) {
                    display.setText(buttonText);
                    newNumberInput = false;
                } else {
                    display.setText(display.getText() + buttonText);
                }
            } else if (buttonText.equals(".")) {
                if (newNumberInput) {
                    display.setText("0.");
                    newNumberInput = false;
                } else if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            } else if (buttonText.equals("C")) {
                currentNumber = 0;
                currentOperator = "";
                display.setText("");
                newNumberInput = true;
            } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("X") || buttonText.equals("/")) {
                if (!newNumberInput) {
                    if (!currentOperator.isEmpty()) {
                        calculate();
                    }
                    currentOperator = buttonText;
                    currentNumber = Double.parseDouble(display.getText());
                    newNumberInput = true;
                }
            } else if (buttonText.equals("=")) {
                if (!newNumberInput && !currentOperator.isEmpty()) {
                    calculate();
                    currentOperator = "";
                    newNumberInput = true;
                }
            }
        }

        private void calculate() {
            double newNumber = Double.parseDouble(display.getText());
            switch (currentOperator) {
                case "+":
                    currentNumber += newNumber;
                    break;
                case "-":
                    currentNumber -= newNumber;
                    break;
                case "X":
                    currentNumber *= newNumber;
                    break;
                case "/":
                    if (newNumber != 0) {
                        currentNumber /= newNumber;
                    } else {
                        display.setText("Error");
                        currentOperator = "";
                        newNumberInput = true;
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(currentNumber));
        }

        private boolean isNumeric(String str) {
            return str.matches("-?\\d+(\\.\\d+)?");
        }
    }

    public static void main(String[] args) {
        CalculatorGUI calculator = new CalculatorGUI();
        calculator.pack();
        calculator.setVisible(true);
    }
}
