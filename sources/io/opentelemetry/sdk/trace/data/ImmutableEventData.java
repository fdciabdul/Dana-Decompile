package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.data.EventData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ImmutableEventData implements EventData {
    @Override // io.opentelemetry.sdk.trace.data.EventData
    public /* synthetic */ int getDroppedAttributesCount() {
        return EventData.CC.$default$getDroppedAttributesCount(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EventData create(long j, String str, Attributes attributes) {
        return create(j, str, attributes, attributes.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static EventData create(long j, String str, Attributes attributes, int i) {
        return new AutoValue_ImmutableEventData(str, attributes, j, i);
    }
}
