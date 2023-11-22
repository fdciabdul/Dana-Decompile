package io.opentelemetry.sdk.logs.export;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Ascii;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.DaemonThreadFactory;
import io.opentelemetry.sdk.logs.LogRecordProcessor;
import io.opentelemetry.sdk.logs.ReadWriteLogRecord;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
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

/* loaded from: classes9.dex */
public final class BatchLogRecordProcessor implements LogRecordProcessor {
    private static final AttributeKey<Boolean> LOG_RECORD_PROCESSOR_DROPPED_LABEL;
    private static final AttributeKey<String> LOG_RECORD_PROCESSOR_TYPE_LABEL;
    private static final String LOG_RECORD_PROCESSOR_TYPE_VALUE;
    private static final String WORKER_THREAD_NAME;
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
    private final Worker worker;

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("BatchLogRecordProcessor");
        sb.append("_WorkerThread");
        WORKER_THREAD_NAME = sb.toString();
        LOG_RECORD_PROCESSOR_TYPE_LABEL = AttributeKey.CC.stringKey("logRecordProcessorType");
        LOG_RECORD_PROCESSOR_DROPPED_LABEL = AttributeKey.CC.booleanKey("dropped");
        LOG_RECORD_PROCESSOR_TYPE_VALUE = "BatchLogRecordProcessor";
    }

    public static BatchLogRecordProcessorBuilder builder(LogRecordExporter logRecordExporter) {
        return new BatchLogRecordProcessorBuilder(logRecordExporter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchLogRecordProcessor(LogRecordExporter logRecordExporter, MeterProvider meterProvider, long j, int i, int i2, long j2) {
        Worker worker = new Worker(logRecordExporter, meterProvider, j, i2, j2, new ArrayBlockingQueue(i));
        this.worker = worker;
        new DaemonThreadFactory(WORKER_THREAD_NAME).newThread(worker).start();
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final void onEmit(ReadWriteLogRecord readWriteLogRecord) {
        if (readWriteLogRecord == null) {
            return;
        }
        this.worker.addLog(readWriteLogRecord);
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        return this.worker.shutdown();
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public final CompletableResultCode forceFlush() {
        return this.worker.forceFlush();
    }

    final ArrayList<LogRecordData> getBatch() {
        return this.worker.batch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class Worker implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {Ascii.EM, 108, 7, 61, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int MyBillsEntityDataFactory = 70;
        private static final Logger logger = Logger.getLogger(Worker.class.getName());
        private final ArrayList<LogRecordData> batch;
        private volatile boolean continueWork;
        private final Attributes droppedAttrs;
        private final Attributes exportedAttrs;
        private final long exporterTimeoutNanos;
        private final AtomicReference<CompletableResultCode> flushRequested;
        private final LogRecordExporter logRecordExporter;
        private final AtomicInteger logsNeeded;
        private final int maxExportBatchSize;
        private long nextExportTime;
        private final LongCounter processedLogsCounter;
        private final Queue<ReadWriteLogRecord> queue;
        private final long scheduleDelayNanos;
        private final BlockingQueue<Boolean> signal;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 3
                int r8 = 16 - r8
                int r6 = r6 * 7
                int r6 = r6 + 99
                byte[] r0 = io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor.Worker.BuiltInFictitiousFunctionClassFactory
                int r7 = r7 * 12
                int r7 = 15 - r7
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1c
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L37
            L1c:
                r3 = 0
            L1d:
                int r7 = r7 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L2e
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2e:
                r3 = r0[r7]
                r5 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L37:
                int r6 = r6 + r7
                int r6 = r6 + 2
                r7 = r8
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1d
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor.Worker.a(byte, byte, int, java.lang.Object[]):void");
        }

        private Worker(LogRecordExporter logRecordExporter, MeterProvider meterProvider, long j, int i, long j2, final Queue<ReadWriteLogRecord> queue) {
            this.logsNeeded = new AtomicInteger(Integer.MAX_VALUE);
            this.flushRequested = new AtomicReference<>();
            this.continueWork = true;
            this.logRecordExporter = logRecordExporter;
            this.scheduleDelayNanos = j;
            this.maxExportBatchSize = i;
            this.exporterTimeoutNanos = j2;
            this.queue = queue;
            this.signal = new ArrayBlockingQueue(1);
            Meter build = meterProvider.meterBuilder("io.opentelemetry.sdk.logs").build();
            build.gaugeBuilder("queueSize").ofLongs().setDescription("The number of logs queued").setUnit("1").buildWithCallback(new Consumer() { // from class: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor$Worker$$ExternalSyntheticLambda1
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    Queue queue2 = queue;
                    ((ObservableLongMeasurement) obj).record(queue2.size(), Attributes.CC.of(BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_LABEL, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_VALUE));
                }

                @Override // j$.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.PlaceComponentResult(this, consumer);
                }
            });
            this.processedLogsCounter = build.counterBuilder("processedLogs").setUnit("1").setDescription("The number of logs processed by the BatchLogRecordProcessor. [dropped=true if they were dropped due to high throughput]").build();
            this.droppedAttrs = Attributes.CC.of(BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_LABEL, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_VALUE, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_DROPPED_LABEL, Boolean.TRUE);
            this.exportedAttrs = Attributes.CC.of(BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_LABEL, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_VALUE, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_DROPPED_LABEL, Boolean.FALSE);
            this.batch = new ArrayList<>(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLog(ReadWriteLogRecord readWriteLogRecord) {
            if (!this.queue.offer(readWriteLogRecord)) {
                this.processedLogsCounter.add(1L, this.droppedAttrs);
            } else if (this.queue.size() >= this.logsNeeded.get()) {
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
                while (!this.queue.isEmpty() && this.batch.size() < this.maxExportBatchSize) {
                    this.batch.add(this.queue.poll().toLogRecordData());
                }
                if (this.batch.size() >= this.maxExportBatchSize || System.nanoTime() >= this.nextExportTime) {
                    exportCurrentBatch();
                    updateNextExportTime();
                }
                if (this.queue.isEmpty()) {
                    try {
                        try {
                            long nanoTime = this.nextExportTime - System.nanoTime();
                            if (nanoTime > 0) {
                                this.logsNeeded.set(this.maxExportBatchSize - this.batch.size());
                                this.signal.poll(nanoTime, TimeUnit.NANOSECONDS);
                                this.logsNeeded.set(Integer.MAX_VALUE);
                            }
                        } catch (InterruptedException unused) {
                            byte b = BuiltInFictitiousFunctionClassFactory[15];
                            byte b2 = (byte) (b - 1);
                            Object[] objArr = new Object[1];
                            a(b, b2, b2, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                            byte b4 = BuiltInFictitiousFunctionClassFactory[15];
                            Object[] objArr2 = new Object[1];
                            a(b3, b4, b4, objArr2);
                            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                            return;
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
            }
        }

        private void flush() {
            int size = this.queue.size();
            while (size > 0) {
                this.batch.add(this.queue.poll().toLogRecordData());
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
            forceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor$Worker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BatchLogRecordProcessor.Worker.this.m3155x434dbb(forceFlush, completableResultCode);
                }
            });
            return completableResultCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$shutdown$2$io-opentelemetry-sdk-logs-export-BatchLogRecordProcessor$Worker  reason: not valid java name */
        public final /* synthetic */ void m3155x434dbb(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
            this.continueWork = false;
            final CompletableResultCode shutdown = this.logRecordExporter.shutdown();
            shutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor$Worker$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BatchLogRecordProcessor.Worker.lambda$shutdown$1(CompletableResultCode.this, shutdown, completableResultCode2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$shutdown$1(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
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
                try {
                    CompletableResultCode export = this.logRecordExporter.export(Collections.unmodifiableList(this.batch));
                    export.join(this.exporterTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (export.isSuccess()) {
                        this.processedLogsCounter.add(this.batch.size(), this.exportedAttrs);
                    } else {
                        logger.log(Level.FINE, "Exporter failed");
                    }
                } catch (RuntimeException e) {
                    logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e);
                }
            } finally {
                this.batch.clear();
            }
        }
    }
}
