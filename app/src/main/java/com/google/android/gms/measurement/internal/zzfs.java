package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* loaded from: classes7.dex */
public final class zzfs implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfv zza;
    private final String zzb;

    public zzfs(zzfv zzfvVar, String str) {
        this.zza = zzfvVar;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (this) {
            this.zza.zzs.zzay().zzd().zzb(this.zzb, th);
        }
    }
}
