import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIExample extends JFrame {
    JLabel JlbName = new JLabel("Name");
    JLabel JlbSurname = new JLabel("Surname");
    JLabel JlbAge = new JLabel("Age");
    JTextField JtfName = new JTextField(10);
    JTextField JtfSurname = new JTextField(10);
    JTextField JtfAge = new JTextField(10);
    JButton JbtOK = new JButton("Ok");
    JButton JbtCancel = new JButton("Cancel"); // Corrected the typo "Cancle" to "Cancel"
    JLabel JlbInfomation = new JLabel();

    JPanel p = new JPanel();

    GUIExample() {
        p.setLayout(new GridLayout(4, 2, 5,2)); // Used "new GridLayout()" to create the layout
        p.add(JlbName);
        p.add(JtfName);
        p.add(JlbSurname);
        p.add(JlbAge);
        p.add(JtfSurname);
        p.add(JtfAge);
        p.add(JlbInfomation);
        p.add(JbtOK);
        p.add(JbtCancel);
        add(p);

        Listener spyObj = new Listener();
        JbtOK.addActionListener(spyObj);
        JbtCancel.addActionListener(spyObj);
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand() == "Ok"){
                JlbInfomation.setText(JtfName.getText() + JtfSurname.getText() + "");
            }
            else{
                JtfName.setText("");
                JtfSurname.setText("");
                JtfAge.setText("");
                JlbInfomation.setText("");
            }
            
        }
    }

    public static void main(String[] args) {
        GUIExample frame = new GUIExample();
        frame.setTitle("Example"); // Corrected the typo "Exmaple" to "Example"
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Corrected the typo "JFarme.EXIT_ON_" to "JFrame.EXIT_ON_CLOSE"
        frame.setVisible(true);
    }
}
