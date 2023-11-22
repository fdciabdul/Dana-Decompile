package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes7.dex */
final class zzgn implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgn(zzgq zzgqVar, String str) {
        this.zzb = zzgqVar;
        this.zza = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkzVar = this.zzb.zza;
        zzkzVar.zzA();
        zzkzVar2 = this.zzb.zza;
        return zzkzVar2.zzi().zzu(this.zza);
    }
}
