package com.mixpanel.android.util;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* loaded from: classes8.dex */
public class StackBlurManager {
    public static void BuiltInFictitiousFunctionClassFactory(Bitmap bitmap) {
        int i;
        int[] iArr;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int[] iArr7 = new int[112896];
        for (int i5 = 0; i5 < 112896; i5++) {
            iArr7[i5] = i5 / 441;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(Integer.TYPE, 41, 3);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= height) {
                break;
            }
            int i9 = -20;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 20; i9 <= i19; i19 = 20) {
                int i20 = height;
                int i21 = iArr2[Math.min(i3, Math.max(i9, 0)) + i7];
                int[] iArr9 = iArr8[i9 + 20];
                iArr9[0] = (i21 & 16711680) >> 16;
                iArr9[1] = (i21 & 65280) >> 8;
                iArr9[2] = i21 & 255;
                int abs = 21 - Math.abs(i9);
                int i22 = iArr9[0];
                i13 += i22 * abs;
                int i23 = iArr9[1];
                i14 += i23 * abs;
                int i24 = iArr9[2];
                i12 += abs * i24;
                if (i9 > 0) {
                    i11 += i22;
                    i10 += i23;
                    i18 += i24;
                } else {
                    i15 += i22;
                    i16 += i23;
                    i17 += i24;
                }
                i9++;
                height = i20;
            }
            int i25 = height;
            int i26 = 20;
            int i27 = 0;
            while (i27 < width) {
                iArr3[i7] = iArr7[i13];
                iArr4[i7] = iArr7[i14];
                iArr5[i7] = iArr7[i12];
                int[] iArr10 = iArr8[((i26 - 20) + 41) % 41];
                int i28 = iArr10[0];
                int i29 = iArr10[1];
                int i30 = iArr10[2];
                if (i6 == 0) {
                    iArr = iArr7;
                    iArr6[i27] = Math.min(i27 + 20 + 1, i3);
                } else {
                    iArr = iArr7;
                }
                int i31 = iArr2[iArr6[i27] + i8];
                int i32 = (i31 & 16711680) >> 16;
                iArr10[0] = i32;
                int i33 = (i31 & 65280) >> 8;
                iArr10[1] = i33;
                int i34 = i31 & 255;
                iArr10[2] = i34;
                int i35 = i11 + i32;
                int i36 = i10 + i33;
                int i37 = i18 + i34;
                i13 = (i13 - i15) + i35;
                i14 = (i14 - i16) + i36;
                i12 = (i12 - i17) + i37;
                i26 = (i26 + 1) % 41;
                int[] iArr11 = iArr8[i26 % 41];
                int i38 = iArr11[0];
                i15 = (i15 - i28) + i38;
                int i39 = iArr11[1];
                i16 = (i16 - i29) + i39;
                int i40 = iArr11[2];
                i17 = (i17 - i30) + i40;
                i11 = i35 - i38;
                i10 = i36 - i39;
                i18 = i37 - i40;
                i7++;
                i27++;
                iArr7 = iArr;
            }
            i8 += width;
            i6++;
            height = i25;
        }
        int[] iArr12 = iArr7;
        int i41 = height;
        int i42 = 0;
        while (i42 < width) {
            int i43 = width * (-20);
            int[] iArr13 = iArr6;
            int[] iArr14 = iArr2;
            int i44 = -20;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            for (int i54 = 20; i44 <= i54; i54 = 20) {
                int max = Math.max(0, i43) + i42;
                int[] iArr15 = iArr8[i44 + 20];
                iArr15[0] = iArr3[max];
                iArr15[1] = iArr4[max];
                iArr15[2] = iArr5[max];
                int abs2 = 21 - Math.abs(i44);
                i46 += iArr3[max] * abs2;
                i47 += iArr4[max] * abs2;
                i48 += iArr5[max] * abs2;
                if (i44 > 0) {
                    i45 += iArr15[0];
                    i52 += iArr15[1];
                    i53 += iArr15[2];
                } else {
                    i49 += iArr15[0];
                    i50 += iArr15[1];
                    i51 += iArr15[2];
                }
                if (i44 < i4) {
                    i43 += width;
                }
                i44++;
            }
            int i55 = i42;
            int i56 = i41;
            int i57 = 0;
            int i58 = 20;
            while (i57 < i56) {
                iArr14[i55] = (iArr12[i46] << 16) | (-16777216) | (iArr12[i47] << 8) | iArr12[i48];
                int[] iArr16 = iArr8[((i58 - 20) + 41) % 41];
                int i59 = iArr16[0];
                int i60 = iArr16[1];
                int i61 = iArr16[2];
                if (i42 == 0) {
                    i = i56;
                    iArr13[i57] = Math.min(i57 + 21, i4) * width;
                } else {
                    i = i56;
                }
                int i62 = iArr13[i57] + i42;
                int i63 = iArr3[i62];
                iArr16[0] = i63;
                int i64 = iArr4[i62];
                iArr16[1] = i64;
                int i65 = iArr5[i62];
                iArr16[2] = i65;
                int i66 = i45 + i63;
                int i67 = i52 + i64;
                int i68 = i53 + i65;
                i46 = (i46 - i49) + i66;
                i47 = (i47 - i50) + i67;
                i48 = (i48 - i51) + i68;
                i58 = (i58 + 1) % 41;
                int[] iArr17 = iArr8[i58];
                int i69 = iArr17[0];
                i49 = (i49 - i59) + i69;
                int i70 = iArr17[1];
                i50 = (i50 - i60) + i70;
                int i71 = iArr17[2];
                i51 = (i51 - i61) + i71;
                i45 = i66 - i69;
                i52 = i67 - i70;
                i53 = i68 - i71;
                i55 += width;
                i57++;
                i56 = i;
            }
            i41 = i56;
            i42++;
            iArr6 = iArr13;
            iArr2 = iArr14;
        }
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i41);
    }
}
