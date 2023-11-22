package zipkin2.v1;

import zipkin2.Endpoint;
import zipkin2.internal.Nullable;

@Deprecated
/* loaded from: classes6.dex */
public final class V1Annotation implements Comparable<V1Annotation> {
    public final Endpoint KClassImpl$Data$declaredNonStaticMembers$2;
    public final String PlaceComponentResult;
    public final long getAuthRequestContext;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(V1Annotation v1Annotation) {
        V1Annotation v1Annotation2 = v1Annotation;
        int i = 0;
        if (this == v1Annotation2) {
            return 0;
        }
        long j = this.getAuthRequestContext;
        long j2 = v1Annotation2.getAuthRequestContext;
        if (j < j2) {
            i = -1;
        } else if (j != j2) {
            i = 1;
        }
        return i != 0 ? i : this.PlaceComponentResult.compareTo(v1Annotation2.PlaceComponentResult);
    }

    public static V1Annotation getAuthRequestContext(long j, String str, @Nullable Endpoint endpoint) {
        return new V1Annotation(j, str, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V1Annotation(long j, String str, @Nullable Endpoint endpoint) {
        this.getAuthRequestContext = j;
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = endpoint;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof V1Annotation) {
            V1Annotation v1Annotation = (V1Annotation) obj;
            if (this.getAuthRequestContext == v1Annotation.getAuthRequestContext && this.PlaceComponentResult.equals(v1Annotation.PlaceComponentResult)) {
                Endpoint endpoint = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Endpoint endpoint2 = v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2;
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
        long j = this.getAuthRequestContext;
        int i = (int) ((j ^ (j >>> 32)) ^ 1000003);
        int hashCode = this.PlaceComponentResult.hashCode();
        Endpoint endpoint = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return ((hashCode ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ (endpoint == null ? 0 : endpoint.hashCode());
    }
}
