package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class BernsenThreshold implements IApplyInPlace {
    private FastBitmap BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 15;
    private double MyBillsEntityDataFactory = 15.0d;
    private FastBitmap PlaceComponentResult;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ BernsenThreshold KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                    FastBitmap fastBitmap = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                    int i3 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)];
                    int i4 = 255;
                    FastBitmap fastBitmap2 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                    double d = (i3 & 255) - (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] & 255);
                    FastBitmap fastBitmap3 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                    int i5 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255;
                    FastBitmap fastBitmap4 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                    double d2 = (i5 + (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i) + (fastBitmap4.MyBillsEntityDataFactory * i2)] & 255)) / 2;
                    FastBitmap fastBitmap5 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    int i6 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i) + (fastBitmap5.MyBillsEntityDataFactory * i2)] & 255;
                    if (d < this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory) {
                        if (d2 >= 128.0d) {
                            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                        }
                        i4 = 0;
                        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                    } else {
                        if (i6 >= d2) {
                            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                        }
                        i4 = 0;
                        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                    }
                }
            }
        }
    }
}
