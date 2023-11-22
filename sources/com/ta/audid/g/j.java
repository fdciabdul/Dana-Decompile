package com.ta.audid.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f7685a;

    /* renamed from: a  reason: collision with other field name */
    private static ScheduledExecutorService f56a;
    private static final AtomicInteger b = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {
        private int priority;

        public a(int i) {
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = j.b.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append("utdid:");
            sb.append(andIncrement);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setPriority(this.priority);
            return thread;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ScheduledExecutorService m247a() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (j.class) {
            if (f56a == null) {
                f56a = Executors.newScheduledThreadPool(3, new a(1));
            }
            scheduledExecutorService = f56a;
        }
        return scheduledExecutorService;
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (f7685a == null) {
                f7685a = new j();
            }
            jVar = f7685a;
        }
        return jVar;
    }

    public final ScheduledFuture schedule(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        return m247a().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final ScheduledFuture a(ScheduledFuture scheduledFuture, Runnable runnable, long j, long j2) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }
        return m247a().scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public void submit(Runnable runnable) {
        try {
            m247a().submit(runnable);
        } catch (Throwable unused) {
        }
    }
}
