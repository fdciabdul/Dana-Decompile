package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.MethodExceptions;
import io.split.android.client.telemetry.model.MethodLatencies;

/* loaded from: classes6.dex */
public interface TelemetryEvaluationConsumer {
    MethodExceptions popExceptions();

    MethodLatencies popLatencies();
}
