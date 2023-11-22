package com.google.firebase.perf.util;

import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;

/* loaded from: classes.dex */
public enum StorageUnit {
    TERABYTES(1099511627776L) { // from class: com.google.firebase.perf.util.StorageUnit.1
        @Override // com.google.firebase.perf.util.StorageUnit
        public final long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toTerabytes(j);
        }
    },
    GIGABYTES(ConvertUtils.GB) { // from class: com.google.firebase.perf.util.StorageUnit.2
        @Override // com.google.firebase.perf.util.StorageUnit
        public final long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toGigabytes(j);
        }
    },
    MEGABYTES(ConvertUtils.MB) { // from class: com.google.firebase.perf.util.StorageUnit.3
        @Override // com.google.firebase.perf.util.StorageUnit
        public final long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toMegabytes(j);
        }
    },
    KILOBYTES(ConvertUtils.KB) { // from class: com.google.firebase.perf.util.StorageUnit.4
        @Override // com.google.firebase.perf.util.StorageUnit
        public final long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toKilobytes(j);
        }
    },
    BYTES(1) { // from class: com.google.firebase.perf.util.StorageUnit.5
        @Override // com.google.firebase.perf.util.StorageUnit
        public final long convert(long j, StorageUnit storageUnit) {
            return storageUnit.toBytes(j);
        }
    };

    long numBytes;

    public abstract long convert(long j, StorageUnit storageUnit);

    StorageUnit(long j) {
        this.numBytes = j;
    }

    public long toBytes(long j) {
        return j * this.numBytes;
    }

    public long toKilobytes(long j) {
        return (j * this.numBytes) / KILOBYTES.numBytes;
    }

    public long toMegabytes(long j) {
        return (j * this.numBytes) / MEGABYTES.numBytes;
    }

    public long toGigabytes(long j) {
        return (j * this.numBytes) / GIGABYTES.numBytes;
    }

    public long toTerabytes(long j) {
        return (j * this.numBytes) / TERABYTES.numBytes;
    }
}
