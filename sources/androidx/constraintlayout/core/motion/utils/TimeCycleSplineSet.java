package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public abstract class TimeCycleSplineSet {
    protected static float MyBillsEntityDataFactory = 6.2831855f;
    protected long KClassImpl$Data$declaredNonStaticMembers$2;
    protected int PlaceComponentResult;
    protected CurveFit lookAheadTest;
    protected String moveToNextValue;
    protected int DatabaseTableConfigUtil = 0;
    protected int[] scheduleImpl = new int[10];
    protected float[][] getErrorConfigVersion = (float[][]) Array.newInstance(Float.TYPE, 10, 3);
    protected float[] getAuthRequestContext = new float[3];
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    protected float BuiltInFictitiousFunctionClassFactory = Float.NaN;

    public String toString() {
        String str = this.moveToNextValue;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.PlaceComponentResult; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("[");
            sb.append(this.scheduleImpl[i]);
            sb.append(" , ");
            sb.append(decimalFormat.format(this.getErrorConfigVersion[i]));
            sb.append("] ");
            str = sb.toString();
        }
        return str;
    }

    public final void PlaceComponentResult(String str) {
        this.moveToNextValue = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float BuiltInFictitiousFunctionClassFactory(float f) {
        float abs;
        switch (this.DatabaseTableConfigUtil) {
            case 1:
                return Math.signum(f * MyBillsEntityDataFactory);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f * MyBillsEntityDataFactory);
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f * MyBillsEntityDataFactory);
        }
        return 1.0f - abs;
    }

    public final void getAuthRequestContext(long j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    public void MyBillsEntityDataFactory(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.scheduleImpl;
        int i3 = this.PlaceComponentResult;
        iArr[i3] = i;
        float[] fArr = this.getErrorConfigVersion[i3];
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        this.DatabaseTableConfigUtil = Math.max(this.DatabaseTableConfigUtil, i2);
        this.PlaceComponentResult++;
    }

    /* loaded from: classes6.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        float[] GetContactSyncConfig;
        KeyFrameArray.CustomArray NetworkUserEntityData$$ExternalSyntheticLambda1;
        KeyFrameArray.FloatArray NetworkUserEntityData$$ExternalSyntheticLambda2;
        float[] initRecordTimeStamp;

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void PlaceComponentResult(int i) {
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2;
            KeyFrameArray.CustomArray customArray = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            int i3 = CustomAttribute.AnonymousClass1.getAuthRequestContext[customArray.getAuthRequestContext[customArray.MyBillsEntityDataFactory[0]].getAuthRequestContext.ordinal()];
            int i4 = 4;
            if (i3 != 4 && i3 != 5) {
                i4 = 1;
            }
            double[] dArr = new double[i2];
            int i5 = i4 + 2;
            this.GetContactSyncConfig = new float[i5];
            this.initRecordTimeStamp = new float[i4];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i2, i5);
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory[i6];
                KeyFrameArray.CustomArray customArray2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                CustomAttribute customAttribute = customArray2.getAuthRequestContext[customArray2.MyBillsEntityDataFactory[i6]];
                KeyFrameArray.FloatArray floatArray = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                float[] fArr = floatArray.getAuthRequestContext[floatArray.BuiltInFictitiousFunctionClassFactory[i6]];
                double d = i7;
                Double.isNaN(d);
                dArr[i6] = d * 0.01d;
                customAttribute.KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig);
                int i8 = 0;
                while (true) {
                    if (i8 < this.GetContactSyncConfig.length) {
                        dArr2[i6][i8] = r8[i8];
                        i8++;
                    }
                }
                double[] dArr3 = dArr2[i6];
                dArr3[i4] = fArr[0];
                dArr3[i4 + 1] = fArr[1];
            }
            this.lookAheadTest = CurveFit.PlaceComponentResult(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void MyBillsEntityDataFactory(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }
    }

    public void PlaceComponentResult(int i) {
        int i2;
        int i3 = this.PlaceComponentResult;
        if (i3 == 0) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append("Error no points added to ");
            sb.append(this.moveToNextValue);
            printStream.println(sb.toString());
            return;
        }
        Sort.getAuthRequestContext(this.scheduleImpl, this.getErrorConfigVersion, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.scheduleImpl;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i5, 3);
        int i6 = 0;
        while (i2 < this.PlaceComponentResult) {
            if (i2 > 0) {
                int[] iArr2 = this.scheduleImpl;
                i2 = iArr2[i2] == iArr2[i2 + (-1)] ? i2 + 1 : 0;
            }
            double d = this.scheduleImpl[i2];
            Double.isNaN(d);
            dArr[i6] = d * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[] fArr = this.getErrorConfigVersion[i2];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i6++;
        }
        this.lookAheadTest = CurveFit.PlaceComponentResult(i, dArr, dArr2);
    }

    /* loaded from: classes3.dex */
    protected static class Sort {
        protected Sort() {
        }

        static void getAuthRequestContext(int[] iArr, float[][] fArr, int i) {
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
                            float[] fArr2 = fArr[i8];
                            fArr[i8] = fArr[i7];
                            fArr[i7] = fArr2;
                            i8++;
                        }
                        i7++;
                    }
                    int i10 = iArr[i8];
                    iArr[i8] = iArr[i5];
                    iArr[i5] = i10;
                    float[] fArr3 = fArr[i8];
                    fArr[i8] = fArr[i5];
                    fArr[i5] = fArr3;
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
    public static class CustomVarSet extends TimeCycleSplineSet {
        KeyFrameArray.CustomVar GetContactSyncConfig;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda2;
        KeyFrameArray.FloatArray initRecordTimeStamp;

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void PlaceComponentResult(int i) {
            int i2 = this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2;
            KeyFrameArray.CustomVar customVar = this.GetContactSyncConfig;
            int i3 = customVar.getAuthRequestContext[customVar.BuiltInFictitiousFunctionClassFactory[0]].BuiltInFictitiousFunctionClassFactory != 902 ? 1 : 4;
            double[] dArr = new double[i2];
            int i4 = i3 + 2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[i4];
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new float[i3];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i2, i4);
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory[i5];
                KeyFrameArray.CustomVar customVar2 = this.GetContactSyncConfig;
                CustomVariable customVariable = customVar2.getAuthRequestContext[customVar2.BuiltInFictitiousFunctionClassFactory[i5]];
                KeyFrameArray.FloatArray floatArray = this.initRecordTimeStamp;
                float[] fArr = floatArray.getAuthRequestContext[floatArray.BuiltInFictitiousFunctionClassFactory[i5]];
                double d = i6;
                Double.isNaN(d);
                dArr[i5] = d * 0.01d;
                customVariable.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                int i7 = 0;
                while (true) {
                    if (i7 < this.NetworkUserEntityData$$ExternalSyntheticLambda1.length) {
                        dArr2[i5][i7] = r8[i7];
                        i7++;
                    }
                }
                double[] dArr3 = dArr2[i5];
                dArr3[i3] = fArr[0];
                dArr3[i3 + 1] = fArr[1];
            }
            this.lookAheadTest = CurveFit.PlaceComponentResult(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void MyBillsEntityDataFactory(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }
    }
}
