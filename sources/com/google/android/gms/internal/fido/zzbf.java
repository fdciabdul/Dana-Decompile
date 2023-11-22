package com.google.android.gms.internal.fido;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbf extends zzbb {
    final /* synthetic */ zzbg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(zzbg zzbgVar) {
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav
    /* renamed from: zzd */
    public final zzcb iterator() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzbb
    final zzba zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzbc
    final zzaz zzj() {
        return new zzbe(this);
    }
}
