package com.google.android.gms.internal.fido;

import java.util.AbstractMap;

/* loaded from: classes3.dex */
final class zzbe extends zzaz {
    final /* synthetic */ zzbf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(zzbf zzbfVar) {
        this.zza = zzbfVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzbu zzbuVar;
        zzaz zzazVar;
        zzbuVar = this.zza.zza.zze;
        Object obj = zzbuVar.zzd.get(i);
        zzazVar = this.zza.zza.zzf;
        return new AbstractMap.SimpleImmutableEntry(obj, zzazVar.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zza.size();
    }
}
