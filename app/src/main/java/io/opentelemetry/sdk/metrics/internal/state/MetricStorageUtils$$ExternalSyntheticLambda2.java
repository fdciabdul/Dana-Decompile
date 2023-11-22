package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import j$.util.function.BiFunction;
import j$.util.function.Function;

/* loaded from: classes9.dex */
public final /* synthetic */ class MetricStorageUtils$$ExternalSyntheticLambda2 implements BiFunction {
    public final /* synthetic */ Aggregator f$0;

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f$0.merge(obj, obj2);
    }
}
