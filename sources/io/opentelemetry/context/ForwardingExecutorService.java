package io.opentelemetry.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class ForwardingExecutorService implements ExecutorService {
    private final ExecutorService delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public ForwardingExecutorService(ExecutorService executorService) {
        this.delegate = executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService delegate() {
        return this.delegate;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> Collection<? extends Callable<T>> wrap(Context context, Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Callable<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(context.wrap(it.next()));
        }
        return arrayList;
    }
}
