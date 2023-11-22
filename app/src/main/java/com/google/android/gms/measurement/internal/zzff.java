package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes7.dex */
public final class zzff implements ServiceConnection {
    final /* synthetic */ zzfg zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzff(zzfg zzfgVar, String str) {
        this.zza = zzfgVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                com.google.android.gms.internal.measurement.zzbr zzb = com.google.android.gms.internal.measurement.zzbq.zzb(iBinder);
                if (zzb == null) {
                    this.zza.zza.zzay().zzk().zza("Install Referrer Service implementation was not found");
                    return;
                }
                this.zza.zza.zzay().zzj().zza("Install Referrer Service connected");
                this.zza.zza.zzaz().zzp(new zzfe(this, zzb, this));
                return;
            } catch (RuntimeException e) {
                this.zza.zza.zzay().zzk().zzb("Exception occurred while calling Install Referrer API", e);
                return;
            }
        }
        this.zza.zza.zzay().zzk().zza("Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzay().zzj().zza("Install Referrer Service disconnected");
    }
}
