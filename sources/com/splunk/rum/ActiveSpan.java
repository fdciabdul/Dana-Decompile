package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import j$.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ActiveSpan {
    private Scope BuiltInFictitiousFunctionClassFactory;
    Span KClassImpl$Data$declaredNonStaticMembers$2;
    private final VisibleScreenTracker PlaceComponentResult;

    public ActiveSpan(VisibleScreenTracker visibleScreenTracker) {
        this.PlaceComponentResult = visibleScreenTracker;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != null;
    }

    public final void getAuthRequestContext(Supplier<Span> supplier) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return;
        }
        Span span = supplier.get();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = span;
        this.BuiltInFictitiousFunctionClassFactory = span.makeCurrent();
    }

    public final void PlaceComponentResult() {
        Scope scope = this.BuiltInFictitiousFunctionClassFactory;
        if (scope != null) {
            scope.close();
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
        Span span = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (span != null) {
            span.end();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return;
        }
        VisibleScreenTracker visibleScreenTracker = this.PlaceComponentResult;
        String str2 = visibleScreenTracker.getAuthRequestContext.get();
        if (str2 == null) {
            str2 = visibleScreenTracker.MyBillsEntityDataFactory.get();
        }
        if (str2 == null || str.equals(str2)) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.lookAheadTest, (AttributeKey<String>) str2);
    }
}
