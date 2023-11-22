package Catalano.Statistics.Regression;

/* loaded from: classes6.dex */
public class PowerRegression implements ISimpleRegression, ILinear {
    private double BuiltInFictitiousFunctionClassFactory;
    private double PlaceComponentResult;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("y = ");
        sb.append(String.format("%.4f", Double.valueOf(this.PlaceComponentResult)));
        sb.append("x^");
        sb.append(String.format("%.4f", Double.valueOf(this.BuiltInFictitiousFunctionClassFactory)));
        return sb.toString();
    }
}
