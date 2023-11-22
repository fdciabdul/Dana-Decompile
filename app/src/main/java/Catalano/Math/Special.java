package Catalano.Math;

import Catalano.Math.Functions.Gamma;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public final class Special {
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static double[] MyBillsEntityDataFactory;
    private static double[] PlaceComponentResult;

    private Special() {
    }

    public static double MyBillsEntityDataFactory(double d, double[] dArr, int i) {
        double d2 = dArr[0];
        for (int i2 = 1; i2 <= i; i2++) {
            d2 = (d2 * d) + dArr[i2];
        }
        return d2;
    }

    public static double MyBillsEntityDataFactory(double d, double[] dArr) {
        double d2 = dArr[0] + d;
        for (int i = 1; i < 6; i++) {
            d2 = (d2 * d) + dArr[i];
        }
        return d2;
    }

    public static double PlaceComponentResult(int i, double d) {
        if (i == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("n");
        }
        double BuiltInFictitiousFunctionClassFactory = 1.0d / BuiltInFictitiousFunctionClassFactory(i);
        int i2 = 0;
        boolean z = true;
        while (true) {
            int i3 = i + 1;
            if (i2 > i3) {
                return BuiltInFictitiousFunctionClassFactory;
            }
            double round = Math.round(Math.exp((KClassImpl$Data$declaredNonStaticMembers$2(i3) - KClassImpl$Data$declaredNonStaticMembers$2(i2)) - KClassImpl$Data$declaredNonStaticMembers$2(i3 - i2)));
            double d2 = i;
            Double.isNaN(d2);
            double d3 = i2;
            Double.isNaN(d3);
            double PlaceComponentResult2 = Tools.PlaceComponentResult((d + ((d2 + 1.0d) / 2.0d)) - d3, d2);
            Double.isNaN(round);
            double d4 = round * PlaceComponentResult2;
            if (!z) {
                d4 = -d4;
            }
            BuiltInFictitiousFunctionClassFactory += d4;
            z = !z;
            i2++;
        }
    }

    private static double KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = new double[101];
        }
        if (i < 0) {
            try {
                throw new ArithmeticException("Argument cannot be negative.");
            } catch (Exception unused) {
            }
        }
        if (i <= 1) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (i <= 100) {
            double[] dArr = MyBillsEntityDataFactory;
            double d = dArr[i];
            if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d2 = i;
                Double.isNaN(d2);
                double KClassImpl$Data$declaredNonStaticMembers$22 = Gamma.KClassImpl$Data$declaredNonStaticMembers$2(d2 + 1.0d);
                dArr[i] = KClassImpl$Data$declaredNonStaticMembers$22;
                return KClassImpl$Data$declaredNonStaticMembers$22;
            }
            return d;
        }
        double d3 = i;
        Double.isNaN(d3);
        return Gamma.KClassImpl$Data$declaredNonStaticMembers$2(d3 + 1.0d);
    }

    private static double BuiltInFictitiousFunctionClassFactory(int i) {
        if (PlaceComponentResult == null) {
            double[] dArr = new double[33];
            PlaceComponentResult = dArr;
            dArr[0] = 1.0d;
            dArr[1] = 1.0d;
            dArr[2] = 2.0d;
            dArr[3] = 6.0d;
            dArr[4] = 24.0d;
            KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        }
        if (i < 0) {
            try {
                throw new ArithmeticException("Argument cannot be negative.");
            } catch (Exception unused) {
            }
        }
        if (i > 32) {
            double d = i;
            Double.isNaN(d);
            return Math.exp(Gamma.KClassImpl$Data$declaredNonStaticMembers$2(d + 1.0d));
        }
        while (true) {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (i2 < i) {
                int i3 = i2 + 1;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3;
                double[] dArr2 = PlaceComponentResult;
                double d2 = dArr2[i2];
                double d3 = i3;
                Double.isNaN(d3);
                dArr2[i3] = d2 * d3;
            } else {
                return PlaceComponentResult[i];
            }
        }
    }
}
