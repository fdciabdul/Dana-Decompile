package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Grayscale implements IApplyInPlace {
    public Algorithm PlaceComponentResult;
    public double getAuthRequestContext = 0.2125d;
    public double KClassImpl$Data$declaredNonStaticMembers$2 = 0.7154d;
    public double BuiltInFictitiousFunctionClassFactory = 0.0721d;
    public boolean MyBillsEntityDataFactory = false;

    /* loaded from: classes6.dex */
    public enum Algorithm {
        Lightness,
        Average,
        GeometricMean,
        Luminosity,
        MinimumDecomposition,
        MaximumDecomposition
    }

    public Grayscale() {
    }

    public Grayscale(Algorithm algorithm) {
        this.PlaceComponentResult = algorithm;
    }

    /* renamed from: Catalano.Imaging.Filters.Grayscale$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Algorithm.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Algorithm.Lightness.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Algorithm.Average.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[Algorithm.GeometricMean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[Algorithm.Luminosity.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PlaceComponentResult[Algorithm.MinimumDecomposition.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                PlaceComponentResult[Algorithm.MaximumDecomposition.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
