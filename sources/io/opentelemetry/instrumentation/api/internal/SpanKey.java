package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class SpanKey {
    public static final SpanKey CONSUMER_PROCESS;
    private static final ContextKey<Span> CONSUMER_PROCESS_KEY;
    public static final SpanKey CONSUMER_RECEIVE;
    private static final ContextKey<Span> CONSUMER_RECEIVE_KEY;
    public static final SpanKey DB_CLIENT;
    private static final ContextKey<Span> DB_CLIENT_KEY;
    public static final SpanKey HTTP_CLIENT;
    private static final ContextKey<Span> HTTP_CLIENT_KEY;
    public static final SpanKey HTTP_SERVER;
    private static final ContextKey<Span> HTTP_SERVER_KEY;
    public static final SpanKey KIND_CLIENT;
    private static final ContextKey<Span> KIND_CLIENT_KEY;
    public static final SpanKey KIND_CONSUMER;
    private static final ContextKey<Span> KIND_CONSUMER_KEY;
    public static final SpanKey KIND_PRODUCER;
    private static final ContextKey<Span> KIND_PRODUCER_KEY;
    public static final SpanKey KIND_SERVER;
    private static final ContextKey<Span> KIND_SERVER_KEY;
    public static final SpanKey PRODUCER;
    private static final ContextKey<Span> PRODUCER_KEY;
    public static final SpanKey RPC_CLIENT;
    private static final ContextKey<Span> RPC_CLIENT_KEY;
    public static final SpanKey RPC_SERVER;
    private static final ContextKey<Span> RPC_SERVER_KEY;
    private final ContextKey<Span> key;

    static {
        ContextKey<Span> named = ContextKey.CC.named("opentelemetry-traces-span-key-kind-server");
        KIND_SERVER_KEY = named;
        ContextKey<Span> named2 = ContextKey.CC.named("opentelemetry-traces-span-key-kind-client");
        KIND_CLIENT_KEY = named2;
        ContextKey<Span> named3 = ContextKey.CC.named("opentelemetry-traces-span-key-kind-consumer");
        KIND_CONSUMER_KEY = named3;
        ContextKey<Span> named4 = ContextKey.CC.named("opentelemetry-traces-span-key-kind-producer");
        KIND_PRODUCER_KEY = named4;
        ContextKey<Span> named5 = ContextKey.CC.named("opentelemetry-traces-span-key-http-server");
        HTTP_SERVER_KEY = named5;
        ContextKey<Span> named6 = ContextKey.CC.named("opentelemetry-traces-span-key-rpc-server");
        RPC_SERVER_KEY = named6;
        ContextKey<Span> named7 = ContextKey.CC.named("opentelemetry-traces-span-key-http-client");
        HTTP_CLIENT_KEY = named7;
        ContextKey<Span> named8 = ContextKey.CC.named("opentelemetry-traces-span-key-rpc-client");
        RPC_CLIENT_KEY = named8;
        ContextKey<Span> named9 = ContextKey.CC.named("opentelemetry-traces-span-key-db-client");
        DB_CLIENT_KEY = named9;
        ContextKey<Span> named10 = ContextKey.CC.named("opentelemetry-traces-span-key-producer");
        PRODUCER_KEY = named10;
        ContextKey<Span> named11 = ContextKey.CC.named("opentelemetry-traces-span-key-consumer-receive");
        CONSUMER_RECEIVE_KEY = named11;
        ContextKey<Span> named12 = ContextKey.CC.named("opentelemetry-traces-span-key-consumer-process");
        CONSUMER_PROCESS_KEY = named12;
        KIND_SERVER = new SpanKey(named);
        KIND_CLIENT = new SpanKey(named2);
        KIND_CONSUMER = new SpanKey(named3);
        KIND_PRODUCER = new SpanKey(named4);
        HTTP_SERVER = new SpanKey(named5);
        RPC_SERVER = new SpanKey(named6);
        HTTP_CLIENT = new SpanKey(named7);
        RPC_CLIENT = new SpanKey(named8);
        DB_CLIENT = new SpanKey(named9);
        PRODUCER = new SpanKey(named10);
        CONSUMER_RECEIVE = new SpanKey(named11);
        CONSUMER_PROCESS = new SpanKey(named12);
    }

    private SpanKey(ContextKey<Span> contextKey) {
        this.key = contextKey;
    }

    public final Context storeInContext(Context context, Span span) {
        return context.with(this.key, span);
    }

    @Nullable
    public final Span fromContextOrNull(Context context) {
        return (Span) context.get(this.key);
    }

    public final String toString() {
        return this.key.toString();
    }
}
