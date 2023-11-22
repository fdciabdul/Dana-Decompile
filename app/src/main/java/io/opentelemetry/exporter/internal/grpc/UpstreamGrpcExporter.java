package io.opentelemetry.exporter.internal.grpc;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes9.dex */
public final class UpstreamGrpcExporter<T extends Marshaler> implements GrpcExporter<T> {
    private static final Logger internalLogger = Logger.getLogger(UpstreamGrpcExporter.class.getName());
    private final ExporterMetrics exporterMetrics;
    private final MarshalerServiceStub<T, ?, ?> stub;
    private final long timeoutNanos;
    private final String type;
    private final ThrottlingLogger logger = new ThrottlingLogger(internalLogger);
    private final AtomicBoolean loggedUnimplemented = new AtomicBoolean();

    public UpstreamGrpcExporter(String str, String str2, MarshalerServiceStub<T, ?, ?> marshalerServiceStub, MeterProvider meterProvider, long j) {
        this.type = str2;
        this.exporterMetrics = ExporterMetrics.createGrpc(str, str2, meterProvider);
        this.timeoutNanos = j;
        this.stub = marshalerServiceStub;
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public final CompletableResultCode export(T t, final int i) {
        this.exporterMetrics.addSeen(i);
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        MarshalerServiceStub<T, ?, ?> marshalerServiceStub = this.stub;
        long j = this.timeoutNanos;
        if (j > 0) {
            marshalerServiceStub = (MarshalerServiceStub) marshalerServiceStub.withDeadlineAfter(j, TimeUnit.NANOSECONDS);
        }
        Futures.addCallback(marshalerServiceStub.export(t), new FutureCallback<Object>() { // from class: io.opentelemetry.exporter.internal.grpc.UpstreamGrpcExporter.1
            {
                UpstreamGrpcExporter.this = this;
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Object obj) {
                UpstreamGrpcExporter.this.exporterMetrics.addSuccess(i);
                completableResultCode.succeed();
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                UpstreamGrpcExporter.this.exporterMetrics.addFailed(i);
                Status fromThrowable = Status.fromThrowable(th);
                int i2 = AnonymousClass2.$SwitchMap$io$grpc$Status$Code[fromThrowable.getCode().ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        ThrottlingLogger throttlingLogger = UpstreamGrpcExporter.this.logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to export ");
                        sb.append(UpstreamGrpcExporter.this.type);
                        sb.append("s. Server responded with gRPC status code ");
                        sb.append(fromThrowable.getCode().value());
                        sb.append(". Error message: ");
                        sb.append(fromThrowable.getDescription());
                        throttlingLogger.log(level, sb.toString());
                    } else {
                        ThrottlingLogger throttlingLogger2 = UpstreamGrpcExporter.this.logger;
                        Level level2 = Level.SEVERE;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to export ");
                        sb2.append(UpstreamGrpcExporter.this.type);
                        sb2.append("s. Server is UNAVAILABLE. Make sure your collector is running and reachable from this network. Full error message:");
                        sb2.append(fromThrowable.getDescription());
                        throttlingLogger2.log(level2, sb2.toString());
                    }
                } else if (UpstreamGrpcExporter.this.loggedUnimplemented.compareAndSet(false, true)) {
                    GrpcExporterUtil.logUnimplemented(UpstreamGrpcExporter.internalLogger, UpstreamGrpcExporter.this.type, fromThrowable.getDescription());
                }
                if (UpstreamGrpcExporter.this.logger.isLoggable(Level.FINEST)) {
                    ThrottlingLogger throttlingLogger3 = UpstreamGrpcExporter.this.logger;
                    Level level3 = Level.FINEST;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Failed to export ");
                    sb3.append(UpstreamGrpcExporter.this.type);
                    sb3.append("s. Details follow: ");
                    sb3.append(th);
                    throttlingLogger3.log(level3, sb3.toString());
                }
                completableResultCode.fail();
            }
        }, MoreExecutors.directExecutor());
        return completableResultCode;
    }

    /* renamed from: io.opentelemetry.exporter.internal.grpc.UpstreamGrpcExporter$2 */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$Status$Code;

        static {
            int[] iArr = new int[Status.Code.values().length];
            $SwitchMap$io$grpc$Status$Code = iArr;
            try {
                iArr[Status.Code.UNIMPLEMENTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$Status$Code[Status.Code.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public final CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}
