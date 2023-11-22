package io.opentelemetry.rum.internal;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import j$.util.function.Consumer;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class GlobalAttributesSpanAppender implements SpanProcessor {
    private final AtomicReference<Attributes> attributes;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final /* synthetic */ CompletableResultCode forceFlush() {
        CompletableResultCode ofSuccess;
        ofSuccess = CompletableResultCode.ofSuccess();
        return ofSuccess;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isEndRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final boolean isStartRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onEnd(ReadableSpan readableSpan) {
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final /* synthetic */ CompletableResultCode shutdown() {
        CompletableResultCode forceFlush;
        forceFlush = forceFlush();
        return forceFlush;
    }

    public static GlobalAttributesSpanAppender create(Attributes attributes) {
        return new GlobalAttributesSpanAppender(attributes);
    }

    private GlobalAttributesSpanAppender(Attributes attributes) {
        this.attributes = new AtomicReference<>(attributes);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public final void onStart(Context context, ReadWriteSpan readWriteSpan) {
        readWriteSpan.setAllAttributes(this.attributes.get());
    }

    public final void update(Consumer<AttributesBuilder> consumer) {
        Attributes attributes;
        AttributesBuilder builder;
        do {
            attributes = (Attributes) Objects.requireNonNull(this.attributes.get());
            builder = attributes.toBuilder();
            consumer.accept(builder);
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.attributes, attributes, builder.build()));
    }
}
