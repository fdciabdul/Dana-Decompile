package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.logs.LoggerBuilder;
import io.opentelemetry.api.logs.LoggerProvider;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import io.opentelemetry.sdk.logs.LogRecordProcessor;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class SdkLoggerProvider implements LoggerProvider, Closeable {
    static final String DEFAULT_LOGGER_NAME = "unknown";
    private static final Logger LOGGER = Logger.getLogger(SdkLoggerProvider.class.getName());
    private final boolean isNoopLogRecordProcessor;
    private final ComponentRegistry<SdkLogger> loggerComponentRegistry;
    private final LoggerSharedState sharedState;

    public static SdkLoggerProviderBuilder builder() {
        return new SdkLoggerProviderBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLoggerProvider(Resource resource, Supplier<LogLimits> supplier, List<LogRecordProcessor> list, Clock clock) {
        LogRecordProcessor composite = LogRecordProcessor.CC.composite(list);
        this.sharedState = new LoggerSharedState(resource, supplier, composite, clock);
        this.loggerComponentRegistry = new ComponentRegistry<>(new Function() { // from class: io.opentelemetry.sdk.logs.SdkLoggerProvider$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return SdkLoggerProvider.this.m3154lambda$new$0$ioopentelemetrysdklogsSdkLoggerProvider((InstrumentationScopeInfo) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
        this.isNoopLogRecordProcessor = composite instanceof NoopLogRecordProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$io-opentelemetry-sdk-logs-SdkLoggerProvider  reason: not valid java name */
    public final /* synthetic */ SdkLogger m3154lambda$new$0$ioopentelemetrysdklogsSdkLoggerProvider(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkLogger(this.sharedState, instrumentationScopeInfo);
    }

    @Override // io.opentelemetry.api.logs.LoggerProvider
    public final io.opentelemetry.api.logs.Logger get(String str) {
        return loggerBuilder(str).build();
    }

    @Override // io.opentelemetry.api.logs.LoggerProvider
    public final LoggerBuilder loggerBuilder(String str) {
        if (this.isNoopLogRecordProcessor) {
            return LoggerProvider.CC.noop().loggerBuilder(str);
        }
        if (str == null || str.isEmpty()) {
            LOGGER.fine("Logger requested without instrumentation scope name.");
            str = "unknown";
        }
        return new SdkLoggerBuilder(this.loggerComponentRegistry, str);
    }

    public final CompletableResultCode forceFlush() {
        return this.sharedState.getLogRecordProcessor().forceFlush();
    }

    public final CompletableResultCode shutdown() {
        if (this.sharedState.hasBeenShutdown()) {
            LOGGER.log(Level.WARNING, "Calling shutdown() multiple times.");
            return CompletableResultCode.ofSuccess();
        }
        return this.sharedState.shutdown();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }
}
