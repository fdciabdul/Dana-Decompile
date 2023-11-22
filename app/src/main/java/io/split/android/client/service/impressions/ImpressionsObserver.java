package io.split.android.client.service.impressions;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.split.android.client.impressions.Impression;

/* loaded from: classes6.dex */
public class ImpressionsObserver {
    private final Cache<Long, Long> mCache;

    public ImpressionsObserver(long j) {
        this.mCache = CacheBuilder.newBuilder().maximumSize(j).concurrencyLevel(4).build();
    }

    public Long testAndSet(Impression impression) {
        if (impression == null) {
            return null;
        }
        Long process = ImpressionHasher.process(impression);
        Long ifPresent = this.mCache.getIfPresent(process);
        this.mCache.put(process, Long.valueOf(impression.time()));
        if (ifPresent == null) {
            return null;
        }
        return Long.valueOf(Math.min(ifPresent.longValue(), impression.time()));
    }
}
