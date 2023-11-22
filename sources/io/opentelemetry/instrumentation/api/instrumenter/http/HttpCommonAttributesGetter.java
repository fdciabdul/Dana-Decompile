package io.opentelemetry.instrumentation.api.instrumenter.http;

import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface HttpCommonAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String method(REQUEST request);

    List<String> requestHeader(REQUEST request, String str);

    List<String> responseHeader(REQUEST request, RESPONSE response, String str);

    @Nullable
    Integer statusCode(REQUEST request, RESPONSE response, @Nullable Throwable th);
}
