package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;

/* loaded from: classes7.dex */
public final class GlobalMetrics {
    private static final GlobalMetrics DEFAULT_INSTANCE = new Builder().build();
    private final StorageMetrics storage_metrics_;

    GlobalMetrics(StorageMetrics storageMetrics) {
        this.storage_metrics_ = storageMetrics;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public final StorageMetrics getStorageMetrics() {
        StorageMetrics storageMetrics = this.storage_metrics_;
        return storageMetrics == null ? StorageMetrics.getDefaultInstance() : storageMetrics;
    }

    @Encodable.Field(name = "storageMetrics")
    public final StorageMetrics getStorageMetricsInternal() {
        return this.storage_metrics_;
    }

    public static GlobalMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private StorageMetrics storage_metrics_ = null;

        Builder() {
        }

        public final GlobalMetrics build() {
            return new GlobalMetrics(this.storage_metrics_);
        }

        public final Builder setStorageMetrics(StorageMetrics storageMetrics) {
            this.storage_metrics_ = storageMetrics;
            return this;
        }
    }
}
