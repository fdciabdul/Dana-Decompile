package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes7.dex */
final class zzfo implements com.google.android.gms.internal.measurement.zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfo(zzfp zzfpVar, String str) {
        this.zzb = zzfpVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) zzfp.zzj(this.zzb).get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
