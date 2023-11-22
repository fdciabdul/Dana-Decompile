package io.opentelemetry.instrumentation.api.instrumenter.code;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import io.opentelemetry.instrumentation.api.internal.ClassNames;

/* loaded from: classes9.dex */
public final class CodeSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final CodeAttributesGetter<REQUEST> getter;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(CodeAttributesGetter<REQUEST> codeAttributesGetter) {
        return new CodeSpanNameExtractor(codeAttributesGetter);
    }

    private CodeSpanNameExtractor(CodeAttributesGetter<REQUEST> codeAttributesGetter) {
        this.getter = codeAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public final String extract(REQUEST request) {
        Class<?> codeClass = this.getter.codeClass(request);
        String simpleName = codeClass != null ? ClassNames.simpleName(codeClass) : "<unknown>";
        int indexOf = simpleName.indexOf("$$Lambda$");
        if (indexOf >= 0) {
            simpleName = simpleName.substring(0, indexOf + 9);
        }
        String methodName = this.getter.methodName(request);
        if (methodName == null) {
            return simpleName;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append(".");
        sb.append(methodName);
        return sb.toString();
    }
}
