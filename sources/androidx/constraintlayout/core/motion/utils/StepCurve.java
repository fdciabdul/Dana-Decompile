package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class StepCurve extends Easing {
    MonotonicCurveFit MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepCurve(String str) {
        this.getAuthRequestContext = str;
        double[] dArr = new double[this.getAuthRequestContext.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        double[] copyOf = Arrays.copyOf(dArr, i + 1);
        int length = (copyOf.length * 3) - 2;
        int length2 = copyOf.length - 1;
        double d = length2;
        Double.isNaN(d);
        double d2 = 1.0d / d;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i2 = 0; i2 < copyOf.length; i2++) {
            double d3 = copyOf[i2];
            int i3 = i2 + length2;
            dArr2[i3][0] = d3;
            double d4 = i2;
            Double.isNaN(d4);
            double d5 = d4 * d2;
            dArr3[i3] = d5;
            if (i2 > 0) {
                int i4 = (length2 * 2) + i2;
                dArr2[i4][0] = d3 + 1.0d;
                dArr3[i4] = d5 + 1.0d;
                int i5 = i2 - 1;
                dArr2[i5][0] = (d3 - 1.0d) - d2;
                dArr3[i5] = (d5 - 1.0d) - d2;
            }
        }
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr3, dArr2);
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(" 0 ");
        sb.append(monotonicCurveFit.getAuthRequestContext(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        printStream.println(sb.toString());
        PrintStream printStream2 = System.out;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" 1 ");
        sb2.append(monotonicCurveFit.getAuthRequestContext(1.0d));
        printStream2.println(sb2.toString());
        this.MyBillsEntityDataFactory = monotonicCurveFit;
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double BuiltInFictitiousFunctionClassFactory(double d) {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double getAuthRequestContext(double d) {
        return this.MyBillsEntityDataFactory.getAuthRequestContext(d);
    }
}
