package javaBasics.commonApis;

import java.sql.Timestamp;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        long time = System.currentTimeMillis();

        Timestamp ts = new Timestamp(time);

        Date date = new Date(ts.getTime());

        System.out.println(date);

    }
}
