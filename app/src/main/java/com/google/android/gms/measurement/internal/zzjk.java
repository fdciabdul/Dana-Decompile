package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzjk implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzd;
    final /* synthetic */ zzjs zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjk(zzjs zzjsVar, String str, String str2, zzq zzqVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zze = zzjsVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfy zzfyVar;
        zzee zzeeVar;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zzjs zzjsVar = this.zze;
                zzeeVar = zzjsVar.zzb;
                if (zzeeVar == null) {
                    zzjsVar.zzs.zzay().zzd().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                    zzfyVar = this.zze.zzs;
                } else {
                    Preconditions.checkNotNull(this.zzc);
                    arrayList = zzlh.zzH(zzeeVar.zzf(this.zza, this.zzb, this.zzc));
                    this.zze.zzQ();
                    zzfyVar = this.zze.zzs;
                }
            } catch (RemoteException e) {
                this.zze.zzs.zzay().zzd().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
                zzfyVar = this.zze.zzs;
            }
            zzfyVar.zzv().zzQ(this.zzd, arrayList);
        } catch (Throwable th) {
            this.zze.zzs.zzv().zzQ(this.zzd, arrayList);
            throw th;
        }
    }
}
