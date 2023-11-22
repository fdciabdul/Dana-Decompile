package zipkin2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.storage.SpanStore;
import zipkin2.storage.Traces;

/* loaded from: classes9.dex */
public final class TracesAdapter implements Traces {
    final SpanStore PlaceComponentResult;

    /* loaded from: classes9.dex */
    enum ToListOfTraces implements Call.Mapper<List<Span>, List<List<Span>>> {
        INSTANCE;

        @Override // java.lang.Enum
        public final String toString() {
            return "ToListOfTraces()";
        }

        @Override // zipkin2.Call.Mapper
        public final List<List<Span>> map(List<Span> list) {
            return list.isEmpty() ? Collections.emptyList() : Collections.singletonList(list);
        }
    }

    /* loaded from: classes9.dex */
    static final class ScatterGather extends AggregateCall<List<Span>, List<List<Span>>> {
        @Override // zipkin2.internal.AggregateCall
        protected final /* synthetic */ void getAuthRequestContext(List<Span> list, List<List<Span>> list2) {
            List<Span> list3 = list;
            List<List<Span>> list4 = list2;
            if (list3.isEmpty()) {
                return;
            }
            list4.add(list3);
        }

        private ScatterGather(List<Call<List<Span>>> list) {
            super(list);
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new ScatterGather(BuiltInFictitiousFunctionClassFactory());
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final /* synthetic */ Call clone() {
            return new ScatterGather(BuiltInFictitiousFunctionClassFactory());
        }

        @Override // zipkin2.internal.AggregateCall
        protected final /* synthetic */ List<List<Span>> scheduleImpl() {
            return new ArrayList();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TracesAdapter{");
        sb.append(this.PlaceComponentResult);
        sb.append("}");
        return sb.toString();
    }
}
