package Catalano.Statistics.Kernels;

/* loaded from: classes6.dex */
public class NormalizedPolynomial implements IMercerKernel<double[]> {
    private double constant;
    private int degree;

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int i) {
        this.degree = Math.max(1, i);
    }

    public double getConstant() {
        return this.constant;
    }

    public void setConstant(double d) {
        this.constant = d;
    }

    public NormalizedPolynomial() {
        this(2);
    }

    public NormalizedPolynomial(int i) {
        this(i, 1.0d);
    }

    public NormalizedPolynomial(int i, double d) {
        setDegree(i);
        this.constant = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = this.constant;
        double d2 = d;
        double d3 = d2;
        for (int i = 0; i < dArr.length; i++) {
            double d4 = dArr[i];
            double d5 = dArr2[i];
            d += d4 * d5;
            d2 += d4 * d4;
            d3 += d5 * d5;
        }
        return Math.pow(d / (d2 + d3), this.degree);
    }
}
