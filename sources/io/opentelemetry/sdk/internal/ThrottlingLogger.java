package io.opentelemetry.sdk.internal;

import io.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class ThrottlingLogger {
    private static final double RATE_LIMIT = 5.0d;
    private static final double THROTTLED_RATE_LIMIT = 1.0d;
    private static final TimeUnit rateTimeUnit = TimeUnit.MINUTES;
    private final Logger delegate;
    private final RateLimiter fastRateLimiter;
    private final AtomicBoolean throttled;
    private final RateLimiter throttledRateLimiter;

    public ThrottlingLogger(Logger logger) {
        this(logger, Clock.CC.getDefault());
    }

    ThrottlingLogger(Logger logger, Clock clock) {
        this.throttled = new AtomicBoolean(false);
        this.delegate = logger;
        TimeUnit timeUnit = rateTimeUnit;
        double seconds = timeUnit.toSeconds(1L);
        Double.isNaN(seconds);
        this.fastRateLimiter = new RateLimiter(RATE_LIMIT / seconds, RATE_LIMIT, clock);
        double seconds2 = timeUnit.toSeconds(1L);
        Double.isNaN(seconds2);
        this.throttledRateLimiter = new RateLimiter(RATE_LIMIT / seconds2, 1.0d, clock);
    }

    public void log(Level level, String str) {
        log(level, str, null);
    }

    public void log(Level level, String str, @Nullable Throwable th) {
        if (isLoggable(level)) {
            if (this.throttled.get()) {
                if (this.throttledRateLimiter.trySpend(1.0d)) {
                    doLog(level, str, th);
                }
            } else if (this.fastRateLimiter.trySpend(1.0d)) {
                doLog(level, str, th);
            } else if (this.throttled.compareAndSet(false, true)) {
                this.throttledRateLimiter.trySpend(1.0d);
                this.delegate.log(level, "Too many log messages detected. Will only log once per minute from now on.");
                doLog(level, str, th);
            }
        }
    }

    private void doLog(Level level, String str, @Nullable Throwable th) {
        if (th != null) {
            this.delegate.log(level, str, th);
        } else {
            this.delegate.log(level, str);
        }
    }

    public boolean isLoggable(Level level) {
        return this.delegate.isLoggable(level);
    }
}
