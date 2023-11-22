package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzad;
import com.google.android.play.core.appupdate.internal.zzaf;

/* loaded from: classes3.dex */
final class zzz implements zza {
    private final zzz zza = this;
    private final zzaf zzb;
    private final zzaf zzc;
    private final zzaf zzd;
    private final zzaf zze;
    private final zzaf zzf;
    private final zzaf zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzz(zzi zziVar, zzy zzyVar) {
        zzk zzkVar = new zzk(zziVar);
        this.zzb = zzkVar;
        zzaf zzb = zzad.zzb(new zzu(zzkVar));
        this.zzc = zzb;
        zzaf zzb2 = zzad.zzb(new zzs(zzkVar, zzb));
        this.zzd = zzb2;
        zzaf zzb3 = zzad.zzb(new zzd(zzkVar));
        this.zze = zzb3;
        zzaf zzb4 = zzad.zzb(new zzh(zzb2, zzb3, zzkVar));
        this.zzf = zzb4;
        this.zzg = zzad.zzb(new zzj(zzb4));
    }

    @Override // com.google.android.play.core.appupdate.zza
    public final AppUpdateManager zza() {
        return (AppUpdateManager) this.zzg.zza();
    }
}
