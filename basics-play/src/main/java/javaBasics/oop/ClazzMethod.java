package javaBasics.oop;

public class ClazzMethod {
    public static void main(String[] args) {
        ClazzMethod cm = new ClazzMethod();
        System.out.println(cm.getStr());
        System.out.println(ClazzMethod.getStr());
    }

    private String getClassName() {
        return "ClazzMethod";
    }

    private static String getStr() {
//        return getClassName();
        return "str";
    }


}
