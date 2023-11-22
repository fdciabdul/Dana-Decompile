package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Filters.Mean;
import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class SauvolaThreshold implements IApplyInPlace {
    private FastBitmap MyBillsEntityDataFactory;
    private FastBitmap moveToNextValue;
    private Mean.Arithmetic KClassImpl$Data$declaredNonStaticMembers$2 = Mean.Arithmetic.Mean;
    private int BuiltInFictitiousFunctionClassFactory = 15;
    private double getAuthRequestContext = 0.5d;
    private double PlaceComponentResult = 128.0d;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ SauvolaThreshold KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                    FastBitmap fastBitmap = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    int i3 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)];
                    int i4 = 255;
                    FastBitmap fastBitmap2 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                    float f = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] & 255;
                    FastBitmap fastBitmap3 = this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
                    double d = f;
                    double sqrt = (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext * ((Math.sqrt(fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255) / this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult) - 1.0d)) + 1.0d;
                    Double.isNaN(d);
                    if (r7 <= d * sqrt) {
                        i4 = 0;
                    }
                    this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                }
            }
        }
    }
}
