package com.google.android.gms.internal.fido;

import java.util.Comparator;

/* loaded from: classes3.dex */
final class zzcn {
    static final String zza;
    static final Comparator zzb;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Comparator comparator;
        String concat = String.valueOf(zzcn.class.getName()).concat("$UnsafeComparator");
        zza = concat;
        try {
            Object[] enumConstants = Class.forName(concat).getEnumConstants();
            enumConstants.getClass();
            comparator = (Comparator) enumConstants[0];
        } catch (Throwable unused) {
            comparator = zzcm.INSTANCE;
        }
        zzb = comparator;
    }

    zzcn() {
    }
}
