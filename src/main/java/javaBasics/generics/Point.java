package javaBasics.generics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Point<K> {
    private K x;
    private K y;

    public Point(K x, K y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point p = new Point<String>("sun", "moon");
//        System.out.println(p.toString());

        Point mathP = new Point<Integer>(1,2);
        System.out.println(mathP.toString());
    }
}
