package zipkin2.storage;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes9.dex */
public final class QueryRequest {
    final int BuiltInFictitiousFunctionClassFactory;
    final Long KClassImpl$Data$declaredNonStaticMembers$2;
    final long MyBillsEntityDataFactory;
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Map<String, String> PlaceComponentResult;
    final long getAuthRequestContext;
    final Long getErrorConfigVersion;
    final String moveToNextValue;
    final String scheduleImpl;

    /* loaded from: classes9.dex */
    public static final class Builder {
        Map<String, String> BuiltInFictitiousFunctionClassFactory = Collections.emptyMap();

        Builder() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0130, code lost:
    
        if (r8.durationAsLong() <= r12.KClassImpl$Data$declaredNonStaticMembers$2.longValue()) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0143, code lost:
    
        if (r8.durationAsLong() >= r12.getErrorConfigVersion.longValue()) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0145, code lost:
    
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean MyBillsEntityDataFactory(java.util.List<zipkin2.Span> r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.storage.QueryRequest.MyBillsEntityDataFactory(java.util.List):boolean");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryRequest{");
        sb.append("endTs=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", ");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append("lookback=");
        sb2.append(this.getAuthRequestContext);
        sb2.append(", ");
        String obj2 = sb2.toString();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj2);
            sb3.append("serviceName=");
            sb3.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb3.append(", ");
            obj2 = sb3.toString();
        }
        if (this.scheduleImpl != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj2);
            sb4.append("remoteServiceName=");
            sb4.append(this.scheduleImpl);
            sb4.append(", ");
            obj2 = sb4.toString();
        }
        if (this.moveToNextValue != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(obj2);
            sb5.append("spanName=");
            sb5.append(this.moveToNextValue);
            sb5.append(", ");
            obj2 = sb5.toString();
        }
        if (!this.PlaceComponentResult.isEmpty()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(obj2);
            sb6.append("annotationQuery=");
            sb6.append(this.PlaceComponentResult);
            sb6.append(", ");
            obj2 = sb6.toString();
        }
        if (this.getErrorConfigVersion != null) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(obj2);
            sb7.append("minDuration=");
            sb7.append(this.getErrorConfigVersion);
            sb7.append(", ");
            obj2 = sb7.toString();
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(obj2);
            sb8.append("maxDuration=");
            sb8.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb8.append(", ");
            obj2 = sb8.toString();
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append(obj2);
        sb9.append("limit=");
        sb9.append(this.BuiltInFictitiousFunctionClassFactory);
        sb9.append("}");
        return sb9.toString();
    }
}
