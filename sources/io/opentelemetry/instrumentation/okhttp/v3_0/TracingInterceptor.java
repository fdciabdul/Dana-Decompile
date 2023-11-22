package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes9.dex */
final class TracingInterceptor implements Interceptor {
    private final Instrumenter<Request, Response> instrumenter;
    private final ContextPropagators propagators;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracingInterceptor(Instrumenter<Request, Response> instrumenter, ContextPropagators contextPropagators) {
        this.instrumenter = instrumenter;
        this.propagators = contextPropagators;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Context callingContextForRequest = TracingCallFactory.getCallingContextForRequest(request);
        if (callingContextForRequest == null) {
            callingContextForRequest = Context.CC.current();
        }
        if (!this.instrumenter.shouldStart(callingContextForRequest, request)) {
            return chain.proceed(chain.request());
        }
        Context start = this.instrumenter.start(callingContextForRequest, request);
        Request injectContextToRequest = injectContextToRequest(request, start);
        try {
            Scope makeCurrent = start.makeCurrent();
            try {
                Response proceed = chain.proceed(injectContextToRequest);
                if (makeCurrent != null) {
                    makeCurrent.close();
                }
                this.instrumenter.end(start, injectContextToRequest, proceed, null);
                return proceed;
            } finally {
            }
        } catch (Exception e) {
            this.instrumenter.end(start, injectContextToRequest, null, e);
            throw e;
        }
    }

    private Request injectContextToRequest(Request request, Context context) {
        Request.Builder newBuilder = request.newBuilder();
        this.propagators.getTextMapPropagator().inject(context, newBuilder, RequestHeaderSetter.INSTANCE);
        return newBuilder.build();
    }
}
