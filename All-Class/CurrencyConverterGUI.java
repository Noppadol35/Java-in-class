import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CurrencyConverterGUI extends JFrame {

    private JTextField usdTextField;
    private JTextField cadTextField;
    private JButton convertButton;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // ใช้ GridLayout 3x2 สำหรับจัดวาง Label และ TextField

        JLabel usdLabel = new JLabel("Enter USD:");
        usdTextField = new JTextField(10);
        JLabel cadLabel = new JLabel("CAD:");
        cadTextField = new JTextField(10);

        // เพิ่ม Label และ TextField ลงใน Panel
        panel.add(usdLabel);
        panel.add(usdTextField);
        panel.add(cadLabel);
        
        resultLabel = new JLabel();
        panel.add(resultLabel);
        panel.add(new JLabel("")); // ช่องว่าง

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // เพิ่มปุ่ม Convert ลงใน Panel ด้านล่าง
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(convertButton);
        panel.add(buttonPanel);

        add(panel);
        pack();
        setLocationRelativeTo(null); // จัดตำแหน่งให้อยู่ตรงกลางของหน้าต่าง
    }

    private void convertCurrency() {
        try {
            double usdAmount = Double.parseDouble(usdTextField.getText());
            double exchangeRate = 1.35; // แทนที่ด้วยอัตราแลกเปลี่ยนจริง
            double cadAmount = usdAmount * exchangeRate;

            DecimalFormat df = new DecimalFormat("#.##");
            resultLabel.setText("" + df.format(cadAmount)); // แสดง "CAD" ชิดซ้ายของผลลัพธ์
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverterGUI().setVisible(true);
            }
        });
    }
}
