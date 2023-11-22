package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
/* loaded from: classes7.dex */
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public final ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int max = Math.max(1, height / 256);
        int max2 = Math.max(1, width / 256);
        int i3 = -max;
        int i4 = i2 / 2;
        int y = ((int) findCornerFromCenter(i2, 0, 0, width, i, i3, 0, height, i4).getY()) - 1;
        int i5 = i / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i2, -max2, 0, width, i, 0, y, height, i5);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i2, max2, x, width, i, 0, y, height, i5);
        int x2 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i2, 0, x, x2, i, max, y, height, i4);
        return new ResultPoint[]{findCornerFromCenter(i2, 0, x, x2, i, i3, y, ((int) findCornerFromCenter3.getY()) + 1, i2 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int[] blackWhiteRange;
        int[] iArr = null;
        int i10 = i;
        int i11 = i5;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            if (i2 == 0) {
                blackWhiteRange = blackWhiteRange(i11, i9, i3, i4, true);
            } else {
                blackWhiteRange = blackWhiteRange(i10, i9, i7, i8, false);
            }
            if (blackWhiteRange == null) {
                if (iArr != null) {
                    if (i2 == 0) {
                        int i12 = i11 - i6;
                        if (iArr[0] < i) {
                            if (iArr[1] > i) {
                                return new ResultPoint(iArr[i6 > 0 ? (char) 0 : (char) 1], i12);
                            }
                            return new ResultPoint(iArr[0], i12);
                        }
                        return new ResultPoint(iArr[1], i12);
                    }
                    int i13 = i10 - i2;
                    if (iArr[0] < i5) {
                        if (iArr[1] > i5) {
                            return new ResultPoint(i13, iArr[i2 < 0 ? (char) 0 : (char) 1]);
                        }
                        return new ResultPoint(i13, iArr[0]);
                    }
                    return new ResultPoint(i13, iArr[1]);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            i11 += i6;
            i10 += i2;
            iArr = blackWhiteRange;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:23:0x0031 BREAK  A[LOOP:1: B:14:0x001d->B:72:0x001d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0065 A[EDGE_INSN: B:85:0x0065->B:47:0x0065 BREAK  A[LOOP:3: B:38:0x0051->B:90:0x0051], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] blackWhiteRange(int r7, int r8, int r9, int r10, boolean r11) {
        /*
            r6 = this;
            int r0 = r9 + r10
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            r3 = 1
            if (r2 < r9) goto L39
            com.google.zxing.common.BitMatrix r4 = r6.image
            if (r11 == 0) goto L13
            boolean r4 = r4.get(r2, r7)
            if (r4 == 0) goto L1c
            goto L19
        L13:
            boolean r4 = r4.get(r7, r2)
            if (r4 == 0) goto L1c
        L19:
            int r2 = r2 + (-1)
            goto L5
        L1c:
            r4 = r2
        L1d:
            int r4 = r4 - r3
            if (r4 < r9) goto L31
            com.google.zxing.common.BitMatrix r5 = r6.image
            if (r11 == 0) goto L2b
            boolean r5 = r5.get(r4, r7)
            if (r5 == 0) goto L1d
            goto L31
        L2b:
            boolean r5 = r5.get(r7, r4)
            if (r5 == 0) goto L1d
        L31:
            if (r4 < r9) goto L39
            int r5 = r2 - r4
            if (r5 > r8) goto L39
            r2 = r4
            goto L5
        L39:
            int r2 = r2 + r3
        L3a:
            if (r0 >= r10) goto L6d
            com.google.zxing.common.BitMatrix r9 = r6.image
            if (r11 == 0) goto L47
            boolean r9 = r9.get(r0, r7)
            if (r9 == 0) goto L50
            goto L4d
        L47:
            boolean r9 = r9.get(r7, r0)
            if (r9 == 0) goto L50
        L4d:
            int r0 = r0 + 1
            goto L3a
        L50:
            r9 = r0
        L51:
            int r9 = r9 + r3
            if (r9 >= r10) goto L65
            com.google.zxing.common.BitMatrix r4 = r6.image
            if (r11 == 0) goto L5f
            boolean r4 = r4.get(r9, r7)
            if (r4 == 0) goto L51
            goto L65
        L5f:
            boolean r4 = r4.get(r7, r9)
            if (r4 == 0) goto L51
        L65:
            if (r9 >= r10) goto L6d
            int r4 = r9 - r0
            if (r4 > r8) goto L6d
            r0 = r9
            goto L3a
        L6d:
            int r0 = r0 - r3
            if (r0 <= r2) goto L78
            int[] r7 = new int[r1]
            r8 = 0
            r7[r8] = r2
            r7[r3] = r0
            return r7
        L78:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.blackWhiteRange(int, int, int, int, boolean):int[]");
    }
}
