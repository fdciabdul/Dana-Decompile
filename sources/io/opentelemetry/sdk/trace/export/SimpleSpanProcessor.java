package io.opentelemetry.sdk.trace.export;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class SimpleSpanProcessor implements SpanProcessor {
    private static final Logger logger = Logger.getLogger(SimpleSpanProcessor.class.getName());
    private final boolean sampled;
    private final SpanExporter spanExporter;
    private final Set<CompletableResultCode> pendingExports = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    @Override // io.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isEndRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isStartRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onStart(Context context, ReadWriteSpan readWriteSpan) {
    }

    public static SpanProcessor create(SpanExporter spanExporter) {
        Objects.requireNonNull(spanExporter, "exporter");
        return new SimpleSpanProcessor(spanExporter, true);
    }

    SimpleSpanProcessor(SpanExporter spanExporter, boolean z) {
        this.spanExporter = (SpanExporter) Objects.requireNonNull(spanExporter, "spanExporter");
        this.sampled = z;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onEnd(ReadableSpan readableSpan) {
        if (!this.sampled || readableSpan.getSpanContext().isSampled()) {
            try {
                final CompletableResultCode export = this.spanExporter.export(Collections.singletonList(readableSpan.toSpanData()));
                this.pendingExports.add(export);
                export.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.SimpleSpanProcessor$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimpleSpanProcessor.this.m3165x532b8784(export);
                    }
                });
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onEnd$0$io-opentelemetry-sdk-trace-export-SimpleSpanProcessor  reason: not valid java name */
    public final /* synthetic */ void m3165x532b8784(CompletableResultCode completableResultCode) {
        this.pendingExports.remove(completableResultCode);
        if (completableResultCode.isSuccess()) {
            return;
        }
        logger.log(Level.FINE, "Exporter failed");
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final CompletableResultCode forceFlush = forceFlush();
        forceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.SimpleSpanProcessor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SimpleSpanProcessor.this.m3166xfbd6c93a(forceFlush, completableResultCode);
            }
        });
        return completableResultCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$shutdown$2$io-opentelemetry-sdk-trace-export-SimpleSpanProcessor  reason: not valid java name */
    public final /* synthetic */ void m3166xfbd6c93a(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
        final CompletableResultCode shutdown = this.spanExporter.shutdown();
        shutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.SimpleSpanProcessor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SimpleSpanProcessor.lambda$shutdown$1(CompletableResultCode.this, shutdown, completableResultCode2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$shutdown$1(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
        if (!completableResultCode.isSuccess() || !completableResultCode2.isSuccess()) {
            completableResultCode3.fail();
        } else {
            completableResultCode3.succeed();
        }
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final CompletableResultCode forceFlush() {
        return CompletableResultCode.ofAll(this.pendingExports);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleSpanProcessor{spanExporter=");
        sb.append(this.spanExporter);
        sb.append('}');
        return sb.toString();
    }
}
