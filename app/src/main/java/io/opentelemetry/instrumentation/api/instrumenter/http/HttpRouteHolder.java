package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.ContextCustomizer;
import io.opentelemetry.instrumentation.api.instrumenter.LocalRootSpan;
import io.opentelemetry.instrumentation.api.internal.HttpRouteState;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class HttpRouteHolder {
    public static <REQUEST> ContextCustomizer<REQUEST> get() {
        return new ContextCustomizer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpRouteHolder$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.ContextCustomizer
            public final Context onStart(Context context, Object obj, Attributes attributes) {
                return HttpRouteHolder.lambda$get$0(context, obj, attributes);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Context lambda$get$0(Context context, Object obj, Attributes attributes) {
        return HttpRouteState.fromContextOrNull(context) != null ? context : context.with(HttpRouteState.create(0, null));
    }

    private HttpRouteHolder() {
    }

    public static void updateHttpRoute(Context context, HttpRouteSource httpRouteSource, @Nullable String str) {
        updateHttpRoute(context, httpRouteSource, ConstantAdapter.INSTANCE, str);
    }

    public static <T> void updateHttpRoute(Context context, HttpRouteSource httpRouteSource, HttpRouteGetter<T> httpRouteGetter, T t) {
        updateHttpRoute(context, httpRouteSource, OneArgAdapter.getInstance(), t, httpRouteGetter);
    }

    public static <T, U> void updateHttpRoute(Context context, HttpRouteSource httpRouteSource, HttpRouteBiGetter<T, U> httpRouteBiGetter, T t, U u) {
        String str;
        Span fromContextOrNull = LocalRootSpan.fromContextOrNull(context);
        if (fromContextOrNull == null) {
            return;
        }
        HttpRouteState fromContextOrNull2 = HttpRouteState.fromContextOrNull(context);
        if (fromContextOrNull2 == null) {
            String str2 = httpRouteBiGetter.get(context, t, u);
            if (str2 == null || str2.isEmpty()) {
                return;
            }
            fromContextOrNull.updateName(str2);
            fromContextOrNull.setAttribute((AttributeKey<AttributeKey<String>>) SemanticAttributes.HTTP_ROUTE, (AttributeKey<String>) str2);
            return;
        }
        boolean z = !httpRouteSource.useFirst && httpRouteSource.order == fromContextOrNull2.getUpdatedBySourceOrder();
        if ((httpRouteSource.order <= fromContextOrNull2.getUpdatedBySourceOrder() && !z) || (str = httpRouteBiGetter.get(context, t, u)) == null || str.isEmpty()) {
            return;
        }
        if (!z || isBetterRoute(fromContextOrNull2, str)) {
            fromContextOrNull.updateName(str);
            fromContextOrNull2.update(context, httpRouteSource.order, str);
        }
    }

    private static boolean isBetterRoute(HttpRouteState httpRouteState, String str) {
        String route = httpRouteState.getRoute();
        return str.length() > (route == null ? 0 : route.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String getRoute(Context context) {
        HttpRouteState fromContextOrNull = HttpRouteState.fromContextOrNull(context);
        if (fromContextOrNull == null) {
            return null;
        }
        return fromContextOrNull.getRoute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class OneArgAdapter<T> implements HttpRouteBiGetter<T, HttpRouteGetter<T>> {
        private static final OneArgAdapter<Object> INSTANCE = new OneArgAdapter<>();

        private OneArgAdapter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpRouteBiGetter
        @Nullable
        public final /* bridge */ /* synthetic */ String get(Context context, Object obj, Object obj2) {
            return get(context, (Context) obj, (HttpRouteGetter<Context>) obj2);
        }

        static <T> OneArgAdapter<T> getInstance() {
            return (OneArgAdapter<T>) INSTANCE;
        }

        @Nullable
        public final String get(Context context, T t, HttpRouteGetter<T> httpRouteGetter) {
            return httpRouteGetter.get(context, t);
        }
    }

    /* loaded from: classes9.dex */
    static final class ConstantAdapter implements HttpRouteGetter<String> {
        private static final ConstantAdapter INSTANCE = new ConstantAdapter();

        @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpRouteGetter
        @Nullable
        public final String get(Context context, String str) {
            return str;
        }

        private ConstantAdapter() {
        }
    }
}
