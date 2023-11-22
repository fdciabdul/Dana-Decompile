package com.google.android.gms.internal.auth;

import android.net.Uri;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.annotation.Nullable;

/* loaded from: classes7.dex */
public final class zzcz {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    @Nullable
    final zzdg zzi;

    public zzcz(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzcz(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzdg zzdgVar) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z;
        this.zzf = false;
        this.zzg = z3;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcz zza() {
        return new zzcz(null, this.zzb, this.zzc, this.zzd, this.zze, false, true, false, null);
    }

    public final zzcz zzb() {
        if (this.zzc.isEmpty()) {
            return new zzcz(null, this.zzb, this.zzc, this.zzd, true, false, this.zzg, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzdc zzc(String str, double d) {
        return new zzcx(this, str, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), true);
    }

    public final zzdc zzd(String str, long j) {
        return new zzcv(this, str, Long.valueOf(j), true);
    }

    public final zzdc zze(String str, boolean z) {
        return new zzcw(this, str, Boolean.valueOf(z), true);
    }

    public final zzdc zzf(String str, Object obj, zzhu zzhuVar) {
        return new zzcy(this, "getTokenRefactor__blocked_packages", obj, true, zzhuVar, null);
    }
}
