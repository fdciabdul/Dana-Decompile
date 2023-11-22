package Catalano.Math.Distances;

/* loaded from: classes6.dex */
public class CorrelationDistance implements IDistance<double[]> {
    @Override // Catalano.Math.Distances.IDistance, Catalano.Math.Distances.IDivergence
    public double Compute(double[] dArr, double[] dArr2) {
        return Distance.moveToNextValue(dArr, dArr2);
    }
}
