package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class zzgs extends zzgr {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzs.zzD();
    }

    protected void zzaA() {
    }

    protected abstract boolean zzf();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzf()) {
            return;
        }
        this.zzs.zzB();
        this.zza = true;
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaA();
        this.zzs.zzB();
        this.zza = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zza;
    }
}
