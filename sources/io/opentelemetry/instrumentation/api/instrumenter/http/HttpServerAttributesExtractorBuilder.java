package io.opentelemetry.instrumentation.api.instrumenter.http;

import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public final class HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> {
    List<String> capturedRequestHeaders = Collections.emptyList();
    List<String> capturedResponseHeaders = Collections.emptyList();
    final HttpServerAttributesGetter<REQUEST, RESPONSE> getter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpServerAttributesExtractorBuilder(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter) {
        this.getter = httpServerAttributesGetter;
    }

    public final HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedRequestHeaders(List<String> list) {
        this.capturedRequestHeaders = list;
        return this;
    }

    public final HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedResponseHeaders(List<String> list) {
        this.capturedResponseHeaders = list;
        return this;
    }

    public final HttpServerAttributesExtractor<REQUEST, RESPONSE> build() {
        return new HttpServerAttributesExtractor<>(this.getter, this.capturedRequestHeaders, this.capturedResponseHeaders);
    }
}
