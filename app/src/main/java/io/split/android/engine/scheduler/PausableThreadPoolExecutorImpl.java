package io.split.android.engine.scheduler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class PausableThreadPoolExecutorImpl extends ThreadPoolExecutor implements PausableThreadPoolExecutor {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private ReentrantLock MyBillsEntityDataFactory;
    private Condition getAuthRequestContext;

    public static PausableThreadPoolExecutorImpl getAuthRequestContext() {
        return new PausableThreadPoolExecutorImpl();
    }

    private PausableThreadPoolExecutorImpl() {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        ReentrantLock reentrantLock = new ReentrantLock();
        this.MyBillsEntityDataFactory = reentrantLock;
        this.getAuthRequestContext = reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.MyBillsEntityDataFactory.lock();
        while (this.BuiltInFictitiousFunctionClassFactory) {
            try {
                try {
                    this.getAuthRequestContext.await();
                } catch (InterruptedException unused) {
                    thread.interrupt();
                }
            } finally {
                this.MyBillsEntityDataFactory.unlock();
            }
        }
    }

    @Override // io.split.android.engine.scheduler.PausableThreadPoolExecutor
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.lock();
        try {
            this.BuiltInFictitiousFunctionClassFactory = false;
            this.getAuthRequestContext.signalAll();
        } finally {
            this.MyBillsEntityDataFactory.unlock();
        }
    }
}
