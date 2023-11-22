package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        this.zzc = zztVar;
        this.zza = z;
        this.zzb = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        zzr zzrVar;
        zzr zzrVar2;
        zzr zzrVar3;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            zzrVar3 = this.zzc.zza;
            zzrVar3.zza(3, zzgVar.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzf;
        }
        int zzb = zzh.zzb(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
        int i = zzb != 2 ? zzb != 3 ? zzb != 5 ? zzb != 6 ? 3 : 2 : 5 : 1 : 4;
        String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            zzrVar2 = this.zzc.zza;
            zzrVar2.zza(i, zzi, Collections.emptyList(), this.zza, this.zzb);
            return zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < Math.min(list.size(), 5); i2++) {
            arrayList.add(zzgVar.zzb((zzap) list.get(i2)).zzi());
        }
        zzrVar = this.zzc.zza;
        zzrVar.zza(i, zzi, arrayList, this.zza, this.zzb);
        return zzf;
    }
}
