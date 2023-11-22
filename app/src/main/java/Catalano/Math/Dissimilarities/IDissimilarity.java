package Catalano.Math.Dissimilarities;

import Catalano.Math.Distances.IDivergence;

/* loaded from: classes6.dex */
public interface IDissimilarity<T> extends IDivergence<T> {
    @Override // Catalano.Math.Distances.IDivergence
    double Compute(T t, T t2);
}
