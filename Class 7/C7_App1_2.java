class A {
    int x = 1;

    void inc() {
        x++;
    }

    int get() {
        return x;
    }
}

class B extends A {
    int x = 2;

    void inc() {
        x++;
    }

    int get() {
        return x;
    }
}

class Test {
    public static void main(String[] args) {
        B b = new B();
        A a = b;
        a.inc();
        b.inc();
        System.out.println(a.x + "," + b.x);
        System.out.println(a.get() + "," + b.get());
    }
}

//output:
// 1,2
// 2,3
// เนื่องจากเมทอด inc() และ get() ถูกโอเวอร์ไรด์ ดังนั้นเมื่อเรียกใช้งานจากออบเจ็กต์ของคลาส B จะเรียกใช้งานเมทอดของคลาส B แทน
// แต่เมื่อเรียกใช้งานจากออบเจ็กต์ของคลาส A จะเรียกใช้งานเมทอดของคลาส A แทน
