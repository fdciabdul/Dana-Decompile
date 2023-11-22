package io.split.android.client.storage.mysegments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class EmptyMySegmentsStorage implements MySegmentsStorage {
    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void clear() {
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void loadLocal() {
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public void set(List<String> list) {
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorage
    public Set<String> getAll() {
        return new HashSet();
    }
}
