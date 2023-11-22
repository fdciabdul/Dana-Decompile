package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* loaded from: classes3.dex */
public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkAndNudgePoints(com.google.zxing.common.BitMatrix r9, float[] r10) throws com.google.zxing.NotFoundException {
        /*
            int r0 = r9.getWidth()
            int r9 = r9.getHeight()
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        Lc:
            int r5 = r10.length
            r6 = 0
            r7 = -1
            if (r3 >= r5) goto L47
            if (r4 == 0) goto L47
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L42
            if (r4 > r0) goto L42
            if (r8 < r7) goto L42
            if (r8 > r9) goto L42
            if (r4 != r7) goto L28
            r10[r3] = r6
            goto L2f
        L28:
            if (r4 != r0) goto L31
            int r4 = r0 + (-1)
            float r4 = (float) r4
            r10[r3] = r4
        L2f:
            r4 = 1
            goto L32
        L31:
            r4 = 0
        L32:
            if (r8 != r7) goto L37
            r10[r5] = r6
            goto L3e
        L37:
            if (r8 != r9) goto L3f
            int r4 = r9 + (-1)
            float r4 = (float) r4
            r10[r5] = r4
        L3e:
            r4 = 1
        L3f:
            int r3 = r3 + 2
            goto Lc
        L42:
            com.google.zxing.NotFoundException r9 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r9
        L47:
            int r3 = r10.length
            int r3 = r3 + (-2)
            r4 = 1
        L4b:
            if (r3 < 0) goto L83
            if (r4 == 0) goto L83
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L7e
            if (r4 > r0) goto L7e
            if (r8 < r7) goto L7e
            if (r8 > r9) goto L7e
            if (r4 != r7) goto L64
            r10[r3] = r6
            goto L6b
        L64:
            if (r4 != r0) goto L6d
            int r4 = r0 + (-1)
            float r4 = (float) r4
            r10[r3] = r4
        L6b:
            r4 = 1
            goto L6e
        L6d:
            r4 = 0
        L6e:
            if (r8 != r7) goto L73
            r10[r5] = r6
            goto L7a
        L73:
            if (r8 != r9) goto L7b
            int r4 = r9 + (-1)
            float r4 = (float) r4
            r10[r5] = r4
        L7a:
            r4 = 1
        L7b:
            int r3 = r3 + (-2)
            goto L4b
        L7e:
            com.google.zxing.NotFoundException r9 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r9
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.GridSampler.checkAndNudgePoints(com.google.zxing.common.BitMatrix, float[]):void");
    }
}
