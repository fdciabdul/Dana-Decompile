package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public final class CacheBuilder<K, V> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final int UNSET_INT = -1;
    @CheckForNull
    Equivalence<Object> keyEquivalence;
    @CheckForNull
    LocalCache.Strength keyStrength;
    @CheckForNull
    RemovalListener<? super K, ? super V> removalListener;
    @CheckForNull
    Ticker ticker;
    @CheckForNull
    Equivalence<Object> valueEquivalence;
    @CheckForNull
    LocalCache.Strength valueStrength;
    @CheckForNull
    Weigher<? super K, ? super V> weigher;
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() { // from class: com.google.common.cache.CacheBuilder.1
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier() { // from class: com.google.common.cache.CacheBuilder$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return CacheBuilder.lambda$static$0();
        }
    };
    static final Ticker NULL_TICKER = new Ticker() { // from class: com.google.common.cache.CacheBuilder.2
        @Override // com.google.common.base.Ticker
        public long read() {
            return 0L;
        }
    };
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    boolean strictParsing = true;
    int initialCapacity = -1;
    int concurrencyLevel = -1;
    long maximumSize = -1;
    long maximumWeight = -1;
    long expireAfterWriteNanos = -1;
    long expireAfterAccessNanos = -1;
    long refreshNanos = -1;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public final void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public final int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AbstractCache.StatsCounter lambda$static$0() {
        return new AbstractCache.SimpleStatsCounter();
    }

    private CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    final CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        Preconditions.checkState(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public final CacheBuilder<K, V> initialCapacity(int i) {
        int i2 = this.initialCapacity;
        Preconditions.checkState(i2 == -1, "initial capacity was already set to %s", i2);
        Preconditions.checkArgument(i >= 0);
        this.initialCapacity = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public final CacheBuilder<K, V> concurrencyLevel(int i) {
        int i2 = this.concurrencyLevel;
        Preconditions.checkState(i2 == -1, "concurrency level was already set to %s", i2);
        Preconditions.checkArgument(i > 0);
        this.concurrencyLevel = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public final CacheBuilder<K, V> maximumSize(long j) {
        long j2 = this.maximumSize;
        Preconditions.checkState(j2 == -1, "maximum size was already set to %s", j2);
        long j3 = this.maximumWeight;
        Preconditions.checkState(j3 == -1, "maximum weight was already set to %s", j3);
        Preconditions.checkState(this.weigher == null, "maximum size can not be combined with weigher");
        Preconditions.checkArgument(j >= 0, "maximum size must not be negative");
        this.maximumSize = j;
        return this;
    }

    public final CacheBuilder<K, V> maximumWeight(long j) {
        long j2 = this.maximumWeight;
        Preconditions.checkState(j2 == -1, "maximum weight was already set to %s", j2);
        long j3 = this.maximumSize;
        Preconditions.checkState(j3 == -1, "maximum size was already set to %s", j3);
        Preconditions.checkArgument(j >= 0, "maximum weight must not be negative");
        this.maximumWeight = j;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher) {
        Preconditions.checkState(this.weigher == null);
        if (this.strictParsing) {
            long j = this.maximumSize;
            Preconditions.checkState(j == -1, "weigher can not be combined with maximum size (%s provided)", j);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0L;
        }
        return this.weigher == null ? this.maximumSize : this.maximumWeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public final CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.keyStrength;
        Preconditions.checkState(strength2 == null, "Key strength was already set to %s", strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public final CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    public final CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.valueStrength;
        Preconditions.checkState(strength2 == null, "Value strength was already set to %s", strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public final CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        long j2 = this.expireAfterWriteNanos;
        Preconditions.checkState(j2 == -1, "expireAfterWrite was already set to %s ns", j2);
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getExpireAfterWriteNanos() {
        long j = this.expireAfterWriteNanos;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public final CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        long j2 = this.expireAfterAccessNanos;
        Preconditions.checkState(j2 == -1, "expireAfterAccess was already set to %s ns", j2);
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getExpireAfterAccessNanos() {
        long j = this.expireAfterAccessNanos;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public final CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        long j2 = this.refreshNanos;
        Preconditions.checkState(j2 == -1, "refresh was already set to %s ns", j2);
        Preconditions.checkArgument(j > 0, "duration must be positive: %s %s", j, timeUnit);
        this.refreshNanos = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getRefreshNanos() {
        long j = this.refreshNanos;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public final CacheBuilder<K, V> ticker(Ticker ticker) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Ticker getTicker(boolean z) {
        Ticker ticker = this.ticker;
        return ticker != null ? ticker : z ? Ticker.systemTicker() : NULL_TICKER;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.checkState(this.removalListener == null);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public final CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    final boolean isRecordingStats() {
        return this.statsCounterSupplier == CACHE_STATS_COUNTER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public final <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public final <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        if (this.weigher == null) {
            Preconditions.checkState(this.maximumWeight == -1, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            Preconditions.checkState(this.maximumWeight != -1, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public final String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.maximumSize;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.maximumWeight;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        if (this.expireAfterWriteNanos != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.expireAfterWriteNanos);
            sb.append("ns");
            stringHelper.add("expireAfterWrite", sb.toString());
        }
        if (this.expireAfterAccessNanos != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.expireAfterAccessNanos);
            sb2.append("ns");
            stringHelper.add("expireAfterAccess", sb2.toString());
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue("valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue("removalListener");
        }
        return stringHelper.toString();
    }
}
