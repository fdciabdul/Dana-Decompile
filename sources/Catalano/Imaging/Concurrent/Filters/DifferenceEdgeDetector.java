package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class DifferenceEdgeDetector implements IApplyInPlace {
    private FastBitmap BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ DifferenceEdgeDetector BuiltInFictitiousFunctionClassFactory;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.getAuthRequestContext.MyBillsEntityDataFactory; i < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i++) {
                int i2 = this.getAuthRequestContext.scheduleImpl;
                while (i2 < this.getAuthRequestContext.PlaceComponentResult) {
                    FastBitmap fastBitmap = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i3 = i - 1;
                    int i4 = i2 - 1;
                    int i5 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i3) + (fastBitmap.MyBillsEntityDataFactory * i4)] & 255;
                    FastBitmap fastBitmap2 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i6 = i + 1;
                    int i7 = i2 + 1;
                    int i8 = i5 - (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i6) + (fastBitmap2.MyBillsEntityDataFactory * i7)] & 255);
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    int i9 = i8 > 0 ? i8 : 0;
                    FastBitmap fastBitmap3 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i10 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i3) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255;
                    FastBitmap fastBitmap4 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i11 = i10 - (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i6) + (fastBitmap4.MyBillsEntityDataFactory * i2)] & 255);
                    if (i11 < 0) {
                        i11 = -i11;
                    }
                    if (i11 > i9) {
                        i9 = i11;
                    }
                    FastBitmap fastBitmap5 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i12 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(i3 * fastBitmap5.PlaceComponentResult) + (fastBitmap5.MyBillsEntityDataFactory * i7)] & 255;
                    FastBitmap fastBitmap6 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i13 = i12 - (fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(i6 * fastBitmap6.PlaceComponentResult) + (fastBitmap6.MyBillsEntityDataFactory * i4)] & 255);
                    if (i13 < 0) {
                        i13 = -i13;
                    }
                    if (i13 > i9) {
                        i9 = i13;
                    }
                    FastBitmap fastBitmap7 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i14 = fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i) + (fastBitmap7.MyBillsEntityDataFactory * i7)] & 255;
                    FastBitmap fastBitmap8 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    int i15 = i14 - (fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i) + (i4 * fastBitmap8.MyBillsEntityDataFactory)] & 255);
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    if (i15 > i9) {
                        i9 = i15;
                    }
                    this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i9);
                    i2 = i7;
                }
            }
        }
    }
}
