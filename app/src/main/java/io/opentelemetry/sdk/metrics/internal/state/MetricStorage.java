package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.resources.Resource;

/* loaded from: classes6.dex */
public interface MetricStorage {
    MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2);

    MetricDescriptor getMetricDescriptor();

    RegisteredReader getRegisteredReader();

    boolean isEmpty();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.state.MetricStorage$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$isEmpty(MetricStorage metricStorage) {
            return metricStorage == EmptyMetricStorage.INSTANCE;
        }
    }
}
