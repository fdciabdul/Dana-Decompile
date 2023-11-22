package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class Instrumenter<REQUEST, RESPONSE> {
    private static final SupportabilityMetrics supportability = SupportabilityMetrics.instance();
    private final List<? extends AttributesExtractor<? super REQUEST, ? super RESPONSE>> attributesExtractors;
    private final List<? extends ContextCustomizer<? super REQUEST>> contextCustomizers;
    private final boolean enabled;
    private final ErrorCauseExtractor errorCauseExtractor;
    private final String instrumentationName;
    private final List<? extends OperationListener> operationListeners;
    private final SpanKindExtractor<? super REQUEST> spanKindExtractor;
    private final List<? extends SpanLinksExtractor<? super REQUEST>> spanLinksExtractors;
    private final SpanNameExtractor<? super REQUEST> spanNameExtractor;
    private final SpanStatusExtractor<? super REQUEST, ? super RESPONSE> spanStatusExtractor;
    private final SpanSuppressor spanSuppressor;
    private final Tracer tracer;

    public static <REQUEST, RESPONSE> InstrumenterBuilder<REQUEST, RESPONSE> builder(OpenTelemetry openTelemetry, String str, SpanNameExtractor<? super REQUEST> spanNameExtractor) {
        return new InstrumenterBuilder<>(openTelemetry, str, spanNameExtractor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Instrumenter(InstrumenterBuilder<REQUEST, RESPONSE> instrumenterBuilder) {
        this.instrumentationName = instrumenterBuilder.instrumentationName;
        this.tracer = instrumenterBuilder.buildTracer();
        this.spanNameExtractor = instrumenterBuilder.spanNameExtractor;
        this.spanKindExtractor = instrumenterBuilder.spanKindExtractor;
        this.spanStatusExtractor = instrumenterBuilder.spanStatusExtractor;
        this.spanLinksExtractors = new ArrayList(instrumenterBuilder.spanLinksExtractors);
        this.attributesExtractors = new ArrayList(instrumenterBuilder.attributesExtractors);
        this.contextCustomizers = new ArrayList(instrumenterBuilder.contextCustomizers);
        this.operationListeners = instrumenterBuilder.buildOperationListeners();
        this.errorCauseExtractor = instrumenterBuilder.errorCauseExtractor;
        this.enabled = instrumenterBuilder.enabled;
        this.spanSuppressor = instrumenterBuilder.buildSpanSuppressor();
    }

    public boolean shouldStart(Context context, REQUEST request) {
        if (this.enabled) {
            SpanKind extract = this.spanKindExtractor.extract(request);
            boolean shouldSuppress = this.spanSuppressor.shouldSuppress(context, extract);
            if (shouldSuppress) {
                supportability.recordSuppressedSpan(extract, this.instrumentationName);
            }
            return !shouldSuppress;
        }
        return false;
    }

    public Context start(Context context, REQUEST request) {
        return doStart(context, request, null);
    }

    public void end(Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        doEnd(context, request, response, th, null);
    }

    Context startAndEnd(Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th, Instant instant, Instant instant2) {
        Context doStart = doStart(context, request, instant);
        doEnd(doStart, request, response, th, instant2);
        return doStart;
    }

    private Context doStart(Context context, REQUEST request, @Nullable Instant instant) {
        SpanKind extract = this.spanKindExtractor.extract(request);
        SpanBuilder spanKind = this.tracer.spanBuilder(this.spanNameExtractor.extract(request)).setSpanKind(extract);
        if (instant != null) {
            spanKind.setStartTimestamp(instant);
        }
        SpanLinksBuilderImpl spanLinksBuilderImpl = new SpanLinksBuilderImpl(spanKind);
        Iterator<? extends SpanLinksExtractor<? super REQUEST>> it = this.spanLinksExtractors.iterator();
        while (it.hasNext()) {
            it.next().extract(spanLinksBuilderImpl, context, request);
        }
        UnsafeAttributes unsafeAttributes = new UnsafeAttributes();
        Iterator<? extends AttributesExtractor<? super REQUEST, ? super RESPONSE>> it2 = this.attributesExtractors.iterator();
        while (it2.hasNext()) {
            it2.next().onStart(unsafeAttributes, context, request);
        }
        Iterator<? extends ContextCustomizer<? super REQUEST>> it3 = this.contextCustomizers.iterator();
        while (it3.hasNext()) {
            context = it3.next().onStart(context, request, unsafeAttributes);
        }
        boolean isLocalRoot = LocalRootSpan.isLocalRoot(context);
        spanKind.setAllAttributes(unsafeAttributes);
        Span startSpan = spanKind.setParent(context).startSpan();
        Context with = context.with(startSpan);
        if (!this.operationListeners.isEmpty()) {
            long nanos = getNanos(instant);
            Iterator<? extends OperationListener> it4 = this.operationListeners.iterator();
            while (it4.hasNext()) {
                with = it4.next().onStart(with, unsafeAttributes, nanos);
            }
        }
        if (isLocalRoot) {
            with = LocalRootSpan.store(with, startSpan);
        }
        return this.spanSuppressor.storeInContext(with, extract, startSpan);
    }

    private void doEnd(Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th, @Nullable Instant instant) {
        Span fromContext = Span.CC.fromContext(context);
        if (th != null) {
            th = this.errorCauseExtractor.extract(th);
            fromContext.recordException(th);
        }
        UnsafeAttributes unsafeAttributes = new UnsafeAttributes();
        Iterator<? extends AttributesExtractor<? super REQUEST, ? super RESPONSE>> it = this.attributesExtractors.iterator();
        while (it.hasNext()) {
            it.next().onEnd(unsafeAttributes, context, request, response, th);
        }
        fromContext.setAllAttributes(unsafeAttributes);
        if (!this.operationListeners.isEmpty()) {
            long nanos = getNanos(instant);
            List<? extends OperationListener> list = this.operationListeners;
            ListIterator<? extends OperationListener> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                listIterator.previous().onEnd(context, unsafeAttributes, nanos);
            }
        }
        this.spanStatusExtractor.extract(new SpanStatusBuilderImpl(fromContext), request, response, th);
        if (instant != null) {
            fromContext.end(instant);
        } else {
            fromContext.end();
        }
    }

    private static long getNanos(@Nullable Instant instant) {
        if (instant == null) {
            return System.nanoTime();
        }
        return TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + instant.getNano();
    }
}
