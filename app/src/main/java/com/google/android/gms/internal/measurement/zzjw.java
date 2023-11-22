package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public enum zzjw {
    DOUBLE(0, 1, zzkp.DOUBLE),
    FLOAT(1, 1, zzkp.FLOAT),
    INT64(2, 1, zzkp.LONG),
    UINT64(3, 1, zzkp.LONG),
    INT32(4, 1, zzkp.INT),
    FIXED64(5, 1, zzkp.LONG),
    FIXED32(6, 1, zzkp.INT),
    BOOL(7, 1, zzkp.BOOLEAN),
    STRING(8, 1, zzkp.STRING),
    MESSAGE(9, 1, zzkp.MESSAGE),
    BYTES(10, 1, zzkp.BYTE_STRING),
    UINT32(11, 1, zzkp.INT),
    ENUM(12, 1, zzkp.ENUM),
    SFIXED32(13, 1, zzkp.INT),
    SFIXED64(14, 1, zzkp.LONG),
    SINT32(15, 1, zzkp.INT),
    SINT64(16, 1, zzkp.LONG),
    GROUP(17, 1, zzkp.MESSAGE),
    DOUBLE_LIST(18, 2, zzkp.DOUBLE),
    FLOAT_LIST(19, 2, zzkp.FLOAT),
    INT64_LIST(20, 2, zzkp.LONG),
    UINT64_LIST(21, 2, zzkp.LONG),
    INT32_LIST(22, 2, zzkp.INT),
    FIXED64_LIST(23, 2, zzkp.LONG),
    FIXED32_LIST(24, 2, zzkp.INT),
    BOOL_LIST(25, 2, zzkp.BOOLEAN),
    STRING_LIST(26, 2, zzkp.STRING),
    MESSAGE_LIST(27, 2, zzkp.MESSAGE),
    BYTES_LIST(28, 2, zzkp.BYTE_STRING),
    UINT32_LIST(29, 2, zzkp.INT),
    ENUM_LIST(30, 2, zzkp.ENUM),
    SFIXED32_LIST(31, 2, zzkp.INT),
    SFIXED64_LIST(32, 2, zzkp.LONG),
    SINT32_LIST(33, 2, zzkp.INT),
    SINT64_LIST(34, 2, zzkp.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzkp.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzkp.FLOAT),
    INT64_LIST_PACKED(37, 3, zzkp.LONG),
    UINT64_LIST_PACKED(38, 3, zzkp.LONG),
    INT32_LIST_PACKED(39, 3, zzkp.INT),
    FIXED64_LIST_PACKED(40, 3, zzkp.LONG),
    FIXED32_LIST_PACKED(41, 3, zzkp.INT),
    BOOL_LIST_PACKED(42, 3, zzkp.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzkp.INT),
    ENUM_LIST_PACKED(44, 3, zzkp.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzkp.INT),
    SFIXED64_LIST_PACKED(46, 3, zzkp.LONG),
    SINT32_LIST_PACKED(47, 3, zzkp.INT),
    SINT64_LIST_PACKED(48, 3, zzkp.LONG),
    GROUP_LIST(49, 2, zzkp.MESSAGE),
    MAP(50, 4, zzkp.VOID);

    private static final zzjw[] zzZ;
    private final zzkp zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzjw[] values = values();
        zzZ = new zzjw[values.length];
        for (zzjw zzjwVar : values) {
            zzZ[zzjwVar.zzac] = zzjwVar;
        }
    }

    zzjw(int i, int i2, zzkp zzkpVar) {
        this.zzac = i;
        this.zzab = zzkpVar;
        zzkp zzkpVar2 = zzkp.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzkpVar.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzkpVar.zza();
        }
        if (i2 == 1) {
            zzkpVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
