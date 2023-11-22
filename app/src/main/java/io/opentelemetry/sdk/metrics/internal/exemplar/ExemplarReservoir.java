package io.opentelemetry.sdk.metrics.internal.exemplar;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import j$.util.function.Supplier;
import java.util.List;
import java.util.Random;

/* loaded from: classes6.dex */
public interface ExemplarReservoir<T extends ExemplarData> {
    List<T> collectAndReset(Attributes attributes);

    void offerDoubleMeasurement(double d, Attributes attributes, Context context);

    void offerLongMeasurement(long j, Attributes attributes, Context context);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<T extends ExemplarData> {
        public static <T extends ExemplarData> ExemplarReservoir<T> filtered(ExemplarFilter exemplarFilter, ExemplarReservoir<T> exemplarReservoir) {
            return new FilteredExemplarReservoir(exemplarFilter, exemplarReservoir);
        }

        public static ExemplarReservoir<DoubleExemplarData> doubleNoSamples() {
            return NoopExemplarReservoir.DOUBLE_INSTANCE;
        }

        public static ExemplarReservoir<LongExemplarData> longNoSamples() {
            return NoopExemplarReservoir.LONG_INSTANCE;
        }

        public static ExemplarReservoir<DoubleExemplarData> doubleFixedSizeReservoir(Clock clock, int i, Supplier<Random> supplier) {
            return RandomFixedSizeExemplarReservoir.createDouble(clock, i, supplier);
        }

        public static ExemplarReservoir<LongExemplarData> longFixedSizeReservoir(Clock clock, int i, Supplier<Random> supplier) {
            return RandomFixedSizeExemplarReservoir.createLong(clock, i, supplier);
        }

        public static ExemplarReservoir<DoubleExemplarData> histogramBucketReservoir(Clock clock, List<Double> list) {
            return new HistogramExemplarReservoir(clock, list);
        }
    }
}
