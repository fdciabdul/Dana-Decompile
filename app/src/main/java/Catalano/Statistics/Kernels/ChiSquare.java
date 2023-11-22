package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class ChiSquare implements IMercerKernel<double[]> {
    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            double d3 = dArr2[i];
            double d4 = d2 - d3;
            double d5 = (d2 + d3) * 0.5d;
            if (d5 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d += (d4 * d4) / d5;
            }
        }
        return 1.0d - d;
    }
}
