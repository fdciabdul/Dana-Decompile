package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.instrumentation.api.instrumenter.OperationListener;
import io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class HttpServerMetrics implements OperationListener {
    private final LongUpDownCounter activeRequests;
    private final DoubleHistogram duration;
    private final LongHistogram requestSize;
    private final LongHistogram responseSize;
    private static final double NANOS_PER_MS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ContextKey<State> HTTP_SERVER_REQUEST_METRICS_STATE = ContextKey.CC.named("http-server-request-metrics-state");
    private static final Logger logger = Logger.getLogger(HttpServerMetrics.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class State {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Attributes startAttributes();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long startTimeNanos();
    }

    public static /* synthetic */ HttpServerMetrics $r8$lambda$lXTOgjw2GuFlvWUPABSORE6pwqk(Meter meter) {
        return new HttpServerMetrics(meter);
    }

    public static OperationMetrics get() {
        return new OperationMetrics() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerMetrics$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics
            public final OperationListener create(Meter meter) {
                return HttpServerMetrics.$r8$lambda$lXTOgjw2GuFlvWUPABSORE6pwqk(meter);
            }
        };
    }

    private HttpServerMetrics(Meter meter) {
        this.activeRequests = meter.upDownCounterBuilder("http.server.active_requests").setUnit("requests").setDescription("The number of concurrent HTTP requests that are currently in-flight").build();
        this.duration = meter.histogramBuilder("http.server.duration").setUnit("ms").setDescription("The duration of the inbound HTTP request").build();
        this.requestSize = meter.histogramBuilder("http.server.request.size").setUnit("By").setDescription("The size of HTTP request messages").ofLongs().build();
        this.responseSize = meter.histogramBuilder("http.server.response.size").setUnit("By").setDescription("The size of HTTP response messages").ofLongs().build();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final Context onStart(Context context, Attributes attributes, long j) {
        this.activeRequests.add(1L, TemporaryMetricsView.applyActiveRequestsView(attributes), context);
        return context.with(HTTP_SERVER_REQUEST_METRICS_STATE, new AutoValue_HttpServerMetrics_State(attributes, j));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final void onEnd(Context context, Attributes attributes, long j) {
        State state = (State) context.get(HTTP_SERVER_REQUEST_METRICS_STATE);
        if (state == null) {
            logger.log(Level.FINE, "No state present when ending context {0}. Cannot record HTTP request metrics.", context);
            return;
        }
        this.activeRequests.add(-1L, TemporaryMetricsView.applyActiveRequestsView(state.startAttributes()), context);
        Attributes applyServerDurationAndSizeView = TemporaryMetricsView.applyServerDurationAndSizeView(state.startAttributes(), attributes);
        DoubleHistogram doubleHistogram = this.duration;
        double startTimeNanos = j - state.startTimeNanos();
        double d = NANOS_PER_MS;
        Double.isNaN(startTimeNanos);
        doubleHistogram.record(startTimeNanos / d, applyServerDurationAndSizeView, context);
        Long l = (Long) getAttribute(SemanticAttributes.HTTP_REQUEST_CONTENT_LENGTH, attributes, state.startAttributes());
        if (l != null) {
            this.requestSize.record(l.longValue(), applyServerDurationAndSizeView);
        }
        Long l2 = (Long) getAttribute(SemanticAttributes.HTTP_RESPONSE_CONTENT_LENGTH, attributes, state.startAttributes());
        if (l2 != null) {
            this.responseSize.record(l2.longValue(), applyServerDurationAndSizeView);
        }
    }

    @Nullable
    private static <T> T getAttribute(AttributeKey<T> attributeKey, Attributes... attributesArr) {
        for (Attributes attributes : attributesArr) {
            T t = (T) attributes.get(attributeKey);
            if (t != null) {
                return t;
            }
        }
        return null;
    }
}
