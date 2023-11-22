package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Gaussian implements IMercerKernel<double[]> {
    private double gamma;

    public double getGamma() {
        return this.gamma;
    }

    public void setGamma(double d) {
        this.gamma = d / 100.0d;
    }

    public Gaussian() {
        this(1.0d);
    }

    public Gaussian(double d) {
        setGamma(d);
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
        return Math.exp((-this.gamma) * d);
    }
}
