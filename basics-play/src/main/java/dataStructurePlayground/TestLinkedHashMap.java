package dataStructurePlayground;

import java.util.*;
import java.util.Map.Entry;

/* reference link: https://www.jianshu.com/p/8f4f58b4b8ab */
public class TestLinkedHashMap {
    /* rezp: LinkedHashMap提供了多个构造方法，我们先看空参的构造方法。

      */

    public static void main(String[] args) {
        LinkedHashMap<String, String> aMap = new LinkedHashMap<>();

        aMap.put("name1", "josan1");
        aMap.put("name2", "josan2");
        aMap.put("name3", "josan3");
        aMap.put("name4", "josan4");
        aMap.put("name5", "josan5");
        aMap.put("name6", "josan6");
        aMap.put("name7", "josan7");

        Iterator<Entry<String, String>> iterator = aMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
