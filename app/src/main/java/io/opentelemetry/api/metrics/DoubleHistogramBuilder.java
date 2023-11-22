package io.opentelemetry.api.metrics;

/* loaded from: classes6.dex */
public interface DoubleHistogramBuilder {
    DoubleHistogram build();

    LongHistogramBuilder ofLongs();

    DoubleHistogramBuilder setDescription(String str);

    DoubleHistogramBuilder setUnit(String str);
}
