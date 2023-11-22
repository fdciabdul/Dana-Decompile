package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class HysteresisThreshold implements IApplyInPlace {
    int MyBillsEntityDataFactory = 20;
    int KClassImpl$Data$declaredNonStaticMembers$2 = 100;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ HysteresisThreshold BuiltInFictitiousFunctionClassFactory;
        private Share PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            for (int i = this.PlaceComponentResult.MyBillsEntityDataFactory; i < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i++) {
                for (int i2 = this.PlaceComponentResult.scheduleImpl; i2 < this.PlaceComponentResult.PlaceComponentResult; i2++) {
                    FastBitmap fastBitmap = this.PlaceComponentResult.getAuthRequestContext;
                    if ((fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                        FastBitmap fastBitmap2 = this.PlaceComponentResult.getAuthRequestContext;
                        if ((fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] & 255) < this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) {
                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, 0);
                        } else {
                            FastBitmap fastBitmap3 = this.PlaceComponentResult.getAuthRequestContext;
                            int i3 = i2 - 1;
                            if ((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i3)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                FastBitmap fastBitmap4 = this.PlaceComponentResult.getAuthRequestContext;
                                int i4 = i2 + 1;
                                if ((fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i) + (fastBitmap4.MyBillsEntityDataFactory * i4)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                    FastBitmap fastBitmap5 = this.PlaceComponentResult.getAuthRequestContext;
                                    int i5 = i - 1;
                                    if ((fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i5) + (fastBitmap5.MyBillsEntityDataFactory * i3)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                        FastBitmap fastBitmap6 = this.PlaceComponentResult.getAuthRequestContext;
                                        if ((fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i5) + (fastBitmap6.MyBillsEntityDataFactory * i2)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                            FastBitmap fastBitmap7 = this.PlaceComponentResult.getAuthRequestContext;
                                            if ((fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(i5 * fastBitmap7.PlaceComponentResult) + (fastBitmap7.MyBillsEntityDataFactory * i4)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                                FastBitmap fastBitmap8 = this.PlaceComponentResult.getAuthRequestContext;
                                                int i6 = i + 1;
                                                if ((fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i6) + (i3 * fastBitmap8.MyBillsEntityDataFactory)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                                    FastBitmap fastBitmap9 = this.PlaceComponentResult.getAuthRequestContext;
                                                    if ((fastBitmap9.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap9.PlaceComponentResult * i6) + (fastBitmap9.MyBillsEntityDataFactory * i2)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                                        FastBitmap fastBitmap10 = this.PlaceComponentResult.getAuthRequestContext;
                                                        if ((fastBitmap10.KClassImpl$Data$declaredNonStaticMembers$2[(i6 * fastBitmap10.PlaceComponentResult) + (i4 * fastBitmap10.MyBillsEntityDataFactory)] & 255) < this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                                                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, 0);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
