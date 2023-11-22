package Catalano.Math;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public final class Matrix {
    private Matrix() {
    }

    public static double[] BuiltInFictitiousFunctionClassFactory(int i) {
        double[] dArr = new double[i];
        for (int i2 = 0; i2 < i; i2++) {
            dArr[i2] = 1.0d;
        }
        return dArr;
    }

    public static double[][] KClassImpl$Data$declaredNonStaticMembers$2(double[][] dArr) {
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, dArr.length, dArr[0].length);
        for (int i = 0; i < dArr.length; i++) {
            for (int i2 = 0; i2 < dArr[0].length; i2++) {
                dArr2[i][i2] = dArr[i][i2];
            }
        }
        return dArr2;
    }

    public static double[][] BuiltInFictitiousFunctionClassFactory(double[][] dArr) {
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, dArr[0].length, dArr.length);
        for (int i = 0; i < dArr.length; i++) {
            for (int i2 = 0; i2 < dArr[0].length; i2++) {
                dArr2[i2][i] = dArr[i][i2];
            }
        }
        return dArr2;
    }

    public static double[][] MyBillsEntityDataFactory(int i, int i2) {
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i2);
        int i3 = 0;
        while (i3 < i) {
            int i4 = 0;
            while (i4 < i2) {
                dArr[i3][i4] = i3 == i4 ? 1.0d : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                i4++;
            }
            i3++;
        }
        return dArr;
    }

    public static double[][] getAuthRequestContext(double[][] dArr, int i, int i2) {
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i, i2);
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                dArr2[i3][i4] = dArr[i3][i4];
            }
        }
        return dArr2;
    }

    public static double[][] BuiltInFictitiousFunctionClassFactory(double[][] dArr, int[] iArr, int i) {
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr.length, (i - 0) + 1);
        for (int i2 = 0; i2 < dArr2.length; i2++) {
            for (int i3 = 0; i3 < dArr2[0].length; i3++) {
                int i4 = iArr[i2];
                if (i4 < 0 || i4 >= dArr.length) {
                    throw new IllegalArgumentException("Argument out of range.");
                }
                dArr2[i2][i3] = dArr[i4][i3 + 0];
            }
        }
        return dArr2;
    }
}
