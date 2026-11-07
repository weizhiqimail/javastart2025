package threadpool;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        threadFn1();
    }

    public static void threadFn1() throws InterruptedException {
        System.out.println("threadFn1 start...");
        Thread t1 = new MyThread1();
        t1.start();
        // main 等待 t1 执行完，再向下走
        t1.join();

        Thread t2 = new Thread(new MyRunnable1());
        t2.start();
        // main 等待 t2 执行完，再向下走
        t2.join();
        System.out.println("threadFn1 end...");
    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread instance start...");
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable1 instance start...");
    }
}
