package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface RpcAttributesGetter<REQUEST> {
    @Nullable
    String method(REQUEST request);

    @Nullable
    String service(REQUEST request);

    @Nullable
    String system(REQUEST request);
}
