package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleUpDownCounter;
import io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.api.metrics.ObservableDoubleUpDownCounter;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class SdkDoubleUpDownCounter extends AbstractInstrument implements DoubleUpDownCounter {
    private final WriteableMetricStorage storage;

    private SdkDoubleUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
    public final void add(double d, Attributes attributes, Context context) {
        this.storage.recordDouble(d, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
    public final void add(double d, Attributes attributes) {
        add(d, attributes, Context.CC.current());
    }

    @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
    public final void add(double d) {
        add(d, Attributes.CC.empty());
    }

    final BoundDoubleUpDownCounter bind(Attributes attributes) {
        return new BoundInstrument(this.storage.bind(attributes), attributes);
    }

    /* loaded from: classes9.dex */
    static final class BoundInstrument implements BoundDoubleUpDownCounter {
        private final Attributes attributes;
        private final BoundStorageHandle handle;

        BoundInstrument(BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public final void add(double d, Context context) {
            this.handle.recordDouble(d, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public final void add(double d) {
            add(d, Context.CC.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public final void unbind() {
            this.handle.release();
        }
    }

    /* loaded from: classes9.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements DoubleUpDownCounterBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public final Builder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public final /* bridge */ /* synthetic */ DoubleUpDownCounterBuilder setDescription(String str) {
            return (DoubleUpDownCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public final /* bridge */ /* synthetic */ DoubleUpDownCounterBuilder setUnit(String str) {
            return (DoubleUpDownCounterBuilder) super.setUnit(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public final DoubleUpDownCounter build() {
            return (DoubleUpDownCounter) buildSynchronousInstrument(InstrumentType.UP_DOWN_COUNTER, InstrumentValueType.DOUBLE, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter$Builder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkDoubleUpDownCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ SdkDoubleUpDownCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleUpDownCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public final ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return new SdkObservableInstrument(this.meterSharedState, registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, consumer));
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public final ObservableDoubleMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, InstrumentValueType.DOUBLE);
        }
    }
}
