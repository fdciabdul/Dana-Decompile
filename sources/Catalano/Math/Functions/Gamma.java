package Catalano.Math.Functions;

import Catalano.Math.Special;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public final class Gamma {
    private Gamma() {
    }

    public static double KClassImpl$Data$declaredNonStaticMembers$2(double d) {
        double[] dArr = {8.116141674705085E-4d, -5.950619042843014E-4d, 7.936503404577169E-4d, -0.002777777777300997d, 0.08333333333333319d};
        double[] dArr2 = {-1378.2515256912086d, -38801.631513463784d, -331612.9927388712d, -1162370.974927623d, -1721737.0082083966d, -853555.6642457654d};
        double[] dArr3 = {-351.81570143652345d, -17064.210665188115d, -220528.59055385445d, -1139334.4436798252d, -2532523.0717758294d, -2018891.4143353277d};
        if (d < -34.0d) {
            double d2 = -d;
            double KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(d2);
            double floor = Math.floor(d2);
            if (floor == d2) {
                try {
                    throw new ArithmeticException("Overflow.");
                } catch (Exception unused) {
                }
            }
            double d3 = d2 - floor;
            if (d3 > 0.5d) {
                d3 = (floor + 1.0d) - d2;
            }
            double sin = d2 * Math.sin(d3 * 3.141592653589793d);
            if (sin == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                try {
                    throw new ArithmeticException("Overflow.");
                } catch (Exception unused2) {
                    return (1.1447298858494002d - Math.log(sin)) - KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
            return (1.1447298858494002d - Math.log(sin)) - KClassImpl$Data$declaredNonStaticMembers$2;
        } else if (d >= 13.0d) {
            if (d > 2.556348E305d) {
                try {
                    throw new ArithmeticException("Overflow.");
                } catch (Exception unused3) {
                }
            }
            double log = (((d - 0.5d) * Math.log(d)) - d) + 0.9189385332046728d;
            if (d > 1.0E8d) {
                return log;
            }
            double d4 = 1.0d / (d * d);
            return log + ((d >= 1000.0d ? (((7.936507936507937E-4d * d4) - 0.002777777777777778d) * d4) + 0.08333333333333333d : Special.MyBillsEntityDataFactory(d4, dArr, 4)) / d);
        } else {
            double d5 = 1.0d;
            while (d >= 3.0d) {
                d -= 1.0d;
                d5 *= d;
            }
            while (d < 2.0d) {
                if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    try {
                        throw new ArithmeticException("Overflow.");
                        break;
                    } catch (Exception unused4) {
                        d5 /= d;
                        d += 1.0d;
                    }
                }
                d5 /= d;
                d += 1.0d;
            }
            if (d5 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d5 = -d5;
            }
            if (d == 2.0d) {
                return Math.log(d5);
            }
            double d6 = d - 2.0d;
            return Math.log(d5) + ((Special.MyBillsEntityDataFactory(d6, dArr2, 5) * d6) / Special.MyBillsEntityDataFactory(d6, dArr3));
        }
    }
}
