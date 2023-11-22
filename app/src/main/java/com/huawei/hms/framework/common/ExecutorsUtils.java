package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class ExecutorsUtils {
    public static ExecutorService newCachedThreadPool(String str) {
        return new ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory(str));
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(str));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i, String str) {
        return new ScheduledThreadPoolExecutorEnhance(i, createThreadFactory(str));
    }

    public static ExecutorService newFixedThreadPool(int i, String str) {
        return new ThreadPoolExcutorEnhance(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), createThreadFactory(str));
    }

    public static ThreadFactory createThreadFactory(final String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException("ThreadName is empty");
        }
        return new ThreadFactory() { // from class: com.huawei.hms.framework.common.ExecutorsUtils.1
            private final AtomicInteger getAuthRequestContext = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                StringBuilder sb = new StringBuilder();
                sb.append("NetworkKit_");
                sb.append(str);
                sb.append("_");
                sb.append(this.getAuthRequestContext.getAndIncrement());
                return new Thread(runnable, sb.toString());
            }
        };
    }
}
