package com.splunk.rum;

import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class BandwidthTracker$$ExternalSyntheticLambda1 implements BinaryOperator {
    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return Long.valueOf(((Long) obj).longValue() + ((Long) obj2).longValue());
    }
}
