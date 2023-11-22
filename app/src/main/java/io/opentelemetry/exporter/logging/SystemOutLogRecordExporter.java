package io.opentelemetry.exporter.logging;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;
import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class SystemOutLogRecordExporter implements LogRecordExporter {
    private static final DateTimeFormatter ISO_FORMAT = DateTimeFormatter.PlaceComponentResult;

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public static SystemOutLogRecordExporter create() {
        return new SystemOutLogRecordExporter();
    }

    private SystemOutLogRecordExporter() {
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode export(Collection<LogRecordData> collection) {
        StringBuilder sb = new StringBuilder(60);
        for (LogRecordData logRecordData : collection) {
            sb.setLength(0);
            formatLog(sb, logRecordData);
            System.out.println(sb);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    static void formatLog(StringBuilder sb, LogRecordData logRecordData) {
        InstrumentationScopeInfo instrumentationScopeInfo = logRecordData.getInstrumentationScopeInfo();
        sb.append(ISO_FORMAT.MyBillsEntityDataFactory(Instant.ofEpochMilli(TimeUnit.NANOSECONDS.toMillis(logRecordData.getEpochNanos())).atZone(ZoneOffset.UTC)));
        sb.append(" ");
        sb.append(logRecordData.getSeverity());
        sb.append(" '");
        sb.append(logRecordData.getBody().asString());
        sb.append("' : ");
        sb.append(logRecordData.getSpanContext().getTraceId());
        sb.append(" ");
        sb.append(logRecordData.getSpanContext().getSpanId());
        sb.append(" [scopeInfo: ");
        sb.append(instrumentationScopeInfo.getName());
        sb.append(":");
        sb.append(instrumentationScopeInfo.getVersion() == null ? "" : instrumentationScopeInfo.getVersion());
        sb.append("] ");
        sb.append(logRecordData.getAttributes());
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}
