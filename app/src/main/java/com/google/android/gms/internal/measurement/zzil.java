package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* loaded from: classes7.dex */
public final class zzil {
    public static zzih zza(zzih zzihVar) {
        if ((zzihVar instanceof zzij) || (zzihVar instanceof zzii)) {
            return zzihVar;
        }
        if (zzihVar instanceof Serializable) {
            return new zzii(zzihVar);
        }
        return new zzij(zzihVar);
    }

    public static zzih zzb(Object obj) {
        return new zzik(obj);
    }
}
