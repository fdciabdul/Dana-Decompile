package Catalano.Imaging.Tools;

/* loaded from: classes6.dex */
public class IntegralImage {
    protected int[][] MyBillsEntityDataFactory;

    public final float KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
        int i5 = i3 + 1;
        int i6 = i4 + 1;
        int[][] iArr = this.MyBillsEntityDataFactory;
        int[] iArr2 = iArr[i5];
        int i7 = iArr2[i6];
        int[] iArr3 = iArr[i];
        double d = ((i7 + iArr3[i2]) - iArr3[i6]) - iArr2[i2];
        double d2 = (i5 - i) * (i6 - i2);
        Double.isNaN(d);
        Double.isNaN(d2);
        return (float) (d / d2);
    }
}
