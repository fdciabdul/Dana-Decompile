package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Random;

/* loaded from: classes6.dex */
public class RandomFixedSizeExemplarReservoir<T extends ExemplarData> extends FixedSizeExemplarReservoir<T> {
    private RandomFixedSizeExemplarReservoir(Clock clock, int i, Supplier<Random> supplier, BiFunction<ReservoirCell, Attributes, T> biFunction) {
        super(clock, i, new RandomCellSelector(supplier), biFunction);
    }

    public static RandomFixedSizeExemplarReservoir<LongExemplarData> createLong(Clock clock, int i, Supplier<Random> supplier) {
        return new RandomFixedSizeExemplarReservoir<>(clock, i, supplier, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.exemplar.RandomFixedSizeExemplarReservoir$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiFunction
            public final /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.MyBillsEntityDataFactory(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ReservoirCell) obj).getAndResetLong((Attributes) obj2);
            }
        });
    }

    public static RandomFixedSizeExemplarReservoir<DoubleExemplarData> createDouble(Clock clock, int i, Supplier<Random> supplier) {
        return new RandomFixedSizeExemplarReservoir<>(clock, i, supplier, new HistogramExemplarReservoir$$ExternalSyntheticLambda0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class RandomCellSelector implements ReservoirCellSelector {
        private final LongAdder numMeasurements;
        private final Supplier<Random> randomSupplier;

        private RandomCellSelector(Supplier<Random> supplier) {
            this.numMeasurements = AdderUtil.createLongAdder();
            this.randomSupplier = supplier;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCellSelector
        public int reservoirCellIndexFor(ReservoirCell[] reservoirCellArr, long j, Attributes attributes, Context context) {
            return reservoirCellIndex(reservoirCellArr);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCellSelector
        public int reservoirCellIndexFor(ReservoirCell[] reservoirCellArr, double d, Attributes attributes, Context context) {
            return reservoirCellIndex(reservoirCellArr);
        }

        private int reservoirCellIndex(ReservoirCell[] reservoirCellArr) {
            int intValue = this.numMeasurements.intValue() + 1;
            int nextInt = this.randomSupplier.get().nextInt(intValue > 0 ? intValue : 1);
            this.numMeasurements.increment();
            if (nextInt < reservoirCellArr.length) {
                return nextInt;
            }
            return -1;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCellSelector
        public void reset() {
            this.numMeasurements.reset();
        }
    }
}
