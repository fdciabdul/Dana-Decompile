package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Pearson implements IMercerKernel<double[]> {
    private double constant;
    private double omega;
    private double sigma;

    public double getOmega() {
        return this.omega;
    }

    public void setOmega(double d) {
        this.omega = d;
        this.constant = (Math.sqrt(Math.pow(2.0d, 1.0d / d) - 1.0d) * 2.0d) / this.sigma;
    }

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double d) {
        this.sigma = d;
        this.constant = (Math.sqrt(Math.pow(2.0d, 1.0d / this.omega) - 1.0d) * 2.0d) / d;
    }

    public Pearson() {
        this(1.0d, 1.0d);
    }

    public Pearson(double d, double d2) {
        setOmega(d);
        setSigma(d2);
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d4 = dArr[i];
            d2 += d4 * d4;
            double d5 = dArr2[i];
            d3 += d5 * d5;
            d += d4 * d5;
        }
        double sqrt = this.constant * Math.sqrt((d * (-2.0d)) + d2 + d3);
        return 1.0d / Math.pow((sqrt * sqrt) + 1.0d, this.omega);
    }
}
