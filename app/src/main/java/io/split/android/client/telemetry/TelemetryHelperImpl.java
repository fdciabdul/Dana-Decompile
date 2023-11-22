package io.split.android.client.telemetry;

/* loaded from: classes6.dex */
public class TelemetryHelperImpl implements TelemetryHelper {
    private static final double ACCEPTANCE_RANGE = 0.001d;
    private static final double MAX_VALUE_PROBABILITY = 1000.0d;

    @Override // io.split.android.client.telemetry.TelemetryHelper
    public boolean shouldRecordTelemetry() {
        return (Math.random() * 1001.0d) / MAX_VALUE_PROBABILITY <= ACCEPTANCE_RANGE;
    }
}
