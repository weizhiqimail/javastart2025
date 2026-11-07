package threadpool.sychronize;

public class SynchronizeTest1 {

    public static void main(String[] args) throws InterruptedException {
        threadFn4();
    }

    // 线程不安全
    public static void threadFn1() throws InterruptedException {
        Thread add1 = new AddThread1();
        Thread dec1 = new DecThread1();

        add1.start();
        dec1.start();

        add1.join();
        dec1.join();

        System.out.println("Counter1.count = " + Counter1.count);
    }

    // 线程同步
    public static void threadFn2() throws InterruptedException {
        Thread add2 = new AddThread2();
        Thread dec2 = new DecThread2();

        add2.start();
        dec2.start();

        add2.join();
        dec2.join();

        System.out.println("Counter2.count = " + Counter2.count);
    }

    // 类内部已同步处理
    public static void threadFn3() throws InterruptedException {
        SynchronizeCounter sc1 = new SynchronizeCounter();
        SynchronizeCounter sc2 = new SynchronizeCounter();

        Thread t1 = new Thread(() -> {
            sc1.add(5);
        });

        Thread t2 = new Thread(() -> {
            sc1.dec(1);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("sc1.count = " + sc1.get());


        Thread t3 = new Thread(() -> {
            sc2.add(10);
        });

        Thread t4 = new Thread(() -> {
            sc2.dec(2);
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("sc2.count = " + sc2.get());
    }

    public static void threadFn4() throws InterruptedException {
        SynchronizeCounter sc1 = new SynchronizeCounter();
        SynchronizeCounter sc2 = new SynchronizeCounter();

        runThread(sc1, 10, 2);
        runThread(sc2, 5, 2);

        System.out.println("sc1.count = " + sc1.get());
        System.out.println("sc2.count = " + sc2.get());
    }

    public static void runThread(SynchronizeCounter sc, int addN, int decN) throws InterruptedException {
        Thread addThread = new Thread(() -> {
            sc.add(addN);
        });

        Thread decThread = new Thread(() -> {
            sc.dec(decN);
        });

        addThread.start();
        decThread.start();

        addThread.join();
        decThread.join();

    }
}

class Counter1 {
    public static int count = 0;
}

class AddThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter1.count += 1;
        }
    }
}

class DecThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter1.count -= 1;
        }
    }
}

class Counter2 {
    public static int count = 0;
    public static final Object lock = new Object();

}

class AddThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter2.lock) {
                Counter2.count += 1;
            }
        }
    }
}

class DecThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter2.lock) {
                Counter2.count -= 1;
            }
        }
    }
}