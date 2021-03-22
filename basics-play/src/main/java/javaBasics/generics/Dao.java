package javaBasics.generics;

import java.util.List;

public interface Dao {

    static <T> T findByAny(T obj) {
        Object o = new Object();
        return (T) o;
    }

    default List getList() {
//        return
        return null;
    }


}
