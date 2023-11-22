package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;

/* loaded from: classes9.dex */
public final class MessagingSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final MessagingAttributesGetter<REQUEST, ?> getter;
    private final MessageOperation operation;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(MessagingAttributesGetter<REQUEST, ?> messagingAttributesGetter, MessageOperation messageOperation) {
        return new MessagingSpanNameExtractor(messagingAttributesGetter, messageOperation);
    }

    private MessagingSpanNameExtractor(MessagingAttributesGetter<REQUEST, ?> messagingAttributesGetter, MessageOperation messageOperation) {
        this.getter = messagingAttributesGetter;
        this.operation = messageOperation;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public final String extract(REQUEST request) {
        String destination = this.getter.temporaryDestination(request) ? "(temporary)" : this.getter.destination(request);
        if (destination == null) {
            destination = "unknown";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(destination);
        sb.append(" ");
        sb.append(this.operation.operationName());
        return sb.toString();
    }
}
