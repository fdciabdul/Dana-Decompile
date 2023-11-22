package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;

/* loaded from: classes2.dex */
final class SdkTracer implements Tracer {
    static final String FALLBACK_SPAN_NAME = "<unspecified span name>";
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final TracerSharedState sharedState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracer(TracerSharedState tracerSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        this.sharedState = tracerSharedState;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.api.trace.Tracer
    public final SpanBuilder spanBuilder(String str) {
        if (str == null || str.trim().isEmpty()) {
            str = FALLBACK_SPAN_NAME;
        }
        if (this.sharedState.hasBeenShutdown()) {
            return TracerProvider.CC.noop().get(this.instrumentationScopeInfo.getName()).spanBuilder(str);
        }
        InstrumentationScopeInfo instrumentationScopeInfo = this.instrumentationScopeInfo;
        TracerSharedState tracerSharedState = this.sharedState;
        return new SdkSpanBuilder(str, instrumentationScopeInfo, tracerSharedState, tracerSharedState.getSpanLimits());
    }

    final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }
}
