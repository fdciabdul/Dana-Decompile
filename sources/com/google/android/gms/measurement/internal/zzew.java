package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzew extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.measurement.internal.zzew";
    private final zzkz zzb;
    private boolean zzc;
    private boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzew(zzkz zzkzVar) {
        Preconditions.checkNotNull(zzkzVar);
        this.zzb = zzkzVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzB();
        String action = intent.getAction();
        this.zzb.zzay().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.zzb.zzay().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zza2 = this.zzb.zzl().zza();
        if (this.zzd != zza2) {
            this.zzd = zza2;
            this.zzb.zzaz().zzp(new zzev(this, zza2));
        }
    }

    public final void zzb() {
        this.zzb.zzB();
        this.zzb.zzaz().zzg();
        if (this.zzc) {
            return;
        }
        this.zzb.zzau().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzd = this.zzb.zzl().zza();
        this.zzb.zzay().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
        this.zzc = true;
    }

    public final void zzc() {
        this.zzb.zzB();
        this.zzb.zzaz().zzg();
        this.zzb.zzaz().zzg();
        if (this.zzc) {
            this.zzb.zzay().zzj().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzau().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzay().zzd().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
