package javaBasics.oop;

public class PlayClazz {

    public static void main(String[] args) {
        Mammal mammal = new Mammal();
        PlayClazz playClazz = new PlayClazz();
        Animal animal = playClazz.new Animal();


        System.out.println(mammal.toString());
        System.out.println(animal.toString());
    }

    private static class Mammal{

    }

    private  class Animal{

    }

}
