package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class KeyCycleOscillator {
    public CycleOscillator BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public CurveFit getAuthRequestContext;
    public int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public String getErrorConfigVersion = null;
    public int MyBillsEntityDataFactory = 0;
    public ArrayList<WavePoint> PlaceComponentResult = new ArrayList<>();

    /* loaded from: classes6.dex */
    static class CoreSpline extends KeyCycleOscillator {
    }

    /* loaded from: classes6.dex */
    public static class PathRotateSet extends KeyCycleOscillator {
    }

    protected void BuiltInFictitiousFunctionClassFactory(Object obj) {
    }

    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory == 1;
    }

    /* loaded from: classes3.dex */
    public static class WavePoint {
        public float BuiltInFictitiousFunctionClassFactory;
        public float KClassImpl$Data$declaredNonStaticMembers$2;
        public float MyBillsEntityDataFactory;
        public float PlaceComponentResult;
        public int getAuthRequestContext;

        public WavePoint(int i, float f, float f2, float f3, float f4) {
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = f4;
            this.MyBillsEntityDataFactory = f2;
            this.BuiltInFictitiousFunctionClassFactory = f;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f3;
        }
    }

    public String toString() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("[");
            sb.append(next.getAuthRequestContext);
            sb.append(" , ");
            sb.append(decimalFormat.format(next.PlaceComponentResult));
            sb.append("] ");
            str = sb.toString();
        }
        return str;
    }

    public final float PlaceComponentResult(float f) {
        CycleOscillator cycleOscillator = this.BuiltInFictitiousFunctionClassFactory;
        CurveFit curveFit = cycleOscillator.MyBillsEntityDataFactory;
        if (curveFit != null) {
            curveFit.getAuthRequestContext(f, cycleOscillator.moveToNextValue);
        } else {
            double[] dArr = cycleOscillator.moveToNextValue;
            dArr[0] = cycleOscillator.BuiltInFictitiousFunctionClassFactory[0];
            dArr[1] = cycleOscillator.getErrorConfigVersion[0];
            dArr[2] = cycleOscillator.NetworkUserEntityData$$ExternalSyntheticLambda1[0];
        }
        double[] dArr2 = cycleOscillator.moveToNextValue;
        return (float) (dArr2[0] + (cycleOscillator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(f, dArr2[1]) * cycleOscillator.moveToNextValue[2]));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final float MyBillsEntityDataFactory(float f) {
        double d;
        double d2;
        CycleOscillator cycleOscillator = this.BuiltInFictitiousFunctionClassFactory;
        CurveFit curveFit = cycleOscillator.MyBillsEntityDataFactory;
        if (curveFit != null) {
            double d3 = f;
            curveFit.PlaceComponentResult(d3, cycleOscillator.NetworkUserEntityData$$ExternalSyntheticLambda0);
            cycleOscillator.MyBillsEntityDataFactory.getAuthRequestContext(d3, cycleOscillator.moveToNextValue);
        } else {
            double[] dArr = cycleOscillator.NetworkUserEntityData$$ExternalSyntheticLambda0;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d4 = f;
        double KClassImpl$Data$declaredNonStaticMembers$2 = cycleOscillator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(d4, cycleOscillator.moveToNextValue[1]);
        Oscillator oscillator = cycleOscillator.PlaceComponentResult;
        double d5 = cycleOscillator.moveToNextValue[1];
        double d6 = cycleOscillator.NetworkUserEntityData$$ExternalSyntheticLambda0[1];
        double BuiltInFictitiousFunctionClassFactory = d5 + oscillator.BuiltInFictitiousFunctionClassFactory(d4);
        if (d4 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d4 = 1.0E-5d;
        } else if (d4 >= 1.0d) {
            d4 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(oscillator.moveToNextValue, d4);
        if (binarySearch > 0) {
            d = 0.0d;
        } else if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = oscillator.scheduleImpl;
            float f2 = fArr[i];
            int i2 = i - 1;
            float f3 = fArr[i2];
            double d7 = f2 - f3;
            double[] dArr2 = oscillator.moveToNextValue;
            double d8 = dArr2[i];
            double d9 = dArr2[i2];
            Double.isNaN(d7);
            double d10 = d7 / (d8 - d9);
            double d11 = f3;
            Double.isNaN(d11);
            d = (d11 - (d9 * d10)) + (d4 * d10);
        } else {
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d12 = d + d6;
        double d13 = 2.0d;
        switch (oscillator.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            case 1:
                d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                break;
            case 2:
                d12 *= 4.0d;
                d13 = Math.signum((((BuiltInFictitiousFunctionClassFactory * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                d2 = d13 * d12;
                break;
            case 3:
                d2 = d13 * d12;
                break;
            case 4:
                d12 = -d12;
                d2 = d13 * d12;
                break;
            case 5:
                double d14 = oscillator.PlaceComponentResult;
                d2 = (-d14) * d12 * Math.sin(d14 * BuiltInFictitiousFunctionClassFactory);
                break;
            case 6:
                d2 = d12 * 4.0d * ((((BuiltInFictitiousFunctionClassFactory * 4.0d) + 2.0d) % 4.0d) - 2.0d);
                break;
            case 7:
                d2 = oscillator.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory % 1.0d);
                break;
            default:
                double d15 = oscillator.PlaceComponentResult;
                d12 *= d15;
                d13 = Math.cos(d15 * BuiltInFictitiousFunctionClassFactory);
                d2 = d13 * d12;
                break;
        }
        double[] dArr3 = cycleOscillator.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return (float) (dArr3[0] + (KClassImpl$Data$declaredNonStaticMembers$2 * dArr3[2]) + (d2 * cycleOscillator.moveToNextValue[2]));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, String str, int i3, float f, float f2, float f3, float f4, Object obj) {
        this.PlaceComponentResult.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.MyBillsEntityDataFactory = i3;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2;
        BuiltInFictitiousFunctionClassFactory(obj);
        this.getErrorConfigVersion = str;
    }

    /* loaded from: classes6.dex */
    static class IntDoubleSort {
        private IntDoubleSort() {
        }
    }

    /* loaded from: classes6.dex */
    static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }
    }

    /* loaded from: classes3.dex */
    public static class CycleOscillator {
        public float[] BuiltInFictitiousFunctionClassFactory;
        int DatabaseTableConfigUtil;
        private final int GetContactSyncConfig;
        public float KClassImpl$Data$declaredNonStaticMembers$2;
        public CurveFit MyBillsEntityDataFactory;
        public double[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        public float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final int NetworkUserEntityData$$ExternalSyntheticLambda2;
        public Oscillator PlaceComponentResult;
        public float[] getAuthRequestContext;
        public float[] getErrorConfigVersion;
        private final int initRecordTimeStamp;
        public double[] lookAheadTest;
        public double[] moveToNextValue;
        private final int newProxyInstance;
        float[] scheduleImpl;

        public CycleOscillator(int i, String str, int i2, int i3) {
            Oscillator oscillator = new Oscillator();
            this.PlaceComponentResult = oscillator;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            this.initRecordTimeStamp = 1;
            this.GetContactSyncConfig = 2;
            this.DatabaseTableConfigUtil = i;
            this.newProxyInstance = i2;
            oscillator.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
            oscillator.getAuthRequestContext = str;
            if (str != null) {
                oscillator.KClassImpl$Data$declaredNonStaticMembers$2 = MonotonicCurveFit.MyBillsEntityDataFactory(str);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[i3];
            this.lookAheadTest = new double[i3];
            this.getAuthRequestContext = new float[i3];
            this.BuiltInFictitiousFunctionClassFactory = new float[i3];
            this.getErrorConfigVersion = new float[i3];
            this.scheduleImpl = new float[i3];
        }
    }
}
