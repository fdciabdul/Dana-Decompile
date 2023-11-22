package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;

/* loaded from: classes6.dex */
public interface ObservableDoubleMeasurement extends ObservableMeasurement {
    void record(double d);

    void record(double d, Attributes attributes);
}
