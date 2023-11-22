package com.google.android.gms.internal.common;

/* loaded from: classes7.dex */
final class zzae extends zzz {
    private final zzag zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzag zzagVar, int i) {
        super(zzagVar.size(), i);
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
