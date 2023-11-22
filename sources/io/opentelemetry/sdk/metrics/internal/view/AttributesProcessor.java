package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import j$.util.Collection;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes6.dex */
public abstract class AttributesProcessor {
    public abstract Attributes process(Attributes attributes, Context context);

    public abstract boolean usesContext();

    public AttributesProcessor then(AttributesProcessor attributesProcessor) {
        if (attributesProcessor == NoopAttributesProcessor.NOOP) {
            return this;
        }
        if (this == NoopAttributesProcessor.NOOP) {
            return attributesProcessor;
        }
        if (attributesProcessor instanceof JoinedAttributesProcessor) {
            return ((JoinedAttributesProcessor) attributesProcessor).prepend(this);
        }
        return new JoinedAttributesProcessor(Arrays.asList(this, attributesProcessor));
    }

    public static AttributesProcessor noop() {
        return NoopAttributesProcessor.NOOP;
    }

    public static AttributesProcessor filterByKeyName(final Predicate<String> predicate) {
        return simple(new UnaryOperator() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                Attributes build;
                build = ((Attributes) obj).toBuilder().removeIf(new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda3
                    @Override // j$.util.function.Predicate
                    public final /* synthetic */ Predicate and(Predicate predicate2) {
                        return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate2);
                    }

                    @Override // j$.util.function.Predicate
                    public final /* synthetic */ Predicate negate() {
                        return Predicate.CC.PlaceComponentResult(this);
                    }

                    @Override // j$.util.function.Predicate
                    public final /* synthetic */ Predicate or(Predicate predicate2) {
                        return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate2);
                    }

                    @Override // j$.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return AttributesProcessor.lambda$filterByKeyName$0(Predicate.this, (AttributeKey) obj2);
                    }
                }).build();
                return build;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$filterByKeyName$0(Predicate predicate, AttributeKey attributeKey) {
        return !predicate.test(attributeKey.getKey());
    }

    public static AttributesProcessor appendBaggageByKeyName(final Predicate<String> predicate) {
        return onBaggage(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiFunction
            public final /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.MyBillsEntityDataFactory(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AttributesProcessor.lambda$appendBaggageByKeyName$3(Predicate.this, (Attributes) obj, (Baggage) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Attributes lambda$appendBaggageByKeyName$3(final Predicate predicate, Attributes attributes, Baggage baggage) {
        final AttributesBuilder builder = Attributes.CC.builder();
        baggage.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda4
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AttributesProcessor.lambda$appendBaggageByKeyName$2(Predicate.this, builder, (String) obj, (BaggageEntry) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        builder.putAll(attributes);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$appendBaggageByKeyName$2(Predicate predicate, AttributesBuilder attributesBuilder, String str, BaggageEntry baggageEntry) {
        if (predicate.test(str)) {
            attributesBuilder.put(str, baggageEntry.getValue());
        }
    }

    public static AttributesProcessor append(final Attributes attributes) {
        return simple(new UnaryOperator() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                Attributes build;
                build = Attributes.this.toBuilder().putAll((Attributes) obj).build();
                return build;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    static AttributesProcessor simple(final UnaryOperator<Attributes> unaryOperator) {
        return new AttributesProcessor() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor.1
            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public boolean usesContext() {
                return false;
            }

            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public Attributes process(Attributes attributes, Context context) {
                return (Attributes) UnaryOperator.this.apply(attributes);
            }
        };
    }

    static AttributesProcessor onBaggage(final BiFunction<Attributes, Baggage, Attributes> biFunction) {
        return new AttributesProcessor() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor.2
            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public boolean usesContext() {
                return true;
            }

            @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
            public Attributes process(Attributes attributes, Context context) {
                return (Attributes) BiFunction.this.apply(attributes, Baggage.CC.fromContext(context));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class JoinedAttributesProcessor extends AttributesProcessor {
        private final Collection<AttributesProcessor> processors;
        private final boolean usesContextCache;

        JoinedAttributesProcessor(Collection<AttributesProcessor> collection) {
            this.processors = collection;
            this.usesContextCache = ((Boolean) Collection.EL.getAuthRequestContext(collection).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$JoinedAttributesProcessor$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((AttributesProcessor) obj).usesContext());
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).getAuthRequestContext(Boolean.FALSE, new BinaryOperator() { // from class: io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor$JoinedAttributesProcessor$$ExternalSyntheticLambda1
                @Override // j$.util.function.BiFunction
                public final /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Boolean valueOf;
                    Boolean bool = (Boolean) obj;
                    Boolean bool2 = (Boolean) obj2;
                    valueOf = Boolean.valueOf(r0.booleanValue() || r1.booleanValue());
                    return valueOf;
                }
            })).booleanValue();
        }

        @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public final Attributes process(Attributes attributes, Context context) {
            Iterator<AttributesProcessor> it = this.processors.iterator();
            while (it.hasNext()) {
                attributes = it.next().process(attributes, context);
            }
            return attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public final boolean usesContext() {
            return this.usesContextCache;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor
        public final AttributesProcessor then(AttributesProcessor attributesProcessor) {
            ArrayList arrayList = new ArrayList(this.processors);
            if (attributesProcessor instanceof JoinedAttributesProcessor) {
                arrayList.addAll(((JoinedAttributesProcessor) attributesProcessor).processors);
            } else {
                arrayList.add(attributesProcessor);
            }
            return new JoinedAttributesProcessor(arrayList);
        }

        final AttributesProcessor prepend(AttributesProcessor attributesProcessor) {
            ArrayList arrayList = new ArrayList(this.processors.size() + 1);
            arrayList.add(attributesProcessor);
            arrayList.addAll(this.processors);
            return new JoinedAttributesProcessor(arrayList);
        }
    }
}
