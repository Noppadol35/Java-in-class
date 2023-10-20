import java.awt.*;
import javax.swing.*;

abstract class AbstractDrawFunction extends JPanel {
    /** Polygon to hold the points */
    private Polygon p = new Polygon();

    /** Default constructor */
    protected AbstractDrawFunction() {
        drawFunction();
        setBackground(Color.white);
    }

    /** Draw the function */
    public abstract double f(double x);

    /** Obtain points for x coordinates 100, 101, ..., 300 */
    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int) f(x));
        }
    }

    /** Paint the function diagram */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw x axis
        g.drawLine(10, 200, 390, 200);
        // Draw y axis
        g.drawLine(200, 30, 200, 390);
        // Draw arrows on x axis
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
        // Draw arrows on y axis
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
        // Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
        // Draw a polygon line by connecting the points in the polygon
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}

class A extends AbstractDrawFunction {

    //cjange background color
    A() {
        setBackground(Color.yellow);
    }

    @Override
    public double f(double x) {
        return x * x;
    }
}

class B extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100 * Math.sin(x);
    }
}

class C extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100 * Math.cos(x);
    }
}

class D extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100 * Math.tan(x);
    }
}

class E extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100 * (Math.cos(x) + (5 * Math.sin(x)));
    }
}

class F extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100 * (Math.sin(x) + (5 * Math.cos(x)));
    }
}

class G extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.log(x) + (x * x);
    }
}

public class C8_lab3 extends JFrame {
    C8_lab3() {

        getContentPane().setLayout(new GridLayout(2, 4, 5, 5));
        getContentPane().add(new A());
        getContentPane().add(new B());
        getContentPane().add(new C());
        getContentPane().add(new D());
        getContentPane().add(new E());
        getContentPane().add(new F());
        getContentPane().add(new G());
    }

    public static void main(String[] args) {
        C8_lab3 frame = new C8_lab3();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
}
