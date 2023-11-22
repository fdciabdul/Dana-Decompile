package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes7.dex */
public final class StorageMetrics {
    private static final StorageMetrics DEFAULT_INSTANCE = new Builder().build();
    private final long current_cache_size_bytes_;
    private final long max_cache_size_bytes_;

    StorageMetrics(long j, long j2) {
        this.current_cache_size_bytes_ = j;
        this.max_cache_size_bytes_ = j2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final long getCurrentCacheSizeBytes() {
        return this.current_cache_size_bytes_;
    }

    public final long getMaxCacheSizeBytes() {
        return this.max_cache_size_bytes_;
    }

    public static StorageMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private long current_cache_size_bytes_ = 0;
        private long max_cache_size_bytes_ = 0;

        Builder() {
        }

        public final StorageMetrics build() {
            return new StorageMetrics(this.current_cache_size_bytes_, this.max_cache_size_bytes_);
        }

        public final Builder setCurrentCacheSizeBytes(long j) {
            this.current_cache_size_bytes_ = j;
            return this;
        }

        public final Builder setMaxCacheSizeBytes(long j) {
            this.max_cache_size_bytes_ = j;
            return this;
        }
    }
}
