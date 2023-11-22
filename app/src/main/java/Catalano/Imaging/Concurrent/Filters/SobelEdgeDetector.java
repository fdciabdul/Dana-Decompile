package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class SobelEdgeDetector implements IApplyInPlace {
    private FastBitmap KClassImpl$Data$declaredNonStaticMembers$2;
    private int getAuthRequestContext = 0;
    private boolean BuiltInFictitiousFunctionClassFactory = true;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ SobelEdgeDetector MyBillsEntityDataFactory;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i++) {
                int i2 = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                while (i2 < this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult) {
                    FastBitmap fastBitmap = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i3 = i - 1;
                    int i4 = i2 - 1;
                    int i5 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i3) + (fastBitmap.MyBillsEntityDataFactory * i4)] & 255;
                    FastBitmap fastBitmap2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i6 = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i3) + (fastBitmap2.MyBillsEntityDataFactory * i2)] & 255;
                    FastBitmap fastBitmap3 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i7 = i2 + 1;
                    int i8 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(i3 * fastBitmap3.PlaceComponentResult) + (fastBitmap3.MyBillsEntityDataFactory * i7)] & 255;
                    FastBitmap fastBitmap4 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i9 = fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i) + (fastBitmap4.MyBillsEntityDataFactory * i7)] & 255;
                    FastBitmap fastBitmap5 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i10 = i + 1;
                    int i11 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i10) + (fastBitmap5.MyBillsEntityDataFactory * i2)] & 255;
                    FastBitmap fastBitmap6 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i12 = fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i10) + (fastBitmap6.MyBillsEntityDataFactory * i7)] & 255;
                    FastBitmap fastBitmap7 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i13 = fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(i10 * fastBitmap7.PlaceComponentResult) + (fastBitmap7.MyBillsEntityDataFactory * i4)] & 255;
                    FastBitmap fastBitmap8 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int min = Math.min(255, Math.abs((((i8 + i5) - i13) - i6) + ((i6 - i11) * 2)) + Math.abs((((i6 + i12) - i5) - i13) + ((i9 - (fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i) + (i4 * fastBitmap8.MyBillsEntityDataFactory)] & 255)) * 2)));
                    if (min > this.MyBillsEntityDataFactory.getAuthRequestContext) {
                        this.MyBillsEntityDataFactory.getAuthRequestContext = min;
                    }
                    this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, min);
                    i2 = i7;
                }
            }
            if (!this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory || this.MyBillsEntityDataFactory.getAuthRequestContext == 255) {
                return;
            }
            double d = this.MyBillsEntityDataFactory.getAuthRequestContext;
            Double.isNaN(d);
            double d2 = 255.0d / d;
            for (int i14 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i14 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i14++) {
                for (int i15 = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl; i15 < this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult; i15++) {
                    FastBitmap fastBitmap9 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    FastBitmap fastBitmap10 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    double d3 = fastBitmap10.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap10.PlaceComponentResult * i14) + (fastBitmap10.MyBillsEntityDataFactory * i15)] & 255;
                    Double.isNaN(d3);
                    fastBitmap9.MyBillsEntityDataFactory(i14, i15, (int) (d3 * d2));
                }
            }
        }
    }
}
