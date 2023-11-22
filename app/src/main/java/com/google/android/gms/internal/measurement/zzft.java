package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzft extends zzka implements zzlm {
    private zzft() {
        super(zzfu.zzb());
    }

    public final zzft zza(long j) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfu.zzd((zzfu) this.zza, j);
        return this;
    }

    public final zzft zzb(String str) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zzfu.zzc((zzfu) this.zza, str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzft(zzfj zzfjVar) {
        super(zzfu.zzb());
    }
}
