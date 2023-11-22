package io.opentelemetry.api.metrics;

/* loaded from: classes2.dex */
public interface Meter {
    BatchCallback batchCallback(Runnable runnable, ObservableMeasurement observableMeasurement, ObservableMeasurement... observableMeasurementArr);

    LongCounterBuilder counterBuilder(String str);

    DoubleGaugeBuilder gaugeBuilder(String str);

    DoubleHistogramBuilder histogramBuilder(String str);

    LongUpDownCounterBuilder upDownCounterBuilder(String str);

    /* renamed from: io.opentelemetry.api.metrics.Meter$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
    }
}
