package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import com.google.common.primitives.Longs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Variance implements IApplyInPlace {
    private int BuiltInFictitiousFunctionClassFactory = 2;
    private FastBitmap getAuthRequestContext;

    /* loaded from: classes6.dex */
    class CThread implements Runnable {
        private Share BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Variance PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            double d;
            int i3;
            int i4 = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
            if (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.BuiltInFictitiousFunctionClassFactory;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i4 = 0;
            }
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
            long j = Longs.MAX_POWER_OF_TWO;
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                for (int i5 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory; i5 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory; i5++) {
                    for (int i6 = 0; i6 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i6++) {
                        int i7 = 0;
                        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        for (int i8 = i5 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i8 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i5; i8++) {
                            for (int i9 = i6 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i9 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i6; i9++) {
                                if (i8 >= 0 && i8 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i4 && i9 >= 0 && i9 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap = this.PlaceComponentResult.getAuthRequestContext;
                                    double d3 = fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i8) + (fastBitmap.MyBillsEntityDataFactory * i9)] & 255;
                                    Double.isNaN(d3);
                                    d2 += d3;
                                    i7++;
                                }
                            }
                        }
                        double d4 = i7;
                        Double.isNaN(d4);
                        double d5 = d2 / d4;
                        double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        for (int i10 = i5 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i10 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i5; i10++) {
                            for (int i11 = i6 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i11 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i6; i11++) {
                                if (i10 >= 0 && i10 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i4 && i11 >= 0 && i11 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                    FastBitmap fastBitmap2 = this.PlaceComponentResult.getAuthRequestContext;
                                    double d7 = fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i10) + (fastBitmap2.MyBillsEntityDataFactory * i11)] & 255;
                                    Double.isNaN(d7);
                                    d6 += Math.pow(d7 - d5, 2.0d);
                                }
                            }
                        }
                        double d8 = (double) (i7 - 1);
                        Double.isNaN(d8);
                        double d9 = d6 / d8;
                        if (d9 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            d9 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                        if (d9 > 255.0d) {
                            d9 = 255.0d;
                        }
                        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i5, i6, (int) d9);
                    }
                }
                return;
            }
            int i12 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            while (i12 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) {
                int i13 = 0;
                while (i13 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                    int i14 = 0;
                    double d10 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d11 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d12 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (int i15 = i12 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i15 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i12; i15++) {
                        for (int i16 = i13 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i16 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i13; i16++) {
                            if (i15 >= 0 && i15 < this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i4 && i16 >= 0 && i16 < this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                FastBitmap fastBitmap3 = this.PlaceComponentResult.getAuthRequestContext;
                                double d13 = (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i15) + (fastBitmap3.MyBillsEntityDataFactory * i16)] >> 16) & 255;
                                Double.isNaN(d13);
                                d10 += d13;
                                FastBitmap fastBitmap4 = this.PlaceComponentResult.getAuthRequestContext;
                                double d14 = (fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i15) + (fastBitmap4.MyBillsEntityDataFactory * i16)] >> 8) & 255;
                                Double.isNaN(d14);
                                d11 += d14;
                                FastBitmap fastBitmap5 = this.PlaceComponentResult.getAuthRequestContext;
                                double d15 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i15) + (fastBitmap5.MyBillsEntityDataFactory * i16)] & 255;
                                Double.isNaN(d15);
                                d12 += d15;
                                i14++;
                            }
                        }
                    }
                    double d16 = i14;
                    Double.isNaN(d16);
                    double d17 = d10 / d16;
                    Double.isNaN(d16);
                    double d18 = d11 / d16;
                    Double.isNaN(d16);
                    double d19 = d12 / d16;
                    int i17 = i12 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                    double d20 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d21 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    double d22 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    while (i17 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i12) {
                        int i18 = i13 - this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                        while (i18 <= this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory + i13) {
                            if (i17 < 0 || i17 >= this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory + i4 || i18 < 0 || i18 >= this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                i = i4;
                                i2 = i13;
                                d = d17;
                                i3 = i12;
                            } else {
                                FastBitmap fastBitmap6 = this.PlaceComponentResult.getAuthRequestContext;
                                i = i4;
                                i2 = i13;
                                i3 = i12;
                                double d23 = (fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i17) + (fastBitmap6.MyBillsEntityDataFactory * i18)] >> 16) & 255;
                                Double.isNaN(d23);
                                d = d17;
                                d20 += Math.pow(d23 - d17, 2.0d);
                                FastBitmap fastBitmap7 = this.PlaceComponentResult.getAuthRequestContext;
                                double d24 = (fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i17) + (fastBitmap7.MyBillsEntityDataFactory * i18)] >> 8) & 255;
                                Double.isNaN(d24);
                                d22 += Math.pow(d24 - d18, 2.0d);
                                FastBitmap fastBitmap8 = this.PlaceComponentResult.getAuthRequestContext;
                                double d25 = fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i17) + (fastBitmap8.MyBillsEntityDataFactory * i18)] & 255;
                                Double.isNaN(d25);
                                d21 += Math.pow(d25 - d19, 2.0d);
                            }
                            i18++;
                            i12 = i3;
                            i4 = i;
                            i13 = i2;
                            d17 = d;
                        }
                        i17++;
                        i13 = i13;
                        d17 = d17;
                    }
                    int i19 = i4;
                    int i20 = i13;
                    int i21 = i12;
                    double d26 = (double) (i14 - 1);
                    Double.isNaN(d26);
                    double d27 = d20 / d26;
                    Double.isNaN(d26);
                    double d28 = d22 / d26;
                    Double.isNaN(d26);
                    double d29 = d21 / d26;
                    if (d27 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d27 = 0.0d;
                    }
                    if (d28 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d28 = 0.0d;
                    }
                    if (d29 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d29 = 0.0d;
                    }
                    if (d27 > 255.0d) {
                        d27 = 255.0d;
                    }
                    if (d28 > 255.0d) {
                        d28 = 255.0d;
                    }
                    if (d29 > 255.0d) {
                        d29 = 255.0d;
                    }
                    this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(i21, i20, (int) d27, (int) d28, (int) d29);
                    i12 = i21;
                    i13 = i20 + 1;
                    i4 = i19;
                    j = 4611686018427387904L;
                }
                i12++;
                i4 = i4;
            }
        }
    }
}
