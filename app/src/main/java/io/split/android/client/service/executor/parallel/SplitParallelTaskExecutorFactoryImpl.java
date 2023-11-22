package io.split.android.client.service.executor.parallel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes6.dex */
public class SplitParallelTaskExecutorFactoryImpl implements SplitParallelTaskExecutorFactory {
    private final ExecutorService mScheduler;
    private final int mThreads;

    public SplitParallelTaskExecutorFactoryImpl() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.mThreads = availableProcessors;
        this.mScheduler = Executors.newFixedThreadPool(availableProcessors);
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory
    public <T> SplitParallelTaskExecutor<List<T>> createForList(Class<T> cls) {
        return new SplitParallelTaskExecutorImpl(this.mThreads, this.mScheduler);
    }

    @Override // io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory
    public <T> SplitParallelTaskExecutor<T> create(Class<T> cls) {
        return new SplitParallelTaskExecutorImpl(this.mThreads, this.mScheduler);
    }
}
