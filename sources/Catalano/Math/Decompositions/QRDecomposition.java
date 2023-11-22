package Catalano.Math.Decompositions;

import Catalano.Math.Tools;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class QRDecomposition implements Serializable {
    private double[][] QR;
    private double[] Rdiag;
    private int m;
    private int n;

    public QRDecomposition(double[][] dArr) {
        this.QR = (double[][]) dArr.clone();
        this.m = dArr.length;
        int length = dArr[0].length;
        this.n = length;
        this.Rdiag = new double[length];
        for (int i = 0; i < this.n; i++) {
            double d = 0.0d;
            for (int i2 = i; i2 < this.m; i2++) {
                d = Tools.getAuthRequestContext(d, this.QR[i2][i]);
            }
            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d = this.QR[i][i] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -d : d;
                for (int i3 = i; i3 < this.m; i3++) {
                    double[] dArr2 = this.QR[i3];
                    dArr2[i] = dArr2[i] / d;
                }
                double[] dArr3 = this.QR[i];
                dArr3[i] = dArr3[i] + 1.0d;
                for (int i4 = i + 1; i4 < this.n; i4++) {
                    double d2 = 0.0d;
                    for (int i5 = i; i5 < this.m; i5++) {
                        double[] dArr4 = this.QR[i5];
                        d2 += dArr4[i] * dArr4[i4];
                    }
                    double d3 = (-d2) / this.QR[i][i];
                    for (int i6 = i; i6 < this.m; i6++) {
                        double[] dArr5 = this.QR[i6];
                        dArr5[i4] = dArr5[i4] + (dArr5[i] * d3);
                    }
                }
            }
            this.Rdiag[i] = -d;
        }
    }

    public boolean isFullRank() {
        for (int i = 0; i < this.n; i++) {
            if (this.Rdiag[i] == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return false;
            }
        }
        return true;
    }

    public double[][] getH() {
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, this.m, this.n);
        for (int i = 0; i < this.m; i++) {
            for (int i2 = 0; i2 < this.n; i2++) {
                if (i >= i2) {
                    dArr[i][i2] = this.QR[i][i2];
                } else {
                    dArr[i][i2] = 0.0d;
                }
            }
        }
        return dArr;
    }

    public double[][] getR() {
        int i = this.n;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (int i2 = 0; i2 < this.n; i2++) {
            for (int i3 = 0; i3 < this.n; i3++) {
                if (i2 < i3) {
                    dArr[i2][i3] = this.QR[i2][i3];
                } else if (i2 == i3) {
                    dArr[i2][i3] = this.Rdiag[i2];
                } else {
                    dArr[i2][i3] = 0.0d;
                }
            }
        }
        return dArr;
    }

    public double[][] getQ() {
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, this.m, this.n);
        for (int i = this.n - 1; i >= 0; i--) {
            for (int i2 = 0; i2 < this.m; i2++) {
                dArr[i2][i] = 0.0d;
            }
            dArr[i][i] = 1.0d;
            for (int i3 = i; i3 < this.n; i3++) {
                if (this.QR[i][i] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double d = 0.0d;
                    for (int i4 = i; i4 < this.m; i4++) {
                        d += this.QR[i4][i] * dArr[i4][i3];
                    }
                    double d2 = (-d) / this.QR[i][i];
                    for (int i5 = i; i5 < this.m; i5++) {
                        double[] dArr2 = dArr[i5];
                        dArr2[i3] = dArr2[i3] + (this.QR[i5][i] * d2);
                    }
                }
            }
        }
        return dArr;
    }

    public double[][] solve(double[][] dArr) {
        int i;
        if (dArr.length != this.m) {
            throw new IllegalArgumentException("Matrix row dimensions must agree.");
        }
        if (!isFullRank()) {
            throw new RuntimeException("Matrix is rank deficient.");
        }
        int length = dArr[0].length;
        double[][] dArr2 = (double[][]) dArr.clone();
        int i2 = 0;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            for (int i3 = 0; i3 < length; i3++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i4 = i2; i4 < this.m; i4++) {
                    d += this.QR[i4][i2] * dArr2[i4][i3];
                }
                double d2 = (-d) / this.QR[i2][i2];
                for (int i5 = i2; i5 < this.m; i5++) {
                    double[] dArr3 = dArr2[i5];
                    dArr3[i3] = dArr3[i3] + (this.QR[i5][i2] * d2);
                }
            }
            i2++;
        }
        for (int i6 = i - 1; i6 >= 0; i6--) {
            for (int i7 = 0; i7 < length; i7++) {
                double[] dArr4 = dArr2[i6];
                dArr4[i7] = dArr4[i7] / this.Rdiag[i6];
            }
            for (int i8 = 0; i8 < i6; i8++) {
                for (int i9 = 0; i9 < length; i9++) {
                    double[] dArr5 = dArr2[i8];
                    dArr5[i9] = dArr5[i9] - (dArr2[i6][i9] * this.QR[i8][i6]);
                }
            }
        }
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, this.n, length);
        for (int i10 = 0; i10 < dArr6.length; i10++) {
            for (int i11 = 0; i11 < dArr6[0].length; i11++) {
                dArr6[i10][i11] = dArr2[i10][i11];
            }
        }
        return dArr6;
    }
}
