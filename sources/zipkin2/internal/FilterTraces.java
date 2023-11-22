package zipkin2.internal;

import java.util.ArrayList;
import java.util.List;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.storage.QueryRequest;

/* loaded from: classes9.dex */
public final class FilterTraces implements Call.Mapper<List<List<Span>>, List<List<Span>>> {
    final QueryRequest getAuthRequestContext;

    @Override // zipkin2.Call.Mapper
    public final /* synthetic */ List<List<Span>> map(List<List<Span>> list) {
        List<List<Span>> list2 = list;
        int size = list2.size();
        if (size == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            List<Span> list3 = list2.get(i);
            if (this.getAuthRequestContext.MyBillsEntityDataFactory(list3)) {
                arrayList.add(list3);
            }
        }
        return arrayList;
    }

    public static Call.Mapper<List<List<Span>>, List<List<Span>>> MyBillsEntityDataFactory(QueryRequest queryRequest) {
        return new FilterTraces(queryRequest);
    }

    private FilterTraces(QueryRequest queryRequest) {
        this.getAuthRequestContext = queryRequest;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FilterTraces{request=");
        sb.append(this.getAuthRequestContext);
        sb.append("}");
        return sb.toString();
    }
}
