package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SpanDataModifier implements SpanExporter {
    final Map<AttributeKey<?>, Function<?, ?>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Predicate<String> MyBillsEntityDataFactory;
    private final Map<AttributeKey<?>, Predicate<?>> PlaceComponentResult;
    private final SpanExporter getAuthRequestContext;

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanDataModifier(SpanExporter spanExporter, Predicate<String> predicate, Map<AttributeKey<?>, Predicate<?>> map, Map<AttributeKey<?>, Function<?, ?>> map2) {
        this.getAuthRequestContext = spanExporter;
        this.MyBillsEntityDataFactory = predicate;
        this.PlaceComponentResult = map;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map2;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode export(Collection<SpanData> collection) {
        ArrayList arrayList = new ArrayList();
        for (SpanData spanData : collection) {
            if (!KClassImpl$Data$declaredNonStaticMembers$2(spanData)) {
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    final AttributesBuilder builder = Attributes.CC.builder();
                    spanData.getAttributes().forEach(new BiConsumer() { // from class: com.splunk.rum.SpanDataModifier$$ExternalSyntheticLambda0
                        @Override // j$.util.function.BiConsumer
                        public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                            return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                        }

                        @Override // j$.util.function.BiConsumer
                        public final void accept(Object obj, Object obj2) {
                            SpanDataModifier spanDataModifier = SpanDataModifier.this;
                            AttributesBuilder attributesBuilder = builder;
                            AttributeKey attributeKey = (AttributeKey) obj;
                            Object apply = ((Function) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(spanDataModifier.KClassImpl$Data$declaredNonStaticMembers$2, attributeKey, Function.CC.BuiltInFictitiousFunctionClassFactory())).apply(obj2);
                            if (apply != null) {
                                attributesBuilder.put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) apply);
                            }
                        }
                    });
                    spanData = new ModifiedSpanData(spanData, builder.build());
                }
                arrayList.add(spanData);
            }
        }
        return this.getAuthRequestContext.export(arrayList);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(SpanData spanData) {
        if (this.MyBillsEntityDataFactory.test(spanData.getName())) {
            return true;
        }
        Attributes attributes = spanData.getAttributes();
        for (Map.Entry<AttributeKey<?>, Predicate<?>> entry : this.PlaceComponentResult.entrySet()) {
            AttributeKey<?> key = entry.getKey();
            Predicate<?> value = entry.getValue();
            if (attributes.get(key) != null && value.test(attributes.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode flush() {
        return this.getAuthRequestContext.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public final CompletableResultCode shutdown() {
        return this.getAuthRequestContext.shutdown();
    }
}
