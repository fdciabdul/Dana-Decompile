package io.opentelemetry.sdk.metrics.internal.state;

/* loaded from: classes3.dex */
public interface ExponentialCounter {
    void clear();

    long get(int i);

    int getIndexEnd();

    int getIndexStart();

    int getMaxSize();

    boolean increment(int i, long j);

    boolean isEmpty();
}
