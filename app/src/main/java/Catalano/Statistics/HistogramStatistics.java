package Catalano.Statistics;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public final class HistogramStatistics {
    private HistogramStatistics() {
    }

    public static double PlaceComponentResult(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        if (i != 0) {
            double d = 0.0d;
            for (double d2 : iArr) {
                double d3 = i;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = d2 / d3;
                if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d += (-d4) * (Math.log10(d4) / Math.log10(2.0d));
                }
            }
            return d;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static double getAuthRequestContext(int[] iArr, double d, double d2) {
        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d4 = 0.0d;
        for (double d5 : iArr) {
            Double.isNaN(d5);
            d4 += d5;
        }
        double d6 = d4 - 1.0d;
        double d7 = d4 - 2.0d;
        double d8 = d4 - 3.0d;
        double d9 = ((1.0d + d4) * d4) / ((d6 * d7) * d8);
        for (int i = 0; i < iArr.length; i++) {
            double d10 = i;
            Double.isNaN(d10);
            double pow = Math.pow((d10 - d) / d2, 4.0d);
            double d11 = iArr[i];
            Double.isNaN(d11);
            d3 += pow * d11;
        }
        return (d9 * d3) - ((Math.pow(d6, 2.0d) * 3.0d) / (d7 * d8));
    }

    public static double BuiltInFictitiousFunctionClassFactory(int[] iArr) {
        int length = iArr.length;
        long j = 0;
        double d = 0.0d;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            double d2 = i * i2;
            Double.isNaN(d2);
            d += d2;
            j += i2;
        }
        if (j == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d3 = j;
        Double.isNaN(d3);
        return d / d3;
    }

    public static int getAuthRequestContext(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = i2 / 2;
        int i5 = 0;
        while (i < length) {
            i5 += iArr[i];
            if (i5 >= i4) {
                break;
            }
            i++;
        }
        return i;
    }

    public static int MyBillsEntityDataFactory(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 > i2) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    public static double PlaceComponentResult(int[] iArr, double d, double d2) {
        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d4 = 0.0d;
        for (double d5 : iArr) {
            Double.isNaN(d5);
            d4 += d5;
        }
        double d6 = d4 / (d4 - 1.0d);
        for (int i = 0; i < iArr.length; i++) {
            double d7 = i;
            Double.isNaN(d7);
            double pow = Math.pow((d7 - d) / d2, 3.0d);
            double d8 = iArr[i];
            Double.isNaN(d8);
            d3 += pow * d8;
        }
        return d6 * (d4 - 2.0d) * d3;
    }

    public static double getAuthRequestContext(int[] iArr, double d) {
        int length = iArr.length;
        double d2 = 0.0d;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            double d3 = i2;
            Double.isNaN(d3);
            double d4 = d3 - d;
            double d5 = i3;
            Double.isNaN(d5);
            d2 += d4 * d4 * d5;
            i += i3;
        }
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d6 = (double) (i - 1);
        Double.isNaN(d6);
        return Math.sqrt(d2 / d6);
    }
}
