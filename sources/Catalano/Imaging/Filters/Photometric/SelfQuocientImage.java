package Catalano.Imaging.Filters.Photometric;

import Catalano.Math.Functions.Gaussian;

/* loaded from: classes6.dex */
public class SelfQuocientImage implements IPhotometricFilter {
    private double[][] KClassImpl$Data$declaredNonStaticMembers$2;
    private double MyBillsEntityDataFactory;
    private int getAuthRequestContext;

    public SelfQuocientImage() {
        this((byte) 0);
    }

    private SelfQuocientImage(byte b) {
        this((char) 0);
    }

    private SelfQuocientImage(char c) {
        this.getAuthRequestContext = 5;
        this.MyBillsEntityDataFactory = 1.0d;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Gaussian(1.0d).KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
    }
}
