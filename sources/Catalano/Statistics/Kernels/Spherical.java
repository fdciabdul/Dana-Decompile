package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Spherical implements IMercerKernel<double[]> {
    private double sigma;

    public double getSigma() {
        return this.sigma;
    }

    public void setDegree(double d) {
        this.sigma = d;
    }

    public Spherical() {
    }

    public Spherical(double d) {
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
        return (1.0d - (1.5d * d4)) + (0.5d * d4 * d4 * d4);
    }
}
