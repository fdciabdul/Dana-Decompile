package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Bessel implements IMercerKernel<double[]> {
    private int order;
    private double sigma;

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double d) {
        this.sigma = d;
    }

    public Bessel(int i, double d) {
        this.order = i;
        this.sigma = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double sqrt = Math.sqrt(d);
        double PlaceComponentResult = Catalano.Math.Functions.Bessel.PlaceComponentResult(this.order, this.sigma * sqrt);
        double d3 = this.order;
        Double.isNaN(d3);
        return PlaceComponentResult / Math.pow(sqrt, (-sqrt) * d3);
    }
}
