package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes9.dex */
public final class OkHttpTelemetry {
    private final Instrumenter<Request, Response> instrumenter;
    private final ContextPropagators propagators;

    public static OkHttpTelemetry create(OpenTelemetry openTelemetry) {
        return builder(openTelemetry).build();
    }

    public static OkHttpTelemetryBuilder builder(OpenTelemetry openTelemetry) {
        return new OkHttpTelemetryBuilder(openTelemetry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpTelemetry(Instrumenter<Request, Response> instrumenter, ContextPropagators contextPropagators) {
        this.instrumenter = instrumenter;
        this.propagators = contextPropagators;
    }

    @Deprecated
    public final Interceptor newInterceptor() {
        return new TracingInterceptor(this.instrumenter, this.propagators);
    }

    public final Call.Factory newCallFactory(OkHttpClient okHttpClient) {
        return new TracingCallFactory(okHttpClient.newBuilder().addInterceptor(newInterceptor()).build());
    }
}
