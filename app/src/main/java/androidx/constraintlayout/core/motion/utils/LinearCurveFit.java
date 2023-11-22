package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class LinearCurveFit extends CurveFit {
    private double[] BuiltInFictitiousFunctionClassFactory;
    double[] KClassImpl$Data$declaredNonStaticMembers$2;
    private double[][] MyBillsEntityDataFactory;
    private boolean PlaceComponentResult = true;
    private double getAuthRequestContext;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.getAuthRequestContext = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new double[length2];
        this.BuiltInFictitiousFunctionClassFactory = dArr;
        this.MyBillsEntityDataFactory = dArr2;
        if (length2 > 2) {
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr2[i][0];
            }
            this.getAuthRequestContext = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void getAuthRequestContext(double d, double[] dArr) {
        double[] dArr2 = this.BuiltInFictitiousFunctionClassFactory;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.MyBillsEntityDataFactory[0].length;
        if (this.PlaceComponentResult) {
            double d2 = dArr2[0];
            if (d <= d2) {
                PlaceComponentResult(d2, this.KClassImpl$Data$declaredNonStaticMembers$2);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.MyBillsEntityDataFactory[0][i2] + ((d - this.BuiltInFictitiousFunctionClassFactory[0]) * this.KClassImpl$Data$declaredNonStaticMembers$2[i2]);
                }
                return;
            }
            int i3 = length - 1;
            double d3 = dArr2[i3];
            if (d >= d3) {
                PlaceComponentResult(d3, this.KClassImpl$Data$declaredNonStaticMembers$2);
                while (i < length2) {
                    dArr[i] = this.MyBillsEntityDataFactory[i3][i] + ((d - this.BuiltInFictitiousFunctionClassFactory[i3]) * this.KClassImpl$Data$declaredNonStaticMembers$2[i]);
                    i++;
                }
                return;
            }
        } else if (d <= dArr2[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                dArr[i4] = this.MyBillsEntityDataFactory[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = this.MyBillsEntityDataFactory[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.BuiltInFictitiousFunctionClassFactory[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.MyBillsEntityDataFactory[i6][i7];
                }
            }
            double[] dArr3 = this.BuiltInFictitiousFunctionClassFactory;
            int i8 = i6 + 1;
            double d4 = dArr3[i8];
            if (d < d4) {
                double d5 = dArr3[i6];
                double d6 = (d - d5) / (d4 - d5);
                while (i < length2) {
                    double[][] dArr4 = this.MyBillsEntityDataFactory;
                    dArr[i] = (dArr4[i6][i] * (1.0d - d6)) + (dArr4[i8][i] * d6);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void KClassImpl$Data$declaredNonStaticMembers$2(double d, float[] fArr) {
        double[] dArr = this.BuiltInFictitiousFunctionClassFactory;
        int length = dArr.length;
        int i = 0;
        int length2 = this.MyBillsEntityDataFactory[0].length;
        if (this.PlaceComponentResult) {
            double d2 = dArr[0];
            if (d <= d2) {
                PlaceComponentResult(d2, this.KClassImpl$Data$declaredNonStaticMembers$2);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.MyBillsEntityDataFactory[0][i2] + ((d - this.BuiltInFictitiousFunctionClassFactory[0]) * this.KClassImpl$Data$declaredNonStaticMembers$2[i2]));
                }
                return;
            }
            int i3 = length - 1;
            double d3 = dArr[i3];
            if (d >= d3) {
                PlaceComponentResult(d3, this.KClassImpl$Data$declaredNonStaticMembers$2);
                while (i < length2) {
                    fArr[i] = (float) (this.MyBillsEntityDataFactory[i3][i] + ((d - this.BuiltInFictitiousFunctionClassFactory[i3]) * this.KClassImpl$Data$declaredNonStaticMembers$2[i]));
                    i++;
                }
                return;
            }
        } else if (d <= dArr[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                fArr[i4] = (float) this.MyBillsEntityDataFactory[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) this.MyBillsEntityDataFactory[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.BuiltInFictitiousFunctionClassFactory[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.MyBillsEntityDataFactory[i6][i7];
                }
            }
            double[] dArr2 = this.BuiltInFictitiousFunctionClassFactory;
            int i8 = i6 + 1;
            double d4 = dArr2[i8];
            if (d < d4) {
                double d5 = dArr2[i6];
                double d6 = (d - d5) / (d4 - d5);
                while (i < length2) {
                    double[][] dArr3 = this.MyBillsEntityDataFactory;
                    fArr[i] = (float) ((dArr3[i6][i] * (1.0d - d6)) + (dArr3[i8][i] * d6));
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
        double[] dArr = this.BuiltInFictitiousFunctionClassFactory;
        int length = dArr.length;
        if (this.PlaceComponentResult) {
            double d4 = dArr[0];
            if (d <= d4) {
                d2 = this.MyBillsEntityDataFactory[0][0];
                d3 = d - d4;
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(d4);
            } else {
                int i = length - 1;
                double d5 = dArr[i];
                if (d >= d5) {
                    d2 = this.MyBillsEntityDataFactory[i][0];
                    d3 = d - d5;
                    MyBillsEntityDataFactory = MyBillsEntityDataFactory(d5);
                }
            }
            return d2 + (d3 * MyBillsEntityDataFactory);
        } else if (d <= dArr[0]) {
            return this.MyBillsEntityDataFactory[0][0];
        } else {
            int i2 = length - 1;
            if (d >= dArr[i2]) {
                return this.MyBillsEntityDataFactory[i2][0];
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr2 = this.BuiltInFictitiousFunctionClassFactory;
            double d6 = dArr2[i3];
            if (d == d6) {
                return this.MyBillsEntityDataFactory[i3][0];
            }
            int i4 = i3 + 1;
            double d7 = dArr2[i4];
            if (d < d7) {
                double d8 = (d - d6) / (d7 - d6);
                double[][] dArr3 = this.MyBillsEntityDataFactory;
                return (dArr3[i3][0] * (1.0d - d8)) + (dArr3[i4][0] * d8);
            }
            i3 = i4;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r13 >= r4) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.BuiltInFictitiousFunctionClassFactory
            int r1 = r0.length
            double[][] r2 = r12.MyBillsEntityDataFactory
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r13 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = 0
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L42
            double[] r4 = r12.BuiltInFictitiousFunctionClassFactory
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L40
            r13 = r4[r0]
        L2b:
            if (r3 >= r2) goto L42
            double[][] r1 = r12.MyBillsEntityDataFactory
            r4 = r1[r0]
            r8 = r4[r3]
            r1 = r1[r5]
            r10 = r1[r3]
            double r10 = r10 - r8
            double r8 = r6 - r13
            double r10 = r10 / r8
            r15[r3] = r10
            int r3 = r3 + 1
            goto L2b
        L40:
            r0 = r5
            goto L1b
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.PlaceComponentResult(double, double[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r10 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double MyBillsEntityDataFactory(double r10) {
        /*
            r9 = this;
            double[] r0 = r9.BuiltInFictitiousFunctionClassFactory
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r10 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            r0 = 0
        L16:
            int r3 = r1 + (-1)
            if (r0 >= r3) goto L36
            double[] r3 = r9.BuiltInFictitiousFunctionClassFactory
            int r4 = r0 + 1
            r5 = r3[r4]
            int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r7 > 0) goto L34
            r10 = r3[r0]
            double[][] r1 = r9.MyBillsEntityDataFactory
            r0 = r1[r0]
            r7 = r0[r2]
            r0 = r1[r4]
            r1 = r0[r2]
            double r1 = r1 - r7
            double r5 = r5 - r10
            double r1 = r1 / r5
            return r1
        L34:
            r0 = r4
            goto L16
        L36:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.MyBillsEntityDataFactory(double):double");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
