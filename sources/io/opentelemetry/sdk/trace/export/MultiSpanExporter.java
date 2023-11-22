package io.opentelemetry.sdk.trace.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class MultiSpanExporter implements SpanExporter {
    private static final Logger logger = Logger.getLogger(MultiSpanExporter.class.getName());
    private final SpanExporter[] spanExporters;

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanExporter create(List<SpanExporter> list) {
        return new MultiSpanExporter((SpanExporter[]) list.toArray(new SpanExporter[0]));
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode export(Collection<SpanData> collection) {
        ArrayList arrayList = new ArrayList(this.spanExporters.length);
        for (SpanExporter spanExporter : this.spanExporters) {
            try {
                arrayList.add(spanExporter.export(collection));
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exception thrown by the export.", (Throwable) e);
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode flush() {
        ArrayList arrayList = new ArrayList(this.spanExporters.length);
        for (SpanExporter spanExporter : this.spanExporters) {
            try {
                arrayList.add(spanExporter.flush());
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exception thrown by the flush.", (Throwable) e);
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode shutdown() {
        ArrayList arrayList = new ArrayList(this.spanExporters.length);
        for (SpanExporter spanExporter : this.spanExporters) {
            try {
                arrayList.add(spanExporter.shutdown());
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exception thrown by the shutdown.", (Throwable) e);
                arrayList.add(CompletableResultCode.ofFailure());
            }
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    private MultiSpanExporter(SpanExporter[] spanExporterArr) {
        this.spanExporters = spanExporterArr;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiSpanExporter{spanExporters=");
        sb.append(Arrays.toString(this.spanExporters));
        sb.append('}');
        return sb.toString();
    }
}
