package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
final class zzlc implements zzlj {
    private final zzlj[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(zzlj... zzljVarArr) {
        this.zza = zzljVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzli zzb(Class cls) {
        zzlj[] zzljVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzlj zzljVar = zzljVarArr[i];
            if (zzljVar.zzc(cls)) {
                return zzljVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzc(Class cls) {
        zzlj[] zzljVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzljVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
