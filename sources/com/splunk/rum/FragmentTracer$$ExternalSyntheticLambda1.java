package com.splunk.rum;

import j$.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class FragmentTracer$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ FragmentTracer getAuthRequestContext;

    public /* synthetic */ FragmentTracer$$ExternalSyntheticLambda1(FragmentTracer fragmentTracer, String str) {
        this.getAuthRequestContext = fragmentTracer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
