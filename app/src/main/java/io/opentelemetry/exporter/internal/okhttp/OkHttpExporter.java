package io.opentelemetry.exporter.internal.okhttp;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.exporter.internal.grpc.GrpcStatusUtil;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.retry.RetryUtil;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import j$.util.function.Function;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes9.dex */
public final class OkHttpExporter<T extends Marshaler> {
    private static final Logger internalLogger = Logger.getLogger(OkHttpExporter.class.getName());
    private final OkHttpClient client;
    private final boolean compressionEnabled;
    private final ExporterMetrics exporterMetrics;
    @Nullable
    private final Headers headers;
    private final ThrottlingLogger logger = new ThrottlingLogger(internalLogger);
    private final Function<T, RequestBody> requestBodyCreator;
    private final String type;
    private final HttpUrl url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpExporter(String str, String str2, OkHttpClient okHttpClient, MeterProvider meterProvider, String str3, @Nullable Headers headers, boolean z, boolean z2) {
        ExporterMetrics createHttpProtobuf;
        this.type = str2;
        this.client = okHttpClient;
        this.url = HttpUrl.get(str3);
        this.headers = headers;
        this.compressionEnabled = z;
        this.requestBodyCreator = z2 ? new Function() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return new JsonRequestBody((Marshaler) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        } : new Function() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return new ProtoRequestBody((Marshaler) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        };
        if (z2) {
            createHttpProtobuf = ExporterMetrics.createHttpJson(str, str2, meterProvider);
        } else {
            createHttpProtobuf = ExporterMetrics.createHttpProtobuf(str, str2, meterProvider);
        }
        this.exporterMetrics = createHttpProtobuf;
    }

    public final CompletableResultCode export(T t, final int i) {
        this.exporterMetrics.addSeen(i);
        Request.Builder url = new Request.Builder().url(this.url);
        Headers headers = this.headers;
        if (headers != null) {
            url.headers(headers);
        }
        RequestBody apply = this.requestBodyCreator.apply(t);
        if (this.compressionEnabled) {
            url.addHeader("Content-Encoding", HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
            url.post(gzipRequestBody(apply));
        } else {
            url.post(apply);
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        this.client.newCall(url.build()).enqueue(new Callback() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpExporter.this.exporterMetrics.addFailed(i);
                ThrottlingLogger throttlingLogger = OkHttpExporter.this.logger;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to export ");
                sb.append(OkHttpExporter.this.type);
                sb.append("s. The request could not be executed. Full error message: ");
                sb.append(iOException.getMessage());
                throttlingLogger.log(level, sb.toString());
                completableResultCode.fail();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                ResponseBody body = response.body();
                try {
                    if (response.isSuccessful()) {
                        OkHttpExporter.this.exporterMetrics.addSuccess(i);
                        completableResultCode.succeed();
                        if (body != null) {
                            body.close();
                            return;
                        }
                        return;
                    }
                    OkHttpExporter.this.exporterMetrics.addFailed(i);
                    int code = response.code();
                    String extractErrorStatus = OkHttpExporter.extractErrorStatus(response, body);
                    ThrottlingLogger throttlingLogger = OkHttpExporter.this.logger;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to export ");
                    sb.append(OkHttpExporter.this.type);
                    sb.append("s. Server responded with HTTP status code ");
                    sb.append(code);
                    sb.append(". Error message: ");
                    sb.append(extractErrorStatus);
                    throttlingLogger.log(level, sb.toString());
                    completableResultCode.fail();
                    if (body != null) {
                        body.close();
                    }
                } catch (Throwable th) {
                    if (body != null) {
                        try {
                            body.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        });
        return completableResultCode;
    }

    public final CompletableResultCode shutdown() {
        CompletableResultCode ofSuccess = CompletableResultCode.ofSuccess();
        this.client.dispatcher().cancelAll();
        this.client.dispatcher().executorService().shutdownNow();
        this.client.connectionPool().evictAll();
        return ofSuccess;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isRetryable(Response response) {
        return RetryUtil.retryableHttpResponseCodes().contains(Integer.valueOf(response.code()));
    }

    private static RequestBody gzipRequestBody(final RequestBody requestBody) {
        return new RequestBody() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporter.2
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return RequestBody.this.contentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(new GzipSink(bufferedSink));
                RequestBody.this.writeTo(BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory.close();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String extractErrorStatus(Response response, @Nullable ResponseBody responseBody) {
        if (responseBody == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Response body missing, HTTP status message: ");
            sb.append(response.message());
            return sb.toString();
        }
        try {
            return GrpcStatusUtil.getStatusMessage(responseBody.bytes());
        } catch (IOException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to parse response body, HTTP status message: ");
            sb2.append(response.message());
            return sb2.toString();
        }
    }
}
