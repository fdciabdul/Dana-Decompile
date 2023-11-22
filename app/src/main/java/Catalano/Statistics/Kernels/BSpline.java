package Catalano.Statistics.Kernels;

import Catalano.Math.Special;

/* loaded from: classes6.dex */
public class BSpline implements IMercerKernel<double[]> {
    private int order;

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public BSpline(int i) {
        this.order = i;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        int i = this.order;
        double d = 1.0d;
        for (int i2 = 0; i2 < dArr.length; i2++) {
            d *= Special.PlaceComponentResult((i * 2) + 1, dArr[i2] - dArr2[i2]);
        }
        return d;
    }
}
