package com.huawei.hms.framework.common;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes7.dex */
public class ScheduledThreadPoolExecutorEnhance extends ScheduledThreadPoolExecutor {
    public ScheduledThreadPoolExecutorEnhance(int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(runnable, runnableScheduledFuture));
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new RunnableScheduledFutureEnhance(super.decorateTask(callable, runnableScheduledFuture));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableScheduledFutureEnhance) {
            String parentName = ((RunnableScheduledFutureEnhance) runnable).getParentName();
            int lastIndexOf = parentName.lastIndexOf(" -->");
            if (lastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, lastIndexOf + 4);
            }
            String name = thread.getName();
            int lastIndexOf2 = name.lastIndexOf(" -->");
            if (lastIndexOf2 != -1) {
                name = StringUtils.substring(name, lastIndexOf2 + 4);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(parentName);
            sb.append(" -->");
            sb.append(name);
            thread.setName(sb.toString());
        }
        super.beforeExecute(thread, runnable);
    }
}
