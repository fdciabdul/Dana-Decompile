package org.yaml.snakeyaml.introspector;

/* loaded from: classes6.dex */
public abstract class Property implements Comparable<Property> {
    private final Class<?> KClassImpl$Data$declaredNonStaticMembers$2;
    private final String PlaceComponentResult;

    public abstract Class<?>[] BuiltInFictitiousFunctionClassFactory();

    public boolean MyBillsEntityDataFactory() {
        return true;
    }

    public abstract void PlaceComponentResult(Object obj, Object obj2) throws Exception;

    public boolean PlaceComponentResult() {
        return true;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Property property) {
        return getAuthRequestContext().compareTo(property.getAuthRequestContext());
    }

    public Property(String str, Class<?> cls) {
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cls;
    }

    public Class<?> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public String getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getAuthRequestContext());
        sb.append(" of ");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2());
        return sb.toString();
    }

    public int hashCode() {
        return getAuthRequestContext().hashCode() + KClassImpl$Data$declaredNonStaticMembers$2().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Property) {
            Property property = (Property) obj;
            return getAuthRequestContext().equals(property.getAuthRequestContext()) && KClassImpl$Data$declaredNonStaticMembers$2().equals(property.KClassImpl$Data$declaredNonStaticMembers$2());
        }
        return false;
    }
}
