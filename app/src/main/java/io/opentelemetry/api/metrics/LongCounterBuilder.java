package io.opentelemetry.api.metrics;

import j$.util.function.Consumer;

/* loaded from: classes6.dex */
public interface LongCounterBuilder {
    LongCounter build();

    ObservableLongMeasurement buildObserver();

    ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    DoubleCounterBuilder ofDoubles();

    LongCounterBuilder setDescription(String str);

    LongCounterBuilder setUnit(String str);

    /* renamed from: io.opentelemetry.api.metrics.LongCounterBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
