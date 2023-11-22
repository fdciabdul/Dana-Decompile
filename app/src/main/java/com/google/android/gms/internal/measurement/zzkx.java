package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
final class zzkx extends zzkz {
    private zzkx() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkx(zzkw zzkwVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final void zza(Object obj, long j) {
        ((zzkl) zzmx.zzf(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final void zzb(Object obj, Object obj2, long j) {
        zzkl zzklVar = (zzkl) zzmx.zzf(obj, j);
        zzkl zzklVar2 = (zzkl) zzmx.zzf(obj2, j);
        int size = zzklVar.size();
        int size2 = zzklVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzklVar.zzc()) {
                zzklVar = zzklVar.zzd(size2 + size);
            }
            zzklVar.addAll(zzklVar2);
        }
        if (size > 0) {
            zzklVar2 = zzklVar;
        }
        zzmx.zzs(obj, j, zzklVar2);
    }
}
