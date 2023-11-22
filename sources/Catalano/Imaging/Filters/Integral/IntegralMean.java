package Catalano.Imaging.Filters.Integral;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class IntegralMean implements IApplyInPlace {
    private int getAuthRequestContext;

    public IntegralMean() {
        this((byte) 0);
    }

    private IntegralMean(byte b) {
        this.getAuthRequestContext = Math.max(1, 1);
    }
}
