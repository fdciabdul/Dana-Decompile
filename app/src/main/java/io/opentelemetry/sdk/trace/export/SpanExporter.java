package io.opentelemetry.sdk.trace.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public interface SpanExporter extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CompletableResultCode export(Collection<SpanData> collection);

    CompletableResultCode flush();

    CompletableResultCode shutdown();

    /* renamed from: io.opentelemetry.sdk.trace.export.SpanExporter$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static SpanExporter composite(SpanExporter... spanExporterArr) {
            return composite(Arrays.asList(spanExporterArr));
        }

        public static SpanExporter composite(Iterable<SpanExporter> iterable) {
            ArrayList arrayList = new ArrayList();
            Iterator<SpanExporter> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            if (arrayList.isEmpty()) {
                return NoopSpanExporter.getInstance();
            }
            if (arrayList.size() == 1) {
                return (SpanExporter) arrayList.get(0);
            }
            return MultiSpanExporter.create(arrayList);
        }
    }
}
