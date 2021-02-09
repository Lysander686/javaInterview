package javaBasics.jvm;


//import org.openjdk.jol.info.ClassLayout;

import org.openjdk.jol.info.ClassLayout;

class Fruit {
    private int size;
}

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        Fruit f = new Fruit();

        System.out.print(ClassLayout.parseClass(Fruit.class).toPrintable());
        System.out.print(ClassLayout.parseClass(Object.class).toPrintable());
    }
}
