package io.opentelemetry.sdk.trace;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MultiSpanProcessor implements SpanProcessor {
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
    private final List<SpanProcessor> spanProcessorsAll;
    private final List<SpanProcessor> spanProcessorsEnd;
    private final List<SpanProcessor> spanProcessorsStart;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanProcessor create(List<SpanProcessor> list) {
        return new MultiSpanProcessor(new ArrayList((Collection) Objects.requireNonNull(list, "spanProcessorList")));
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onStart(Context context, ReadWriteSpan readWriteSpan) {
        Iterator<SpanProcessor> it = this.spanProcessorsStart.iterator();
        while (it.hasNext()) {
            it.next().onStart(context, readWriteSpan);
        }
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isStartRequired() {
        return !this.spanProcessorsStart.isEmpty();
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onEnd(ReadableSpan readableSpan) {
        Iterator<SpanProcessor> it = this.spanProcessorsEnd.iterator();
        while (it.hasNext()) {
            it.next().onEnd(readableSpan);
        }
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isEndRequired() {
        return !this.spanProcessorsEnd.isEmpty();
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList(this.spanProcessorsAll.size());
        Iterator<SpanProcessor> it = this.spanProcessorsAll.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().shutdown());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final CompletableResultCode forceFlush() {
        ArrayList arrayList = new ArrayList(this.spanProcessorsAll.size());
        Iterator<SpanProcessor> it = this.spanProcessorsAll.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().forceFlush());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    private MultiSpanProcessor(List<SpanProcessor> list) {
        this.spanProcessorsAll = list;
        this.spanProcessorsStart = new ArrayList(list.size());
        this.spanProcessorsEnd = new ArrayList(list.size());
        for (SpanProcessor spanProcessor : list) {
            if (spanProcessor.isStartRequired()) {
                this.spanProcessorsStart.add(spanProcessor);
            }
            if (spanProcessor.isEndRequired()) {
                this.spanProcessorsEnd.add(spanProcessor);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiSpanProcessor{spanProcessorsStart=");
        sb.append(this.spanProcessorsStart);
        sb.append(", spanProcessorsEnd=");
        sb.append(this.spanProcessorsEnd);
        sb.append(", spanProcessorsAll=");
        sb.append(this.spanProcessorsAll);
        sb.append('}');
        return sb.toString();
    }
}
