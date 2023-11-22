package Catalano.Statistics.Regression;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class LinearRegression implements ISimpleRegression, ILinear {
    private double BuiltInFictitiousFunctionClassFactory;
    private double PlaceComponentResult;

    public String toString() {
        if (this.BuiltInFictitiousFunctionClassFactory >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("y = ");
            sb.append(String.format("%.4f", Double.valueOf(this.PlaceComponentResult)));
            sb.append("x + ");
            sb.append(String.format("%.4f", Double.valueOf(this.BuiltInFictitiousFunctionClassFactory)));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("y = ");
        sb2.append(String.format("%.4f", Double.valueOf(this.PlaceComponentResult)));
        sb2.append("x ");
        sb2.append(String.format("%.4f", Double.valueOf(this.BuiltInFictitiousFunctionClassFactory)));
        return sb2.toString();
    }
}
