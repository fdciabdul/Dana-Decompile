package com.splunk.rum;

import android.app.Activity;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alipay.mobile.security.bio.api.BioDetector;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ActivityTracer {
    static final AttributeKey<String> BuiltInFictitiousFunctionClassFactory = AttributeKey.CC.stringKey("activityName");
    final AppStartupTimer KClassImpl$Data$declaredNonStaticMembers$2;
    final String MyBillsEntityDataFactory;
    private final Tracer NetworkUserEntityData$$ExternalSyntheticLambda0;
    final AtomicReference<String> PlaceComponentResult;
    final ActiveSpan getAuthRequestContext;
    private final String lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityTracer(Activity activity, AtomicReference<String> atomicReference, Tracer tracer, VisibleScreenTracker visibleScreenTracker, AppStartupTimer appStartupTimer) {
        this.PlaceComponentResult = atomicReference;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = tracer;
        String simpleName = activity.getClass().getSimpleName();
        this.MyBillsEntityDataFactory = simpleName;
        RumScreenName rumScreenName = (RumScreenName) activity.getClass().getAnnotation(RumScreenName.class);
        this.lookAheadTest = rumScreenName != null ? rumScreenName.value() : simpleName;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appStartupTimer;
        this.getAuthRequestContext = new ActiveSpan(visibleScreenTracker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Span PlaceComponentResult(String str, Span span) {
        SpanBuilder attribute = this.NetworkUserEntityData$$ExternalSyntheticLambda0.spanBuilder(str).setAttribute((AttributeKey<AttributeKey<String>>) BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) this.MyBillsEntityDataFactory).setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) BioDetector.EXT_KEY_UI);
        if (span != null) {
            attribute.setParent(span.storeInContext(Context.CC.current()));
        }
        Span startSpan = attribute.startSpan();
        startSpan.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda1, (AttributeKey<String>) this.lookAheadTest);
        return startSpan;
    }

    public static /* synthetic */ Span BuiltInFictitiousFunctionClassFactory(ActivityTracer activityTracer) {
        if (activityTracer.PlaceComponentResult.get() == null) {
            return activityTracer.PlaceComponentResult("Created", activityTracer.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        }
        if (activityTracer.MyBillsEntityDataFactory.equals(activityTracer.PlaceComponentResult.get())) {
            Span PlaceComponentResult = activityTracer.PlaceComponentResult(TrackId.Stub_AppStart, null);
            PlaceComponentResult.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda8, (AttributeKey<String>) "warm");
            PlaceComponentResult.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) "appstart");
            return PlaceComponentResult;
        }
        return activityTracer.PlaceComponentResult("Created", null);
    }
}
