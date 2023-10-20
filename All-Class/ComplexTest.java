class Complex {
    private double r, i;
    Complex(double r, double i)
    {
        this.r = r; this.i = i;
    }

    Complex(Complex c)
    {
        this(c.r, c.i);
    }
    public void add(Complex c)
    {
        r += c.r;
        i += c.i;
    }
    public void print()
    {
        System.out.println(r + " i: " + i);
    }
}

class ComplexTest
{
    public static void main(String[] args) {
        Complex a = new Complex(1.0, 2.0);
        Complex b = new Complex(3.0, 4.0);
        Complex c = new Complex(a);
        c.add(b);
        c.print();
    }
}