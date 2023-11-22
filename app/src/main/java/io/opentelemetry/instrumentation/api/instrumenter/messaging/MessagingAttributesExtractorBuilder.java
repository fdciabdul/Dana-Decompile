package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingAttributesExtractorBuilder<REQUEST, RESPONSE> {
    List<String> capturedHeaders = Collections.emptyList();
    final MessagingAttributesGetter<REQUEST, RESPONSE> getter;
    final MessageOperation operation;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessagingAttributesExtractorBuilder(MessagingAttributesGetter<REQUEST, RESPONSE> messagingAttributesGetter, MessageOperation messageOperation) {
        this.getter = messagingAttributesGetter;
        this.operation = messageOperation;
    }

    public final MessagingAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedHeaders(List<String> list) {
        this.capturedHeaders = list;
        return this;
    }

    public final MessagingAttributesExtractor<REQUEST, RESPONSE> build() {
        return new MessagingAttributesExtractor<>(this.getter, this.operation, this.capturedHeaders);
    }
}
