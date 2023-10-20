import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AngryBirds extends JFrame {
    private JLabel lblScore = new JLabel("SCORE: 0");
    private JTextField jtfYPosition = new JTextField(10);
    private JTextField jtfVelocity = new JTextField(10);
    private JTextField jtfAngle = new JTextField(10);
    private JButton btnOk = new JButton("OK");
    private int score = 0;

    private Point birdPosition;
    private Point pigPosition;
    private final int BIRD_RADIUS = 20;
    private final int PIG_RADIUS = 20;

    private Point initialBirdPosition;
    private Point finalBirdPosition;

    Timer timer;
    int animationDuration = 2000;
    long animationStartTime;

    public AngryBirds() {
        setTitle("AngryBirds");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("SCENE 1 : At Tokyo"), BorderLayout.WEST);
        topPanel.add(lblScore, BorderLayout.EAST);

        JPanel gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED); // Set bird color
                if (birdPosition != null)
                    g.fillOval(birdPosition.x - BIRD_RADIUS, birdPosition.y - BIRD_RADIUS, BIRD_RADIUS * 2,
                            BIRD_RADIUS * 2);

                g.setColor(Color.GREEN); // Set pig color
                if (pigPosition != null) // Check if pigPosition is not null before drawing
                    g.fillOval(pigPosition.x - PIG_RADIUS, pigPosition.y - PIG_RADIUS, PIG_RADIUS * 2, PIG_RADIUS * 2);
            }
        };
        gamePanel.setPreferredSize(new Dimension(400, 300));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gamePanel.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Bird Position in y-axis
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Bird Position in y-axis"), gbc);
        gbc.gridx = 1;
        inputPanel.add(jtfYPosition, gbc);
        gbc.gridx = 2;
        inputPanel.add(new JLabel("m"), gbc);

        // Shooting speed
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Shooting speed"), gbc);
        gbc.gridx = 1;
        inputPanel.add(jtfVelocity, gbc);
        gbc.gridx = 2;
        inputPanel.add(new JLabel("m/s"), gbc);

        // Angle
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Angle"), gbc);
        gbc.gridx = 1;
        inputPanel.add(jtfAngle, gbc);
        gbc.gridx = 2;
        inputPanel.add(new JLabel("degree"), gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnOk);

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - animationStartTime;

                if (elapsedTime < animationDuration) {
                    double ratio = (double) elapsedTime / animationDuration;
                    birdPosition.x = initialBirdPosition.x
                            + (int) ((finalBirdPosition.x - initialBirdPosition.x) * ratio);
                    birdPosition.y = initialBirdPosition.y
                            + (int) ((finalBirdPosition.y - initialBirdPosition.y) * ratio);

                    // Check if bird hits the pig during the animation
                    if (pigPosition != null && birdPosition.distance(pigPosition) <= PIG_RADIUS + BIRD_RADIUS) {
                        score += 100;
                        lblScore.setText("SCORE: " + score);
                        pigPosition = null; // Set pigPosition to null to "remove" the pig
                        timer.stop(); // Stop the timer once the bird hits the pig
                    }
                    gamePanel.repaint();
                } else {
                    birdPosition = new Point(finalBirdPosition.x, finalBirdPosition.y);
                    gamePanel.repaint();
                    timer.stop();
                }
            }
        });
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                if (jtfYPosition.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter bird's y position!");
                    return;
                }

                // Set the initial position
                initialBirdPosition = new Point(10, 300 - Integer.parseInt(jtfYPosition.getText()));
                pigPosition = new Point(rand.nextInt(400 - 2 * PIG_RADIUS) + PIG_RADIUS,
                        rand.nextInt(300 - 2 * PIG_RADIUS) + PIG_RADIUS);
                birdPosition = new Point(initialBirdPosition.x, initialBirdPosition.y);

                // Calculate the final position
                finalBirdPosition = calculateBirdFinalPosition();
                animationStartTime = System.currentTimeMillis();
                timer.start();
            }
        });
        JPanel combinedPanel = new JPanel(new BorderLayout());
        combinedPanel.add(gamePanel, BorderLayout.CENTER);
        combinedPanel.add(inputPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(combinedPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);

    }

    private Point calculateBirdFinalPosition() {
        double velocity = Double.parseDouble(jtfVelocity.getText());
        double angleInDegrees = Double.parseDouble(jtfAngle.getText());

        double angleInRadians = Math.toRadians(angleInDegrees);

        double determinant = Math.sqrt(25 + 80);
        double t = (5 + determinant) / 2;

        double x = velocity * Math.cos(angleInRadians) * t;
        double y = velocity * Math.sin(angleInRadians) * t - 0.5 * 10 * t * t;

        System.out.println("Calculated bird position: x = " + (int) x + ", y = " + (int) y);

        return new Point((int) x, (int) y);
    }

    public static void main(String[] args) {
        AngryBirds frame = new AngryBirds();
        frame.setVisible(true);
    }
}
