class Circle {
    private double radius;

    public Circle(double radius) {
        // radius = radius; ผิดเพราะ ต้อง้ใช้ this เเพื่อให้โปรแกรมรู้ว่าเป็นตัวแปรภายใน class นี้
        this.radius = radius; 
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        return radius * radius * Math.PI;
    }
}

class Cylinder extends Circle {
    private double length;

    Cylinder(double radius, double length) {
        // Circle(radius); ผิดเพราะ เราจะเรียกใช้ constructor ใน class(แม่) ต้องใช้ super ใน class(ลูก)
        super(radius);
        // length = length; ผิดเพราะ ต้อง้ใช้ this เเพื่อให้โปรแกรมรู้ว่าเป็นตัวแปรภายใน class นี้
        this.length = length;
    }
}

public class Test2 {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(2.0, 3.0);
    }
}
