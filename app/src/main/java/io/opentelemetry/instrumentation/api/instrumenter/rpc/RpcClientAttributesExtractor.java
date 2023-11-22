package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;

/* loaded from: classes9.dex */
public final class RpcClientAttributesExtractor<REQUEST, RESPONSE> extends RpcCommonAttributesExtractor<REQUEST, RESPONSE> implements SpanKeyProvider {
    public static <REQUEST, RESPONSE> RpcClientAttributesExtractor<REQUEST, RESPONSE> create(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        return new RpcClientAttributesExtractor<>(rpcAttributesGetter);
    }

    private RpcClientAttributesExtractor(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        super(rpcAttributesGetter);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public final SpanKey internalGetSpanKey() {
        return SpanKey.RPC_CLIENT;
    }
}
