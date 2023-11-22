package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import io.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter;
import io.opentelemetry.sdk.metrics.SdkLongUpDownCounter;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;

/* loaded from: classes9.dex */
public final class SdkLongUpDownCounter extends AbstractInstrument implements LongUpDownCounter {
    private final WriteableMetricStorage storage;

    private SdkLongUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.LongUpDownCounter
    public final void add(long j, Attributes attributes, Context context) {
        this.storage.recordLong(j, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.LongUpDownCounter
    public final void add(long j, Attributes attributes) {
        add(j, attributes, Context.CC.current());
    }

    @Override // io.opentelemetry.api.metrics.LongUpDownCounter
    public final void add(long j) {
        add(j, Attributes.CC.empty());
    }

    final BoundLongUpDownCounter bind(Attributes attributes) {
        return new BoundInstrument(this.storage.bind(attributes), attributes);
    }

    /* loaded from: classes9.dex */
    static final class BoundInstrument implements BoundLongUpDownCounter {
        private final Attributes attributes;
        private final BoundStorageHandle handle;

        BoundInstrument(BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public final void add(long j, Context context) {
            this.handle.recordLong(j, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public final void add(long j) {
            add(j, Context.CC.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public final void unbind() {
            this.handle.release();
        }
    }

    /* loaded from: classes9.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements LongUpDownCounterBuilder {
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public final Builder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public final /* bridge */ /* synthetic */ LongUpDownCounterBuilder setDescription(String str) {
            return (LongUpDownCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public final /* bridge */ /* synthetic */ LongUpDownCounterBuilder setUnit(String str) {
            return (LongUpDownCounterBuilder) super.setUnit(str);
        }

        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            super(meterProviderSharedState, meterSharedState, str, "", "");
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public final LongUpDownCounter build() {
            return (LongUpDownCounter) buildSynchronousInstrument(InstrumentType.UP_DOWN_COUNTER, InstrumentValueType.LONG, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkLongUpDownCounter$Builder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkLongUpDownCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        public static /* synthetic */ SdkLongUpDownCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongUpDownCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public final DoubleUpDownCounterBuilder ofDoubles() {
            return (DoubleUpDownCounterBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkLongUpDownCounter$Builder$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkDoubleUpDownCounter.Builder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public final ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return new SdkObservableInstrument(this.meterSharedState, registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, consumer));
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public final ObservableLongMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, InstrumentValueType.LONG);
        }
    }
}
