package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.metrics.BatchCallback;
import io.opentelemetry.api.metrics.ObservableDoubleCounter;
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
import io.opentelemetry.api.metrics.ObservableDoubleUpDownCounter;
import io.opentelemetry.api.metrics.ObservableLongCounter;
import io.opentelemetry.api.metrics.ObservableLongGauge;
import io.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
class SdkObservableInstrument implements ObservableDoubleCounter, ObservableLongCounter, ObservableDoubleGauge, ObservableLongGauge, ObservableDoubleUpDownCounter, ObservableLongUpDownCounter, BatchCallback {
    private static final Logger logger = Logger.getLogger(SdkObservableInstrument.class.getName());
    private final CallbackRegistration callbackRegistration;
    private final MeterSharedState meterSharedState;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);
    private final AtomicBoolean removed = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkObservableInstrument(MeterSharedState meterSharedState, CallbackRegistration callbackRegistration) {
        this.meterSharedState = meterSharedState;
        this.callbackRegistration = callbackRegistration;
    }

    @Override // io.opentelemetry.api.metrics.ObservableDoubleCounter, java.lang.AutoCloseable
    public void close() {
        if (!this.removed.compareAndSet(false, true)) {
            ThrottlingLogger throttlingLogger = this.throttlingLogger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append(this.callbackRegistration.getCallbackDescription());
            sb.append(" has called close() multiple times.");
            throttlingLogger.log(level, sb.toString());
            return;
        }
        this.meterSharedState.removeCallback(this.callbackRegistration);
    }
}
