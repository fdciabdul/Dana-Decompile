package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.messaging.Constants;

/* loaded from: classes7.dex */
final class zzfe implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzff zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfe(zzff zzffVar, com.google.android.gms.internal.measurement.zzbr zzbrVar, ServiceConnection serviceConnection) {
        this.zzc = zzffVar;
        this.zza = zzbrVar;
        this.zzb = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Bundle bundle;
        zzff zzffVar = this.zzc;
        zzfg zzfgVar = zzffVar.zza;
        str = zzffVar.zzb;
        com.google.android.gms.internal.measurement.zzbr zzbrVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfgVar.zza.zzaz().zzg();
        Bundle bundle2 = new Bundle();
        bundle2.putString("package_name", str);
        try {
            bundle = zzbrVar.zzd(bundle2);
        } catch (Exception e) {
            zzfgVar.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        if (bundle == null) {
            zzfgVar.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
            bundle = null;
        }
        zzfgVar.zza.zzaz().zzg();
        zzfy.zzO();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzfgVar.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfgVar.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfgVar.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    Bundle zzs = zzfgVar.zza.zzv().zzs(Uri.parse("?".concat(string)));
                    if (zzs == null) {
                        zzfgVar.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = bundle.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzfgVar.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfgVar.zza.zzm().zzd.zza()) {
                            zzfgVar.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzfgVar.zza.zzJ()) {
                            zzfgVar.zza.zzm().zzd.zzb(j);
                            zzfgVar.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs.putString("_cis", "referrer API v2");
                            zzfgVar.zza.zzq().zzF("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzs, str);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfgVar.zza.zzau(), serviceConnection);
    }
}
