package com.iap.ac.android.common.task.threadpool;

import android.os.SystemClock;
import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.threadpool.TaskPoolRunnable;
import com.iap.ac.android.common.utils.LoggerUtil;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public class TaskPoolExecutor extends ThreadPoolExecutor {
    public static final String CLASS_NAME = "TaskPoolExecutor";
    public boolean isPaused;
    public long lastPauseTime;
    public TaskPoolRunnable.TaskType mTaskType;
    public int mThreadPriority;
    public ReentrantLock pauseLock;
    public Condition unPaused;

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

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "allowCoreThreadTimeOut");
        super.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.pauseLock.lock();
        try {
            if (this.isPaused) {
                if (this.lastPauseTime > 0 && SystemClock.elapsedRealtime() - this.lastPauseTime > TimeUnit.SECONDS.toMillis(4L)) {
                    ACLog.i(CLASS_NAME, "wanna  pause thread pool, but exceed max wait time.");
                    resume();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("try run :");
                sb.append(runnable);
                sb.append(" but thread pool request pause.");
                ACLog.i(CLASS_NAME, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("try run :");
                sb2.append(runnable);
                sb2.append(" but thread pool request pause.");
                ACLog.i(CLASS_NAME, sb2.toString());
                this.unPaused.await(4L, TimeUnit.SECONDS);
            }
        } catch (InterruptedException unused) {
            thread.interrupt();
        } finally {
            this.pauseLock.unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(new TaskPoolRunnable(runnable, this.mTaskType, this.mThreadPriority));
    }

    public void pause() {
        StringBuilder a2 = a.a("pause execute : ");
        a2.append(this.mTaskType);
        ACLog.i(CLASS_NAME, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("pause execute:");
        sb.append(this.mTaskType);
        ACLog.i(CLASS_NAME, sb.toString());
        this.pauseLock.lock();
        try {
            this.isPaused = true;
            this.lastPauseTime = SystemClock.elapsedRealtime();
        } finally {
            this.pauseLock.unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void purge() {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "purge");
        super.purge();
    }

    public void resume() {
        StringBuilder a2 = a.a("resume execute:");
        a2.append(this.mTaskType);
        ACLog.i(CLASS_NAME, a2.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("resume execute:");
        sb.append(this.mTaskType);
        ACLog.i(CLASS_NAME, sb.toString());
        this.pauseLock.lock();
        try {
            this.isPaused = false;
            this.lastPauseTime = -1L;
            this.unPaused.signalAll();
        } finally {
            this.pauseLock.unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "setCorePoolSize");
        super.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "setKeepAliveTime");
        super.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setMaximumPoolSize(int i) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "setMaximumPoolSize");
        super.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "setRejectedExecutionHandler");
        super.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "setThreadFactory");
        super.setThreadFactory(threadFactory);
    }

    public void setThreadPriority(int i) {
        this.mThreadPriority = i;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (TaskPoolDiagnose.isShutdownCheckInvoker(LoggerUtil.backTrackInvoker())) {
            TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "shutdown");
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (TaskPoolDiagnose.isShutdownCheckInvoker(LoggerUtil.backTrackInvoker())) {
            TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "shutdownNow");
        }
        return super.shutdownNow();
    }

    public void shutdownValidly() {
        super.shutdown();
    }
}
