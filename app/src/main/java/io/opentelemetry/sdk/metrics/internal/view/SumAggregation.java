package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.internal.RandomSupplier;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.InstrumentValueType;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.aggregator.DoubleSumAggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.LongSumAggregator;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import j$.util.function.Supplier;

/* loaded from: classes6.dex */
public final class SumAggregation implements Aggregation, AggregatorFactory {
    private static final SumAggregation INSTANCE = new SumAggregation();

    public final String toString() {
        return "SumAggregation";
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    private SumAggregation() {
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public final <T, U extends ExemplarData> Aggregator<T, U> createAggregator(InstrumentDescriptor instrumentDescriptor, final ExemplarFilter exemplarFilter) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType[instrumentDescriptor.getValueType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new DoubleSumAggregator(instrumentDescriptor, new Supplier() { // from class: io.opentelemetry.sdk.metrics.internal.view.SumAggregation$$ExternalSyntheticLambda1
                    @Override // j$.util.function.Supplier
                    public final Object get() {
                        ExemplarReservoir filtered;
                        filtered = ExemplarReservoir.CC.filtered(ExemplarFilter.this, ExemplarReservoir.CC.doubleFixedSizeReservoir(Clock.CC.getDefault(), Runtime.getRuntime().availableProcessors(), RandomSupplier.platformDefault()));
                        return filtered;
                    }
                });
            }
            throw new IllegalArgumentException("Invalid instrument value type");
        }
        return new LongSumAggregator(instrumentDescriptor, new Supplier() { // from class: io.opentelemetry.sdk.metrics.internal.view.SumAggregation$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                ExemplarReservoir filtered;
                filtered = ExemplarReservoir.CC.filtered(ExemplarFilter.this, ExemplarReservoir.CC.longFixedSizeReservoir(Clock.CC.getDefault(), Runtime.getRuntime().availableProcessors(), RandomSupplier.platformDefault()));
                return filtered;
            }
        });
    }

    /* renamed from: io.opentelemetry.sdk.metrics.internal.view.SumAggregation$1 */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType;
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType;

        static {
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 3;
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
            int[] iArr2 = new int[InstrumentValueType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType = iArr2;
            try {
                iArr2[InstrumentValueType.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentValueType[InstrumentValueType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public final boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[instrumentDescriptor.getType().ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }
}
