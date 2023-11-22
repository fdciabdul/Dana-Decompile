package io.opentelemetry.sdk.logs.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class MultiLogRecordExporter implements LogRecordExporter {
    private static final Logger logger = Logger.getLogger(MultiLogRecordExporter.class.getName());
    private final LogRecordExporter[] logRecordExporters;

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogRecordExporter create(List<LogRecordExporter> list) {
        return new MultiLogRecordExporter((LogRecordExporter[]) list.toArray(new LogRecordExporter[0]));
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public final CompletableResultCode export(Collection<LogRecordData> collection) {
        ArrayList arrayList = new ArrayList(this.logRecordExporters.length);
        for (LogRecordExporter logRecordExporter : this.logRecordExporters) {
            try {
                arrayList.add(logRecordExporter.export(collection));
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exception thrown by the export.", (Throwable) e);
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public final CompletableResultCode flush() {
        ArrayList arrayList = new ArrayList(this.logRecordExporters.length);
        for (LogRecordExporter logRecordExporter : this.logRecordExporters) {
            try {
                arrayList.add(logRecordExporter.flush());
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exception thrown by the flush.", (Throwable) e);
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public final CompletableResultCode shutdown() {
        ArrayList arrayList = new ArrayList(this.logRecordExporters.length);
        for (LogRecordExporter logRecordExporter : this.logRecordExporters) {
            try {
                arrayList.add(logRecordExporter.shutdown());
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exception thrown by the shutdown.", (Throwable) e);
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    private MultiLogRecordExporter(LogRecordExporter[] logRecordExporterArr) {
        this.logRecordExporters = logRecordExporterArr;
    }
}
