package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzjj implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzq zzd;
    final /* synthetic */ zzjs zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjj(zzjs zzjsVar, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar) {
        this.zze = zzjsVar;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjs zzjsVar;
        zzee zzeeVar;
        synchronized (this.zza) {
            try {
                try {
                    zzjsVar = this.zze;
                    zzeeVar = zzjsVar.zzb;
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zze.zzs.zzay().zzd().zzd("(legacy) Failed to get conditional properties; remote exception", null, this.zzb, e);
                this.zza.set(Collections.emptyList());
                atomicReference = this.zza;
            }
            if (zzeeVar != null) {
                if (TextUtils.isEmpty(null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzeeVar.zzf(this.zzb, this.zzc, this.zzd));
                } else {
                    this.zza.set(zzeeVar.zzg(null, this.zzb, this.zzc));
                }
                this.zze.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
                return;
            }
            zzjsVar.zzs.zzay().zzd().zzd("(legacy) Failed to get conditional properties; not connected to service", null, this.zzb, this.zzc);
            this.zza.set(Collections.emptyList());
        }
    }
}
