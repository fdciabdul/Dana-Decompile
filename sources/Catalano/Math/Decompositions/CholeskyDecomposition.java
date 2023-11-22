package Catalano.Math.Decompositions;

import Catalano.Math.Matrix;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class CholeskyDecomposition implements Serializable {
    private double[][] L;
    private boolean isspd;
    private int n;

    public CholeskyDecomposition(double[][] dArr) {
        int length = dArr.length;
        this.n = length;
        this.L = (double[][]) Array.newInstance(Double.TYPE, length, length);
        this.isspd = dArr[0].length == this.n;
        int i = 0;
        while (i < this.n) {
            double[] dArr2 = this.L[i];
            double d = 0.0d;
            for (int i2 = 0; i2 < i; i2++) {
                double[] dArr3 = this.L[i2];
                double d2 = 0.0d;
                for (int i3 = 0; i3 < i2; i3++) {
                    d2 += dArr3[i3] * dArr2[i3];
                }
                double[] dArr4 = dArr[i];
                double d3 = (dArr4[i2] - d2) / this.L[i2][i2];
                dArr2[i2] = d3;
                d += d3 * d3;
                this.isspd = (dArr[i2][i] == dArr4[i2]) & this.isspd;
            }
            double d4 = dArr[i][i] - d;
            this.isspd &= d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.L[i][i] = Math.sqrt(Math.max(d4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            int i4 = i + 1;
            for (int i5 = i4; i5 < this.n; i5++) {
                this.L[i][i5] = 0.0d;
            }
            i = i4;
        }
    }

    public boolean isSPD() {
        return this.isspd;
    }

    public double[][] getL() {
        double[][] dArr = this.L;
        int i = this.n;
        return Matrix.getAuthRequestContext(dArr, i, i);
    }

    public double[][] solve(double[][] dArr) {
        int i;
        if (dArr.length != this.n) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        }
        if (!this.isspd) {
            throw new RuntimeException("Matrix is not symmetric positive definite.");
        }
        double[][] KClassImpl$Data$declaredNonStaticMembers$2 = Matrix.KClassImpl$Data$declaredNonStaticMembers$2(dArr);
        int length = dArr[0].length;
        int i2 = 0;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            for (int i3 = 0; i3 < length; i3++) {
                for (int i4 = 0; i4 < i2; i4++) {
                    double[] dArr2 = KClassImpl$Data$declaredNonStaticMembers$2[i2];
                    dArr2[i3] = dArr2[i3] - (KClassImpl$Data$declaredNonStaticMembers$2[i4][i3] * this.L[i2][i4]);
                }
                double[] dArr3 = KClassImpl$Data$declaredNonStaticMembers$2[i2];
                dArr3[i3] = dArr3[i3] / this.L[i2][i2];
            }
            i2++;
        }
        for (int i5 = i - 1; i5 >= 0; i5--) {
            for (int i6 = 0; i6 < length; i6++) {
                for (int i7 = i5 + 1; i7 < this.n; i7++) {
                    double[] dArr4 = KClassImpl$Data$declaredNonStaticMembers$2[i5];
                    dArr4[i6] = dArr4[i6] - (KClassImpl$Data$declaredNonStaticMembers$2[i7][i6] * this.L[i7][i5]);
                }
                double[] dArr5 = KClassImpl$Data$declaredNonStaticMembers$2[i5];
                dArr5[i6] = dArr5[i6] / this.L[i5][i5];
            }
        }
        return Matrix.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, this.n, length);
    }
}
