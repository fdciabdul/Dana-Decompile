package com.alipay.mobile.rome.syncsdk.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class SyncThreadManager {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f7263a;
    private ScheduledExecutorService b;

    /* loaded from: classes3.dex */
    public enum ThreadType {
        SYNC_RECEIVE,
        SYNC_DISPATCH
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ SyncThreadManager(byte b) {
        this();
    }

    private SyncThreadManager() {
        byte b = 0;
        this.f7263a = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new i(b));
        this.b = new ScheduledThreadPoolExecutor(0, new h(b));
    }

    public final void a(ThreadType threadType, Runnable runnable) {
        synchronized (this) {
            ExecutorService a2 = a(threadType);
            if (a2 != null) {
                a2.submit(runnable);
            }
        }
    }

    public final ExecutorService a(ThreadType threadType) {
        ExecutorService executorService;
        byte b = 0;
        if (threadType == ThreadType.SYNC_RECEIVE) {
            ExecutorService executorService2 = this.f7263a;
            if (executorService2 == null || executorService2.isTerminated() || this.f7263a.isShutdown()) {
                this.f7263a = Executors.newSingleThreadExecutor(new i(b));
            }
            executorService = this.f7263a;
        } else if (threadType == ThreadType.SYNC_DISPATCH) {
            ScheduledExecutorService scheduledExecutorService = this.b;
            if (scheduledExecutorService == null || scheduledExecutorService.isTerminated() || this.b.isShutdown()) {
                this.b = Executors.newSingleThreadScheduledExecutor(new h(b));
            }
            executorService = this.b;
        } else {
            StringBuilder sb = new StringBuilder("unknown thread type: ");
            sb.append(threadType);
            c.a("SyncThreadManager", sb.toString());
            executorService = null;
        }
        return executorService == null ? Executors.newSingleThreadExecutor(new i(b)) : executorService;
    }
}
