package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MonotonicCurveFit extends CurveFit {
    private double[][] BuiltInFictitiousFunctionClassFactory;
    private double[][] KClassImpl$Data$declaredNonStaticMembers$2;
    double[] MyBillsEntityDataFactory;
    private boolean PlaceComponentResult = true;
    private double[] getAuthRequestContext;

    private static double BuiltInFictitiousFunctionClassFactory(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d2 * 6.0d;
        double d9 = 3.0d * d;
        return ((((((((((-6.0d) * d7) * d4) + (d8 * d4)) + ((6.0d * d7) * d3)) - (d8 * d3)) + ((d9 * d6) * d7)) + ((d9 * d5) * d7)) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2)) + (d * d5);
    }

    private static double getAuthRequestContext(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        double d9 = 3.0d * d7;
        double d10 = d * d6;
        double d11 = d * d5;
        return (((((((((((-2.0d) * d8) * d4) + (d9 * d4)) + ((d8 * 2.0d) * d3)) - (d9 * d3)) + d3) + (d10 * d8)) + (d8 * d11)) - (d10 * d7)) - (((d * 2.0d) * d5) * d7)) + (d11 * d2);
    }

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.MyBillsEntityDataFactory = new double[length2];
        int i = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(Double.TYPE, length, length2);
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                double d = dArr[i4];
                double d2 = dArr[i3];
                double[] dArr5 = dArr3[i3];
                double d3 = (dArr2[i4][i2] - dArr2[i3][i2]) / (d - d2);
                dArr5[i2] = d3;
                if (i3 == 0) {
                    dArr4[i3][i2] = d3;
                } else {
                    dArr4[i3][i2] = (dArr3[i3 - 1][i2] + d3) * 0.5d;
                }
                i3 = i4;
            }
            dArr4[i][i2] = dArr3[length - 2][i2];
        }
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                double d4 = dArr3[i5][i6];
                if (d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    dArr4[i5][i6] = 0.0d;
                    dArr4[i5 + 1][i6] = 0.0d;
                } else {
                    double d5 = dArr4[i5][i6] / d4;
                    int i7 = i5 + 1;
                    double d6 = dArr4[i7][i6] / d4;
                    double hypot = Math.hypot(d5, d6);
                    if (hypot > 9.0d) {
                        double d7 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i5];
                        double[] dArr7 = dArr3[i5];
                        dArr6[i6] = d5 * d7 * dArr7[i6];
                        dArr4[i7][i6] = d7 * d6 * dArr7[i6];
                    }
                }
            }
        }
        this.getAuthRequestContext = dArr;
        this.BuiltInFictitiousFunctionClassFactory = dArr2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dArr4;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void getAuthRequestContext(double d, double[] dArr) {
        double[] dArr2 = this.getAuthRequestContext;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.BuiltInFictitiousFunctionClassFactory[0].length;
        if (this.PlaceComponentResult) {
            double d2 = dArr2[0];
            if (d <= d2) {
                PlaceComponentResult(d2, this.MyBillsEntityDataFactory);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.BuiltInFictitiousFunctionClassFactory[0][i2] + ((d - this.getAuthRequestContext[0]) * this.MyBillsEntityDataFactory[i2]);
                }
                return;
            }
            int i3 = length - 1;
            double d3 = dArr2[i3];
            if (d >= d3) {
                PlaceComponentResult(d3, this.MyBillsEntityDataFactory);
                while (i < length2) {
                    dArr[i] = this.BuiltInFictitiousFunctionClassFactory[i3][i] + ((d - this.getAuthRequestContext[i3]) * this.MyBillsEntityDataFactory[i]);
                    i++;
                }
                return;
            }
        } else if (d <= dArr2[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                dArr[i4] = this.BuiltInFictitiousFunctionClassFactory[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = this.BuiltInFictitiousFunctionClassFactory[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.getAuthRequestContext[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.BuiltInFictitiousFunctionClassFactory[i6][i7];
                }
            }
            double[] dArr3 = this.getAuthRequestContext;
            int i8 = i6 + 1;
            double d4 = dArr3[i8];
            if (d < d4) {
                double d5 = dArr3[i6];
                double d6 = d4 - d5;
                double d7 = (d - d5) / d6;
                while (i < length2) {
                    double[][] dArr4 = this.BuiltInFictitiousFunctionClassFactory;
                    double d8 = dArr4[i6][i];
                    double d9 = dArr4[i8][i];
                    double[][] dArr5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    dArr[i] = getAuthRequestContext(d6, d7, d8, d9, dArr5[i6][i], dArr5[i8][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void KClassImpl$Data$declaredNonStaticMembers$2(double d, float[] fArr) {
        double[] dArr = this.getAuthRequestContext;
        int length = dArr.length;
        int i = 0;
        int length2 = this.BuiltInFictitiousFunctionClassFactory[0].length;
        if (this.PlaceComponentResult) {
            double d2 = dArr[0];
            if (d <= d2) {
                PlaceComponentResult(d2, this.MyBillsEntityDataFactory);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.BuiltInFictitiousFunctionClassFactory[0][i2] + ((d - this.getAuthRequestContext[0]) * this.MyBillsEntityDataFactory[i2]));
                }
                return;
            }
            int i3 = length - 1;
            double d3 = dArr[i3];
            if (d >= d3) {
                PlaceComponentResult(d3, this.MyBillsEntityDataFactory);
                while (i < length2) {
                    fArr[i] = (float) (this.BuiltInFictitiousFunctionClassFactory[i3][i] + ((d - this.getAuthRequestContext[i3]) * this.MyBillsEntityDataFactory[i]));
                    i++;
                }
                return;
            }
        } else if (d <= dArr[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                fArr[i4] = (float) this.BuiltInFictitiousFunctionClassFactory[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) this.BuiltInFictitiousFunctionClassFactory[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.getAuthRequestContext[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.BuiltInFictitiousFunctionClassFactory[i6][i7];
                }
            }
            double[] dArr2 = this.getAuthRequestContext;
            int i8 = i6 + 1;
            double d4 = dArr2[i8];
            if (d < d4) {
                double d5 = dArr2[i6];
                double d6 = d4 - d5;
                double d7 = (d - d5) / d6;
                while (i < length2) {
                    double[][] dArr3 = this.BuiltInFictitiousFunctionClassFactory;
                    double d8 = dArr3[i6][i];
                    double d9 = dArr3[i8][i];
                    double[][] dArr4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    fArr[i] = (float) getAuthRequestContext(d6, d7, d8, d9, dArr4[i6][i], dArr4[i8][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double getAuthRequestContext(double d) {
        double d2;
        double d3;
        double MyBillsEntityDataFactory;
        double[] dArr = this.getAuthRequestContext;
        int length = dArr.length;
        if (this.PlaceComponentResult) {
            double d4 = dArr[0];
            if (d <= d4) {
                d2 = this.BuiltInFictitiousFunctionClassFactory[0][0];
                d3 = d - d4;
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(d4);
            } else {
                int i = length - 1;
                double d5 = dArr[i];
                if (d >= d5) {
                    d2 = this.BuiltInFictitiousFunctionClassFactory[i][0];
                    d3 = d - d5;
                    MyBillsEntityDataFactory = MyBillsEntityDataFactory(d5);
                }
            }
            return d2 + (d3 * MyBillsEntityDataFactory);
        } else if (d <= dArr[0]) {
            return this.BuiltInFictitiousFunctionClassFactory[0][0];
        } else {
            int i2 = length - 1;
            if (d >= dArr[i2]) {
                return this.BuiltInFictitiousFunctionClassFactory[i2][0];
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr2 = this.getAuthRequestContext;
            double d6 = dArr2[i3];
            if (d == d6) {
                return this.BuiltInFictitiousFunctionClassFactory[i3][0];
            }
            int i4 = i3 + 1;
            double d7 = dArr2[i4];
            if (d < d7) {
                double d8 = d7 - d6;
                double d9 = (d - d6) / d8;
                double[][] dArr3 = this.BuiltInFictitiousFunctionClassFactory;
                double d10 = dArr3[i3][0];
                double d11 = dArr3[i4][0];
                double[][] dArr4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return getAuthRequestContext(d8, d9, d10, d11, dArr4[i3][0], dArr4[i4][0]);
            }
            i3 = i4;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void PlaceComponentResult(double d, double[] dArr) {
        double[] dArr2 = this.getAuthRequestContext;
        int length = dArr2.length;
        int length2 = this.BuiltInFictitiousFunctionClassFactory[0].length;
        double d2 = dArr2[0];
        if (d > d2) {
            d2 = dArr2[length - 1];
            if (d < d2) {
                d2 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.getAuthRequestContext;
            int i2 = i + 1;
            double d3 = dArr3[i2];
            if (d2 <= d3) {
                double d4 = dArr3[i];
                double d5 = d3 - d4;
                double d6 = (d2 - d4) / d5;
                for (int i3 = 0; i3 < length2; i3++) {
                    double[][] dArr4 = this.BuiltInFictitiousFunctionClassFactory;
                    double d7 = dArr4[i][i3];
                    double d8 = dArr4[i2][i3];
                    double[][] dArr5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    dArr[i3] = BuiltInFictitiousFunctionClassFactory(d5, d6, d7, d8, dArr5[i][i3], dArr5[i2][i3]) / d5;
                }
                return;
            }
            i = i2;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double MyBillsEntityDataFactory(double d) {
        double[] dArr = this.getAuthRequestContext;
        int length = dArr.length;
        double d2 = dArr[0];
        if (d >= d2) {
            d2 = dArr[length - 1];
            if (d < d2) {
                d2 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr2 = this.getAuthRequestContext;
            int i2 = i + 1;
            double d3 = dArr2[i2];
            if (d2 <= d3) {
                double d4 = dArr2[i];
                double d5 = d3 - d4;
                double d6 = (d2 - d4) / d5;
                double[][] dArr3 = this.BuiltInFictitiousFunctionClassFactory;
                double d7 = dArr3[i][0];
                double d8 = dArr3[i2][0];
                double[][] dArr4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return BuiltInFictitiousFunctionClassFactory(d5, d6, d7, d8, dArr4[i][0], dArr4[i2][0]) / d5;
            }
            i = i2;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public static MonotonicCurveFit MyBillsEntityDataFactory(String str) {
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        double[] copyOf = Arrays.copyOf(dArr, i + 1);
        int length = (copyOf.length * 3) - 2;
        int length2 = copyOf.length - 1;
        double d = length2;
        Double.isNaN(d);
        double d2 = 1.0d / d;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i2 = 0; i2 < copyOf.length; i2++) {
            double d3 = copyOf[i2];
            int i3 = i2 + length2;
            dArr2[i3][0] = d3;
            double d4 = i2;
            Double.isNaN(d4);
            double d5 = d4 * d2;
            dArr3[i3] = d5;
            if (i2 > 0) {
                int i4 = (length2 * 2) + i2;
                dArr2[i4][0] = d3 + 1.0d;
                dArr3[i4] = d5 + 1.0d;
                int i5 = i2 - 1;
                dArr2[i5][0] = (d3 - 1.0d) - d2;
                dArr3[i5] = (d5 - 1.0d) - d2;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }
}
