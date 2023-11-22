package io.opentelemetry.sdk.internal;

import j$.util.concurrent.ThreadLocalRandom;
import j$.util.function.Supplier;
import java.util.Random;

/* loaded from: classes6.dex */
public final class RandomSupplier {
    private RandomSupplier() {
    }

    public static Supplier<Random> platformDefault() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            return AndroidFriendlyRandomHolder.INSTANCE;
        }
        return new Supplier() { // from class: io.opentelemetry.sdk.internal.RandomSupplier$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return ThreadLocalRandom.current();
            }
        };
    }
}
