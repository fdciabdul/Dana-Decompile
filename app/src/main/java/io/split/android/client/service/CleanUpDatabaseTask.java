package io.split.android.client.service;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.events.PersistentEventsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsCountStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsStorage;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;

/* loaded from: classes6.dex */
public class CleanUpDatabaseTask implements SplitTask {
    private final PersistentEventsStorage mEventsStorage;
    private final PersistentImpressionsCountStorage mImpressionsCountStorage;
    private final PersistentImpressionsStorage mImpressionsStorage;
    private final PersistentImpressionsUniqueStorage mImpressionsUniqueStorage;
    private final long mMaxTimestamp;

    public CleanUpDatabaseTask(PersistentEventsStorage persistentEventsStorage, PersistentImpressionsStorage persistentImpressionsStorage, PersistentImpressionsCountStorage persistentImpressionsCountStorage, PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorage, long j) {
        this.mEventsStorage = (PersistentEventsStorage) Preconditions.checkNotNull(persistentEventsStorage);
        this.mImpressionsStorage = (PersistentImpressionsStorage) Preconditions.checkNotNull(persistentImpressionsStorage);
        this.mImpressionsCountStorage = (PersistentImpressionsCountStorage) Preconditions.checkNotNull(persistentImpressionsCountStorage);
        this.mImpressionsUniqueStorage = (PersistentImpressionsUniqueStorage) Preconditions.checkNotNull(persistentImpressionsUniqueStorage);
        this.mMaxTimestamp = j;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        this.mEventsStorage.deleteInvalid(this.mMaxTimestamp);
        this.mImpressionsStorage.deleteInvalid(this.mMaxTimestamp);
        this.mImpressionsCountStorage.deleteInvalid(this.mMaxTimestamp);
        this.mImpressionsUniqueStorage.deleteInvalid(this.mMaxTimestamp);
        return SplitTaskExecutionInfo.error(SplitTaskType.CLEAN_UP_DATABASE);
    }
}
