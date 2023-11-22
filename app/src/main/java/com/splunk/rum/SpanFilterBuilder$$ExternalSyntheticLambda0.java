package com.splunk.rum;

import j$.util.function.Function;
import j$.util.function.Predicate;

/* loaded from: classes8.dex */
public final /* synthetic */ class SpanFilterBuilder$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Predicate MyBillsEntityDataFactory;

    @Override // j$.util.function.Function
    /* renamed from: andThen */
    public final /* synthetic */ Function mo3169andThen(Function function) {
        return Function.CC.getAuthRequestContext(this, function);
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        return SpanFilterBuilder.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, obj);
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
    }
}
