package io.split.android.client.storage.mysegments;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
class MySegmentsStorageImpl implements MySegmentsStorage {
    private final Set<String> mInMemoryMySegments = Sets.newConcurrentHashSet();
    private final String mMatchingKey;
    private final PersistentMySegmentsStorage mPersistentStorage;

    public MySegmentsStorageImpl(String str, PersistentMySegmentsStorage persistentMySegmentsStorage) {
        this.mPersistentStorage = (PersistentMySegmentsStorage) Preconditions.checkNotNull(persistentMySegmentsStorage);
        this.mMatchingKey = (String) Preconditions.checkNotNull(str);
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void loadLocal() {
        this.mInMemoryMySegments.addAll(this.mPersistentStorage.getSnapshot(this.mMatchingKey));
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public Set<String> getAll() {
        return this.mInMemoryMySegments;
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void set(List<String> list) {
        if (list == null) {
            return;
        }
        this.mInMemoryMySegments.clear();
        this.mInMemoryMySegments.addAll(list);
        this.mPersistentStorage.set(this.mMatchingKey, list);
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void clear() {
        this.mInMemoryMySegments.clear();
        this.mPersistentStorage.set(this.mMatchingKey, new ArrayList());
    }
}
