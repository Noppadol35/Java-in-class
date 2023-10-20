class SuperClass {
    private int num = 1;

    protected int getNumber() {
        return num;
    }
}

class Subclass extends SuperClass {
    private int num = 10;

    // overriding method

    public static void main(String[] args) {
        Subclass s = new Subclass();
        System.out.println(s.getNumber());
    }
// ไม่สามารถใช้ protected int getNumbers()
// เนื่องจากไม่ตรงกับเฉพาะเงื่อนไขการโอเวอร์ไรด์ที่ถูกต้อง ต้องมี signature
// เดียวกับเมธอดใน SuperClass.

// ไม่สามารถใช้ protected long getNumber() ได้ เนื่องจาก signature ต้องตรงกับ
// int getNumber() ใน SuperClass.

// ไม่สามารถใช้ protected int getNumber() ได้ เนื่องจาก signature ต้องตรงกับ int
// getNumber() ใน SuperClass.

// สามารถใช้ public int getNumber() ได้ เพราะมี signature และ modifier
// ที่ถูกต้อง และไม่เป็นการลดความเข้มงวด (accessibility) ของเมธอดใน SuperClass.

// ไม่สามารถใช้ public int getNumber() ได้ เนื่องจาก signature ต้องตรงกับ
// protected int getNumber() ใน SuperClass.

// สามารถใช้ int getNumber() ได้ เนื่องจากไม่ได้ระบุ modifier
// ซึ่งในกรณีนี้จะถือเป็น default access modifier
// และสามารถใช้ในการโอเวอร์ไรด์เมธอดใน SuperClass.

// สามารถใช้ private int getNumber() ได้ แม้ว่ามันจะไม่ใช้การโอเวอร์ไรด์จริง ๆ
// แต่จะถือว่าเป็นการสร้างเมธอดใหม่ใน Subclass และไม่มีผลกับ SuperClass.
}
