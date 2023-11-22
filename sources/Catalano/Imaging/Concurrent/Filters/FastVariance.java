package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class FastVariance implements IApplyInPlace {
    private int BuiltInFictitiousFunctionClassFactory = 2;
    private FastBitmap KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes6.dex */
    class CThread implements Runnable {
        final /* synthetic */ FastVariance BuiltInFictitiousFunctionClassFactory;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            double d;
            int i3;
            int i4 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.getAuthRequestContext;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i4 = 0;
            }
            if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                for (int i5 = this.getAuthRequestContext.MyBillsEntityDataFactory; i5 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i5++) {
                    for (int i6 = 0; i6 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i6++) {
                        int i7 = 0;
                        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        for (int i8 = i5 - this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i8 <= this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i5; i8++) {
                            for (int i9 = i6 - this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i9 <= this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i6; i9++) {
                                if (i8 >= 0 && i8 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i4 && i9 >= 0 && i9 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    i7++;
                                    FastBitmap fastBitmap = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    double d4 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i8) + (fastBitmap.MyBillsEntityDataFactory * i9)] & 255;
                                    Double.isNaN(d4);
                                    double d5 = d4 - d3;
                                    double d6 = i7;
                                    Double.isNaN(d6);
                                    d3 += d5 / d6;
                                    FastBitmap fastBitmap2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                    double d7 = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i8) + (fastBitmap2.MyBillsEntityDataFactory * i9)] & 255;
                                    Double.isNaN(d7);
                                    d2 += d5 * (d7 - d3);
                                }
                            }
                        }
                        double d8 = (double) (i7 - 1);
                        Double.isNaN(d8);
                        double d9 = d2 / d8;
                        if (d9 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d9 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                        if (d9 > 255.0d) {
                            d9 = 255.0d;
                        }
                        this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i5, i6, (int) d9);
                    }
                }
                return;
            }
            int i10 = this.getAuthRequestContext.MyBillsEntityDataFactory;
            while (i10 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                int i11 = 0;
                while (i11 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                    double d10 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d11 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    int i12 = 0;
                    double d12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d13 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d14 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d15 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (int i13 = i10 - this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i13 <= this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i10; i13++) {
                        int i14 = i11 - this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                        while (i14 <= this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i11) {
                            if (i13 < 0 || i13 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i4 || i14 < 0 || i14 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                i = i4;
                                i2 = i10;
                                d = d10;
                                i3 = i11;
                                d11 = d11;
                                d12 = d12;
                            } else {
                                i12++;
                                FastBitmap fastBitmap3 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                i = i4;
                                i3 = i11;
                                double d16 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i13) + (fastBitmap3.MyBillsEntityDataFactory * i14)] >> 16) & 255;
                                Double.isNaN(d16);
                                double d17 = d16 - d15;
                                FastBitmap fastBitmap4 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                i2 = i10;
                                double d18 = d11;
                                double d19 = (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i13) + (fastBitmap4.MyBillsEntityDataFactory * i14)] >> 8) & 255;
                                Double.isNaN(d19);
                                double d20 = d19 - d13;
                                FastBitmap fastBitmap5 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                double d21 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i13) + (fastBitmap5.MyBillsEntityDataFactory * i14)] & 255;
                                Double.isNaN(d21);
                                double d22 = d21 - d14;
                                double d23 = d10;
                                double d24 = i12;
                                Double.isNaN(d24);
                                d15 += d17 / d24;
                                Double.isNaN(d24);
                                d13 += d20 / d24;
                                Double.isNaN(d24);
                                d14 += d22 / d24;
                                FastBitmap fastBitmap6 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                double d25 = (fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i13) + (fastBitmap6.MyBillsEntityDataFactory * i14)] >> 16) & 255;
                                Double.isNaN(d25);
                                double d26 = d23 + (d17 * (d25 - d15));
                                FastBitmap fastBitmap7 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                double d27 = (fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i13) + (fastBitmap7.MyBillsEntityDataFactory * i14)] >> 8) & 255;
                                FastBitmap fastBitmap8 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                d = d26;
                                double d28 = fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i13) + (fastBitmap8.MyBillsEntityDataFactory * i14)] & 255;
                                Double.isNaN(d28);
                                d12 += d22 * (d28 - d14);
                                Double.isNaN(d27);
                                d11 = d18 + (d20 * (d27 - d13));
                            }
                            d10 = d;
                            i14++;
                            i4 = i;
                            i11 = i3;
                            i10 = i2;
                        }
                    }
                    int i15 = i4;
                    int i16 = i10;
                    int i17 = i11;
                    double d29 = (double) (i12 - 1);
                    Double.isNaN(d29);
                    double d30 = d10 / d29;
                    Double.isNaN(d29);
                    double d31 = d11 / d29;
                    Double.isNaN(d29);
                    double d32 = d12 / d29;
                    if (d30 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d30 = 0.0d;
                    }
                    if (d31 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d31 = 0.0d;
                    }
                    if (d32 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d32 = 0.0d;
                    }
                    if (d30 > 255.0d) {
                        d30 = 255.0d;
                    }
                    if (d31 > 255.0d) {
                        d31 = 255.0d;
                    }
                    if (d32 > 255.0d) {
                        d32 = 255.0d;
                    }
                    this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i16, i17, (int) d30, (int) d31, (int) d32);
                    i11 = i17 + 1;
                    i4 = i15;
                    i10 = i16;
                }
                i10++;
            }
        }
    }
}
