package javaBasics.commonApis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
