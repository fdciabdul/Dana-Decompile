package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import com.splunk.rum.ThrottlingExporter;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import j$.time.Duration;
import j$.util.Map;
import j$.util.function.Function;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ThrottlingExporter implements SpanExporter {
    private final Map<String, Window> BuiltInFictitiousFunctionClassFactory;
    private final long KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final Function<SpanData, String> PlaceComponentResult;
    private final SpanExporter getAuthRequestContext;

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public /* synthetic */ ThrottlingExporter(Builder builder, byte b) {
        this(builder);
    }

    private ThrottlingExporter(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.getAuthRequestContext = builder.BuiltInFictitiousFunctionClassFactory;
        this.PlaceComponentResult = builder.PlaceComponentResult;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.getAuthRequestContext.toNanos();
        this.MyBillsEntityDataFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2(SpanExporter spanExporter) {
        return new Builder(spanExporter, (byte) 0);
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        ArrayList arrayList = new ArrayList();
        for (SpanData spanData : collection) {
            if (!((Window) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) this.BuiltInFictitiousFunctionClassFactory, (Object) this.PlaceComponentResult.apply(spanData), new Function() { // from class: com.splunk.rum.ThrottlingExporter$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    String str = (String) obj;
                    return new ThrottlingExporter.Window();
                }
            })).KClassImpl$Data$declaredNonStaticMembers$2(spanData)) {
                arrayList.add(spanData);
            }
        }
        int size = collection.size() - arrayList.size();
        if (size > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dropped ");
            sb.append(size);
            sb.append(" spans because of throttling");
            InstrumentInjector.log_d("SplunkRum", sb.toString());
        }
        return this.getAuthRequestContext.export(arrayList);
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        return this.getAuthRequestContext.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        return this.getAuthRequestContext.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class Window {
        private final Deque<Long> BuiltInFictitiousFunctionClassFactory = new ArrayDeque();

        public Window() {
            ThrottlingExporter.this = r1;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(SpanData spanData) {
            long endEpochNanos = spanData.getEndEpochNanos();
            this.BuiltInFictitiousFunctionClassFactory.addLast(Long.valueOf(endEpochNanos));
            while (true) {
                Long peekFirst = this.BuiltInFictitiousFunctionClassFactory.peekFirst();
                if (peekFirst == null || endEpochNanos - peekFirst.longValue() < ThrottlingExporter.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    break;
                }
                this.BuiltInFictitiousFunctionClassFactory.removeFirst();
            }
            boolean z = this.BuiltInFictitiousFunctionClassFactory.size() > ThrottlingExporter.this.MyBillsEntityDataFactory;
            if (z) {
                this.BuiltInFictitiousFunctionClassFactory.removeLast();
            }
            return z;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        final SpanExporter BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        Function<SpanData, String> PlaceComponentResult;
        Duration getAuthRequestContext;

        public static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2() {
            return "default";
        }

        /* synthetic */ Builder(SpanExporter spanExporter, byte b) {
            this(spanExporter);
        }

        private Builder(SpanExporter spanExporter) {
            this.PlaceComponentResult = new Function() { // from class: com.splunk.rum.ThrottlingExporter$Builder$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    SpanData spanData = (SpanData) obj;
                    return ThrottlingExporter.Builder.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            };
            this.getAuthRequestContext = Duration.ofSeconds(30L);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 100;
            this.BuiltInFictitiousFunctionClassFactory = spanExporter;
        }

        public static /* synthetic */ String MyBillsEntityDataFactory(AttributeKey attributeKey, SpanData spanData) {
            return (String) spanData.getAttributes().get(attributeKey);
        }
    }
}
