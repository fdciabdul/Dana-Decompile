package io.opentelemetry.sdk.metrics.internal.export;

import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.CollectionRegistration;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public interface MetricProducer extends CollectionRegistration {
    Collection<MetricData> collectAllMetrics();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.export.MetricProducer$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static MetricProducer asMetricProducer(CollectionRegistration collectionRegistration) {
            if (!(collectionRegistration instanceof MetricProducer)) {
                throw new IllegalArgumentException("unrecognized CollectionRegistration, custom MetricReader implementations are not currently supported");
            }
            return (MetricProducer) collectionRegistration;
        }

        public static MetricProducer noop() {
            return new MetricProducer() { // from class: io.opentelemetry.sdk.metrics.internal.export.MetricProducer$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.sdk.metrics.internal.export.MetricProducer
                public final Collection collectAllMetrics() {
                    return Collections.emptyList();
                }
            };
        }
    }
}
