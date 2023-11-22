package io.opentelemetry.api.metrics;

import j$.util.function.Consumer;

/* loaded from: classes6.dex */
public interface DoubleGaugeBuilder {
    ObservableDoubleMeasurement buildObserver();

    ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    LongGaugeBuilder ofLongs();

    DoubleGaugeBuilder setDescription(String str);

    DoubleGaugeBuilder setUnit(String str);

    /* renamed from: io.opentelemetry.api.metrics.DoubleGaugeBuilder$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
