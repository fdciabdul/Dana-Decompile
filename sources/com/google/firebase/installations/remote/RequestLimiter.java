package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    private static boolean isRetryableError(int i) {
        return i == 429 || (i >= 500 && i < 600);
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i) {
        return (i >= 200 && i < 300) || i == 401 || i == 404;
    }

    RequestLimiter(Utils utils) {
        this.utils = utils;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestLimiter() {
        this.utils = Utils.getInstance();
    }

    public void setNextRequestTime(int i) {
        synchronized (this) {
            if (isSuccessfulOrRequiresNewFidCreation(i)) {
                resetBackoffStrategy();
                return;
            }
            this.attemptCount++;
            this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i);
        }
    }

    private void resetBackoffStrategy() {
        synchronized (this) {
            this.attemptCount = 0;
        }
    }

    private long getBackoffDuration(int i) {
        synchronized (this) {
            if (!isRetryableError(i)) {
                return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
            }
            double pow = Math.pow(2.0d, this.attemptCount);
            double randomDelayForSyncPrevention = this.utils.getRandomDelayForSyncPrevention();
            double d = MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS;
            Double.isNaN(randomDelayForSyncPrevention);
            return (long) Math.min(pow + randomDelayForSyncPrevention, d);
        }
    }

    public boolean isRequestAllowed() {
        boolean z;
        synchronized (this) {
            if (this.attemptCount != 0) {
                z = this.utils.currentTimeInMillis() > this.nextRequestTime;
            }
        }
        return z;
    }
}
