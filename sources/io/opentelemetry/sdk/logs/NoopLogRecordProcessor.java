package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.CompletableResultCode;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class NoopLogRecordProcessor implements LogRecordProcessor {
    private static final NoopLogRecordProcessor INSTANCE = new NoopLogRecordProcessor();

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final /* synthetic */ CompletableResultCode forceFlush() {
        CompletableResultCode ofSuccess;
        ofSuccess = CompletableResultCode.ofSuccess();
        return ofSuccess;
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final void onEmit(ReadWriteLogRecord readWriteLogRecord) {
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final /* synthetic */ CompletableResultCode shutdown() {
        CompletableResultCode forceFlush;
        forceFlush = forceFlush();
        return forceFlush;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogRecordProcessor getInstance() {
        return INSTANCE;
    }

    private NoopLogRecordProcessor() {
    }
}
