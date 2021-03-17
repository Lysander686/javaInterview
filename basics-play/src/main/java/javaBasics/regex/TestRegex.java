package javaBasics.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        //正则规则
        Pattern pattern= Pattern.compile("^[a-zA-Z0-9_-]+$");

        //被校验的字符串
        Matcher match = pattern.matcher("MV_ADDRESS_001");

        if (match.matches()){
            System.out.println(1);
        }

    }
}
