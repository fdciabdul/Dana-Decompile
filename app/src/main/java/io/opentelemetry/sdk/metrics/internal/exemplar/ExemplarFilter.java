package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes2.dex */
public interface ExemplarFilter {
    boolean shouldSampleMeasurement(double d, Attributes attributes, Context context);

    boolean shouldSampleMeasurement(long j, Attributes attributes, Context context);

    /* renamed from: io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static ExemplarFilter sampleWithTraces() {
            return WithTraceExemplarFilter.INSTANCE;
        }

        public static ExemplarFilter alwaysSample() {
            return AlwaysSampleFilter.INSTANCE;
        }

        public static ExemplarFilter neverSample() {
            return NeverSampleFilter.INSTANCE;
        }
    }
}
