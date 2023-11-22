package androidx.room.util;

import java.util.Set;

/* loaded from: classes6.dex */
public final class FtsTableInfo {
    private static final String[] PlaceComponentResult = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> BuiltInFictitiousFunctionClassFactory;
    public final String MyBillsEntityDataFactory;
    public final Set<String> getAuthRequestContext;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FtsTableInfo) {
            FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
            String str = this.MyBillsEntityDataFactory;
            if (str == null ? ftsTableInfo.MyBillsEntityDataFactory == null : str.equals(ftsTableInfo.MyBillsEntityDataFactory)) {
                Set<String> set = this.getAuthRequestContext;
                if (set == null ? ftsTableInfo.getAuthRequestContext == null : set.equals(ftsTableInfo.getAuthRequestContext)) {
                    Set<String> set2 = this.BuiltInFictitiousFunctionClassFactory;
                    Set<String> set3 = ftsTableInfo.BuiltInFictitiousFunctionClassFactory;
                    return set2 != null ? set2.equals(set3) : set3 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.MyBillsEntityDataFactory;
        int hashCode = str != null ? str.hashCode() : 0;
        Set<String> set = this.getAuthRequestContext;
        int hashCode2 = set != null ? set.hashCode() : 0;
        Set<String> set2 = this.BuiltInFictitiousFunctionClassFactory;
        return (((hashCode * 31) + hashCode2) * 31) + (set2 != null ? set2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FtsTableInfo{name='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('\'');
        sb.append(", columns=");
        sb.append(this.getAuthRequestContext);
        sb.append(", options=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('}');
        return sb.toString();
    }
}
