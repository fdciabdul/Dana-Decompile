package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.context.ImplicitContextKeyed;
import io.opentelemetry.context.Scope;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class HttpRouteState implements ImplicitContextKeyed {
    private static final ContextKey<HttpRouteState> KEY = ContextKey.CC.named("opentelemetry-http-server-route-key");
    @Nullable
    private volatile String route;
    private volatile int updatedBySourceOrder;

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Scope makeCurrent() {
        Scope makeCurrent;
        makeCurrent = Context.CC.current().with(this).makeCurrent();
        return makeCurrent;
    }

    @Nullable
    public static HttpRouteState fromContextOrNull(Context context) {
        return (HttpRouteState) context.get(KEY);
    }

    public static HttpRouteState create(int i, @Nullable String str) {
        return new HttpRouteState(i, str);
    }

    private HttpRouteState(int i, @Nullable String str) {
        this.updatedBySourceOrder = i;
        this.route = str;
    }

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    public final Context storeInContext(Context context) {
        return context.with(KEY, this);
    }

    public final int getUpdatedBySourceOrder() {
        return this.updatedBySourceOrder;
    }

    @Nullable
    public final String getRoute() {
        return this.route;
    }

    public final void update(Context context, int i, String str) {
        this.updatedBySourceOrder = i;
        this.route = str;
    }
}
