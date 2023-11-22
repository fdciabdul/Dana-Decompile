package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;

/* loaded from: classes6.dex */
public interface ObservableLongMeasurement extends ObservableMeasurement {
    void record(long j);

    void record(long j, Attributes attributes);
}
