package com.google.android.gms.internal.fido;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzaw extends zzar {
    private final zzaz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaw(zzaz zzazVar, int i) {
        super(zzazVar.size(), i);
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.internal.fido.zzar
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
