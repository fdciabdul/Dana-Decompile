package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Threshold implements IApplyInPlace {
    private int MyBillsEntityDataFactory = 128;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ Threshold BuiltInFictitiousFunctionClassFactory;
        private Share KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory; i < this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                    FastBitmap fastBitmap = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    if ((fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] & 255) < this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, 0);
                    } else {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, 255);
                    }
                }
            }
        }
    }
}
