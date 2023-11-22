package com.otaliastudios.cameraview.internal.utils;

import com.otaliastudios.cameraview.size.Size;

@Deprecated
/* loaded from: classes8.dex */
public class RotationHelper {
    public static byte[] BuiltInFictitiousFunctionClassFactory(byte[] bArr, Size size, int i) {
        if (i == 0) {
            return bArr;
        }
        if (i % 90 != 0 || i < 0 || i > 270) {
            throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
        }
        int i2 = size.BuiltInFictitiousFunctionClassFactory;
        int i3 = size.getAuthRequestContext;
        byte[] bArr2 = new byte[bArr.length];
        int i4 = i2 * i3;
        boolean z = i % 180 != 0;
        boolean z2 = i % 270 != 0;
        boolean z3 = i >= 180;
        for (int i5 = 0; i5 < i3; i5++) {
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = ((i5 >> 1) * i2) + i4 + (i6 & (-2));
                int i8 = z ? i3 : i2;
                int i9 = z ? i2 : i3;
                int i10 = z ? i5 : i6;
                int i11 = z ? i6 : i5;
                if (z2) {
                    i10 = (i8 - i10) - 1;
                }
                if (z3) {
                    i11 = (i9 - i11) - 1;
                }
                int i12 = ((i11 >> 1) * i8) + i4 + (i10 & (-2));
                bArr2[(i11 * i8) + i10] = (byte) (bArr[(i5 * i2) + i6] & 255);
                bArr2[i12] = (byte) (bArr[i7] & 255);
                bArr2[i12 + 1] = (byte) (bArr[i7 + 1] & 255);
            }
        }
        return bArr2;
    }
}
