package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Log implements IMercerKernel<double[]> {
    private double degree;

    public double getDegree() {
        return this.degree;
    }

    public void setDegree(double d) {
        this.degree = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        return -Math.log(Math.pow(d, this.degree / 2.0d) + 1.0d);
    }
}
