package io.opentelemetry.sdk.trace;

/* loaded from: classes.dex */
public interface IdGenerator {
    String generateSpanId();

    String generateTraceId();

    /* renamed from: io.opentelemetry.sdk.trace.IdGenerator$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static IdGenerator random() {
            return RandomIdGenerator.INSTANCE;
        }
    }
}
