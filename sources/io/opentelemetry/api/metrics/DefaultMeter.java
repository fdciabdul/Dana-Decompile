package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.metrics.BatchCallback;
import io.opentelemetry.api.metrics.ObservableDoubleCounter;
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
import io.opentelemetry.api.metrics.ObservableDoubleUpDownCounter;
import io.opentelemetry.api.metrics.ObservableLongCounter;
import io.opentelemetry.api.metrics.ObservableLongGauge;
import io.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import io.opentelemetry.context.Context;
import j$.util.function.Consumer;

/* loaded from: classes6.dex */
class DefaultMeter implements Meter {
    private static final Meter INSTANCE = new DefaultMeter();
    private static final BatchCallback NOOP_BATCH_CALLBACK = new BatchCallback() { // from class: io.opentelemetry.api.metrics.DefaultMeter.1
        @Override // io.opentelemetry.api.metrics.BatchCallback, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            BatchCallback.CC.$default$close(this);
        }
    };
    private static final DoubleGaugeBuilder NOOP_DOUBLE_GAUGE_BUILDER;
    private static final DoubleHistogramBuilder NOOP_DOUBLE_HISTOGRAM_BUILDER;
    private static final LongCounterBuilder NOOP_LONG_COUNTER_BUILDER;
    private static final LongUpDownCounterBuilder NOOP_LONG_UP_DOWN_COUNTER_BUILDER;
    private static final ObservableDoubleMeasurement NOOP_OBSERVABLE_DOUBLE_MEASUREMENT;
    private static final ObservableLongMeasurement NOOP_OBSERVABLE_LONG_MEASUREMENT;

    static {
        NOOP_LONG_COUNTER_BUILDER = new NoopLongCounterBuilder();
        NOOP_LONG_UP_DOWN_COUNTER_BUILDER = new NoopLongUpDownCounterBuilder();
        NOOP_DOUBLE_HISTOGRAM_BUILDER = new NoopDoubleHistogramBuilder();
        NOOP_DOUBLE_GAUGE_BUILDER = new NoopDoubleGaugeBuilder();
        NOOP_OBSERVABLE_DOUBLE_MEASUREMENT = new NoopObservableDoubleMeasurement();
        NOOP_OBSERVABLE_LONG_MEASUREMENT = new NoopObservableLongMeasurement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Meter getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public LongCounterBuilder counterBuilder(String str) {
        ValidationUtil.checkValidInstrumentName(str);
        return NOOP_LONG_COUNTER_BUILDER;
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public LongUpDownCounterBuilder upDownCounterBuilder(String str) {
        ValidationUtil.checkValidInstrumentName(str);
        return NOOP_LONG_UP_DOWN_COUNTER_BUILDER;
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public DoubleHistogramBuilder histogramBuilder(String str) {
        ValidationUtil.checkValidInstrumentName(str);
        return NOOP_DOUBLE_HISTOGRAM_BUILDER;
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public DoubleGaugeBuilder gaugeBuilder(String str) {
        ValidationUtil.checkValidInstrumentName(str);
        return NOOP_DOUBLE_GAUGE_BUILDER;
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public BatchCallback batchCallback(Runnable runnable, ObservableMeasurement observableMeasurement, ObservableMeasurement... observableMeasurementArr) {
        return NOOP_BATCH_CALLBACK;
    }

    private DefaultMeter() {
    }

    /* loaded from: classes6.dex */
    static class NoopLongCounter implements LongCounter {
        @Override // io.opentelemetry.api.metrics.LongCounter
        public void add(long j) {
        }

        @Override // io.opentelemetry.api.metrics.LongCounter
        public void add(long j, Attributes attributes) {
        }

        @Override // io.opentelemetry.api.metrics.LongCounter
        public void add(long j, Attributes attributes, Context context) {
        }

        private NoopLongCounter() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleCounter implements DoubleCounter {
        @Override // io.opentelemetry.api.metrics.DoubleCounter
        public void add(double d) {
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounter
        public void add(double d, Attributes attributes) {
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounter
        public void add(double d, Attributes attributes, Context context) {
        }

        private NoopDoubleCounter() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopLongCounterBuilder implements LongCounterBuilder {
        private static final LongCounter NOOP_COUNTER;
        private static final DoubleCounterBuilder NOOP_DOUBLE_COUNTER_BUILDER;
        private static final ObservableLongCounter NOOP_OBSERVABLE_COUNTER = new ObservableLongCounter() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopLongCounterBuilder.1
            @Override // io.opentelemetry.api.metrics.ObservableLongCounter, java.lang.AutoCloseable
            public /* synthetic */ void close() {
                ObservableLongCounter.CC.$default$close(this);
            }
        };

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public LongCounterBuilder setDescription(String str) {
            return this;
        }

        private NoopLongCounterBuilder() {
        }

        static {
            NOOP_COUNTER = new NoopLongCounter();
            NOOP_DOUBLE_COUNTER_BUILDER = new NoopDoubleCounterBuilder();
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public LongCounterBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public DoubleCounterBuilder ofDoubles() {
            return NOOP_DOUBLE_COUNTER_BUILDER;
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public LongCounter build() {
            return NOOP_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return NOOP_OBSERVABLE_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public ObservableLongMeasurement buildObserver() {
            return DefaultMeter.NOOP_OBSERVABLE_LONG_MEASUREMENT;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleCounterBuilder implements DoubleCounterBuilder {
        private static final DoubleCounter NOOP_COUNTER = new NoopDoubleCounter();
        private static final ObservableDoubleCounter NOOP_OBSERVABLE_COUNTER = new ObservableDoubleCounter() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopDoubleCounterBuilder.1
            @Override // io.opentelemetry.api.metrics.ObservableDoubleCounter, java.lang.AutoCloseable
            public /* synthetic */ void close() {
                ObservableDoubleCounter.CC.$default$close(this);
            }
        };

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public DoubleCounterBuilder setDescription(String str) {
            return this;
        }

        private NoopDoubleCounterBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public DoubleCounterBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public DoubleCounter build() {
            return NOOP_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return NOOP_OBSERVABLE_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public ObservableDoubleMeasurement buildObserver() {
            return DefaultMeter.NOOP_OBSERVABLE_DOUBLE_MEASUREMENT;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopLongUpDownCounter implements LongUpDownCounter {
        @Override // io.opentelemetry.api.metrics.LongUpDownCounter
        public void add(long j) {
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounter
        public void add(long j, Attributes attributes) {
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounter
        public void add(long j, Attributes attributes, Context context) {
        }

        private NoopLongUpDownCounter() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleUpDownCounter implements DoubleUpDownCounter {
        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
        public void add(double d) {
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
        public void add(double d, Attributes attributes) {
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
        public void add(double d, Attributes attributes, Context context) {
        }

        private NoopDoubleUpDownCounter() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopLongUpDownCounterBuilder implements LongUpDownCounterBuilder {
        private static final LongUpDownCounter NOOP_UP_DOWN_COUNTER = new NoopLongUpDownCounter() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopLongUpDownCounterBuilder.1
        };
        private static final ObservableLongUpDownCounter NOOP_OBSERVABLE_UP_DOWN_COUNTER = new ObservableLongUpDownCounter() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopLongUpDownCounterBuilder.2
            @Override // io.opentelemetry.api.metrics.ObservableLongUpDownCounter, java.lang.AutoCloseable
            public /* synthetic */ void close() {
                ObservableLongUpDownCounter.CC.$default$close(this);
            }
        };
        private static final DoubleUpDownCounterBuilder NOOP_DOUBLE_UP_DOWN_COUNTER_BUILDER = new NoopDoubleUpDownCounterBuilder();

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounterBuilder setDescription(String str) {
            return this;
        }

        private NoopLongUpDownCounterBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounterBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public DoubleUpDownCounterBuilder ofDoubles() {
            return NOOP_DOUBLE_UP_DOWN_COUNTER_BUILDER;
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounter build() {
            return NOOP_UP_DOWN_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return NOOP_OBSERVABLE_UP_DOWN_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public ObservableLongMeasurement buildObserver() {
            return DefaultMeter.NOOP_OBSERVABLE_LONG_MEASUREMENT;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleUpDownCounterBuilder implements DoubleUpDownCounterBuilder {
        private static final DoubleUpDownCounter NOOP_UP_DOWN_COUNTER = new NoopDoubleUpDownCounter() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopDoubleUpDownCounterBuilder.1
        };
        private static final ObservableDoubleUpDownCounter NOOP_OBSERVABLE_UP_DOWN_COUNTER = new ObservableDoubleUpDownCounter() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopDoubleUpDownCounterBuilder.2
            @Override // io.opentelemetry.api.metrics.ObservableDoubleUpDownCounter, java.lang.AutoCloseable
            public /* synthetic */ void close() {
                ObservableDoubleUpDownCounter.CC.$default$close(this);
            }
        };

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounterBuilder setDescription(String str) {
            return this;
        }

        private NoopDoubleUpDownCounterBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounterBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounter build() {
            return NOOP_UP_DOWN_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return NOOP_OBSERVABLE_UP_DOWN_COUNTER;
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public ObservableDoubleMeasurement buildObserver() {
            return DefaultMeter.NOOP_OBSERVABLE_DOUBLE_MEASUREMENT;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleHistogram implements DoubleHistogram {
        @Override // io.opentelemetry.api.metrics.DoubleHistogram
        public void record(double d) {
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogram
        public void record(double d, Attributes attributes) {
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogram
        public void record(double d, Attributes attributes, Context context) {
        }

        private NoopDoubleHistogram() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopLongHistogram implements LongHistogram {
        @Override // io.opentelemetry.api.metrics.LongHistogram
        public void record(long j) {
        }

        @Override // io.opentelemetry.api.metrics.LongHistogram
        public void record(long j, Attributes attributes) {
        }

        @Override // io.opentelemetry.api.metrics.LongHistogram
        public void record(long j, Attributes attributes, Context context) {
        }

        private NoopLongHistogram() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleHistogramBuilder implements DoubleHistogramBuilder {
        private static final DoubleHistogram NOOP;
        private static final LongHistogramBuilder NOOP_LONG_HISTOGRAM_BUILDER;

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public DoubleHistogramBuilder setDescription(String str) {
            return this;
        }

        private NoopDoubleHistogramBuilder() {
        }

        static {
            NOOP = new NoopDoubleHistogram();
            NOOP_LONG_HISTOGRAM_BUILDER = new NoopLongHistogramBuilder();
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public DoubleHistogramBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public LongHistogramBuilder ofLongs() {
            return NOOP_LONG_HISTOGRAM_BUILDER;
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public DoubleHistogram build() {
            return NOOP;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopLongHistogramBuilder implements LongHistogramBuilder {
        private static final LongHistogram NOOP = new NoopLongHistogram();

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public LongHistogramBuilder setDescription(String str) {
            return this;
        }

        private NoopLongHistogramBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public LongHistogramBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public LongHistogram build() {
            return NOOP;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopDoubleGaugeBuilder implements DoubleGaugeBuilder {
        private static final ObservableDoubleGauge NOOP = new ObservableDoubleGauge() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopDoubleGaugeBuilder.1
            @Override // io.opentelemetry.api.metrics.ObservableDoubleGauge, java.lang.AutoCloseable
            public /* synthetic */ void close() {
                ObservableDoubleGauge.CC.$default$close(this);
            }
        };
        private static final LongGaugeBuilder NOOP_LONG_GAUGE_BUILDER = new NoopLongGaugeBuilder();

        @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
        public DoubleGaugeBuilder setDescription(String str) {
            return this;
        }

        private NoopDoubleGaugeBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
        public DoubleGaugeBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
        public LongGaugeBuilder ofLongs() {
            return NOOP_LONG_GAUGE_BUILDER;
        }

        @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
        public ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return NOOP;
        }

        @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
        public ObservableDoubleMeasurement buildObserver() {
            return DefaultMeter.NOOP_OBSERVABLE_DOUBLE_MEASUREMENT;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopLongGaugeBuilder implements LongGaugeBuilder {
        private static final ObservableLongGauge NOOP = new ObservableLongGauge() { // from class: io.opentelemetry.api.metrics.DefaultMeter.NoopLongGaugeBuilder.1
            @Override // io.opentelemetry.api.metrics.ObservableLongGauge, java.lang.AutoCloseable
            public /* synthetic */ void close() {
                ObservableLongGauge.CC.$default$close(this);
            }
        };

        @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
        public LongGaugeBuilder setDescription(String str) {
            return this;
        }

        private NoopLongGaugeBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
        public LongGaugeBuilder setUnit(String str) {
            ValidationUtil.checkValidInstrumentUnit(str);
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
        public ObservableLongGauge buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return NOOP;
        }

        @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
        public ObservableLongMeasurement buildObserver() {
            return DefaultMeter.NOOP_OBSERVABLE_LONG_MEASUREMENT;
        }
    }

    /* loaded from: classes6.dex */
    static class NoopObservableDoubleMeasurement implements ObservableDoubleMeasurement {
        @Override // io.opentelemetry.api.metrics.ObservableDoubleMeasurement
        public void record(double d) {
        }

        @Override // io.opentelemetry.api.metrics.ObservableDoubleMeasurement
        public void record(double d, Attributes attributes) {
        }

        private NoopObservableDoubleMeasurement() {
        }
    }

    /* loaded from: classes6.dex */
    static class NoopObservableLongMeasurement implements ObservableLongMeasurement {
        @Override // io.opentelemetry.api.metrics.ObservableLongMeasurement
        public void record(long j) {
        }

        @Override // io.opentelemetry.api.metrics.ObservableLongMeasurement
        public void record(long j, Attributes attributes) {
        }

        private NoopObservableLongMeasurement() {
        }
    }
}
