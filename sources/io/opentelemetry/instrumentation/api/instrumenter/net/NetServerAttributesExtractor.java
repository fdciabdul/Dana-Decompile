package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class NetServerAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final NetServerAttributesGetter<REQUEST> getter;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
    }

    public static <REQUEST, RESPONSE> NetServerAttributesExtractor<REQUEST, RESPONSE> create(NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        return new NetServerAttributesExtractor<>(netServerAttributesGetter);
    }

    private NetServerAttributesExtractor(NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        this.getter = netServerAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        boolean z;
        String sockFamily;
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_TRANSPORT, this.getter.transport(request));
        String sockPeerAddr = this.getter.sockPeerAddr(request);
        boolean z2 = true;
        if (sockPeerAddr != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_PEER_ADDR, sockPeerAddr);
            Integer sockPeerPort = this.getter.sockPeerPort(request);
            if (sockPeerPort != null && sockPeerPort.intValue() > 0) {
                AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_PEER_PORT, Long.valueOf(sockPeerPort.intValue()));
            }
            z = true;
        } else {
            z = false;
        }
        String hostName = this.getter.hostName(request);
        Integer hostPort = this.getter.hostPort(request);
        if (hostName != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_HOST_NAME, hostName);
            if (hostPort != null && hostPort.intValue() > 0) {
                AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_HOST_PORT, Long.valueOf(hostPort.intValue()));
            }
        }
        String sockHostAddr = this.getter.sockHostAddr(request);
        if (sockHostAddr == null || sockHostAddr.equals(hostName)) {
            z2 = z;
        } else {
            AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_HOST_ADDR, sockHostAddr);
            Integer sockHostPort = this.getter.sockHostPort(request);
            if (sockHostPort != null && sockHostPort.intValue() > 0 && !sockHostPort.equals(hostPort)) {
                AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_HOST_PORT, Long.valueOf(sockHostPort.intValue()));
            }
        }
        if (!z2 || (sockFamily = this.getter.sockFamily(request)) == null || SemanticAttributes.NetSockFamilyValues.INET.equals(sockFamily)) {
            return;
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, NetAttributes.NET_SOCK_FAMILY, sockFamily);
    }
}
