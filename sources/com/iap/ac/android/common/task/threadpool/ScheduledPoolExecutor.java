package com.iap.ac.android.common.task.threadpool;

import com.iap.ac.android.common.task.threadpool.TaskPoolRunnable;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class ScheduledPoolExecutor extends ScheduledThreadPoolExecutor {
    public static final String CLASS_NAME = "ScheduledPoolExecutor";
    public TaskPoolRunnable.TaskType mTaskType;
    public int mThreadPriority;

    public ScheduledPoolExecutor(TaskPoolRunnable.TaskType taskType, int i, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, threadFactory, rejectedExecutionHandler);
        setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
        super.allowCoreThreadTimeOut(true);
        this.mTaskType = taskType;
        this.mThreadPriority = -1;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "allowCoreThreadTimeOut");
        super.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void purge() {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "purge");
        super.purge();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return super.schedule(new TaskPoolRunnable(runnable, this.mTaskType, this.mThreadPriority), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return super.scheduleAtFixedRate(new TaskPoolRunnable(runnable, this.mTaskType, this.mThreadPriority), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return super.scheduleWithFixedDelay(new TaskPoolRunnable(runnable, this.mTaskType, this.mThreadPriority), j, j2, timeUnit);
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

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "shutdown");
        super.shutdown();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        TaskPoolDiagnose.shouldNotBeInvoked(this.mTaskType, CLASS_NAME, "shutdownNow");
        return super.shutdownNow();
    }

    public void shutdownValidly() {
        super.shutdown();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return super.submit(new TaskPoolRunnable(runnable, this.mTaskType, this.mThreadPriority), t);
    }
}
