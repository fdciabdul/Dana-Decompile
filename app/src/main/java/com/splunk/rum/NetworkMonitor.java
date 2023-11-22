package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class NetworkMonitor implements AppStateListener {
    static final AttributeKey<String> getAuthRequestContext = AttributeKey.CC.stringKey("network.status");
    final AtomicBoolean BuiltInFictitiousFunctionClassFactory = new AtomicBoolean(true);
    final ConnectionUtil MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetworkMonitor(ConnectionUtil connectionUtil) {
        this.MyBillsEntityDataFactory = connectionUtil;
    }

    @Override // com.splunk.rum.AppStateListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.set(true);
    }

    @Override // com.splunk.rum.AppStateListener
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TracingConnectionStateListener implements ConnectionStateListener {
        private final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final Tracer getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TracingConnectionStateListener(Tracer tracer, AtomicBoolean atomicBoolean) {
            this.getAuthRequestContext = tracer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = atomicBoolean;
        }

        @Override // com.splunk.rum.ConnectionStateListener
        public final void PlaceComponentResult(CurrentNetwork currentNetwork) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.get()) {
                if (currentNetwork.PlaceComponentResult == NetworkState.NO_NETWORK_AVAILABLE) {
                    this.getAuthRequestContext.spanBuilder("network.change").setAttribute((AttributeKey<AttributeKey<String>>) NetworkMonitor.getAuthRequestContext, (AttributeKey<String>) "lost").startSpan().setAttribute((AttributeKey<AttributeKey<String>>) SemanticAttributes.NET_HOST_CONNECTION_TYPE, (AttributeKey<String>) currentNetwork.PlaceComponentResult.getHumanName()).end();
                    return;
                }
                Span startSpan = this.getAuthRequestContext.spanBuilder("network.change").setAttribute((AttributeKey<AttributeKey<String>>) NetworkMonitor.getAuthRequestContext, (AttributeKey<String>) "available").startSpan();
                RumAttributeAppender.PlaceComponentResult(startSpan, currentNetwork);
                startSpan.end();
            }
        }
    }
}
