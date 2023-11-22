package io.split.android.client.service.impressions.unique;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class UniqueKeysTrackerImpl implements UniqueKeysTracker {
    private final Object mLock = new Object();
    private final Map<String, Set<String>> mCache = new ConcurrentHashMap();

    @Override // io.split.android.client.service.impressions.unique.UniqueKeysTracker
    public boolean track(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        synchronized (this.mLock) {
            if (!this.mCache.containsKey(str)) {
                this.mCache.put(str, new HashSet());
            }
            this.mCache.get(str).add(str2);
        }
        return true;
    }

    @Override // io.split.android.client.service.impressions.unique.UniqueKeysTracker
    public Map<String, Set<String>> popAll() {
        HashMap hashMap;
        synchronized (this.mLock) {
            hashMap = new HashMap(this.mCache);
            this.mCache.clear();
        }
        return hashMap;
    }

    @Override // io.split.android.client.service.impressions.unique.UniqueKeysTracker
    public boolean isFull() {
        return this.mCache.size() >= 30000;
    }
}
