package Catalano.Imaging.Filters.Photometric;

/* loaded from: classes6.dex */
public class MultiscaleRetinex implements IPhotometricFilter {
    private int[] MyBillsEntityDataFactory;

    public MultiscaleRetinex() {
        this(new int[]{7, 15, 21});
    }

    private MultiscaleRetinex(int[] iArr) {
        this.MyBillsEntityDataFactory = iArr;
    }
}
