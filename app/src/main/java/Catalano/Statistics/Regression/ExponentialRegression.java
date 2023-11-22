package Catalano.Statistics.Regression;

/* loaded from: classes6.dex */
public class ExponentialRegression implements ISimpleRegression, ILinear {
    private double BuiltInFictitiousFunctionClassFactory;
    private double PlaceComponentResult;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("y = ");
        sb.append(String.format("%.4f", Double.valueOf(this.BuiltInFictitiousFunctionClassFactory)));
        sb.append("exp(");
        sb.append(String.format("%.4f", Double.valueOf(this.PlaceComponentResult)));
        sb.append("x)");
        return sb.toString();
    }
}
