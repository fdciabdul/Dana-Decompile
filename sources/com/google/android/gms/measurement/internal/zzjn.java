package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes7.dex */
final class zzjn implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(zzjr zzjrVar, ComponentName componentName) {
        this.zzb = zzjrVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjs.zzo(this.zzb.zza, this.zza);
    }
}
