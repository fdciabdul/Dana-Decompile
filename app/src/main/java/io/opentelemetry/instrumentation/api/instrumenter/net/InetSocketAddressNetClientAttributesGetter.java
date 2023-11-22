package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public abstract class InetSocketAddressNetClientAttributesGetter<REQUEST, RESPONSE> implements NetClientAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    protected abstract InetSocketAddress getPeerSocketAddress(REQUEST request, @Nullable RESPONSE response);

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public /* synthetic */ String peerName(Object obj) {
        String peerName;
        peerName = peerName(obj, null);
        return peerName;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public /* synthetic */ String peerName(Object obj, Object obj2) {
        return NetClientAttributesGetter.CC.$default$peerName(this, obj, obj2);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public /* synthetic */ Integer peerPort(Object obj) {
        Integer peerPort;
        peerPort = peerPort(obj, null);
        return peerPort;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public /* synthetic */ Integer peerPort(Object obj, Object obj2) {
        return NetClientAttributesGetter.CC.$default$peerPort(this, obj, obj2);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    @Nullable
    public String sockFamily(REQUEST request, @Nullable RESPONSE response) {
        InetSocketAddress peerSocketAddress = getPeerSocketAddress(request, response);
        if (peerSocketAddress != null && (peerSocketAddress.getAddress() instanceof Inet6Address)) {
            return SemanticAttributes.NetSockFamilyValues.INET6;
        }
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    @Nullable
    public final String sockPeerAddr(REQUEST request, @Nullable RESPONSE response) {
        InetAddress address;
        InetSocketAddress peerSocketAddress = getPeerSocketAddress(request, response);
        if (peerSocketAddress == null || (address = peerSocketAddress.getAddress()) == null) {
            return null;
        }
        return address.getHostAddress();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    @Nullable
    public String sockPeerName(REQUEST request, @Nullable RESPONSE response) {
        InetSocketAddress peerSocketAddress = getPeerSocketAddress(request, response);
        if (peerSocketAddress == null) {
            return null;
        }
        return peerSocketAddress.getHostString();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    @Nullable
    public Integer sockPeerPort(REQUEST request, @Nullable RESPONSE response) {
        InetSocketAddress peerSocketAddress = getPeerSocketAddress(request, response);
        if (peerSocketAddress == null) {
            return null;
        }
        return Integer.valueOf(peerSocketAddress.getPort());
    }
}
