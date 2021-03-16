package javaBasics.oop;

public class ClazzMethod {
    public static void main(String[] args) {
        ClazzMethod cm = new ClazzMethod();
        System.out.println(cm.getStr());
    }

    private String getClassName() {
        return "ClazzMethod";
    }

    private String getStr() {
        return this.getClassName();
    }


}
