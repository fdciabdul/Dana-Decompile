package io.split.android.client.service.executor.parallel;

import java.util.Collection;
import java.util.List;

/* loaded from: classes6.dex */
public interface SplitParallelTaskExecutor<T> {
    List<T> execute(Collection<SplitDeferredTaskItem<T>> collection);

    int getAvailableThreads();
}
