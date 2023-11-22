package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Invert implements IApplyInPlace {

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                for (int i = this.getAuthRequestContext.MyBillsEntityDataFactory; i < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i++) {
                    for (int i2 = 0; i2 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                        FastBitmap fastBitmap = this.getAuthRequestContext.getAuthRequestContext;
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, 255 - (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] & 255));
                    }
                }
                return;
            }
            for (int i3 = this.getAuthRequestContext.MyBillsEntityDataFactory; i3 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i3++) {
                for (int i4 = 0; i4 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i4++) {
                    FastBitmap fastBitmap2 = this.getAuthRequestContext.getAuthRequestContext;
                    int i5 = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i3) + (fastBitmap2.MyBillsEntityDataFactory * i4)] >> 16) & 255;
                    FastBitmap fastBitmap3 = this.getAuthRequestContext.getAuthRequestContext;
                    int i6 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i3) + (fastBitmap3.MyBillsEntityDataFactory * i4)] >> 8) & 255;
                    FastBitmap fastBitmap4 = this.getAuthRequestContext.getAuthRequestContext;
                    int i7 = 255 - i6;
                    int i8 = 255 - (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i3) + (fastBitmap4.MyBillsEntityDataFactory * i4)] & 255);
                    this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i3, i4, 255 - i5, i7, i8);
                }
            }
        }
    }
}
