import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class ClockAnimation extends JFrame {
    private StillClock thaiClock = new StillClock();
    private StillClock japanClock = new StillClock();

    public ClockAnimation() {
        JPanel clockPanel = new JPanel();
        clockPanel.setLayout(new GridLayout(1, 2));

        clockPanel.add(thaiClock);
        clockPanel.add(japanClock);

        add(clockPanel);

        // Create a timer with delay 1000 ms
        Timer timer = new Timer(1000, new TimerListener());
        timer.start();

        // Create radio buttons USA, Singapore, UK for country selection
        JRadioButton usaRadioButton = new JRadioButton("USA");
        JRadioButton singaporeRadioButton = new JRadioButton("Singapore");
        JRadioButton ukRadioButton = new JRadioButton("UK");

        // Create a button group to ensure only one radio button is selected at a time
        ButtonGroup countryButtonGroup = new ButtonGroup();
        countryButtonGroup.add(usaRadioButton);
        countryButtonGroup.add(singaporeRadioButton);
        countryButtonGroup.add(ukRadioButton);

        // Create a panel for the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(usaRadioButton);
        radioPanel.add(singaporeRadioButton);
        radioPanel.add(ukRadioButton);

        // Add the radio panel to the main frame
        add(radioPanel, BorderLayout.SOUTH);

        usaRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle USA radio button selection here
                Calendar usaCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
                japanClock.setHour(usaCalendar.get(Calendar.HOUR_OF_DAY));
                japanClock.setMinute(usaCalendar.get(Calendar.MINUTE));
                // สามารถเพิ่มการตั้งค่านาทีหรือวินาทีในปุ่ม USA ตามต้องการได้
                japanClock.repaint(); // ต้องการให้นาฬิกาใหม่แสดงเวลาที่ถูกตั้งค่า
            }
        });
        
        singaporeRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Singapore radio button selection here
                Calendar singaporeCalendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore"));
                japanClock.setHour(singaporeCalendar.get(Calendar.HOUR_OF_DAY));
                japanClock.setMinute(singaporeCalendar.get(Calendar.MINUTE));
                // สามารถเพิ่มการตั้งค่านาทีหรือวินาทีในปุ่ม Singapore ตามต้องการได้
                japanClock.repaint(); // ต้องการให้นาฬิกาใหม่แสดงเวลาที่ถูกตั้งค่า
            }
        });
        
        ukRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle UK radio button selection here
                Calendar ukCalendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
                japanClock.setHour(ukCalendar.get(Calendar.HOUR_OF_DAY));
                japanClock.setMinute(ukCalendar.get(Calendar.MINUTE));
                // สามารถเพิ่มการตั้งค่านาทีหรือวินาทีในปุ่ม UK ตามต้องการได้
                japanClock.repaint(); // ต้องการให้นาฬิกาใหม่แสดงเวลาที่ถูกตั้งค่า
            }
        });
        
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Set new time for Thai clock (GMT+7) and repaint
            Calendar thaiCalendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Bangkok"));
            thaiClock.setHour(thaiCalendar.get(Calendar.HOUR_OF_DAY));
            thaiClock.setMinute(thaiCalendar.get(Calendar.MINUTE));
            thaiClock.setSecond(thaiCalendar.get(Calendar.SECOND));
            thaiClock.repaint();

            // Determine which country is selected and set the time accordingly
            if (usaRadioButton.isSelected()) {
                Calendar usaCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
                japanClock.setHour(usaCalendar.get(Calendar.HOUR_OF_DAY));
                japanClock.setMinute(usaCalendar.get(Calendar.MINUTE));
            } else if (singaporeRadioButton.isSelected()) {
                Calendar singaporeCalendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore"));
                japanClock.setHour(singaporeCalendar.get(Calendar.HOUR_OF_DAY));
                japanClock.setMinute(singaporeCalendar.get(Calendar.MINUTE));
            } else if (ukRadioButton.isSelected()) {
                Calendar ukCalendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
                japanClock.setHour(ukCalendar.get(Calendar.HOUR_OF_DAY));
                japanClock.setMinute(ukCalendar.get(Calendar.MINUTE));
            }

            // Set the second and repaint
            Calendar japanCalendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
            japanClock.setSecond(japanCalendar.get(Calendar.SECOND));
            japanClock.repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ClockAnimation();
        frame.setTitle("Dual Clocks");
        frame.setSize(400, 200); // Make the frame wider to accommodate both clocks
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class StillClock extends JPanel {
    private int hour;
    private int minute;
    private int second;

    public StillClock() {
        setCurrentTime();
    }

    public StillClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        repaint();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        repaint();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        repaint();
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.paintComponent(g);
        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.black);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        // Draw minute hand
        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength *
                Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength *
                Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.BLUE);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        // Draw hour hand
        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}