package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class NetClientAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final NetClientAttributesGetter<REQUEST, RESPONSE> getter;

    public static <REQUEST, RESPONSE> NetClientAttributesExtractor<REQUEST, RESPONSE> create(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        return new NetClientAttributesExtractor<>(netClientAttributesGetter);
    }

    private NetClientAttributesExtractor(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        this.getter = netClientAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        String peerName = this.getter.peerName(request);
        Integer peerPort = this.getter.peerPort(request);
        if (peerName != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_PEER_NAME, peerName);
            if (peerPort == null || peerPort.intValue() <= 0) {
                return;
            }
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_PEER_PORT, Long.valueOf(peerPort.intValue()));
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_TRANSPORT, this.getter.transport(request, response));
        String peerName = this.getter.peerName(request);
        Integer peerPort = this.getter.peerPort(request);
        String sockPeerAddr = this.getter.sockPeerAddr(request, response);
        if (sockPeerAddr == null || sockPeerAddr.equals(peerName)) {
            return;
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_PEER_ADDR, sockPeerAddr);
        Integer sockPeerPort = this.getter.sockPeerPort(request, response);
        if (sockPeerPort != null && sockPeerPort.intValue() > 0 && !sockPeerPort.equals(peerPort)) {
            AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_PEER_PORT, Long.valueOf(sockPeerPort.intValue()));
        }
        String sockFamily = this.getter.sockFamily(request, response);
        if (sockFamily != null && !SemanticAttributes.NetSockFamilyValues.INET.equals(sockFamily)) {
            AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_FAMILY, sockFamily);
        }
        String sockPeerName = this.getter.sockPeerName(request, response);
        if (sockPeerName == null || sockPeerName.equals(peerName)) {
            return;
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_PEER_NAME, sockPeerName);
    }
}
