package com.google.android.gms.internal.auth;

/* loaded from: classes7.dex */
final class zzfn implements zzfu {
    private final zzfu[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfn(zzfu... zzfuVarArr) {
        this.zza = zzfuVarArr;
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final zzft zzb(Class cls) {
        zzfu[] zzfuVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzfu zzfuVar = zzfuVarArr[i];
            if (zzfuVar.zzc(cls)) {
                return zzfuVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final boolean zzc(Class cls) {
        zzfu[] zzfuVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzfuVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
