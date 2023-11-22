package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
abstract class RpcCommonAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final RpcAttributesGetter<REQUEST> getter;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RpcCommonAttributesExtractor(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        this.getter = rpcAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.RPC_SYSTEM, this.getter.system(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.RPC_SERVICE, this.getter.service(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.RPC_METHOD, this.getter.method(request));
    }
}
