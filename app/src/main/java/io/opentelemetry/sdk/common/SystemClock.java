package io.opentelemetry.sdk.common;

import io.opentelemetry.sdk.internal.JavaVersionSpecific;

/* loaded from: classes.dex */
final class SystemClock implements Clock {
    private static final SystemClock INSTANCE = new SystemClock();

    public final String toString() {
        return "SystemClock{}";
    }

    private SystemClock() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Clock getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.sdk.common.Clock
    public final long now() {
        return JavaVersionSpecific.get().currentTimeNanos();
    }

    @Override // io.opentelemetry.sdk.common.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }
}
