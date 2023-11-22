package io.opentelemetry.sdk.internal;

import io.opentelemetry.sdk.common.Clock;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class RateLimiter {
    private final Clock clock;
    private final double creditsPerNanosecond;
    private final AtomicLong currentBalance;
    private final long maxBalance;

    public RateLimiter(double d, double d2, Clock clock) {
        this.clock = clock;
        double d3 = d / 1.0E9d;
        this.creditsPerNanosecond = d3;
        long j = (long) (d2 / d3);
        this.maxBalance = j;
        this.currentBalance = new AtomicLong(clock.nanoTime() - j);
    }

    public boolean trySpend(double d) {
        long j;
        long nanoTime;
        long j2;
        long j3 = (long) (d / this.creditsPerNanosecond);
        do {
            j = this.currentBalance.get();
            nanoTime = this.clock.nanoTime();
            long j4 = nanoTime - j;
            long j5 = this.maxBalance;
            if (j4 > j5) {
                j4 = j5;
            }
            j2 = j4 - j3;
            if (j2 < 0) {
                return false;
            }
        } while (!this.currentBalance.compareAndSet(j, nanoTime - j2));
        return true;
    }
}
