package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class InverseMultiquadric implements IMercerKernel<double[]> {
    private double constant;

    public double getConstant() {
        return this.constant;
    }

    public void setConstant(double d) {
        this.constant = d;
    }

    public InverseMultiquadric() {
        this(1.0d);
    }

    public InverseMultiquadric(double d) {
        this.constant = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        double d3 = this.constant;
        return 1.0d / (d + (d3 * d3));
    }
}
