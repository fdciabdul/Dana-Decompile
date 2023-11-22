package zipkin2.storage;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.internal.FilterTraces;

/* loaded from: classes9.dex */
public final class StrictTraceId {

    /* loaded from: classes9.dex */
    static final class FilterTracesIfClashOnLowerTraceId implements Call.Mapper<List<List<Span>>, List<List<Span>>> {
        final QueryRequest BuiltInFictitiousFunctionClassFactory;

        @Override // zipkin2.Call.Mapper
        public final /* synthetic */ List<List<Span>> map(List<List<Span>> list) {
            List<List<Span>> list2 = list;
            return StrictTraceId.KClassImpl$Data$declaredNonStaticMembers$2(list2) ? FilterTraces.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory).map(list2) : list2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FilterTracesIfClashOnLowerTraceId{request=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("}");
            return sb.toString();
        }
    }

    static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<List<Span>> list) {
        int size = list.size();
        if (size <= 1) {
            return false;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < size; i++) {
            String traceId = list.get(i).get(0).traceId();
            if (traceId.length() != 16) {
                traceId = traceId.substring(16);
            }
            if (!linkedHashSet.add(traceId)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        return str.length() != 16 ? str.substring(16) : str;
    }

    /* loaded from: classes9.dex */
    static final class FilterSpans implements Call.Mapper<List<Span>, List<Span>> {
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // zipkin2.Call.Mapper
        public final /* synthetic */ List<Span> map(List<Span> list) {
            List<Span> list2 = list;
            Iterator<Span> it = list2.iterator();
            while (it.hasNext()) {
                if (!it.next().traceId().equals(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    it.remove();
                }
            }
            return list2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FilterSpans{traceId=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    static final class FilterTracesByIds implements Call.Mapper<List<List<Span>>, List<List<Span>>> {
        final Set<String> PlaceComponentResult;

        @Override // zipkin2.Call.Mapper
        public final /* synthetic */ List<List<Span>> map(List<List<Span>> list) {
            List<List<Span>> list2 = list;
            Iterator<List<Span>> it = list2.iterator();
            while (it.hasNext()) {
                if (!this.PlaceComponentResult.contains(it.next().get(0).traceId())) {
                    it.remove();
                }
            }
            return list2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FilterTracesByIds{traceIds=");
            sb.append(this.PlaceComponentResult);
            sb.append("}");
            return sb.toString();
        }
    }

    StrictTraceId() {
    }
}
