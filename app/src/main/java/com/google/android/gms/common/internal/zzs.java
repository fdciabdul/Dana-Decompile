package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzs extends GmsClientSupervisor {
    private final HashMap zzb = new HashMap();
    private final Context zzc;
    private volatile Handler zzd;
    private final zzr zze;
    private final ConnectionTracker zzf;
    private final long zzg;
    private final long zzh;
    private volatile Executor zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(Context context, Looper looper, Executor executor) {
        zzr zzrVar = new zzr(this, null);
        this.zze = zzrVar;
        this.zzc = context.getApplicationContext();
        this.zzd = new com.google.android.gms.internal.common.zzi(looper, zzrVar);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
        this.zzh = 300000L;
        this.zzi = executor;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void zza(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzp zzpVar = (zzp) this.zzb.get(zzoVar);
            if (zzpVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
            } else if (!zzpVar.zzh(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
            } else {
                zzpVar.zzf(serviceConnection, str);
                if (zzpVar.zzi()) {
                    this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzoVar), this.zzg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zzj;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzp zzpVar = (zzp) this.zzb.get(zzoVar);
            if (executor == null) {
                executor = this.zzi;
            }
            if (zzpVar == null) {
                zzpVar = new zzp(this, zzoVar);
                zzpVar.zzd(serviceConnection, serviceConnection, str);
                zzpVar.zze(str, executor);
                this.zzb.put(zzoVar, zzpVar);
            } else {
                this.zzd.removeMessages(0, zzoVar);
                if (zzpVar.zzh(serviceConnection)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                }
                zzpVar.zzd(serviceConnection, serviceConnection, str);
                int zza = zzpVar.zza();
                if (zza == 1) {
                    serviceConnection.onServiceConnected(zzpVar.zzb(), zzpVar.zzc());
                } else if (zza == 2) {
                    zzpVar.zze(str, executor);
                }
            }
            zzj = zzpVar.zzj();
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new com.google.android.gms.internal.common.zzi(looper, this.zze);
        }
    }
}
