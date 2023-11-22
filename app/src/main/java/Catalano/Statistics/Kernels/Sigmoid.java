package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Sigmoid implements IMercerKernel<double[]> {
    private double alpha;
    private double constant;

    public void setConstant(double d) {
    }

    public Sigmoid() {
        this(0.01d, -2.718281828459045d);
    }

    public Sigmoid(double d, double d2) {
        this.alpha = d;
        this.constant = d2;
    }

    public double getConstant() {
        return this.constant;
    }

    public double getAlpha() {
        return this.alpha;
    }

    public void setAlpha(double d) {
        this.alpha = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d += dArr[i] * dArr2[i];
        }
        return Math.tanh((this.alpha * d) + this.constant);
    }
}
