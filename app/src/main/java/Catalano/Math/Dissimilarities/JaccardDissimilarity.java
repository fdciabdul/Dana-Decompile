package Catalano.Math.Dissimilarities;

/* loaded from: classes6.dex */
public class JaccardDissimilarity implements IDissimilarity<int[]> {
    @Override // Catalano.Math.Dissimilarities.IDissimilarity, Catalano.Math.Distances.IDivergence
    public double Compute(int[] iArr, int[] iArr2) {
        return Dissimilarity.MyBillsEntityDataFactory(iArr, iArr2);
    }
}
