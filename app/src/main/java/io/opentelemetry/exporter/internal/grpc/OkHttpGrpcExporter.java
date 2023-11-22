package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.retry.RetryUtil;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes9.dex */
public final class OkHttpGrpcExporter<T extends Marshaler> implements GrpcExporter<T> {
    private static final String GRPC_MESSAGE = "grpc-message";
    private static final String GRPC_STATUS = "grpc-status";
    private static final Logger internalLogger = Logger.getLogger(OkHttpGrpcExporter.class.getName());
    private final OkHttpClient client;
    private final boolean compressionEnabled;
    private final ExporterMetrics exporterMetrics;
    private final Headers headers;
    private final String type;
    private final HttpUrl url;
    private final ThrottlingLogger logger = new ThrottlingLogger(internalLogger);
    private final AtomicBoolean loggedUnimplemented = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpGrpcExporter(String str, String str2, OkHttpClient okHttpClient, MeterProvider meterProvider, String str3, Headers headers, boolean z) {
        this.type = str2;
        this.exporterMetrics = ExporterMetrics.createGrpcOkHttp(str, str2, meterProvider);
        this.client = okHttpClient;
        this.url = HttpUrl.get(str3);
        this.headers = headers;
        this.compressionEnabled = z;
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public final CompletableResultCode export(T t, final int i) {
        this.exporterMetrics.addSeen(i);
        Request.Builder headers = new Request.Builder().url(this.url).headers(this.headers);
        headers.post(new GrpcRequestBody(t, this.compressionEnabled));
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        this.client.newCall(headers.build()).enqueue(new Callback() { // from class: io.opentelemetry.exporter.internal.grpc.OkHttpGrpcExporter.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpGrpcExporter.this.exporterMetrics.addFailed(i);
                ThrottlingLogger throttlingLogger = OkHttpGrpcExporter.this.logger;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to export ");
                sb.append(OkHttpGrpcExporter.this.type);
                sb.append("s. The request could not be executed. Full error message: ");
                sb.append(iOException.getMessage());
                throttlingLogger.log(level, sb.toString());
                completableResultCode.fail();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String obj;
                try {
                    response.body().bytes();
                    String grpcStatus = OkHttpGrpcExporter.grpcStatus(response);
                    if ("0".equals(grpcStatus)) {
                        OkHttpGrpcExporter.this.exporterMetrics.addSuccess(i);
                        completableResultCode.succeed();
                        return;
                    }
                    OkHttpGrpcExporter.this.exporterMetrics.addFailed(i);
                    if (grpcStatus != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("gRPC status code ");
                        sb.append(grpcStatus);
                        obj = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("HTTP status code ");
                        sb2.append(response.code());
                        obj = sb2.toString();
                    }
                    String grpcMessage = OkHttpGrpcExporter.grpcMessage(response);
                    if ("12".equals(grpcStatus)) {
                        if (OkHttpGrpcExporter.this.loggedUnimplemented.compareAndSet(false, true)) {
                            GrpcExporterUtil.logUnimplemented(OkHttpGrpcExporter.internalLogger, OkHttpGrpcExporter.this.type, grpcMessage);
                        }
                    } else if ("14".equals(grpcStatus)) {
                        ThrottlingLogger throttlingLogger = OkHttpGrpcExporter.this.logger;
                        Level level = Level.SEVERE;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to export ");
                        sb3.append(OkHttpGrpcExporter.this.type);
                        sb3.append("s. Server is UNAVAILABLE. Make sure your collector is running and reachable from this network. Full error message:");
                        sb3.append(grpcMessage);
                        throttlingLogger.log(level, sb3.toString());
                    } else {
                        ThrottlingLogger throttlingLogger2 = OkHttpGrpcExporter.this.logger;
                        Level level2 = Level.WARNING;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Failed to export ");
                        sb4.append(OkHttpGrpcExporter.this.type);
                        sb4.append("s. Server responded with ");
                        sb4.append(obj);
                        sb4.append(". Error message: ");
                        sb4.append(grpcMessage);
                        throttlingLogger2.log(level2, sb4.toString());
                    }
                    completableResultCode.fail();
                } catch (IOException e) {
                    ThrottlingLogger throttlingLogger3 = OkHttpGrpcExporter.this.logger;
                    Level level3 = Level.WARNING;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Failed to export ");
                    sb5.append(OkHttpGrpcExporter.this.type);
                    sb5.append("s, could not consume server response.");
                    throttlingLogger3.log(level3, sb5.toString(), e);
                    OkHttpGrpcExporter.this.exporterMetrics.addFailed(i);
                    completableResultCode.fail();
                }
            }
        });
        return completableResultCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String grpcStatus(Response response) {
        String header = response.header(GRPC_STATUS);
        if (header == null) {
            try {
                return response.trailers().get(GRPC_STATUS);
            } catch (IOException unused) {
                return null;
            }
        }
        return header;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String grpcMessage(Response response) {
        String header = response.header(GRPC_MESSAGE);
        if (header == null) {
            try {
                header = response.trailers().get(GRPC_MESSAGE);
            } catch (IOException unused) {
            }
        }
        if (header != null) {
            return unescape(header);
        }
        return response.message();
    }

    @Override // io.opentelemetry.exporter.internal.grpc.GrpcExporter
    public final CompletableResultCode shutdown() {
        this.client.dispatcher().cancelAll();
        this.client.dispatcher().executorService().shutdownNow();
        this.client.connectionPool().evictAll();
        return CompletableResultCode.ofSuccess();
    }

    public static boolean isRetryable(Response response) {
        if (response.isSuccessful()) {
            return RetryUtil.retryableGrpcStatusCodes().contains(response.header(GRPC_STATUS));
        }
        return false;
    }

    private static String unescape(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt >= '~' || (charAt == '%' && i + 2 < str.length())) {
                return doUnescape(str.getBytes(StandardCharsets.US_ASCII));
            }
        }
        return str;
    }

    private static String doUnescape(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        int i = 0;
        while (i < bArr.length) {
            if (bArr[i] == 37 && i + 2 < bArr.length) {
                try {
                    allocate.put((byte) Integer.parseInt(new String(bArr, i + 1, 2, StandardCharsets.UTF_8), 16));
                    i += 3;
                } catch (NumberFormatException unused) {
                }
            }
            allocate.put(bArr[i]);
            i++;
        }
        return new String(allocate.array(), 0, allocate.position(), StandardCharsets.UTF_8);
    }
}
