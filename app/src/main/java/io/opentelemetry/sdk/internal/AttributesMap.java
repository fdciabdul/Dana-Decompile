package io.opentelemetry.sdk.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class AttributesMap extends HashMap<AttributeKey<?>, Object> implements Attributes, Map {
    private static final long serialVersionUID = -5072696312123632376L;
    private final long capacity;
    private final int lengthLimit;
    private int totalAddedValues = 0;

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

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.MyBillsEntityDataFactory(this, obj, obj2);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.PlaceComponentResult(this, obj, obj2);
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

    private AttributesMap(long j, int i) {
        this.capacity = j;
        this.lengthLimit = i;
    }

    public static AttributesMap create(long j, int i) {
        return new AttributesMap(j, i);
    }

    public final <T> void put(AttributeKey<T> attributeKey, T t) {
        this.totalAddedValues++;
        if (size() < this.capacity || containsKey(attributeKey)) {
            super.put((AttributesMap) attributeKey, (AttributeKey<T>) AttributeUtil.applyAttributeLengthLimit(t, this.lengthLimit));
        }
    }

    public final int getTotalAddedValues() {
        return this.totalAddedValues;
    }

    @Override // io.opentelemetry.api.common.Attributes
    @Nullable
    public final <T> T get(AttributeKey<T> attributeKey) {
        return (T) super.get((Object) attributeKey);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public final java.util.Map<AttributeKey<?>, Object> asMap() {
        return Collections.unmodifiableMap(this);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public final AttributesBuilder toBuilder() {
        return Attributes.CC.builder().putAll(this);
    }

    @Override // io.opentelemetry.api.common.Attributes, j$.util.Map
    public final void forEach(j$.util.function.BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer) {
        Map.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributesMap{data=");
        sb.append(super.toString());
        sb.append(", capacity=");
        sb.append(this.capacity);
        sb.append(", totalAddedValues=");
        sb.append(this.totalAddedValues);
        sb.append('}');
        return sb.toString();
    }

    public final Attributes immutableCopy() {
        return Attributes.CC.builder().putAll(this).build();
    }
}
