package androidx.work.impl.model;

/* loaded from: classes3.dex */
public class Preference {
    public String BuiltInFictitiousFunctionClassFactory;
    public Long MyBillsEntityDataFactory;

    public Preference(String str) {
        this(str, 0L);
    }

    public Preference(String str, long j) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Preference) {
            Preference preference = (Preference) obj;
            if (this.BuiltInFictitiousFunctionClassFactory.equals(preference.BuiltInFictitiousFunctionClassFactory)) {
                Long l = this.MyBillsEntityDataFactory;
                Long l2 = preference.MyBillsEntityDataFactory;
                return l != null ? l.equals(l2) : l2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        Long l = this.MyBillsEntityDataFactory;
        return (hashCode * 31) + (l != null ? l.hashCode() : 0);
    }
}
