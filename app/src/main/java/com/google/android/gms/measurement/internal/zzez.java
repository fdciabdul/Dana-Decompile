package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes7.dex */
public final class zzez {
    final /* synthetic */ zzfd zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzez(zzfd zzfdVar, String str, long j) {
        this.zza = zzfdVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putLong(this.zzb, j);
        edit.apply();
        this.zze = j;
    }
}
