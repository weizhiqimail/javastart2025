package threadpool.sychronize;

public class SynchronizeCounter {

    private int count = 0;

    public synchronized  void add(int n) {
        count += n;
    }

    public synchronized  void dec(int n) {
        count -= n;
    }

    public synchronized int get() {
        return count;
    }


}
