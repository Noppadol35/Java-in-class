public class Lecture_C8 {
    public static void main(String[] args) throws Exception {
        Geometrics obj;
        obj = new circle();
        obj.r = 10;
        System.out.println("Area of circle is " + obj.calArea());
        System.out.println("Perimeter of circle is " + obj.calPerimeter());
        obj = new sq();
        obj.w = 10;
        obj.h = 20;
        System.out.println("Area of square is " + obj.calArea());
        System.out.println("Perimeter of square is " + obj.calPerimeter());
    }

    
}

abstract class Geometrics{
    double w , h, r;
    double area, perimeter;
    abstract double calArea();
    abstract double calPerimeter();

}


class sq extends Geometrics{

    @Override
    double calArea(){
        return area = w * h;
    }
    @Override
    double calPerimeter(){
        return perimeter = 2 * (w + h);
    }
}

class circle extends Geometrics{

    @Override
    double calArea(){
        return area = r * r * 3.14;
    }
    @Override
    double calPerimeter(){
        return perimeter = 2 * (r * 3.14);
    }
}