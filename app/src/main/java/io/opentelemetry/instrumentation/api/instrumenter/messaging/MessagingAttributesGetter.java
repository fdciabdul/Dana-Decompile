package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface MessagingAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String conversationId(REQUEST request);

    @Nullable
    String destination(REQUEST request);

    @Nullable
    String destinationKind(REQUEST request);

    List<String> header(REQUEST request, String str);

    @Nullable
    String messageId(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    Long messagePayloadCompressedSize(REQUEST request);

    @Nullable
    Long messagePayloadSize(REQUEST request);

    @Nullable
    String protocol(REQUEST request);

    @Nullable
    String protocolVersion(REQUEST request);

    @Nullable
    String system(REQUEST request);

    boolean temporaryDestination(REQUEST request);

    @Nullable
    String url(REQUEST request);

    @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.messaging.MessagingAttributesGetter$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC<REQUEST, RESPONSE> {
    }
}
