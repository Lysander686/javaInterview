package javaBasics.interfaces;

public class Kangaroo {

    static final class Descendant implements Animal.Mammal{
        @Override
        public void wayToBeBorn() {
            System.out.println("By viviparity");
        }
    }

}
