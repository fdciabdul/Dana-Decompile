package androidx.room.util;

/* loaded from: classes6.dex */
public final class ViewInfo {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String PlaceComponentResult;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ViewInfo) {
            ViewInfo viewInfo = (ViewInfo) obj;
            String str = this.PlaceComponentResult;
            if (str == null ? viewInfo.PlaceComponentResult == null : str.equals(viewInfo.PlaceComponentResult)) {
                String str2 = this.BuiltInFictitiousFunctionClassFactory;
                if (str2 != null) {
                    if (str2.equals(viewInfo.BuiltInFictitiousFunctionClassFactory)) {
                        return true;
                    }
                } else if (viewInfo.BuiltInFictitiousFunctionClassFactory == null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewInfo{name='");
        sb.append(this.PlaceComponentResult);
        sb.append('\'');
        sb.append(", sql='");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
