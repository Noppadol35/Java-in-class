import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockAnimation extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public ClockAnimation() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClock(g);
    }

    private void drawClock(Graphics g) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        // Get the current time
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeStr = sdf.format(now);

        // Draw clock face
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, WIDTH, HEIGHT);

        // Draw hour hand
        int hours = now.getHours() % 12;
        double hourAngle = Math.toRadians((hours - 3) * 30);
        int hourHandLength = 70;
        int hourX = (int) (centerX + hourHandLength * Math.cos(hourAngle));
        int hourY = (int) (centerY + hourHandLength * Math.sin(hourAngle));
        g.setColor(Color.BLACK);
        g.drawLine(centerX, centerY, hourX, hourY);

        // Draw minute hand
        int minutes = now.getMinutes();
        double minuteAngle = Math.toRadians((minutes - 15) * 6);
        int minuteHandLength = 100;
        int minuteX = (int) (centerX + minuteHandLength * Math.cos(minuteAngle));
        int minuteY = (int) (centerY + minuteHandLength * Math.sin(minuteAngle));
        g.setColor(Color.BLUE);
        g.drawLine(centerX, centerY, minuteX, minuteY);

        // Draw second hand
        int seconds = now.getSeconds();
        double secondAngle = Math.toRadians((seconds - 15) * 6);
        int secondHandLength = 150;
        int secondX = (int) (centerX + secondHandLength * Math.cos(secondAngle));
        int secondY = (int) (centerY + secondHandLength * Math.sin(secondAngle));
        g.setColor(Color.RED);
        g.drawLine(centerX, centerY, secondX, secondY);

        // Display the current time
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(timeStr, 160, 380);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock Animation");
        ClockAnimation clock = new ClockAnimation();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(clock);
        frame.pack();
        frame.setVisible(true);

        // using thread to move the clock
        Thread clockThread = new Thread(() -> {
            while (true) {
                clock.repaint(); // Redraw the clock
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        clockThread.start();
    }
}
