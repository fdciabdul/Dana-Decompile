package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RumAttributeAppender implements SpanProcessor {
    static final AttributeKey<String> MyBillsEntityDataFactory = AttributeKey.CC.stringKey("splunk.rumSessionId");
    private final ConnectionUtil BuiltInFictitiousFunctionClassFactory;
    private final SessionId KClassImpl$Data$declaredNonStaticMembers$2;
    private final VisibleScreenTracker getAuthRequestContext;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public /* synthetic */ CompletableResultCode forceFlush() {
        CompletableResultCode ofSuccess;
        ofSuccess = CompletableResultCode.ofSuccess();
        return ofSuccess;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public /* synthetic */ CompletableResultCode shutdown() {
        CompletableResultCode forceFlush;
        forceFlush = forceFlush();
        return forceFlush;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RumAttributeAppender(SessionId sessionId, VisibleScreenTracker visibleScreenTracker, ConnectionUtil connectionUtil) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sessionId;
        this.getAuthRequestContext = visibleScreenTracker;
        this.BuiltInFictitiousFunctionClassFactory = connectionUtil;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        readWriteSpan.setAttribute((AttributeKey<AttributeKey<String>>) MyBillsEntityDataFactory, (AttributeKey<String>) this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
        readWriteSpan.setAttribute((AttributeKey<AttributeKey<String>>) SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda1, (AttributeKey<String>) this.getAuthRequestContext.PlaceComponentResult());
        PlaceComponentResult(readWriteSpan, this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Span span, CurrentNetwork currentNetwork) {
        AttributeKey<String> attributeKey = SemanticAttributes.NET_HOST_CONNECTION_TYPE;
        String humanName = currentNetwork.PlaceComponentResult.getHumanName();
        if (humanName != null) {
            span.setAttribute((AttributeKey<AttributeKey<String>>) attributeKey, (AttributeKey<String>) humanName);
        }
        AttributeKey<String> attributeKey2 = SemanticAttributes.NET_HOST_CONNECTION_SUBTYPE;
        String str = currentNetwork.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str != null) {
            span.setAttribute((AttributeKey<AttributeKey<String>>) attributeKey2, (AttributeKey<String>) str);
        }
        AttributeKey<String> attributeKey3 = SemanticAttributes.NET_HOST_CARRIER_NAME;
        String str2 = currentNetwork.BuiltInFictitiousFunctionClassFactory() ? currentNetwork.getAuthRequestContext.getAuthRequestContext : null;
        if (str2 != null) {
            span.setAttribute((AttributeKey<AttributeKey<String>>) attributeKey3, (AttributeKey<String>) str2);
        }
        AttributeKey<String> attributeKey4 = SemanticAttributes.NET_HOST_CARRIER_MCC;
        String str3 = currentNetwork.BuiltInFictitiousFunctionClassFactory() ? currentNetwork.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory : null;
        if (str3 != null) {
            span.setAttribute((AttributeKey<AttributeKey<String>>) attributeKey4, (AttributeKey<String>) str3);
        }
        AttributeKey<String> attributeKey5 = SemanticAttributes.NET_HOST_CARRIER_MNC;
        String str4 = currentNetwork.BuiltInFictitiousFunctionClassFactory() ? currentNetwork.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (str4 != null) {
            span.setAttribute((AttributeKey<AttributeKey<String>>) attributeKey5, (AttributeKey<String>) str4);
        }
        AttributeKey<String> attributeKey6 = SemanticAttributes.NET_HOST_CARRIER_ICC;
        String str5 = currentNetwork.BuiltInFictitiousFunctionClassFactory() ? currentNetwork.getAuthRequestContext.MyBillsEntityDataFactory : null;
        if (str5 != null) {
            span.setAttribute((AttributeKey<AttributeKey<String>>) attributeKey6, (AttributeKey<String>) str5);
        }
    }
}
