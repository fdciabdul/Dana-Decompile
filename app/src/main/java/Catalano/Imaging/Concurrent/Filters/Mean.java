package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Mean implements IApplyInPlace {
    private FastBitmap MyBillsEntityDataFactory;
    private int getAuthRequestContext = 1;
    private Arithmetic PlaceComponentResult = Arithmetic.Mean;
    private int BuiltInFictitiousFunctionClassFactory = 1;

    /* loaded from: classes6.dex */
    public enum Arithmetic {
        Mean,
        Harmonic,
        ContraHarmonic,
        Geometry
    }

    static /* synthetic */ int BuiltInFictitiousFunctionClassFactory(int i) {
        return (i * 2) + 1;
    }

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        final /* synthetic */ Mean KClassImpl$Data$declaredNonStaticMembers$2;
        private Share getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int BuiltInFictitiousFunctionClassFactory = Mean.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
            int i10 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                Share share = this.getAuthRequestContext;
                share.BuiltInFictitiousFunctionClassFactory = share.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getHeight();
                i10 = 0;
            }
            int i11 = AnonymousClass1.PlaceComponentResult[this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.ordinal()];
            if (i11 == 1) {
                int i12 = BuiltInFictitiousFunctionClassFactory;
                int i13 = i10;
                if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    for (int i14 = this.getAuthRequestContext.MyBillsEntityDataFactory; i14 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i14++) {
                        int i15 = 0;
                        while (i15 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                            int i16 = i12;
                            int i17 = 0;
                            int i18 = 0;
                            for (int i19 = 0; i19 < i16; i19++) {
                                int i20 = (i19 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i14;
                                for (int i21 = 0; i21 < i16; i21++) {
                                    int i22 = (i21 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i15;
                                    if (i20 >= 0 && i20 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i13 && i22 >= 0 && i22 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                        FastBitmap fastBitmap = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        i17 += fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i20) + (i22 * fastBitmap.MyBillsEntityDataFactory)] & 255;
                                        i18++;
                                    }
                                }
                            }
                            this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i14, i15, i17 / i18);
                            i15++;
                            i12 = i16;
                        }
                    }
                } else if (this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext()) {
                    for (int i23 = this.getAuthRequestContext.MyBillsEntityDataFactory; i23 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i23++) {
                        for (int i24 = 0; i24 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i24++) {
                            int i25 = 0;
                            int i26 = 0;
                            int i27 = 0;
                            int i28 = 0;
                            for (int i29 = 0; i29 < i12; i29++) {
                                int i30 = (i29 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i23;
                                for (int i31 = 0; i31 < i12; i31++) {
                                    int i32 = (i31 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i24;
                                    if (i30 >= 0 && i30 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i13 && i32 >= 0 && i32 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                        FastBitmap fastBitmap2 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        i25 += (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i30) + (fastBitmap2.MyBillsEntityDataFactory * i32)] >> 16) & 255;
                                        FastBitmap fastBitmap3 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        i27 += (fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i30) + (fastBitmap3.MyBillsEntityDataFactory * i32)] >> 8) & 255;
                                        FastBitmap fastBitmap4 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        i28 += fastBitmap4.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap4.PlaceComponentResult * i30) + (i32 * fastBitmap4.MyBillsEntityDataFactory)] & 255;
                                        i26++;
                                    }
                                }
                            }
                            this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i23, i24, i25 / i26, i27 / i26, i28 / i26);
                        }
                    }
                }
            } else if (i11 == 2) {
                int i33 = BuiltInFictitiousFunctionClassFactory;
                int i34 = i10;
                if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    for (int i35 = this.getAuthRequestContext.MyBillsEntityDataFactory; i35 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i35++) {
                        int i36 = 0;
                        while (i36 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                            int i37 = i33;
                            int i38 = 0;
                            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            for (int i39 = 0; i39 < i37; i39++) {
                                int i40 = (i39 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i35;
                                for (int i41 = 0; i41 < i37; i41++) {
                                    int i42 = (i41 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i36;
                                    if (i40 >= 0 && i40 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i34 && i42 >= 0 && i42 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                        FastBitmap fastBitmap5 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        double d2 = fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i40) + (i42 * fastBitmap5.MyBillsEntityDataFactory)] & 255;
                                        Double.isNaN(d2);
                                        d += 1.0d / d2;
                                        i38++;
                                    }
                                }
                            }
                            double d3 = i38;
                            Double.isNaN(d3);
                            this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i35, i36, (int) (d3 / d));
                            i36++;
                            i33 = i37;
                        }
                    }
                    return;
                }
                int i43 = i33;
                if (this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext()) {
                    for (int i44 = this.getAuthRequestContext.MyBillsEntityDataFactory; i44 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i44++) {
                        int i45 = 0;
                        while (i45 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                            int i46 = 0;
                            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            for (int i47 = 0; i47 < i43; i47++) {
                                int i48 = (i47 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i44;
                                int i49 = 0;
                                while (i49 < i43) {
                                    int i50 = (i49 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i45;
                                    if (i48 < 0 || i48 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i34 || i50 < 0 || i50 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                        i = i45;
                                        i2 = i43;
                                    } else {
                                        FastBitmap fastBitmap6 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        i2 = i43;
                                        i = i45;
                                        double d7 = (fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i48) + (fastBitmap6.MyBillsEntityDataFactory * i50)] >> 16) & 255;
                                        Double.isNaN(d7);
                                        d4 += 1.0d / d7;
                                        FastBitmap fastBitmap7 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        double d8 = (fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i48) + (fastBitmap7.MyBillsEntityDataFactory * i50)] >> 8) & 255;
                                        Double.isNaN(d8);
                                        d5 += 1.0d / d8;
                                        FastBitmap fastBitmap8 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        double d9 = fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i48) + (i50 * fastBitmap8.MyBillsEntityDataFactory)] & 255;
                                        Double.isNaN(d9);
                                        d6 += 1.0d / d9;
                                        i46++;
                                    }
                                    i49++;
                                    i43 = i2;
                                    i45 = i;
                                }
                            }
                            int i51 = i45;
                            double d10 = i46;
                            Double.isNaN(d10);
                            Double.isNaN(d10);
                            Double.isNaN(d10);
                            this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i44, i51, (int) (d10 / d4), (int) (d10 / d5), (int) (d10 / d6));
                            i45 = i51 + 1;
                            i43 = i43;
                        }
                    }
                }
            } else if (i11 != 3) {
                if (i11 == 4) {
                    if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        for (int i52 = this.getAuthRequestContext.MyBillsEntityDataFactory; i52 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i52++) {
                            for (int i53 = 0; i53 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i53++) {
                                int i54 = 0;
                                double d11 = 1.0d;
                                for (int i55 = 0; i55 < BuiltInFictitiousFunctionClassFactory; i55++) {
                                    int i56 = (i55 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i52;
                                    for (int i57 = 0; i57 < BuiltInFictitiousFunctionClassFactory; i57++) {
                                        int i58 = (i57 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i53;
                                        if (i56 >= 0 && i56 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i10 && i58 >= 0 && i58 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                            FastBitmap fastBitmap9 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            double d12 = fastBitmap9.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap9.PlaceComponentResult * i56) + (i58 * fastBitmap9.MyBillsEntityDataFactory)] & 255;
                                            Double.isNaN(d12);
                                            d11 *= d12;
                                            i54++;
                                        }
                                    }
                                }
                                double d13 = i54;
                                Double.isNaN(d13);
                                this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i52, i53, (int) Math.pow(d11, 1.0d / d13));
                            }
                        }
                    } else if (this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext()) {
                        for (int i59 = this.getAuthRequestContext.MyBillsEntityDataFactory; i59 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory; i59++) {
                            int i60 = 0;
                            while (i60 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                double d14 = 1.0d;
                                double d15 = 1.0d;
                                double d16 = 1.0d;
                                int i61 = 0;
                                for (int i62 = 0; i62 < BuiltInFictitiousFunctionClassFactory; i62++) {
                                    int i63 = (i62 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i59;
                                    int i64 = 0;
                                    while (i64 < BuiltInFictitiousFunctionClassFactory) {
                                        int i65 = (i64 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i60;
                                        int i66 = BuiltInFictitiousFunctionClassFactory;
                                        if (i63 < 0 || i63 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i10 || i65 < 0 || i65 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                            i8 = i10;
                                            i9 = i60;
                                        } else {
                                            FastBitmap fastBitmap10 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            i8 = i10;
                                            i9 = i60;
                                            double d17 = (fastBitmap10.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap10.PlaceComponentResult * i63) + (fastBitmap10.MyBillsEntityDataFactory * i65)] >> 16) & 255;
                                            Double.isNaN(d17);
                                            d14 *= d17;
                                            FastBitmap fastBitmap11 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            double d18 = (fastBitmap11.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap11.PlaceComponentResult * i63) + (fastBitmap11.MyBillsEntityDataFactory * i65)] >> 8) & 255;
                                            Double.isNaN(d18);
                                            d15 *= d18;
                                            FastBitmap fastBitmap12 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            double d19 = fastBitmap12.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap12.PlaceComponentResult * i63) + (i65 * fastBitmap12.MyBillsEntityDataFactory)] & 255;
                                            Double.isNaN(d19);
                                            d16 *= d19;
                                            i61++;
                                        }
                                        i64++;
                                        BuiltInFictitiousFunctionClassFactory = i66;
                                        i10 = i8;
                                        i60 = i9;
                                    }
                                }
                                int i67 = BuiltInFictitiousFunctionClassFactory;
                                int i68 = i60;
                                double d20 = i61;
                                Double.isNaN(d20);
                                double d21 = 1.0d / d20;
                                this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i59, i68, (int) Math.pow(d14, d21), (int) Math.pow(d15, d21), (int) Math.pow(d16, d21));
                                i60 = i68 + 1;
                                BuiltInFictitiousFunctionClassFactory = i67;
                                i10 = i10;
                            }
                        }
                    }
                }
            } else {
                int i69 = BuiltInFictitiousFunctionClassFactory;
                int i70 = i10;
                if (this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    int i71 = this.getAuthRequestContext.MyBillsEntityDataFactory;
                    while (i71 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                        int i72 = 0;
                        while (i72 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                            int i73 = i69;
                            double d22 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d23 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            for (int i74 = 0; i74 < i73; i74++) {
                                int i75 = (i74 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i71;
                                int i76 = 0;
                                while (i76 < i73) {
                                    int i77 = (i76 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i72;
                                    if (i75 < 0 || i75 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i70 || i77 < 0 || i77 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                        i6 = i71;
                                        i7 = i72;
                                    } else {
                                        FastBitmap fastBitmap13 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        i6 = i71;
                                        i7 = i72;
                                        d22 += Math.pow(fastBitmap13.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap13.PlaceComponentResult * i75) + (fastBitmap13.MyBillsEntityDataFactory * i77)] & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory + 1);
                                        FastBitmap fastBitmap14 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                        d23 += Math.pow(fastBitmap14.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap14.PlaceComponentResult * i75) + (i77 * fastBitmap14.MyBillsEntityDataFactory)] & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                                    }
                                    i76++;
                                    i71 = i6;
                                    i72 = i7;
                                }
                            }
                            int i78 = i71;
                            int i79 = i72;
                            this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i78, i79, (int) (d22 / d23));
                            i72 = i79 + 1;
                            i69 = i73;
                            i71 = i78;
                        }
                        i71++;
                    }
                    return;
                }
                int i80 = i69;
                if (this.getAuthRequestContext.getAuthRequestContext.getAuthRequestContext()) {
                    int i81 = this.getAuthRequestContext.MyBillsEntityDataFactory;
                    while (i81 < this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                        int i82 = 0;
                        while (i82 < this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                            int i83 = 0;
                            double d24 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d25 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d26 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d27 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d28 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            double d29 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            while (i83 < i80) {
                                int i84 = (i83 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i81;
                                int i85 = i81;
                                int i86 = 0;
                                while (i86 < i80) {
                                    int i87 = i80;
                                    int i88 = (i86 - this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) + i82;
                                    if (i84 >= 0) {
                                        i4 = i82;
                                        if (i84 >= this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory + i70 || i88 < 0 || i88 >= this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth()) {
                                            i3 = i86;
                                        } else {
                                            FastBitmap fastBitmap15 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            i5 = i83;
                                            i3 = i86;
                                            d24 += Math.pow((fastBitmap15.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap15.PlaceComponentResult * i84) + (fastBitmap15.MyBillsEntityDataFactory * i88)] >> 16) & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory + 1);
                                            FastBitmap fastBitmap16 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            d26 += Math.pow((fastBitmap16.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap16.PlaceComponentResult * i84) + (fastBitmap16.MyBillsEntityDataFactory * i88)] >> 8) & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory + 1);
                                            FastBitmap fastBitmap17 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            d28 += Math.pow(fastBitmap17.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap17.PlaceComponentResult * i84) + (fastBitmap17.MyBillsEntityDataFactory * i88)] & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory + 1);
                                            FastBitmap fastBitmap18 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            d25 += Math.pow((fastBitmap18.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap18.PlaceComponentResult * i84) + (fastBitmap18.MyBillsEntityDataFactory * i88)] >> 16) & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                                            FastBitmap fastBitmap19 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            d27 += Math.pow((fastBitmap19.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap19.PlaceComponentResult * i84) + (fastBitmap19.MyBillsEntityDataFactory * i88)] >> 8) & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                                            FastBitmap fastBitmap20 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                                            d29 += Math.pow(fastBitmap20.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap20.PlaceComponentResult * i84) + (i88 * fastBitmap20.MyBillsEntityDataFactory)] & 255, this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                                            i86 = i3 + 1;
                                            i80 = i87;
                                            i82 = i4;
                                            i83 = i5;
                                        }
                                    } else {
                                        i3 = i86;
                                        i4 = i82;
                                    }
                                    i5 = i83;
                                    d27 = d27;
                                    i86 = i3 + 1;
                                    i80 = i87;
                                    i82 = i4;
                                    i83 = i5;
                                }
                                i83++;
                                i81 = i85;
                            }
                            int i89 = i81;
                            int i90 = i82;
                            this.getAuthRequestContext.getAuthRequestContext.MyBillsEntityDataFactory(i89, i90, (int) (d24 / d25), (int) (d26 / d27), (int) (d28 / d29));
                            i82 = i90 + 1;
                            i81 = i89;
                        }
                        i81++;
                    }
                }
            }
        }
    }

    /* renamed from: Catalano.Imaging.Concurrent.Filters.Mean$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Arithmetic.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Arithmetic.Mean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Arithmetic.Harmonic.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[Arithmetic.ContraHarmonic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[Arithmetic.Geometry.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
