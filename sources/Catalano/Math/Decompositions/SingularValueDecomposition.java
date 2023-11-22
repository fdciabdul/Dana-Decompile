package Catalano.Math.Decompositions;

import Catalano.Math.Matrix;
import Catalano.Math.Tools;
import com.google.common.primitives.Longs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class SingularValueDecomposition implements Serializable {
    private double[][] U;
    private double[][] V;
    private int m;
    private int n;
    private double[] s;
    boolean wantu;
    boolean wantv;

    public boolean isWantU() {
        return this.wantu;
    }

    public void setWantU(boolean z) {
        this.wantu = z;
    }

    public boolean isWantV() {
        return this.wantv;
    }

    public void setWantV(boolean z) {
        this.wantv = z;
    }

    public SingularValueDecomposition(double[][] dArr, boolean z, boolean z2) {
        this.wantu = z;
        this.wantv = z2;
        Compute(dArr);
    }

    public SingularValueDecomposition(double[][] dArr) {
        this.wantu = true;
        this.wantv = true;
        Compute(dArr);
    }

    private void Compute(double[][] dArr) {
        double[][] KClassImpl$Data$declaredNonStaticMembers$2;
        boolean z;
        double d;
        char c;
        int i;
        boolean z2;
        double d2;
        double d3;
        long j;
        int i2;
        double d4;
        int i3;
        int i4;
        int i5;
        double[] dArr2;
        SingularValueDecomposition singularValueDecomposition = this;
        if (dArr.length == 0 && dArr[0].length == 0) {
            throw new IllegalArgumentException("Matrix does not have any rows or columns.");
        }
        if (dArr.length < dArr[0].length) {
            KClassImpl$Data$declaredNonStaticMembers$2 = Matrix.BuiltInFictitiousFunctionClassFactory(dArr);
            z = true;
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = Matrix.KClassImpl$Data$declaredNonStaticMembers$2(dArr);
            z = false;
        }
        int length = KClassImpl$Data$declaredNonStaticMembers$2.length;
        singularValueDecomposition.m = length;
        int length2 = KClassImpl$Data$declaredNonStaticMembers$2[0].length;
        singularValueDecomposition.n = length2;
        int min = Math.min(length, length2);
        singularValueDecomposition.s = new double[Math.min(singularValueDecomposition.m + 1, singularValueDecomposition.n)];
        singularValueDecomposition.U = (double[][]) Array.newInstance(Double.TYPE, singularValueDecomposition.m, min);
        int i6 = singularValueDecomposition.n;
        singularValueDecomposition.V = (double[][]) Array.newInstance(Double.TYPE, i6, i6);
        int i7 = singularValueDecomposition.n;
        double[] dArr3 = new double[i7];
        int i8 = singularValueDecomposition.m;
        double[] dArr4 = new double[i8];
        int min2 = Math.min(i8 - 1, i7);
        int max = Math.max(0, Math.min(singularValueDecomposition.n - 2, singularValueDecomposition.m));
        int i9 = 0;
        while (true) {
            int max2 = Math.max(min2, max);
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i9 >= max2) {
                break;
            }
            if (i9 < min2) {
                singularValueDecomposition.s[i9] = 0.0d;
                int i10 = i9;
                while (i10 < singularValueDecomposition.m) {
                    double[] dArr5 = singularValueDecomposition.s;
                    dArr5[i9] = Tools.getAuthRequestContext(dArr5[i9], KClassImpl$Data$declaredNonStaticMembers$2[i10][i9]);
                    i10++;
                    dArr3 = dArr3;
                    min2 = min2;
                }
                i5 = min2;
                dArr2 = dArr3;
                double[] dArr6 = singularValueDecomposition.s;
                double d5 = dArr6[i9];
                if (d5 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    if (KClassImpl$Data$declaredNonStaticMembers$2[i9][i9] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        dArr6[i9] = -d5;
                    }
                    for (int i11 = i9; i11 < singularValueDecomposition.m; i11++) {
                        double[] dArr7 = KClassImpl$Data$declaredNonStaticMembers$2[i11];
                        dArr7[i9] = dArr7[i9] / singularValueDecomposition.s[i9];
                    }
                    double[] dArr8 = KClassImpl$Data$declaredNonStaticMembers$2[i9];
                    dArr8[i9] = dArr8[i9] + 1.0d;
                }
                double[] dArr9 = singularValueDecomposition.s;
                dArr9[i9] = -dArr9[i9];
            } else {
                i5 = min2;
                dArr2 = dArr3;
            }
            int i12 = i9 + 1;
            int i13 = i12;
            while (i13 < singularValueDecomposition.n) {
                int i14 = i5;
                if (i9 < i14 && singularValueDecomposition.s[i9] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double d6 = 0.0d;
                    for (int i15 = i9; i15 < singularValueDecomposition.m; i15++) {
                        double[] dArr10 = KClassImpl$Data$declaredNonStaticMembers$2[i15];
                        d6 += dArr10[i9] * dArr10[i13];
                    }
                    double d7 = (-d6) / KClassImpl$Data$declaredNonStaticMembers$2[i9][i9];
                    for (int i16 = i9; i16 < singularValueDecomposition.m; i16++) {
                        double[] dArr11 = KClassImpl$Data$declaredNonStaticMembers$2[i16];
                        dArr11[i13] = dArr11[i13] + (dArr11[i9] * d7);
                    }
                }
                dArr2[i13] = KClassImpl$Data$declaredNonStaticMembers$2[i9][i13];
                i13++;
                i5 = i14;
            }
            min2 = i5;
            if (singularValueDecomposition.wantu & (i9 < min2)) {
                for (int i17 = i9; i17 < singularValueDecomposition.m; i17++) {
                    singularValueDecomposition.U[i17][i9] = KClassImpl$Data$declaredNonStaticMembers$2[i17][i9];
                }
            }
            if (i9 < max) {
                dArr2[i9] = 0.0d;
                for (int i18 = i12; i18 < singularValueDecomposition.n; i18++) {
                    dArr2[i9] = Tools.getAuthRequestContext(dArr2[i9], dArr2[i18]);
                }
                double d8 = dArr2[i9];
                if (d8 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    if (dArr2[i12] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        dArr2[i9] = -d8;
                    }
                    for (int i19 = i12; i19 < singularValueDecomposition.n; i19++) {
                        dArr2[i19] = dArr2[i19] / dArr2[i9];
                    }
                    dArr2[i12] = dArr2[i12] + 1.0d;
                }
                double d9 = -dArr2[i9];
                dArr2[i9] = d9;
                if ((i12 < singularValueDecomposition.m) & (d9 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                    for (int i20 = i12; i20 < singularValueDecomposition.m; i20++) {
                        dArr4[i20] = 0.0d;
                    }
                    for (int i21 = i12; i21 < singularValueDecomposition.n; i21++) {
                        for (int i22 = i12; i22 < singularValueDecomposition.m; i22++) {
                            dArr4[i22] = dArr4[i22] + (dArr2[i21] * KClassImpl$Data$declaredNonStaticMembers$2[i22][i21]);
                        }
                    }
                    for (int i23 = i12; i23 < singularValueDecomposition.n; i23++) {
                        double d10 = (-dArr2[i23]) / dArr2[i12];
                        for (int i24 = i12; i24 < singularValueDecomposition.m; i24++) {
                            double[] dArr12 = KClassImpl$Data$declaredNonStaticMembers$2[i24];
                            dArr12[i23] = dArr12[i23] + (dArr4[i24] * d10);
                        }
                    }
                }
                if (singularValueDecomposition.wantv) {
                    for (int i25 = i12; i25 < singularValueDecomposition.n; i25++) {
                        singularValueDecomposition.V[i25][i9] = dArr2[i25];
                    }
                }
            }
            i9 = i12;
            dArr3 = dArr2;
        }
        double[] dArr13 = dArr3;
        int min3 = Math.min(singularValueDecomposition.n, singularValueDecomposition.m + 1);
        if (min2 < singularValueDecomposition.n) {
            singularValueDecomposition.s[min2] = KClassImpl$Data$declaredNonStaticMembers$2[min2][min2];
        }
        if (singularValueDecomposition.m < min3) {
            singularValueDecomposition.s[min3 - 1] = 0.0d;
        }
        if (max + 1 < min3) {
            dArr13[max] = KClassImpl$Data$declaredNonStaticMembers$2[max][min3 - 1];
        }
        int i26 = min3 - 1;
        dArr13[i26] = 0.0d;
        int i27 = -1;
        if (singularValueDecomposition.wantu) {
            for (int i28 = min2; i28 < min; i28++) {
                for (int i29 = 0; i29 < singularValueDecomposition.m; i29++) {
                    singularValueDecomposition.U[i29][i28] = 0.0d;
                }
                singularValueDecomposition.U[i28][i28] = 1.0d;
            }
            for (int i30 = min2 - 1; i30 >= 0; i30--) {
                if (singularValueDecomposition.s[i30] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    for (int i31 = i30 + 1; i31 < min; i31++) {
                        double d11 = 0.0d;
                        for (int i32 = i30; i32 < singularValueDecomposition.m; i32++) {
                            double[] dArr14 = singularValueDecomposition.U[i32];
                            d11 += dArr14[i30] * dArr14[i31];
                        }
                        double d12 = (-d11) / singularValueDecomposition.U[i30][i30];
                        for (int i33 = i30; i33 < singularValueDecomposition.m; i33++) {
                            double[] dArr15 = singularValueDecomposition.U[i33];
                            dArr15[i31] = dArr15[i31] + (dArr15[i30] * d12);
                        }
                    }
                    for (int i34 = i30; i34 < singularValueDecomposition.m; i34++) {
                        double[] dArr16 = singularValueDecomposition.U[i34];
                        dArr16[i30] = -dArr16[i30];
                    }
                    double[] dArr17 = singularValueDecomposition.U[i30];
                    dArr17[i30] = dArr17[i30] + 1.0d;
                    for (int i35 = 0; i35 < i30 - 1; i35++) {
                        singularValueDecomposition.U[i35][i30] = 0.0d;
                    }
                } else {
                    for (int i36 = 0; i36 < singularValueDecomposition.m; i36++) {
                        singularValueDecomposition.U[i36][i30] = 0.0d;
                    }
                    singularValueDecomposition.U[i30][i30] = 1.0d;
                }
            }
        }
        if (singularValueDecomposition.wantv) {
            int i37 = singularValueDecomposition.n - 1;
            while (i37 >= 0) {
                if ((i37 < max) & (dArr13[i37] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                    int i38 = i37 + 1;
                    for (int i39 = i38; i39 < singularValueDecomposition.n; i39++) {
                        double d13 = 0.0d;
                        for (int i40 = i38; i40 < singularValueDecomposition.n; i40++) {
                            double[] dArr18 = singularValueDecomposition.V[i40];
                            d13 += dArr18[i37] * dArr18[i39];
                        }
                        double d14 = (-d13) / singularValueDecomposition.V[i38][i37];
                        for (int i41 = i38; i41 < singularValueDecomposition.n; i41++) {
                            double[] dArr19 = singularValueDecomposition.V[i41];
                            dArr19[i39] = dArr19[i39] + (dArr19[i37] * d14);
                        }
                    }
                }
                for (int i42 = 0; i42 < singularValueDecomposition.n; i42++) {
                    singularValueDecomposition.V[i42][i37] = 0.0d;
                }
                singularValueDecomposition.V[i37][i37] = 1.0d;
                i37--;
            }
        }
        double pow = Math.pow(2.0d, -52.0d);
        double pow2 = Math.pow(2.0d, -966.0d);
        while (min3 > 0) {
            int i43 = min3 - 2;
            int i44 = i43;
            while (true) {
                if (i44 < i27 || i44 == i27) {
                    break;
                } else if (Math.abs(dArr13[i44]) <= pow2 + ((Math.abs(singularValueDecomposition.s[i44]) + Math.abs(singularValueDecomposition.s[i44 + 1])) * pow)) {
                    dArr13[i44] = d;
                    break;
                } else {
                    i44--;
                    i27 = -1;
                }
            }
            if (i44 == i43) {
                c = 4;
            } else {
                int i45 = min3 - 1;
                int i46 = i45;
                while (true) {
                    if (i46 < i44 || i46 == i44) {
                        break;
                    }
                    if (Math.abs(singularValueDecomposition.s[i46]) <= pow2 + (((i46 != min3 ? Math.abs(dArr13[i46]) : d) + (i46 != i44 + 1 ? Math.abs(dArr13[i46 - 1]) : d)) * pow)) {
                        singularValueDecomposition.s[i46] = d;
                        break;
                    }
                    i46--;
                }
                if (i46 == i44) {
                    c = 3;
                } else if (i46 == i45) {
                    c = 1;
                } else {
                    i44 = i46;
                    c = 2;
                }
            }
            int i47 = i44 + 1;
            if (c == 1) {
                i = i26;
                z2 = z;
                d2 = pow;
                d3 = pow2;
                j = Longs.MAX_POWER_OF_TWO;
                i2 = min3;
                double d15 = dArr13[i43];
                dArr13[i43] = 0.0d;
                while (i43 >= i47) {
                    double authRequestContext = Tools.getAuthRequestContext(singularValueDecomposition.s[i43], d15);
                    double[] dArr20 = singularValueDecomposition.s;
                    double d16 = dArr20[i43] / authRequestContext;
                    double d17 = d15 / authRequestContext;
                    dArr20[i43] = authRequestContext;
                    if (i43 != i47) {
                        int i48 = i43 - 1;
                        double d18 = dArr13[i48];
                        d15 = (-d17) * d18;
                        dArr13[i48] = d18 * d16;
                    }
                    if (singularValueDecomposition.wantv) {
                        int i49 = 0;
                        while (i49 < singularValueDecomposition.n) {
                            double[] dArr21 = singularValueDecomposition.V[i49];
                            double d19 = dArr21[i43];
                            int i50 = i2 - 1;
                            double d20 = dArr21[i50];
                            dArr21[i50] = ((-d17) * d19) + (d20 * d16);
                            dArr21[i43] = (d19 * d16) + (d20 * d17);
                            i49++;
                            d15 = d15;
                        }
                    }
                    i43--;
                    d15 = d15;
                }
            } else if (c == 2) {
                i = i26;
                z2 = z;
                int i51 = min3;
                d2 = pow;
                d3 = pow2;
                j = Longs.MAX_POWER_OF_TWO;
                int i52 = i47 - 1;
                double d21 = dArr13[i52];
                dArr13[i52] = 0.0d;
                int i53 = i47;
                i2 = i51;
                while (i53 < i2) {
                    double authRequestContext2 = Tools.getAuthRequestContext(singularValueDecomposition.s[i53], d21);
                    double[] dArr22 = singularValueDecomposition.s;
                    double d22 = dArr22[i53] / authRequestContext2;
                    double d23 = d21 / authRequestContext2;
                    dArr22[i53] = authRequestContext2;
                    double d24 = -d23;
                    double d25 = dArr13[i53];
                    dArr13[i53] = d25 * d22;
                    if (singularValueDecomposition.wantu) {
                        for (int i54 = 0; i54 < singularValueDecomposition.m; i54++) {
                            double[] dArr23 = singularValueDecomposition.U[i54];
                            double d26 = dArr23[i53];
                            double d27 = dArr23[i52];
                            dArr23[i52] = (d26 * d24) + (d27 * d22);
                            dArr23[i53] = (d26 * d22) + (d27 * d23);
                        }
                    }
                    i53++;
                    d21 = d24 * d25;
                }
            } else if (c != 3) {
                if (c == 4) {
                    double[] dArr24 = singularValueDecomposition.s;
                    double d28 = dArr24[i47];
                    if (d28 <= d) {
                        dArr24[i47] = d28 < d ? -d28 : d;
                        if (singularValueDecomposition.wantv) {
                            for (int i55 = 0; i55 <= i26; i55++) {
                                double[] dArr25 = singularValueDecomposition.V[i55];
                                dArr25[i47] = -dArr25[i47];
                            }
                        }
                    }
                    while (i47 < i26) {
                        double[] dArr26 = singularValueDecomposition.s;
                        double d29 = dArr26[i47];
                        int i56 = i47 + 1;
                        double d30 = dArr26[i56];
                        if (d29 >= d30) {
                            break;
                        }
                        dArr26[i47] = d30;
                        dArr26[i56] = d29;
                        if (singularValueDecomposition.wantv && i47 < singularValueDecomposition.n - 1) {
                            int i57 = 0;
                            while (i57 < singularValueDecomposition.n) {
                                double[] dArr27 = singularValueDecomposition.V[i57];
                                double d31 = dArr27[i56];
                                dArr27[i56] = dArr27[i47];
                                dArr27[i47] = -d31;
                                i57++;
                                pow2 = pow2;
                            }
                        }
                        double d32 = pow2;
                        if (singularValueDecomposition.wantu && i47 < singularValueDecomposition.m - 1) {
                            for (int i58 = 0; i58 < singularValueDecomposition.m; i58++) {
                                double[] dArr28 = singularValueDecomposition.U[i58];
                                double d33 = dArr28[i56];
                                dArr28[i56] = dArr28[i47];
                                dArr28[i47] = d33;
                            }
                        }
                        i47 = i56;
                        pow2 = d32;
                    }
                    d3 = pow2;
                    min3--;
                } else {
                    d3 = pow2;
                }
                i = i26;
                z2 = z;
                d2 = pow;
                j = Longs.MAX_POWER_OF_TWO;
                pow2 = d3;
                z = z2;
                i26 = i;
                pow = d2;
                i27 = -1;
                d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                d3 = pow2;
                int i59 = min3 - 1;
                double max3 = Math.max(Math.max(Math.max(Math.max(Math.abs(singularValueDecomposition.s[i59]), Math.abs(singularValueDecomposition.s[i43])), Math.abs(dArr13[i43])), Math.abs(singularValueDecomposition.s[i47])), Math.abs(dArr13[i47]));
                double[] dArr29 = singularValueDecomposition.s;
                double d34 = dArr29[i59] / max3;
                double d35 = dArr29[i43] / max3;
                double d36 = dArr13[i43] / max3;
                double d37 = dArr29[i47] / max3;
                double d38 = dArr13[i47] / max3;
                j = Longs.MAX_POWER_OF_TWO;
                double d39 = (((d35 + d34) * (d35 - d34)) + (d36 * d36)) / 2.0d;
                double d40 = d36 * d34;
                double d41 = d40 * d40;
                if ((d39 != d) || (d41 != d)) {
                    d2 = pow;
                    double sqrt = Math.sqrt((d39 * d39) + d41);
                    if (d39 < d) {
                        sqrt = -sqrt;
                    }
                    d4 = d41 / (d39 + sqrt);
                } else {
                    d2 = pow;
                    d4 = d;
                }
                double d42 = ((d37 + d34) * (d37 - d34)) + d4;
                int i60 = i47;
                double d43 = d37 * d38;
                while (i60 < i59) {
                    double authRequestContext3 = Tools.getAuthRequestContext(d42, d43);
                    double d44 = d42 / authRequestContext3;
                    double d45 = d43 / authRequestContext3;
                    if (i60 != i47) {
                        dArr13[i60 - 1] = authRequestContext3;
                    }
                    double[] dArr30 = singularValueDecomposition.s;
                    double d46 = dArr30[i60];
                    double d47 = dArr13[i60];
                    int i61 = i26;
                    boolean z3 = z;
                    double d48 = (d44 * d46) + (d45 * d47);
                    dArr13[i60] = (d47 * d44) - (d46 * d45);
                    int i62 = i60 + 1;
                    double d49 = dArr30[i62];
                    double d50 = d45 * d49;
                    dArr30[i62] = d49 * d44;
                    if (singularValueDecomposition.wantv) {
                        i3 = i59;
                        int i63 = 0;
                        while (i63 < singularValueDecomposition.n) {
                            double[] dArr31 = singularValueDecomposition.V[i63];
                            double d51 = dArr31[i60];
                            double d52 = dArr31[i62];
                            dArr31[i62] = ((-d45) * d51) + (d52 * d44);
                            dArr31[i60] = (d51 * d44) + (d52 * d45);
                            i63++;
                            singularValueDecomposition = this;
                            d48 = d48;
                        }
                    } else {
                        i3 = i59;
                    }
                    double d53 = d48;
                    double authRequestContext4 = Tools.getAuthRequestContext(d53, d50);
                    double d54 = d53 / authRequestContext4;
                    double d55 = d50 / authRequestContext4;
                    singularValueDecomposition = this;
                    double[] dArr32 = singularValueDecomposition.s;
                    dArr32[i60] = authRequestContext4;
                    double d56 = dArr13[i60];
                    double d57 = dArr32[i62];
                    int i64 = i47;
                    double d58 = -d55;
                    dArr32[i62] = (d56 * d58) + (d57 * d54);
                    double d59 = dArr13[i62];
                    double d60 = d55 * d59;
                    dArr13[i62] = d59 * d54;
                    if (singularValueDecomposition.wantu) {
                        i4 = min3;
                        if (i60 < singularValueDecomposition.m - 1) {
                            for (int i65 = 0; i65 < singularValueDecomposition.m; i65++) {
                                double[] dArr33 = singularValueDecomposition.U[i65];
                                double d61 = dArr33[i60];
                                double d62 = dArr33[i62];
                                dArr33[i62] = (d61 * d58) + (d62 * d54);
                                dArr33[i60] = (d61 * d54) + (d62 * d55);
                            }
                        }
                    } else {
                        i4 = min3;
                    }
                    d42 = (d54 * d56) + (d55 * d57);
                    i60 = i62;
                    i59 = i3;
                    i47 = i64;
                    min3 = i4;
                    z = z3;
                    i26 = i61;
                    d43 = d60;
                }
                i = i26;
                z2 = z;
                dArr13[i43] = d42;
                i2 = min3;
            }
            min3 = i2;
            pow2 = d3;
            z = z2;
            i26 = i;
            pow = d2;
            i27 = -1;
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (z) {
            double[][] KClassImpl$Data$declaredNonStaticMembers$22 = Matrix.KClassImpl$Data$declaredNonStaticMembers$2(singularValueDecomposition.U);
            singularValueDecomposition.U = singularValueDecomposition.V;
            singularValueDecomposition.V = KClassImpl$Data$declaredNonStaticMembers$22;
        }
    }

    public double[][] getU() {
        return this.U;
    }

    public double[][] getV() {
        return this.V;
    }

    public double[] getSingularValues() {
        return this.s;
    }

    public double[][] getS() {
        int i = this.n;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i);
        for (int i2 = 0; i2 < this.n; i2++) {
            for (int i3 = 0; i3 < this.n; i3++) {
                dArr[i2][i3] = 0.0d;
            }
            dArr[i2][i2] = this.s[i2];
        }
        return dArr;
    }

    public double norm2() {
        return this.s[0];
    }

    public double cond() {
        double[] dArr = this.s;
        return dArr[0] / dArr[Math.min(this.m, this.n) - 1];
    }

    public int rank() {
        double pow = Math.pow(2.0d, -52.0d);
        double max = Math.max(this.m, this.n);
        int i = 0;
        double d = this.s[0];
        int i2 = 0;
        while (true) {
            double[] dArr = this.s;
            if (i >= dArr.length) {
                return i2;
            }
            double d2 = dArr[i];
            Double.isNaN(max);
            if (d2 > max * d * pow) {
                i2++;
            }
            i++;
        }
    }

    public double threshold() {
        double max = Math.max(this.m, this.n);
        Double.isNaN(max);
        return max * 1.1102230246251565E-16d * this.s[0];
    }

    public double[][] inverse() {
        double threshold = threshold();
        double[][] dArr = this.V;
        int length = dArr.length;
        int length2 = dArr[0].length;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, length, this.s.length);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                if (Math.abs(this.s[i2]) > threshold) {
                    dArr2[i][i2] = this.V[i][i2] / this.s[i2];
                }
            }
        }
        double[][] dArr3 = this.U;
        int length3 = dArr3.length;
        int length4 = dArr3[0].length;
        double[][] dArr4 = (double[][]) Array.newInstance(Double.TYPE, length, length3);
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length3; i4++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i5 = 0; i5 < length4; i5++) {
                    d += dArr2[i3][i5] * this.U[i4][i5];
                }
                dArr4[i3][i4] = d;
            }
        }
        return dArr4;
    }
}
