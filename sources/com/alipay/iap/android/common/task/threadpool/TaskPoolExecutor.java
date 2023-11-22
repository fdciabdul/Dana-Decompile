package com.alipay.iap.android.common.task.threadpool;

import android.os.SystemClock;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.log.util.LoggerUtil;
import com.alipay.iap.android.common.task.threadpool.TaskPoolRunnable;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes6.dex */
public class TaskPoolExecutor extends ThreadPoolExecutor {
    private static final String CLASS_NAME = "TaskPoolExecutor";
    private boolean isPaused;
    private long lastPauseTime;
    private TaskPoolRunnable.TaskType mTaskType;
    private int mThreadPriority;
    private ReentrantLock pauseLock;
    private Condition unPaused;

    public TaskPoolExecutor(TaskPoolRunnable.TaskType taskType, int i, int i2, long j, TimeUnit timeUnit, boolean z, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.pauseLock = reentrantLock;
        this.unPaused = reentrantLock.newCondition();
        this.lastPauseTime = -1L;
        super.allowCoreThreadTimeOut(z);
        this.mTaskType = taskType;
        this.mThreadPriority = -1;
    }

    public void setThreadPriority(int i) {
        this.mThreadPriority = i;
    }

    public void shutdownValidly() {
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.pauseLock.lock();
        try {
            try {
                if (this.isPaused) {
                    if (this.lastPauseTime > 0 && SystemClock.elapsedRealtime() - this.lastPauseTime > TimeUnit.SECONDS.toMillis(4L)) {
                        LoggerWrapper.i("TaskPoolExecutor", "wanna  pause thread pool, but exceed max wait time.");
                        resume();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("try run :");
                        sb.append(runnable);
                        sb.append(" but thread pool request pause.");
                        InstrumentInjector.log_i("TaskPoolExecutor", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("try run :");
                        sb2.append(runnable);
                        sb2.append(" but thread pool request pause.");
                        LoggerWrapper.i("TaskPoolExecutor", sb2.toString());
                        this.unPaused.await(4L, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException unused) {
                thread.interrupt();
            }
        } finally {
            this.pauseLock.unlock();
        }
    }

    public void pause() {
        StringBuilder sb = new StringBuilder();
        sb.append("pause execute : ");
        sb.append(this.mTaskType);
        LoggerWrapper.i("TaskPoolExecutor", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pause execute:");
        sb2.append(this.mTaskType);
        InstrumentInjector.log_i("TaskPoolExecutor", sb2.toString());
        this.pauseLock.lock();
        try {
            this.isPaused = true;
            this.lastPauseTime = SystemClock.elapsedRealtime();
        } finally {
            this.pauseLock.unlock();
        }
    }

    public void resume() {
        StringBuilder sb = new StringBuilder();
        sb.append("resume execute:");
        sb.append(this.mTaskType);
        LoggerWrapper.i("TaskPoolExecutor", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("resume execute:");
        sb2.append(this.mTaskType);
        InstrumentInjector.log_i("TaskPoolExecutor", sb2.toString());
        this.pauseLock.lock();
        try {
            this.isPaused = false;
            this.lastPauseTime = -1L;
            this.unPaused.signalAll();
        } finally {
            this.pauseLock.unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(new TaskPoolRunnable(runnable, this.mTaskType, this.mThreadPriority));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (TaskPoolDiagnose.isShutdownCheckInvoker(LoggerUtil.backTrackInvoker())) {
            TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "shutdown");
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (TaskPoolDiagnose.isShutdownCheckInvoker(LoggerUtil.backTrackInvoker())) {
            TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "shutdownNow");
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void purge() {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "purge");
        super.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "setCorePoolSize");
        super.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "setKeepAliveTime");
        super.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "setThreadFactory");
        super.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setMaximumPoolSize(int i) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "setMaximumPoolSize");
        super.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "setRejectedExecutionHandler");
        super.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, "TaskPoolExecutor", "allowCoreThreadTimeOut");
        super.allowCoreThreadTimeOut(z);
    }
}
