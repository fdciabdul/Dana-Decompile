package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
final class zzdv extends zzch {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {75, 108, -123, 87, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 76;
    private final com.google.android.gms.measurement.internal.zzgz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(com.google.android.gms.measurement.internal.zzgz zzgzVar) {
        this.zza = zzgzVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 15
            int r7 = 18 - r7
            int r6 = r6 + 105
            byte[] r0 = com.google.android.gms.internal.measurement.zzdv.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 2
            int r8 = 16 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdv.a(int, byte, short, java.lang.Object[]):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        try {
            Object[] objArr = {this.zza};
            byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr3 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr3);
            return ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.onEvent(str, str2, bundle, j);
    }
}
