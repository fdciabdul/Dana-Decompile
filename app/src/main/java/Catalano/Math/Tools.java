package Catalano.Math;

import Catalano.Math.Random.Random;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public final class Tools {
    private static Random PlaceComponentResult = new Random();

    private Tools() {
    }

    public static double PlaceComponentResult(double d, double d2) {
        double pow = Math.pow(d, d2);
        return pow <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : pow;
    }

    public static double getAuthRequestContext(double d, double d2) {
        double abs = Math.abs(d);
        double abs2 = Math.abs(d2);
        if (abs > abs2) {
            double d3 = d2 / d;
            return abs * Math.sqrt((d3 * d3) + 1.0d);
        } else if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d4 = d / d2;
            return abs2 * Math.sqrt((d4 * d4) + 1.0d);
        } else {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }
}
