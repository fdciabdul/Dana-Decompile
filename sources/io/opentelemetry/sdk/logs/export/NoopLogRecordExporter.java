package io.opentelemetry.sdk.logs.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class NoopLogRecordExporter implements LogRecordExporter {
    private static final LogRecordExporter INSTANCE = new NoopLogRecordExporter();

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    NoopLogRecordExporter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogRecordExporter getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public final CompletableResultCode export(Collection<LogRecordData> collection) {
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public final CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public final CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}
