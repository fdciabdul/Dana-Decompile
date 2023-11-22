package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzjd implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzc;
    final /* synthetic */ zzjs zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjd(zzjs zzjsVar, zzaw zzawVar, String str, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzd = zzjsVar;
        this.zza = zzawVar;
        this.zzb = str;
        this.zzc = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfy zzfyVar;
        zzee zzeeVar;
        byte[] bArr = null;
        try {
            try {
                zzjs zzjsVar = this.zzd;
                zzeeVar = zzjsVar.zzb;
                if (zzeeVar == null) {
                    zzjsVar.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                    zzfyVar = this.zzd.zzs;
                } else {
                    bArr = zzeeVar.zzu(this.zza, this.zzb);
                    this.zzd.zzQ();
                    zzfyVar = this.zzd.zzs;
                }
            } catch (RemoteException e) {
                this.zzd.zzs.zzay().zzd().zzb("Failed to send event to the service to bundle", e);
                zzfyVar = this.zzd.zzs;
            }
            zzfyVar.zzv().zzS(this.zzc, bArr);
        } catch (Throwable th) {
            this.zzd.zzs.zzv().zzS(this.zzc, bArr);
            throw th;
        }
    }
}
