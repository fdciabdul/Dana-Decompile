package Catalano.Core;

/* loaded from: classes6.dex */
public class FloatPoint {
    public float BuiltInFictitiousFunctionClassFactory;
    public float MyBillsEntityDataFactory;

    public boolean equals(Object obj) {
        if (obj.getClass().isAssignableFrom(DoublePoint.class)) {
            FloatPoint floatPoint = (FloatPoint) obj;
            return this.BuiltInFictitiousFunctionClassFactory == floatPoint.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == floatPoint.MyBillsEntityDataFactory;
        }
        return false;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory) + 623) * 89) + Float.floatToIntBits(this.MyBillsEntityDataFactory);
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
