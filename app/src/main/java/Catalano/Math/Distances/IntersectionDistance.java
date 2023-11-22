package Catalano.Math.Distances;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class IntersectionDistance implements IDistance<double[]> {
    @Override // Catalano.Math.Distances.IDistance, Catalano.Math.Distances.IDivergence
    public double Compute(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d += Math.min(dArr[i], dArr2[i]);
        }
        return d;
    }
}
