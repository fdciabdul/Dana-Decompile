package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

/* loaded from: classes3.dex */
public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.value = i;
        this.startEnd = iArr;
        float f = i2;
        float f2 = i4;
        this.resultPoints = new ResultPoint[]{new ResultPoint(f, f2), new ResultPoint(i3, f2)};
    }

    public final int getValue() {
        return this.value;
    }

    public final int[] getStartEnd() {
        return this.startEnd;
    }

    public final ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value;
    }

    public final int hashCode() {
        return this.value;
    }
}
