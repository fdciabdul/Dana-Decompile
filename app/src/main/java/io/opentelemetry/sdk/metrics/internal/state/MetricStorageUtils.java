package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import j$.util.Collection;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Predicate;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class MetricStorageUtils {
    static final int MAX_ACCUMULATIONS = 2000;

    private MetricStorageUtils() {
    }

    static <T, U extends ExemplarData> void mergeInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, Aggregator<T, U> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, false, new MetricStorageUtils$$ExternalSyntheticLambda2(aggregator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, U extends ExemplarData> void mergeAndPreserveInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, Aggregator<T, U> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, true, new MetricStorageUtils$$ExternalSyntheticLambda2(aggregator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, U extends ExemplarData> void diffInPlace(Map<Attributes, T> map, Map<Attributes, T> map2, final Aggregator<T, U> aggregator) {
        Objects.requireNonNull(aggregator);
        blend(map, map2, false, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda4
            @Override // j$.util.function.BiFunction
            public final /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.MyBillsEntityDataFactory(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Aggregator.this.diff(obj, obj2);
            }
        });
    }

    private static <T> void blend(final Map<Attributes, T> map, Map<Attributes, T> map2, boolean z, final BiFunction<T, T, T> biFunction) {
        if (!z) {
            removeUnseen(map, map2);
        }
        Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map2, new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda1
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, (Object) ((Attributes) obj), new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda0
                    @Override // j$.util.function.BiFunction
                    public final /* synthetic */ BiFunction andThen(Function function) {
                        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                    }

                    @Override // j$.util.function.BiFunction
                    public final Object apply(Object obj3, Object obj4) {
                        return MetricStorageUtils.lambda$blend$0(BiFunction.this, obj2, (Attributes) obj3, obj4);
                    }
                });
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$blend$0(BiFunction biFunction, Object obj, Attributes attributes, Object obj2) {
        return obj2 != null ? biFunction.apply(obj2, obj) : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$removeUnseen$2(java.util.Map map, Map.Entry entry) {
        return !map.containsKey(entry.getKey());
    }

    public static <T> void removeUnseen(java.util.Map<Attributes, T> map, final java.util.Map<Attributes, T> map2) {
        Collection.EL.BuiltInFictitiousFunctionClassFactory(map.entrySet(), new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.state.MetricStorageUtils$$ExternalSyntheticLambda3
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
                return MetricStorageUtils.lambda$removeUnseen$2(map2, (Map.Entry) obj);
            }
        });
    }
}
