package Catalano.Imaging.Filters;

import Catalano.Core.DoubleRange;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class RandomConvolution implements IApplyInPlace {
    private DoubleRange KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private int getAuthRequestContext;

    public RandomConvolution() {
        this((byte) 0);
    }

    private RandomConvolution(byte b) {
        this(new DoubleRange(-2.5d, 2.5d));
    }

    private RandomConvolution(DoubleRange doubleRange) {
        this(3, doubleRange);
    }

    private RandomConvolution(int i, DoubleRange doubleRange) {
        this.PlaceComponentResult = true;
        this.getAuthRequestContext = 3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleRange;
        this.MyBillsEntityDataFactory = true;
    }
}
