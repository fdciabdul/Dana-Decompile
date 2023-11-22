package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
final class zzep {
    private static final zzep zzb = new zzep(true);
    final zzgu zza = new zzgk(16);
    private boolean zzc;
    private boolean zzd;

    private zzep() {
    }

    public static zzep zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.auth.zzeo r3, java.lang.Object r4) {
        /*
            com.google.android.gms.internal.auth.zzhn r0 = r3.zzb()
            com.google.android.gms.internal.auth.zzez.zze(r4)
            com.google.android.gms.internal.auth.zzhn r1 = com.google.android.gms.internal.auth.zzhn.DOUBLE
            com.google.android.gms.internal.auth.zzho r1 = com.google.android.gms.internal.auth.zzho.INT
            com.google.android.gms.internal.auth.zzho r0 = r0.zza()
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
            boolean r0 = r4 instanceof com.google.android.gms.internal.auth.zzfw
            if (r0 != 0) goto L45
            boolean r0 = r4 instanceof com.google.android.gms.internal.auth.zzfb
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r4 instanceof com.google.android.gms.internal.auth.zzew
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r4 instanceof com.google.android.gms.internal.auth.zzee
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
            com.google.android.gms.internal.auth.zzhn r3 = r3.zzb()
            com.google.android.gms.internal.auth.zzho r3 = r3.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzep.zzd(com.google.android.gms.internal.auth.zzeo, java.lang.Object):void");
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzep zzepVar = new zzep();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzepVar.zzc((zzeo) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzepVar.zzc((zzeo) entry.getKey(), entry.getValue());
        }
        zzepVar.zzd = this.zzd;
        return zzepVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzep) {
            return this.zza.equals(((zzep) obj).zza);
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

    public final void zzc(zzeo zzeoVar, Object obj) {
        if (zzeoVar.zzc()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzeoVar, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            zzd(zzeoVar, obj);
        }
        if (obj instanceof zzfb) {
            this.zzd = true;
        }
        this.zza.put(zzeoVar, obj);
    }

    private zzep(boolean z) {
        zzb();
        zzb();
    }
}
