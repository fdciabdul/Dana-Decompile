package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class MessagingAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE>, SpanKeyProvider {
    static final String TEMP_DESTINATION_NAME = "(temporary)";
    private final List<String> capturedHeaders;
    private final MessagingAttributesGetter<REQUEST, RESPONSE> getter;
    private final MessageOperation operation;

    public static <REQUEST, RESPONSE> MessagingAttributesExtractor<REQUEST, RESPONSE> create(MessagingAttributesGetter<REQUEST, RESPONSE> messagingAttributesGetter, MessageOperation messageOperation) {
        return builder(messagingAttributesGetter, messageOperation).build();
    }

    public static <REQUEST, RESPONSE> MessagingAttributesExtractorBuilder<REQUEST, RESPONSE> builder(MessagingAttributesGetter<REQUEST, RESPONSE> messagingAttributesGetter, MessageOperation messageOperation) {
        return new MessagingAttributesExtractorBuilder<>(messagingAttributesGetter, messageOperation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessagingAttributesExtractor(MessagingAttributesGetter<REQUEST, RESPONSE> messagingAttributesGetter, MessageOperation messageOperation, List<String> list) {
        this.getter = messagingAttributesGetter;
        this.operation = messageOperation;
        this.capturedHeaders = CapturedMessageHeadersUtil.lowercase(list);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_SYSTEM, this.getter.system(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_DESTINATION_KIND, this.getter.destinationKind(request));
        if (this.getter.temporaryDestination(request)) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_TEMP_DESTINATION, Boolean.TRUE);
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_DESTINATION, TEMP_DESTINATION_NAME);
        } else {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_DESTINATION, this.getter.destination(request));
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_PROTOCOL, this.getter.protocol(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_PROTOCOL_VERSION, this.getter.protocolVersion(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_URL, this.getter.url(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_CONVERSATION_ID, this.getter.conversationId(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_MESSAGE_PAYLOAD_SIZE_BYTES, this.getter.messagePayloadSize(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_MESSAGE_PAYLOAD_COMPRESSED_SIZE_BYTES, this.getter.messagePayloadCompressedSize(request));
        if (this.operation == MessageOperation.RECEIVE || this.operation == MessageOperation.PROCESS) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_OPERATION, this.operation.operationName());
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.MESSAGING_MESSAGE_ID, this.getter.messageId(request, response));
        for (String str : this.capturedHeaders) {
            List<String> header = this.getter.header(request, str);
            if (!header.isEmpty()) {
                AttributesExtractorUtil.internalSet(attributesBuilder, CapturedMessageHeadersUtil.attributeKey(str), header);
            }
        }
    }

    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.messaging.MessagingAttributesExtractor$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$instrumentation$api$instrumenter$messaging$MessageOperation;

        static {
            int[] iArr = new int[MessageOperation.values().length];
            $SwitchMap$io$opentelemetry$instrumentation$api$instrumenter$messaging$MessageOperation = iArr;
            try {
                iArr[MessageOperation.SEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$instrumentation$api$instrumenter$messaging$MessageOperation[MessageOperation.RECEIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$instrumentation$api$instrumenter$messaging$MessageOperation[MessageOperation.PROCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public final SpanKey internalGetSpanKey() {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$instrumentation$api$instrumenter$messaging$MessageOperation[this.operation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return SpanKey.CONSUMER_PROCESS;
                }
                throw new IllegalStateException("Can't possibly happen");
            }
            return SpanKey.CONSUMER_RECEIVE;
        }
        return SpanKey.PRODUCER;
    }
}
