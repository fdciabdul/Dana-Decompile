package io.opentelemetry.sdk.internal;

import j$.util.function.Supplier;
import java.util.Random;

/* loaded from: classes6.dex */
enum AndroidFriendlyRandomHolder implements Supplier<Random> {
    INSTANCE;

    private static final Random random = new Random();

    @Override // j$.util.function.Supplier
    public final Random get() {
        return random;
    }
}
