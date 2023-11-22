package io.split.android.client.service.executor.parallel;

import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class SplitParallelTaskExecutorImpl<T> implements SplitParallelTaskExecutor<T> {
    private static final int TIMEOUT_IN_SECONDS = 5;
    private final ExecutorService mScheduler;
    private final int mThreads;

    public SplitParallelTaskExecutorImpl(int i, ExecutorService executorService) {
        this.mThreads = i;
        this.mScheduler = executorService;
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutor
    public List<T> execute(Collection<SplitDeferredTaskItem<T>> collection) {
        try {
            List<Future<T>> invokeAll = this.mScheduler.invokeAll(collection, 5L, TimeUnit.SECONDS);
            ArrayList arrayList = new ArrayList();
            Iterator<Future<T>> it = invokeAll.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().get());
            }
            return arrayList;
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            Logger.e(e.getLocalizedMessage());
            return new ArrayList();
        }
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutor
    public int getAvailableThreads() {
        return this.mThreads;
    }
}
