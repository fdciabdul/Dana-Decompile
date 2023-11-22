package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import j$.util.function.BiFunction;
import j$.util.function.Function;

/* loaded from: classes8.dex */
public final /* synthetic */ class SpanFilterBuilder$$ExternalSyntheticLambda1 implements BiFunction {
    public final /* synthetic */ Function KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        AttributeKey attributeKey = (AttributeKey) obj;
        return SpanFilterBuilder.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, (Function) obj2);
    }
}
