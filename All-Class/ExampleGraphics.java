// import java.awt.Graphics;
// import javax.swing.*;

// public class ExampleGraphics extends JFarme {
//     ExampleGraphics(){
//         add(new DrawArea());
//     }

//     class DrawArea extends JPanel{
//         URL imageURL = this.getClass().getResouce("");
//         Image image = new ImageIcon(imageURL).getImage();
//         @Override
//         public void paintComponent(Graphics g){
//             super.paintComponent(g);
//             g.drawImage(image, 0, 0, 1200, 1200);
//             g.drawImage(imageBoat, 0, getHeight()/2, 100, 100);
//         }
//     }
//     public static void main(String[] args) {
//         ExampleGraphics frame = new ExampleGraphics();
//         frame.setTitle("ExampleGraphics");
//         frame.setSize(1200, 700);
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }
// }


