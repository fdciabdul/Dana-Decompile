package com.splunk.rum;

import android.webkit.WebView;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Tracer;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class NoOpSplunkRum extends SplunkRum {
    static final NoOpSplunkRum MyBillsEntityDataFactory = new NoOpSplunkRum();

    @Override // com.splunk.rum.SplunkRum
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    @Override // com.splunk.rum.SplunkRum
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Consumer<AttributesBuilder> consumer) {
    }

    @Override // com.splunk.rum.SplunkRum
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, Attributes attributes) {
    }

    @Override // com.splunk.rum.SplunkRum
    public final void getAuthRequestContext(WebView webView) {
    }

    private NoOpSplunkRum() {
        super(null, null, null);
    }

    @Override // com.splunk.rum.SplunkRum
    public final OpenTelemetry PlaceComponentResult() {
        return OpenTelemetry.CC.noop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.splunk.rum.SplunkRum
    public final Tracer BuiltInFictitiousFunctionClassFactory() {
        return OpenTelemetry.CC.noop().getTracer("unused");
    }
}
