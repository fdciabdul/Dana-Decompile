package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.instrumentation.api.internal.ContextPropagationDebug;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class PropagatingFromUpstreamInstrumenter<REQUEST, RESPONSE> extends Instrumenter<REQUEST, RESPONSE> {
    private final TextMapGetter<REQUEST> getter;
    private final ContextPropagators propagators;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PropagatingFromUpstreamInstrumenter(InstrumenterBuilder<REQUEST, RESPONSE> instrumenterBuilder, TextMapGetter<REQUEST> textMapGetter) {
        super(instrumenterBuilder);
        this.propagators = instrumenterBuilder.openTelemetry.getPropagators();
        this.getter = textMapGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.Instrumenter
    public final Context start(Context context, REQUEST request) {
        ContextPropagationDebug.debugContextLeakIfEnabled();
        return super.start(this.propagators.getTextMapPropagator().extract(context, request, this.getter), request);
    }
}
