package javaBasics.extendz;

import javaAdvanced.customizedAnnotations.Beautiful;

public class Deer implements Beautiful {
    public static void main(String[] args) {
        Deer deer = new Deer();
        deer.displayItself();
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }
}
