package com.google.android.gms.internal.measurement;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes7.dex */
public final class zzz {
    final TreeMap zza = new TreeMap();
    final TreeMap zzb = new TreeMap();

    private static final int zzc(zzg zzgVar, zzao zzaoVar, zzap zzapVar) {
        zzap zza = zzaoVar.zza(zzgVar, Collections.singletonList(zzapVar));
        if (zza instanceof zzah) {
            return zzh.zzb(zza.zzh().doubleValue());
        }
        return -1;
    }

    public final void zza(String str, int i, zzao zzaoVar, String str2) {
        TreeMap treeMap;
        if (ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE.equals(str2)) {
            treeMap = this.zzb;
        } else if (SemanticAttributes.FaasDocumentOperationValues.EDIT.equals(str2)) {
            treeMap = this.zza;
        } else {
            throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), zzaoVar);
    }

    public final void zzb(zzg zzgVar, zzab zzabVar) {
        zzl zzlVar = new zzl(zzabVar);
        for (Integer num : this.zza.keySet()) {
            zzaa clone = zzabVar.zzb().clone();
            int zzc = zzc(zzgVar, (zzao) this.zza.get(num), zzlVar);
            if (zzc == 2 || zzc == -1) {
                zzabVar.zzf(clone);
            }
        }
        Iterator it = this.zzb.keySet().iterator();
        while (it.hasNext()) {
            zzc(zzgVar, (zzao) this.zzb.get((Integer) it.next()), zzlVar);
        }
    }
}
