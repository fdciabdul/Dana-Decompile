package io.opentelemetry.sdk.trace.export;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.DaemonThreadFactory;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.internal.JcTools;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class BatchSpanProcessor implements SpanProcessor {
    private static final AttributeKey<Boolean> SPAN_PROCESSOR_DROPPED_LABEL;
    private static final AttributeKey<String> SPAN_PROCESSOR_TYPE_LABEL;
    private static final String SPAN_PROCESSOR_TYPE_VALUE;
    private static final String WORKER_THREAD_NAME;
    private static final Logger logger = Logger.getLogger(BatchSpanProcessor.class.getName());
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
    private final Worker worker;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isEndRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isStartRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onStart(Context context, ReadWriteSpan readWriteSpan) {
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("BatchSpanProcessor");
        sb.append("_WorkerThread");
        WORKER_THREAD_NAME = sb.toString();
        SPAN_PROCESSOR_TYPE_LABEL = AttributeKey.CC.stringKey("spanProcessorType");
        SPAN_PROCESSOR_DROPPED_LABEL = AttributeKey.CC.booleanKey("dropped");
        SPAN_PROCESSOR_TYPE_VALUE = "BatchSpanProcessor";
    }

    public static BatchSpanProcessorBuilder builder(SpanExporter spanExporter) {
        return new BatchSpanProcessorBuilder(spanExporter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchSpanProcessor(SpanExporter spanExporter, MeterProvider meterProvider, long j, int i, int i2, long j2) {
        Worker worker = new Worker(spanExporter, meterProvider, j, i2, j2, JcTools.newFixedSizeQueue(i));
        this.worker = worker;
        new DaemonThreadFactory(WORKER_THREAD_NAME).newThread(worker).start();
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onEnd(ReadableSpan readableSpan) {
        if (readableSpan == null || !readableSpan.getSpanContext().isSampled()) {
            return;
        }
        this.worker.addSpan(readableSpan);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        return this.worker.shutdown();
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final CompletableResultCode forceFlush() {
        return this.worker.forceFlush();
    }

    final ArrayList<SpanData> getBatch() {
        return this.worker.batch;
    }

    final Queue<ReadableSpan> getQueue() {
        return this.worker.queue;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BatchSpanProcessor{spanExporter=");
        sb.append(this.worker.spanExporter);
        sb.append(", scheduleDelayNanos=");
        sb.append(this.worker.scheduleDelayNanos);
        sb.append(", maxExportBatchSize=");
        sb.append(this.worker.maxExportBatchSize);
        sb.append(", exporterTimeoutNanos=");
        sb.append(this.worker.exporterTimeoutNanos);
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Worker implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ArrayList<SpanData> batch;
        private volatile boolean continueWork;
        private final Attributes droppedAttrs;
        private final Attributes exportedAttrs;
        private final long exporterTimeoutNanos;
        private final AtomicReference<CompletableResultCode> flushRequested;
        private final int maxExportBatchSize;
        private long nextExportTime;
        private final LongCounter processedSpansCounter;
        private final Queue<ReadableSpan> queue;
        private final long scheduleDelayNanos;
        private final BlockingQueue<Boolean> signal;
        private final SpanExporter spanExporter;
        private final AtomicInteger spansNeeded;
        public static final byte[] getAuthRequestContext = {40, 6, -7, -65, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int PlaceComponentResult = 51;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                int r9 = r9 * 7
                int r9 = r9 + 99
                byte[] r0 = io.opentelemetry.sdk.trace.export.BatchSpanProcessor.Worker.getAuthRequestContext
                int r7 = r7 * 3
                int r7 = r7 + 13
                int r8 = r8 * 12
                int r8 = 15 - r8
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L1b
                r3 = r1
                r5 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                goto L37
            L1b:
                r3 = 0
            L1c:
                byte r4 = (byte) r9
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r7) goto L2b
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2b:
                int r8 = r8 + 1
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L37:
                int r7 = -r7
                int r10 = r10 + r7
                int r7 = r10 + 2
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                r6 = r9
                r9 = r7
                r7 = r8
                r8 = r6
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.trace.export.BatchSpanProcessor.Worker.a(int, byte, short, java.lang.Object[]):void");
        }

        private Worker(SpanExporter spanExporter, MeterProvider meterProvider, long j, int i, long j2, final Queue<ReadableSpan> queue) {
            this.spansNeeded = new AtomicInteger(Integer.MAX_VALUE);
            this.flushRequested = new AtomicReference<>();
            this.continueWork = true;
            this.spanExporter = spanExporter;
            this.scheduleDelayNanos = j;
            this.maxExportBatchSize = i;
            this.exporterTimeoutNanos = j2;
            this.queue = queue;
            this.signal = new ArrayBlockingQueue(1);
            Meter build = meterProvider.meterBuilder("io.opentelemetry.sdk.trace").build();
            build.gaugeBuilder("queueSize").ofLongs().setDescription("The number of spans queued").setUnit("1").buildWithCallback(new Consumer() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda3
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    Queue queue2 = queue;
                    ((ObservableLongMeasurement) obj).record(queue2.size(), Attributes.CC.of(BatchSpanProcessor.SPAN_PROCESSOR_TYPE_LABEL, BatchSpanProcessor.SPAN_PROCESSOR_TYPE_VALUE));
                }

                @Override // j$.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.PlaceComponentResult(this, consumer);
                }
            });
            this.processedSpansCounter = build.counterBuilder("processedSpans").setUnit("1").setDescription("The number of spans processed by the BatchSpanProcessor. [dropped=true if they were dropped due to high throughput]").build();
            this.droppedAttrs = Attributes.CC.of(BatchSpanProcessor.SPAN_PROCESSOR_TYPE_LABEL, BatchSpanProcessor.SPAN_PROCESSOR_TYPE_VALUE, BatchSpanProcessor.SPAN_PROCESSOR_DROPPED_LABEL, Boolean.TRUE);
            this.exportedAttrs = Attributes.CC.of(BatchSpanProcessor.SPAN_PROCESSOR_TYPE_LABEL, BatchSpanProcessor.SPAN_PROCESSOR_TYPE_VALUE, BatchSpanProcessor.SPAN_PROCESSOR_DROPPED_LABEL, Boolean.FALSE);
            this.batch = new ArrayList<>(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSpan(ReadableSpan readableSpan) {
            if (!this.queue.offer(readableSpan)) {
                this.processedSpansCounter.add(1L, this.droppedAttrs);
            } else if (this.queue.size() >= this.spansNeeded.get()) {
                this.signal.offer(Boolean.TRUE);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            updateNextExportTime();
            while (this.continueWork) {
                if (this.flushRequested.get() != null) {
                    flush();
                }
                JcTools.drain(this.queue, this.maxExportBatchSize - this.batch.size(), new Consumer() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        BatchSpanProcessor.Worker.this.m3163xa5528bf2((ReadableSpan) obj);
                    }

                    @Override // j$.util.function.Consumer
                    public final /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer.CC.PlaceComponentResult(this, consumer);
                    }
                });
                if (this.batch.size() >= this.maxExportBatchSize || System.nanoTime() >= this.nextExportTime) {
                    exportCurrentBatch();
                    updateNextExportTime();
                }
                if (this.queue.isEmpty()) {
                    try {
                        try {
                            long nanoTime = this.nextExportTime - System.nanoTime();
                            if (nanoTime > 0) {
                                this.spansNeeded.set(this.maxExportBatchSize - this.batch.size());
                                this.signal.poll(nanoTime, TimeUnit.NANOSECONDS);
                                this.spansNeeded.set(Integer.MAX_VALUE);
                            }
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (InterruptedException unused) {
                        byte b = (byte) (-getAuthRequestContext[15]);
                        Object[] objArr = new Object[1];
                        a(b, (byte) (b - 1), (byte) (-getAuthRequestContext[15]), objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b2 = (byte) (getAuthRequestContext[15] + 1);
                        byte b3 = (byte) (-getAuthRequestContext[15]);
                        Object[] objArr2 = new Object[1];
                        a(b2, b3, (byte) (b3 - 1), objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$1$io-opentelemetry-sdk-trace-export-BatchSpanProcessor$Worker  reason: not valid java name */
        public final /* synthetic */ void m3163xa5528bf2(ReadableSpan readableSpan) {
            this.batch.add(readableSpan.toSpanData());
        }

        private void flush() {
            int size = this.queue.size();
            while (size > 0) {
                this.batch.add(this.queue.poll().toSpanData());
                size--;
                if (this.batch.size() >= this.maxExportBatchSize) {
                    exportCurrentBatch();
                }
            }
            exportCurrentBatch();
            CompletableResultCode completableResultCode = this.flushRequested.get();
            if (completableResultCode != null) {
                completableResultCode.succeed();
                this.flushRequested.set(null);
            }
        }

        private void updateNextExportTime() {
            this.nextExportTime = System.nanoTime() + this.scheduleDelayNanos;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode shutdown() {
            final CompletableResultCode completableResultCode = new CompletableResultCode();
            final CompletableResultCode forceFlush = forceFlush();
            forceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BatchSpanProcessor.Worker.this.m3164xf1cce899(forceFlush, completableResultCode);
                }
            });
            return completableResultCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$shutdown$3$io-opentelemetry-sdk-trace-export-BatchSpanProcessor$Worker  reason: not valid java name */
        public final /* synthetic */ void m3164xf1cce899(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
            this.continueWork = false;
            final CompletableResultCode shutdown = this.spanExporter.shutdown();
            shutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BatchSpanProcessor.Worker.lambda$shutdown$2(CompletableResultCode.this, shutdown, completableResultCode2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$shutdown$2(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
            if (!completableResultCode.isSuccess() || !completableResultCode2.isSuccess()) {
                completableResultCode3.fail();
            } else {
                completableResultCode3.succeed();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode forceFlush() {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.flushRequested, null, new CompletableResultCode())) {
                this.signal.offer(Boolean.TRUE);
            }
            CompletableResultCode completableResultCode = this.flushRequested.get();
            return completableResultCode == null ? CompletableResultCode.ofSuccess() : completableResultCode;
        }

        private void exportCurrentBatch() {
            if (this.batch.isEmpty()) {
                return;
            }
            try {
                CompletableResultCode export = this.spanExporter.export(Collections.unmodifiableList(this.batch));
                export.join(this.exporterTimeoutNanos, TimeUnit.NANOSECONDS);
                if (!export.isSuccess()) {
                    BatchSpanProcessor.logger.log(Level.FINE, "Exporter failed");
                } else {
                    this.processedSpansCounter.add(this.batch.size(), this.exportedAttrs);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
