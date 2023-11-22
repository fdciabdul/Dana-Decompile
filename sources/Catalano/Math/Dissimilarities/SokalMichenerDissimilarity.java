package Catalano.Math.Dissimilarities;

/* loaded from: classes6.dex */
public class SokalMichenerDissimilarity implements IDissimilarity<int[]> {
    @Override // Catalano.Math.Dissimilarities.IDissimilarity, Catalano.Math.Distances.IDivergence
    public double Compute(int[] iArr, int[] iArr2) {
        return Dissimilarity.lookAheadTest(iArr, iArr2);
    }
}
