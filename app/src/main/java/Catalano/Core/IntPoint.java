package Catalano.Core;

/* loaded from: classes6.dex */
public class IntPoint {
    public int BuiltInFictitiousFunctionClassFactory;
    public int getAuthRequestContext;

    public boolean equals(Object obj) {
        if (obj.getClass().isAssignableFrom(IntPoint.class)) {
            IntPoint intPoint = (IntPoint) obj;
            return this.getAuthRequestContext == intPoint.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == intPoint.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public int hashCode() {
        return ((this.getAuthRequestContext + 201) * 67) + this.BuiltInFictitiousFunctionClassFactory;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("X: ");
        sb.append(this.getAuthRequestContext);
        sb.append(" Y: ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }
}
