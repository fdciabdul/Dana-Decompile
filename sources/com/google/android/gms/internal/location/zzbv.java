package com.google.android.gms.internal.location;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbv extends zzbt {
    private final zzbx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbv(zzbx zzbxVar, int i) {
        super(zzbxVar.size(), i);
        this.zza = zzbxVar;
    }

    @Override // com.google.android.gms.internal.location.zzbt
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
