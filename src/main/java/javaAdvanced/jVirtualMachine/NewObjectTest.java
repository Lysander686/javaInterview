package javaAdvanced.javaVirtualMachine;

public class NewObjectTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000 * 10000; i++) {
            // 指针逃逸
            newApple();
        }
        System.out.println("take time:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static Apple newApple() {
        return new Apple();
    }

}
