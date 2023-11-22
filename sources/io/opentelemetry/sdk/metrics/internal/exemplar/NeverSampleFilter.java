package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class NeverSampleFilter implements ExemplarFilter {
    static final ExemplarFilter INSTANCE = new NeverSampleFilter();

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public boolean shouldSampleMeasurement(double d, Attributes attributes, Context context) {
        return false;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public boolean shouldSampleMeasurement(long j, Attributes attributes, Context context) {
        return false;
    }

    private NeverSampleFilter() {
    }
}
