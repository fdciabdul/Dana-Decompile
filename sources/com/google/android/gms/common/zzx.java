package com.google.android.gms.common;

import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public class zzx {
    private static final zzx zze = new zzx(true, 3, 1, null, null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;
    final int zzd;

    private zzx(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static zzx zzb() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzc(String str) {
        return new zzx(false, 1, 5, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzd(String str, Throwable th) {
        return new zzx(false, 1, 5, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzf(int i) {
        return new zzx(true, i, 1, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzg(int i, int i2, String str, @Nullable Throwable th) {
        return new zzx(false, i, i2, str, th);
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            InstrumentInjector.log_d("GoogleCertificatesRslt", zza(), this.zzc);
        } else {
            InstrumentInjector.log_d("GoogleCertificatesRslt", zza());
        }
    }
}
