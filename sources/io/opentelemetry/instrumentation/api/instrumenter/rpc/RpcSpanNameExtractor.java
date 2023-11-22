package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;

/* loaded from: classes9.dex */
public final class RpcSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final RpcAttributesGetter<REQUEST> getter;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        return new RpcSpanNameExtractor(rpcAttributesGetter);
    }

    private RpcSpanNameExtractor(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        this.getter = rpcAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public final String extract(REQUEST request) {
        String service = this.getter.service(request);
        String method = this.getter.method(request);
        if (service == null || method == null) {
            return "RPC request";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(service);
        sb.append('/');
        sb.append(method);
        return sb.toString();
    }
}
