package javaBasics.interfaces;

public interface Animal {

    default void selfIntro() {
        System.out.println("I'm an animal.");
    }

    interface InnerMammal {

        void wayToBeBorn();

    }
}
