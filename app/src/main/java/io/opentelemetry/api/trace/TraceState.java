package io.opentelemetry.api.trace;

import j$.util.function.BiConsumer;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface TraceState {
    Map<String, String> asMap();

    void forEach(BiConsumer<String, String> biConsumer);

    @Nullable
    String get(String str);

    boolean isEmpty();

    int size();

    TraceStateBuilder toBuilder();

    /* renamed from: io.opentelemetry.api.trace.TraceState$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static TraceState getDefault() {
            return ArrayBasedTraceStateBuilder.empty();
        }

        public static TraceStateBuilder builder() {
            return new ArrayBasedTraceStateBuilder();
        }
    }
}
