package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes7.dex */
public final class zzep {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Bundle zzd;

    public zzep(String str, String str2, Bundle bundle, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j;
    }

    public static zzep zzb(zzaw zzawVar) {
        return new zzep(zzawVar.zza, zzawVar.zzc, zzawVar.zzb.zzc(), zzawVar.zzd);
    }

    public final String toString() {
        return "origin=" + this.zzb + ",name=" + this.zza + ",params=" + this.zzd.toString();
    }

    public final zzaw zza() {
        return new zzaw(this.zza, new zzau(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
