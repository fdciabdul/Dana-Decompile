package io.opentelemetry.api.metrics;

import j$.util.function.Consumer;

/* loaded from: classes6.dex */
public interface LongUpDownCounterBuilder {
    LongUpDownCounter build();

    ObservableLongMeasurement buildObserver();

    ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    DoubleUpDownCounterBuilder ofDoubles();

    LongUpDownCounterBuilder setDescription(String str);

    LongUpDownCounterBuilder setUnit(String str);

    /* renamed from: io.opentelemetry.api.metrics.LongUpDownCounterBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
