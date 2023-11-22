package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class TStudent implements IMercerKernel<double[]> {
    private int degree;

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int i) {
        this.degree = i;
    }

    public TStudent() {
    }

    public TStudent(int i) {
        this.degree = i;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        return 1.0d / (Math.pow(Math.sqrt(d), this.degree) + 1.0d);
    }
}
