package Catalano.Math.Distances;

/* loaded from: classes6.dex */
public class EuclideanDistance implements IDistance<double[]> {
    @Override // Catalano.Math.Distances.IDistance, Catalano.Math.Distances.IDivergence
    public double Compute(double[] dArr, double[] dArr2) {
        double sqrt;
        sqrt = Math.sqrt(Distance.newProxyInstance(dArr, dArr2));
        return sqrt;
    }
}
