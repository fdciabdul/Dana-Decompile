package io.opentelemetry.api.metrics;

import j$.util.function.Consumer;

/* loaded from: classes6.dex */
public interface DoubleCounterBuilder {
    DoubleCounter build();

    ObservableDoubleMeasurement buildObserver();

    ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    DoubleCounterBuilder setDescription(String str);

    DoubleCounterBuilder setUnit(String str);

    /* renamed from: io.opentelemetry.api.metrics.DoubleCounterBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
