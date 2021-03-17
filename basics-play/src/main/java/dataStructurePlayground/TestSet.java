package dataStructurePlayground;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

    public static void main(String[] args) {
        Set set = new HashSet<String>();
        set.add("questions");
        String q = (String) set.iterator().next();
        System.out.println(q);

    }
}
