package id.dana.rum.quake;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/rum/quake/QuakeNetAttributesGetter;", "Lio/opentelemetry/instrumentation/api/instrumenter/net/NetClientAttributesGetter;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuakeNetAttributesGetter implements NetClientAttributesGetter<Request, NetworkResponse> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String peerName(Request request) {
        String peerName;
        peerName = peerName(request, null);
        return peerName;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ Integer peerPort(Request request) {
        Integer peerPort;
        peerPort = peerPort(request, null);
        return peerPort;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String sockFamily(Request request, NetworkResponse networkResponse) {
        return NetClientAttributesGetter.CC.$default$sockFamily(this, request, networkResponse);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String sockPeerAddr(Request request, NetworkResponse networkResponse) {
        return NetClientAttributesGetter.CC.$default$sockPeerAddr(this, request, networkResponse);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String sockPeerName(Request request, NetworkResponse networkResponse) {
        return NetClientAttributesGetter.CC.$default$sockPeerName(this, request, networkResponse);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ Integer sockPeerPort(Request request, NetworkResponse networkResponse) {
        return NetClientAttributesGetter.CC.$default$sockPeerPort(this, request, networkResponse);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ String peerName(Request request, NetworkResponse networkResponse) {
        Intrinsics.checkNotNullParameter(request, "");
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* synthetic */ Integer peerPort(Request request, NetworkResponse networkResponse) {
        Intrinsics.checkNotNullParameter(request, "");
        return 80;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public final /* bridge */ /* synthetic */ String transport(Request request, NetworkResponse networkResponse) {
        return SemanticAttributes.NetTransportValues.IP_TCP;
    }
}
