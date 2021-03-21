package javaAdvanced.customizedAnnotations;

import javaBasics.extendz.Property;

public interface Beautiful extends Property {
    String description();
    int length();

    default void displayItself() {
        System.out.println("I'm Beautiful");
    }
}
