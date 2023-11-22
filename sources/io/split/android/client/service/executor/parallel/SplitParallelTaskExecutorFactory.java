package io.split.android.client.service.executor.parallel;

import java.util.List;

/* loaded from: classes6.dex */
public interface SplitParallelTaskExecutorFactory {
    <T> SplitParallelTaskExecutor<T> create(Class<T> cls);

    <T> SplitParallelTaskExecutor<List<T>> createForList(Class<T> cls);
}
