package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes9.dex */
class AlwaysSampleFilter implements ExemplarFilter {
    static final ExemplarFilter INSTANCE = new AlwaysSampleFilter();

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public boolean shouldSampleMeasurement(double d, Attributes attributes, Context context) {
        return true;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public boolean shouldSampleMeasurement(long j, Attributes attributes, Context context) {
        return true;
    }

    private AlwaysSampleFilter() {
    }
}
