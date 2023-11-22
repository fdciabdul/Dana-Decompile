package io.split.android.client.service.executor.parallel;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public class SplitDeferredTaskItem<T> implements Callable<T> {
    private final Callable<T> mCallable;

    public SplitDeferredTaskItem(Callable<T> callable) {
        this.mCallable = (Callable) Preconditions.checkNotNull(callable);
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.mCallable.call();
    }
}
