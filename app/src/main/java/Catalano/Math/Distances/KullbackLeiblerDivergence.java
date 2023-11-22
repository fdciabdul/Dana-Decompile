package Catalano.Math.Distances;

/* loaded from: classes6.dex */
public class KullbackLeiblerDivergence implements IDivergence<double[]> {
    @Override // Catalano.Math.Distances.IDivergence
    public double Compute(double[] dArr, double[] dArr2) {
        return Distance.initRecordTimeStamp(dArr, dArr2);
    }
}
