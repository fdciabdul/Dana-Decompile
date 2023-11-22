package Catalano.Statistics.Kernels;

/* loaded from: classes6.dex */
public class Polynomial implements IMercerKernel<double[]> {
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

    public Polynomial() {
        this(2);
    }

    public Polynomial(int i) {
        this(i, 1.0d);
    }

    public Polynomial(int i, double d) {
        setDegree(i);
        this.constant = d;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = this.constant;
        for (int i = 0; i < dArr.length; i++) {
            d += dArr[i] * dArr2[i];
        }
        return Math.pow(d, this.degree);
    }
}
