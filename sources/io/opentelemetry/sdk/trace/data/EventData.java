package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;

/* loaded from: classes6.dex */
public interface EventData {
    Attributes getAttributes();

    int getDroppedAttributesCount();

    long getEpochNanos();

    String getName();

    int getTotalAttributeCount();

    /* renamed from: io.opentelemetry.sdk.trace.data.EventData$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static EventData create(long j, String str, Attributes attributes) {
            return ImmutableEventData.create(j, str, attributes);
        }

        public static EventData create(long j, String str, Attributes attributes, int i) {
            return ImmutableEventData.create(j, str, attributes, i);
        }

        public static int $default$getDroppedAttributesCount(EventData eventData) {
            return eventData.getTotalAttributeCount() - eventData.getAttributes().size();
        }
    }
}
