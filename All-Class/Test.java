public class Test{
    public static void main(String[] args) {
        System.out.println("befor cre obj");
        System.out.println("the num inc cir is " + circleWithStaticMember.numberOfObj);

        circleWithStaticMember c1 = new circleWithStaticMember();
        System.out.println("after cre obj");
        System.out.println("the num in c1 inc cir is " + c1.radius + "(" + c1.numberOfObj + ")");

        circleWithStaticMember c2 = new circleWithStaticMember();

        c1.radius = 9;
        System.out.println("the num in c1 inc cir is " + c1.radius + "(" + c1.numberOfObj + ")");
        System.out.println("the num in c2 inc cir is " + c2.radius + "(" + c2.numberOfObj + ")");

        //output const in get area

        System.out.println("c1 in area : " + c1.getArea());
        System.out.println("c2 : " + c2.getArea());

    }
}

class circleWithStaticMember{
    public static String getArea; //static getArea for show output

    static double radius;

    static int numberOfObj = 0;

    circleWithStaticMember(){
        radius = 1.0;
        numberOfObj++;
    }

    //Construct a circle with radius

    circleWithStaticMember(double newRadius){
        radius = newRadius;
        numberOfObj++;
    }

    // Return numberOfObj
    static int getNumberOfObj(){
        return numberOfObj;
    }

    double getArea(){
        return radius * radius * Math.PI;
    }
}
