package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregationUtil;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class ViewRegistry {
    static final RegisteredView DEFAULT_REGISTERED_VIEW;
    static final View DEFAULT_VIEW;
    private static final Logger logger;
    private final Map<InstrumentType, RegisteredView> instrumentDefaultRegisteredView = new HashMap();
    private final List<RegisteredView> registeredViews;

    public static /* synthetic */ boolean lambda$toGlobPatternPredicate$1(String str) {
        return true;
    }

    static {
        View build = View.builder().build();
        DEFAULT_VIEW = build;
        DEFAULT_REGISTERED_VIEW = RegisteredView.create(InstrumentSelector.builder().setName("*").build(), build, NoopAttributesProcessor.NOOP, SourceInfo.CC.noSourceInfo());
        logger = Logger.getLogger(ViewRegistry.class.getName());
    }

    ViewRegistry(DefaultAggregationSelector defaultAggregationSelector, List<RegisteredView> list) {
        for (InstrumentType instrumentType : InstrumentType.values()) {
            this.instrumentDefaultRegisteredView.put(instrumentType, RegisteredView.create(InstrumentSelector.builder().setName("*").build(), View.builder().setAggregation(defaultAggregationSelector.getDefaultAggregation(instrumentType)).build(), AttributesProcessor.noop(), SourceInfo.CC.noSourceInfo()));
        }
        this.registeredViews = list;
    }

    public static ViewRegistry create(DefaultAggregationSelector defaultAggregationSelector, List<RegisteredView> list) {
        return new ViewRegistry(defaultAggregationSelector, new ArrayList(list));
    }

    public static ViewRegistry create() {
        return create(new DefaultAggregationSelector() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda3
            @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public final Aggregation getDefaultAggregation(InstrumentType instrumentType) {
                Aggregation defaultAggregation;
                defaultAggregation = Aggregation.CC.defaultAggregation();
                return defaultAggregation;
            }

            @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public final /* synthetic */ DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
                return DefaultAggregationSelector.CC.$default$with(this, instrumentType, aggregation);
            }
        }, Collections.emptyList());
    }

    public final List<RegisteredView> findViews(InstrumentDescriptor instrumentDescriptor, InstrumentationScopeInfo instrumentationScopeInfo) {
        ArrayList arrayList = new ArrayList();
        for (RegisteredView registeredView : this.registeredViews) {
            if (matchesSelector(registeredView.getInstrumentSelector(), instrumentDescriptor, instrumentationScopeInfo)) {
                if (((AggregatorFactory) registeredView.getView().getAggregation()).isCompatibleWithInstrument(instrumentDescriptor)) {
                    arrayList.add(registeredView);
                } else {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append("View aggregation ");
                    sb.append(AggregationUtil.aggregationName(registeredView.getView().getAggregation()));
                    sb.append(" is incompatible with instrument ");
                    sb.append(instrumentDescriptor.getName());
                    sb.append(" of type ");
                    sb.append(instrumentDescriptor.getType());
                    logger2.log(level, sb.toString());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return Collections.unmodifiableList(arrayList);
        }
        RegisteredView registeredView2 = (RegisteredView) Objects.requireNonNull(this.instrumentDefaultRegisteredView.get(instrumentDescriptor.getType()));
        if (((AggregatorFactory) registeredView2.getView().getAggregation()).isCompatibleWithInstrument(instrumentDescriptor)) {
            return Collections.singletonList(registeredView2);
        }
        Logger logger3 = logger;
        Level level2 = Level.WARNING;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Instrument default aggregation ");
        sb2.append(AggregationUtil.aggregationName(registeredView2.getView().getAggregation()));
        sb2.append(" is incompatible with instrument ");
        sb2.append(instrumentDescriptor.getName());
        sb2.append(" of type ");
        sb2.append(instrumentDescriptor.getType());
        logger3.log(level2, sb2.toString());
        return Collections.singletonList(DEFAULT_REGISTERED_VIEW);
    }

    private static boolean matchesSelector(InstrumentSelector instrumentSelector, InstrumentDescriptor instrumentDescriptor, InstrumentationScopeInfo instrumentationScopeInfo) {
        if (instrumentSelector.getInstrumentType() == null || instrumentSelector.getInstrumentType() == instrumentDescriptor.getType()) {
            if (instrumentSelector.getInstrumentName() == null || toGlobPatternPredicate(instrumentSelector.getInstrumentName()).test(instrumentDescriptor.getName())) {
                return matchesMeter(instrumentSelector, instrumentationScopeInfo);
            }
            return false;
        }
        return false;
    }

    private static boolean matchesMeter(InstrumentSelector instrumentSelector, InstrumentationScopeInfo instrumentationScopeInfo) {
        if (instrumentSelector.getMeterName() == null || instrumentSelector.getMeterName().equals(instrumentationScopeInfo.getName())) {
            if (instrumentSelector.getMeterVersion() == null || instrumentSelector.getMeterVersion().equals(instrumentationScopeInfo.getVersion())) {
                return instrumentSelector.getMeterSchemaUrl() == null || instrumentSelector.getMeterSchemaUrl().equals(instrumentationScopeInfo.getSchemaUrl());
            }
            return false;
        }
        return false;
    }

    static Predicate<String> toGlobPatternPredicate(final String str) {
        if (str.equals("*")) {
            return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda0
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
                    return ViewRegistry.lambda$toGlobPatternPredicate$1((String) obj);
                }
            };
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '*' || charAt == '?') {
                final Pattern regexPattern = toRegexPattern(str);
                return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda1
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
                        boolean matches;
                        matches = regexPattern.matcher((String) obj).matches();
                        return matches;
                    }
                };
            }
        }
        Objects.requireNonNull(str);
        return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.ViewRegistry$$ExternalSyntheticLambda2
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
                return str.equalsIgnoreCase((String) obj);
            }
        };
    }

    private static Pattern toRegexPattern(String str) {
        StringBuilder sb = new StringBuilder();
        int i = -1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '*' || charAt == '?') {
                if (i != -1) {
                    sb.append(Pattern.quote(str.substring(i, i2)));
                    i = -1;
                }
                if (charAt == '*') {
                    sb.append(".*");
                } else {
                    sb.append(".");
                }
            } else if (i == -1) {
                i = i2;
            }
        }
        if (i != -1) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        return Pattern.compile(sb.toString());
    }
}
