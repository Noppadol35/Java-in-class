import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanGameGUI extends JFrame {

    HangmanGameGUI() {
        add(new DrawArea());
    }

    int x = 0;
    int y =0;
    int a;

    class DrawArea extends JPanel {

        Timer timer = new Timer(20, (ActionListener) new Listener());

        DrawArea() {
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
            g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100 + x, 40);
            g.setColor(Color.RED);
            int radius = 20;
            g.drawOval(20 + 40 + 100 - radius + x, 40, 2 * radius, 2 * radius);

            if (130 - x == 100 || 160+ y == 120){
                a = 1;
            }
            if (130 - x == 150 || 160 + y == 200){
                a = 0;
            }
            g.drawLine(20 + 40 + 100 - (int) (radius *
            Math.cos(Math.toRadians(45)))+x,
            40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
            20 + 40 + 100 - 60+x+y, 40 + radius + 60);
            g.drawLine(20 + 40 + 100 + (int) (radius *
            Math.cos(Math.toRadians(45)))+x,
            40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
            20 + 40 + 100 + 60+x+y, 40 + radius + 60);
            g.drawLine(20 + 40 + 100+x, 40 + 2 * radius,
            20 + 40 + 100+x+y, 40 + radius + 80);
            g.drawLine(20 + 40 + 100+x+y, 40 + radius + 80, 20 + 40 + 100 - 40+x+x+y+y,
            40 + radius + 80 + 40);
            g.drawLine(20 + 40 + 100+x+y, 40 + radius + 80, 20 + 40 + 100 + 40+x+x+y+y,
            40 + radius + 80 + 40);
            if (a == 0){
                x++;
                y++;
            }
            else{
                x--;
                y--;
            }

        }

        class Listener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();

            }
        }
    }

    public static void main(String[] args) throws Exception {
        HangmanGameGUI frame = new HangmanGameGUI();
        frame.setTitle("Example");
        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ปิดหน้าต่างแล้วจบการทำงานของโปรแกรม
        frame.setVisible(true);
    }
}
