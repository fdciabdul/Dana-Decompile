package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
final class zzjv {
    private static final zzjv zzb = new zzjv(true);
    final zzmj zza = new zzlz(16);
    private boolean zzc;
    private boolean zzd;

    private zzjv() {
    }

    public static zzjv zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.measurement.zzju r3, java.lang.Object r4) {
        /*
            com.google.android.gms.internal.measurement.zznd r0 = r3.zzb()
            com.google.android.gms.internal.measurement.zzkm.zze(r4)
            com.google.android.gms.internal.measurement.zznd r1 = com.google.android.gms.internal.measurement.zznd.DOUBLE
            com.google.android.gms.internal.measurement.zzne r1 = com.google.android.gms.internal.measurement.zzne.INT
            com.google.android.gms.internal.measurement.zzne r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r4 instanceof com.google.android.gms.internal.measurement.zzll
            if (r0 != 0) goto L45
            boolean r0 = r4 instanceof com.google.android.gms.internal.measurement.zzkq
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r4 instanceof com.google.android.gms.internal.measurement.zzkg
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r4 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r0 != 0) goto L45
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r4 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r4 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r4 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r4 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r4 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r4 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            int r2 = r3.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 1
            com.google.android.gms.internal.measurement.zznd r3 = r3.zzb()
            com.google.android.gms.internal.measurement.zzne r3 = r3.zza()
            r0[r1] = r3
            r3 = 2
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r0[r3] = r4
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r0)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjv.zzd(com.google.android.gms.internal.measurement.zzju, java.lang.Object):void");
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjv zzjvVar = new zzjv();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzjvVar.zzc((zzju) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzjvVar.zzc((zzju) entry.getKey(), entry.getValue());
        }
        zzjvVar.zzd = this.zzd;
        return zzjvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjv) {
            return this.zza.equals(((zzjv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzju zzjuVar, Object obj) {
        if (zzjuVar.zzc()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzjuVar, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            zzd(zzjuVar, obj);
        }
        if (obj instanceof zzkq) {
            this.zzd = true;
        }
        this.zza.put(zzjuVar, obj);
    }

    private zzjv(boolean z) {
        zzb();
        zzb();
    }
}
