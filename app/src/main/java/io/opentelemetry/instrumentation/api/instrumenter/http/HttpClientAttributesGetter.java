package io.opentelemetry.instrumentation.api.instrumenter.http;

import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface HttpClientAttributesGetter<REQUEST, RESPONSE> extends HttpCommonAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String flavor(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    String url(REQUEST request);
}
