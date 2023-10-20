class Fruit {

}

class Apple extends Fruit {
    void makeApple() {
        System.out.println("Apple juiceeeeee");
    }
}

class Orange extends Fruit {
    void makeOrangeJuice() {
        System.out.println("Orange juiceeeeee");
    }
}

class GoldenDelicious extends Apple {

}

class Macintosh extends Apple {

}

public class C7_App3 {

    public static void main(String[] args) {
        Fruit fruit = new GoldenDelicious();
        Orange orange = new Orange();

        System.out.println("3.1 " + (fruit instanceof Orange));
        System.out.println("3.2 " + (fruit instanceof Apple));
        System.out.println("3.3 " + (fruit instanceof GoldenDelicious));
        System.out.println("3.4 " + (fruit instanceof Macintosh));
        System.out.println("3.5 " + (orange instanceof Orange));
        System.out.println("3.6 " + (orange instanceof Fruit));
        //System.out.println("3.7 " + (orange instanceof Apple)); NO
        //3.8
        // fruit.makeApple();
        // orange.makeApple();
        //3.9
        orange.makeOrangeJuice();
        // fruit.makeOrangeJuice();
    }
}
