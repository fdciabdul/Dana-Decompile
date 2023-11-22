package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class HistogramIntersection implements IMercerKernel<double[]> {
    private double alpha;
    private double beta;

    public HistogramIntersection(double d, double d2) {
        this.alpha = d;
        this.beta = d2;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d += Math.min(Math.pow(Math.abs(dArr[i]), this.alpha), Math.pow(Math.abs(dArr2[i]), this.beta));
        }
        return d;
    }
}
