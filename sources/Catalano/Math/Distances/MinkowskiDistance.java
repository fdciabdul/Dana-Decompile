package Catalano.Math.Distances;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class MinkowskiDistance implements IDistance<double[]> {
    private double p = 1.0d;

    public double getOrder() {
        return this.p;
    }

    public void setOrder(double d) {
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("P must be different from 0.");
        }
        this.p = d;
    }

    public MinkowskiDistance() {
    }

    public MinkowskiDistance(double d) {
        setOrder(d);
    }

    @Override // Catalano.Math.Distances.IDistance, Catalano.Math.Distances.IDivergence
    public double Compute(double[] dArr, double[] dArr2) {
        return Distance.PlaceComponentResult(dArr, dArr2, this.p);
    }
}
