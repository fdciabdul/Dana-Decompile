package io.opentelemetry.api.trace;

/* loaded from: classes6.dex */
public interface TraceStateBuilder {
    TraceState build();

    TraceStateBuilder put(String str, String str2);

    TraceStateBuilder remove(String str);
}
