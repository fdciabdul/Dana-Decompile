package io.opentelemetry.api.logs;

/* loaded from: classes2.dex */
public interface LoggerProvider {
    Logger get(String str);

    LoggerBuilder loggerBuilder(String str);

    /* renamed from: io.opentelemetry.api.logs.LoggerProvider$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static LoggerProvider noop() {
            return DefaultLoggerProvider.getInstance();
        }
    }
}
