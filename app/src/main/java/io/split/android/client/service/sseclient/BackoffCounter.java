package io.split.android.client.service.sseclient;

/* loaded from: classes6.dex */
public interface BackoffCounter {
    long getNextRetryTime();

    void resetCounter();
}
