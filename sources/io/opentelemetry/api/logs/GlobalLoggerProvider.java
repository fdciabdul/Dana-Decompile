package io.opentelemetry.api.logs;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.opentelemetry.api.logs.LoggerProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class GlobalLoggerProvider {
    private static final AtomicReference<LoggerProvider> instance = new AtomicReference<>(LoggerProvider.CC.noop());
    @Nullable
    private static volatile Throwable setInstanceCaller;

    private GlobalLoggerProvider() {
    }

    public static LoggerProvider get() {
        return instance.get();
    }

    public static void set(LoggerProvider loggerProvider) {
        if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(instance, LoggerProvider.CC.noop(), loggerProvider) && loggerProvider != LoggerProvider.CC.noop()) {
            throw new IllegalStateException("GlobalLoggerProvider.set has already been called. GlobalLoggerProvider.set must be called only once before any calls to GlobalLoggerProvider.get. Previous invocation set to cause of this exception.", setInstanceCaller);
        }
        setInstanceCaller = new Throwable();
    }

    public static void resetForTest() {
        instance.set(LoggerProvider.CC.noop());
    }
}
