package Catalano.Imaging.Tools;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class ColorConverter {
    private static final double[][] getErrorConfigVersion = {new double[]{0.38971d, 0.68898d, -0.07868d}, new double[]{-0.22981d, 1.1834d, 0.04641d}, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d}};
    private static final double[][] scheduleImpl = {new double[]{1.9102d, -1.11212d, 0.20191d}, new double[]{0.37095d, 0.62905d, -1.0E-5d}, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d}};
    private static final double[][] getAuthRequestContext = {new double[]{0.8951d, 0.2664d, -0.1614d}, new double[]{-0.7502d, 1.7135d, 0.0367d}, new double[]{0.0389d, -0.0685d, 1.0296d}};
    private static final double[][] PlaceComponentResult = {new double[]{0.9869929d, -0.1470543d, 0.1599627d}, new double[]{0.4323053d, 0.5183603d, 0.0492912d}, new double[]{-0.0085287d, 0.0400428d, 0.9684867d}};
    private static final double[][] NetworkUserEntityData$$ExternalSyntheticLambda2 = {new double[]{0.4002d, 0.7076d, -0.0808d}, new double[]{-0.2263d, 1.1653d, 0.0457d}, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.9182d}};
    private static final double[][] DatabaseTableConfigUtil = {new double[]{1.86007d, -1.12948d, 0.2199d}, new double[]{0.36122d, 0.6388d, -1.0E-5d}, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.08909d}};
    private static final double[][] moveToNextValue = {new double[]{0.8562d, 0.3372d, -0.1934d}, new double[]{-0.836d, 1.8327d, 0.0033d}, new double[]{0.0357d, -0.00469d, 1.0112d}};
    private static final double[][] KClassImpl$Data$declaredNonStaticMembers$2 = {new double[]{0.9838112d, -0.1805292d, 0.1887508d}, new double[]{0.4488317d, 0.4632779d, 0.0843307d}, new double[]{-0.0326513d, 0.0085222d, 0.9826514d}};
    private static final double[][] MyBillsEntityDataFactory = {new double[]{0.7328d, 0.4296d, -0.1624d}, new double[]{-0.7036d, 1.6975d, 0.0061d}, new double[]{0.003d, 0.0136d, 0.9834d}};
    private static final double[][] BuiltInFictitiousFunctionClassFactory = {new double[]{1.0961238d, -0.278869d, 0.1827452d}, new double[]{0.454369d, 0.4735332d, 0.0720978d}, new double[]{-0.0096276d, -0.005698d, 1.0153256d}};
    private static double NetworkUserEntityData$$ExternalSyntheticLambda0 = 903.2962962962963d;
    private static double lookAheadTest = 0.0088564516790356d;

    /* loaded from: classes6.dex */
    public enum LMS {
        HPE,
        Bradford,
        VonKries,
        CAT97,
        CAT02
    }

    /* loaded from: classes6.dex */
    public enum YCbCrColorSpace {
        ITU_BT_601,
        ITU_BT_709_HDTV
    }

    private static double KClassImpl$Data$declaredNonStaticMembers$2(double d, double d2, double d3) {
        double d4;
        if (d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d3 += 1.0d;
        }
        if (d3 > 1.0d) {
            d3 -= 1.0d;
        }
        if (d3 * 6.0d < 1.0d) {
            d4 = (d2 - d) * 6.0d * d3;
        } else if (d3 * 2.0d < 1.0d) {
            return d2;
        } else {
            if (3.0d * d3 >= 2.0d) {
                return d;
            }
            d4 = (d2 - d) * (0.6666666865348816d - d3) * 6.0d;
        }
        return d + d4;
    }

    private ColorConverter() {
    }

    public static double[] MyBillsEntityDataFactory(int i, int i2, int i3, YCbCrColorSpace yCbCrColorSpace) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5 = i;
        Double.isNaN(d5);
        double d6 = d5 / 255.0d;
        double d7 = i2;
        Double.isNaN(d7);
        double d8 = d7 / 255.0d;
        double d9 = i3;
        Double.isNaN(d9);
        double d10 = d9 / 255.0d;
        double[] dArr = new double[3];
        if (yCbCrColorSpace == YCbCrColorSpace.ITU_BT_601) {
            d = (0.299d * d6) + (0.587d * d8) + (0.114d * d10);
            d2 = (((-0.169d) * d6) - (0.331d * d8)) + (d10 * 0.5d);
            d3 = (d6 * 0.5d) - (d8 * 0.419d);
            d4 = 0.081d;
        } else {
            d = (0.2215d * d6) + (0.7154d * d8) + (0.0721d * d10);
            d2 = (((-0.1145d) * d6) - (0.3855d * d8)) + (0.5d * d10);
            d3 = (d6 * 0.5016d) - (d8 * 0.4556d);
            d4 = 0.0459d;
        }
        dArr[0] = d;
        dArr[1] = d2;
        dArr[2] = d3 - (d10 * d4);
        return dArr;
    }

    public static int[] KClassImpl$Data$declaredNonStaticMembers$2(double d, double d2, double d3, YCbCrColorSpace yCbCrColorSpace) {
        double d4;
        double d5;
        double d6;
        int[] iArr = new int[3];
        if (yCbCrColorSpace == YCbCrColorSpace.ITU_BT_601) {
            d4 = ((d2 * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + d + (1.403d * d3)) * 255.0d;
            d5 = ((d - (0.344d * d2)) - (0.714d * d3)) * 255.0d;
            d6 = 1.773d;
        } else {
            d4 = ((d2 * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + d + (1.5701d * d3)) * 255.0d;
            d5 = ((d - (0.187d * d2)) - (0.4664d * d3)) * 255.0d;
            d6 = 1.8556d;
        }
        iArr[0] = (int) d4;
        iArr[1] = (int) d5;
        iArr[2] = (int) (((d6 * d2) + d + (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE * d3)) * 255.0d);
        return iArr;
    }

    /* renamed from: Catalano.Imaging.Tools.ColorConverter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LMS.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[LMS.HPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[LMS.Bradford.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[LMS.VonKries.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[LMS.CAT97.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static double[] PlaceComponentResult(int i, int i2, int i3) {
        double d;
        double d2;
        double[] dArr = new double[3];
        double d3 = i / 255.0f;
        double d4 = i2 / 255.0f;
        double d5 = i3 / 255.0f;
        double max = Math.max(d3, Math.max(d4, d5));
        double min = Math.min(d3, Math.min(d4, d5));
        double d6 = max - min;
        double d7 = max + min;
        double d8 = d7 / 2.0d;
        double d9 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d = 0.0d;
        } else {
            d = d8 <= 0.5d ? d6 / d7 : d6 / ((2.0d - max) - min);
            if (d3 == max) {
                Double.isNaN(d4);
                Double.isNaN(d5);
                d2 = ((d4 - d5) / 6.0d) / d6;
            } else if (d4 == max) {
                Double.isNaN(d5);
                Double.isNaN(d3);
                d2 = 0.3333333432674408d + (((d5 - d3) / 6.0d) / d6);
            } else {
                Double.isNaN(d3);
                Double.isNaN(d4);
                d2 = (((d3 - d4) / 6.0d) / d6) + 0.6666666865348816d;
            }
            if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d2 += 1.0d;
            }
            if (d2 > 1.0d) {
                d2 -= 1.0d;
            }
            d9 = (int) (d2 * 360.0d);
        }
        dArr[0] = d9;
        dArr[1] = d;
        dArr[2] = d8;
        return dArr;
    }

    public static int[] MyBillsEntityDataFactory(double d, double d2, double d3) {
        double KClassImpl$Data$declaredNonStaticMembers$22;
        double KClassImpl$Data$declaredNonStaticMembers$23;
        double d4;
        int[] iArr = new int[3];
        if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d4 = (int) (255.0d * d3);
            KClassImpl$Data$declaredNonStaticMembers$23 = d4;
            KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$23;
        } else {
            double d5 = d / 360.0d;
            double d6 = d3 < 0.5d ? (d2 + 1.0d) * d3 : (d3 + d2) - (d3 * d2);
            double d7 = (2.0d * d3) - d6;
            double d8 = d6;
            double KClassImpl$Data$declaredNonStaticMembers$24 = (int) (KClassImpl$Data$declaredNonStaticMembers$2(d7, d8, d5 + 0.3333333432674408d) * 255.0d);
            KClassImpl$Data$declaredNonStaticMembers$22 = (int) (KClassImpl$Data$declaredNonStaticMembers$2(d7, d8, d5) * 255.0d);
            KClassImpl$Data$declaredNonStaticMembers$23 = (int) (KClassImpl$Data$declaredNonStaticMembers$2(d7, d8, d5 - 0.3333333432674408d) * 255.0d);
            d4 = KClassImpl$Data$declaredNonStaticMembers$24;
        }
        iArr[0] = (int) d4;
        iArr[1] = (int) KClassImpl$Data$declaredNonStaticMembers$22;
        iArr[2] = (int) KClassImpl$Data$declaredNonStaticMembers$23;
        return iArr;
    }
}
