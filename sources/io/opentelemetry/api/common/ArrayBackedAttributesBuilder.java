package io.opentelemetry.api.common;

import io.opentelemetry.api.common.AttributesBuilder;
import j$.util.function.BiConsumer;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ArrayBackedAttributesBuilder implements AttributesBuilder {
    private final List<Object> data;

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(AttributeKey attributeKey, Object... objArr) {
        return AttributesBuilder.CC.$default$put(this, attributeKey, objArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, double d) {
        return AttributesBuilder.CC.$default$put(this, str, d);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, long j) {
        return AttributesBuilder.CC.$default$put((AttributesBuilder) this, str, j);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, String str2) {
        return AttributesBuilder.CC.$default$put(this, str, str2);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, boolean z) {
        return AttributesBuilder.CC.$default$put(this, str, z);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, double... dArr) {
        return AttributesBuilder.CC.$default$put(this, str, dArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, long... jArr) {
        return AttributesBuilder.CC.$default$put((AttributesBuilder) this, str, jArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, String... strArr) {
        return AttributesBuilder.CC.$default$put(this, str, strArr);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public /* synthetic */ AttributesBuilder put(String str, boolean... zArr) {
        return AttributesBuilder.CC.$default$put(this, str, zArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBackedAttributesBuilder() {
        this.data = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBackedAttributesBuilder(List<Object> list) {
        this.data = list;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public Attributes build() {
        if (this.data.size() == 2 && this.data.get(0) != null) {
            return new ArrayBackedAttributes(this.data.toArray());
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(this.data.toArray());
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i) {
        return put((AttributeKey<AttributeKey<Long>>) attributeKey, (AttributeKey<Long>) Long.valueOf(i));
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t != null) {
            this.data.add(attributeKey);
            this.data.add(t);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putAll$0$io-opentelemetry-api-common-ArrayBackedAttributesBuilder  reason: not valid java name */
    public /* synthetic */ void m3149xff16beb8(AttributeKey attributeKey, Object obj) {
        put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder putAll(Attributes attributes) {
        if (attributes == null) {
            return this;
        }
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.common.ArrayBackedAttributesBuilder$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ArrayBackedAttributesBuilder.this.m3149xff16beb8((AttributeKey) obj, obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return this;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder remove(final AttributeKey<T> attributeKey) {
        return (attributeKey == null || attributeKey.getKey().isEmpty()) ? this : removeIf(new Predicate() { // from class: io.opentelemetry.api.common.ArrayBackedAttributesBuilder$$ExternalSyntheticLambda1
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return ArrayBackedAttributesBuilder.lambda$remove$1(AttributeKey.this, (AttributeKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$remove$1(AttributeKey attributeKey, AttributeKey attributeKey2) {
        return attributeKey.getKey().equals(attributeKey2.getKey()) && attributeKey.getType().equals(attributeKey2.getType());
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder removeIf(Predicate<AttributeKey<?>> predicate) {
        if (predicate == null) {
            return this;
        }
        for (int i = 0; i < this.data.size() - 1; i += 2) {
            Object obj = this.data.get(i);
            if ((obj instanceof AttributeKey) && predicate.test((AttributeKey) obj)) {
                this.data.set(i, null);
                this.data.set(i + 1, null);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Double> toList(double... dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return Arrays.asList(dArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> toList(long... jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return Arrays.asList(lArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Boolean> toList(boolean... zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return Arrays.asList(boolArr);
    }
}
