package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzlt {
    private static final zzlt zza = new zzlt();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzlx zzb = new zzld();

    private zzlt() {
    }

    public static zzlt zza() {
        return zza;
    }

    public final zzlw zzb(Class cls) {
        zzkm.zzf(cls, "messageType");
        zzlw zzlwVar = (zzlw) this.zzc.get(cls);
        if (zzlwVar == null) {
            zzlwVar = this.zzb.zza(cls);
            zzkm.zzf(cls, "messageType");
            zzkm.zzf(zzlwVar, "schema");
            zzlw zzlwVar2 = (zzlw) this.zzc.putIfAbsent(cls, zzlwVar);
            if (zzlwVar2 != null) {
                return zzlwVar2;
            }
        }
        return zzlwVar;
    }
}
