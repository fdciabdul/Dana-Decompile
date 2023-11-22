package io.opentelemetry.exporter.logging;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class LoggingSpanExporter implements SpanExporter {
    private static final Logger logger = Logger.getLogger(LoggingSpanExporter.class.getName());

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public static LoggingSpanExporter create() {
        return new LoggingSpanExporter();
    }

    @Deprecated
    public LoggingSpanExporter() {
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode export(Collection<SpanData> collection) {
        StringBuilder sb = new StringBuilder(60);
        for (SpanData spanData : collection) {
            sb.setLength(0);
            InstrumentationScopeInfo instrumentationScopeInfo = spanData.getInstrumentationScopeInfo();
            sb.append("'");
            sb.append(spanData.getName());
            sb.append("' : ");
            sb.append(spanData.getTraceId());
            sb.append(" ");
            sb.append(spanData.getSpanId());
            sb.append(" ");
            sb.append(spanData.getKind());
            sb.append(" [tracer: ");
            sb.append(instrumentationScopeInfo.getName());
            sb.append(":");
            sb.append(instrumentationScopeInfo.getVersion() == null ? "" : instrumentationScopeInfo.getVersion());
            sb.append("] ");
            sb.append(spanData.getAttributes());
            logger.log(Level.INFO, sb.toString());
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode flush() {
        CompletableResultCode completableResultCode = new CompletableResultCode();
        for (Handler handler : logger.getHandlers()) {
            try {
                handler.flush();
            } catch (Throwable unused) {
                completableResultCode.fail();
            }
        }
        return completableResultCode.succeed();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode shutdown() {
        return flush();
    }
}
