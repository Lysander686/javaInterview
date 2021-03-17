package dataStructurePlayground;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

    public static void main(String[] args) {
        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("name1", "josan1");
        aMap.put("name2", "josan2");
        aMap.put("name3", "josan3");
        aMap.put("name4", "josan4");
        aMap.put("name5", "josan5");
        aMap.put("name6", "josan6");
        aMap.put("name7", "josan7");
        Set<Entry<String, String>> set = aMap.entrySet();
        Iterator<Entry<String, String>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
