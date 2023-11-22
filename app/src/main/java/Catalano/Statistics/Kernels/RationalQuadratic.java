package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class RationalQuadratic implements IMercerKernel<double[]> {
    private double constant;

    public double getConstant() {
        return this.constant;
    }

    public void setConstant(double d) {
        this.constant = d;
    }

    public RationalQuadratic() {
        this(1.0d);
    }

    public RationalQuadratic(double d) {
        this.constant = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        return 1.0d - (d / (d - this.constant));
    }
}
