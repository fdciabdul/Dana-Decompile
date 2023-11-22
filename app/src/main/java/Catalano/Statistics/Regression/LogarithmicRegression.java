package Catalano.Statistics.Regression;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class LogarithmicRegression implements ISimpleRegression, ILinear {
    private double KClassImpl$Data$declaredNonStaticMembers$2;
    private double getAuthRequestContext;

    public String toString() {
        if (this.getAuthRequestContext > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("y = ");
            sb.append(String.format("%.4f", Double.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2)));
            sb.append("ln(x) + ");
            sb.append(this.getAuthRequestContext);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("y = ");
        sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb2.append("ln(x) ");
        sb2.append(this.getAuthRequestContext);
        return sb2.toString();
    }
}
