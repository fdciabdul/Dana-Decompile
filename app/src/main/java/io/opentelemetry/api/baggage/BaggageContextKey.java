package io.opentelemetry.api.baggage;

import io.opentelemetry.context.ContextKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class BaggageContextKey {
    static final ContextKey<Baggage> KEY = ContextKey.CC.named("opentelemetry-baggage-key");

    private BaggageContextKey() {
    }
}
