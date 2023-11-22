package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
public abstract class zzkn extends zzkm {
    private boolean zza;

    public zzkn(zzkz zzkzVar) {
        super(zzkzVar);
        this.zzf.zzM();
    }

    public final void zzW() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzb();
        this.zzf.zzH();
        this.zza = true;
    }

    public final boolean zzY() {
        return this.zza;
    }

    protected abstract boolean zzb();
}
