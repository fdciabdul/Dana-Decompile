package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzio implements Runnable {
    final /* synthetic */ zzis zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zzis zzisVar) {
        this.zza = zzisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzik zzikVar;
        zzis zzisVar = this.zza;
        zzikVar = zzisVar.zzh;
        zzisVar.zza = zzikVar;
    }
}
