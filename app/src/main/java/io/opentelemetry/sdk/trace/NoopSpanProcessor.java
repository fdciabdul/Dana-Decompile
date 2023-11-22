package io.opentelemetry.sdk.trace;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class NoopSpanProcessor implements SpanProcessor {
    private static final NoopSpanProcessor INSTANCE = new NoopSpanProcessor();

    @Override // io.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final /* synthetic */ CompletableResultCode forceFlush() {
        CompletableResultCode ofSuccess;
        ofSuccess = CompletableResultCode.ofSuccess();
        return ofSuccess;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isEndRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isStartRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onEnd(ReadableSpan readableSpan) {
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onStart(Context context, ReadWriteSpan readWriteSpan) {
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final /* synthetic */ CompletableResultCode shutdown() {
        CompletableResultCode forceFlush;
        forceFlush = forceFlush();
        return forceFlush;
    }

    public final String toString() {
        return "NoopSpanProcessor{}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanProcessor getInstance() {
        return INSTANCE;
    }

    private NoopSpanProcessor() {
    }
}
