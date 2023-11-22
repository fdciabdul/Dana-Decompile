package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
final class zzkv extends zzkz {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzkv() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkv(zzku zzkuVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzmx.zzf(obj, j);
        if (list instanceof zzkt) {
            unmodifiableList = ((zzkt) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if (!(list instanceof zzls) || !(list instanceof zzkl)) {
                unmodifiableList = Collections.unmodifiableList(list);
            } else {
                zzkl zzklVar = (zzkl) list;
                if (zzklVar.zzc()) {
                    zzklVar.zzb();
                    return;
                }
                return;
            }
        }
        zzmx.zzs(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final void zzb(Object obj, Object obj2, long j) {
        zzks zzksVar;
        List list = (List) zzmx.zzf(obj2, j);
        int size = list.size();
        List list2 = (List) zzmx.zzf(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzkt) {
                list2 = new zzks(size);
            } else if (!(list2 instanceof zzls) || !(list2 instanceof zzkl)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((zzkl) list2).zzd(size);
            }
            zzmx.zzs(obj, j, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzmx.zzs(obj, j, arrayList);
                zzksVar = arrayList;
            } else if (list2 instanceof zzms) {
                zzks zzksVar2 = new zzks(list2.size() + size);
                zzksVar2.addAll(zzksVar2.size(), (zzms) list2);
                zzmx.zzs(obj, j, zzksVar2);
                zzksVar = zzksVar2;
            } else if ((list2 instanceof zzls) && (list2 instanceof zzkl)) {
                zzkl zzklVar = (zzkl) list2;
                if (!zzklVar.zzc()) {
                    list2 = zzklVar.zzd(list2.size() + size);
                    zzmx.zzs(obj, j, list2);
                }
            }
            list2 = zzksVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzmx.zzs(obj, j, list);
    }
}
