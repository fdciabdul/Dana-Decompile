package com.iap.ac.android.common.task;

import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.pipeline.NamedRunnable;
import com.iap.ac.android.common.task.transaction.Transaction;
import com.iap.ac.android.common.task.transaction.TransactionExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class AsyncTaskExecutor {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static AsyncTaskExecutor INSTANCE = null;
    public static final String TAG = "AsyncTaskExecutor";
    public static final ThreadFactory THREADFACTORY;
    public final ThreadPoolExecutor PARALLEL_EXECUTOR;
    public final ScheduledThreadPoolExecutor SCHEDULED_EXECUTOR;
    public final SerialExecutor SERIAL_EXECUTOR;
    public final TransactionExecutor TRANSACTION_EXECUTOR;

    /* loaded from: classes8.dex */
    public static class Factory {
        public AsyncTaskExecutor createExecutorInstance() {
            return new AsyncTaskExecutor();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        THREADFACTORY = new ThreadFactory() { // from class: com.iap.ac.android.common.task.AsyncTaskExecutor.1
            public final AtomicInteger mCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                StringBuilder a2 = a.a("AsyncTaskExecutor_thread_");
                a2.append(this.mCount.incrementAndGet());
                String obj = a2.toString();
                StringBuilder sb = new StringBuilder();
                sb.append("ThreadFactory.newThread(");
                sb.append(obj);
                sb.append(")");
                ACLog.w("AsyncTaskExecutor", sb.toString());
                Thread thread = new Thread(runnable, obj);
                thread.setPriority(1);
                return thread;
            }
        };
        INSTANCE = new AsyncTaskExecutor();
    }

    public static AsyncTaskExecutor getInstance() {
        return INSTANCE;
    }

    public String addTransaction(Transaction transaction) {
        return this.TRANSACTION_EXECUTOR.addTransaction(transaction);
    }

    @Deprecated
    public void execute(Runnable runnable) {
        execute(runnable, "");
    }

    @Deprecated
    public void executeSerially(Runnable runnable) {
        executeSerially(runnable, "");
    }

    public final Executor getExecutor() {
        return this.PARALLEL_EXECUTOR;
    }

    public void removeTransaction(String str) {
        this.TRANSACTION_EXECUTOR.removeTransaction(str);
    }

    @Deprecated
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(runnable, "", j, timeUnit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ACLog.v("AsyncTaskExecutor", "AsyncTaskExecutor.scheduleAtFixedRate(Runnable)");
        return this.SCHEDULED_EXECUTOR.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.SCHEDULED_EXECUTOR.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    public void shutdown() {
        this.TRANSACTION_EXECUTOR.shutdown();
        this.SERIAL_EXECUTOR.shutdown();
        this.PARALLEL_EXECUTOR.shutdown();
        this.SCHEDULED_EXECUTOR.shutdown();
    }

    public AsyncTaskExecutor() {
        this.TRANSACTION_EXECUTOR = new TransactionExecutor();
        ThreadFactory threadFactory = THREADFACTORY;
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool(threadFactory);
        this.PARALLEL_EXECUTOR = threadPoolExecutor;
        this.SERIAL_EXECUTOR = new SerialExecutor(threadPoolExecutor);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(CORE_POOL_SIZE, threadFactory);
        this.SCHEDULED_EXECUTOR = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public void execute(Runnable runnable, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTaskExecutor.execute(Runnable, threadName=");
        sb.append(str);
        sb.append(")");
        ACLog.v("AsyncTaskExecutor", sb.toString());
        this.PARALLEL_EXECUTOR.execute(NamedRunnable.TASK_POOL.obtain(runnable, str));
    }

    public void executeSerially(Runnable runnable, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTaskExecutor.executeSerially(Runnable, threadName=");
        sb.append(str);
        sb.append(")");
        ACLog.v("AsyncTaskExecutor", sb.toString());
        this.SERIAL_EXECUTOR.execute(NamedRunnable.TASK_POOL.obtain(runnable, str));
    }

    public ScheduledFuture<?> schedule(Runnable runnable, String str, long j, TimeUnit timeUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTaskExecutor.schedule(Runnable, threadName=");
        sb.append(str);
        sb.append(")");
        ACLog.v("AsyncTaskExecutor", sb.toString());
        return this.SCHEDULED_EXECUTOR.schedule(NamedRunnable.TASK_POOL.obtain(runnable, str), j, timeUnit);
    }
}
