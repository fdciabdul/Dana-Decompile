package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzdo extends zzdr {
    private final int zza;
    private final zzbg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdo(zzbg zzbgVar) throws zzdh {
        zzbgVar.getClass();
        this.zzb = zzbgVar;
        zzcb it = zzbgVar.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int zzb = ((zzdr) entry.getKey()).zzb();
            i = i < zzb ? zzb : i;
            int zzb2 = ((zzdr) entry.getValue()).zzb();
            if (i < zzb2) {
                i = zzb2;
            }
        }
        int i2 = i + 1;
        this.zza = i2;
        if (i2 > 4) {
            throw new zzdh("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        int compareTo;
        int size;
        int size2;
        zzdr zzdrVar = (zzdr) obj;
        if (zzd((byte) -96) != zzdrVar.zza()) {
            size2 = zzdrVar.zza();
            size = zzd((byte) -96);
        } else {
            zzdo zzdoVar = (zzdo) zzdrVar;
            if (this.zzb.size() != zzdoVar.zzb.size()) {
                size = this.zzb.size();
                size2 = zzdoVar.zzb.size();
            } else {
                zzcb it = this.zzb.entrySet().iterator();
                zzcb it2 = zzdoVar.zzb.entrySet().iterator();
                do {
                    if (!it.hasNext() && !it2.hasNext()) {
                        return 0;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    int compareTo2 = ((zzdr) entry.getKey()).compareTo((zzdr) entry2.getKey());
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    compareTo = ((zzdr) entry.getValue()).compareTo((zzdr) entry2.getValue());
                } while (compareTo == 0);
                return compareTo;
            }
        }
        return size - size2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zzb.equals(((zzdo) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) -96)), this.zzb});
    }

    public final String toString() {
        if (this.zzb.isEmpty()) {
            return "{}";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzcb it = this.zzb.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((zzdr) entry.getKey()).toString().replace("\n", "\n  "), ((zzdr) entry.getValue()).toString().replace("\n", "\n  "));
        }
        zzag zza = zzag.zza(",\n  ");
        StringBuilder sb = new StringBuilder("{\n  ");
        try {
            zzaf.zza(sb, linkedHashMap.entrySet().iterator(), zza, " : ");
            sb.append("\n}");
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzd((byte) -96);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zzb() {
        return this.zza;
    }

    public final zzbg zzc() {
        return this.zzb;
    }
}
