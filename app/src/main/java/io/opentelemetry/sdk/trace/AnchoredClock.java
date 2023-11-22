package io.opentelemetry.sdk.trace;

import io.opentelemetry.sdk.common.Clock;

/* loaded from: classes6.dex */
final class AnchoredClock {
    private final Clock clock;
    private final long epochNanos;
    private final long nanoTime;

    private AnchoredClock(Clock clock, long j, long j2) {
        this.clock = clock;
        this.epochNanos = j;
        this.nanoTime = j2;
    }

    public static AnchoredClock create(Clock clock) {
        return new AnchoredClock(clock, clock.now(), clock.nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long now() {
        return this.epochNanos + (this.clock.nanoTime() - this.nanoTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long startTime() {
        return this.epochNanos;
    }
}
