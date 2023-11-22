package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes7.dex */
final class zzjp implements Runnable {
    final /* synthetic */ zzjr zza;

    public zzjp(zzjr zzjrVar) {
        this.zza = zzjrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjs zzjsVar = this.zza.zza;
        Context zzau = zzjsVar.zzs.zzau();
        this.zza.zza.zzs.zzaw();
        zzjs.zzo(zzjsVar, new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
