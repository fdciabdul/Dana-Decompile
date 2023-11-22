package Catalano.Statistics.Kernels;

/* loaded from: classes6.dex */
public class Dirichlet implements IMercerKernel<double[]> {
    private int dimension;

    public int getDimension() {
        return this.dimension;
    }

    public void setDimension(int i) {
        this.dimension = i;
    }

    public Dirichlet(int i) {
        this.dimension = i;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = 1.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            double d3 = this.dimension;
            Double.isNaN(d3);
            d *= Math.sin((d3 + 0.5d) * d2) / (Math.sin(d2 / 2.0d) * 2.0d);
        }
        return d;
    }
}
