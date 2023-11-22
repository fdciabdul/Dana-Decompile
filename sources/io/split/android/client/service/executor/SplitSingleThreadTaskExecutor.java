package io.split.android.client.service.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutorImpl;

/* loaded from: classes6.dex */
public class SplitSingleThreadTaskExecutor extends SplitBaseTaskExecutor {
    private static final String THREAD_NAME_FORMAT = "split-singleThreadTaskExecutor-%d";

    @Override // io.split.android.client.service.executor.SplitBaseTaskExecutor
    protected PausableScheduledThreadPoolExecutor buildScheduler() {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setDaemon(true);
        threadFactoryBuilder.setNameFormat(THREAD_NAME_FORMAT);
        return PausableScheduledThreadPoolExecutorImpl.KClassImpl$Data$declaredNonStaticMembers$2(threadFactoryBuilder.build());
    }
}
