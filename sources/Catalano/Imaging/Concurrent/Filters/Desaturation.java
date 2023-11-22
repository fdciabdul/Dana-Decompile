package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Desaturation implements IApplyInPlace {
    private double getAuthRequestContext = 0.2d;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Desaturation getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory; i < this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory; i++) {
                int i2 = 0;
                while (i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                    FastBitmap fastBitmap = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    double d = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] >> 16) & 255;
                    FastBitmap fastBitmap2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    double d2 = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] >> 8) & 255;
                    FastBitmap fastBitmap3 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    double d3 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    double d4 = (0.2125d * d) + (0.7154d * d2) + (0.0721d * d3);
                    double d5 = this.getAuthRequestContext.getAuthRequestContext;
                    double d6 = this.getAuthRequestContext.getAuthRequestContext;
                    double d7 = this.getAuthRequestContext.getAuthRequestContext;
                    int i3 = i2;
                    FastBitmap fastBitmap4 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    fastBitmap4.MyBillsEntityDataFactory(i, i3, (int) ((d5 * (d - d4)) + d4), (int) ((d6 * (d2 - d4)) + d4), (int) (d4 + (d7 * (d3 - d4))));
                    i2 = i3 + 1;
                }
            }
        }
    }
}
