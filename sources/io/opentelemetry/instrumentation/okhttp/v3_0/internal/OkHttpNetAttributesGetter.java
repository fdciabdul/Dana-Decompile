package io.opentelemetry.instrumentation.okhttp.v3_0.internal;

import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class OkHttpNetAttributesGetter implements NetClientAttributesGetter<Request, Response> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String peerName(Request request, Response response) {
        return NetClientAttributesGetter.CC.$default$peerName(this, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ Integer peerPort(Request request, Response response) {
        return NetClientAttributesGetter.CC.$default$peerPort(this, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String sockFamily(Request request, Response response) {
        return NetClientAttributesGetter.CC.$default$sockFamily(this, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String sockPeerAddr(Request request, Response response) {
        return NetClientAttributesGetter.CC.$default$sockPeerAddr(this, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String sockPeerName(Request request, Response response) {
        return NetClientAttributesGetter.CC.$default$sockPeerName(this, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ Integer sockPeerPort(Request request, Response response) {
        return NetClientAttributesGetter.CC.$default$sockPeerPort(this, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final String transport(Request request, @Nullable Response response) {
        return SemanticAttributes.NetTransportValues.IP_TCP;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    @Nullable
    public final String peerName(Request request) {
        return request.url().host();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final Integer peerPort(Request request) {
        return Integer.valueOf(request.url().port());
    }
}
