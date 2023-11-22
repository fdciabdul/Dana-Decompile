package com.splunk.rum;

import android.app.Application;
import com.splunk.android.rum.R;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import j$.util.function.Supplier;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RumInitializer {
    final List<InitializationEvent> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    final AppStartupTimer KClassImpl$Data$declaredNonStaticMembers$2;
    final SplunkRumBuilder MyBillsEntityDataFactory;
    final AnchoredClock PlaceComponentResult;
    final Application getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InetAddress BuiltInFictitiousFunctionClassFactory() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SpanExporter PlaceComponentResult(DanaExporter danaExporter) {
        return danaExporter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RumInitializer(SplunkRumBuilder splunkRumBuilder, Application application, AppStartupTimer appStartupTimer) {
        this.MyBillsEntityDataFactory = splunkRumBuilder;
        this.getAuthRequestContext = application;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appStartupTimer;
        this.PlaceComponentResult = appStartupTimer.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String PlaceComponentResult() {
        try {
            return this.getAuthRequestContext.getApplicationContext().getResources().getString(R.string.getAuthRequestContext_res_0x7f131389);
        } catch (Exception unused) {
            return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MyBillsEntityDataFactory.PlaceComponentResult);
        sb.append("?auth=");
        sb.append(this.MyBillsEntityDataFactory.isLayoutRequested);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InitializationEvent {
        private final long KClassImpl$Data$declaredNonStaticMembers$2;
        private final String MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ InitializationEvent(String str, long j, byte b) {
            this(str, j);
        }

        private InitializationEvent(String str, long j) {
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class AnchoredClock {
        final long BuiltInFictitiousFunctionClassFactory;
        final Clock MyBillsEntityDataFactory;
        final long getAuthRequestContext;

        private AnchoredClock(Clock clock, long j, long j2) {
            this.MyBillsEntityDataFactory = clock;
            this.getAuthRequestContext = j;
            this.BuiltInFictitiousFunctionClassFactory = j2;
        }

        public static AnchoredClock KClassImpl$Data$declaredNonStaticMembers$2(Clock clock) {
            return new AnchoredClock(clock, clock.now(), clock.nanoTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazyInitSpanExporter implements SpanExporter {
        private volatile SpanExporter MyBillsEntityDataFactory;
        private final Supplier<SpanExporter> getAuthRequestContext;

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            shutdown().join(10L, TimeUnit.SECONDS);
        }

        public LazyInitSpanExporter(Supplier<SpanExporter> supplier) {
            this.getAuthRequestContext = supplier;
        }

        private SpanExporter KClassImpl$Data$declaredNonStaticMembers$2() {
            SpanExporter spanExporter = this.MyBillsEntityDataFactory;
            if (spanExporter == null) {
                synchronized (this) {
                    spanExporter = this.MyBillsEntityDataFactory;
                    if (spanExporter == null) {
                        spanExporter = this.getAuthRequestContext.get();
                        this.MyBillsEntityDataFactory = spanExporter;
                    }
                }
            }
            return spanExporter;
        }

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter
        public CompletableResultCode export(Collection<SpanData> collection) {
            return KClassImpl$Data$declaredNonStaticMembers$2().export(collection);
        }

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter
        public CompletableResultCode flush() {
            return KClassImpl$Data$declaredNonStaticMembers$2().flush();
        }

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter
        public CompletableResultCode shutdown() {
            return KClassImpl$Data$declaredNonStaticMembers$2().shutdown();
        }
    }
}
