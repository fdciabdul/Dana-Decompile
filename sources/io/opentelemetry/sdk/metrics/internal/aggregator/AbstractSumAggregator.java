package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;

/* loaded from: classes6.dex */
abstract class AbstractSumAggregator<T, U extends ExemplarData> implements Aggregator<T, U> {
    private final boolean isMonotonic;

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ Object accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateDoubleMeasurement(this, d, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ Object accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        return Aggregator.CC.$default$accumulateLongMeasurement(this, j, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ Object diff(Object obj, Object obj2) {
        return Aggregator.CC.$default$diff(this, obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSumAggregator(InstrumentDescriptor instrumentDescriptor) {
        this.isMonotonic = MetricDataUtils.isMonotonicInstrument(instrumentDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isMonotonic() {
        return this.isMonotonic;
    }
}
