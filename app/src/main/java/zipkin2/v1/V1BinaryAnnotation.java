package zipkin2.v1;

import zipkin2.Endpoint;

@Deprecated
/* loaded from: classes6.dex */
public final class V1BinaryAnnotation implements Comparable<V1BinaryAnnotation> {
    public final String BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    public final Endpoint PlaceComponentResult;
    public final String getAuthRequestContext;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(V1BinaryAnnotation v1BinaryAnnotation) {
        V1BinaryAnnotation v1BinaryAnnotation2 = v1BinaryAnnotation;
        if (this == v1BinaryAnnotation2) {
            return 0;
        }
        return this.BuiltInFictitiousFunctionClassFactory.compareTo(v1BinaryAnnotation2.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V1BinaryAnnotation(String str, String str2, Endpoint endpoint) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2 != null ? 6 : 0;
        this.PlaceComponentResult = endpoint;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof V1BinaryAnnotation) {
            V1BinaryAnnotation v1BinaryAnnotation = (V1BinaryAnnotation) obj;
            if (this.BuiltInFictitiousFunctionClassFactory.equals(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory) && ((str = this.getAuthRequestContext) != null ? str.equals(v1BinaryAnnotation.getAuthRequestContext) : v1BinaryAnnotation.getAuthRequestContext == null)) {
                Endpoint endpoint = this.PlaceComponentResult;
                Endpoint endpoint2 = v1BinaryAnnotation.PlaceComponentResult;
                if (endpoint == null) {
                    if (endpoint2 == null) {
                        return true;
                    }
                } else if (endpoint.equals(endpoint2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        String str = this.getAuthRequestContext;
        int hashCode2 = str == null ? 0 : str.hashCode();
        Endpoint endpoint = this.PlaceComponentResult;
        return ((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ (endpoint != null ? endpoint.hashCode() : 0);
    }
}
