package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class NoopAttributesProcessor extends AttributesProcessor {
    static final NoopAttributesProcessor NOOP = new NoopAttributesProcessor();

    @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
    public Attributes process(Attributes attributes, Context context) {
        return attributes;
    }

    public String toString() {
        return "NoopAttributesProcessor{}";
    }

    @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
    public boolean usesContext() {
        return false;
    }

    private NoopAttributesProcessor() {
    }
}
