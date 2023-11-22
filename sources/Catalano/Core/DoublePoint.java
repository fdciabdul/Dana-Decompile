package Catalano.Core;

/* loaded from: classes6.dex */
public class DoublePoint {
    public double BuiltInFictitiousFunctionClassFactory;
    public double MyBillsEntityDataFactory;

    public boolean equals(Object obj) {
        if (obj.getClass().isAssignableFrom(DoublePoint.class)) {
            DoublePoint doublePoint = (DoublePoint) obj;
            return this.BuiltInFictitiousFunctionClassFactory == doublePoint.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == doublePoint.MyBillsEntityDataFactory;
        }
        return false;
    }

    public int hashCode() {
        return ((((int) (Double.doubleToLongBits(this.BuiltInFictitiousFunctionClassFactory) ^ (Double.doubleToLongBits(this.BuiltInFictitiousFunctionClassFactory) >>> 32))) + 679) * 97) + ((int) (Double.doubleToLongBits(this.MyBillsEntityDataFactory) ^ (Double.doubleToLongBits(this.MyBillsEntityDataFactory) >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("X: ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(" Y: ");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }
}
