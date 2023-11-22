package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzdp extends zzdr {
    private final String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdp(String str) {
        this.zza = str;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        int length;
        int length2;
        zzdr zzdrVar = (zzdr) obj;
        if (zzd((byte) 96) != zzdrVar.zza()) {
            length2 = zzdrVar.zza();
            length = zzd((byte) 96);
        } else {
            String str = this.zza;
            int length3 = str.length();
            String str2 = ((zzdp) zzdrVar).zza;
            if (length3 == str2.length()) {
                return str.compareTo(str2);
            }
            length = str.length();
            length2 = str2.length();
        }
        return length - length2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzdp) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) 96)), this.zza});
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzd((byte) 96);
    }
}
