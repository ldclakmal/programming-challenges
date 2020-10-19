package lk.avix.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwap {

    private AtomicBoolean lock = new AtomicBoolean(false);

    public boolean tryLock() {
        return lock.compareAndSet(false, true);
    }

    public void releaseLock() {
        lock.set(false);
    }
}
