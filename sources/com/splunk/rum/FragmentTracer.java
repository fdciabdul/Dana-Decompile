package com.splunk.rum;

import androidx.fragment.app.Fragment;
import com.alipay.mobile.security.bio.api.BioDetector;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FragmentTracer {
    static final AttributeKey<String> MyBillsEntityDataFactory = AttributeKey.CC.stringKey("fragmentName");
    final ActiveSpan BuiltInFictitiousFunctionClassFactory;
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Tracer PlaceComponentResult;
    private final String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentTracer(Fragment fragment, Tracer tracer, VisibleScreenTracker visibleScreenTracker) {
        this.PlaceComponentResult = tracer;
        String simpleName = fragment.getClass().getSimpleName();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = simpleName;
        RumScreenName rumScreenName = (RumScreenName) fragment.getClass().getAnnotation(RumScreenName.class);
        this.getAuthRequestContext = rumScreenName != null ? rumScreenName.value() : simpleName;
        this.BuiltInFictitiousFunctionClassFactory = new ActiveSpan(visibleScreenTracker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Span KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Span startSpan = this.PlaceComponentResult.spanBuilder(str).setAttribute((AttributeKey<AttributeKey<String>>) MyBillsEntityDataFactory, (AttributeKey<String>) this.KClassImpl$Data$declaredNonStaticMembers$2).setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) BioDetector.EXT_KEY_UI).startSpan();
        startSpan.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda1, (AttributeKey<String>) this.getAuthRequestContext);
        return startSpan;
    }
}
