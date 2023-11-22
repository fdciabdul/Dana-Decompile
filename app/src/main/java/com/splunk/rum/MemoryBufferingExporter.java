package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MemoryBufferingExporter implements SpanExporter {
    private final ConnectionUtil BuiltInFictitiousFunctionClassFactory;
    private final SpanExporter KClassImpl$Data$declaredNonStaticMembers$2;
    final MemorySpanBuffer MyBillsEntityDataFactory;

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryBufferingExporter(ConnectionUtil connectionUtil, SpanExporter spanExporter, MemorySpanBuffer memorySpanBuffer) {
        this.BuiltInFictitiousFunctionClassFactory = connectionUtil;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spanExporter;
        this.MyBillsEntityDataFactory = memorySpanBuffer;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(collection);
        if (!this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Network offline, buffering ");
            sb.append(collection.size());
            sb.append(" spans for eventual export.");
            InstrumentInjector.log_i("SplunkRum", sb.toString());
            return CompletableResultCode.ofSuccess();
        }
        final List<SpanData> PlaceComponentResult = this.MyBillsEntityDataFactory.PlaceComponentResult();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending ");
        sb2.append(PlaceComponentResult.size());
        sb2.append(" spans for export");
        InstrumentInjector.log_d("SplunkRum", sb2.toString());
        final CompletableResultCode export = this.KClassImpl$Data$declaredNonStaticMembers$2.export(PlaceComponentResult);
        export.whenComplete(new Runnable() { // from class: com.splunk.rum.MemoryBufferingExporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MemoryBufferingExporter memoryBufferingExporter = MemoryBufferingExporter.this;
                CompletableResultCode completableResultCode = export;
                List<SpanData> list = PlaceComponentResult;
                if (completableResultCode.isSuccess()) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Export failed. adding ");
                sb3.append(list.size());
                sb3.append(" spans to the backlog");
                InstrumentInjector.log_i("SplunkRum", sb3.toString());
                for (SpanData spanData : list) {
                    if (memoryBufferingExporter.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory() < 100) {
                        memoryBufferingExporter.MyBillsEntityDataFactory.MyBillsEntityDataFactory(spanData);
                    }
                }
            }
        });
        return export;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        if (!this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return export(this.MyBillsEntityDataFactory.PlaceComponentResult());
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        this.MyBillsEntityDataFactory.getAuthRequestContext();
        return this.KClassImpl$Data$declaredNonStaticMembers$2.shutdown();
    }
}
