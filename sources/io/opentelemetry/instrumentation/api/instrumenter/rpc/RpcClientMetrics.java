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
public final class RpcClientMetrics implements OperationListener {
    private static final double NANOS_PER_MS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ContextKey<State> RPC_CLIENT_REQUEST_METRICS_STATE = ContextKey.CC.named("rpc-client-request-metrics-state");
    private static final Logger logger = Logger.getLogger(RpcClientMetrics.class.getName());
    private final DoubleHistogram clientDurationHistogram;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class State {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Attributes startAttributes();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long startTimeNanos();
    }

    public static /* synthetic */ RpcClientMetrics $r8$lambda$dvbP6pQU0vpW9COcfTgq7D4S45Y(Meter meter) {
        return new RpcClientMetrics(meter);
    }

    private RpcClientMetrics(Meter meter) {
        this.clientDurationHistogram = meter.histogramBuilder("rpc.client.duration").setDescription("The duration of an outbound RPC invocation").setUnit("ms").build();
    }

    public static OperationMetrics get() {
        return new OperationMetrics() { // from class: io.opentelemetry.instrumentation.api.instrumenter.rpc.RpcClientMetrics$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics
            public final OperationListener create(Meter meter) {
                return RpcClientMetrics.$r8$lambda$dvbP6pQU0vpW9COcfTgq7D4S45Y(meter);
            }
        };
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final Context onStart(Context context, Attributes attributes, long j) {
        return context.with(RPC_CLIENT_REQUEST_METRICS_STATE, new AutoValue_RpcClientMetrics_State(attributes, j));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final void onEnd(Context context, Attributes attributes, long j) {
        State state = (State) context.get(RPC_CLIENT_REQUEST_METRICS_STATE);
        if (state == null) {
            logger.log(Level.FINE, "No state present when ending context {0}. Cannot record RPC request metrics.", context);
            return;
        }
        DoubleHistogram doubleHistogram = this.clientDurationHistogram;
        double startTimeNanos = j - state.startTimeNanos();
        double d = NANOS_PER_MS;
        Double.isNaN(startTimeNanos);
        doubleHistogram.record(startTimeNanos / d, MetricsView.applyClientView(state.startAttributes(), attributes), context);
    }
}
