package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* loaded from: classes7.dex */
final class zzes implements Runnable {
    private final zzeq zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzes(String str, zzeq zzeqVar, int i, Throwable th, byte[] bArr, Map map, zzer zzerVar) {
        Preconditions.checkNotNull(zzeqVar);
        this.zza = zzeqVar;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
