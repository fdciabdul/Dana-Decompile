package io.split.android.client.service.synchronizer;

import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.storage.common.InBytesSizable;

/* loaded from: classes6.dex */
public interface RecorderSyncHelper<T extends InBytesSizable> extends SplitTaskExecutionListener {
    boolean pushAndCheckIfFlushNeeded(T t);
}
