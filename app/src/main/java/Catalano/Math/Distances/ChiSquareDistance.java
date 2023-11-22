package Catalano.Math.Distances;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class ChiSquareDistance implements IDistance<double[]> {
    @Override // Catalano.Math.Distances.IDistance, Catalano.Math.Distances.IDivergence
    public double Compute(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            double d3 = dArr2[i];
            double d4 = d2 + d3;
            if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d += Math.pow(d2 - d3, 2.0d) / d4;
            }
        }
        return d * 0.5d;
    }
}
