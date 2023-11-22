package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class HttpSpanStatusExtractor<REQUEST, RESPONSE> implements SpanStatusExtractor<REQUEST, RESPONSE> {
    private final HttpCommonAttributesGetter<? super REQUEST, ? super RESPONSE> getter;
    private final HttpStatusConverter statusConverter;

    public static <REQUEST, RESPONSE> SpanStatusExtractor<REQUEST, RESPONSE> create(HttpClientAttributesGetter<? super REQUEST, ? super RESPONSE> httpClientAttributesGetter) {
        return new HttpSpanStatusExtractor(httpClientAttributesGetter, HttpStatusConverter.CLIENT);
    }

    public static <REQUEST, RESPONSE> SpanStatusExtractor<REQUEST, RESPONSE> create(HttpServerAttributesGetter<? super REQUEST, ? super RESPONSE> httpServerAttributesGetter) {
        return new HttpSpanStatusExtractor(httpServerAttributesGetter, HttpStatusConverter.SERVER);
    }

    private HttpSpanStatusExtractor(HttpCommonAttributesGetter<? super REQUEST, ? super RESPONSE> httpCommonAttributesGetter, HttpStatusConverter httpStatusConverter) {
        this.getter = httpCommonAttributesGetter;
        this.statusConverter = httpStatusConverter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor
    public final void extract(SpanStatusBuilder spanStatusBuilder, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        Integer statusCode;
        StatusCode statusFromHttpStatus;
        if (response != null && (statusCode = this.getter.statusCode(request, response, th)) != null && (statusFromHttpStatus = this.statusConverter.statusFromHttpStatus(statusCode.intValue())) == StatusCode.ERROR) {
            spanStatusBuilder.setStatus(statusFromHttpStatus);
        } else {
            SpanStatusExtractor.CC.getDefault().extract(spanStatusBuilder, request, response, th);
        }
    }
}
