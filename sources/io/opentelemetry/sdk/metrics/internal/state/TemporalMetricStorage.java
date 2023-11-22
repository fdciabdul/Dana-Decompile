package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class TemporalMetricStorage<T, U extends ExemplarData> {
    private final Aggregator<T, U> aggregator;
    private final boolean isSynchronous;
    private Map<Attributes, T> lastAccumulation = new HashMap();
    private final MetricDescriptor metricDescriptor;
    private final RegisteredReader registeredReader;
    private final AggregationTemporality temporality;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalMetricStorage(Aggregator<T, U> aggregator, boolean z, RegisteredReader registeredReader, AggregationTemporality aggregationTemporality, MetricDescriptor metricDescriptor) {
        this.aggregator = aggregator;
        this.isSynchronous = z;
        this.registeredReader = registeredReader;
        this.temporality = aggregationTemporality;
        this.metricDescriptor = metricDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0010, B:8:0x0014, B:19:0x0043, B:21:0x0047, B:23:0x004c, B:25:0x0052, B:28:0x0058, B:22:0x004a, B:10:0x001f, B:12:0x0025, B:14:0x0029, B:16:0x003a, B:17:0x003f), top: B:36:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0010, B:8:0x0014, B:19:0x0043, B:21:0x0047, B:23:0x004c, B:25:0x0052, B:28:0x0058, B:22:0x004a, B:10:0x001f, B:12:0x0025, B:14:0x0029, B:16:0x003a, B:17:0x003f), top: B:36:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[Catch: all -> 0x006c, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0010, B:8:0x0014, B:19:0x0043, B:21:0x0047, B:23:0x004c, B:25:0x0052, B:28:0x0058, B:22:0x004a, B:10:0x001f, B:12:0x0025, B:14:0x0029, B:16:0x003a, B:17:0x003f), top: B:36:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[Catch: all -> 0x006c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0010, B:8:0x0014, B:19:0x0043, B:21:0x0047, B:23:0x004c, B:25:0x0052, B:28:0x0058, B:22:0x004a, B:10:0x001f, B:12:0x0025, B:14:0x0029, B:16:0x003a, B:17:0x003f), top: B:36:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.opentelemetry.sdk.metrics.data.MetricData buildMetricFor(io.opentelemetry.sdk.resources.Resource r16, io.opentelemetry.sdk.common.InstrumentationScopeInfo r17, java.util.Map<io.opentelemetry.api.common.Attributes, T> r18, long r19, long r21) {
        /*
            r15 = this;
            r1 = r15
            r0 = r18
            monitor-enter(r15)
            io.opentelemetry.sdk.metrics.internal.export.RegisteredReader r2 = r1.registeredReader     // Catch: java.lang.Throwable -> L6c
            long r11 = r2.getLastCollectEpochNanos()     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.data.AggregationTemporality r2 = r1.temporality     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.data.AggregationTemporality r3 = io.opentelemetry.sdk.metrics.data.AggregationTemporality.DELTA     // Catch: java.lang.Throwable -> L6c
            if (r2 != r3) goto L1f
            boolean r2 = r1.isSynchronous     // Catch: java.lang.Throwable -> L6c
            if (r2 != 0) goto L1f
            java.util.Map<io.opentelemetry.api.common.Attributes, T> r2 = r1.lastAccumulation     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator<T, U extends io.opentelemetry.sdk.metrics.data.ExemplarData> r3 = r1.aggregator     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils.diffInPlace(r2, r0, r3)     // Catch: java.lang.Throwable -> L6c
            java.util.Map<io.opentelemetry.api.common.Attributes, T> r2 = r1.lastAccumulation     // Catch: java.lang.Throwable -> L6c
        L1d:
            r7 = r2
            goto L43
        L1f:
            io.opentelemetry.sdk.metrics.data.AggregationTemporality r2 = r1.temporality     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.data.AggregationTemporality r3 = io.opentelemetry.sdk.metrics.data.AggregationTemporality.CUMULATIVE     // Catch: java.lang.Throwable -> L6c
            if (r2 != r3) goto L42
            boolean r2 = r1.isSynchronous     // Catch: java.lang.Throwable -> L6c
            if (r2 == 0) goto L42
            java.util.Map<io.opentelemetry.api.common.Attributes, T> r2 = r1.lastAccumulation     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator<T, U extends io.opentelemetry.sdk.metrics.data.ExemplarData> r3 = r1.aggregator     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils.mergeAndPreserveInPlace(r2, r0, r3)     // Catch: java.lang.Throwable -> L6c
            java.util.Map<io.opentelemetry.api.common.Attributes, T> r2 = r1.lastAccumulation     // Catch: java.lang.Throwable -> L6c
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L6c
            r3 = 2000(0x7d0, float:2.803E-42)
            if (r2 <= r3) goto L3f
            java.util.Map<io.opentelemetry.api.common.Attributes, T> r2 = r1.lastAccumulation     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils.removeUnseen(r2, r0)     // Catch: java.lang.Throwable -> L6c
        L3f:
            java.util.Map<io.opentelemetry.api.common.Attributes, T> r2 = r1.lastAccumulation     // Catch: java.lang.Throwable -> L6c
            goto L1d
        L42:
            r7 = r0
        L43:
            boolean r2 = r1.isSynchronous     // Catch: java.lang.Throwable -> L6c
            if (r2 == 0) goto L4a
            r1.lastAccumulation = r7     // Catch: java.lang.Throwable -> L6c
            goto L4c
        L4a:
            r1.lastAccumulation = r0     // Catch: java.lang.Throwable -> L6c
        L4c:
            boolean r0 = r7.isEmpty()     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L58
            io.opentelemetry.sdk.metrics.data.MetricData r0 = io.opentelemetry.sdk.metrics.internal.aggregator.EmptyMetricData.getInstance()     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r15)
            return r0
        L58:
            io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator<T, U extends io.opentelemetry.sdk.metrics.data.ExemplarData> r3 = r1.aggregator     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor r6 = r1.metricDescriptor     // Catch: java.lang.Throwable -> L6c
            io.opentelemetry.sdk.metrics.data.AggregationTemporality r8 = r1.temporality     // Catch: java.lang.Throwable -> L6c
            r4 = r16
            r5 = r17
            r9 = r19
            r13 = r21
            io.opentelemetry.sdk.metrics.data.MetricData r0 = r3.toMetricData(r4, r5, r6, r7, r8, r9, r11, r13)     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r15)
            return r0
        L6c:
            r0 = move-exception
            monitor-exit(r15)
            goto L70
        L6f:
            throw r0
        L70:
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.metrics.internal.state.TemporalMetricStorage.buildMetricFor(io.opentelemetry.sdk.resources.Resource, io.opentelemetry.sdk.common.InstrumentationScopeInfo, java.util.Map, long, long):io.opentelemetry.sdk.metrics.data.MetricData");
    }
}
