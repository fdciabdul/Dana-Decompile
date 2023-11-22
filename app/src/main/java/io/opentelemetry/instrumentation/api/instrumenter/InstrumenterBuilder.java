package io.opentelemetry.instrumentation.api.instrumenter;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapSetter;
import io.opentelemetry.instrumentation.api.instrumenter.ErrorCauseExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.SpanStatusExtractor;
import io.opentelemetry.instrumentation.api.internal.ConfigPropertiesUtil;
import io.opentelemetry.instrumentation.api.internal.EmbeddedInstrumentationProperties;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class InstrumenterBuilder<REQUEST, RESPONSE> {
    private static final SpanSuppressionStrategy spanSuppressionStrategy = SpanSuppressionStrategy.fromConfig(ConfigPropertiesUtil.getString("otel.instrumentation.experimental.span-suppression-strategy"));
    final String instrumentationName;
    @Nullable
    private String instrumentationVersion;
    final OpenTelemetry openTelemetry;
    final SpanNameExtractor<? super REQUEST> spanNameExtractor;
    final List<SpanLinksExtractor<? super REQUEST>> spanLinksExtractors = new ArrayList();
    final List<AttributesExtractor<? super REQUEST, ? super RESPONSE>> attributesExtractors = new ArrayList();
    final List<ContextCustomizer<? super REQUEST>> contextCustomizers = new ArrayList();
    private final List<OperationListener> operationListeners = new ArrayList();
    private final List<OperationMetrics> operationMetrics = new ArrayList();
    @Nullable
    private String schemaUrl = null;
    SpanKindExtractor<? super REQUEST> spanKindExtractor = SpanKindExtractor.CC.alwaysInternal();
    SpanStatusExtractor<? super REQUEST, ? super RESPONSE> spanStatusExtractor = SpanStatusExtractor.CC.getDefault();
    ErrorCauseExtractor errorCauseExtractor = ErrorCauseExtractor.CC.getDefault();
    boolean enabled = true;

    public InstrumenterBuilder(OpenTelemetry openTelemetry, String str, SpanNameExtractor<? super REQUEST> spanNameExtractor) {
        this.openTelemetry = openTelemetry;
        this.instrumentationName = str;
        this.spanNameExtractor = spanNameExtractor;
        this.instrumentationVersion = EmbeddedInstrumentationProperties.findVersion(str);
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> setInstrumentationVersion(String str) {
        this.instrumentationVersion = (String) Objects.requireNonNull(str, "instrumentationVersion");
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> setSchemaUrl(String str) {
        this.schemaUrl = (String) Objects.requireNonNull(str, "schemaUrl");
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> setSpanStatusExtractor(SpanStatusExtractor<? super REQUEST, ? super RESPONSE> spanStatusExtractor) {
        this.spanStatusExtractor = (SpanStatusExtractor) Objects.requireNonNull(spanStatusExtractor, "spanStatusExtractor");
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> addAttributesExtractor(AttributesExtractor<? super REQUEST, ? super RESPONSE> attributesExtractor) {
        this.attributesExtractors.add((AttributesExtractor) Objects.requireNonNull(attributesExtractor, "attributesExtractor"));
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> addAttributesExtractors(Iterable<? extends AttributesExtractor<? super REQUEST, ? super RESPONSE>> iterable) {
        Iterable.EL.MyBillsEntityDataFactory(iterable, new Consumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda3
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                InstrumenterBuilder.this.addAttributesExtractor((AttributesExtractor) obj);
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.PlaceComponentResult(this, consumer);
            }
        });
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> addSpanLinksExtractor(SpanLinksExtractor<REQUEST> spanLinksExtractor) {
        this.spanLinksExtractors.add((SpanLinksExtractor) Objects.requireNonNull(spanLinksExtractor, "spanLinksExtractor"));
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> addContextCustomizer(ContextCustomizer<? super REQUEST> contextCustomizer) {
        this.contextCustomizers.add((ContextCustomizer) Objects.requireNonNull(contextCustomizer, "contextCustomizer"));
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> addOperationListener(OperationListener operationListener) {
        this.operationListeners.add((OperationListener) Objects.requireNonNull(operationListener, "operationListener"));
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> addOperationMetrics(OperationMetrics operationMetrics) {
        this.operationMetrics.add((OperationMetrics) Objects.requireNonNull(operationMetrics, "operationMetrics"));
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> setErrorCauseExtractor(ErrorCauseExtractor errorCauseExtractor) {
        this.errorCauseExtractor = (ErrorCauseExtractor) Objects.requireNonNull(errorCauseExtractor, "errorCauseExtractor");
        return this;
    }

    public final InstrumenterBuilder<REQUEST, RESPONSE> setEnabled(boolean z) {
        this.enabled = z;
        return this;
    }

    public final Instrumenter<REQUEST, RESPONSE> buildClientInstrumenter(TextMapSetter<REQUEST> textMapSetter) {
        return buildInstrumenter(InstrumenterConstructor.CC.propagatingToDownstream((TextMapSetter) Objects.requireNonNull(textMapSetter, "setter")), SpanKindExtractor.CC.alwaysClient());
    }

    public final Instrumenter<REQUEST, RESPONSE> buildServerInstrumenter(TextMapGetter<REQUEST> textMapGetter) {
        return buildInstrumenter(InstrumenterConstructor.CC.propagatingFromUpstream((TextMapGetter) Objects.requireNonNull(textMapGetter, "getter")), SpanKindExtractor.CC.alwaysServer());
    }

    public final Instrumenter<REQUEST, RESPONSE> buildProducerInstrumenter(TextMapSetter<REQUEST> textMapSetter) {
        return buildInstrumenter(InstrumenterConstructor.CC.propagatingToDownstream((TextMapSetter) Objects.requireNonNull(textMapSetter, "setter")), SpanKindExtractor.CC.alwaysProducer());
    }

    public final Instrumenter<REQUEST, RESPONSE> buildConsumerInstrumenter(TextMapGetter<REQUEST> textMapGetter) {
        return buildInstrumenter(InstrumenterConstructor.CC.propagatingFromUpstream((TextMapGetter) Objects.requireNonNull(textMapGetter, "getter")), SpanKindExtractor.CC.alwaysConsumer());
    }

    public final Instrumenter<REQUEST, RESPONSE> buildInstrumenter() {
        return buildInstrumenter(InstrumenterConstructor.CC.internal(), SpanKindExtractor.CC.alwaysInternal());
    }

    public final Instrumenter<REQUEST, RESPONSE> buildInstrumenter(SpanKindExtractor<? super REQUEST> spanKindExtractor) {
        return buildInstrumenter(InstrumenterConstructor.CC.internal(), (SpanKindExtractor) Objects.requireNonNull(spanKindExtractor, "spanKindExtractor"));
    }

    private Instrumenter<REQUEST, RESPONSE> buildInstrumenter(InstrumenterConstructor<REQUEST, RESPONSE> instrumenterConstructor, SpanKindExtractor<? super REQUEST> spanKindExtractor) {
        this.spanKindExtractor = spanKindExtractor;
        return instrumenterConstructor.create(this);
    }

    public final Tracer buildTracer() {
        TracerBuilder tracerBuilder = this.openTelemetry.getTracerProvider().tracerBuilder(this.instrumentationName);
        String str = this.instrumentationVersion;
        if (str != null) {
            tracerBuilder.setInstrumentationVersion(str);
        }
        String str2 = this.schemaUrl;
        if (str2 != null) {
            tracerBuilder.setSchemaUrl(str2);
        }
        return tracerBuilder.build();
    }

    public final List<OperationListener> buildOperationListeners() {
        if (this.operationMetrics.isEmpty()) {
            return new ArrayList(this.operationListeners);
        }
        ArrayList arrayList = new ArrayList(this.operationListeners.size() + this.operationMetrics.size());
        arrayList.addAll(this.operationListeners);
        MeterBuilder meterBuilder = this.openTelemetry.getMeterProvider().meterBuilder(this.instrumentationName);
        String str = this.instrumentationVersion;
        if (str != null) {
            meterBuilder.setInstrumentationVersion(str);
        }
        String str2 = this.schemaUrl;
        if (str2 != null) {
            meterBuilder.setSchemaUrl(str2);
        }
        Meter build = meterBuilder.build();
        Iterator<OperationMetrics> it = this.operationMetrics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().create(build));
        }
        return arrayList;
    }

    public final SpanSuppressor buildSpanSuppressor() {
        return spanSuppressionStrategy.create(getSpanKeysFromAttributesExtractors());
    }

    private Set<SpanKey> getSpanKeysFromAttributesExtractors() {
        final Class<SpanKeyProvider> cls = SpanKeyProvider.class;
        Stream authRequestContext = Collection.EL.getAuthRequestContext(this.attributesExtractors).getAuthRequestContext(new Predicate() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((AttributesExtractor) obj);
            }
        });
        final Class<SpanKeyProvider> cls2 = SpanKeyProvider.class;
        return (Set) authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return (SpanKeyProvider) cls2.cast((AttributesExtractor) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).getAuthRequestContext(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return InstrumenterBuilder.lambda$getSpanKeysFromAttributesExtractors$0((SpanKeyProvider) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public static /* synthetic */ Stream lambda$getSpanKeysFromAttributesExtractors$0(SpanKeyProvider spanKeyProvider) {
        SpanKey internalGetSpanKey = spanKeyProvider.internalGetSpanKey();
        return internalGetSpanKey == null ? Stream.CC.getAuthRequestContext(new SpanKey[0]) : Stream.CC.MyBillsEntityDataFactory(internalGetSpanKey);
    }

    /* loaded from: classes6.dex */
    public interface InstrumenterConstructor<RQ, RS> {
        Instrumenter<RQ, RS> create(InstrumenterBuilder<RQ, RS> instrumenterBuilder);

        @SynthesizedClassV2(kind = 7, versionHash = "5e5398f0546d1d7afd62641edb14d82894f11ddc41bce363a0c8d0dac82c9c5a")
        /* renamed from: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$-CC */
        /* loaded from: classes6.dex */
        public final /* synthetic */ class CC<RQ, RS> {
            public static <RQ, RS> InstrumenterConstructor<RQ, RS> internal() {
                return new InstrumenterConstructor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$$ExternalSyntheticLambda1
                    @Override // io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder.InstrumenterConstructor
                    public final Instrumenter create(InstrumenterBuilder instrumenterBuilder) {
                        return new Instrumenter(instrumenterBuilder);
                    }
                };
            }

            public static /* synthetic */ Instrumenter lambda$propagatingToDownstream$0(TextMapSetter textMapSetter, InstrumenterBuilder instrumenterBuilder) {
                return new PropagatingToDownstreamInstrumenter(instrumenterBuilder, textMapSetter);
            }

            public static <RQ, RS> InstrumenterConstructor<RQ, RS> propagatingToDownstream(final TextMapSetter<RQ> textMapSetter) {
                return new InstrumenterConstructor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$$ExternalSyntheticLambda2
                    @Override // io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder.InstrumenterConstructor
                    public final Instrumenter create(InstrumenterBuilder instrumenterBuilder) {
                        return InstrumenterBuilder.InstrumenterConstructor.CC.lambda$propagatingToDownstream$0(TextMapSetter.this, instrumenterBuilder);
                    }
                };
            }

            public static /* synthetic */ Instrumenter lambda$propagatingFromUpstream$1(TextMapGetter textMapGetter, InstrumenterBuilder instrumenterBuilder) {
                return new PropagatingFromUpstreamInstrumenter(instrumenterBuilder, textMapGetter);
            }

            public static <RQ, RS> InstrumenterConstructor<RQ, RS> propagatingFromUpstream(final TextMapGetter<RQ> textMapGetter) {
                return new InstrumenterConstructor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$$ExternalSyntheticLambda0
                    @Override // io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder.InstrumenterConstructor
                    public final Instrumenter create(InstrumenterBuilder instrumenterBuilder) {
                        return InstrumenterBuilder.InstrumenterConstructor.CC.lambda$propagatingFromUpstream$1(TextMapGetter.this, instrumenterBuilder);
                    }
                };
            }
        }
    }
}
