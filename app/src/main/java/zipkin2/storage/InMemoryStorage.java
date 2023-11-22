package zipkin2.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import zipkin2.Call;
import zipkin2.Callback;
import zipkin2.Span;
import zipkin2.storage.StorageComponent;

/* loaded from: classes9.dex */
public final class InMemoryStorage extends StorageComponent implements SpanStore, SpanConsumer, AutocompleteTags, ServiceAndSpanNames, Traces {
    static final Comparator<String> BuiltInFictitiousFunctionClassFactory = new Comparator<String>() { // from class: zipkin2.storage.InMemoryStorage.6
        public String toString() {
            return "String::compareTo";
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            if (str3 == null) {
                return -1;
            }
            return str3.compareTo(str4);
        }
    };
    static final Comparator<TraceIdTimestamp> getAuthRequestContext = new Comparator<TraceIdTimestamp>() { // from class: zipkin2.storage.InMemoryStorage.7
        public String toString() {
            return "TimestampDescending{}";
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(TraceIdTimestamp traceIdTimestamp, TraceIdTimestamp traceIdTimestamp2) {
            TraceIdTimestamp traceIdTimestamp3 = traceIdTimestamp;
            TraceIdTimestamp traceIdTimestamp4 = traceIdTimestamp2;
            long j = traceIdTimestamp3.PlaceComponentResult;
            long j2 = traceIdTimestamp4.PlaceComponentResult;
            int i = j < j2 ? -1 : j == j2 ? 0 : 1;
            return i != 0 ? -i : traceIdTimestamp4.KClassImpl$Data$declaredNonStaticMembers$2.compareTo(traceIdTimestamp3.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    };
    private final SortedMultimap<String, TraceIdTimestamp> DatabaseTableConfigUtil;
    final Set<String> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    private final SortedMultimap<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final SortedMultimap<TraceIdTimestamp, Span> NetworkUserEntityData$$ExternalSyntheticLambda2;
    final AtomicInteger PlaceComponentResult;
    private final SortedMultimap<String, String> getErrorConfigVersion;
    private final SortedMultimap<String, String> lookAheadTest;
    private final ServiceNameToTraceIds moveToNextValue;
    final boolean scheduleImpl;

    /* loaded from: classes9.dex */
    public static final class Builder extends StorageComponent.Builder {
        boolean BuiltInFictitiousFunctionClassFactory = true;
        boolean MyBillsEntityDataFactory = true;
        int KClassImpl$Data$declaredNonStaticMembers$2 = 500000;
        List<String> getAuthRequestContext = Collections.emptyList();
    }

    @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final String toString() {
        return "InMemoryStorage{}";
    }

    /* renamed from: zipkin2.storage.InMemoryStorage$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 extends SortedMultimap<TraceIdTimestamp, Span> {
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        final Collection<Span> MyBillsEntityDataFactory() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: zipkin2.storage.InMemoryStorage$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass2 extends SortedMultimap<String, TraceIdTimestamp> {
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        final Collection<TraceIdTimestamp> MyBillsEntityDataFactory() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: zipkin2.storage.InMemoryStorage$3  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass3 extends SortedMultimap<String, String> {
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        final Collection<String> MyBillsEntityDataFactory() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: zipkin2.storage.InMemoryStorage$4  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass4 extends SortedMultimap<String, String> {
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        final Collection<String> MyBillsEntityDataFactory() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: zipkin2.storage.InMemoryStorage$5  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass5 extends SortedMultimap<String, String> {
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        final Collection<String> MyBillsEntityDataFactory() {
            return new LinkedHashSet();
        }
    }

    final void getAuthRequestContext(List<Span> list) {
        int i;
        synchronized (this) {
            int size = list.size();
            this.PlaceComponentResult.addAndGet(size);
            for (int i2 = (this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 + size) - this.MyBillsEntityDataFactory; i2 > 0; i2 -= i) {
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory.lastKey().KClassImpl$Data$declaredNonStaticMembers$2;
                Iterator<TraceIdTimestamp> it = this.DatabaseTableConfigUtil.MyBillsEntityDataFactory(str).iterator();
                i = 0;
                while (it.hasNext()) {
                    i += this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory(it.next()).size();
                }
                if (this.scheduleImpl) {
                    ServiceNameToTraceIds serviceNameToTraceIds = this.moveToNextValue;
                    LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                    for (Map.Entry entry : serviceNameToTraceIds.MyBillsEntityDataFactory.entrySet()) {
                        Collection collection = (Collection) entry.getValue();
                        if (collection.remove(str) && collection.isEmpty()) {
                            linkedHashSet.add(entry.getKey());
                        }
                    }
                    serviceNameToTraceIds.MyBillsEntityDataFactory.keySet().removeAll(linkedHashSet);
                    for (String str2 : linkedHashSet) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(str2);
                        this.getErrorConfigVersion.MyBillsEntityDataFactory(str2);
                    }
                }
            }
            for (Span span : list) {
                long timestampAsLong = span.timestampAsLong() / 1000;
                String traceId = span.traceId();
                if (traceId.length() == 32) {
                    traceId = traceId.substring(16);
                }
                TraceIdTimestamp traceIdTimestamp = new TraceIdTimestamp(traceId, timestampAsLong);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(traceIdTimestamp, span);
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(traceId, traceIdTimestamp);
                if (this.scheduleImpl) {
                    String localServiceName = span.localServiceName();
                    if (localServiceName != null) {
                        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(localServiceName, traceId);
                        String remoteServiceName = span.remoteServiceName();
                        if (remoteServiceName != null) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(localServiceName, remoteServiceName);
                        }
                        String name = span.name();
                        if (name != null) {
                            this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(localServiceName, name);
                        }
                    }
                    for (Map.Entry<String, String> entry2 : span.tags().entrySet()) {
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.contains(entry2.getKey())) {
                            this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(entry2.getKey(), entry2.getValue());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    final class StoreSpansCall extends Call.Base<Void> {
        final List<Span> getAuthRequestContext;

        private StoreSpansCall(List<Span> list) {
            this.getAuthRequestContext = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // zipkin2.Call.Base
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public Void KClassImpl$Data$declaredNonStaticMembers$2() {
            InMemoryStorage.this.getAuthRequestContext(this.getAuthRequestContext);
            return null;
        }

        @Override // zipkin2.Call.Base
        public final void PlaceComponentResult(Callback<Void> callback) {
            try {
                callback.onSuccess(KClassImpl$Data$declaredNonStaticMembers$2());
            } catch (Throwable th) {
                KClassImpl$Data$declaredNonStaticMembers$2(th);
                callback.onError(th);
            }
        }

        @Override // zipkin2.Call
        /* renamed from: MyBillsEntityDataFactory */
        public final Call<Void> clone() {
            return new StoreSpansCall(this.getAuthRequestContext);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StoreSpansCall{");
            sb.append(this.getAuthRequestContext);
            sb.append("}");
            return sb.toString();
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return new StoreSpansCall(this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class ServiceNameToTraceIds extends SortedMultimap<String, String> {
        ServiceNameToTraceIds() {
            super(InMemoryStorage.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        final /* synthetic */ Collection<String> MyBillsEntityDataFactory() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class SortedMultimap<K, V> {
        int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        final SortedMap<K, Collection<V>> MyBillsEntityDataFactory;

        abstract Collection<V> MyBillsEntityDataFactory();

        SortedMultimap(Comparator<K> comparator) {
            this.MyBillsEntityDataFactory = new TreeMap(comparator);
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(K k, V v) {
            Collection<V> collection = this.MyBillsEntityDataFactory.get(k);
            if (collection == null) {
                SortedMap<K, Collection<V>> sortedMap = this.MyBillsEntityDataFactory;
                Collection<V> MyBillsEntityDataFactory = MyBillsEntityDataFactory();
                sortedMap.put(k, MyBillsEntityDataFactory);
                collection = MyBillsEntityDataFactory;
            }
            if (collection.add(v)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }

        final Collection<V> MyBillsEntityDataFactory(K k) {
            Collection<V> remove = this.MyBillsEntityDataFactory.remove(k);
            if (remove != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 -= remove.size();
            }
            return remove;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class TraceIdTimestamp {
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final long PlaceComponentResult;

        TraceIdTimestamp(String str, long j) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.PlaceComponentResult = j;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof TraceIdTimestamp) {
                TraceIdTimestamp traceIdTimestamp = (TraceIdTimestamp) obj;
                return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(traceIdTimestamp.KClassImpl$Data$declaredNonStaticMembers$2) && this.PlaceComponentResult == traceIdTimestamp.PlaceComponentResult;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            long j = this.PlaceComponentResult;
            return ((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
        }
    }
}
