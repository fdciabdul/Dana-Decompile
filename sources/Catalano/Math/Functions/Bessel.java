package Catalano.Math.Functions;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public final class Bessel {
    private Bessel() {
    }

    private static double BuiltInFictitiousFunctionClassFactory(double d) {
        double abs = Math.abs(d);
        if (abs < 8.0d) {
            double d2 = d * d;
            return (((((((((((-184.9052456d) * d2) + 77392.33017d) * d2) - 1.121442418E7d) * d2) + 6.516196407E8d) * d2) - 1.3362590354E10d) * d2) + 5.7568490574E10d) / ((d2 * ((((((((1.0d * d2) + 267.8532712d) * d2) + 59272.64853d) * d2) + 9494680.718d) * d2) + 1.029532985E9d)) + 5.7568490411E10d);
        }
        double d3 = 8.0d / abs;
        double d4 = d3 * d3;
        double d5 = abs - 0.785398164d;
        return Math.sqrt(0.636619772d / abs) * ((Math.cos(d5) * ((((((((2.093887211E-7d * d4) - 2.073370639E-6d) * d4) + 2.734510407E-5d) * d4) - 0.001098628627d) * d4) + 1.0d)) - ((d3 * Math.sin(d5)) * ((d4 * (((((7.621095161E-7d - (9.34935152E-8d * d4)) * d4) - 6.911147651E-6d) * d4) + 1.430488765E-4d)) - 0.01562499995d)));
    }

    private static double KClassImpl$Data$declaredNonStaticMembers$2(double d) {
        double abs = Math.abs(d);
        if (abs < 8.0d) {
            double d2 = d * d;
            return ((((((((((((-30.16036606d) * d2) + 15704.4826d) * d2) - 2972611.439d) * d2) + 2.423968531E8d) * d2) - 7.895059235E9d) * d2) + 7.2362614232E10d) * d) / ((d2 * ((((((((1.0d * d2) + 376.9991397d) * d2) + 99447.43394d) * d2) + 1.858330474E7d) * d2) + 2.300535178E9d)) + 1.44725228442E11d);
        }
        double d3 = 8.0d / abs;
        double d4 = abs - 2.356194491d;
        double d5 = d3 * d3;
        double sqrt = Math.sqrt(0.636619772d / abs) * ((Math.cos(d4) * (((((((((-2.40337019E-7d) * d5) + 2.457520174E-6d) * d5) - 3.516396496E-5d) * d5) + 0.00183105d) * d5) + 1.0d)) - ((d3 * Math.sin(d4)) * ((d5 * ((((((1.05787412E-7d * d5) - 8.8228987E-7d) * d5) + 8.449199096E-6d) * d5) - 2.002690873E-4d)) + 0.04687499995d)));
        return d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -sqrt : sqrt;
    }

    public static double PlaceComponentResult(int i, double d) {
        double d2;
        if (i == 0) {
            return BuiltInFictitiousFunctionClassFactory(d);
        }
        if (i == 1) {
            return KClassImpl$Data$declaredNonStaticMembers$2(d);
        }
        double abs = Math.abs(d);
        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (abs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d4 = i;
        if (abs > d4) {
            double d5 = 2.0d / abs;
            double BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(abs);
            d2 = KClassImpl$Data$declaredNonStaticMembers$2(abs);
            int i2 = 1;
            while (i2 < i) {
                double d6 = i2;
                i2++;
                Double.isNaN(d6);
                double d7 = ((d6 * d5) * d2) - BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = d2;
                d2 = d7;
            }
        } else {
            double d8 = 2.0d / abs;
            Double.isNaN(d4);
            boolean z = false;
            double d9 = 1.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            double d12 = 0.0d;
            for (int sqrt = ((((int) Math.sqrt(d4 * 40.0d)) + i) / 2) * 2; sqrt > 0; sqrt--) {
                double d13 = sqrt;
                Double.isNaN(d13);
                double d14 = ((d13 * d8) * d9) - d12;
                if (Math.abs(d14) > 1.0E10d) {
                    d14 *= 1.0E-10d;
                    d9 *= 1.0E-10d;
                    d10 *= 1.0E-10d;
                    d11 *= 1.0E-10d;
                }
                d12 = d9;
                d9 = d14;
                if (z) {
                    d11 += d9;
                }
                z = !z;
                if (sqrt == i) {
                    d10 = d12;
                }
            }
            d2 = d10 / ((d11 * 2.0d) - d9);
            d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return (d >= d3 || i % 2 != 1) ? d2 : -d2;
    }
}
