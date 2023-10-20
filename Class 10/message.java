import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class message extends JFrame {

    private StillClock clockThailand;
    private StillClock clockJapan;
    private StillClock clockUSA;
    private JTextField countryInput;
    private JButton okButton;
    private JPanel clockPanel;

    public message() {
        clockThailand = new StillClock("Thailand (UTC+7)");
        clockJapan = new StillClock("Japan (UTC+9)");
        clockUSA = new StillClock("US (UTC-5)");
        clockUSA.setVisible(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel inputLabel = new JLabel("Input Country");
        countryInput = new JTextField(10);
        okButton = new JButton("OK");

        inputPanel.add(inputLabel);
        inputPanel.add(countryInput);
        inputPanel.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String country = countryInput.getText();
                if (country.equalsIgnoreCase("Thailand")) {
                    clockThailand.setCurrentTimeThailand();
                    clockThailand.setCountryName("Thailand (UTC+7)");
                    clockThailand.repaint();
                    clockThailand.validate();

                    clockJapan.setCountryName("Japan (UTC+9)");
                    clockJapan.repaint();
                    clockJapan.validate();

                    clockUSA.setVisible(false);
                } else if (country.equalsIgnoreCase("Japan")) {
                    if (clockUSA.getParent() != null) {
                        clockPanel.remove(clockUSA);
                    }
                    clockPanel.add(clockJapan);
                    clockJapan.setCurrentTimeJapan();
                    clockJapan.setCountryName("Japan (UTC+9)");
                    clockJapan.repaint();
                    clockJapan.validate();

                    clockThailand.setCountryName("Thailand (UTC+7)");
                    clockThailand.repaint();
                    clockThailand.validate();

                    clockUSA.setVisible(false);
                } else if (country.equalsIgnoreCase("US")) {
                    if (clockJapan.getParent() != null) {
                        clockPanel.remove(clockJapan);
                    }
                    clockPanel.add(clockUSA);
                    clockUSA.setCurrentTimeUSA();
                    clockUSA.setCountryName("US (UTC-5)");
                    clockUSA.repaint();

                    clockThailand.setCountryName("US (UTC-5)");
                    clockThailand.repaint();

                    clockUSA.setVisible(true);
                }
            }
        });

        inputPanel.add(countryInput);
        inputPanel.add(okButton);

        clockPanel = new JPanel();
        clockPanel.setLayout(new GridLayout(1, 2));

        clockPanel.add(clockThailand);
        clockPanel.add(clockJapan);

        add(clockPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        Timer timer = new Timer(1000, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clockThailand.setCurrentTimeThailand();
            if (clockJapan.getParent() != null) {
                clockJapan.setCurrentTimeJapan();
            } else if (clockUSA.getParent() != null) {
                clockUSA.setCurrentTimeUSA();
            }
            clockThailand.repaint();
            clockJapan.repaint();
            clockUSA.repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new message();
        frame.setTitle("message");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class StillClock extends JPanel {

    private int hour;
    private int minute;
    private int second;
    private String countryName;
    private JLabel label;

    public StillClock(String countryName) {
        this.countryName = countryName;
        this.label = new JLabel(countryName, SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.NORTH);
        setCurrentTime();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        repaint();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        repaint();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Draw circle
        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        // Draw second hand
        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        // Draw minute hand
        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        // Draw hour hand
        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.green);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    public void setCurrentTimeThailand() {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Bangkok"));
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        repaint();
    }

    public void setCurrentTimeJapan() {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo"));
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        repaint();
    }

    public void setCurrentTimeUSA() {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("America/New_York"));
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        repaint();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}

// 2.1
// StillClock คือคลาสที่ใช้ในการสร้างแสดงนาฬิกาแบบเข็ม โดยมีการสร้างเข็มชั่วโมง
// (สีเขียว), เข็มนาที (สีน้ำเงิน), และเข็มวินาที (สีแดง) ซึ่งถูกวาดบน JPanel.
// StillClock มีเมทอด setCurrentTime() ที่ใช้ในการตั้งค่าเวลาปัจจุบันจาก
// Calendar, และมีเมทอด setCurrentTimeThailand(), setCurrentTimeJapan(), และ
// setCurrentTimeUSA() ที่ใช้ในการตั้งค่าเวลาสำหรับแต่ละประเทศตาม TimeZone
// ที่กำหนด. และมีเมทอด setCountryName() เพื่อกำหนดชื่อประเทศที่แสดง และ
// getCountryName() เพื่อรับชื่อประเทศ.

// ในคลาส message, มีการสร้างหน้าต่าง Swing ที่มีสาม StillClock สำหรับประเทศ
// Thailand, Japan, และ USA ซึ่งถูกนำมาแสดงบน JPanel
// และสามารถเลือกแสดงนาฬิกาของประเทศใดที่ต้องการผ่านการป้อนชื่อประเทศใน
// JTextField และคลิกปุ่ม OK.

// โปรแกรมใช้ Timer ในการทำงานแบบเป็นรอบ เพื่ออัปเดตเวลาทุกวินาที
// และปรับปรุงการแสดงผลบนนาฬิกา.

// การสร้างเข็มนาฬิกาใน StillClock:

// สร้างวงกลมขอบนาฬิกาด้วย drawOval.
// วาดตัวเลข 12, 3, 6, 9 ที่ตำแหน่งที่เหมาะสม.
// สร้างเข็มวินาที, เข็มนาที, และเข็มชั่วโมง
// โดยคำนวณตำแหน่งและความยาวของเข็มในแต่ละรอบของ Timer.
// สีของเข็มแต่ละอันถูกกำหนดโดยใช้ setColor.
// วาดเข็มด้วย drawLine.
// เวลาปัจจุบันจะถูกสร้างขึ้นโดยใช้ Calendar และเข็มจะถูกวาดตามเวลาปัจจุบัน.

// 2.2
// สร้าง Timer โดยระบุค่าที่ต้องการ เช่น 1000 มิลลิวินาที (หรือ 1 วินาที)
// ในคุณสมบัติ int delay. โดยที่ delay คือช่วงเวลา (ในมิลลิวินาที) ที่ Timer
// จะรอระหว่างการเรียกเหตุการณ์.

// สร้าง ActionListener ที่เป็นตัวจัดการเหตุการณ์ที่จะทำงานทุกครั้งเมื่อ Timer
// ทำงาน. ในตัวอย่าง TimerListener ถูกใช้เพื่ออัปเดตเวลาของ StillClock และเรียก
// repaint() เพื่อวาดนาฬิกาใหม่ทุกครั้งที่ Timer ทำงาน.

// สร้าง Timer ด้วย delay และ ActionListener ที่ได้สร้าง.

// ในเมทอด actionPerformed ของ ActionListener ในตัวอย่าง TimerListener,
// นำเอาความสมบูรณ์จากหน้าต่างนาฬิกาของแต่ละประเทศ และใช้เมทอด setCurrentTime
// หรือ setCurrentTime<ชื่อประเทศ>() เพื่ออัปเดตเวลาของนาฬิกาแต่ละอัน. สุดท้าย,
// เรียก repaint() เพื่อวาดนาฬิกาใหม่.

// เริ่ม Timer โดยใช้ start() เพื่อเริ่มเหตุการณ์จับเวลาและทำให้นาฬิกาเดิน.

// ขั้นตอนนี้จะทำให้ Timer เริ่มทำงานทุกครั้งที่มาถึง delay ที่กำหนดไว้
// และเหตุการณ์จับเวลานี้จะทำงานและอัปเดตเวลาของนาฬิกาในทุกๆ วินาที.