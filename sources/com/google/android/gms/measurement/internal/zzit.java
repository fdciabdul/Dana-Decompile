package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzit implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zze;
    final /* synthetic */ zzjs zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zzjs zzjsVar, String str, String str2, zzq zzqVar, boolean z, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzf = zzjsVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th;
        zzee zzeeVar;
        Bundle bundle = new Bundle();
        try {
            zzjs zzjsVar = this.zzf;
            zzeeVar = zzjsVar.zzb;
            if (zzeeVar == null) {
                zzjsVar.zzs.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzs.zzv().zzR(this.zze, bundle);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzlc> zzh = zzeeVar.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            Bundle bundle2 = new Bundle();
            if (zzh != null) {
                for (zzlc zzlcVar : zzh) {
                    String str = zzlcVar.zze;
                    if (str != null) {
                        bundle2.putString(zzlcVar.zzb, str);
                    } else {
                        Long l = zzlcVar.zzd;
                        if (l != null) {
                            bundle2.putLong(zzlcVar.zzb, l.longValue());
                        } else {
                            Double d = zzlcVar.zzg;
                            if (d != null) {
                                bundle2.putDouble(zzlcVar.zzb, d.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.zzf.zzQ();
                this.zzf.zzs.zzv().zzR(this.zze, bundle2);
            } catch (RemoteException e) {
                e = e;
                bundle = bundle2;
                try {
                    this.zzf.zzs.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
                    this.zzf.zzs.zzv().zzR(this.zze, bundle);
                } catch (Throwable th2) {
                    bundle2 = bundle;
                    th = th2;
                    th = th;
                    bundle = bundle2;
                    this.zzf.zzs.zzv().zzR(this.zze, bundle);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                bundle = bundle2;
                this.zzf.zzs.zzv().zzR(this.zze, bundle);
                throw th;
            }
        } catch (RemoteException e2) {
            e = e2;
        } catch (Throwable th4) {
            th = th4;
            this.zzf.zzs.zzv().zzR(this.zze, bundle);
            throw th;
        }
    }
}
