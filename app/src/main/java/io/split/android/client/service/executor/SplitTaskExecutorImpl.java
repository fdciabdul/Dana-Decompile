package io.split.android.client.service.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutorImpl;

/* loaded from: classes6.dex */
public class SplitTaskExecutorImpl extends SplitBaseTaskExecutor {
    private static final int MIN_THREAD_POOL_SIZE_WHEN_IDLE = 6;
    private static final String THREAD_NAME_FORMAT = "split-taskExecutor-%d";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.service.executor.SplitBaseTaskExecutor
    public PausableScheduledThreadPoolExecutorImpl buildScheduler() {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setDaemon(true);
        threadFactoryBuilder.setNameFormat(THREAD_NAME_FORMAT);
        return new PausableScheduledThreadPoolExecutorImpl(6, threadFactoryBuilder.build());
    }
}
