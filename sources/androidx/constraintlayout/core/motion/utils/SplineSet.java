package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class SplineSet {
    private int BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    protected int[] MyBillsEntityDataFactory = new int[10];
    protected float[] PlaceComponentResult = new float[10];
    protected CurveFit getAuthRequestContext;

    /* loaded from: classes6.dex */
    static class CoreSpline extends SplineSet {
    }

    public String toString() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("[");
            sb.append(this.MyBillsEntityDataFactory[i]);
            sb.append(" , ");
            sb.append(decimalFormat.format(this.PlaceComponentResult[i]));
            sb.append("] ");
            str = sb.toString();
        }
        return str;
    }

    public final float PlaceComponentResult(float f) {
        return (float) this.getAuthRequestContext.getAuthRequestContext(f);
    }

    public final float MyBillsEntityDataFactory(float f) {
        return (float) this.getAuthRequestContext.MyBillsEntityDataFactory(f);
    }

    public void MyBillsEntityDataFactory(int i, float f) {
        int[] iArr = this.MyBillsEntityDataFactory;
        if (iArr.length < this.BuiltInFictitiousFunctionClassFactory + 1) {
            this.MyBillsEntityDataFactory = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.PlaceComponentResult;
            this.PlaceComponentResult = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.MyBillsEntityDataFactory;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        iArr2[i2] = i;
        this.PlaceComponentResult[i2] = f;
        this.BuiltInFictitiousFunctionClassFactory = i2 + 1;
    }

    public void MyBillsEntityDataFactory(int i) {
        int i2;
        int i3 = this.BuiltInFictitiousFunctionClassFactory;
        if (i3 == 0) {
            return;
        }
        Sort.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.PlaceComponentResult, i3 - 1);
        int i4 = 1;
        for (int i5 = 1; i5 < this.BuiltInFictitiousFunctionClassFactory; i5++) {
            int[] iArr = this.MyBillsEntityDataFactory;
            if (iArr[i5 - 1] != iArr[i5]) {
                i4++;
            }
        }
        double[] dArr = new double[i4];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i4, 1);
        int i6 = 0;
        while (i2 < this.BuiltInFictitiousFunctionClassFactory) {
            if (i2 > 0) {
                int[] iArr2 = this.MyBillsEntityDataFactory;
                i2 = iArr2[i2] == iArr2[i2 + (-1)] ? i2 + 1 : 0;
            }
            double d = this.MyBillsEntityDataFactory[i2];
            Double.isNaN(d);
            dArr[i6] = d * 0.01d;
            dArr2[i6][0] = this.PlaceComponentResult[i2];
            i6++;
        }
        this.getAuthRequestContext = CurveFit.PlaceComponentResult(i, dArr, dArr2);
    }

    /* loaded from: classes3.dex */
    static class Sort {
        private Sort() {
        }

        static void KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr, float[] fArr, int i) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i;
            iArr2[1] = 0;
            int i2 = 2;
            while (i2 > 0) {
                int i3 = i2 - 1;
                int i4 = iArr2[i3];
                i2 = i3 - 1;
                int i5 = iArr2[i2];
                if (i4 < i5) {
                    int i6 = iArr[i5];
                    int i7 = i4;
                    int i8 = i7;
                    while (i7 < i5) {
                        if (iArr[i7] <= i6) {
                            int i9 = iArr[i8];
                            iArr[i8] = iArr[i7];
                            iArr[i7] = i9;
                            float f = fArr[i8];
                            fArr[i8] = fArr[i7];
                            fArr[i7] = f;
                            i8++;
                        }
                        i7++;
                    }
                    int i10 = iArr[i8];
                    iArr[i8] = iArr[i5];
                    iArr[i5] = i10;
                    float f2 = fArr[i8];
                    fArr[i8] = fArr[i5];
                    fArr[i5] = f2;
                    int i11 = i2 + 1;
                    iArr2[i2] = i8 - 1;
                    int i12 = i11 + 1;
                    iArr2[i11] = i4;
                    int i13 = i12 + 1;
                    iArr2[i12] = i5;
                    i2 = i13 + 1;
                    iArr2[i13] = i8 + 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class CustomSet extends SplineSet {
        KeyFrameArray.CustomArray BuiltInFictitiousFunctionClassFactory;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda0;

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void MyBillsEntityDataFactory(int i) {
            int i2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            KeyFrameArray.CustomArray customArray = this.BuiltInFictitiousFunctionClassFactory;
            int i3 = CustomAttribute.AnonymousClass1.getAuthRequestContext[customArray.getAuthRequestContext[customArray.MyBillsEntityDataFactory[0]].getAuthRequestContext.ordinal()];
            int i4 = 4;
            if (i3 != 4 && i3 != 5) {
                i4 = 1;
            }
            double[] dArr = new double[i2];
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[i4];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i2, i4);
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory[i5];
                KeyFrameArray.CustomArray customArray2 = this.BuiltInFictitiousFunctionClassFactory;
                CustomAttribute customAttribute = customArray2.getAuthRequestContext[customArray2.MyBillsEntityDataFactory[i5]];
                double d = i6;
                Double.isNaN(d);
                dArr[i5] = d * 0.01d;
                customAttribute.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                int i7 = 0;
                while (true) {
                    if (i7 < this.NetworkUserEntityData$$ExternalSyntheticLambda0.length) {
                        dArr2[i5][i7] = r6[i7];
                        i7++;
                    }
                }
            }
            this.getAuthRequestContext = CurveFit.PlaceComponentResult(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void MyBillsEntityDataFactory(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }
    }

    /* loaded from: classes6.dex */
    public static class CustomSpline extends SplineSet {
        KeyFrameArray.CustomVar BuiltInFictitiousFunctionClassFactory;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda0;

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void MyBillsEntityDataFactory(int i) {
            int i2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            KeyFrameArray.CustomVar customVar = this.BuiltInFictitiousFunctionClassFactory;
            int i3 = customVar.getAuthRequestContext[customVar.BuiltInFictitiousFunctionClassFactory[0]].BuiltInFictitiousFunctionClassFactory != 902 ? 1 : 4;
            double[] dArr = new double[i2];
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[i3];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i2, i3);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory[i4];
                KeyFrameArray.CustomVar customVar2 = this.BuiltInFictitiousFunctionClassFactory;
                CustomVariable customVariable = customVar2.getAuthRequestContext[customVar2.BuiltInFictitiousFunctionClassFactory[i4]];
                double d = i5;
                Double.isNaN(d);
                dArr[i4] = d * 0.01d;
                customVariable.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                int i6 = 0;
                while (true) {
                    if (i6 < this.NetworkUserEntityData$$ExternalSyntheticLambda0.length) {
                        dArr2[i4][i6] = r6[i6];
                        i6++;
                    }
                }
            }
            this.getAuthRequestContext = CurveFit.PlaceComponentResult(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void MyBillsEntityDataFactory(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }
    }
}
