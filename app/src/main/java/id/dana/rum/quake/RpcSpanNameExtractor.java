package id.dana.rum.quake;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerAttributesGetter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u001d\b\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/rum/quake/RpcSpanNameExtractor;", "Lio/opentelemetry/instrumentation/api/instrumenter/SpanNameExtractor;", "Lcom/alipay/imobile/network/quake/Request;", "Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpCommonAttributesGetter;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpCommonAttributesGetter;", "PlaceComponentResult", "p0", "<init>", "(Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpCommonAttributesGetter;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RpcSpanNameExtractor implements SpanNameExtractor<Request> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final HttpCommonAttributesGetter<Request, NetworkResponse> PlaceComponentResult;

    public /* synthetic */ RpcSpanNameExtractor(HttpCommonAttributesGetter httpCommonAttributesGetter, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCommonAttributesGetter);
    }

    private RpcSpanNameExtractor(HttpCommonAttributesGetter<Request, NetworkResponse> httpCommonAttributesGetter) {
        this.PlaceComponentResult = httpCommonAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public final /* synthetic */ String extract(Request request) {
        Request request2 = request;
        Intrinsics.checkNotNullParameter(request2, "");
        HttpCommonAttributesGetter<Request, NetworkResponse> httpCommonAttributesGetter = this.PlaceComponentResult;
        String route = httpCommonAttributesGetter instanceof HttpServerAttributesGetter ? ((HttpServerAttributesGetter) httpCommonAttributesGetter).route(request2) : null;
        if (route != null) {
            return route;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RPC ");
        sb.append(request2.getActionType());
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/rum/quake/RpcSpanNameExtractor$Companion;", "", "Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpCommonAttributesGetter;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "p0", "Lio/opentelemetry/instrumentation/api/instrumenter/SpanNameExtractor;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpCommonAttributesGetter;)Lio/opentelemetry/instrumentation/api/instrumenter/SpanNameExtractor;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SpanNameExtractor<Request> KClassImpl$Data$declaredNonStaticMembers$2(HttpCommonAttributesGetter<Request, NetworkResponse> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new RpcSpanNameExtractor(p0, null);
        }
    }
}
