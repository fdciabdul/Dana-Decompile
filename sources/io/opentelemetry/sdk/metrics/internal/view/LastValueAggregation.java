package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.InstrumentValueType;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.aggregator.DoubleLastValueAggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.LongLastValueAggregator;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import j$.util.function.Supplier;

/* loaded from: classes6.dex */
public final class LastValueAggregation implements Aggregation, AggregatorFactory {
    private static final Aggregation INSTANCE = new LastValueAggregation();

    public final String toString() {
        return "LastValueAggregation";
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    private LastValueAggregation() {
    }

    /* renamed from: io.opentelemetry.sdk.metrics.internal.view.LastValueAggregation$1 */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType;

        static {
            int[] iArr = new int[InstrumentValueType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType = iArr;
            try {
                iArr[InstrumentValueType.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType[InstrumentValueType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public final <T, U extends ExemplarData> Aggregator<T, U> createAggregator(InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType[instrumentDescriptor.getValueType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new DoubleLastValueAggregator(new Supplier() { // from class: io.opentelemetry.sdk.metrics.internal.view.LastValueAggregation$$ExternalSyntheticLambda1
                    @Override // j$.util.function.Supplier
                    public final Object get() {
                        return ExemplarReservoir.CC.doubleNoSamples();
                    }
                });
            }
            throw new IllegalArgumentException("Invalid instrument value type");
        }
        return new LongLastValueAggregator(new Supplier() { // from class: io.opentelemetry.sdk.metrics.internal.view.LastValueAggregation$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return ExemplarReservoir.CC.longNoSamples();
            }
        });
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public final boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        return instrumentDescriptor.getType() == InstrumentType.OBSERVABLE_GAUGE;
    }
}
