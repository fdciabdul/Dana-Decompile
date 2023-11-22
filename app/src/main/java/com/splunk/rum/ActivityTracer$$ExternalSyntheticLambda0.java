package com.splunk.rum;

import j$.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class ActivityTracer$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ ActivityTracer MyBillsEntityDataFactory;

    public /* synthetic */ ActivityTracer$$ExternalSyntheticLambda0(ActivityTracer activityTracer, String str) {
        this.MyBillsEntityDataFactory = activityTracer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        return this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, null);
    }
}
