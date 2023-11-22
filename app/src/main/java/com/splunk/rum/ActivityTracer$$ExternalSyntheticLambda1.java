package com.splunk.rum;

import com.alibaba.ariver.kernel.api.track.TrackId;
import id.dana.domain.foundation.logger.PerformanceConstant;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import j$.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class ActivityTracer$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ ActivityTracer BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ ActivityTracer$$ExternalSyntheticLambda1(ActivityTracer activityTracer, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = activityTracer;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        ActivityTracer activityTracer = this.BuiltInFictitiousFunctionClassFactory;
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2 && activityTracer.MyBillsEntityDataFactory.equals(activityTracer.PlaceComponentResult.get())) {
            Span PlaceComponentResult = activityTracer.PlaceComponentResult(TrackId.Stub_AppStart, null);
            PlaceComponentResult.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda8, (AttributeKey<String>) PerformanceConstant.HOT_START_PREFIX);
            PlaceComponentResult.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) "appstart");
            return PlaceComponentResult;
        }
        return activityTracer.PlaceComponentResult("Restarted", null);
    }
}
