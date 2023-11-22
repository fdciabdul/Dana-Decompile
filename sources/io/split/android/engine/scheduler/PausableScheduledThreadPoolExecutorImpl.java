package io.split.android.engine.scheduler;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class PausableScheduledThreadPoolExecutorImpl extends ScheduledThreadPoolExecutor implements PausableScheduledThreadPoolExecutor {
    private final ReentrantLock BuiltInFictitiousFunctionClassFactory;
    private final Condition MyBillsEntityDataFactory;
    private boolean getAuthRequestContext;

    public static PausableScheduledThreadPoolExecutor KClassImpl$Data$declaredNonStaticMembers$2(ThreadFactory threadFactory) {
        return new PausableScheduledThreadPoolExecutorImpl(1, threadFactory);
    }

    public PausableScheduledThreadPoolExecutorImpl(int i, ThreadFactory threadFactory) {
        super(i, threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        ReentrantLock reentrantLock = new ReentrantLock();
        this.BuiltInFictitiousFunctionClassFactory = reentrantLock;
        this.MyBillsEntityDataFactory = reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.BuiltInFictitiousFunctionClassFactory.lock();
        while (this.getAuthRequestContext) {
            try {
                try {
                    this.MyBillsEntityDataFactory.await();
                } catch (InterruptedException unused) {
                    thread.interrupt();
                }
            } finally {
                this.BuiltInFictitiousFunctionClassFactory.unlock();
            }
        }
    }

    @Override // io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.lock();
        try {
            this.getAuthRequestContext = true;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.unlock();
        }
    }

    @Override // io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.lock();
        try {
            this.getAuthRequestContext = false;
            this.MyBillsEntityDataFactory.signalAll();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.unlock();
        }
    }
}
