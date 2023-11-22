package Catalano.Core.Concurrent;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes6.dex */
class SimpleDeamonThreadFactory implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
