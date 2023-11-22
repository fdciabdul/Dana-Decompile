package io.opentelemetry.sdk.logs.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.logs.LogRecordProcessor;
import io.opentelemetry.sdk.logs.ReadWriteLogRecord;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes9.dex */
public final class SimpleLogRecordProcessor implements LogRecordProcessor {
    private static final Logger logger = Logger.getLogger(SimpleLogRecordProcessor.class.getName());
    private final LogRecordExporter logRecordExporter;
    private final Set<CompletableResultCode> pendingExports = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public static LogRecordProcessor create(LogRecordExporter logRecordExporter) {
        Objects.requireNonNull(logRecordExporter, "exporter");
        return new SimpleLogRecordProcessor(logRecordExporter);
    }

    SimpleLogRecordProcessor(LogRecordExporter logRecordExporter) {
        this.logRecordExporter = (LogRecordExporter) Objects.requireNonNull(logRecordExporter, "logRecordExporter");
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final void onEmit(ReadWriteLogRecord readWriteLogRecord) {
        try {
            final CompletableResultCode export = this.logRecordExporter.export(Collections.singletonList(readWriteLogRecord.toLogRecordData()));
            this.pendingExports.add(export);
            export.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleLogRecordProcessor.this.m3156x14191179(export);
                }
            });
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onEmit$0$io-opentelemetry-sdk-logs-export-SimpleLogRecordProcessor  reason: not valid java name */
    public final /* synthetic */ void m3156x14191179(CompletableResultCode completableResultCode) {
        this.pendingExports.remove(completableResultCode);
        if (completableResultCode.isSuccess()) {
            return;
        }
        logger.log(Level.FINE, "Exporter failed");
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final CompletableResultCode forceFlush = forceFlush();
        forceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SimpleLogRecordProcessor.this.m3157x67979dbf(forceFlush, completableResultCode);
            }
        });
        return completableResultCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$shutdown$2$io-opentelemetry-sdk-logs-export-SimpleLogRecordProcessor  reason: not valid java name */
    public final /* synthetic */ void m3157x67979dbf(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
        final CompletableResultCode shutdown = this.logRecordExporter.shutdown();
        shutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SimpleLogRecordProcessor.lambda$shutdown$1(CompletableResultCode.this, shutdown, completableResultCode2);
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

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final CompletableResultCode forceFlush() {
        return CompletableResultCode.ofAll(this.pendingExports);
    }
}
