package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Circular implements IMercerKernel<double[]> {
    private final double c2dPI = 0.6366197723675814d;
    private double sigma;

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double d) {
        this.sigma = d;
    }

    public Circular(double d) {
        this.sigma = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double sqrt = Math.sqrt(d);
        double d3 = this.sigma;
        if (sqrt >= d3) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d4 = sqrt / d3;
        return (Math.acos(-d4) * 0.6366197723675814d) - ((0.6366197723675814d * d4) * Math.sqrt(1.0d - (d4 * d4)));
    }
}
