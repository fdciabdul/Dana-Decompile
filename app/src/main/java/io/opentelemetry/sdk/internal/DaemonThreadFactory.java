package io.opentelemetry.sdk.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class DaemonThreadFactory implements ThreadFactory {
    private final AtomicInteger counter = new AtomicInteger();
    private final ThreadFactory delegate = Executors.defaultThreadFactory();
    private final String namePrefix;

    public DaemonThreadFactory(String str) {
        this.namePrefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.delegate.newThread(runnable);
        try {
            newThread.setDaemon(true);
            StringBuilder sb = new StringBuilder();
            sb.append(this.namePrefix);
            sb.append("-");
            sb.append(this.counter.incrementAndGet());
            newThread.setName(sb.toString());
        } catch (SecurityException unused) {
        }
        return newThread;
    }
}
