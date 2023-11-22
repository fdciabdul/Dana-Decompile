package com.google.firebase.perf.transport;

import android.content.Context;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.resource.ResourceType;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RateLimiter {
    private final ConfigResolver configResolver;
    private final float fragmentBucketId;
    private boolean isLogcatEnabled;
    private RateLimiterImpl networkLimiter;
    private final float samplingBucketId;
    private RateLimiterImpl traceLimiter;

    public RateLimiter(Context context, Rate rate, long j) {
        this(rate, j, new Clock(), getSamplingBucketId(), getSamplingBucketId(), ConfigResolver.getInstance());
        this.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
    }

    static float getSamplingBucketId() {
        return new Random().nextFloat();
    }

    RateLimiter(Rate rate, long j, Clock clock, float f, float f2, ConfigResolver configResolver) {
        this.traceLimiter = null;
        this.networkLimiter = null;
        boolean z = false;
        this.isLogcatEnabled = false;
        Utils.checkArgument(0.0f <= f && f < 1.0f, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        if (0.0f <= f2 && f2 < 1.0f) {
            z = true;
        }
        Utils.checkArgument(z, "Fragment sampling bucket ID should be in range [0.0f, 1.0f).");
        this.samplingBucketId = f;
        this.fragmentBucketId = f2;
        this.configResolver = configResolver;
        this.traceLimiter = new RateLimiterImpl(rate, j, clock, configResolver, ResourceType.TRACE, this.isLogcatEnabled);
        this.networkLimiter = new RateLimiterImpl(rate, j, clock, configResolver, ResourceType.NETWORK, this.isLogcatEnabled);
    }

    private boolean isDeviceAllowedToSendTraces() {
        return this.samplingBucketId < this.configResolver.getTraceSamplingRate();
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        return this.samplingBucketId < this.configResolver.getNetworkRequestSamplingRate();
    }

    private boolean isDeviceAllowedToSendFragmentScreenTraces() {
        return this.fragmentBucketId < this.configResolver.getFragmentSamplingRate();
    }

    protected final boolean isFragmentScreenTrace(PerfMetric perfMetric) {
        return perfMetric.hasTraceMetric() && perfMetric.getTraceMetric().getName().startsWith(Constants.SCREEN_TRACE_PREFIX) && perfMetric.getTraceMetric().containsCustomAttributes(Constants.ACTIVITY_ATTRIBUTE_KEY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEventRateLimited(PerfMetric perfMetric) {
        boolean check;
        if (isRateLimitApplicable(perfMetric)) {
            if (perfMetric.hasNetworkRequestMetric()) {
                check = this.networkLimiter.check(perfMetric);
            } else if (!perfMetric.hasTraceMetric()) {
                return true;
            } else {
                check = this.traceLimiter.check(perfMetric);
            }
            return !check;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEventSampled(PerfMetric perfMetric) {
        if (!perfMetric.hasTraceMetric() || isDeviceAllowedToSendTraces() || hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            if (!isFragmentScreenTrace(perfMetric) || isDeviceAllowedToSendFragmentScreenTraces() || hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
                return !perfMetric.hasNetworkRequestMetric() || isDeviceAllowedToSendNetworkEvents() || hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList());
            }
            return false;
        }
        return false;
    }

    private boolean hasVerboseSessions(List<PerfSession> list) {
        return list.size() > 0 && list.get(0).getSessionVerbosityCount() > 0 && list.get(0).getSessionVerbosity(0) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
    }

    final boolean isRateLimitApplicable(PerfMetric perfMetric) {
        return (!perfMetric.hasTraceMetric() || (!(perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString()) || perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString())) || perfMetric.getTraceMetric().getCountersCount() <= 0)) && !perfMetric.hasGaugeMetric();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void changeRate(boolean z) {
        this.traceLimiter.changeRate(z);
        this.networkLimiter.changeRate(z);
    }

    final boolean getIsDeviceAllowedToSendTraces() {
        return isDeviceAllowedToSendTraces();
    }

    final boolean getIsDeviceAllowedToSendNetworkEvents() {
        return isDeviceAllowedToSendNetworkEvents();
    }

    final boolean getIsDeviceAllowedToSendFragmentScreenTraces() {
        return isDeviceAllowedToSendFragmentScreenTraces();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RateLimiterImpl {
        private long backgroundCapacity;
        private Rate backgroundRate;
        private long capacity;
        private final Clock clock;
        private long foregroundCapacity;
        private Rate foregroundRate;
        private final boolean isLogcatEnabled;
        private Timer lastTimeTokenReplenished;
        private Rate rate;
        private long tokenCount;
        private static final AndroidLogger logger = AndroidLogger.getInstance();
        private static final long MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);

        RateLimiterImpl(Rate rate, long j, Clock clock, ConfigResolver configResolver, @ResourceType String str, boolean z) {
            this.clock = clock;
            this.capacity = j;
            this.rate = rate;
            this.tokenCount = j;
            this.lastTimeTokenReplenished = clock.getTime();
            setRateByReadingRemoteConfigValues(configResolver, str, z);
            this.isLogcatEnabled = z;
        }

        boolean check(PerfMetric perfMetric) {
            synchronized (this) {
                double durationMicros = this.lastTimeTokenReplenished.getDurationMicros(this.clock.getTime());
                double tokensPerSeconds = this.rate.getTokensPerSeconds();
                long j = MICROS_IN_A_SECOND;
                double d = j;
                Double.isNaN(durationMicros);
                Double.isNaN(d);
                long max = Math.max(0L, (long) ((durationMicros * tokensPerSeconds) / d));
                this.tokenCount = Math.min(this.tokenCount + max, this.capacity);
                if (max > 0) {
                    long micros = this.lastTimeTokenReplenished.getMicros();
                    double d2 = max * j;
                    double tokensPerSeconds2 = this.rate.getTokensPerSeconds();
                    Double.isNaN(d2);
                    this.lastTimeTokenReplenished = new Timer(micros + ((long) (d2 / tokensPerSeconds2)));
                }
                long j2 = this.tokenCount;
                if (j2 > 0) {
                    this.tokenCount = j2 - 1;
                    return true;
                }
                if (this.isLogcatEnabled) {
                    logger.warn("Exceeded log rate limit, dropping the log.");
                }
                return false;
            }
        }

        void changeRate(boolean z) {
            synchronized (this) {
                this.rate = z ? this.foregroundRate : this.backgroundRate;
                this.capacity = z ? this.foregroundCapacity : this.backgroundCapacity;
            }
        }

        private void setRateByReadingRemoteConfigValues(ConfigResolver configResolver, @ResourceType String str, boolean z) {
            long flimitSec = getFlimitSec(configResolver, str);
            long flimitEvents = getFlimitEvents(configResolver, str);
            Rate rate = new Rate(flimitEvents, flimitSec, TimeUnit.SECONDS);
            this.foregroundRate = rate;
            this.foregroundCapacity = flimitEvents;
            if (z) {
                logger.debug("Foreground %s logging rate:%f, burst capacity:%d", str, rate, Long.valueOf(flimitEvents));
            }
            long blimitSec = getBlimitSec(configResolver, str);
            long blimitEvents = getBlimitEvents(configResolver, str);
            Rate rate2 = new Rate(blimitEvents, blimitSec, TimeUnit.SECONDS);
            this.backgroundRate = rate2;
            this.backgroundCapacity = blimitEvents;
            if (z) {
                logger.debug("Background %s logging rate:%f, capacity:%d", str, rate2, Long.valueOf(blimitEvents));
            }
        }

        private static long getFlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private static long getFlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountForeground();
            }
            return configResolver.getNetworkEventCountForeground();
        }

        private static long getBlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private static long getBlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountBackground();
            }
            return configResolver.getNetworkEventCountBackground();
        }

        Rate getForegroundRate() {
            return this.foregroundRate;
        }

        long getForegroundCapacity() {
            return this.foregroundCapacity;
        }

        Rate getBackgroundRate() {
            return this.backgroundRate;
        }

        long getBackgroundCapacity() {
            return this.backgroundCapacity;
        }

        Rate getRate() {
            return this.rate;
        }

        void setRate(Rate rate) {
            this.rate = rate;
        }
    }
}
