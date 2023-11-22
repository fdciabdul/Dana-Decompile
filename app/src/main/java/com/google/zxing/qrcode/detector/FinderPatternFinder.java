package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean z2 = false;
        while (i2 < height && !z2) {
            clearCounts(iArr);
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.image.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else {
                    if ((i4 & 1) == 0) {
                        if (i4 == 4) {
                            if (foundPatternCross(iArr)) {
                                if (handlePossibleCenter(iArr, i2, i3)) {
                                    if (this.hasSkipped) {
                                        z2 = haveMultiplyConfirmedCenters();
                                    } else {
                                        int findRowSkip = findRowSkip();
                                        int i5 = iArr[2];
                                        if (findRowSkip > i5) {
                                            i2 += (findRowSkip - i5) - 2;
                                            i3 = width - 1;
                                        }
                                    }
                                    clearCounts(iArr);
                                    i = 2;
                                    i4 = 0;
                                } else {
                                    shiftCounts2(iArr);
                                }
                            } else {
                                shiftCounts2(iArr);
                            }
                            i4 = 3;
                        } else {
                            i4++;
                        }
                    }
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width)) {
                i = iArr[0];
                if (this.hasSkipped) {
                    z2 = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - iArr[0]) < f2 && Math.abs(f - iArr[1]) < f2) {
            if (Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2 && Math.abs(f - iArr[3]) < f2 && Math.abs(f - iArr[4]) < f2) {
                return true;
            }
        }
        return false;
    }

    protected static boolean foundPatternDiagonal(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        if (Math.abs(f - iArr[0]) < f2 && Math.abs(f - iArr[1]) < f2) {
            if (Math.abs((f * 3.0f) - iArr[2]) < 3.0f * f2 && Math.abs(f - iArr[3]) < f2 && Math.abs(f - iArr[4]) < f2) {
                return true;
            }
        }
        return false;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void clearCounts(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean crossCheckDiagonal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= height || (i5 = i2 + i7) >= width || !this.image.get(i5, i8)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= height || (i4 = i2 + i7) >= width || this.image.get(i4, i9)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= height || (i3 = i2 + i7) >= width || !this.image.get(i3, i10)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0080, code lost:
    
        if (r2[3] >= r13) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:
    
        if (r11 >= r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
    
        if (r0.get(r12, r11) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008b, code lost:
    
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
    
        if (r9 >= r13) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008f, code lost:
    
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0096, code lost:
    
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
    
        if (r12 < r13) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b0, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < (r14 * 2)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b2, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b7, code lost:
    
        if (foundPatternCross(r2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bd, code lost:
    
        return centerFromEnd(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float crossCheckVertical(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            com.google.zxing.common.BitMatrix r0 = r10.image
            int r1 = r0.getHeight()
            int[] r2 = r10.getCrossCheckStateCount()
            r3 = r11
        Lb:
            r4 = 2
            r5 = 1
            if (r3 < 0) goto L1d
            boolean r6 = r0.get(r12, r3)
            if (r6 == 0) goto L1d
            r6 = r2[r4]
            int r6 = r6 + r5
            r2[r4] = r6
            int r3 = r3 + (-1)
            goto Lb
        L1d:
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r3 >= 0) goto L22
            return r6
        L22:
            if (r3 < 0) goto L35
            boolean r7 = r0.get(r12, r3)
            if (r7 != 0) goto L35
            r7 = r2[r5]
            if (r7 > r13) goto L35
            int r7 = r7 + 1
            r2[r5] = r7
            int r3 = r3 + (-1)
            goto L22
        L35:
            if (r3 < 0) goto Lbe
            r7 = r2[r5]
            if (r7 > r13) goto Lbe
        L3b:
            r7 = 0
            if (r3 < 0) goto L4f
            boolean r8 = r0.get(r12, r3)
            if (r8 == 0) goto L4f
            r8 = r2[r7]
            if (r8 > r13) goto L4f
            int r8 = r8 + 1
            r2[r7] = r8
            int r3 = r3 + (-1)
            goto L3b
        L4f:
            r3 = r2[r7]
            if (r3 <= r13) goto L54
            return r6
        L54:
            int r11 = r11 + r5
        L55:
            if (r11 >= r1) goto L65
            boolean r3 = r0.get(r12, r11)
            if (r3 == 0) goto L65
            r3 = r2[r4]
            int r3 = r3 + r5
            r2[r4] = r3
            int r11 = r11 + 1
            goto L55
        L65:
            if (r11 != r1) goto L68
            return r6
        L68:
            r3 = 3
            if (r11 >= r1) goto L7c
            boolean r8 = r0.get(r12, r11)
            if (r8 != 0) goto L7c
            r8 = r2[r3]
            if (r8 >= r13) goto L7c
            int r8 = r8 + 1
            r2[r3] = r8
            int r11 = r11 + 1
            goto L68
        L7c:
            if (r11 == r1) goto Lbe
            r8 = r2[r3]
            if (r8 >= r13) goto Lbe
        L82:
            r8 = 4
            if (r11 >= r1) goto L96
            boolean r9 = r0.get(r12, r11)
            if (r9 == 0) goto L96
            r9 = r2[r8]
            if (r9 >= r13) goto L96
            int r9 = r9 + 1
            r2[r8] = r9
            int r11 = r11 + 1
            goto L82
        L96:
            r12 = r2[r8]
            if (r12 < r13) goto L9b
            return r6
        L9b:
            r13 = r2[r7]
            r0 = r2[r5]
            r1 = r2[r4]
            r3 = r2[r3]
            int r13 = r13 + r0
            int r13 = r13 + r1
            int r13 = r13 + r3
            int r13 = r13 + r12
            int r13 = r13 - r14
            int r12 = java.lang.Math.abs(r13)
            int r12 = r12 * 5
            int r14 = r14 * 2
            if (r12 < r14) goto Lb3
            return r6
        Lb3:
            boolean r12 = foundPatternCross(r2)
            if (r12 == 0) goto Lbe
            float r11 = centerFromEnd(r2, r11)
            return r11
        Lbe:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.crossCheckVertical(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0080, code lost:
    
        if (r2[3] >= r13) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:
    
        if (r11 >= r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
    
        if (r0.get(r11, r12) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008b, code lost:
    
        r9 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
    
        if (r9 >= r13) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008f, code lost:
    
        r2[4] = r9 + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0096, code lost:
    
        r12 = r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
    
        if (r12 < r13) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r12) - r14) * 5) < r14) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b5, code lost:
    
        if (foundPatternCross(r2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bb, code lost:
    
        return centerFromEnd(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float crossCheckHorizontal(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            com.google.zxing.common.BitMatrix r0 = r10.image
            int r1 = r0.getWidth()
            int[] r2 = r10.getCrossCheckStateCount()
            r3 = r11
        Lb:
            r4 = 2
            r5 = 1
            if (r3 < 0) goto L1d
            boolean r6 = r0.get(r3, r12)
            if (r6 == 0) goto L1d
            r6 = r2[r4]
            int r6 = r6 + r5
            r2[r4] = r6
            int r3 = r3 + (-1)
            goto Lb
        L1d:
            r6 = 2143289344(0x7fc00000, float:NaN)
            if (r3 >= 0) goto L22
            return r6
        L22:
            if (r3 < 0) goto L35
            boolean r7 = r0.get(r3, r12)
            if (r7 != 0) goto L35
            r7 = r2[r5]
            if (r7 > r13) goto L35
            int r7 = r7 + 1
            r2[r5] = r7
            int r3 = r3 + (-1)
            goto L22
        L35:
            if (r3 < 0) goto Lbc
            r7 = r2[r5]
            if (r7 > r13) goto Lbc
        L3b:
            r7 = 0
            if (r3 < 0) goto L4f
            boolean r8 = r0.get(r3, r12)
            if (r8 == 0) goto L4f
            r8 = r2[r7]
            if (r8 > r13) goto L4f
            int r8 = r8 + 1
            r2[r7] = r8
            int r3 = r3 + (-1)
            goto L3b
        L4f:
            r3 = r2[r7]
            if (r3 <= r13) goto L54
            return r6
        L54:
            int r11 = r11 + r5
        L55:
            if (r11 >= r1) goto L65
            boolean r3 = r0.get(r11, r12)
            if (r3 == 0) goto L65
            r3 = r2[r4]
            int r3 = r3 + r5
            r2[r4] = r3
            int r11 = r11 + 1
            goto L55
        L65:
            if (r11 != r1) goto L68
            return r6
        L68:
            r3 = 3
            if (r11 >= r1) goto L7c
            boolean r8 = r0.get(r11, r12)
            if (r8 != 0) goto L7c
            r8 = r2[r3]
            if (r8 >= r13) goto L7c
            int r8 = r8 + 1
            r2[r3] = r8
            int r11 = r11 + 1
            goto L68
        L7c:
            if (r11 == r1) goto Lbc
            r8 = r2[r3]
            if (r8 >= r13) goto Lbc
        L82:
            r8 = 4
            if (r11 >= r1) goto L96
            boolean r9 = r0.get(r11, r12)
            if (r9 == 0) goto L96
            r9 = r2[r8]
            if (r9 >= r13) goto L96
            int r9 = r9 + 1
            r2[r8] = r9
            int r11 = r11 + 1
            goto L82
        L96:
            r12 = r2[r8]
            if (r12 < r13) goto L9b
            return r6
        L9b:
            r13 = r2[r7]
            r0 = r2[r5]
            r1 = r2[r4]
            r3 = r2[r3]
            int r13 = r13 + r0
            int r13 = r13 + r1
            int r13 = r13 + r3
            int r13 = r13 + r12
            int r13 = r13 - r14
            int r12 = java.lang.Math.abs(r13)
            int r12 = r12 * 5
            if (r12 < r14) goto Lb1
            return r6
        Lb1:
            boolean r12 = foundPatternCross(r2)
            if (r12 == 0) goto Lbc
            float r11 = centerFromEnd(r2, r11)
            return r11
        Lbc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.crossCheckHorizontal(int, int, int, int):float");
    }

    @Deprecated
    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        return handlePossibleCenter(iArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, centerFromEnd, iArr[2], i3);
        if (!Float.isNaN(crossCheckVertical)) {
            int i4 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i4, iArr[2], i3);
            if (!Float.isNaN(crossCheckHorizontal) && crossCheckDiagonal(i4, (int) crossCheckHorizontal)) {
                float f = i3 / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                        z = true;
                        break;
                    }
                    i5++;
                }
                if (!z) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback = this.resultPointCallback;
                    if (resultPointCallback != null) {
                        resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                f2 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            f += Math.abs(it.next().getEstimatedModuleSize() - f3);
        }
        return f <= f2 * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float f = 0.0f;
        if (size > 3) {
            Iterator<FinderPattern> it = this.possibleCenters.iterator();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it.hasNext()) {
                float estimatedModuleSize = it.next().getEstimatedModuleSize();
                f2 += estimatedModuleSize;
                f3 += estimatedModuleSize * estimatedModuleSize;
            }
            float f4 = f2 / size;
            float sqrt = (float) Math.sqrt((f3 / r0) - (f4 * f4));
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f4));
            float max = Math.max(0.2f * f4, sqrt);
            int i = 0;
            while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f4) > max) {
                    this.possibleCenters.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            Iterator<FinderPattern> it2 = this.possibleCenters.iterator();
            while (it2.hasNext()) {
                f += it2.next().getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(f / this.possibleCenters.size()));
            List<FinderPattern> list = this.possibleCenters;
            list.subList(3, list.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public final int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.getEstimatedModuleSize() - this.average), Math.abs(finderPattern.getEstimatedModuleSize() - this.average));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        @Override // java.util.Comparator
        public final int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            int compare = Integer.compare(finderPattern2.getCount(), finderPattern.getCount());
            return compare == 0 ? Float.compare(Math.abs(finderPattern.getEstimatedModuleSize() - this.average), Math.abs(finderPattern2.getEstimatedModuleSize() - this.average)) : compare;
        }
    }
}
