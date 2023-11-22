package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class WithTraceExemplarFilter implements ExemplarFilter {
    static final ExemplarFilter INSTANCE = new WithTraceExemplarFilter();

    private WithTraceExemplarFilter() {
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public final boolean shouldSampleMeasurement(long j, Attributes attributes, Context context) {
        return hasSampledTrace(context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public final boolean shouldSampleMeasurement(double d, Attributes attributes, Context context) {
        return hasSampledTrace(context);
    }

    private static boolean hasSampledTrace(Context context) {
        return Span.CC.fromContext(context).getSpanContext().isSampled();
    }
}
