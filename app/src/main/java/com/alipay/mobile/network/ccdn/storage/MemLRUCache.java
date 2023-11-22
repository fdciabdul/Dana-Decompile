package com.alipay.mobile.network.ccdn.storage;

import android.os.SystemClock;
import com.alipay.mobile.network.ccdn.storage.SizeMeasurable;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class MemLRUCache<K, V extends SizeMeasurable> {
    private Map<K, LRUEntry<V>> container;
    private long expiration;
    private int maxEntrySize;
    private long maxMemSize;
    private volatile AtomicLong memSize = new AtomicLong(0);
    private AtomicInteger reqCount = new AtomicInteger(0);
    private AtomicInteger hitCount = new AtomicInteger(0);
    private AtomicInteger evictCount = new AtomicInteger(0);

    public MemLRUCache(int i, long j, long j2) {
        this.container = DesugarCollections.MyBillsEntityDataFactory(new LinkedHashMap<K, LRUEntry<V>>(i, 0.75f, true) { // from class: com.alipay.mobile.network.ccdn.storage.MemLRUCache.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<K, LRUEntry<V>> entry) {
                return MemLRUCache.this.ensureSize(entry);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public void clear() {
                super.clear();
                MemLRUCache.this.memSize.set(0L);
            }
        });
        this.maxEntrySize = i;
        this.maxMemSize = j;
        this.expiration = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureSize(Map.Entry<K, LRUEntry<V>> entry) {
        LRUEntry<V> value = entry.getValue();
        if (this.memSize.longValue() > this.maxMemSize || this.container.size() > this.maxEntrySize) {
            onEntryRemoved(value);
            return true;
        } else if (value.expired()) {
            onEntryRemoved(value);
            return true;
        } else {
            return false;
        }
    }

    public Collection<LRUEntry<V>> values() {
        return this.container.values();
    }

    public void put(K k, V v) {
        int size = v.getSize();
        if (size <= 0 || this.container.put(k, new LRUEntry<>(k, v, this.expiration)) != null) {
            return;
        }
        this.memSize.addAndGet(size);
    }

    public V get(K k) {
        this.reqCount.incrementAndGet();
        LRUEntry<V> lRUEntry = this.container.get(k);
        if (lRUEntry != null) {
            if (lRUEntry.expired()) {
                remove(k);
                return null;
            }
            V value = lRUEntry.value();
            if (value != null) {
                lRUEntry.updateExpiration(this.expiration);
                this.hitCount.incrementAndGet();
                return value;
            }
        }
        return null;
    }

    public boolean contains(K k) {
        return this.container.containsKey(k);
    }

    public V remove(K k) {
        return onEntryRemoved(this.container.remove(k));
    }

    private V onEntryRemoved(LRUEntry<V> lRUEntry) {
        if (lRUEntry != null) {
            this.evictCount.incrementAndGet();
            this.memSize.getAndAdd(-lRUEntry.size());
            return lRUEntry.value();
        }
        return null;
    }

    public void clear() {
        this.container.clear();
    }

    public int entries() {
        return this.container.size();
    }

    public long memSize() {
        return this.memSize.get();
    }

    public int hits() {
        return this.hitCount.get();
    }

    public int requests() {
        return this.reqCount.get();
    }

    public int evicts() {
        return this.evictCount.get();
    }

    /* loaded from: classes6.dex */
    public static class LRUEntry<V extends SizeMeasurable> {
        long expiration;
        protected Object key;
        V value;

        LRUEntry(Object obj, V v, long j) {
            this.key = obj;
            this.value = v;
            updateExpiration(j);
        }

        public V value() {
            return this.value;
        }

        public int size() {
            V v = this.value;
            if (v != null) {
                return v.getSize();
            }
            return 0;
        }

        boolean expired() {
            return SystemClock.elapsedRealtime() > this.expiration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateExpiration(long j) {
            this.expiration = SystemClock.elapsedRealtime() + j;
        }
    }
}
