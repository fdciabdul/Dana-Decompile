package io.opentelemetry.sdk.metrics;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleCounter;
import io.opentelemetry.api.metrics.DoubleCounterBuilder;
import io.opentelemetry.api.metrics.ObservableDoubleCounter;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.SdkDoubleCounter;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class SdkDoubleCounter extends AbstractInstrument implements DoubleCounter {
    private static final Logger logger = Logger.getLogger(SdkDoubleCounter.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkDoubleCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.DoubleCounter
    public final void add(double d, Attributes attributes, Context context) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Counters can only increase. Instrument ");
            sb.append(getDescriptor().getName());
            sb.append(" has recorded a negative value.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        this.storage.recordDouble(d, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.DoubleCounter
    public final void add(double d, Attributes attributes) {
        add(d, attributes, Context.CC.current());
    }

    @Override // io.opentelemetry.api.metrics.DoubleCounter
    public final void add(double d) {
        add(d, Attributes.CC.empty());
    }

    final BoundDoubleCounter bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    /* loaded from: classes9.dex */
    static final class BoundInstrument implements BoundDoubleCounter {
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkDoubleCounter.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public final void add(double d, Context context) {
            if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                ThrottlingLogger throttlingLogger = this.throttlingLogger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Counters can only increase. Instrument ");
                sb.append(this.descriptor.getName());
                sb.append(" has recorded a negative value.");
                throttlingLogger.log(level, sb.toString());
                return;
            }
            this.handle.recordDouble(d, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public final void add(double d) {
            add(d, Context.CC.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public final void unbind() {
            this.handle.release();
        }
    }

    /* loaded from: classes9.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements DoubleCounterBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public final Builder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public final /* bridge */ /* synthetic */ DoubleCounterBuilder setDescription(String str) {
            return (DoubleCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public final /* bridge */ /* synthetic */ DoubleCounterBuilder setUnit(String str) {
            return (DoubleCounterBuilder) super.setUnit(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public final SdkDoubleCounter build() {
            return (SdkDoubleCounter) buildSynchronousInstrument(InstrumentType.COUNTER, InstrumentValueType.DOUBLE, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleCounter$Builder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkDoubleCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ SdkDoubleCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public final ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return new SdkObservableInstrument(this.meterSharedState, registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_COUNTER, consumer));
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public final ObservableDoubleMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_COUNTER, InstrumentValueType.DOUBLE);
        }
    }
}
