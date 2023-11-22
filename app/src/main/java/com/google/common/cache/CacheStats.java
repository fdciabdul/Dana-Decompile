package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public final class CacheStats {
    private final long evictionCount;
    private final long hitCount;
    private final long loadExceptionCount;
    private final long loadSuccessCount;
    private final long missCount;
    private final long totalLoadTime;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j4 >= 0);
        Preconditions.checkArgument(j5 >= 0);
        Preconditions.checkArgument(j6 >= 0);
        this.hitCount = j;
        this.missCount = j2;
        this.loadSuccessCount = j3;
        this.loadExceptionCount = j4;
        this.totalLoadTime = j5;
        this.evictionCount = j6;
    }

    public final long requestCount() {
        return LongMath.saturatedAdd(this.hitCount, this.missCount);
    }

    public final long hitCount() {
        return this.hitCount;
    }

    public final double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        double d = this.hitCount;
        double d2 = requestCount;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long missCount() {
        return this.missCount;
    }

    public final double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = this.missCount;
        double d2 = requestCount;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long loadCount() {
        return LongMath.saturatedAdd(this.loadSuccessCount, this.loadExceptionCount);
    }

    public final long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    public final long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    public final double loadExceptionRate() {
        long saturatedAdd = LongMath.saturatedAdd(this.loadSuccessCount, this.loadExceptionCount);
        if (saturatedAdd == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = this.loadExceptionCount;
        double d2 = saturatedAdd;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long totalLoadTime() {
        return this.totalLoadTime;
    }

    public final double averageLoadPenalty() {
        long saturatedAdd = LongMath.saturatedAdd(this.loadSuccessCount, this.loadExceptionCount);
        if (saturatedAdd == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = this.totalLoadTime;
        double d2 = saturatedAdd;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final long evictionCount() {
        return this.evictionCount;
    }

    public final CacheStats minus(CacheStats cacheStats) {
        return new CacheStats(Math.max(0L, LongMath.saturatedSubtract(this.hitCount, cacheStats.hitCount)), Math.max(0L, LongMath.saturatedSubtract(this.missCount, cacheStats.missCount)), Math.max(0L, LongMath.saturatedSubtract(this.loadSuccessCount, cacheStats.loadSuccessCount)), Math.max(0L, LongMath.saturatedSubtract(this.loadExceptionCount, cacheStats.loadExceptionCount)), Math.max(0L, LongMath.saturatedSubtract(this.totalLoadTime, cacheStats.totalLoadTime)), Math.max(0L, LongMath.saturatedSubtract(this.evictionCount, cacheStats.evictionCount)));
    }

    public final CacheStats plus(CacheStats cacheStats) {
        return new CacheStats(LongMath.saturatedAdd(this.hitCount, cacheStats.hitCount), LongMath.saturatedAdd(this.missCount, cacheStats.missCount), LongMath.saturatedAdd(this.loadSuccessCount, cacheStats.loadSuccessCount), LongMath.saturatedAdd(this.loadExceptionCount, cacheStats.loadExceptionCount), LongMath.saturatedAdd(this.totalLoadTime, cacheStats.totalLoadTime), LongMath.saturatedAdd(this.evictionCount, cacheStats.evictionCount));
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.hitCount), Long.valueOf(this.missCount), Long.valueOf(this.loadSuccessCount), Long.valueOf(this.loadExceptionCount), Long.valueOf(this.totalLoadTime), Long.valueOf(this.evictionCount));
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof CacheStats) {
            CacheStats cacheStats = (CacheStats) obj;
            return this.hitCount == cacheStats.hitCount && this.missCount == cacheStats.missCount && this.loadSuccessCount == cacheStats.loadSuccessCount && this.loadExceptionCount == cacheStats.loadExceptionCount && this.totalLoadTime == cacheStats.totalLoadTime && this.evictionCount == cacheStats.evictionCount;
        }
        return false;
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
    }
}
