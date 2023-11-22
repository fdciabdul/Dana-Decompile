package com.iap.ac.android.common.task.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class TaskFactory implements ThreadFactory {
    public AtomicInteger mNewThreadCount = new AtomicInteger(1);
    public String mThreadNamePrefix;
    public int mThreadPriority;

    public TaskFactory(String str, int i) {
        this.mThreadNamePrefix = str;
        this.mThreadPriority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mThreadNamePrefix);
        sb.append(this.mNewThreadCount.getAndIncrement());
        Thread thread = new Thread(runnable, sb.toString());
        thread.setPriority(this.mThreadPriority);
        return thread;
    }
}
