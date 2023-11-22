package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Predicate;

/* loaded from: classes8.dex */
public final /* synthetic */ class SpanFilterBuilder$$ExternalSyntheticLambda2 implements BiFunction {
    public final /* synthetic */ Predicate PlaceComponentResult;

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        AttributeKey attributeKey = (AttributeKey) obj;
        return SpanFilterBuilder.MyBillsEntityDataFactory(this.PlaceComponentResult, (Predicate) obj2);
    }
}
