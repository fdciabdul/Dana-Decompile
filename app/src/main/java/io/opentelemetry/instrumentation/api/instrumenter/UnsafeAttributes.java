package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Predicate;
import java.util.HashMap;
import java.util.function.BiConsumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class UnsafeAttributes extends HashMap<AttributeKey<?>, Object> implements Attributes, AttributesBuilder, Map {
    private static final long serialVersionUID = 1;

    @Override // io.opentelemetry.api.common.Attributes
    public final java.util.Map<AttributeKey<?>, Object> asMap() {
        return this;
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.BuiltInFictitiousFunctionClassFactory((java.util.Map) this, obj, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.PlaceComponentResult((java.util.Map) this, obj, function);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.getAuthRequestContext(this, obj, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* synthetic */ void forEach(BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.BuiltInFictitiousFunctionClassFactory(this, obj, obj2);
    }

    @Override // j$.util.Map
    public final /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.PlaceComponentResult(this, obj, obj2, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(AttributeKey attributeKey, Object... objArr) {
        return AttributesBuilder.CC.$default$put(this, attributeKey, objArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, double d) {
        AttributesBuilder put;
        put = put((AttributeKey<AttributeKey<AttributeKey<Double>>>) ((AttributeKey<AttributeKey<Double>>) AttributeKey.CC.doubleKey(str)), (AttributeKey<AttributeKey<Double>>) ((AttributeKey<Double>) Double.valueOf(d)));
        return put;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, long j) {
        AttributesBuilder put;
        put = put((AttributeKey<AttributeKey<AttributeKey<Long>>>) ((AttributeKey<AttributeKey<Long>>) AttributeKey.CC.longKey(str)), (AttributeKey<AttributeKey<Long>>) ((AttributeKey<Long>) Long.valueOf(j)));
        return put;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, String str2) {
        AttributesBuilder put;
        put = put((AttributeKey<AttributeKey<AttributeKey<String>>>) ((AttributeKey<AttributeKey<String>>) AttributeKey.CC.stringKey(str)), (AttributeKey<AttributeKey<String>>) ((AttributeKey<String>) str2));
        return put;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, boolean z) {
        AttributesBuilder put;
        put = put((AttributeKey<AttributeKey<AttributeKey<Boolean>>>) ((AttributeKey<AttributeKey<Boolean>>) AttributeKey.CC.booleanKey(str)), (AttributeKey<AttributeKey<Boolean>>) ((AttributeKey<Boolean>) Boolean.valueOf(z)));
        return put;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, double... dArr) {
        return AttributesBuilder.CC.$default$put(this, str, dArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, long... jArr) {
        return AttributesBuilder.CC.$default$put((AttributesBuilder) this, str, jArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, String... strArr) {
        return AttributesBuilder.CC.$default$put(this, str, strArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder put(String str, boolean... zArr) {
        return AttributesBuilder.CC.$default$put(this, str, zArr);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.MyBillsEntityDataFactory(this, obj, obj2);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder remove(AttributeKey attributeKey) {
        return AttributesBuilder.CC.$default$remove(this, attributeKey);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.PlaceComponentResult(this, obj, obj2);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final /* synthetic */ AttributesBuilder removeIf(Predicate predicate) {
        return AttributesBuilder.CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, obj, obj2);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.MyBillsEntityDataFactory(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public final /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.MyBillsEntityDataFactory(this, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // io.opentelemetry.api.common.Attributes
    public final <T> T get(AttributeKey<T> attributeKey) {
        return (T) super.get((Object) attributeKey);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public final AttributesBuilder toBuilder() {
        return Attributes.CC.builder().putAll(this);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final Attributes build() {
        return toBuilder().build();
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i) {
        return put((AttributeKey<AttributeKey<Long>>) attributeKey, (AttributeKey<Long>) Long.valueOf(i));
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t) {
        super.put((UnsafeAttributes) attributeKey, (AttributeKey<T>) t);
        return this;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public final AttributesBuilder putAll(Attributes attributes) {
        attributes.forEach(new j$.util.function.BiConsumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.UnsafeAttributes$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                UnsafeAttributes.this.put((UnsafeAttributes) ((AttributeKey) obj), (AttributeKey) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ j$.util.function.BiConsumer andThen(j$.util.function.BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return this;
    }

    @Override // io.opentelemetry.api.common.Attributes, j$.util.Map
    public final void forEach(j$.util.function.BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer) {
        Map.CC.getAuthRequestContext(this, biConsumer);
    }
}
