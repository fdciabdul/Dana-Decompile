package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public abstract class CurveFit {
    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(double d, float[] fArr);

    public abstract double MyBillsEntityDataFactory(double d);

    public abstract void PlaceComponentResult(double d, double[] dArr);

    public abstract double getAuthRequestContext(double d);

    public abstract void getAuthRequestContext(double d, double[] dArr);

    public abstract double[] getAuthRequestContext();

    public static CurveFit PlaceComponentResult(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i != 0) {
            if (i == 2) {
                return new Constant(dArr[0], dArr2[0]);
            }
            return new LinearCurveFit(dArr, dArr2);
        }
        return new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    /* loaded from: classes3.dex */
    static class Constant extends CurveFit {
        double[] BuiltInFictitiousFunctionClassFactory;
        double KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final double MyBillsEntityDataFactory(double d) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        Constant(double d, double[] dArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = d;
            this.BuiltInFictitiousFunctionClassFactory = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final void getAuthRequestContext(double d, double[] dArr) {
            double[] dArr2 = this.BuiltInFictitiousFunctionClassFactory;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final void KClassImpl$Data$declaredNonStaticMembers$2(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.BuiltInFictitiousFunctionClassFactory;
                if (i >= dArr.length) {
                    return;
                }
                fArr[i] = (float) dArr[i];
                i++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final double getAuthRequestContext(double d) {
            return this.BuiltInFictitiousFunctionClassFactory[0];
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final void PlaceComponentResult(double d, double[] dArr) {
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final double[] getAuthRequestContext() {
            return new double[]{this.KClassImpl$Data$declaredNonStaticMembers$2};
        }
    }
}
