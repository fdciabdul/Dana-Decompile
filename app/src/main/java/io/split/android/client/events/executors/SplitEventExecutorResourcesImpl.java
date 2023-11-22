package io.split.android.client.events.executors;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitClient;

/* loaded from: classes6.dex */
public class SplitEventExecutorResourcesImpl implements SplitEventExecutorResources {
    private SplitClient mClient;

    @Override // io.split.android.client.events.executors.SplitEventExecutorResources
    public void setSplitClient(SplitClient splitClient) {
        this.mClient = (SplitClient) Preconditions.checkNotNull(splitClient);
    }

    @Override // io.split.android.client.events.executors.SplitEventExecutorResources
    public SplitClient getSplitClient() {
        return this.mClient;
    }
}
