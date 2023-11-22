package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzjl implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzq zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzjs zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjl(zzjs zzjsVar, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar, boolean z) {
        this.zzf = zzjsVar;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzqVar;
        this.zze = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjs zzjsVar;
        zzee zzeeVar;
        synchronized (this.zza) {
            try {
                try {
                    zzjsVar = this.zzf;
                    zzeeVar = zzjsVar.zzb;
                } catch (RemoteException e) {
                    this.zzf.zzs.zzay().zzd().zzd("(legacy) Failed to get user properties; remote exception", null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                }
                if (zzeeVar != null) {
                    if (TextUtils.isEmpty(null)) {
                        Preconditions.checkNotNull(this.zzd);
                        this.zza.set(zzeeVar.zzh(this.zzb, this.zzc, this.zze, this.zzd));
                    } else {
                        this.zza.set(zzeeVar.zzi(null, this.zzb, this.zzc, this.zze));
                    }
                    this.zzf.zzQ();
                    atomicReference = this.zza;
                    atomicReference.notify();
                    return;
                }
                zzjsVar.zzs.zzay().zzd().zzd("(legacy) Failed to get user properties; not connected to service", null, this.zzb, this.zzc);
                this.zza.set(Collections.emptyList());
            } finally {
                this.zza.notify();
            }
        }
    }
}
