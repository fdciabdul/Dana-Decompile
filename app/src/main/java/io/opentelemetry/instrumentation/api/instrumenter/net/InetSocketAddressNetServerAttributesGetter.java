package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public abstract class InetSocketAddressNetServerAttributesGetter<REQUEST> implements NetServerAttributesGetter<REQUEST> {
    @Nullable
    protected abstract InetSocketAddress getHostSocketAddress(REQUEST request);

    @Nullable
    protected abstract InetSocketAddress getPeerSocketAddress(REQUEST request);

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter
    @Nullable
    public String sockFamily(REQUEST request) {
        InetSocketAddress peerSocketAddress = getPeerSocketAddress(request);
        if (peerSocketAddress == null) {
            peerSocketAddress = getHostSocketAddress(request);
        }
        if (peerSocketAddress != null && (peerSocketAddress.getAddress() instanceof Inet6Address)) {
            return SemanticAttributes.NetSockFamilyValues.INET6;
        }
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter
    @Nullable
    public final String sockPeerAddr(REQUEST request) {
        return getAddress(getPeerSocketAddress(request));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter
    @Nullable
    public final Integer sockPeerPort(REQUEST request) {
        return getPort(getPeerSocketAddress(request));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter
    @Nullable
    public String sockHostAddr(REQUEST request) {
        return getAddress(getHostSocketAddress(request));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter
    @Nullable
    public Integer sockHostPort(REQUEST request) {
        return getPort(getHostSocketAddress(request));
    }

    @Nullable
    private static String getAddress(InetSocketAddress inetSocketAddress) {
        InetAddress address;
        if (inetSocketAddress == null || (address = inetSocketAddress.getAddress()) == null) {
            return null;
        }
        return address.getHostAddress();
    }

    @Nullable
    private static Integer getPort(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            return null;
        }
        return Integer.valueOf(inetSocketAddress.getPort());
    }
}
