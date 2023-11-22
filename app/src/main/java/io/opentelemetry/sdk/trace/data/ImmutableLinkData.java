package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public abstract class ImmutableLinkData implements LinkData {
    private static final Attributes DEFAULT_ATTRIBUTE_COLLECTION = Attributes.CC.empty();
    private static final int DEFAULT_ATTRIBUTE_COUNT = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkData create(SpanContext spanContext) {
        return new AutoValue_ImmutableLinkData(spanContext, DEFAULT_ATTRIBUTE_COLLECTION, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkData create(SpanContext spanContext, Attributes attributes) {
        return new AutoValue_ImmutableLinkData(spanContext, attributes, attributes.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkData create(SpanContext spanContext, Attributes attributes, int i) {
        return new AutoValue_ImmutableLinkData(spanContext, attributes, i);
    }
}
