package androidx.work.impl.model;

/* loaded from: classes3.dex */
public class SystemIdInfo {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    public SystemIdInfo(String str, int i) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SystemIdInfo) {
            SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != systemIdInfo.KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            return this.BuiltInFictitiousFunctionClassFactory.equals(systemIdInfo.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public int hashCode() {
        return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
