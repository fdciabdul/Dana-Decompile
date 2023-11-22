package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class zzar {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzau zzf;

    public zzar(zzfy zzfyVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzau zzauVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzfyVar.zzay().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzeo.zzn(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzauVar = new zzau(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzfyVar.zzay().zzd().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzA = zzfyVar.zzv().zzA(next, bundle2.get(next));
                    if (zzA == null) {
                        zzfyVar.zzay().zzk().zzb("Param value can't be null", zzfyVar.zzj().zze(next));
                        it.remove();
                    } else {
                        zzfyVar.zzv().zzO(bundle2, next, zzA);
                    }
                }
            }
            zzauVar = new zzau(bundle2);
        }
        this.zzf = zzauVar;
    }

    public final String toString() {
        return "Event{appId='" + this.zza + "', name='" + this.zzb + "', params=" + this.zzf.toString() + "}";
    }

    public final zzar zza(zzfy zzfyVar, long j) {
        return new zzar(zzfyVar, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    private zzar(zzfy zzfyVar, String str, String str2, String str3, long j, long j2, zzau zzauVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzauVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzfyVar.zzay().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzeo.zzn(str2), zzeo.zzn(str3));
        }
        this.zzf = zzauVar;
    }
}
