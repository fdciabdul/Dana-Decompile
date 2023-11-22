package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import java.util.Locale;

/* loaded from: classes9.dex */
public enum MessageOperation {
    SEND,
    RECEIVE,
    PROCESS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String operationName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
