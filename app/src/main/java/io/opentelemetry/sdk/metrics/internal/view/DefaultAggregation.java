package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class DefaultAggregation implements Aggregation, AggregatorFactory {
    private static final Aggregation INSTANCE = new DefaultAggregation();
    private static final ThrottlingLogger logger = new ThrottlingLogger(Logger.getLogger(DefaultAggregation.class.getName()));

    public final String toString() {
        return "DefaultAggregation";
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    private DefaultAggregation() {
    }

    /* renamed from: io.opentelemetry.sdk.metrics.internal.view.DefaultAggregation$1 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType;

        static {
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_UP_DOWN_COUNTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_GAUGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static Aggregation resolve(InstrumentDescriptor instrumentDescriptor) {
        switch (AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[instrumentDescriptor.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return SumAggregation.getInstance();
            case 5:
                return ExplicitBucketHistogramAggregation.getDefault();
            case 6:
                return LastValueAggregation.getInstance();
            default:
                ThrottlingLogger throttlingLogger = logger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to find default aggregation for instrument: ");
                sb.append(instrumentDescriptor);
                throttlingLogger.log(level, sb.toString());
                return DropAggregation.getInstance();
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public final <T, U extends ExemplarData> Aggregator<T, U> createAggregator(InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        return ((AggregatorFactory) resolve(instrumentDescriptor)).createAggregator(instrumentDescriptor, exemplarFilter);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public final boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        return ((AggregatorFactory) resolve(instrumentDescriptor)).isCompatibleWithInstrument(instrumentDescriptor);
    }
}
