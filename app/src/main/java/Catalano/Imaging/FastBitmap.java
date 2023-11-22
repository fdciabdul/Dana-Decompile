package Catalano.Imaging;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public class FastBitmap {
    public Bitmap BuiltInFictitiousFunctionClassFactory;
    public int[] KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public int PlaceComponentResult;
    public boolean getAuthRequestContext;
    private CoordinateSystem scheduleImpl;

    /* loaded from: classes6.dex */
    public enum ColorSpace {
        Grayscale,
        RGB
    }

    /* loaded from: classes6.dex */
    public enum CoordinateSystem {
        Cartesian,
        Matrix
    }

    public FastBitmap() {
        this.getAuthRequestContext = false;
    }

    public FastBitmap(FastBitmap fastBitmap) {
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = fastBitmap.BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult(fastBitmap.scheduleImpl);
        PlaceComponentResult();
        if (fastBitmap.getAuthRequestContext()) {
            this.getAuthRequestContext = false;
        } else {
            this.getAuthRequestContext = true;
        }
    }

    public FastBitmap(Bitmap bitmap) {
        this.getAuthRequestContext = false;
        if (bitmap.isMutable()) {
            this.BuiltInFictitiousFunctionClassFactory = bitmap;
            PlaceComponentResult(CoordinateSystem.Matrix);
            PlaceComponentResult();
            return;
        }
        throw new IllegalArgumentException("Bitmap needs to be mutable.");
    }

    private void PlaceComponentResult() {
        int[] iArr = new int[this.BuiltInFictitiousFunctionClassFactory.getWidth() * this.BuiltInFictitiousFunctionClassFactory.getHeight()];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        Bitmap bitmap = this.BuiltInFictitiousFunctionClassFactory;
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, this.BuiltInFictitiousFunctionClassFactory.getWidth(), this.BuiltInFictitiousFunctionClassFactory.getHeight());
    }

    private void PlaceComponentResult(CoordinateSystem coordinateSystem) {
        this.scheduleImpl = coordinateSystem;
        if (coordinateSystem == CoordinateSystem.Matrix) {
            this.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.getWidth();
            this.MyBillsEntityDataFactory = 1;
            return;
        }
        this.PlaceComponentResult = 1;
        this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.getWidth();
    }

    public final void MyBillsEntityDataFactory(int i, int i2, int i3, int i4, int i5) {
        this.KClassImpl$Data$declaredNonStaticMembers$2[(i * this.PlaceComponentResult) + (i2 * this.MyBillsEntityDataFactory)] = (i3 << 16) | (-16777216) | (i4 << 8) | i5;
    }

    public final void getAuthRequestContext(int i, int i2, int[] iArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2[(i * this.PlaceComponentResult) + (i2 * this.MyBillsEntityDataFactory)] = (iArr[0] << 16) | (-16777216) | (iArr[1] << 8) | iArr[2];
    }

    public final void MyBillsEntityDataFactory(int i, int i2, int i3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2[(i * this.PlaceComponentResult) + (i2 * this.MyBillsEntityDataFactory)] = (i3 << 16) | (-16777216) | (i3 << 8) | i3;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3) {
        int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = (i * this.PlaceComponentResult) + (i2 * this.MyBillsEntityDataFactory);
        iArr[i4] = (iArr[i4] & (-16711681)) | (i3 << 16);
    }

    public final void getAuthRequestContext(int i, int i2, int i3) {
        int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = (i * this.PlaceComponentResult) + (i2 * this.MyBillsEntityDataFactory);
        iArr[i4] = (iArr[i4] & (-65281)) | (i3 << 8);
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3) {
        int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = (i * this.PlaceComponentResult) + (i2 * this.MyBillsEntityDataFactory);
        iArr[i4] = (iArr[i4] & (-256)) | i3;
    }

    public final boolean getAuthRequestContext() {
        return !this.getAuthRequestContext;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }

    public final Bitmap BuiltInFictitiousFunctionClassFactory() {
        if (!getAuthRequestContext()) {
            int height = this.BuiltInFictitiousFunctionClassFactory.getHeight();
            int width = this.BuiltInFictitiousFunctionClassFactory.getWidth();
            for (int i = 0; i < height * width; i++) {
                int[] iArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = iArr[i] & 255;
                iArr[i] = i2 | (-16777216) | (i2 << 16) | (i2 << 8);
            }
        }
        this.BuiltInFictitiousFunctionClassFactory.setPixels(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, Math.max(this.PlaceComponentResult, this.MyBillsEntityDataFactory), 0, 0, this.BuiltInFictitiousFunctionClassFactory.getWidth(), this.BuiltInFictitiousFunctionClassFactory.getHeight());
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
