package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Cauchy implements IMercerKernel<double[]> {
    private double sigma;

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double d) {
        this.sigma = d;
    }

    public Cauchy() {
        this.sigma = 1.0d;
    }

    public Cauchy(double d) {
        this.sigma = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        if (dArr == dArr2) {
            return 1.0d;
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        return 1.0d / ((d / this.sigma) + 1.0d);
    }
}
