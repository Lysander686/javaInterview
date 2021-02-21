package javaAdvanced.jVirtualMachine.codeExecuteOrder;

/**
 * 使用线程的 wait 方法
 */
public class m3_ThreadWaitDemo {

    private static Object myLock1 = new Object();
    private static Object myLock2 = new Object();


    // 为什么要加这两个标识状态?
    // 如果没有状态标识，当t1已经运行完了t2才运行，t2在等待t1唤醒导致t2永远处于等待状态

    /**
     * 产品结束规划吗
     */
    private static Boolean t1Run = false;

    /** 开发结束开发吗*/
    private static Boolean t2Run = false;

    public static void main(String[] args) {

        /** 产品经理 */
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    System.out.println("产品经理规划新需求...");
                    t1Run = true;
                    myLock1.notify();
                }
            }
        });


        /*开发人员*/
        final Thread thread2 = new Thread(() -> {
            synchronized (myLock1) {
                try {
                    if (!t1Run) {
                        System.out.println("开发人员先休息会...");
                        myLock1.wait();
                    }
                    synchronized (myLock2) {
                        System.out.println("开发人员开发新需求功能");
                        myLock2.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 测试人员
        Thread thread3 = new Thread(() -> {
            synchronized (myLock2) {
                try {
                    if (!t2Run) {
                        System.out.println("测试人员先休息会...");
                        myLock2.wait();
                    }
                    System.out.println("测试人员测试新功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }
}