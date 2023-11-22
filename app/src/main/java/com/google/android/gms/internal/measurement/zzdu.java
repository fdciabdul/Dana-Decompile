package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
final class zzdu extends zzch {
    private final com.google.android.gms.measurement.internal.zzgy zza;
    public static final byte[] PlaceComponentResult = {61, 16, -46, 32, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 148;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(com.google.android.gms.measurement.internal.zzgy zzgyVar) {
        this.zza = zzgyVar;
    }

    private static void a(byte b, int i, short s, Object[] objArr) {
        int i2 = s + 4;
        int i3 = (i * 3) + 16;
        byte[] bArr = PlaceComponentResult;
        int i4 = 106 - b;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4 = i6 + i4 + 2;
            i6 = i6;
            i2 = i2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i4;
            int i8 = i2 + 1;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i6;
            i4 = i4 + bArr[i8] + 2;
            i6 = i9;
            i2 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        try {
            Object[] objArr = {this.zza};
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            Object[] objArr3 = new Object[1];
            a(b3, (byte) (b3 - 1), PlaceComponentResult[5], objArr3);
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
        this.zza.interceptEvent(str, str2, bundle, j);
    }
}
