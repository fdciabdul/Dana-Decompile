package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.metrics.BatchCallback;
import io.opentelemetry.api.metrics.DoubleGaugeBuilder;
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
import io.opentelemetry.api.metrics.LongCounterBuilder;
import io.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.metrics.ObservableMeasurement;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.SdkDoubleHistogram;
import io.opentelemetry.sdk.metrics.SdkLongCounter;
import io.opentelemetry.sdk.metrics.SdkLongUpDownCounter;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.SdkObservableMeasurement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
final class SdkMeter implements Meter {
    private static final String NOOP_INSTRUMENT_WARNING = " Returning noop instrument.";
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final MeterProviderSharedState meterProviderSharedState;
    private final MeterSharedState meterSharedState;
    private static final Logger logger = Logger.getLogger(SdkMeter.class.getName());
    private static final String NOOP_INSTRUMENT_NAME = "noop";
    private static final Meter NOOP_METER = MeterProvider.CC.noop().get(NOOP_INSTRUMENT_NAME);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeter(MeterProviderSharedState meterProviderSharedState, InstrumentationScopeInfo instrumentationScopeInfo, List<RegisteredReader> list) {
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.meterProviderSharedState = meterProviderSharedState;
        this.meterSharedState = MeterSharedState.create(instrumentationScopeInfo, list);
    }

    final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Collection<MetricData> collectAll(RegisteredReader registeredReader, long j) {
        return this.meterSharedState.collectAll(registeredReader, this.meterProviderSharedState, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void resetForTest() {
        this.meterSharedState.resetForTest();
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public final LongCounterBuilder counterBuilder(String str) {
        if (!ValidationUtil.checkValidInstrumentName(str, NOOP_INSTRUMENT_WARNING)) {
            return NOOP_METER.counterBuilder(NOOP_INSTRUMENT_NAME);
        }
        return new SdkLongCounter.Builder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public final LongUpDownCounterBuilder upDownCounterBuilder(String str) {
        if (!ValidationUtil.checkValidInstrumentName(str, NOOP_INSTRUMENT_WARNING)) {
            return NOOP_METER.upDownCounterBuilder(NOOP_INSTRUMENT_NAME);
        }
        return new SdkLongUpDownCounter.Builder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public final DoubleHistogramBuilder histogramBuilder(String str) {
        if (!ValidationUtil.checkValidInstrumentName(str, NOOP_INSTRUMENT_WARNING)) {
            return NOOP_METER.histogramBuilder(NOOP_INSTRUMENT_NAME);
        }
        return new SdkDoubleHistogram.Builder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public final DoubleGaugeBuilder gaugeBuilder(String str) {
        if (!ValidationUtil.checkValidInstrumentName(str, NOOP_INSTRUMENT_WARNING)) {
            return NOOP_METER.gaugeBuilder(NOOP_INSTRUMENT_NAME);
        }
        return new SdkDoubleGaugeBuilder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    @Override // io.opentelemetry.api.metrics.Meter
    public final BatchCallback batchCallback(Runnable runnable, ObservableMeasurement observableMeasurement, ObservableMeasurement... observableMeasurementArr) {
        HashSet<ObservableMeasurement> hashSet = new HashSet();
        hashSet.add(observableMeasurement);
        Collections.addAll(hashSet, observableMeasurementArr);
        ArrayList arrayList = new ArrayList();
        for (ObservableMeasurement observableMeasurement2 : hashSet) {
            if (!(observableMeasurement2 instanceof SdkObservableMeasurement)) {
                logger.log(Level.WARNING, "batchCallback called with instruments that were not created by the SDK.");
            } else {
                SdkObservableMeasurement sdkObservableMeasurement = (SdkObservableMeasurement) observableMeasurement2;
                if (!this.meterSharedState.getInstrumentationScopeInfo().equals(sdkObservableMeasurement.getInstrumentationScopeInfo())) {
                    logger.log(Level.WARNING, "batchCallback called with instruments that belong to a different Meter.");
                } else {
                    arrayList.add(sdkObservableMeasurement);
                }
            }
        }
        CallbackRegistration create = CallbackRegistration.create(arrayList, runnable);
        this.meterSharedState.registerCallback(create);
        return new SdkObservableInstrument(this.meterSharedState, create);
    }
}
