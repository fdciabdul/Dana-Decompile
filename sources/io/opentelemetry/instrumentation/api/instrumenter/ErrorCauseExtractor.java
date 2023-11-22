package io.opentelemetry.instrumentation.api.instrumenter;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface ErrorCauseExtractor {
    Throwable extract(Throwable th);

    /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.ErrorCauseExtractor$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static ErrorCauseExtractor getDefault() {
            return DefaultErrorCauseExtractor.INSTANCE;
        }
    }
}
