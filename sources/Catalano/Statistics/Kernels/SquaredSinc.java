package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class SquaredSinc implements IMercerKernel<double[]> {
    private double gamma;

    public double getGamma() {
        return this.gamma;
    }

    public void setGamma(double d) {
        this.gamma = d;
    }

    public SquaredSinc() {
    }

    public SquaredSinc(double d) {
        this.gamma = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double d3 = this.gamma;
        double sqrt = Math.sqrt(d);
        double d4 = this.gamma;
        return Math.sin(d3 * sqrt) / ((d4 * d4) * d);
    }
}
