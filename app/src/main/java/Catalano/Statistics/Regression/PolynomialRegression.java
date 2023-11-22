package Catalano.Statistics.Regression;

/* loaded from: classes6.dex */
public class PolynomialRegression implements ISimpleRegression {
    private double[][] getAuthRequestContext;

    public String toString() {
        int length = this.getAuthRequestContext.length - 1;
        String str = "y = ";
        for (int i = 0; i < this.getAuthRequestContext.length; i++) {
            if (length != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(String.format("%.4f", Double.valueOf(this.getAuthRequestContext[length][0])));
                sb.append("x^");
                sb.append(length);
                sb.append(" ");
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(String.format("%.4f", Double.valueOf(this.getAuthRequestContext[length][0])));
                str = sb2.toString();
            }
            length--;
        }
        return str;
    }
}
