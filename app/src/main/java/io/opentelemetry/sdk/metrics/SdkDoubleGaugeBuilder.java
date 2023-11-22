package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.metrics.DoubleGaugeBuilder;
import io.opentelemetry.api.metrics.LongGaugeBuilder;
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import j$.util.function.Consumer;

/* loaded from: classes6.dex */
final class SdkDoubleGaugeBuilder extends AbstractInstrumentBuilder<SdkDoubleGaugeBuilder> implements DoubleGaugeBuilder {
    @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    public final SdkDoubleGaugeBuilder getThis() {
        return this;
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public final /* bridge */ /* synthetic */ DoubleGaugeBuilder setDescription(String str) {
        return (DoubleGaugeBuilder) super.setDescription(str);
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public final /* bridge */ /* synthetic */ DoubleGaugeBuilder setUnit(String str) {
        return (DoubleGaugeBuilder) super.setUnit(str);
    }

    public SdkDoubleGaugeBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
        super(meterProviderSharedState, meterSharedState, str, "", "");
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public final LongGaugeBuilder ofLongs() {
        return (LongGaugeBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleGaugeBuilder$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
            public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                return new SdkLongGaugeBuilder(meterProviderSharedState, meterSharedState, str, str2, str3);
            }
        });
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public final ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
        return new SdkObservableInstrument(this.meterSharedState, registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_GAUGE, consumer));
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public final ObservableDoubleMeasurement buildObserver() {
        return buildObservableMeasurement(InstrumentType.OBSERVABLE_GAUGE, InstrumentValueType.DOUBLE);
    }
}
