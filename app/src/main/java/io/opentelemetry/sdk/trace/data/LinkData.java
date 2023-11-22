package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* loaded from: classes2.dex */
public interface LinkData {
    Attributes getAttributes();

    SpanContext getSpanContext();

    int getTotalAttributeCount();

    /* renamed from: io.opentelemetry.sdk.trace.data.LinkData$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static LinkData create(SpanContext spanContext) {
            return ImmutableLinkData.create(spanContext);
        }

        public static LinkData create(SpanContext spanContext, Attributes attributes) {
            return ImmutableLinkData.create(spanContext, attributes);
        }

        public static LinkData create(SpanContext spanContext, Attributes attributes, int i) {
            return ImmutableLinkData.create(spanContext, attributes, i);
        }
    }
}
