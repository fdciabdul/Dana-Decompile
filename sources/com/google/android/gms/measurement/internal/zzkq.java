package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzkq implements zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzkz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkq(zzkz zzkzVar, String str) {
        this.zzb = zzkzVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzeq
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzK(i, th, bArr, this.zza);
    }
}
