package javaBasics.generics;

import lombok.Data;

@Data
public class Apple {


    private String color;
    private String flavor;

    public Apple(String color, String flavor) {
        this.color = color;
        this.flavor = flavor;
    }

    public void testThis(){
        System.out.println(this);
    }


    public void showColor(){
        System.out.println(this.color);
    }

    public void printFlavor(){
        System.out.println(flavor);
    }


    public static void main(String[] args) {
        Apple test = new Apple("red", "sweet");
//        test.testThis();

        Apple greenApple = new Apple("green", "sour");

//        greenOne.testThis();
        greenApple.showColor();
        greenApple.printFlavor();

    }

}
