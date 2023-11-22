package io.opentelemetry.api.metrics;

import j$.util.function.Consumer;

/* loaded from: classes6.dex */
public interface DoubleUpDownCounterBuilder {
    DoubleUpDownCounter build();

    ObservableDoubleMeasurement buildObserver();

    ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    DoubleUpDownCounterBuilder setDescription(String str);

    DoubleUpDownCounterBuilder setUnit(String str);

    /* renamed from: io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
