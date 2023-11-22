package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.CompletableResultCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class MultiLogRecordProcessor implements LogRecordProcessor {
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
    private final List<LogRecordProcessor> logRecordProcessors;

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogRecordProcessor create(List<LogRecordProcessor> list) {
        return new MultiLogRecordProcessor(new ArrayList((Collection) Objects.requireNonNull(list, "logRecordProcessorsList")));
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final void onEmit(ReadWriteLogRecord readWriteLogRecord) {
        Iterator<LogRecordProcessor> it = this.logRecordProcessors.iterator();
        while (it.hasNext()) {
            it.next().onEmit(readWriteLogRecord);
        }
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList(this.logRecordProcessors.size());
        Iterator<LogRecordProcessor> it = this.logRecordProcessors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().shutdown());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final CompletableResultCode forceFlush() {
        ArrayList arrayList = new ArrayList(this.logRecordProcessors.size());
        Iterator<LogRecordProcessor> it = this.logRecordProcessors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().forceFlush());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    private MultiLogRecordProcessor(List<LogRecordProcessor> list) {
        this.logRecordProcessors = list;
    }
}
