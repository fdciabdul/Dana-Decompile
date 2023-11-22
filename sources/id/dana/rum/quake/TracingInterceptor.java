package id.dana.rum.quake;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.request.RequestInterceptor;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B#\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010"}, d2 = {"Lid/dana/rum/quake/TracingInterceptor;", "Lcom/alipay/imobile/network/quake/request/RequestInterceptor;", "Lcom/alipay/imobile/network/quake/Request;", "p0", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "p1", "", "afterReceiveResponse", "(Lcom/alipay/imobile/network/quake/Request;Lcom/alipay/imobile/network/quake/NetworkResponse;)V", "beforeSendRequest", "(Lcom/alipay/imobile/network/quake/Request;)V", "Lio/opentelemetry/instrumentation/api/instrumenter/Instrumenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/opentelemetry/instrumentation/api/instrumenter/Instrumenter;", "PlaceComponentResult", "Lio/opentelemetry/context/propagation/ContextPropagators;", "Lio/opentelemetry/context/propagation/ContextPropagators;", "getAuthRequestContext", "<init>", "(Lio/opentelemetry/instrumentation/api/instrumenter/Instrumenter;Lio/opentelemetry/context/propagation/ContextPropagators;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TracingInterceptor implements RequestInterceptor {
    private static final Cache<Request, Context> getAuthRequestContext = Cache.CC.weak();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Instrumenter<Request, NetworkResponse> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ContextPropagators getAuthRequestContext;

    public TracingInterceptor(Instrumenter<Request, NetworkResponse> instrumenter, ContextPropagators contextPropagators) {
        Intrinsics.checkNotNullParameter(instrumenter, "");
        Intrinsics.checkNotNullParameter(contextPropagators, "");
        this.PlaceComponentResult = instrumenter;
        this.getAuthRequestContext = contextPropagators;
    }

    @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
    public final void beforeSendRequest(Request p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Cache<Request, Context> cache = getAuthRequestContext;
        Context context = cache.get(p0);
        if (context == null) {
            context = Context.CC.current();
        }
        if (this.PlaceComponentResult.shouldStart(context, p0)) {
            Context start = this.PlaceComponentResult.start(context, p0);
            cache.put(p0, start);
            this.getAuthRequestContext.getTextMapPropagator().inject(start, p0, RequestHeaderSetter.INSTANCE);
        }
    }

    @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
    public final void afterReceiveResponse(Request p0, NetworkResponse p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Context context = getAuthRequestContext.get(p0);
        if (context != null) {
            this.PlaceComponentResult.end(context, p0, p1, null);
        }
    }
}
