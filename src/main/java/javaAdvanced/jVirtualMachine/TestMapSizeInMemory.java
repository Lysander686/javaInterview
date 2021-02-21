package javaAdvanced.javaVirtualMachine;


//import org.openjdk.jol.info.ClassLayout;

import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Random;


public class TestMapSizeInMemory {

    private static volatile Instrumentation globalInstrumentation;

    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return (randomStrings);
    }

    public static void main(String[] args) {


        HashMap<String, String> m = new HashMap<>();
        int num = 10;
        String[] wordList = generateRandomWords(num + 1);

        for (int i = 0; i < num; i++) {
            m.put(String.valueOf(i), wordList[num]);
        }

        System.out.println(m.toString());
//        System.out.println("size:" + ObjectSizeFetcher.getObjectSize(m));

    }
}
