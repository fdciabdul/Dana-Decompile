package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class ThinPlateSpline implements IMercerKernel<double[]> {
    private double sigma = 1.0d;

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double d) {
        this.sigma = Math.max(1.0d, d);
    }

    public ThinPlateSpline() {
    }

    public ThinPlateSpline(double d) {
        setSigma(d);
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double d3 = this.sigma;
        return (d / (d3 * d3)) * Math.log(Math.sqrt(d) / this.sigma);
    }
}
