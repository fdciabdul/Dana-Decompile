package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongHistogram;
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

/* loaded from: classes2.dex */
public final class HttpClientMetrics implements OperationListener {
    private final DoubleHistogram duration;
    private final LongHistogram requestSize;
    private final LongHistogram responseSize;
    private static final double NANOS_PER_MS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ContextKey<State> HTTP_CLIENT_REQUEST_METRICS_STATE = ContextKey.CC.named("http-client-request-metrics-state");
    private static final Logger logger = Logger.getLogger(HttpClientMetrics.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class State {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Attributes startAttributes();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long startTimeNanos();
    }

    /* renamed from: $r8$lambda$sQz-1XyyobzxVW4G8Cf4W8CJEaU  reason: not valid java name */
    public static /* synthetic */ HttpClientMetrics m3151$r8$lambda$sQz1XyyobzxVW4G8Cf4W8CJEaU(Meter meter) {
        return new HttpClientMetrics(meter);
    }

    public static OperationMetrics get() {
        return new OperationMetrics() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientMetrics$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics
            public final OperationListener create(Meter meter) {
                return HttpClientMetrics.m3151$r8$lambda$sQz1XyyobzxVW4G8Cf4W8CJEaU(meter);
            }
        };
    }

    private HttpClientMetrics(Meter meter) {
        this.duration = meter.histogramBuilder("http.client.duration").setUnit("ms").setDescription("The duration of the outbound HTTP request").build();
        this.requestSize = meter.histogramBuilder("http.client.request.size").setUnit("By").setDescription("The size of HTTP request messages").ofLongs().build();
        this.responseSize = meter.histogramBuilder("http.client.response.size").setUnit("By").setDescription("The size of HTTP response messages").ofLongs().build();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final Context onStart(Context context, Attributes attributes, long j) {
        return context.with(HTTP_CLIENT_REQUEST_METRICS_STATE, new AutoValue_HttpClientMetrics_State(attributes, j));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public final void onEnd(Context context, Attributes attributes, long j) {
        State state = (State) context.get(HTTP_CLIENT_REQUEST_METRICS_STATE);
        if (state == null) {
            logger.log(Level.FINE, "No state present when ending context {0}. Cannot record HTTP request metrics.", context);
            return;
        }
        Attributes applyClientDurationAndSizeView = TemporaryMetricsView.applyClientDurationAndSizeView(state.startAttributes(), attributes);
        DoubleHistogram doubleHistogram = this.duration;
        double startTimeNanos = j - state.startTimeNanos();
        double d = NANOS_PER_MS;
        Double.isNaN(startTimeNanos);
        doubleHistogram.record(startTimeNanos / d, applyClientDurationAndSizeView, context);
        Long l = (Long) getAttribute(SemanticAttributes.HTTP_REQUEST_CONTENT_LENGTH, attributes, state.startAttributes());
        if (l != null) {
            this.requestSize.record(l.longValue(), applyClientDurationAndSizeView);
        }
        Long l2 = (Long) getAttribute(SemanticAttributes.HTTP_RESPONSE_CONTENT_LENGTH, attributes, state.startAttributes());
        if (l2 != null) {
            this.responseSize.record(l2.longValue(), applyClientDurationAndSizeView);
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
