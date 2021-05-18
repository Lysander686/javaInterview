package javaBasics.interfaces;

public class Kangaroo {

    static final class Descendant implements Animal.InnerMammal {
        @Override
        public void wayToBeBorn() {
            System.out.println("By viviparity");
        }
    }

}
