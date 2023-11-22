package zipkin2.reporter;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes9.dex */
public final class InMemoryReporterMetrics implements ReporterMetrics {
    private final ConcurrentHashMap<MetricKey, AtomicLong> BuiltInFictitiousFunctionClassFactory = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<? extends Throwable>, AtomicLong> KClassImpl$Data$declaredNonStaticMembers$2 = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum MetricKey {
        messages,
        messageBytes,
        spans,
        spanBytes,
        spansDropped,
        spansPending,
        spanBytesPending
    }

    @Override // zipkin2.reporter.ReporterMetrics
    public final void getAuthRequestContext() {
        PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, MetricKey.messages, 1);
    }

    @Override // zipkin2.reporter.ReporterMetrics
    public final void MyBillsEntityDataFactory(Throwable th) {
        PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, th.getClass(), 1);
    }

    @Override // zipkin2.reporter.ReporterMetrics
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, MetricKey.messageBytes, i);
    }

    @Override // zipkin2.reporter.ReporterMetrics
    public final void PlaceComponentResult(int i) {
        PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, MetricKey.spansDropped, i);
    }

    @Override // zipkin2.reporter.ReporterMetrics
    public final void getAuthRequestContext(int i) {
        MyBillsEntityDataFactory(MetricKey.spansPending, i);
    }

    @Override // zipkin2.reporter.ReporterMetrics
    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        MyBillsEntityDataFactory(MetricKey.spanBytesPending, i);
    }

    private static <K> void PlaceComponentResult(ConcurrentHashMap<K, AtomicLong> concurrentHashMap, K k, int i) {
        long j;
        if (i == 0) {
            return;
        }
        AtomicLong atomicLong = concurrentHashMap.get(k);
        if (atomicLong == null && (atomicLong = concurrentHashMap.putIfAbsent(k, new AtomicLong(i))) == null) {
            return;
        }
        do {
            j = atomicLong.get();
        } while (!atomicLong.compareAndSet(j, i + j));
    }

    private void MyBillsEntityDataFactory(MetricKey metricKey, int i) {
        AtomicLong atomicLong = this.BuiltInFictitiousFunctionClassFactory.get(metricKey);
        if (atomicLong == null && (atomicLong = this.BuiltInFictitiousFunctionClassFactory.putIfAbsent(metricKey, new AtomicLong(i))) == null) {
            return;
        }
        atomicLong.set(i);
    }
}
