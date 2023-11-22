package Catalano.Imaging.Concurrent.Filters;

import Catalano.Core.IntRange;
import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class ColorFiltering implements IApplyInPlace {
    private IntRange BuiltInFictitiousFunctionClassFactory;
    private IntRange MyBillsEntityDataFactory;
    private IntRange PlaceComponentResult;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ ColorFiltering KClassImpl$Data$declaredNonStaticMembers$2;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.getAuthRequestContext.MyBillsEntityDataFactory; i < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = 0; i2 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                    FastBitmap fastBitmap = this.getAuthRequestContext.getAuthRequestContext;
                    int i3 = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] >> 16) & 255;
                    FastBitmap fastBitmap2 = this.getAuthRequestContext.getAuthRequestContext;
                    int i4 = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] >> 8) & 255;
                    FastBitmap fastBitmap3 = this.getAuthRequestContext.getAuthRequestContext;
                    int i5 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255;
                    if (i3 >= this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getMin() && i3 <= this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getMax() && i4 >= this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getMin() && i4 <= this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getMax() && i5 >= this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.getMin() && i5 <= this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.getMax()) {
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i3, i4, i5);
                    } else {
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, 0, 0, 0);
                    }
                }
            }
        }
    }
}
