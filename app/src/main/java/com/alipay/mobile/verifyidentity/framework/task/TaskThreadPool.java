package com.alipay.mobile.verifyidentity.framework.task;

import com.alipay.mobile.verifyidentity.base.log.VILog;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TaskThreadPool extends ThreadPoolExecutor {
    public static String TAG = "TaskThreadPool";

    public TaskThreadPool() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.alipay.mobile.verifyidentity.framework.task.TaskThreadPool.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "verifyidentity_task");
            }
        });
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("thread begin to run ");
        sb.append(thread.getId());
        VILog.i(str, sb.toString());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        VILog.i(TAG, "thread end to run ", th);
    }
}
