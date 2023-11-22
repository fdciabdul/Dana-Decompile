package io.split.android.client.storage.mysegments;

import com.google.common.base.Preconditions;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class MySegmentsStorageContainerImpl implements MySegmentsStorageContainer {
    private final PersistentMySegmentsStorage mPersistentMySegmentsStorage;
    private final ConcurrentMap<String, MySegmentsStorage> mStorageMap = new ConcurrentHashMap();
    private final Object lock = new Object();

    public MySegmentsStorageContainerImpl(PersistentMySegmentsStorage persistentMySegmentsStorage) {
        this.mPersistentMySegmentsStorage = (PersistentMySegmentsStorage) Preconditions.checkNotNull(persistentMySegmentsStorage);
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorageContainer
    public MySegmentsStorage getStorageForKey(String str) {
        MySegmentsStorage mySegmentsStorage;
        synchronized (this.lock) {
            if (this.mStorageMap.get(str) == null) {
                this.mStorageMap.put(str, new MySegmentsStorageImpl(str, this.mPersistentMySegmentsStorage));
            }
            mySegmentsStorage = this.mStorageMap.get(str);
        }
        return mySegmentsStorage;
    }

    @Override // io.split.android.client.storage.mysegments.MySegmentsStorageContainer
    public long getUniqueAmount() {
        HashSet hashSet = new HashSet();
        Iterator<MySegmentsStorage> it = this.mStorageMap.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getAll());
        }
        return hashSet.size();
    }
}
