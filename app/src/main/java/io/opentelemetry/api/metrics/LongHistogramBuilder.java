package io.opentelemetry.api.metrics;

/* loaded from: classes6.dex */
public interface LongHistogramBuilder {
    LongHistogram build();

    LongHistogramBuilder setDescription(String str);

    LongHistogramBuilder setUnit(String str);
}
