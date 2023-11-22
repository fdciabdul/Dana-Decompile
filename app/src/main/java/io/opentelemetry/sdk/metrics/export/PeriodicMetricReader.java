package io.opentelemetry.sdk.metrics.export;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.metrics.internal.export.MetricProducer;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class PeriodicMetricReader implements MetricReader {
    private final MetricExporter exporter;
    private final long intervalNanos;
    private final Object lock = new Object();
    private volatile MetricProducer metricProducer = MetricProducer.CC.noop();
    private final Scheduled scheduled = new Scheduled();
    @Nullable
    private volatile ScheduledFuture<?> scheduledFuture;
    private final ScheduledExecutorService scheduler;
    public static final byte[] PlaceComponentResult = {Ascii.EM, 108, 7, 61, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 31;
    private static final Logger logger = Logger.getLogger(PeriodicMetricReader.class.getName());

    private static void a(byte b, short s, int i, Object[] objArr) {
        int i2 = 106 - (s * 7);
        int i3 = (b * 12) + 4;
        int i4 = 16 - (i * 3);
        byte[] bArr = PlaceComponentResult;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            int i7 = i6 + (-i3) + 2;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i2 = i7;
            i3++;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i2;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i3];
            int i9 = i2;
            int i10 = i3 + 1;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
            i2 = i9 + (-b2) + 2;
            i3 = i10;
        }
    }

    @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    public final /* synthetic */ DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
        return DefaultAggregationSelector.CC.$default$with(this, instrumentType, aggregation);
    }

    public static PeriodicMetricReader create(MetricExporter metricExporter) {
        return builder(metricExporter).build();
    }

    public static PeriodicMetricReaderBuilder builder(MetricExporter metricExporter) {
        return new PeriodicMetricReaderBuilder(metricExporter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PeriodicMetricReader(MetricExporter metricExporter, long j, ScheduledExecutorService scheduledExecutorService) {
        this.exporter = metricExporter;
        this.intervalNanos = j;
        this.scheduler = scheduledExecutorService;
    }

    @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
    public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        return this.exporter.getAggregationTemporality(instrumentType);
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricReader, io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    public final Aggregation getDefaultAggregation(InstrumentType instrumentType) {
        return this.exporter.getDefaultAggregation(instrumentType);
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricReader
    public final CompletableResultCode forceFlush() {
        return this.scheduled.doRun();
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricReader
    public final CompletableResultCode shutdown() {
        final CompletableResultCode shutdown;
        Runnable runnable;
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.scheduler.shutdown();
        try {
            try {
                this.scheduler.awaitTermination(5L, TimeUnit.SECONDS);
                this.scheduled.doRun().join(5L, TimeUnit.SECONDS);
                shutdown = this.scheduled.shutdown();
                runnable = new Runnable() { // from class: io.opentelemetry.sdk.metrics.export.PeriodicMetricReader$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PeriodicMetricReader.lambda$shutdown$0(CompletableResultCode.this, completableResultCode);
                    }
                };
            } catch (InterruptedException unused) {
                this.scheduler.shutdownNow();
                try {
                    byte b = (byte) (-PlaceComponentResult[15]);
                    byte b2 = (byte) (b - 1);
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (PlaceComponentResult[15] + 1);
                    byte b4 = (byte) (-PlaceComponentResult[15]);
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    shutdown = this.scheduled.shutdown();
                    runnable = new Runnable() { // from class: io.opentelemetry.sdk.metrics.export.PeriodicMetricReader$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PeriodicMetricReader.lambda$shutdown$0(CompletableResultCode.this, completableResultCode);
                        }
                    };
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            shutdown.whenComplete(runnable);
            return completableResultCode;
        } catch (Throwable th2) {
            final CompletableResultCode shutdown2 = this.scheduled.shutdown();
            shutdown2.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.metrics.export.PeriodicMetricReader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PeriodicMetricReader.lambda$shutdown$0(CompletableResultCode.this, completableResultCode);
                }
            });
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$shutdown$0(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2) {
        if (!completableResultCode.isSuccess()) {
            completableResultCode2.fail();
        } else {
            completableResultCode2.succeed();
        }
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricReader
    public final void register(CollectionRegistration collectionRegistration) {
        this.metricProducer = MetricProducer.CC.asMetricProducer(collectionRegistration);
        start();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PeriodicMetricReader{exporter=");
        sb.append(this.exporter);
        sb.append(", intervalNanos=");
        sb.append(this.intervalNanos);
        sb.append('}');
        return sb.toString();
    }

    final void start() {
        synchronized (this.lock) {
            if (this.scheduledFuture != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService = this.scheduler;
            Scheduled scheduled = this.scheduled;
            long j = this.intervalNanos;
            this.scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(scheduled, j, j, TimeUnit.NANOSECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public final class Scheduled implements Runnable {
        private final AtomicBoolean exportAvailable;

        private Scheduled() {
            this.exportAvailable = new AtomicBoolean(true);
        }

        @Override // java.lang.Runnable
        public final void run() {
            doRun();
        }

        final CompletableResultCode doRun() {
            final CompletableResultCode completableResultCode = new CompletableResultCode();
            if (this.exportAvailable.compareAndSet(true, false)) {
                try {
                    Collection<MetricData> collectAllMetrics = PeriodicMetricReader.this.metricProducer.collectAllMetrics();
                    if (collectAllMetrics.isEmpty()) {
                        PeriodicMetricReader.logger.log(Level.FINE, "No metric data to export - skipping export.");
                        completableResultCode.succeed();
                        this.exportAvailable.set(true);
                    } else {
                        final CompletableResultCode export = PeriodicMetricReader.this.exporter.export(collectAllMetrics);
                        export.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.metrics.export.PeriodicMetricReader$Scheduled$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                PeriodicMetricReader.Scheduled.this.m3159x322aab83(export, completableResultCode);
                            }
                        });
                    }
                } catch (Throwable th) {
                    this.exportAvailable.set(true);
                    PeriodicMetricReader.logger.log(Level.WARNING, "Exporter threw an Exception", th);
                    completableResultCode.fail();
                }
            } else {
                PeriodicMetricReader.logger.log(Level.FINE, "Exporter busy. Dropping metrics.");
                completableResultCode.fail();
            }
            return completableResultCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$doRun$0$io-opentelemetry-sdk-metrics-export-PeriodicMetricReader$Scheduled  reason: not valid java name */
        public final /* synthetic */ void m3159x322aab83(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2) {
            if (!completableResultCode.isSuccess()) {
                PeriodicMetricReader.logger.log(Level.FINE, "Exporter failed");
            }
            completableResultCode2.succeed();
            this.exportAvailable.set(true);
        }

        final CompletableResultCode shutdown() {
            return PeriodicMetricReader.this.exporter.shutdown();
        }
    }
}
