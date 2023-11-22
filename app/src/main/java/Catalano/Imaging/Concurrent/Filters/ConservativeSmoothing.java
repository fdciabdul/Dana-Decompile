package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class ConservativeSmoothing implements IApplyInPlace {
    private FastBitmap KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory = 1;

    /* loaded from: classes6.dex */
    class CThread implements Runnable {
        final /* synthetic */ ConservativeSmoothing MyBillsEntityDataFactory;
        private Share PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3 = (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory * 2) + 1;
            int i4 = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory;
            if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.PlaceComponentResult;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i4 = 0;
            }
            if (this.PlaceComponentResult.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                for (int i5 = this.PlaceComponentResult.MyBillsEntityDataFactory; i5 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i5++) {
                    for (int i6 = 0; i6 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i6++) {
                        int i7 = 0;
                        int i8 = 255;
                        for (int i9 = 0; i9 < i3; i9++) {
                            int i10 = (i9 - this.MyBillsEntityDataFactory.MyBillsEntityDataFactory) + i5;
                            for (int i11 = 0; i11 < i3; i11++) {
                                int i12 = (i11 - this.MyBillsEntityDataFactory.MyBillsEntityDataFactory) + i6;
                                if (i10 >= 0 && i10 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i4 && i12 >= 0 && i12 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth() && i9 != i11) {
                                    FastBitmap fastBitmap = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if ((fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i10) + (fastBitmap.MyBillsEntityDataFactory * i12)] & 255) > i7) {
                                        FastBitmap fastBitmap2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                        i7 = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i10) + (fastBitmap2.MyBillsEntityDataFactory * i12)] & 255;
                                    }
                                    FastBitmap fastBitmap3 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if ((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i10) + (fastBitmap3.MyBillsEntityDataFactory * i12)] & 255) < i8) {
                                        FastBitmap fastBitmap4 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                        i8 = fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i10) + (i12 * fastBitmap4.MyBillsEntityDataFactory)] & 255;
                                    }
                                }
                            }
                        }
                        FastBitmap fastBitmap5 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                        int i13 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i5) + (fastBitmap5.MyBillsEntityDataFactory * i6)] & 255;
                        if (i13 <= i7) {
                            i7 = i13;
                        }
                        if (i7 >= i8) {
                            i8 = i7;
                        }
                        this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i5, i6, i8);
                    }
                }
                return;
            }
            int i14 = this.PlaceComponentResult.MyBillsEntityDataFactory;
            while (i14 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory) {
                int i15 = 0;
                while (i15 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                    int i16 = 0;
                    int i17 = 255;
                    int i18 = 255;
                    int i19 = 255;
                    int i20 = 0;
                    int i21 = 0;
                    for (int i22 = 0; i22 < i3; i22++) {
                        int i23 = (i22 - this.MyBillsEntityDataFactory.MyBillsEntityDataFactory) + i14;
                        int i24 = 0;
                        while (i24 < i3) {
                            int i25 = (i24 - this.MyBillsEntityDataFactory.MyBillsEntityDataFactory) + i15;
                            if (i23 < 0 || i23 >= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i4 || i25 < 0 || i25 >= this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth() || i22 == i24) {
                                i = i3;
                                i2 = i4;
                            } else {
                                FastBitmap fastBitmap6 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                i = i3;
                                i2 = i4;
                                if (((fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i23) + (fastBitmap6.MyBillsEntityDataFactory * i25)] >> 16) & 255) > i16) {
                                    FastBitmap fastBitmap7 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i16 = (fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i23) + (fastBitmap7.MyBillsEntityDataFactory * i25)] >> 16) & 255;
                                }
                                FastBitmap fastBitmap8 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (((fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i23) + (fastBitmap8.MyBillsEntityDataFactory * i25)] >> 8) & 255) > i20) {
                                    FastBitmap fastBitmap9 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i20 = (fastBitmap9.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap9.PlaceComponentResult * i23) + (fastBitmap9.MyBillsEntityDataFactory * i25)] >> 8) & 255;
                                }
                                FastBitmap fastBitmap10 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                if ((fastBitmap10.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap10.PlaceComponentResult * i23) + (fastBitmap10.MyBillsEntityDataFactory * i25)] & 255) > i21) {
                                    FastBitmap fastBitmap11 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i21 = fastBitmap11.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap11.PlaceComponentResult * i23) + (fastBitmap11.MyBillsEntityDataFactory * i25)] & 255;
                                }
                                FastBitmap fastBitmap12 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (((fastBitmap12.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap12.PlaceComponentResult * i23) + (fastBitmap12.MyBillsEntityDataFactory * i25)] >> 16) & 255) < i19) {
                                    FastBitmap fastBitmap13 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i19 = (fastBitmap13.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap13.PlaceComponentResult * i23) + (fastBitmap13.MyBillsEntityDataFactory * i25)] >> 16) & 255;
                                }
                                FastBitmap fastBitmap14 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (((fastBitmap14.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap14.PlaceComponentResult * i23) + (fastBitmap14.MyBillsEntityDataFactory * i25)] >> 8) & 255) < i18) {
                                    FastBitmap fastBitmap15 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i18 = (fastBitmap15.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap15.PlaceComponentResult * i23) + (fastBitmap15.MyBillsEntityDataFactory * i25)] >> 8) & 255;
                                }
                                FastBitmap fastBitmap16 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                if ((fastBitmap16.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap16.PlaceComponentResult * i23) + (fastBitmap16.MyBillsEntityDataFactory * i25)] & 255) < i17) {
                                    FastBitmap fastBitmap17 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    i17 = fastBitmap17.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap17.PlaceComponentResult * i23) + (i25 * fastBitmap17.MyBillsEntityDataFactory)] & 255;
                                }
                            }
                            i24++;
                            i3 = i;
                            i4 = i2;
                        }
                    }
                    int i26 = i3;
                    int i27 = i4;
                    FastBitmap fastBitmap18 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i28 = (fastBitmap18.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap18.PlaceComponentResult * i14) + (fastBitmap18.MyBillsEntityDataFactory * i15)] >> 16) & 255;
                    FastBitmap fastBitmap19 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i29 = (fastBitmap19.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap19.PlaceComponentResult * i14) + (fastBitmap19.MyBillsEntityDataFactory * i15)] >> 8) & 255;
                    FastBitmap fastBitmap20 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i30 = fastBitmap20.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap20.PlaceComponentResult * i14) + (fastBitmap20.MyBillsEntityDataFactory * i15)] & 255;
                    if (i28 <= i16) {
                        i16 = i28;
                    }
                    if (i29 <= i20) {
                        i20 = i29;
                    }
                    if (i30 <= i21) {
                        i21 = i30;
                    }
                    if (i16 >= i19) {
                        i19 = i16;
                    }
                    if (i20 < i18) {
                        i20 = i18;
                    }
                    if (i21 < i17) {
                        i21 = i17;
                    }
                    this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i14, i15, i19, i20, i21);
                    i15++;
                    i3 = i26;
                    i4 = i27;
                }
                i14++;
                i4 = i4;
            }
        }
    }
}
