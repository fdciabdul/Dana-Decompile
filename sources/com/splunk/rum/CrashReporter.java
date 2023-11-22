package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashReporter {
    CrashReporter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Tracer tracer, SdkTracerProvider sdkTracerProvider, RuntimeDetails runtimeDetails) {
        InstrumentInjector.setDefaultUncaughtExceptionHandler(new CrashReportingExceptionHandler(tracer, sdkTracerProvider, InstrumentInjector.getDefaultUncaughtExceptionHandler(), runtimeDetails));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CrashReportingExceptionHandler implements Thread.UncaughtExceptionHandler {
        private final SdkTracerProvider BuiltInFictitiousFunctionClassFactory;
        private final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicBoolean(false);
        private final Thread.UncaughtExceptionHandler MyBillsEntityDataFactory;
        private final RuntimeDetails PlaceComponentResult;
        private final Tracer getAuthRequestContext;

        CrashReportingExceptionHandler(Tracer tracer, SdkTracerProvider sdkTracerProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, RuntimeDetails runtimeDetails) {
            this.getAuthRequestContext = tracer;
            this.MyBillsEntityDataFactory = uncaughtExceptionHandler;
            this.BuiltInFictitiousFunctionClassFactory = sdkTracerProvider;
            this.PlaceComponentResult = runtimeDetails;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            SpanBuilder attribute = this.getAuthRequestContext.spanBuilder(th.getClass().getSimpleName()).setAttribute((AttributeKey<AttributeKey<Long>>) SemanticAttributes.THREAD_ID, (AttributeKey<Long>) Long.valueOf(thread.getId())).setAttribute((AttributeKey<AttributeKey<String>>) SemanticAttributes.THREAD_NAME, (AttributeKey<String>) thread.getName()).setAttribute((AttributeKey<AttributeKey<Boolean>>) SemanticAttributes.EXCEPTION_ESCAPED, (AttributeKey<Boolean>) Boolean.TRUE).setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) (this.KClassImpl$Data$declaredNonStaticMembers$2.compareAndSet(false, true) ? "crash" : "error")).setAttribute((AttributeKey<AttributeKey<Long>>) SplunkRum.newProxyInstance, (AttributeKey<Long>) Long.valueOf(this.PlaceComponentResult.MyBillsEntityDataFactory.getFreeSpace())).setAttribute((AttributeKey<AttributeKey<Long>>) SplunkRum.scheduleImpl, (AttributeKey<Long>) Long.valueOf(RuntimeDetails.BuiltInFictitiousFunctionClassFactory()));
            Double d = this.PlaceComponentResult.PlaceComponentResult;
            if (d != null) {
                attribute.setAttribute((AttributeKey<AttributeKey<Double>>) SplunkRum.PlaceComponentResult, (AttributeKey<Double>) d);
            }
            attribute.startSpan().recordException(th).setStatus(StatusCode.ERROR).end();
            this.BuiltInFictitiousFunctionClassFactory.forceFlush().join(10L, TimeUnit.SECONDS);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.MyBillsEntityDataFactory;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
