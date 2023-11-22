package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.Method;

/* loaded from: classes6.dex */
public interface TelemetryEvaluationProducer {
    void recordException(Method method);

    void recordLatency(Method method, long j);
}
