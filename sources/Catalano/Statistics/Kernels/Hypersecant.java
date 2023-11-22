package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Hypersecant implements IMercerKernel<double[]> {
    private double gamma;

    public double getGamma() {
        return this.gamma;
    }

    public void setGamma(double d) {
        this.gamma = d;
    }

    public Hypersecant(double d) {
        this.gamma = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double sqrt = Math.sqrt(d);
        return (2.0d / Math.exp(this.gamma * sqrt)) + Math.exp((-this.gamma) * sqrt);
    }
}
