package io.opentelemetry.sdk.metrics;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
import io.opentelemetry.api.metrics.LongHistogramBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import io.opentelemetry.sdk.metrics.SdkDoubleHistogram;
import io.opentelemetry.sdk.metrics.SdkLongHistogram;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class SdkDoubleHistogram extends AbstractInstrument implements DoubleHistogram {
    private static final Logger logger = Logger.getLogger(SdkDoubleHistogram.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkDoubleHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.DoubleHistogram
    public final void record(double d, Attributes attributes, Context context) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Histograms can only record non-negative values. Instrument ");
            sb.append(getDescriptor().getName());
            sb.append(" has recorded a negative value.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        this.storage.recordDouble(d, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.DoubleHistogram
    public final void record(double d, Attributes attributes) {
        record(d, attributes, Context.CC.current());
    }

    @Override // io.opentelemetry.api.metrics.DoubleHistogram
    public final void record(double d) {
        record(d, Attributes.CC.empty());
    }

    final BoundDoubleHistogram bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    /* loaded from: classes9.dex */
    static final class BoundInstrument implements BoundDoubleHistogram {
        private final BoundStorageHandle aggregatorHandle;
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkDoubleHistogram.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.aggregatorHandle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public final void record(double d, Context context) {
            if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                ThrottlingLogger throttlingLogger = this.throttlingLogger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Histograms can only record non-negative values. Instrument ");
                sb.append(this.descriptor.getName());
                sb.append(" has recorded a negative value.");
                throttlingLogger.log(level, sb.toString());
                return;
            }
            this.aggregatorHandle.recordDouble(d, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public final void record(double d) {
            record(d, Context.CC.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public final void unbind() {
            this.aggregatorHandle.release();
        }
    }

    /* loaded from: classes6.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements DoubleHistogramBuilder {
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public final Builder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public final /* bridge */ /* synthetic */ DoubleHistogramBuilder setDescription(String str) {
            return (DoubleHistogramBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public final /* bridge */ /* synthetic */ DoubleHistogramBuilder setUnit(String str) {
            return (DoubleHistogramBuilder) super.setUnit(str);
        }

        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            super(meterProviderSharedState, meterSharedState, str, "", "");
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public final SdkDoubleHistogram build() {
            return (SdkDoubleHistogram) buildSynchronousInstrument(InstrumentType.HISTOGRAM, InstrumentValueType.DOUBLE, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleHistogram$Builder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkDoubleHistogram.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        public static /* synthetic */ SdkDoubleHistogram lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleHistogram(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public final LongHistogramBuilder ofLongs() {
            return (LongHistogramBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleHistogram$Builder$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkLongHistogram.Builder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }
    }
}
