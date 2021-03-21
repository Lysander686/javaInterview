package javaBasics.generics;

import java.util.*;

public class GenericsMain {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple());
        List<Plant> plants = Arrays.asList(new Plant());
        List<Creature> creatures = Arrays.asList(new Creature());

        List<? super Apple> generifiedList;
        generifiedList = appleList;
        generifiedList = plants;
        generifiedList = creatures;
    }

    public static void printCollection(Collection<?> collection) {
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }
}
