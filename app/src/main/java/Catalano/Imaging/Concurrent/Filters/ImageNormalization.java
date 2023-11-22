package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class ImageNormalization implements IApplyInPlace {
    private float KClassImpl$Data$declaredNonStaticMembers$2 = 160.0f;
    private float MyBillsEntityDataFactory = 150.0f;
    private float PlaceComponentResult;
    private float getAuthRequestContext;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ ImageNormalization BuiltInFictitiousFunctionClassFactory;
        private Share MyBillsEntityDataFactory;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory; i < this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                    FastBitmap fastBitmap = this.MyBillsEntityDataFactory.getAuthRequestContext;
                    float f = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] & 255;
                    float sqrt = (float) Math.sqrt((this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory * ((float) Math.pow(f - this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, 2.0d))) / this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
                    int i3 = (int) (f > this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult ? this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 + sqrt : this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 - sqrt);
                    int i4 = i3 <= 255 ? i3 : 255;
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    this.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i4);
                }
            }
        }
    }
}
