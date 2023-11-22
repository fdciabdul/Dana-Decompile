package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
final class zzlg {
    public static final int zza(int i, Object obj, Object obj2) {
        zzlf zzlfVar = (zzlf) obj;
        zzle zzleVar = (zzle) obj2;
        if (zzlfVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlfVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzlf zzlfVar = (zzlf) obj;
        zzlf zzlfVar2 = (zzlf) obj2;
        if (!zzlfVar2.isEmpty()) {
            if (!zzlfVar.zze()) {
                zzlfVar = zzlfVar.zzb();
            }
            zzlfVar.zzd(zzlfVar2);
        }
        return zzlfVar;
    }
}
