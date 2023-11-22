package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class AlignmentPatternFinder {
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final int[] crossCheckStateCount = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f;
        this.resultPointCallback = resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AlignmentPattern find() throws NotFoundException {
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i = this.startX;
        int i2 = this.height;
        int i3 = this.width + i;
        int i4 = this.startY;
        int i5 = i2 / 2;
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i4 + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i;
            while (i8 < i3 && !this.image.get(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i3) {
                if (!this.image.get(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 == 2) {
                    if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i7, i8)) != null) {
                        return handlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                } else {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                }
                i8++;
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i7, i3)) != null) {
                return handlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean foundPatternCross(int[] iArr) {
        float f = this.moduleSize;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        if (r2[1] > r12) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if (r10 >= r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r0.get(r11, r10) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        r6 = r2[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        if (r6 > r12) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0069, code lost:
    
        r2[2] = r6 + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
    
        r11 = r2[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r11 <= r12) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
    
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r11) - r13) * 5) < (r13 * 2)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0086, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (foundPatternCross(r2) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0091, code lost:
    
        return centerFromEnd(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float crossCheckVertical(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            com.google.zxing.common.BitMatrix r0 = r9.image
            int r1 = r0.getHeight()
            int[] r2 = r9.crossCheckStateCount
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = r10
        L12:
            if (r6 < 0) goto L25
            boolean r7 = r0.get(r11, r6)
            if (r7 == 0) goto L25
            r7 = r2[r4]
            if (r7 > r12) goto L25
            int r7 = r7 + 1
            r2[r4] = r7
            int r6 = r6 + (-1)
            goto L12
        L25:
            r7 = 2143289344(0x7fc00000, float:NaN)
            if (r6 < 0) goto L92
            r8 = r2[r4]
            if (r8 > r12) goto L92
        L2d:
            if (r6 < 0) goto L40
            boolean r8 = r0.get(r11, r6)
            if (r8 != 0) goto L40
            r8 = r2[r3]
            if (r8 > r12) goto L40
            int r8 = r8 + 1
            r2[r3] = r8
            int r6 = r6 + (-1)
            goto L2d
        L40:
            r6 = r2[r3]
            if (r6 <= r12) goto L45
            return r7
        L45:
            int r10 = r10 + r4
            if (r10 >= r1) goto L57
            boolean r6 = r0.get(r11, r10)
            if (r6 == 0) goto L57
            r6 = r2[r4]
            if (r6 > r12) goto L57
            int r6 = r6 + 1
            r2[r4] = r6
            goto L45
        L57:
            if (r10 == r1) goto L92
            r6 = r2[r4]
            if (r6 > r12) goto L92
        L5d:
            if (r10 >= r1) goto L70
            boolean r6 = r0.get(r11, r10)
            if (r6 != 0) goto L70
            r6 = r2[r5]
            if (r6 > r12) goto L70
            int r6 = r6 + 1
            r2[r5] = r6
            int r10 = r10 + 1
            goto L5d
        L70:
            r11 = r2[r5]
            if (r11 <= r12) goto L75
            return r7
        L75:
            r12 = r2[r3]
            r0 = r2[r4]
            int r12 = r12 + r0
            int r12 = r12 + r11
            int r12 = r12 - r13
            int r11 = java.lang.Math.abs(r12)
            int r11 = r11 * 5
            int r13 = r13 * 2
            if (r11 < r13) goto L87
            return r7
        L87:
            boolean r11 = r9.foundPatternCross(r2)
            if (r11 == 0) goto L92
            float r10 = centerFromEnd(r2, r10)
            return r10
        L92:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.AlignmentPatternFinder.crossCheckVertical(int, int, int, int):float");
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i, int i2) {
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[1] * 2, i3 + i4 + i5);
        if (Float.isNaN(crossCheckVertical)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.possibleCenters) {
            if (alignmentPattern.aboutEquals(f, crossCheckVertical, centerFromEnd)) {
                return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f);
        this.possibleCenters.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
            return null;
        }
        return null;
    }
}
