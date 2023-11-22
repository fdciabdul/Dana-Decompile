package io.opentelemetry.instrumentation.api.instrumenter.http;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> {
    List<String> capturedRequestHeaders = Collections.emptyList();
    List<String> capturedResponseHeaders = Collections.emptyList();
    final HttpClientAttributesGetter<REQUEST, RESPONSE> getter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpClientAttributesExtractorBuilder(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter) {
        this.getter = httpClientAttributesGetter;
    }

    public final HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedRequestHeaders(List<String> list) {
        this.capturedRequestHeaders = list;
        return this;
    }

    public final HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedResponseHeaders(List<String> list) {
        this.capturedResponseHeaders = list;
        return this;
    }

    public final HttpClientAttributesExtractor<REQUEST, RESPONSE> build() {
        return new HttpClientAttributesExtractor<>(this.getter, this.capturedRequestHeaders, this.capturedResponseHeaders);
    }
}
