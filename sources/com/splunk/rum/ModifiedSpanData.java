package com.splunk.rum;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.data.DelegatingSpanData;
import io.opentelemetry.sdk.trace.data.SpanData;

/* loaded from: classes3.dex */
final class ModifiedSpanData extends DelegatingSpanData {
    private final Attributes MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModifiedSpanData(SpanData spanData, Attributes attributes) {
        super(spanData);
        this.MyBillsEntityDataFactory = attributes;
    }

    @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
    public final Attributes getAttributes() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
    public final int getTotalAttributeCount() {
        return this.MyBillsEntityDataFactory.size();
    }
}
