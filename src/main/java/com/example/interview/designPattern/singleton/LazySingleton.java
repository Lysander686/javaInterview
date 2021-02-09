package com.example.interview.designPattern.singleton;

public class LazySingleton {

    /**
     * 懒汉式的多里会遇到线程安全问题
     * <p>
     * 有可能会获取到多个实例
     */

    private static LazySingleton lazyInstance = null;
    private String props;


    private LazySingleton() {
        this.props = "initialized";
    }


    /**
     * 1、适用于单线程环境（不推荐）
     * 具体原因: 多线程的情况有问题。如果两个线程同时运行到判断instance是否为null的if语句，并且instance的确没有被创建时，那么两个线程都会创建一个实例，此时类型Singleton1就不再满足单例模式的要求了。
     */
    public static LazySingleton getInstance() {
        if (null == lazyInstance) {

            lazyInstance = new LazySingleton();

        }
        return lazyInstance;

    }

    /**
     * 2、适用于多线程环境，但效率不高（不推荐）
     *  - 会引起线程阻塞，影响程序的性能
     */
    public static synchronized LazySingleton getInstanceSync() {
        if (lazyInstance == null) {
            lazyInstance = new LazySingleton();
        }
        return lazyInstance;
    }

    /**
     * 3、双重检查加锁（推荐）
     */
    public static LazySingleton getInstance_checkLock() {
        // 先判断实例是否存在，若不存在再对类对象进行加锁处理
        if (lazyInstance == null) {
            synchronized (LazySingleton.class) {
                if (lazyInstance == null) {
                    lazyInstance = new LazySingleton();
                }
            }
        }
        return lazyInstance;
    }


    public static void main(String[] args) {
        // 开辟10条线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LazySingleton instance = LazySingleton.getInstance();
                    System.out.println(instance.hashCode());


                }
            }).start();
        }

    }
}

