package id.dana.rum.okhttp;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class OkHttpJsonRpcTracingInterceptor implements Interceptor {
    private final ContextPropagators MyBillsEntityDataFactory;
    private final Instrumenter<Request, Response> getAuthRequestContext;

    public OkHttpJsonRpcTracingInterceptor(Instrumenter<Request, Response> instrumenter, ContextPropagators contextPropagators) {
        this.getAuthRequestContext = instrumenter;
        this.MyBillsEntityDataFactory = contextPropagators;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Context PlaceComponentResult = OkHttpJsonRpcTracingCallFactory.PlaceComponentResult(request);
        if (PlaceComponentResult == null) {
            PlaceComponentResult = Context.CC.current();
        }
        if (!this.getAuthRequestContext.shouldStart(PlaceComponentResult, request)) {
            return chain.proceed(chain.request());
        }
        Context start = this.getAuthRequestContext.start(PlaceComponentResult, request);
        Request.Builder newBuilder = request.newBuilder();
        this.MyBillsEntityDataFactory.getTextMapPropagator().inject(start, newBuilder, OkHttpJsonRpcRequestHeaderSetter.INSTANCE);
        Request build = newBuilder.build();
        try {
            Scope makeCurrent = start.makeCurrent();
            try {
                Response proceed = chain.proceed(build);
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                this.getAuthRequestContext.end(start, build, proceed, null);
                return proceed;
            } finally {
            }
        } catch (Exception e) {
            this.getAuthRequestContext.end(start, build, null, e);
            throw e;
        }
    }
}
