package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

/* loaded from: classes7.dex */
final class AutoValue_EventStoreConfig extends EventStoreConfig {
    private final int criticalSectionEnterTimeoutMs;
    private final long eventCleanUpAge;
    private final int loadBatchSize;
    private final int maxBlobByteSizePerRow;
    private final long maxStorageSizeInBytes;

    private AutoValue_EventStoreConfig(long j, int i, int i2, long j2, int i3) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = i;
        this.criticalSectionEnterTimeoutMs = i2;
        this.eventCleanUpAge = j2;
        this.maxBlobByteSizePerRow = i3;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    final long getMaxStorageSizeInBytes() {
        return this.maxStorageSizeInBytes;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    final int getLoadBatchSize() {
        return this.loadBatchSize;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    final int getCriticalSectionEnterTimeoutMs() {
        return this.criticalSectionEnterTimeoutMs;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    final long getEventCleanUpAge() {
        return this.eventCleanUpAge;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    final int getMaxBlobByteSizePerRow() {
        return this.maxBlobByteSizePerRow;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.maxStorageSizeInBytes);
        sb.append(", loadBatchSize=");
        sb.append(this.loadBatchSize);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.criticalSectionEnterTimeoutMs);
        sb.append(", eventCleanUpAge=");
        sb.append(this.eventCleanUpAge);
        sb.append(", maxBlobByteSizePerRow=");
        sb.append(this.maxBlobByteSizePerRow);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EventStoreConfig) {
            EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
            return this.maxStorageSizeInBytes == eventStoreConfig.getMaxStorageSizeInBytes() && this.loadBatchSize == eventStoreConfig.getLoadBatchSize() && this.criticalSectionEnterTimeoutMs == eventStoreConfig.getCriticalSectionEnterTimeoutMs() && this.eventCleanUpAge == eventStoreConfig.getEventCleanUpAge() && this.maxBlobByteSizePerRow == eventStoreConfig.getMaxBlobByteSizePerRow();
        }
        return false;
    }

    public final int hashCode() {
        long j = this.maxStorageSizeInBytes;
        int i = (int) (j ^ (j >>> 32));
        int i2 = this.loadBatchSize;
        int i3 = this.criticalSectionEnterTimeoutMs;
        long j2 = this.eventCleanUpAge;
        return ((((((i2 ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ i3) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.maxBlobByteSizePerRow;
    }

    /* loaded from: classes7.dex */
    static final class Builder extends EventStoreConfig.Builder {
        private Integer criticalSectionEnterTimeoutMs;
        private Long eventCleanUpAge;
        private Integer loadBatchSize;
        private Integer maxBlobByteSizePerRow;
        private Long maxStorageSizeInBytes;

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        final EventStoreConfig.Builder setMaxStorageSizeInBytes(long j) {
            this.maxStorageSizeInBytes = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        final EventStoreConfig.Builder setLoadBatchSize(int i) {
            this.loadBatchSize = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        final EventStoreConfig.Builder setCriticalSectionEnterTimeoutMs(int i) {
            this.criticalSectionEnterTimeoutMs = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        final EventStoreConfig.Builder setEventCleanUpAge(long j) {
            this.eventCleanUpAge = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        final EventStoreConfig.Builder setMaxBlobByteSizePerRow(int i) {
            this.maxBlobByteSizePerRow = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        final EventStoreConfig build() {
            String str;
            if (this.maxStorageSizeInBytes == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" maxStorageSizeInBytes");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.loadBatchSize == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" loadBatchSize");
                str = sb2.toString();
            }
            if (this.criticalSectionEnterTimeoutMs == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" criticalSectionEnterTimeoutMs");
                str = sb3.toString();
            }
            if (this.eventCleanUpAge == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" eventCleanUpAge");
                str = sb4.toString();
            }
            if (this.maxBlobByteSizePerRow == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" maxBlobByteSizePerRow");
                str = sb5.toString();
            }
            if (!str.isEmpty()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Missing required properties:");
                sb6.append(str);
                throw new IllegalStateException(sb6.toString());
            }
            return new AutoValue_EventStoreConfig(this.maxStorageSizeInBytes.longValue(), this.loadBatchSize.intValue(), this.criticalSectionEnterTimeoutMs.intValue(), this.eventCleanUpAge.longValue(), this.maxBlobByteSizePerRow.intValue());
        }
    }
}
