package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Wave implements IMercerKernel<double[]> {
    private double sigma;

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double d) {
        this.sigma = d;
    }

    public Wave(double d) {
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
        return (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || sqrt == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (d3 / sqrt) * Math.sin(sqrt / d3);
    }
}
