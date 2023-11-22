package io.split.android.client.localhost;

import io.split.android.client.storage.mysegments.EmptyMySegmentsStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;

/* loaded from: classes6.dex */
public class LocalhostMySegmentsStorageContainer implements MySegmentsStorageContainer {
    private final MySegmentsStorage mEmptyMySegmentsStorage = new EmptyMySegmentsStorage();

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorageContainer
    public MySegmentsStorage getStorageForKey(String str) {
        return this.mEmptyMySegmentsStorage;
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorageContainer
    public long getUniqueAmount() {
        return this.mEmptyMySegmentsStorage.getAll().size();
    }
}
