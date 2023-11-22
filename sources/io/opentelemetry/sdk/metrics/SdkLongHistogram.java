package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.LongHistogramBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.SdkLongHistogram;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class SdkLongHistogram extends AbstractInstrument implements LongHistogram {
    private static final Logger logger = Logger.getLogger(SdkLongHistogram.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkLongHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.LongHistogram
    public final void record(long j, Attributes attributes, Context context) {
        if (j < 0) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Histograms can only record non-negative values. Instrument ");
            sb.append(getDescriptor().getName());
            sb.append(" has recorded a negative value.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        this.storage.recordLong(j, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.LongHistogram
    public final void record(long j, Attributes attributes) {
        record(j, attributes, Context.CC.current());
    }

    @Override // io.opentelemetry.api.metrics.LongHistogram
    public final void record(long j) {
        record(j, Attributes.CC.empty());
    }

    final BoundLongHistogram bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    /* loaded from: classes9.dex */
    static final class BoundInstrument implements BoundLongHistogram {
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkLongHistogram.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public final void record(long j, Context context) {
            if (j < 0) {
                ThrottlingLogger throttlingLogger = this.throttlingLogger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Histograms can only record non-negative values. Instrument ");
                sb.append(this.descriptor.getName());
                sb.append(" has recorded a negative value.");
                throttlingLogger.log(level, sb.toString());
                return;
            }
            this.handle.recordLong(j, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public final void record(long j) {
            record(j, Context.CC.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public final void unbind() {
            this.handle.release();
        }
    }

    /* loaded from: classes6.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements LongHistogramBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public final Builder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public final /* bridge */ /* synthetic */ LongHistogramBuilder setDescription(String str) {
            return (LongHistogramBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public final /* bridge */ /* synthetic */ LongHistogramBuilder setUnit(String str) {
            return (LongHistogramBuilder) super.setUnit(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public final SdkLongHistogram build() {
            return (SdkLongHistogram) buildSynchronousInstrument(InstrumentType.HISTOGRAM, InstrumentValueType.LONG, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkLongHistogram$Builder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkLongHistogram.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ SdkLongHistogram lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongHistogram(instrumentDescriptor, writeableMetricStorage);
        }
    }
}
