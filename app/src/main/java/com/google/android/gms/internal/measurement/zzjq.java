package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class zzjq {
    static final zzjq zza = new zzjq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzjq zzd;
    private final Map zze;

    zzjq() {
        this.zze = new HashMap();
    }

    public final zzkc zzb(zzll zzllVar, int i) {
        return (zzkc) this.zze.get(new zzjp(zzllVar, i));
    }

    zzjq(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzjq zza() {
        zzjq zzjqVar = zzd;
        if (zzjqVar != null) {
            return zzjqVar;
        }
        synchronized (zzjq.class) {
            zzjq zzjqVar2 = zzd;
            if (zzjqVar2 != null) {
                return zzjqVar2;
            }
            zzjq zzb2 = zzjy.zzb(zzjq.class);
            zzd = zzb2;
            return zzb2;
        }
    }
}
