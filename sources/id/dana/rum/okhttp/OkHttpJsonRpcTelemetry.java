package id.dana.rum.okhttp;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class OkHttpJsonRpcTelemetry {
    public final ContextPropagators BuiltInFictitiousFunctionClassFactory;
    public final Instrumenter<Request, Response> getAuthRequestContext;

    public static OkHttpJsonRpcTelemetryBuilder MyBillsEntityDataFactory(OpenTelemetry openTelemetry) {
        return new OkHttpJsonRpcTelemetryBuilder(openTelemetry);
    }

    public OkHttpJsonRpcTelemetry(Instrumenter<Request, Response> instrumenter, ContextPropagators contextPropagators) {
        this.getAuthRequestContext = instrumenter;
        this.BuiltInFictitiousFunctionClassFactory = contextPropagators;
    }
}
