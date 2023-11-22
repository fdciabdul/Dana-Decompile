package io.split.android.client.service.impressions;

import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;

/* loaded from: classes6.dex */
interface ImpressionManagerRetryTimerProvider {
    RetryBackoffCounterTimer getImpressionsCountTimer();

    RetryBackoffCounterTimer getImpressionsTimer();

    RetryBackoffCounterTimer getUniqueKeysTimer();
}
