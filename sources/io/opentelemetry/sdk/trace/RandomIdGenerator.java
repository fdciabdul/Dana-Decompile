package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.sdk.internal.RandomSupplier;
import j$.util.function.Supplier;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum RandomIdGenerator implements IdGenerator {
    INSTANCE;

    private static final long INVALID_ID = 0;
    private static final Supplier<Random> randomSupplier = RandomSupplier.platformDefault();

    @Override // java.lang.Enum
    public final String toString() {
        return "RandomIdGenerator{}";
    }

    @Override // io.opentelemetry.sdk.trace.IdGenerator
    public final String generateSpanId() {
        long nextLong;
        Random random = randomSupplier.get();
        do {
            nextLong = random.nextLong();
        } while (nextLong == 0);
        return SpanId.fromLong(nextLong);
    }

    @Override // io.opentelemetry.sdk.trace.IdGenerator
    public final String generateTraceId() {
        long nextLong;
        Random random = randomSupplier.get();
        long nextLong2 = random.nextLong();
        do {
            nextLong = random.nextLong();
        } while (nextLong == 0);
        return TraceId.fromLongs(nextLong2, nextLong);
    }
}
