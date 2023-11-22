package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.CompletableResultCode;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes6.dex */
public interface LogRecordProcessor extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CompletableResultCode forceFlush();

    void onEmit(ReadWriteLogRecord readWriteLogRecord);

    CompletableResultCode shutdown();

    /* renamed from: io.opentelemetry.sdk.logs.LogRecordProcessor$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static LogRecordProcessor composite(LogRecordProcessor... logRecordProcessorArr) {
            return composite(Arrays.asList(logRecordProcessorArr));
        }

        public static LogRecordProcessor composite(Iterable<LogRecordProcessor> iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator<LogRecordProcessor> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            if (arrayList.isEmpty()) {
                return NoopLogRecordProcessor.getInstance();
            }
            if (arrayList.size() == 1) {
                return (LogRecordProcessor) arrayList.get(0);
            }
            return MultiLogRecordProcessor.create(arrayList);
        }
    }
}
