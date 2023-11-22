package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class HttpSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final HttpCommonAttributesGetter<REQUEST, ?> getter;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter) {
        return new HttpSpanNameExtractor(httpCommonAttributesGetter);
    }

    private HttpSpanNameExtractor(HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter) {
        this.getter = httpCommonAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public final String extract(REQUEST request) {
        String extractRoute = extractRoute(request);
        if (extractRoute != null) {
            return extractRoute;
        }
        String method = this.getter.method(request);
        if (method != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("HTTP ");
            sb.append(method);
            return sb.toString();
        }
        return "HTTP request";
    }

    @Nullable
    private String extractRoute(REQUEST request) {
        HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter = this.getter;
        if (httpCommonAttributesGetter instanceof HttpServerAttributesGetter) {
            return ((HttpServerAttributesGetter) httpCommonAttributesGetter).route(request);
        }
        return null;
    }
}
