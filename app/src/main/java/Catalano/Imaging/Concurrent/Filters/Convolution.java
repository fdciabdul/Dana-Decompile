package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Convolution implements IApplyInPlace {
    private int[][] KClassImpl$Data$declaredNonStaticMembers$2;
    private FastBitmap MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private boolean getAuthRequestContext = false;
    private boolean BuiltInFictitiousFunctionClassFactory = false;

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ Convolution PlaceComponentResult;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int PlaceComponentResult = Convolution.PlaceComponentResult(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
            char c = 0;
            if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.getAuthRequestContext;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i = 0;
            } else {
                i = PlaceComponentResult;
            }
            int i6 = 255;
            if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                int i7 = this.getAuthRequestContext.MyBillsEntityDataFactory;
                while (i7 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                    int i8 = 0;
                    while (i8 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                        int i9 = 0;
                        int i10 = 0;
                        int i11 = 0;
                        while (i9 < this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                            int i12 = (i9 - PlaceComponentResult) + i7;
                            int i13 = 0;
                            while (i13 < this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[c].length) {
                                int i14 = (i13 - PlaceComponentResult) + i8;
                                if (i12 < 0 || i12 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i || i14 < 0 || i14 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory) {
                                        int i15 = (i7 + i9) - PlaceComponentResult;
                                        int i16 = (i8 + i13) - PlaceComponentResult;
                                        if (i15 < 0) {
                                            i15 = 0;
                                        }
                                        if (i15 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                                            i15 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory - 1;
                                        }
                                        if (i16 < 0) {
                                            i16 = 0;
                                        }
                                        if (i16 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                            i16 = this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth() - 1;
                                        }
                                        int i17 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i9][i13];
                                        FastBitmap fastBitmap = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                        i10 += i17 * (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(i15 * fastBitmap.PlaceComponentResult) + (i16 * fastBitmap.MyBillsEntityDataFactory)] & 255);
                                        i5 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i9][i13];
                                    } else {
                                        i13++;
                                        c = 0;
                                        i6 = 255;
                                    }
                                } else {
                                    int i18 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i9][i13];
                                    FastBitmap fastBitmap2 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                    i10 += i18 * (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i12) + (i14 * fastBitmap2.MyBillsEntityDataFactory)] & i6);
                                    i5 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i9][i13];
                                }
                                i11 += i5;
                                i13++;
                                c = 0;
                                i6 = 255;
                            }
                            i9++;
                            c = 0;
                            i6 = 255;
                        }
                        if (i11 != 0) {
                            if (this.PlaceComponentResult.getAuthRequestContext) {
                                i10 /= this.PlaceComponentResult.PlaceComponentResult;
                            } else {
                                i10 /= i11;
                            }
                        }
                        if (i10 > 255) {
                            i10 = 255;
                        }
                        if (i10 < 0) {
                            i10 = 0;
                        }
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i7, i8, i10);
                        i8++;
                        c = 0;
                        i6 = 255;
                    }
                    i7++;
                    c = 0;
                    i6 = 255;
                }
                return;
            }
            int i19 = this.getAuthRequestContext.MyBillsEntityDataFactory;
            while (i19 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                int i20 = 0;
                while (i20 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                    int i21 = 0;
                    int i22 = 0;
                    int i23 = 0;
                    int i24 = 0;
                    for (int i25 = 0; i25 < this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.length; i25++) {
                        int i26 = (i25 - PlaceComponentResult) + i19;
                        int i27 = 0;
                        while (i27 < this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[0].length) {
                            int i28 = (i27 - PlaceComponentResult) + i20;
                            if (i26 < 0 || i26 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i || i28 < 0 || i28 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                i2 = i;
                                if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory) {
                                    int i29 = (i19 + i25) - PlaceComponentResult;
                                    int i30 = (i20 + i27) - PlaceComponentResult;
                                    if (i29 < 0) {
                                        i29 = 0;
                                    }
                                    if (i29 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                                        i29 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory - 1;
                                    }
                                    if (i30 < 0) {
                                        i30 = 0;
                                    }
                                    if (i30 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                        i30 = this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth() - 1;
                                    }
                                    int i31 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                    FastBitmap fastBitmap3 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                    i3 = PlaceComponentResult;
                                    i21 += i31 * ((fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i29) + (fastBitmap3.MyBillsEntityDataFactory * i30)] >> 16) & 255);
                                    int i32 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                    FastBitmap fastBitmap4 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                    i22 += i32 * ((fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i29) + (fastBitmap4.MyBillsEntityDataFactory * i30)] >> 8) & 255);
                                    int i33 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                    FastBitmap fastBitmap5 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                    i23 += i33 * (fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(i29 * fastBitmap5.PlaceComponentResult) + (i30 * fastBitmap5.MyBillsEntityDataFactory)] & 255);
                                    i4 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                } else {
                                    i3 = PlaceComponentResult;
                                    i27++;
                                    i = i2;
                                    PlaceComponentResult = i3;
                                }
                            } else {
                                int i34 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                FastBitmap fastBitmap6 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                i2 = i;
                                i21 += i34 * ((fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i26) + (fastBitmap6.MyBillsEntityDataFactory * i28)] >> 16) & 255);
                                int i35 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                FastBitmap fastBitmap7 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                i22 += i35 * ((fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i26) + (fastBitmap7.MyBillsEntityDataFactory * i28)] >> 8) & 255);
                                int i36 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                FastBitmap fastBitmap8 = this.PlaceComponentResult.MyBillsEntityDataFactory;
                                i23 += i36 * (fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i26) + (i28 * fastBitmap8.MyBillsEntityDataFactory)] & 255);
                                i4 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2[i25][i27];
                                i3 = PlaceComponentResult;
                            }
                            i24 += i4;
                            i27++;
                            i = i2;
                            PlaceComponentResult = i3;
                        }
                    }
                    int i37 = PlaceComponentResult;
                    int i38 = i;
                    if (i24 != 0) {
                        if (this.PlaceComponentResult.getAuthRequestContext) {
                            i21 /= this.PlaceComponentResult.PlaceComponentResult;
                            i22 /= this.PlaceComponentResult.PlaceComponentResult;
                            i23 /= this.PlaceComponentResult.PlaceComponentResult;
                        } else {
                            i21 /= i24;
                            i22 /= i24;
                            i23 /= i24;
                        }
                    }
                    if (i21 > 255) {
                        i21 = 255;
                    }
                    if (i22 > 255) {
                        i22 = 255;
                    }
                    if (i23 > 255) {
                        i23 = 255;
                    }
                    this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i19, i20, i21 < 0 ? 0 : i21, i22 < 0 ? 0 : i22, i23 < 0 ? 0 : i23);
                    i20++;
                    i = i38;
                    PlaceComponentResult = i37;
                }
                i19++;
                PlaceComponentResult = PlaceComponentResult;
            }
        }
    }

    static /* synthetic */ int PlaceComponentResult(int[][] iArr) {
        return (iArr[0].length - 1) / 2;
    }
}
