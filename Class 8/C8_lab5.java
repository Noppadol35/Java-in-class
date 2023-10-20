abstract class GeometricObject {
    private String color = "white";
    private boolean filled;

    protected GeometricObject() {
    }

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

abstract class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            return this.getArea() == ((Circle) o).getArea();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Circle o) {
        if (this.getArea() == o.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}

abstract class Rectangle extends GeometricObject implements Comparable {
    private double width;
    private double height;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            return this.getArea() == ((Rectangle) o).getArea();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if (this.getArea() == ((Rectangle) o).getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}

abstract class Octagon extends GeometricObject implements Comparable,Cloneable{
    public double side = 5;


    @Override
    public boolean equals(Object o) {
        if (o instanceof Octagon) {
            return this.getArea() == ((Octagon) o).getArea();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if (this.getArea() == ((Octagon) o).getArea()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

abstract class ComparableCircle extends Circle implements Comparable<Circle> {
    @Override
    public int compareTo(Circle o) {
        if (this.getArea() == o.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}
    

public class C8_lab5 {
    public static void main(String[] args) {
        Circle c1 = new Circle() {
            @Override
            public double getArea() {
                return 2.0;
            }

            @Override
            public double getPerimeter() {
                return 1.0;
            }
        };
        Circle c2 = new Circle() {
            @Override
            public double getArea() {
                return 2.0;
            }

            @Override
            public double getPerimeter() {
                return 2.0;
            }
        };
        //test case 
        int C_com = c1.compareTo(c2);
        if (C_com == 1) {
            System.out.println("area of C1 = area of C2");
        } else {
            System.out.println("area of C1 != area of C2");
        }

        Rectangle square1 = new Rectangle() {
            @Override
            public double getArea() {
                return 10.0;
            }

            @Override
            public double getPerimeter() {
                return 2.5;
            }
        };

        Rectangle square2 = new Rectangle() {
            @Override
            public double getArea() {
                return 10.0;
            }

            @Override
            public double getPerimeter() {
                return 2.5;
            }
        };
        //test case 
        int R_com = square1.compareTo(square2);
        if (R_com == 1) {
            System.out.println("area of R1 = area of R2");
        } else {
            System.out.println("area of R1 != area of R2");
        }

        Octagon octagon1 = new Octagon() {
            @Override
            public double getArea() {
                return (2+4/Math.sqrt(2)) *side*side;
            }

            @Override
            public double getPerimeter() {
                return 2.5;
            }
        };

        //test case 
        try {
            Octagon octagon2 = (Octagon) octagon1.clone();
            System.out.println("octagon1.equals(octagon2) ? : " + octagon1.equals(octagon2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        ComparableCircle comparableCircle1 = new ComparableCircle() {
            @Override
            public double getArea() {
                return 10.0;
            }

            @Override
            public double getPerimeter() {
                return 2.5;
            }
        };

        ComparableCircle comparableCircle2 = new ComparableCircle() {
            @Override
            public double getArea() {
                return 10.0;
            }

            @Override
            public double getPerimeter() {
                return 2.5;
            }
        };
        //test case 
        int CC_com = comparableCircle1.compareTo(comparableCircle2);
        if (CC_com == 1) {
            System.out.println("area of comparableCircle1 = area of comparableCircle2");
        } else {
            System.out.println("area of comparableCircle1 != area of comparableCircle2");
        }
          

    }
}
