package Catalano.Math.Decompositions;

import Catalano.Math.Matrix;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class EigenvalueDecomposition implements Serializable {
    private double[][] H;
    private double[][] V;
    private transient double cdivi;
    private transient double cdivr;
    private double[] d;
    private double[] e;
    private boolean issymmetric;
    private int n;
    private double[] ort;

    public EigenvalueDecomposition(double[][] dArr) {
        int i;
        boolean z;
        int length = dArr[0].length;
        this.n = length;
        this.V = (double[][]) Array.newInstance(Double.TYPE, length, length);
        int i2 = this.n;
        this.d = new double[i2];
        this.e = new double[i2];
        this.issymmetric = true;
        int i3 = 0;
        while (true) {
            i = this.n;
            boolean z2 = i3 < i;
            z = this.issymmetric;
            if (!z2 || !z) {
                break;
            }
            int i4 = 0;
            while (true) {
                if ((i4 < this.n) & this.issymmetric) {
                    this.issymmetric = dArr[i4][i3] == dArr[i3][i4];
                    i4++;
                }
            }
            i3++;
        }
        if (z) {
            for (int i5 = 0; i5 < this.n; i5++) {
                for (int i6 = 0; i6 < this.n; i6++) {
                    this.V[i5][i6] = dArr[i5][i6];
                }
            }
            tred2();
            tql2();
            return;
        }
        this.H = (double[][]) Array.newInstance(Double.TYPE, i, i);
        this.ort = new double[this.n];
        for (int i7 = 0; i7 < this.n; i7++) {
            for (int i8 = 0; i8 < this.n; i8++) {
                this.H[i8][i7] = dArr[i8][i7];
            }
        }
        orthes();
        hqr2();
    }

    private void tred2() {
        int i;
        int i2 = 0;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            this.d[i2] = this.V[i - 1][i2];
            i2++;
        }
        while (true) {
            i--;
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i <= 0) {
                break;
            }
            double d2 = 0.0d;
            for (int i3 = 0; i3 < i; i3++) {
                d2 += Math.abs(this.d[i3]);
            }
            if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                int i4 = i - 1;
                this.e[i] = this.d[i4];
                for (int i5 = 0; i5 < i; i5++) {
                    double[] dArr = this.d;
                    double[][] dArr2 = this.V;
                    dArr[i5] = dArr2[i4][i5];
                    dArr2[i][i5] = 0.0d;
                    dArr2[i5][i] = 0.0d;
                }
            } else {
                double d3 = 0.0d;
                for (int i6 = 0; i6 < i; i6++) {
                    double[] dArr3 = this.d;
                    double d4 = dArr3[i6] / d2;
                    dArr3[i6] = d4;
                    d3 += d4 * d4;
                }
                int i7 = i - 1;
                double d5 = this.d[i7];
                double sqrt = Math.sqrt(d3);
                if (d5 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    sqrt = -sqrt;
                }
                this.e[i] = d2 * sqrt;
                double d6 = d3 - (d5 * sqrt);
                this.d[i7] = d5 - sqrt;
                for (int i8 = 0; i8 < i; i8++) {
                    this.e[i8] = 0.0d;
                }
                int i9 = 0;
                while (i9 < i) {
                    double d7 = this.d[i9];
                    double[] dArr4 = this.V[i9];
                    dArr4[i] = d7;
                    double d8 = this.e[i9] + (dArr4[i9] * d7);
                    int i10 = i9 + 1;
                    for (int i11 = i10; i11 <= i7; i11++) {
                        double d9 = this.V[i11][i9];
                        d8 += this.d[i11] * d9;
                        double[] dArr5 = this.e;
                        dArr5[i11] = dArr5[i11] + (d9 * d7);
                    }
                    this.e[i9] = d8;
                    i9 = i10;
                }
                double d10 = 0.0d;
                for (int i12 = 0; i12 < i; i12++) {
                    double[] dArr6 = this.e;
                    double d11 = dArr6[i12] / d6;
                    dArr6[i12] = d11;
                    d10 += d11 * this.d[i12];
                }
                double d12 = d10 / (d6 + d6);
                for (int i13 = 0; i13 < i; i13++) {
                    double[] dArr7 = this.e;
                    dArr7[i13] = dArr7[i13] - (this.d[i13] * d12);
                }
                for (int i14 = 0; i14 < i; i14++) {
                    double d13 = this.d[i14];
                    double d14 = this.e[i14];
                    for (int i15 = i14; i15 <= i7; i15++) {
                        double[] dArr8 = this.V[i15];
                        dArr8[i14] = dArr8[i14] - ((this.e[i15] * d13) + (this.d[i15] * d14));
                    }
                    double[] dArr9 = this.d;
                    double[][] dArr10 = this.V;
                    dArr9[i14] = dArr10[i7][i14];
                    dArr10[i][i14] = 0.0d;
                }
                d = d6;
            }
            this.d[i] = d;
        }
        int i16 = 0;
        while (true) {
            int i17 = this.n - 1;
            if (i16 >= i17) {
                break;
            }
            double[][] dArr11 = this.V;
            double[] dArr12 = dArr11[i17];
            double[] dArr13 = dArr11[i16];
            dArr12[i16] = dArr13[i16];
            dArr13[i16] = 1.0d;
            int i18 = i16 + 1;
            double d15 = this.d[i18];
            if (d15 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                for (int i19 = 0; i19 <= i16; i19++) {
                    this.d[i19] = this.V[i19][i18] / d15;
                }
                for (int i20 = 0; i20 <= i16; i20++) {
                    double d16 = 0.0d;
                    for (int i21 = 0; i21 <= i16; i21++) {
                        double[] dArr14 = this.V[i21];
                        d16 += dArr14[i18] * dArr14[i20];
                    }
                    for (int i22 = 0; i22 <= i16; i22++) {
                        double[] dArr15 = this.V[i22];
                        dArr15[i20] = dArr15[i20] - (this.d[i22] * d16);
                    }
                }
            }
            for (int i23 = 0; i23 <= i16; i23++) {
                this.V[i23][i18] = 0.0d;
            }
            i16 = i18;
        }
        int i24 = 0;
        while (true) {
            int i25 = this.n;
            if (i24 < i25) {
                double[] dArr16 = this.d;
                double[][] dArr17 = this.V;
                int i26 = i25 - 1;
                dArr16[i24] = dArr17[i26][i24];
                dArr17[i26][i24] = 0.0d;
                i24++;
            } else {
                int i27 = i25 - 1;
                this.V[i27][i27] = 1.0d;
                this.e[0] = 0.0d;
                return;
            }
        }
    }

    private void tql2() {
        int i;
        double d;
        double d2;
        double d3;
        int i2 = 1;
        while (true) {
            i = this.n;
            if (i2 >= i) {
                break;
            }
            double[] dArr = this.e;
            dArr[i2 - 1] = dArr[i2];
            i2++;
        }
        double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.e[i - 1] = 0.0d;
        double d5 = 2.0d;
        double pow = Math.pow(2.0d, -52.0d);
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i3 = 0;
        while (i3 < this.n) {
            double max = Math.max(d6, Math.abs(this.d[i3]) + Math.abs(this.e[i3]));
            int i4 = i3;
            while (i4 < this.n && Math.abs(this.e[i4]) > pow * max) {
                i4++;
            }
            if (i4 > i3) {
                while (true) {
                    double[] dArr2 = this.d;
                    double d8 = dArr2[i3];
                    int i5 = i3 + 1;
                    double d9 = (dArr2[i5] - d8) / (this.e[i3] * d5);
                    d = pow;
                    double hypot = Math.hypot(d9, 1.0d);
                    if (d9 < d4) {
                        hypot = -hypot;
                    }
                    double[] dArr3 = this.d;
                    double[] dArr4 = this.e;
                    double d10 = d9 + hypot;
                    dArr3[i3] = dArr4[i3] / d10;
                    double d11 = dArr4[i3] * d10;
                    dArr3[i5] = d11;
                    double d12 = d8 - dArr3[i3];
                    for (int i6 = i3 + 2; i6 < this.n; i6++) {
                        double[] dArr5 = this.d;
                        dArr5[i6] = dArr5[i6] - d12;
                    }
                    d3 = d7 + d12;
                    double d13 = this.d[i4];
                    double d14 = this.e[i5];
                    int i7 = i4 - 1;
                    double d15 = d4;
                    double d16 = 1.0d;
                    double d17 = 1.0d;
                    double d18 = d15;
                    double d19 = d13;
                    double d20 = 1.0d;
                    while (i7 >= i3) {
                        int i8 = i4;
                        double d21 = max;
                        double d22 = this.e[i7];
                        double d23 = d20 * d22;
                        double hypot2 = Math.hypot(d19, d22);
                        double[] dArr6 = this.e;
                        int i9 = i7 + 1;
                        dArr6[i9] = d18 * hypot2;
                        double d24 = dArr6[i7] / hypot2;
                        double d25 = d19 / hypot2;
                        double[] dArr7 = this.d;
                        double d26 = dArr7[i7];
                        dArr7[i9] = (d19 * d20) + (((d23 * d25) + (d26 * d24)) * d24);
                        for (int i10 = 0; i10 < this.n; i10++) {
                            double[] dArr8 = this.V[i10];
                            double d27 = dArr8[i9];
                            dArr8[i9] = (dArr8[i7] * d24) + (d25 * d27);
                            dArr8[i7] = (dArr8[i7] * d25) - (d27 * d24);
                        }
                        i7--;
                        d19 = (d26 * d25) - (d23 * d24);
                        d15 = d18;
                        d17 = d16;
                        i4 = i8;
                        d18 = d24;
                        d16 = d20;
                        d20 = d25;
                        max = d21;
                    }
                    int i11 = i4;
                    d2 = max;
                    double[] dArr9 = this.e;
                    double d28 = (((((-d18) * d15) * d17) * d14) * dArr9[i3]) / d11;
                    dArr9[i3] = d18 * d28;
                    this.d[i3] = d20 * d28;
                    if (Math.abs(dArr9[i3]) <= d * d2) {
                        break;
                    }
                    pow = d;
                    i4 = i11;
                    d7 = d3;
                    max = d2;
                    d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    d5 = 2.0d;
                }
                d7 = d3;
            } else {
                d = pow;
                d2 = max;
            }
            double[] dArr10 = this.d;
            dArr10[i3] = dArr10[i3] + d7;
            this.e[i3] = 0.0d;
            i3++;
            d4 = 0.0d;
            pow = d;
            d6 = d2;
            d5 = 2.0d;
        }
        int i12 = 0;
        while (i12 < this.n - 1) {
            double d29 = this.d[i12];
            int i13 = i12 + 1;
            int i14 = i12;
            for (int i15 = i13; i15 < this.n; i15++) {
                double d30 = this.d[i15];
                if (d30 < d29) {
                    i14 = i15;
                    d29 = d30;
                }
            }
            if (i14 != i12) {
                double[] dArr11 = this.d;
                dArr11[i14] = dArr11[i12];
                dArr11[i12] = d29;
                for (int i16 = 0; i16 < this.n; i16++) {
                    double[] dArr12 = this.V[i16];
                    double d31 = dArr12[i12];
                    dArr12[i12] = dArr12[i14];
                    dArr12[i14] = d31;
                }
            }
            i12 = i13;
        }
    }

    private void orthes() {
        int i;
        int i2 = 1;
        int i3 = this.n - 1;
        while (true) {
            i = i3 - 1;
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i2 > i) {
                break;
            }
            double d2 = 0.0d;
            for (int i4 = i2; i4 <= i3; i4++) {
                d2 += Math.abs(this.H[i4][i2 - 1]);
            }
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = 0.0d;
                for (int i5 = i3; i5 >= i2; i5--) {
                    double[] dArr = this.ort;
                    double d4 = this.H[i5][i2 - 1] / d2;
                    dArr[i5] = d4;
                    d3 += d4 * d4;
                }
                double sqrt = Math.sqrt(d3);
                double[] dArr2 = this.ort;
                double d5 = dArr2[i2];
                if (d5 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    sqrt = -sqrt;
                }
                double d6 = d3 - (d5 * sqrt);
                dArr2[i2] = d5 - sqrt;
                int i6 = i2;
                while (i6 < this.n) {
                    double d7 = d;
                    for (int i7 = i3; i7 >= i2; i7--) {
                        d7 += this.ort[i7] * this.H[i7][i6];
                    }
                    double d8 = d7 / d6;
                    for (int i8 = i2; i8 <= i3; i8++) {
                        double[] dArr3 = this.H[i8];
                        dArr3[i6] = dArr3[i6] - (this.ort[i8] * d8);
                    }
                    i6++;
                    d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                for (int i9 = 0; i9 <= i3; i9++) {
                    double d9 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (int i10 = i3; i10 >= i2; i10--) {
                        d9 += this.ort[i10] * this.H[i9][i10];
                    }
                    double d10 = d9 / d6;
                    int i11 = i2;
                    while (i11 <= i3) {
                        double[] dArr4 = this.H[i9];
                        dArr4[i11] = dArr4[i11] - (this.ort[i11] * d10);
                        i11++;
                        d6 = d6;
                    }
                }
                double[] dArr5 = this.ort;
                dArr5[i2] = dArr5[i2] * d2;
                this.H[i2][i2 - 1] = d2 * sqrt;
            }
            i2++;
        }
        int i12 = 0;
        while (i12 < this.n) {
            int i13 = 0;
            while (i13 < this.n) {
                this.V[i12][i13] = i12 == i13 ? 1.0d : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                i13++;
            }
            i12++;
        }
        while (i > 0) {
            int i14 = i - 1;
            if (this.H[i][i14] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                for (int i15 = i + 1; i15 <= i3; i15++) {
                    this.ort[i15] = this.H[i15][i14];
                }
                for (int i16 = i; i16 <= i3; i16++) {
                    double d11 = 0.0d;
                    for (int i17 = i; i17 <= i3; i17++) {
                        d11 += this.ort[i17] * this.V[i17][i16];
                    }
                    double d12 = (d11 / this.ort[i]) / this.H[i][i14];
                    for (int i18 = i; i18 <= i3; i18++) {
                        double[] dArr6 = this.V[i18];
                        dArr6[i16] = dArr6[i16] + (this.ort[i18] * d12);
                    }
                }
            }
            i--;
        }
    }

    private void cdiv(double d, double d2, double d3, double d4) {
        if (Math.abs(d3) > Math.abs(d4)) {
            double d5 = d4 / d3;
            double d6 = d3 + (d4 * d5);
            this.cdivr = ((d5 * d2) + d) / d6;
            this.cdivi = (d2 - (d5 * d)) / d6;
            return;
        }
        double d7 = d3 / d4;
        double d8 = d4 + (d3 * d7);
        this.cdivr = ((d7 * d) + d2) / d8;
        this.cdivi = ((d7 * d2) - d) / d8;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void hqr2() {
        /*
            Method dump skipped, instructions count: 1993
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Catalano.Math.Decompositions.EigenvalueDecomposition.hqr2():void");
    }

    public double[][] getV() {
        double[][] dArr = this.V;
        int i = this.n;
        return Matrix.getAuthRequestContext(dArr, i, i);
    }

    public double[] getRealEigenvalues() {
        return this.d;
    }

    public double[] getImagEigenvalues() {
        return this.e;
    }

    public double[][] getD() {
        int i = this.n;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (int i2 = 0; i2 < this.n; i2++) {
            for (int i3 = 0; i3 < this.n; i3++) {
                dArr[i2][i3] = 0.0d;
            }
            double[] dArr2 = dArr[i2];
            dArr2[i2] = this.d[i2];
            double d = this.e[i2];
            if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dArr2[i2 + 1] = d;
            } else if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dArr2[i2 - 1] = d;
            }
        }
        return dArr;
    }
}
