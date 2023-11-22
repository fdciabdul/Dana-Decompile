package io.opentelemetry.api.common;

import io.opentelemetry.api.common.AttributeKey;
import j$.util.function.Predicate;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public interface AttributesBuilder {
    Attributes build();

    <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i);

    <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t);

    <T> AttributesBuilder put(AttributeKey<List<T>> attributeKey, T... tArr);

    AttributesBuilder put(String str, double d);

    AttributesBuilder put(String str, long j);

    AttributesBuilder put(String str, String str2);

    AttributesBuilder put(String str, boolean z);

    AttributesBuilder put(String str, double... dArr);

    AttributesBuilder put(String str, long... jArr);

    AttributesBuilder put(String str, String... strArr);

    AttributesBuilder put(String str, boolean... zArr);

    AttributesBuilder putAll(Attributes attributes);

    <T> AttributesBuilder remove(AttributeKey<T> attributeKey);

    AttributesBuilder removeIf(Predicate<AttributeKey<?>> predicate);

    /* renamed from: io.opentelemetry.api.common.AttributesBuilder$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static AttributesBuilder $default$remove(AttributesBuilder attributesBuilder, AttributeKey attributeKey) {
            return attributesBuilder;
        }

        public static AttributesBuilder $default$removeIf(AttributesBuilder attributesBuilder, Predicate predicate) {
            return attributesBuilder;
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, String str2) {
            return attributesBuilder.put((AttributeKey<AttributeKey<String>>) AttributeKey.CC.stringKey(str), (AttributeKey<String>) str2);
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, long j) {
            return attributesBuilder.put((AttributeKey<AttributeKey<Long>>) AttributeKey.CC.longKey(str), (AttributeKey<Long>) Long.valueOf(j));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, double d) {
            return attributesBuilder.put((AttributeKey<AttributeKey<Double>>) AttributeKey.CC.doubleKey(str), (AttributeKey<Double>) Double.valueOf(d));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, boolean z) {
            return attributesBuilder.put((AttributeKey<AttributeKey<Boolean>>) AttributeKey.CC.booleanKey(str), (AttributeKey<Boolean>) Boolean.valueOf(z));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, String... strArr) {
            return strArr == null ? attributesBuilder : attributesBuilder.put((AttributeKey<AttributeKey<List<String>>>) AttributeKey.CC.stringArrayKey(str), (AttributeKey<List<String>>) Arrays.asList(strArr));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, AttributeKey attributeKey, Object... objArr) {
            return objArr == null ? attributesBuilder : attributesBuilder.put((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) Arrays.asList(objArr));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, long... jArr) {
            return jArr == null ? attributesBuilder : attributesBuilder.put((AttributeKey<AttributeKey<List<Long>>>) AttributeKey.CC.longArrayKey(str), (AttributeKey<List<Long>>) ArrayBackedAttributesBuilder.toList(jArr));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, double... dArr) {
            return dArr == null ? attributesBuilder : attributesBuilder.put((AttributeKey<AttributeKey<List<Double>>>) AttributeKey.CC.doubleArrayKey(str), (AttributeKey<List<Double>>) ArrayBackedAttributesBuilder.toList(dArr));
        }

        public static AttributesBuilder $default$put(AttributesBuilder attributesBuilder, String str, boolean... zArr) {
            return zArr == null ? attributesBuilder : attributesBuilder.put((AttributeKey<AttributeKey<List<Boolean>>>) AttributeKey.CC.booleanArrayKey(str), (AttributeKey<List<Boolean>>) ArrayBackedAttributesBuilder.toList(zArr));
        }
    }
}
