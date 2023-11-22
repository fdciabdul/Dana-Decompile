package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import Catalano.Imaging.Tools.IntegralImage;

/* loaded from: classes6.dex */
public class BradleyLocalThreshold implements IApplyInPlace {
    private IntegralImage BuiltInFictitiousFunctionClassFactory;
    private int getAuthRequestContext = 41;
    private float KClassImpl$Data$declaredNonStaticMembers$2 = 0.15f;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ BradleyLocalThreshold PlaceComponentResult;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            int width = this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth() - 1;
            int i = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory - 1;
            int i2 = this.PlaceComponentResult.getAuthRequestContext / 2;
            float f = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            for (int i3 = this.getAuthRequestContext.MyBillsEntityDataFactory; i3 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i3++) {
                int i4 = i3 - i2;
                int i5 = i3 + i2;
                if (i4 < 0) {
                    i4 = 0;
                }
                if (i5 > i) {
                    i5 = i;
                }
                for (int i6 = 0; i6 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i6++) {
                    int i7 = i6 - i2;
                    int i8 = i6 + i2;
                    if (i7 < 0) {
                        i7 = 0;
                    }
                    if (i8 > width) {
                        i8 = width;
                    }
                    FastBitmap fastBitmap = this.getAuthRequestContext.getAuthRequestContext;
                    int i9 = 255;
                    if ((fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i3) + (fastBitmap.MyBillsEntityDataFactory * i6)] & 255) < ((int) (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i4, i7, i5, i8) * (1.0f - f)))) {
                        i9 = 0;
                    }
                    this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i3, i6, i9);
                }
            }
        }
    }
}
