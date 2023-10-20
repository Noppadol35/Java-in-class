class Thread1 extends Thread {
    Thread1(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " ");
        }
    }
}

class TestThread1 {
    public static void main(String args[]) {
        new Thread1("A").start();
        new Thread1("B").start();
    }
}

// เมื่อคุณเรียก new Thread1("A").start(); และ new Thread1("B").start();
// จะสร้างและเริ่ม Thread สองตัวพร้อมกัน (Thread A และ Thread B)
// แต่อย่างไรก็ตามไม่มีการระบุลำดับการทำงานของ Thread ทั้งสอง
// ทำให้ผลลัพธ์ของการทำงานอาจแตกต่างกันทุกครั้งที่คุณรันโปรแกรม
// หรืออาจไม่ได้แสดงผลลัพธ์เป็นลำดับสวนที่กำหนดไว้.