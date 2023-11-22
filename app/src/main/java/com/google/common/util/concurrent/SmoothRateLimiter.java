package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    abstract double coolDownIntervalMicros();

    abstract void doSetRate(double d, double d2);

    abstract long storedPermitsToWaitTime(double d, double d2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j, TimeUnit timeUnit, double d) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j);
            this.coldFactor = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        final void doSetRate(double d, double d2) {
            double d3;
            double d4 = this.maxPermits;
            double d5 = this.coldFactor * d2;
            double d6 = this.warmupPeriodMicros;
            Double.isNaN(d6);
            double d7 = (0.5d * d6) / d2;
            this.thresholdPermits = d7;
            Double.isNaN(d6);
            this.maxPermits = d7 + ((d6 * 2.0d) / (d2 + d5));
            this.slope = (d5 - d2) / (this.maxPermits - this.thresholdPermits);
            if (d4 == Double.POSITIVE_INFINITY) {
                this.storedPermits = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                return;
            }
            if (d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d3 = this.maxPermits;
            } else {
                d3 = (this.storedPermits * this.maxPermits) / d4;
            }
            this.storedPermits = d3;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        final long storedPermitsToWaitTime(double d, double d2) {
            long j;
            double d3 = d - this.thresholdPermits;
            if (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double min = Math.min(d3, d2);
                j = (long) (((permitsToTime(d3) + permitsToTime(d3 - min)) * min) / 2.0d);
                d2 -= min;
            } else {
                j = 0;
            }
            return j + ((long) (this.stableIntervalMicros * d2));
        }

        private double permitsToTime(double d) {
            return this.stableIntervalMicros + (d * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        final double coolDownIntervalMicros() {
            double d = this.warmupPeriodMicros;
            double d2 = this.maxPermits;
            Double.isNaN(d);
            return d / d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        final long storedPermitsToWaitTime(double d, double d2) {
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        final void doSetRate(double d, double d2) {
            double d3 = this.maxPermits;
            this.maxPermits = this.maxBurstSeconds * d;
            if (d3 == Double.POSITIVE_INFINITY) {
                this.storedPermits = this.maxPermits;
                return;
            }
            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d4 = (this.storedPermits * this.maxPermits) / d3;
            }
            this.storedPermits = d4;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        final double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final void doSetRate(double d, long j) {
        resync(j);
        double micros = TimeUnit.SECONDS.toMicros(1L);
        Double.isNaN(micros);
        double d2 = micros / d;
        this.stableIntervalMicros = d2;
        doSetRate(d, d2);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double doGetRate() {
        double micros = TimeUnit.SECONDS.toMicros(1L);
        double d = this.stableIntervalMicros;
        Double.isNaN(micros);
        return micros / d;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long queryEarliestAvailable(long j) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long reserveEarliestAvailable(int i, long j) {
        resync(j);
        long j2 = this.nextFreeTicketMicros;
        double d = i;
        double min = Math.min(d, this.storedPermits);
        long storedPermitsToWaitTime = storedPermitsToWaitTime(this.storedPermits, min);
        Double.isNaN(d);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime + ((long) ((d - min) * this.stableIntervalMicros)));
        this.storedPermits -= min;
        return j2;
    }

    void resync(long j) {
        long j2 = this.nextFreeTicketMicros;
        if (j > j2) {
            double d = j - j2;
            double coolDownIntervalMicros = coolDownIntervalMicros();
            Double.isNaN(d);
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (d / coolDownIntervalMicros));
            this.nextFreeTicketMicros = j;
        }
    }
}
