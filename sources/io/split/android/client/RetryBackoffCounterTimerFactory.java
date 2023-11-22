package io.split.android.client;

import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.FixedIntervalBackoffCounter;
import io.split.android.client.service.sseclient.ReconnectBackoffCounter;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;

/* loaded from: classes6.dex */
public class RetryBackoffCounterTimerFactory {
    public RetryBackoffCounterTimer create(SplitTaskExecutor splitTaskExecutor, int i) {
        return new RetryBackoffCounterTimer(splitTaskExecutor, new ReconnectBackoffCounter(i));
    }

    public RetryBackoffCounterTimer createWithFixedInterval(SplitTaskExecutor splitTaskExecutor, int i, int i2) {
        return new RetryBackoffCounterTimer(splitTaskExecutor, new FixedIntervalBackoffCounter(i), i2);
    }
}
