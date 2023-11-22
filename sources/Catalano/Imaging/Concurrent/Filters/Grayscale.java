package Catalano.Imaging.Concurrent.Filters;

import Catalano.Imaging.Concurrent.Share;
import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Grayscale implements IApplyInPlace {
    private double BuiltInFictitiousFunctionClassFactory = 0.2125d;
    private double PlaceComponentResult = 0.7154d;
    private double MyBillsEntityDataFactory = 0.0721d;
    private Algorithm getAuthRequestContext = Algorithm.Luminosity;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

    /* loaded from: classes6.dex */
    public enum Algorithm {
        Lightness,
        Average,
        GeometricMean,
        Luminosity,
        MinimumDecomposition,
        MaximumDecomposition
    }

    /* loaded from: classes6.dex */
    class Run implements Runnable {
        private Share PlaceComponentResult;
        final /* synthetic */ Grayscale getAuthRequestContext;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                for (int i = this.PlaceComponentResult.MyBillsEntityDataFactory; i < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i++) {
                    for (int i2 = 0; i2 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i2++) {
                        FastBitmap fastBitmap = this.PlaceComponentResult.getAuthRequestContext;
                        double d = (fastBitmap.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap.PlaceComponentResult * i) + (fastBitmap.MyBillsEntityDataFactory * i2)] >> 16) & 255;
                        FastBitmap fastBitmap2 = this.PlaceComponentResult.getAuthRequestContext;
                        double d2 = (fastBitmap2.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap2.PlaceComponentResult * i) + (fastBitmap2.MyBillsEntityDataFactory * i2)] >> 8) & 255;
                        FastBitmap fastBitmap3 = this.PlaceComponentResult.getAuthRequestContext;
                        double d3 = fastBitmap3.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap3.PlaceComponentResult * i) + (fastBitmap3.MyBillsEntityDataFactory * i2)] & 255;
                        double d4 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
                        double d5 = this.getAuthRequestContext.PlaceComponentResult;
                        double d6 = this.getAuthRequestContext.MyBillsEntityDataFactory;
                        FastBitmap fastBitmap4 = this.PlaceComponentResult.getAuthRequestContext;
                        Double.isNaN(d);
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        fastBitmap4.MyBillsEntityDataFactory(i, i2, (int) ((d * d4) + (d2 * d5) + (d3 * d6)));
                    }
                }
                return;
            }
            switch (AnonymousClass1.MyBillsEntityDataFactory[this.getAuthRequestContext.getAuthRequestContext.ordinal()]) {
                case 1:
                    for (int i3 = this.PlaceComponentResult.MyBillsEntityDataFactory; i3 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i3++) {
                        for (int i4 = 0; i4 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i4++) {
                            FastBitmap fastBitmap5 = this.PlaceComponentResult.getAuthRequestContext;
                            double d7 = (fastBitmap5.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap5.PlaceComponentResult * i3) + (fastBitmap5.MyBillsEntityDataFactory * i4)] >> 16) & 255;
                            FastBitmap fastBitmap6 = this.PlaceComponentResult.getAuthRequestContext;
                            double d8 = (fastBitmap6.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap6.PlaceComponentResult * i3) + (fastBitmap6.MyBillsEntityDataFactory * i4)] >> 8) & 255;
                            FastBitmap fastBitmap7 = this.PlaceComponentResult.getAuthRequestContext;
                            double d9 = fastBitmap7.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap7.PlaceComponentResult * i3) + (fastBitmap7.MyBillsEntityDataFactory * i4)] & 255;
                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i3, i4, (int) ((Math.max(Math.max(d7, d8), d9) + Math.min(Math.min(d7, d8), d9)) / 2.0d));
                        }
                    }
                    return;
                case 2:
                    for (int i5 = this.PlaceComponentResult.MyBillsEntityDataFactory; i5 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i5++) {
                        for (int i6 = 0; i6 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i6++) {
                            FastBitmap fastBitmap8 = this.PlaceComponentResult.getAuthRequestContext;
                            double d10 = (fastBitmap8.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap8.PlaceComponentResult * i5) + (fastBitmap8.MyBillsEntityDataFactory * i6)] >> 16) & 255;
                            FastBitmap fastBitmap9 = this.PlaceComponentResult.getAuthRequestContext;
                            double d11 = (fastBitmap9.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap9.PlaceComponentResult * i5) + (fastBitmap9.MyBillsEntityDataFactory * i6)] >> 8) & 255;
                            FastBitmap fastBitmap10 = this.PlaceComponentResult.getAuthRequestContext;
                            double d12 = fastBitmap10.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap10.PlaceComponentResult * i5) + (fastBitmap10.MyBillsEntityDataFactory * i6)] & 255;
                            Double.isNaN(d10);
                            Double.isNaN(d11);
                            Double.isNaN(d12);
                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i5, i6, (int) (((d10 + d11) + d12) / 3.0d));
                        }
                    }
                    return;
                case 3:
                    for (int i7 = this.PlaceComponentResult.MyBillsEntityDataFactory; i7 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i7++) {
                        for (int i8 = 0; i8 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i8++) {
                            FastBitmap fastBitmap11 = this.PlaceComponentResult.getAuthRequestContext;
                            double d13 = (fastBitmap11.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap11.PlaceComponentResult * i7) + (fastBitmap11.MyBillsEntityDataFactory * i8)] >> 16) & 255;
                            FastBitmap fastBitmap12 = this.PlaceComponentResult.getAuthRequestContext;
                            double d14 = (fastBitmap12.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap12.PlaceComponentResult * i7) + (fastBitmap12.MyBillsEntityDataFactory * i8)] >> 8) & 255;
                            FastBitmap fastBitmap13 = this.PlaceComponentResult.getAuthRequestContext;
                            double d15 = fastBitmap13.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap13.PlaceComponentResult * i7) + (fastBitmap13.MyBillsEntityDataFactory * i8)] & 255;
                            Double.isNaN(d13);
                            Double.isNaN(d14);
                            Double.isNaN(d15);
                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i7, i8, (int) Math.pow(d13 * d14 * d15, 0.33d));
                        }
                    }
                    return;
                case 4:
                    for (int i9 = this.PlaceComponentResult.MyBillsEntityDataFactory; i9 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i9++) {
                        for (int i10 = 0; i10 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i10++) {
                            FastBitmap fastBitmap14 = this.PlaceComponentResult.getAuthRequestContext;
                            double d16 = (fastBitmap14.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap14.PlaceComponentResult * i9) + (fastBitmap14.MyBillsEntityDataFactory * i10)] >> 16) & 255;
                            FastBitmap fastBitmap15 = this.PlaceComponentResult.getAuthRequestContext;
                            double d17 = (fastBitmap15.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap15.PlaceComponentResult * i9) + (fastBitmap15.MyBillsEntityDataFactory * i10)] >> 8) & 255;
                            FastBitmap fastBitmap16 = this.PlaceComponentResult.getAuthRequestContext;
                            double d18 = fastBitmap16.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap16.PlaceComponentResult * i9) + (fastBitmap16.MyBillsEntityDataFactory * i10)] & 255;
                            FastBitmap fastBitmap17 = this.PlaceComponentResult.getAuthRequestContext;
                            Double.isNaN(d16);
                            Double.isNaN(d17);
                            Double.isNaN(d18);
                            fastBitmap17.MyBillsEntityDataFactory(i9, i10, (int) ((d16 * 0.2125d) + (d17 * 0.7154d) + (d18 * 0.0721d)));
                        }
                    }
                    return;
                case 5:
                    for (int i11 = this.PlaceComponentResult.MyBillsEntityDataFactory; i11 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i11++) {
                        for (int i12 = 0; i12 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i12++) {
                            FastBitmap fastBitmap18 = this.PlaceComponentResult.getAuthRequestContext;
                            double d19 = (fastBitmap18.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap18.PlaceComponentResult * i11) + (fastBitmap18.MyBillsEntityDataFactory * i12)] >> 16) & 255;
                            FastBitmap fastBitmap19 = this.PlaceComponentResult.getAuthRequestContext;
                            double min = Math.min(d19, (fastBitmap19.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap19.PlaceComponentResult * i11) + (fastBitmap19.MyBillsEntityDataFactory * i12)] >> 8) & 255);
                            FastBitmap fastBitmap20 = this.PlaceComponentResult.getAuthRequestContext;
                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i11, i12, (int) Math.min(min, fastBitmap20.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap20.PlaceComponentResult * i11) + (fastBitmap20.MyBillsEntityDataFactory * i12)] & 255));
                        }
                    }
                    return;
                case 6:
                    for (int i13 = this.PlaceComponentResult.MyBillsEntityDataFactory; i13 < this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory; i13++) {
                        for (int i14 = 0; i14 < this.PlaceComponentResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.getWidth(); i14++) {
                            FastBitmap fastBitmap21 = this.PlaceComponentResult.getAuthRequestContext;
                            double d20 = (fastBitmap21.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap21.PlaceComponentResult * i13) + (fastBitmap21.MyBillsEntityDataFactory * i14)] >> 16) & 255;
                            FastBitmap fastBitmap22 = this.PlaceComponentResult.getAuthRequestContext;
                            double max = Math.max(d20, (fastBitmap22.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap22.PlaceComponentResult * i13) + (fastBitmap22.MyBillsEntityDataFactory * i14)] >> 8) & 255);
                            FastBitmap fastBitmap23 = this.PlaceComponentResult.getAuthRequestContext;
                            this.PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory(i13, i14, (int) Math.max(max, fastBitmap23.KClassImpl$Data$declaredNonStaticMembers$2[(fastBitmap23.PlaceComponentResult * i13) + (fastBitmap23.MyBillsEntityDataFactory * i14)] & 255));
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: Catalano.Imaging.Concurrent.Filters.Grayscale$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Algorithm.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Algorithm.Lightness.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.Average.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.GeometricMean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.Luminosity.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.MinimumDecomposition.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.MaximumDecomposition.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
