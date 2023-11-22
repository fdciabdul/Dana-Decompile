package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.instrumentation.api.instrumenter.OperationListener;
import io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes9.dex */
public final class RpcServerMetrics implements OperationListener {
    private static final double NANOS_PER_MS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ContextKey<State> RPC_SERVER_REQUEST_METRICS_STATE = ContextKey.CC.named("rpc-server-request-metrics-state");
    private static final Logger logger = Logger.getLogger(RpcServerMetrics.class.getName());
    private final DoubleHistogram serverDurationHistogram;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class State {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Attributes startAttributes();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long startTimeNanos();
    }

    public static /* synthetic */ RpcServerMetrics $r8$lambda$wKN268z9UiAMjHggvlrXsl42Eco(Meter meter) {
        return new RpcServerMetrics(meter);
    }

    private RpcServerMetrics(Meter meter) {
        this.serverDurationHistogram = meter.histogramBuilder("rpc.server.duration").setDescription("The duration of an inbound RPC invocation").setUnit("ms").build();
    }

    public static OperationMetrics get() {
        return new OperationMetrics() { // from class: io.opentelemetry.instrumentation.api.instrumenter.rpc.RpcServerMetrics$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics
            public final OperationListener create(Meter meter) {
                return RpcServerMetrics.$r8$lambda$wKN268z9UiAMjHggvlrXsl42Eco(meter);
            }
        };
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final Context onStart(Context context, Attributes attributes, long j) {
        return context.with(RPC_SERVER_REQUEST_METRICS_STATE, new AutoValue_RpcServerMetrics_State(attributes, j));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final void onEnd(Context context, Attributes attributes, long j) {
        State state = (State) context.get(RPC_SERVER_REQUEST_METRICS_STATE);
        if (state == null) {
            logger.log(Level.FINE, "No state present when ending context {0}. Cannot record RPC request metrics.", context);
            return;
        }
        DoubleHistogram doubleHistogram = this.serverDurationHistogram;
        double startTimeNanos = j - state.startTimeNanos();
        double d = NANOS_PER_MS;
        Double.isNaN(startTimeNanos);
        doubleHistogram.record(startTimeNanos / d, MetricsView.applyServerView(state.startAttributes(), attributes), context);
    }
}
