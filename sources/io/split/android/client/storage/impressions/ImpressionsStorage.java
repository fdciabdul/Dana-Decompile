package io.split.android.client.storage.impressions;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.storage.common.PersistentStorage;
import io.split.android.client.storage.common.Storage;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.utils.logger.Logger;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class ImpressionsStorage implements Storage<KeyImpression>, StoragePusher<KeyImpression> {
    private final AbstractQueue<KeyImpression> mImpressions = new ConcurrentLinkedQueue();
    private final AtomicBoolean mIsPersistenceEnabled;
    private final PersistentStorage<KeyImpression> mPersistentStorage;

    public ImpressionsStorage(PersistentStorage<KeyImpression> persistentStorage, boolean z) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.mIsPersistenceEnabled = atomicBoolean;
        this.mPersistentStorage = (PersistentStorage) Preconditions.checkNotNull(persistentStorage);
        atomicBoolean.set(z);
    }

    @Override // io.split.android.client.storage.common.Storage
    public void enablePersistence(boolean z) {
        this.mIsPersistenceEnabled.set(z);
        if (z) {
            Logger.v("Persisting in memory impressions");
            ArrayList arrayList = new ArrayList(this.mImpressions);
            this.mImpressions.removeAll(arrayList);
            this.mPersistentStorage.pushMany(arrayList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Persistence for impressions has been ");
        sb.append(z ? "enabled" : "disabled");
        Logger.d(sb.toString());
    }

    @Override // io.split.android.client.storage.common.Storage, io.split.android.client.storage.common.StoragePusher
    public void push(KeyImpression keyImpression) {
        if (keyImpression == null) {
            return;
        }
        if (this.mIsPersistenceEnabled.get()) {
            Logger.v("Pushing impressions to persistent storage");
            this.mPersistentStorage.push(keyImpression);
            return;
        }
        Logger.v("Pushing impressions to in memory storage");
        this.mImpressions.add(keyImpression);
    }

    @Override // io.split.android.client.storage.common.Storage
    public void clearInMemory() {
        this.mImpressions.clear();
    }
}
