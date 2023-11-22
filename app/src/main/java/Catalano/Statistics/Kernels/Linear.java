package Catalano.Statistics.Kernels;

/* loaded from: classes6.dex */
public class Linear implements IMercerKernel<double[]> {
    private double constant;

    public Linear(double d) {
        this.constant = d;
    }

    public Linear() {
        this.constant = 1.0d;
    }

    public double getConstant() {
        return this.constant;
    }

    public void setConstant(double d) {
        this.constant = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = this.constant;
        for (int i = 0; i < dArr.length; i++) {
            d += dArr[i] * dArr2[i];
        }
        return d;
    }
}
