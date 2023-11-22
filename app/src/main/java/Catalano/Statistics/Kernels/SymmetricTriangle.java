package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class SymmetricTriangle implements IMercerKernel<double[]> {
    private double gamma;

    public double getGamma() {
        return this.gamma;
    }

    public void setGamma(double d) {
        this.gamma = d;
    }

    public SymmetricTriangle() {
    }

    public SymmetricTriangle(double d) {
        this.gamma = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double sqrt = 1.0d - (this.gamma * Math.sqrt(d));
        return sqrt > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? sqrt : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
