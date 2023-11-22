package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzgi extends zzka implements zzlm {
    private zzgi() {
        super(zzgj.zze());
    }

    public final zzgi zza(Iterable iterable) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzgj.zzh((zzgj) this.zza, iterable);
        return this;
    }

    public final zzgi zzb(int i) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzgj.zzg((zzgj) this.zza, i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgi(zzfj zzfjVar) {
        super(zzgj.zze());
    }
}
