package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class zzao extends zzai implements zzal {
    protected final List zza;
    protected final List zzb;
    protected zzg zzc;

    private zzao(zzao zzaoVar) {
        super(zzaoVar.zzd);
        ArrayList arrayList = new ArrayList(zzaoVar.zza.size());
        this.zza = arrayList;
        arrayList.addAll(zzaoVar.zza);
        ArrayList arrayList2 = new ArrayList(zzaoVar.zzb.size());
        this.zzb = arrayList2;
        arrayList2.addAll(zzaoVar.zzb);
        this.zzc = zzaoVar.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        zzg zza = this.zzc.zza();
        for (int i = 0; i < this.zza.size(); i++) {
            if (i < list.size()) {
                zza.zze((String) this.zza.get(i), zzgVar.zzb((zzap) list.get(i)));
            } else {
                zza.zze((String) this.zza.get(i), zzf);
            }
        }
        for (zzap zzapVar : this.zzb) {
            zzap zzb = zza.zzb(zzapVar);
            if (zzb instanceof zzaq) {
                zzb = zza.zzb(zzapVar);
            }
            if (zzb instanceof zzag) {
                return ((zzag) zzb).zzb();
            }
        }
        return zzap.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzai, com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzao(this);
    }

    public zzao(String str, List list, List list2, zzg zzgVar) {
        super(str);
        this.zza = new ArrayList();
        this.zzc = zzgVar;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zza.add(((zzap) it.next()).zzi());
            }
        }
        this.zzb = new ArrayList(list2);
    }
}
