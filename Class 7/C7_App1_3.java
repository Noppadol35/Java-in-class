public class C7_App1_3 {
    public static void main(String[] args){
        Object fruit = new Fruit();
        // Object apple = new (Apple)fruit; ผิด เพราะ การ cast ไม่ต้องมี new
        Object apple = (Apple)fruit;

        }
}

class Apple extends Fruit {
}

class Fruit {
}
