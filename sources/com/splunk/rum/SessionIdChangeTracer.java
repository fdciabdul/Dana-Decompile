package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Tracer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SessionIdChangeTracer implements SessionIdChangeListener {
    static final AttributeKey<String> KClassImpl$Data$declaredNonStaticMembers$2 = AttributeKey.CC.stringKey("splunk.rum.previous_session_id");
    private final Tracer PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionIdChangeTracer(Tracer tracer) {
        this.PlaceComponentResult = tracer;
    }

    @Override // com.splunk.rum.SessionIdChangeListener
    public final void MyBillsEntityDataFactory(String str) {
        this.PlaceComponentResult.spanBuilder("sessionId.change").setAttribute((AttributeKey<AttributeKey<String>>) KClassImpl$Data$declaredNonStaticMembers$2, (AttributeKey<String>) str).startSpan().end();
    }
}
