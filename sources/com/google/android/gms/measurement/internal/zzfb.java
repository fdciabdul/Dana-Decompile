package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes7.dex */
public final class zzfb {
    final String zza;
    final /* synthetic */ zzfd zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public /* synthetic */ zzfb(zzfd zzfdVar, String str, long j, zzfa zzfaVar) {
        this.zzb = zzfdVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    private final long zzc() {
        return this.zzb.zza().getLong(this.zza, 0L);
    }

    private final void zzd() {
        this.zzb.zzg();
        long currentTimeMillis = this.zzb.zzs.zzav().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzb.zza().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }

    public final Pair zza() {
        long abs;
        this.zzb.zzg();
        this.zzb.zzg();
        long zzc = zzc();
        if (zzc == 0) {
            zzd();
            abs = 0;
        } else {
            abs = Math.abs(zzc - this.zzb.zzs.zzav().currentTimeMillis());
        }
        long j = this.zze;
        if (abs < j) {
            return null;
        }
        if (abs > j + j) {
            zzd();
            return null;
        }
        String string = this.zzb.zza().getString(this.zzd, null);
        long j2 = this.zzb.zza().getLong(this.zzc, 0L);
        zzd();
        if (string == null || j2 <= 0) {
            return zzfd.zza;
        }
        return new Pair(string, Long.valueOf(j2));
    }

    public final void zzb(String str, long j) {
        this.zzb.zzg();
        if (zzc() == 0) {
            zzd();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzb.zza().getLong(this.zzc, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zzb.zza().edit();
            edit.putString(this.zzd, str);
            edit.putLong(this.zzc, 1L);
            edit.apply();
            return;
        }
        long nextLong = this.zzb.zzs.zzv().zzG().nextLong();
        long j3 = j2 + 1;
        long j4 = LongCompanionObject.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.zzb.zza().edit();
        if ((nextLong & LongCompanionObject.MAX_VALUE) < j4) {
            edit2.putString(this.zzd, str);
        }
        edit2.putLong(this.zzc, j3);
        edit2.apply();
    }
}
