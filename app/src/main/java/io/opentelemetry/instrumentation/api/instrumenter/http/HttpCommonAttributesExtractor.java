package io.opentelemetry.instrumentation.api.instrumenter.http;

import com.alipay.griver.ccdn.CCDNH5CacheManager;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
abstract class HttpCommonAttributesExtractor<REQUEST, RESPONSE, GETTER extends HttpCommonAttributesGetter<REQUEST, RESPONSE>> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final List<String> capturedRequestHeaders;
    private final List<String> capturedResponseHeaders;
    final GETTER getter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCommonAttributesExtractor(GETTER getter, List<String> list, List<String> list2) {
        this.getter = getter;
        this.capturedRequestHeaders = CapturedHttpHeadersUtil.lowercase(list);
        this.capturedResponseHeaders = CapturedHttpHeadersUtil.lowercase(list2);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_METHOD, this.getter.method(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_USER_AGENT, userAgent(request));
        for (String str : this.capturedRequestHeaders) {
            List<String> requestHeader = this.getter.requestHeader(request, str);
            if (!requestHeader.isEmpty()) {
                AttributesExtractorUtil.internalSet(attributesBuilder, CapturedHttpHeadersUtil.requestAttributeKey(str), requestHeader);
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_REQUEST_CONTENT_LENGTH, requestContentLength(request));
        if (response != null) {
            Integer statusCode = this.getter.statusCode(request, response, th);
            if (statusCode != null && statusCode.intValue() > 0) {
                AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_STATUS_CODE, Long.valueOf(statusCode.intValue()));
            }
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_RESPONSE_CONTENT_LENGTH, responseContentLength(request, response));
            for (String str : this.capturedResponseHeaders) {
                List<String> responseHeader = this.getter.responseHeader(request, response, str);
                if (!responseHeader.isEmpty()) {
                    AttributesExtractorUtil.internalSet(attributesBuilder, CapturedHttpHeadersUtil.responseAttributeKey(str), responseHeader);
                }
            }
        }
    }

    @Nullable
    private String userAgent(REQUEST request) {
        return firstHeaderValue(this.getter.requestHeader(request, "user-agent"));
    }

    @Nullable
    private Long requestContentLength(REQUEST request) {
        return parseNumber(firstHeaderValue(this.getter.requestHeader(request, CCDNH5CacheManager.CONTENT_LENGTH)));
    }

    @Nullable
    private Long responseContentLength(REQUEST request, RESPONSE response) {
        return parseNumber(firstHeaderValue(this.getter.responseHeader(request, response, CCDNH5CacheManager.CONTENT_LENGTH)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String firstHeaderValue(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    private static Long parseNumber(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
