package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapSetter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class PropagatingToDownstreamInstrumenter<REQUEST, RESPONSE> extends Instrumenter<REQUEST, RESPONSE> {
    private final ContextPropagators propagators;
    private final TextMapSetter<REQUEST> setter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PropagatingToDownstreamInstrumenter(InstrumenterBuilder<REQUEST, RESPONSE> instrumenterBuilder, TextMapSetter<REQUEST> textMapSetter) {
        super(instrumenterBuilder);
        this.propagators = instrumenterBuilder.openTelemetry.getPropagators();
        this.setter = textMapSetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.Instrumenter
    public final Context start(Context context, REQUEST request) {
        Context start = super.start(context, request);
        this.propagators.getTextMapPropagator().inject(start, request, this.setter);
        return start;
    }
}
