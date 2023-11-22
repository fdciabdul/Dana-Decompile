package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes7.dex */
final class zzge implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgq zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(zzgq zzgqVar, String str, String str2, String str3) {
        this.zzd = zzgqVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkzVar = this.zzd.zza;
        zzkzVar.zzA();
        zzkzVar2 = this.zzd.zza;
        return zzkzVar2.zzi().zzs(this.zza, this.zzb, this.zzc);
    }
}
