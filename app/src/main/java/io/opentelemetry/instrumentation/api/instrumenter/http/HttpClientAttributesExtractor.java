package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class HttpClientAttributesExtractor<REQUEST, RESPONSE> extends HttpCommonAttributesExtractor<REQUEST, RESPONSE, HttpClientAttributesGetter<REQUEST, RESPONSE>> implements SpanKeyProvider {
    public static <REQUEST, RESPONSE> HttpClientAttributesExtractor<REQUEST, RESPONSE> create(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter) {
        return builder(httpClientAttributesGetter).build();
    }

    public static <REQUEST, RESPONSE> HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> builder(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter) {
        return new HttpClientAttributesExtractorBuilder<>(httpClientAttributesGetter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpClientAttributesExtractor(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter, List<String> list, List<String> list2) {
        super(httpClientAttributesGetter, list, list2);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        super.onStart(attributesBuilder, context, request);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_URL, stripSensitiveData(((HttpClientAttributesGetter) this.getter).url(request)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        if (r3 != (r2 - 1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append(r8.substring(0, r0));
        r1.append(r8.substring(r3 + 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        return r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return r8;
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String stripSensitiveData(@javax.annotation.Nullable java.lang.String r8) {
        /*
            if (r8 == 0) goto L6a
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L9
            goto L6a
        L9:
            r0 = 58
            int r0 = r8.indexOf(r0)
            r1 = -1
            if (r0 != r1) goto L13
            return r8
        L13:
            int r2 = r8.length()
            int r3 = r0 + 2
            if (r2 <= r3) goto L6a
            int r4 = r0 + 1
            char r4 = r8.charAt(r4)
            r5 = 47
            if (r4 != r5) goto L6a
            char r3 = r8.charAt(r3)
            if (r3 == r5) goto L2c
            goto L6a
        L2c:
            int r0 = r0 + 3
            r4 = r0
            r3 = -1
        L30:
            if (r4 >= r2) goto L49
            char r6 = r8.charAt(r4)
            r7 = 64
            if (r6 != r7) goto L3b
            r3 = r4
        L3b:
            if (r6 == r5) goto L49
            r7 = 63
            if (r6 == r7) goto L49
            r7 = 35
            if (r6 != r7) goto L46
            goto L49
        L46:
            int r4 = r4 + 1
            goto L30
        L49:
            if (r3 == r1) goto L6a
            int r2 = r2 + (-1)
            if (r3 != r2) goto L50
            goto L6a
        L50:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.lang.String r0 = r8.substring(r2, r0)
            r1.append(r0)
            int r3 = r3 + 1
            java.lang.String r8 = r8.substring(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
        L6a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractor.stripSensitiveData(java.lang.String):java.lang.String");
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        super.onEnd(attributesBuilder, context, request, response, th);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_FLAVOR, ((HttpClientAttributesGetter) this.getter).flavor(request, response));
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public final SpanKey internalGetSpanKey() {
        return SpanKey.HTTP_CLIENT;
    }
}
