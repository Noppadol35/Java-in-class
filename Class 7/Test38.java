class A {
    void f() {
        System.out.println("A");
    }
}

class B extends A {
    void f() {
        System.out.println("B");
    }
}

class Test38 {
    static void t(A a) {
        a.f();
    }

    public static void main(String[] args) {
        t(new A());
        t(new B());
    }
}
//output:
// A
// B

//เนื่องจากเมทอด t() รับพารามิเตอร์แบบ A แต่มันสามารถรับวัตถุของคลาส B ได้ด้วย 
//ทำให้เมทอด f() ที่เรียกใน t() จะถูกเลือกตามประเภทของวัตถุที่ถูกส่งเข้ามา 
//ในกรณีที่ส่งวัตถุของคลาส A จะเรียกเมทอด f() ของคลาส A และในกรณีที่ส่งวัตถุของคลาส B จะเรียกเมทอด f() ของคลาส B 
//โดยที่มีการโอเวอร์ไรด์ เมทอด f() ของคลาส A ด้วย 