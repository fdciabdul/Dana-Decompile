package io.split.android.client.events;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.split.android.client.utils.ConcurrentSet;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.scheduler.PausableThreadPoolExecutorImpl;
import java.lang.Thread;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes6.dex */
public abstract class BaseEventsManager implements Runnable {
    private static final int QUEUE_CAPACITY = 20;
    protected final ArrayBlockingQueue<SplitInternalEvent> mQueue = new ArrayBlockingQueue<>(20);
    protected final Set<SplitInternalEvent> mTriggered = new ConcurrentSet();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void notifyInternalEvent(SplitInternalEvent splitInternalEvent);

    protected abstract void triggerEventsWhenAreAvailable();

    public BaseEventsManager() {
        launch(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("Split-FactoryEventsManager-%d").setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.split.android.client.events.BaseEventsManager.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected error ");
                sb.append(th.getLocalizedMessage());
                Logger.e(sb.toString());
            }
        }).build());
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            triggerEventsWhenAreAvailable();
        }
    }

    private void launch(ThreadFactory threadFactory) {
        PausableThreadPoolExecutorImpl authRequestContext = PausableThreadPoolExecutorImpl.getAuthRequestContext();
        authRequestContext.submit(this);
        authRequestContext.MyBillsEntityDataFactory();
    }
}
