package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.DelegatingSpanData;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.Collection;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SplunkSpanDataModifier implements SpanExporter {
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final SpanExporter getAuthRequestContext;
    static final AttributeKey<String> PlaceComponentResult = AttributeKey.CC.stringKey("_splunk_operation");
    static final AttributeKey<String> KClassImpl$Data$declaredNonStaticMembers$2 = AttributeKey.CC.stringKey("_reactnative_traceId");
    static final AttributeKey<String> BuiltInFictitiousFunctionClassFactory = AttributeKey.CC.stringKey("_reactnative_spanId");
    private static final Set<AttributeKey<String>> MyBillsEntityDataFactory = Collections.unmodifiableSet(new HashSet(Arrays.asList(ResourceAttributes.DEPLOYMENT_ENVIRONMENT, ResourceAttributes.DEVICE_MODEL_NAME, ResourceAttributes.DEVICE_MODEL_IDENTIFIER, ResourceAttributes.OS_NAME, ResourceAttributes.OS_TYPE, ResourceAttributes.OS_VERSION, SplunkRum.getAuthRequestContext, SplunkRum.NetworkUserEntityData$$ExternalSyntheticLambda2)));

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplunkSpanDataModifier(SpanExporter spanExporter, boolean z) {
        this.getAuthRequestContext = spanExporter;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode export(Collection<SpanData> collection) {
        return this.getAuthRequestContext.export((Collection) Collection.EL.getAuthRequestContext(collection).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: com.splunk.rum.SplunkSpanDataModifier$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return SplunkSpanDataModifier.PlaceComponentResult(SplunkSpanDataModifier.this, (SpanData) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory()));
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode flush() {
        return this.getAuthRequestContext.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode shutdown() {
        return this.getAuthRequestContext.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SplunkSpan extends DelegatingSpanData {
        private final List<EventData> BuiltInFictitiousFunctionClassFactory;
        private final SpanContext MyBillsEntityDataFactory;
        private final Attributes getAuthRequestContext;

        /* synthetic */ SplunkSpan(SpanData spanData, SpanContext spanContext, List list, Attributes attributes, byte b) {
            this(spanData, spanContext, list, attributes);
        }

        private SplunkSpan(SpanData spanData, SpanContext spanContext, List<EventData> list, Attributes attributes) {
            super(spanData);
            this.MyBillsEntityDataFactory = spanContext;
            this.BuiltInFictitiousFunctionClassFactory = list;
            this.getAuthRequestContext = attributes;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public final SpanContext getSpanContext() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public final List<EventData> getEvents() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public final int getTotalRecordedEvents() {
            return this.BuiltInFictitiousFunctionClassFactory.size();
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public final Attributes getAttributes() {
            return this.getAuthRequestContext;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public final int getTotalAttributeCount() {
            return this.getAuthRequestContext.size();
        }
    }

    public static /* synthetic */ SpanData PlaceComponentResult(SplunkSpanDataModifier splunkSpanDataModifier, SpanData spanData) {
        SpanContext spanContext;
        ArrayList arrayList = new ArrayList(spanData.getEvents().size());
        AttributesBuilder builder = spanData.getAttributes().toBuilder();
        if (!splunkSpanDataModifier.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            spanContext = spanData.getSpanContext();
        } else {
            Attributes attributes = spanData.getAttributes();
            SpanContext spanContext2 = spanData.getSpanContext();
            String str = (String) attributes.get(KClassImpl$Data$declaredNonStaticMembers$2);
            String str2 = (String) attributes.get(BuiltInFictitiousFunctionClassFactory);
            if (str != null && str2 != null) {
                spanContext2 = spanContext2.isRemote() ? SpanContext.CC.createFromRemoteParent(str, str2, spanContext2.getTraceFlags(), spanContext2.getTraceState()) : SpanContext.CC.create(str, str2, spanContext2.getTraceFlags(), spanContext2.getTraceState());
            }
            builder.remove(KClassImpl$Data$declaredNonStaticMembers$2);
            builder.remove(BuiltInFictitiousFunctionClassFactory);
            spanContext = spanContext2;
        }
        for (EventData eventData : spanData.getEvents()) {
            if (!eventData.getName().equals("exception")) {
                arrayList.add(eventData);
            } else {
                String str3 = (String) eventData.getAttributes().get(SemanticAttributes.EXCEPTION_TYPE);
                String str4 = (String) eventData.getAttributes().get(SemanticAttributes.EXCEPTION_MESSAGE);
                String str5 = (String) eventData.getAttributes().get(SemanticAttributes.EXCEPTION_STACKTRACE);
                AttributesBuilder builder2 = Attributes.CC.builder();
                if (str3 != null) {
                    int lastIndexOf = str3.lastIndexOf(46);
                    if (lastIndexOf != -1) {
                        str3 = str3.substring(lastIndexOf + 1);
                    }
                    builder2.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_TYPE, (AttributeKey<String>) str3);
                    builder2.put((AttributeKey<AttributeKey<String>>) SplunkRum.getErrorConfigVersion, (AttributeKey<String>) str3);
                }
                if (str4 != null) {
                    builder2.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_MESSAGE, (AttributeKey<String>) str4);
                    builder2.put((AttributeKey<AttributeKey<String>>) SplunkRum.moveToNextValue, (AttributeKey<String>) str4);
                }
                if (str5 != null) {
                    builder2.put((AttributeKey<AttributeKey<String>>) SemanticAttributes.EXCEPTION_STACKTRACE, (AttributeKey<String>) str5);
                }
                builder.putAll(builder2.build());
            }
        }
        builder.put((AttributeKey<AttributeKey<String>>) PlaceComponentResult, (AttributeKey<String>) spanData.getName());
        for (AttributeKey<String> attributeKey : MyBillsEntityDataFactory) {
            String str6 = (String) spanData.getResource().getAttribute(attributeKey);
            if (str6 != null) {
                builder.put((AttributeKey<AttributeKey<String>>) attributeKey, (AttributeKey<String>) str6);
            }
        }
        return new SplunkSpan(spanData, spanContext, arrayList, builder.build(), (byte) 0);
    }
}
