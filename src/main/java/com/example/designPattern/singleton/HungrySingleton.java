package com.example.designPattern.singleton;

/**
 * 饿汉式：加载类的时候，就创建了对象
 */
public class HungrySingleton {
    // 创建对象
    private static HungrySingleton hungry = new HungrySingleton();

    // 无参构造
    private HungrySingleton() {
    }

    public HungrySingleton getInstance() {
        return hungry;
    }


}

