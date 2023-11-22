package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Hellinger implements IMercerKernel<double[]> {
    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d += Math.sqrt(dArr[i] * dArr2[i]);
        }
        return d;
    }
}
