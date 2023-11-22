package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleCounterBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongCounterBuilder;
import io.opentelemetry.api.metrics.ObservableLongCounter;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import io.opentelemetry.sdk.metrics.SdkDoubleCounter;
import io.opentelemetry.sdk.metrics.SdkLongCounter;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class SdkLongCounter extends AbstractInstrument implements LongCounter {
    private static final Logger logger = Logger.getLogger(SdkLongCounter.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkLongCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.LongCounter
    public final void add(long j, Attributes attributes, Context context) {
        if (j < 0) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Counters can only increase. Instrument ");
            sb.append(getDescriptor().getName());
            sb.append(" has recorded a negative value.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        this.storage.recordLong(j, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.LongCounter
    public final void add(long j, Attributes attributes) {
        add(j, attributes, Context.CC.current());
    }

    @Override // io.opentelemetry.api.metrics.LongCounter
    public final void add(long j) {
        add(j, Attributes.CC.empty());
    }

    final BoundLongCounter bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    /* loaded from: classes9.dex */
    static final class BoundInstrument implements BoundLongCounter {
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkLongCounter.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public final void add(long j, Context context) {
            if (j < 0) {
                ThrottlingLogger throttlingLogger = this.throttlingLogger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Counters can only increase. Instrument ");
                sb.append(this.descriptor.getName());
                sb.append(" has recorded a negative value.");
                throttlingLogger.log(level, sb.toString());
                return;
            }
            this.handle.recordLong(j, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public final void add(long j) {
            add(j, Context.CC.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public final void unbind() {
            this.handle.release();
        }
    }

    /* loaded from: classes6.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements LongCounterBuilder {
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public final Builder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public final /* bridge */ /* synthetic */ LongCounterBuilder setDescription(String str) {
            return (LongCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public final /* bridge */ /* synthetic */ LongCounterBuilder setUnit(String str) {
            return (LongCounterBuilder) super.setUnit(str);
        }

        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            super(meterProviderSharedState, meterSharedState, str, "", "");
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public final SdkLongCounter build() {
            return (SdkLongCounter) buildSynchronousInstrument(InstrumentType.COUNTER, InstrumentValueType.LONG, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkLongCounter$Builder$$ExternalSyntheticLambda1
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkLongCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        public static /* synthetic */ SdkLongCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public final DoubleCounterBuilder ofDoubles() {
            return (DoubleCounterBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkLongCounter$Builder$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkDoubleCounter.Builder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public final ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return new SdkObservableInstrument(this.meterSharedState, registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_COUNTER, consumer));
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public final ObservableLongMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_COUNTER, InstrumentValueType.LONG);
        }
    }
}
