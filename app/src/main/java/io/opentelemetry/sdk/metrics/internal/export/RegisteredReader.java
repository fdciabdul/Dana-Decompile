package io.opentelemetry.sdk.metrics.internal.export;

import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class RegisteredReader {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(1);

    /* renamed from: id  reason: collision with root package name */
    private final int f8248id = ID_COUNTER.incrementAndGet();
    private volatile long lastCollectEpochNanos;
    private final MetricReader metricReader;
    private final ViewRegistry viewRegistry;

    public static RegisteredReader create(MetricReader metricReader, ViewRegistry viewRegistry) {
        return new RegisteredReader(metricReader, viewRegistry);
    }

    private RegisteredReader(MetricReader metricReader, ViewRegistry viewRegistry) {
        this.metricReader = metricReader;
        this.viewRegistry = viewRegistry;
    }

    public MetricReader getReader() {
        return this.metricReader;
    }

    public void setLastCollectEpochNanos(long j) {
        this.lastCollectEpochNanos = j;
    }

    public long getLastCollectEpochNanos() {
        return this.lastCollectEpochNanos;
    }

    public ViewRegistry getViewRegistry() {
        return this.viewRegistry;
    }

    public int hashCode() {
        return this.f8248id;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RegisteredReader) && this.f8248id == ((RegisteredReader) obj).f8248id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisteredReader{");
        sb.append(this.f8248id);
        sb.append("}");
        return sb.toString();
    }
}
