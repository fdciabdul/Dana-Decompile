package io.split.android.client.service.synchronizer;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.common.InBytesSizable;
import io.split.android.client.storage.common.StoragePusher;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class RecorderSyncHelperImpl<T extends InBytesSizable> implements RecorderSyncHelper<T> {
    private final int mMaxQueueSize;
    private final long mMaxQueueSizeInBytes;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final StoragePusher<T> mStorage;
    private final SplitTaskType mTaskType;
    private final AtomicInteger mPushedCount = new AtomicInteger(0);
    private final AtomicLong mTotalPushedSizeInBytes = new AtomicLong(0);

    public RecorderSyncHelperImpl(SplitTaskType splitTaskType, StoragePusher<T> storagePusher, int i, long j, SplitTaskExecutor splitTaskExecutor) {
        this.mTaskType = (SplitTaskType) Preconditions.checkNotNull(splitTaskType);
        this.mStorage = (StoragePusher) Preconditions.checkNotNull(storagePusher);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mMaxQueueSize = i;
        this.mMaxQueueSizeInBytes = j;
    }

    @Override // io.split.android.client.service.synchronizer.RecorderSyncHelper
    public boolean pushAndCheckIfFlushNeeded(T t) {
        pushAsync(t);
        int addAndGet = this.mPushedCount.addAndGet(1);
        long addAndGet2 = this.mTotalPushedSizeInBytes.addAndGet(t.getSizeInBytes());
        if (addAndGet > this.mMaxQueueSize || addAndGet2 >= this.mMaxQueueSizeInBytes) {
            this.mPushedCount.set(0);
            this.mTotalPushedSizeInBytes.set(0L);
            return true;
        }
        return false;
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        if (this.mTaskType.equals(splitTaskExecutionInfo.getTaskType()) && splitTaskExecutionInfo.getStatus().equals(SplitTaskExecutionStatus.ERROR)) {
            this.mPushedCount.addAndGet(splitTaskExecutionInfo.getIntegerValue(SplitTaskExecutionInfo.NON_SENT_RECORDS).intValue());
            this.mTotalPushedSizeInBytes.addAndGet(splitTaskExecutionInfo.getLongValue(SplitTaskExecutionInfo.NON_SENT_BYTES).longValue());
        }
    }

    private void pushAsync(final T t) {
        this.mSplitTaskExecutor.submit(new SplitTask() { // from class: io.split.android.client.service.synchronizer.RecorderSyncHelperImpl.1
            @Override // io.split.android.client.service.executor.SplitTask
            public SplitTaskExecutionInfo execute() {
                RecorderSyncHelperImpl.this.mStorage.push(t);
                return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
            }
        }, null);
    }
}
