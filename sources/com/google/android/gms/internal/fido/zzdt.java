package com.google.android.gms.internal.fido;

/* loaded from: classes3.dex */
public final class zzdt {
    private final byte zza;
    private final byte zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(int i) {
        this.zza = (byte) (i & 224);
        this.zzb = (byte) (i & 31);
    }

    public final byte zza() {
        return this.zzb;
    }

    public final byte zzb() {
        return this.zza;
    }

    public final int zzc() {
        return (this.zza >> 5) & 7;
    }
}
