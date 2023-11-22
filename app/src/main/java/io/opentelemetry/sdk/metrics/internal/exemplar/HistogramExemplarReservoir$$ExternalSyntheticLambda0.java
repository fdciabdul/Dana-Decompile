package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import j$.util.function.BiFunction;
import j$.util.function.Function;

/* loaded from: classes6.dex */
public final /* synthetic */ class HistogramExemplarReservoir$$ExternalSyntheticLambda0 implements BiFunction {
    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ReservoirCell) obj).getAndResetDouble((Attributes) obj2);
    }
}
