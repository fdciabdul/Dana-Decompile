package zipkin2.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import zipkin2.Call;
import zipkin2.Span;

/* loaded from: classes9.dex */
public final class GroupByTraceId implements Call.Mapper<List<Span>, List<List<Span>>> {
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // zipkin2.Call.Mapper
    public final /* synthetic */ List<List<Span>> map(List<Span> list) {
        List<Span> list2 = list;
        if (list2.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Span span : list2) {
            String traceId = span.traceId();
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                traceId = StrictTraceId.BuiltInFictitiousFunctionClassFactory(traceId);
            }
            if (!linkedHashMap.containsKey(traceId)) {
                linkedHashMap.put(traceId, new ArrayList());
            }
            ((List) linkedHashMap.get(traceId)).add(span);
        }
        return new ArrayList(linkedHashMap.values());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupByTraceId{strictTraceId=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("}");
        return sb.toString();
    }
}
