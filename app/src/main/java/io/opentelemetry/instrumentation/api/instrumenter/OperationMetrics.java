package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.metrics.Meter;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface OperationMetrics {
    OperationListener create(Meter meter);
}
