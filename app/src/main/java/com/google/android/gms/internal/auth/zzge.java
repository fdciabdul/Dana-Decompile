package com.google.android.gms.internal.auth;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzge {
    private static final zzge zza = new zzge();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgi zzb = new zzfo();

    private zzge() {
    }

    public static zzge zza() {
        return zza;
    }

    public final zzgh zzb(Class cls) {
        zzez.zzf(cls, "messageType");
        zzgh zzghVar = (zzgh) this.zzc.get(cls);
        if (zzghVar == null) {
            zzghVar = this.zzb.zza(cls);
            zzez.zzf(cls, "messageType");
            zzez.zzf(zzghVar, "schema");
            zzgh zzghVar2 = (zzgh) this.zzc.putIfAbsent(cls, zzghVar);
            if (zzghVar2 != null) {
                return zzghVar2;
            }
        }
        return zzghVar;
    }
}
