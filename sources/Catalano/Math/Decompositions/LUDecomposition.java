package Catalano.Math.Decompositions;

import Catalano.Math.Matrix;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class LUDecomposition implements Serializable {
    private double[][] LU;
    private int m;
    private int n;
    private int[] piv;
    private int pivsign;

    public LUDecomposition(double[][] dArr) {
        int i;
        this.LU = Matrix.KClassImpl$Data$declaredNonStaticMembers$2(dArr);
        int length = dArr.length;
        this.m = length;
        this.n = dArr[0].length;
        this.piv = new int[length];
        int i2 = 0;
        while (true) {
            i = this.m;
            if (i2 >= i) {
                break;
            }
            this.piv[i2] = i2;
            i2++;
        }
        this.pivsign = 1;
        double[] dArr2 = new double[i];
        int i3 = 0;
        while (i3 < this.n) {
            for (int i4 = 0; i4 < this.m; i4++) {
                dArr2[i4] = this.LU[i4][i3];
            }
            int i5 = 0;
            while (true) {
                int i6 = this.m;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                if (i5 >= i6) {
                    break;
                }
                double[] dArr3 = this.LU[i5];
                int min = Math.min(i5, i3);
                for (int i7 = 0; i7 < min; i7++) {
                    d += dArr3[i7] * dArr2[i7];
                }
                double d2 = dArr2[i5] - d;
                dArr2[i5] = d2;
                dArr3[i3] = d2;
                i5++;
            }
            int i8 = i3 + 1;
            int i9 = i3;
            for (int i10 = i8; i10 < this.m; i10++) {
                if (Math.abs(dArr2[i10]) > Math.abs(dArr2[i9])) {
                    i9 = i10;
                }
            }
            if (i9 != i3) {
                for (int i11 = 0; i11 < this.n; i11++) {
                    double[][] dArr4 = this.LU;
                    double[] dArr5 = dArr4[i9];
                    double d3 = dArr5[i11];
                    double[] dArr6 = dArr4[i3];
                    dArr5[i11] = dArr6[i11];
                    dArr6[i11] = d3;
                }
                int[] iArr = this.piv;
                int i12 = iArr[i9];
                iArr[i9] = iArr[i3];
                iArr[i3] = i12;
                this.pivsign = -this.pivsign;
            }
            if (i3 < this.m && this.LU[i3][i3] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                for (int i13 = i8; i13 < this.m; i13++) {
                    double[][] dArr7 = this.LU;
                    double[] dArr8 = dArr7[i13];
                    dArr8[i3] = dArr8[i3] / dArr7[i3][i3];
                }
            }
            i3 = i8;
        }
    }

    public boolean isNonsingular() {
        for (int i = 0; i < this.n; i++) {
            if (this.LU[i][i] == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return false;
            }
        }
        return true;
    }

    public double[][] inverse() {
        int i = this.m;
        return solve(Matrix.MyBillsEntityDataFactory(i, i));
    }

    public double[][] getL() {
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, this.m, this.n);
        for (int i = 0; i < this.m; i++) {
            for (int i2 = 0; i2 < this.n; i2++) {
                if (i > i2) {
                    dArr[i][i2] = this.LU[i][i2];
                } else if (i == i2) {
                    dArr[i][i2] = 1.0d;
                } else {
                    dArr[i][i2] = 0.0d;
                }
            }
        }
        return dArr;
    }

    public double[][] getU() {
        int i = this.n;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (int i2 = 0; i2 < this.n; i2++) {
            for (int i3 = 0; i3 < this.n; i3++) {
                if (i2 <= i3) {
                    dArr[i2][i3] = this.LU[i2][i3];
                } else {
                    dArr[i2][i3] = 0.0d;
                }
            }
        }
        return dArr;
    }

    public int[] getPivot() {
        int[] iArr = new int[this.m];
        for (int i = 0; i < this.m; i++) {
            iArr[i] = this.piv[i];
        }
        return iArr;
    }

    public double[] getDoublePivot() {
        double[] dArr = new double[this.m];
        for (int i = 0; i < this.m; i++) {
            dArr[i] = this.piv[i];
        }
        return dArr;
    }

    public double determinant() {
        if (this.m != this.n) {
            throw new IllegalArgumentException("Matrix must be square.");
        }
        double d = this.pivsign;
        for (int i = 0; i < this.n; i++) {
            d *= this.LU[i][i];
        }
        return d;
    }

    public double[][] solve(double[][] dArr) {
        int i;
        if (dArr.length != this.m) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        }
        if (!isNonsingular()) {
            throw new RuntimeException("Matrix is singular.");
        }
        int length = dArr[0].length;
        double[][] BuiltInFictitiousFunctionClassFactory = Matrix.BuiltInFictitiousFunctionClassFactory(dArr, this.piv, length - 1);
        int i2 = 0;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.n; i4++) {
                for (int i5 = 0; i5 < length; i5++) {
                    double[] dArr2 = BuiltInFictitiousFunctionClassFactory[i4];
                    dArr2[i5] = dArr2[i5] - (BuiltInFictitiousFunctionClassFactory[i2][i5] * this.LU[i4][i2]);
                }
            }
            i2 = i3;
        }
        for (int i6 = i - 1; i6 >= 0; i6--) {
            for (int i7 = 0; i7 < length; i7++) {
                double[] dArr3 = BuiltInFictitiousFunctionClassFactory[i6];
                dArr3[i7] = dArr3[i7] / this.LU[i6][i6];
            }
            for (int i8 = 0; i8 < i6; i8++) {
                for (int i9 = 0; i9 < length; i9++) {
                    double[] dArr4 = BuiltInFictitiousFunctionClassFactory[i8];
                    dArr4[i9] = dArr4[i9] - (BuiltInFictitiousFunctionClassFactory[i6][i9] * this.LU[i8][i6]);
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }
}
