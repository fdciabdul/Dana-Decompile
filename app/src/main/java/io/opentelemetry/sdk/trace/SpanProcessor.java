package io.opentelemetry.sdk.trace;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface SpanProcessor extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CompletableResultCode forceFlush();

    boolean isEndRequired();

    boolean isStartRequired();

    void onEnd(ReadableSpan readableSpan);

    void onStart(Context context, ReadWriteSpan readWriteSpan);

    CompletableResultCode shutdown();

    /* renamed from: io.opentelemetry.sdk.trace.SpanProcessor$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static SpanProcessor composite(SpanProcessor... spanProcessorArr) {
            return composite(Arrays.asList(spanProcessorArr));
        }

        public static SpanProcessor composite(Iterable<SpanProcessor> iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator<SpanProcessor> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            if (arrayList.isEmpty()) {
                return NoopSpanProcessor.getInstance();
            }
            if (arrayList.size() == 1) {
                return (SpanProcessor) arrayList.get(0);
            }
            return MultiSpanProcessor.create(arrayList);
        }
    }
}
