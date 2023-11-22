package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Maximum implements IApplyInPlace {
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private FastBitmap PlaceComponentResult;

    /* loaded from: classes6.dex */
    class CThread implements Runnable {
        private Share BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Maximum PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            int i = (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 * 2) + 1;
            int i2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
            if (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.BuiltInFictitiousFunctionClassFactory;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i2 = 0;
            }
            if (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                for (int i3 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i3 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i3++) {
                    for (int i4 = 0; i4 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i4++) {
                        int i5 = 0;
                        for (int i6 = 0; i6 < i; i6++) {
                            int i7 = (i6 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i3;
                            for (int i8 = 0; i8 < i; i8++) {
                                int i9 = (i8 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i4;
                                if (i7 >= 0 && i7 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i2 && i9 >= 0 && i9 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap = this.PlaceComponentResult.PlaceComponentResult;
                                    if ((fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i7) + (fastBitmap.MyBillsEntityDataFactory * i9)] & 255) > i5) {
                                        FastBitmap fastBitmap2 = this.PlaceComponentResult.PlaceComponentResult;
                                        i5 = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i7) + (i9 * fastBitmap2.MyBillsEntityDataFactory)] & 255;
                                    }
                                }
                            }
                        }
                        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i3, i4, i5);
                    }
                }
                return;
            }
            for (int i10 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i10 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i10++) {
                for (int i11 = 0; i11 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i11++) {
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    for (int i15 = 0; i15 < i; i15++) {
                        int i16 = (i15 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i10;
                        for (int i17 = 0; i17 < i; i17++) {
                            int i18 = (i17 - this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) + i11;
                            if (i16 >= 0 && i16 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i2 && i18 >= 0 && i18 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                FastBitmap fastBitmap3 = this.PlaceComponentResult.PlaceComponentResult;
                                if (((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i16) + (fastBitmap3.MyBillsEntityDataFactory * i18)] >> 16) & 255) > i12) {
                                    FastBitmap fastBitmap4 = this.PlaceComponentResult.PlaceComponentResult;
                                    i12 = (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i16) + (fastBitmap4.MyBillsEntityDataFactory * i18)] >> 16) & 255;
                                }
                                FastBitmap fastBitmap5 = this.PlaceComponentResult.PlaceComponentResult;
                                if (((fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i16) + (fastBitmap5.MyBillsEntityDataFactory * i18)] >> 8) & 255) > i13) {
                                    FastBitmap fastBitmap6 = this.PlaceComponentResult.PlaceComponentResult;
                                    i13 = (fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i16) + (fastBitmap6.MyBillsEntityDataFactory * i18)] >> 8) & 255;
                                }
                                FastBitmap fastBitmap7 = this.PlaceComponentResult.PlaceComponentResult;
                                if ((fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i16) + (fastBitmap7.MyBillsEntityDataFactory * i18)] & 255) > i14) {
                                    FastBitmap fastBitmap8 = this.PlaceComponentResult.PlaceComponentResult;
                                    i14 = fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i16) + (i18 * fastBitmap8.MyBillsEntityDataFactory)] & 255;
                                }
                            }
                        }
                    }
                    this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i10, i11, i12, i13, i14);
                }
            }
        }
    }
}
