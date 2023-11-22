package io.split.android.client.service.impressions;

import com.google.common.base.Preconditions;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class ImpressionsCounter {
    private final ConcurrentHashMap<Key, AtomicInteger> mCounts = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    public static class Key {
        private final String featureName;
        private final long timeFrame;

        public Key(String str, long j) {
            this.featureName = (String) Preconditions.checkNotNull(str);
            this.timeFrame = j;
        }

        public String featureName() {
            return this.featureName;
        }

        public long timeFrame() {
            return this.timeFrame;
        }

        public int hashCode() {
            return String.format("%s%d", this.featureName, Long.valueOf(this.timeFrame)).hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            return this.featureName.equals(key.featureName) && this.timeFrame == key.timeFrame;
        }
    }

    public void inc(String str, long j, int i) {
        AtomicInteger putIfAbsent;
        Key key = new Key(str, ImpressionUtils.truncateTimeframe(j));
        AtomicInteger atomicInteger = this.mCounts.get(key);
        if (atomicInteger == null && (putIfAbsent = this.mCounts.putIfAbsent(key, (atomicInteger = new AtomicInteger()))) != null) {
            atomicInteger = putIfAbsent;
        }
        atomicInteger.addAndGet(i);
    }

    public List<ImpressionsCountPerFeature> popAll() {
        ArrayList arrayList = new ArrayList();
        for (Key key : new ArrayList(this.mCounts.keySet())) {
            AtomicInteger remove = this.mCounts.remove(key);
            if (remove != null) {
                arrayList.add(new ImpressionsCountPerFeature(key.featureName, key.timeFrame, remove.get()));
            }
        }
        return arrayList;
    }

    public boolean isEmpty() {
        return this.mCounts.isEmpty();
    }
}
