package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerMetrics;

/* loaded from: classes9.dex */
final class AutoValue_HttpServerMetrics_State extends HttpServerMetrics.State {
    private final Attributes startAttributes;
    private final long startTimeNanos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_HttpServerMetrics_State(Attributes attributes, long j) {
        if (attributes == null) {
            throw new NullPointerException("Null startAttributes");
        }
        this.startAttributes = attributes;
        this.startTimeNanos = j;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerMetrics.State
    final Attributes startAttributes() {
        return this.startAttributes;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerMetrics.State
    final long startTimeNanos() {
        return this.startTimeNanos;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("State{startAttributes=");
        sb.append(this.startAttributes);
        sb.append(", startTimeNanos=");
        sb.append(this.startTimeNanos);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HttpServerMetrics.State) {
            HttpServerMetrics.State state = (HttpServerMetrics.State) obj;
            return this.startAttributes.equals(state.startAttributes()) && this.startTimeNanos == state.startTimeNanos();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.startAttributes.hashCode();
        long j = this.startTimeNanos;
        return ((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
