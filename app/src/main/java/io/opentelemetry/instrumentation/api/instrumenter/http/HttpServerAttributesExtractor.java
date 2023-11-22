package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.function.Function;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class HttpServerAttributesExtractor<REQUEST, RESPONSE> extends HttpCommonAttributesExtractor<REQUEST, RESPONSE, HttpServerAttributesGetter<REQUEST, RESPONSE>> implements SpanKeyProvider {
    private final Function<Context, String> httpRouteHolderGetter;

    public static <REQUEST, RESPONSE> HttpServerAttributesExtractor<REQUEST, RESPONSE> create(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter) {
        return builder(httpServerAttributesGetter).build();
    }

    public static <REQUEST, RESPONSE> HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> builder(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter) {
        return new HttpServerAttributesExtractorBuilder<>(httpServerAttributesGetter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpServerAttributesExtractor(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, List<String> list, List<String> list2) {
        this(httpServerAttributesGetter, list, list2, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerAttributesExtractor$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return HttpRouteHolder.getRoute((Context) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    HttpServerAttributesExtractor(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, List<String> list, List<String> list2, Function<Context, String> function) {
        super(httpServerAttributesGetter, list, list2);
        this.httpRouteHolderGetter = function;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        super.onStart(attributesBuilder, context, request);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_FLAVOR, ((HttpServerAttributesGetter) this.getter).flavor(request));
        String forwardedProto = forwardedProto(request);
        if (forwardedProto == null) {
            forwardedProto = ((HttpServerAttributesGetter) this.getter).scheme(request);
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_SCHEME, forwardedProto);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_TARGET, ((HttpServerAttributesGetter) this.getter).target(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_ROUTE, ((HttpServerAttributesGetter) this.getter).route(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_CLIENT_IP, clientIp(request));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        super.onEnd(attributesBuilder, context, request, response, th);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_ROUTE, this.httpRouteHolderGetter.apply(context));
    }

    @Nullable
    private String forwardedProto(REQUEST request) {
        String extractProtoFromForwardedHeader;
        String firstHeaderValue = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "forwarded"));
        if (firstHeaderValue == null || (extractProtoFromForwardedHeader = ForwardedHeaderParser.extractProtoFromForwardedHeader(firstHeaderValue)) == null) {
            String firstHeaderValue2 = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "x-forwarded-proto"));
            if (firstHeaderValue2 != null) {
                return ForwardedHeaderParser.extractProtoFromForwardedProtoHeader(firstHeaderValue2);
            }
            return null;
        }
        return extractProtoFromForwardedHeader;
    }

    @Nullable
    private String clientIp(REQUEST request) {
        String extractClientIpFromForwardedHeader;
        String firstHeaderValue = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "forwarded"));
        if (firstHeaderValue == null || (extractClientIpFromForwardedHeader = ForwardedHeaderParser.extractClientIpFromForwardedHeader(firstHeaderValue)) == null) {
            String firstHeaderValue2 = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "x-forwarded-for"));
            if (firstHeaderValue2 != null) {
                return ForwardedHeaderParser.extractClientIpFromForwardedForHeader(firstHeaderValue2);
            }
            return null;
        }
        return extractClientIpFromForwardedHeader;
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public final SpanKey internalGetSpanKey() {
        return SpanKey.HTTP_SERVER;
    }
}
