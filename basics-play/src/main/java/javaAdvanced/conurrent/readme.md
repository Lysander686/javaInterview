- [java 并发编程 tutorial link](https://www.cnblogs.com/dolphin0520/p/3920397.html)
  - summary:
    1. CountDownLatch 和 CyclicBarrier 都能够实现线程之间的等待，只不过它们侧重点不同：
       - CountDownLatch 一般用于某个线程 A 等待若干个其他线程执行完任务之后，它才执行；
       - 而 CyclicBarrier 一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
       - 另外，CountDownLatch 是不能够重用的，而 CyclicBarrier 是可以重用的。

    2. Semaphore 其实和锁有点类似，它一般用于控制对某组资源的访问权限。
