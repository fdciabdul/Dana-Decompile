package Catalano.Statistics.Kernels;

/* loaded from: classes6.dex */
public class Spline implements IMercerKernel<double[]> {
    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = 1.0d;
        for (int i = 0; i < dArr.length; i++) {
            double min = Math.min(dArr[i], dArr2[i]);
            double d2 = dArr[i];
            double d3 = dArr2[i];
            double d4 = d2 * d3;
            d *= (((d4 + 1.0d) + (d4 * min)) - ((((d2 + d3) / 2.0d) * min) * min)) + (((min * min) * min) / 3.0d);
        }
        return d;
    }
}
