package com.google.android.gms.measurement.internal;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzel implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeo zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzel(zzeo zzeoVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeoVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        long j;
        char c2;
        long j2;
        zzfd zzm = this.zzf.zzs.zzm();
        if (zzm.zzx()) {
            zzeo zzeoVar = this.zzf;
            c = zzeoVar.zza;
            if (c == 0) {
                if (zzeoVar.zzs.zzf().zzy()) {
                    zzeo zzeoVar2 = this.zzf;
                    zzeoVar2.zzs.zzaw();
                    zzeoVar2.zza = 'C';
                } else {
                    zzeo zzeoVar3 = this.zzf;
                    zzeoVar3.zzs.zzaw();
                    zzeoVar3.zza = 'c';
                }
            }
            zzeo zzeoVar4 = this.zzf;
            j = zzeoVar4.zzb;
            if (j < 0) {
                zzeoVar4.zzs.zzf().zzh();
                zzeoVar4.zzb = 73000L;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzeo zzeoVar5 = this.zzf;
            c2 = zzeoVar5.zza;
            j2 = zzeoVar5.zzb;
            String str = "2" + charAt + c2 + j2 + ":" + zzeo.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            if (str.length() > 1024) {
                str = this.zzb.substring(0, 1024);
            }
            zzfb zzfbVar = zzm.zzb;
            if (zzfbVar != null) {
                zzfbVar.zzb(str, 1L);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
