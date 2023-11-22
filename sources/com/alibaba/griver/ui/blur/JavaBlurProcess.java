package com.alibaba.griver.ui.blur;

import android.graphics.Bitmap;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class JavaBlurProcess implements BlurProcess {

    /* renamed from: a  reason: collision with root package name */
    private static final short[] f6705a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    private static final byte[] b = {9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN};

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i3;
        int i9 = i7 - 1;
        int i10 = i2 - 1;
        int i11 = (i8 * 2) + 1;
        short s = f6705a[i8];
        byte b2 = b[i8];
        int[] iArr2 = new int[i11];
        if (i6 == 1) {
            int i12 = (i5 * i2) / i4;
            int i13 = ((i5 + 1) * i2) / i4;
            while (i12 < i13) {
                int i14 = i7 * i12;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                int i15 = 0;
                while (i15 <= i8) {
                    iArr2[i15] = iArr[i14];
                    int i16 = iArr[i14];
                    i15++;
                    int i17 = (i16 >>> 16) & 255;
                    j += i17 * i15;
                    int i18 = (i16 >>> 8) & 255;
                    j2 += i18 * i15;
                    j3 += r7 * i15;
                    j4 += i17;
                    j5 += i18;
                    j6 += i16 & 255;
                }
                int i19 = i14;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                int i20 = 1;
                while (i20 <= i8) {
                    if (i20 <= i9) {
                        i19++;
                    }
                    iArr2[i20 + i8] = iArr[i19];
                    int i21 = i13;
                    int i22 = iArr[i19];
                    int i23 = (i8 + 1) - i20;
                    int i24 = i19;
                    int i25 = (i22 >>> 16) & 255;
                    int i26 = i12;
                    j += i25 * i23;
                    int i27 = (i22 >>> 8) & 255;
                    j2 += i27 * i23;
                    j3 += r5 * i23;
                    j8 += i25;
                    j7 += i27;
                    j9 += i22 & 255;
                    i20++;
                    i13 = i21;
                    i19 = i24;
                    i12 = i26;
                    b2 = b2;
                    iArr2 = iArr2;
                }
                int i28 = i12;
                int i29 = i13;
                byte b3 = b2;
                int[] iArr3 = iArr2;
                int i30 = i8 > i9 ? i9 : i8;
                int i31 = i30 + i14;
                int i32 = i8;
                int i33 = 0;
                while (i33 < i7) {
                    long j10 = j7;
                    long j11 = s;
                    iArr[i14] = (int) ((((j11 * j3) >>> b3) & 255) | (iArr[i14] & (-16777216)) | ((((j * j11) >>> b3) & 255) << 16) | ((((j11 * j2) >>> b3) & 255) << 8));
                    int i34 = (i32 + i11) - i8;
                    if (i34 >= i11) {
                        i34 -= i11;
                    }
                    int i35 = iArr3[i34];
                    long j12 = (i35 >>> 16) & 255;
                    short s2 = s;
                    int i36 = i14;
                    long j13 = (i35 >>> 8) & 255;
                    int i37 = i35 & 255;
                    int i38 = i33;
                    long j14 = i37;
                    if (i30 < i9) {
                        i31++;
                        i30++;
                    }
                    iArr3[i34] = iArr[i31];
                    int i39 = iArr[i31];
                    int i40 = i30;
                    int i41 = i9;
                    long j15 = j8 + ((i39 >>> 16) & 255);
                    long j16 = j10 + ((i39 >>> 8) & 255);
                    long j17 = j9 + (i39 & 255);
                    j = (j - j4) + j15;
                    j2 = (j2 - j5) + j16;
                    j3 = (j3 - j6) + j17;
                    i32++;
                    if (i32 >= i11) {
                        i32 = 0;
                    }
                    int i42 = iArr3[i32];
                    long j18 = (i42 >>> 16) & 255;
                    j4 = (j4 - j12) + j18;
                    long j19 = j5 - j13;
                    long j20 = (i42 >>> 8) & 255;
                    j5 = j19 + j20;
                    long j21 = j6 - j14;
                    long j22 = i42 & 255;
                    j6 = j21 + j22;
                    j8 = j15 - j18;
                    j7 = j16 - j20;
                    i14 = i36 + 1;
                    j9 = j17 - j22;
                    i33 = i38 + 1;
                    s = s2;
                    i30 = i40;
                    i9 = i41;
                    i7 = i;
                }
                i12 = i28 + 1;
                i7 = i;
                i13 = i29;
                b2 = b3;
                iArr2 = iArr3;
            }
            return;
        }
        short s3 = s;
        if (i6 == 2) {
            int i43 = (i5 * i) / i4;
            int i44 = ((i5 + 1) * i) / i4;
            while (i43 < i44) {
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                long j26 = 0;
                long j27 = 0;
                long j28 = 0;
                int i45 = 0;
                while (i45 <= i8) {
                    iArr2[i45] = iArr[i43];
                    int i46 = iArr[i43];
                    i45++;
                    int i47 = i44;
                    int i48 = i43;
                    long j29 = j23 + (r4 * i45);
                    j24 += r0 * i45;
                    j25 += r1 * i45;
                    j26 += (i46 >>> 16) & 255;
                    j27 += (i46 >>> 8) & 255;
                    j28 += i46 & 255;
                    i44 = i47;
                    j23 = j29;
                    i11 = i11;
                    i43 = i48;
                }
                int i49 = i43;
                int i50 = i44;
                int i51 = i11;
                long j30 = 0;
                long j31 = 0;
                long j32 = 0;
                int i52 = i49;
                int i53 = 1;
                while (i53 <= i8) {
                    if (i53 <= i10) {
                        i52 += i;
                    }
                    iArr2[i53 + i8] = iArr[i52];
                    long j33 = j26;
                    int i54 = iArr[i52];
                    int i55 = (i8 + 1) - i53;
                    int i56 = i52;
                    long j34 = j30;
                    j23 += r1 * i55;
                    int i57 = (i54 >>> 8) & 255;
                    j24 += i57 * i55;
                    j25 += i55 * r3;
                    j31 += (i54 >>> 16) & 255;
                    j32 += i54 & 255;
                    i53++;
                    j26 = j33;
                    j30 = j34 + i57;
                    i52 = i56;
                    i8 = i3;
                }
                int i58 = i8;
                long j35 = j30;
                long j36 = j26;
                int i59 = i58 > i10 ? i10 : i58;
                int i60 = (i59 * i) + i49;
                int i61 = i2;
                int i62 = i49;
                long j37 = j35;
                int i63 = 0;
                int i64 = i58;
                while (i63 < i61) {
                    int i65 = i63;
                    long j38 = j37;
                    short s4 = s3;
                    long j39 = j31;
                    long j40 = s4;
                    iArr[i62] = (int) ((((j40 * j25) >>> b2) & 255) | ((((j40 * j24) >>> b2) & 255) << 8) | (iArr[i62] & (-16777216)) | ((((j23 * j40) >>> b2) & 255) << 16));
                    i62 += i;
                    int i66 = (i64 + i51) - i58;
                    int i67 = i51;
                    if (i66 >= i67) {
                        i66 -= i67;
                    }
                    int i68 = iArr2[i66];
                    int i69 = i10;
                    long j41 = (i68 >>> 16) & 255;
                    long j42 = (i68 >>> 8) & 255;
                    long j43 = i68 & 255;
                    if (i59 < i69) {
                        i60 += i;
                        i59++;
                    }
                    iArr2[i66] = iArr[i60];
                    int i70 = iArr[i60];
                    int i71 = i59;
                    long j44 = j39 + ((i70 >>> 16) & 255);
                    int i72 = i60;
                    long j45 = j38 + ((i70 >>> 8) & 255);
                    long j46 = (i70 & 255) + j32;
                    long j47 = (j23 - j36) + j44;
                    long j48 = (j24 - j27) + j45;
                    j25 = (j25 - j28) + j46;
                    int i73 = i64 + 1;
                    i64 = i73 >= i67 ? 0 : i73;
                    int i74 = iArr2[i64];
                    long j49 = (i74 >>> 16) & 255;
                    long j50 = j27 - j42;
                    long j51 = (i74 >>> 8) & 255;
                    j27 = j50 + j51;
                    long j52 = i74 & 255;
                    j28 = (j28 - j43) + j52;
                    j37 = j45 - j51;
                    i63 = i65 + 1;
                    i61 = i2;
                    j23 = j47;
                    j36 = (j36 - j41) + j49;
                    i60 = i72;
                    s3 = s4;
                    j24 = j48;
                    j32 = j46 - j52;
                    i10 = i69;
                    j31 = j44 - j49;
                    i59 = i71;
                    i51 = i67;
                    i58 = i3;
                }
                i43 = i49 + 1;
                i8 = i3;
                i44 = i50;
                i11 = i51;
            }
        }
    }

    @Override // com.alibaba.griver.ui.blur.BlurProcess
    public Bitmap blur(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(2);
        int i = 0;
        for (int i2 = 2; i < i2; i2 = 2) {
            int i3 = (int) f;
            int i4 = i;
            arrayList.add(new BlurTask(iArr, width, height, i3, 2, i4, 1));
            arrayList2.add(new BlurTask(iArr, width, height, i3, 2, i4, 2));
            i++;
        }
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }

    /* loaded from: classes6.dex */
    static class BlurTask implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f6706a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public BlurTask(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f6706a = iArr;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            JavaBlurProcess.a(this.f6706a, this.b, this.c, this.d, this.e, this.f, this.g);
            return null;
        }
    }
}
