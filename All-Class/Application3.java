class Fruit {
}

class Apple extends Fruit {
}

class GoldenDelicious extends Apple {
}

class Macintosh extends Apple {
}

class Orange extends Fruit {
    public void makeOrangeJuice() {
        System.out.println("Making orange juice");
    }
}

public class Application3 {
    public static void main(String[] args) {
        Fruit fruit = new GoldenDelicious();
        Orange orange = new Orange();

        System.out.println("1. Is fruit instanceof Orange? " + (fruit instanceof Orange));

        System.out.println("2. Is fruit instanceof Apple? " + (fruit instanceof Apple));

        System.out.println("3. Is fruit instanceof GoldenDelicious? " + (fruit instanceof GoldenDelicious));

        System.out.println("4. Is fruit instanceof Macintosh? " + (fruit instanceof Macintosh));

        System.out.println("5. Is orange instanceof Orange? " + (orange instanceof Orange));

        System.out.println("6. Is orange instanceof Fruit? " + (orange instanceof Fruit));

        //System.out.println("7. Is orange instanceof Apple? " + (orange instanceof Apple));

        // 8. Can fruit invoke makeApple() method? No, because it's declared as Fruit.
        // 9. Can orange invoke makeOrangeJuice() method? Yes, it's an Orange object.
        orange.makeOrangeJuice();
    }
}
