package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public enum zznd {
    DOUBLE(zzne.DOUBLE, 1),
    FLOAT(zzne.FLOAT, 5),
    INT64(zzne.LONG, 0),
    UINT64(zzne.LONG, 0),
    INT32(zzne.INT, 0),
    FIXED64(zzne.LONG, 1),
    FIXED32(zzne.INT, 5),
    BOOL(zzne.BOOLEAN, 0),
    STRING(zzne.STRING, 2),
    GROUP(zzne.MESSAGE, 3),
    MESSAGE(zzne.MESSAGE, 2),
    BYTES(zzne.BYTE_STRING, 2),
    UINT32(zzne.INT, 0),
    ENUM(zzne.ENUM, 0),
    SFIXED32(zzne.INT, 5),
    SFIXED64(zzne.LONG, 1),
    SINT32(zzne.INT, 0),
    SINT64(zzne.LONG, 0);

    private final zzne zzt;

    zznd(zzne zzneVar, int i) {
        this.zzt = zzneVar;
    }

    public final zzne zza() {
        return this.zzt;
    }
}
