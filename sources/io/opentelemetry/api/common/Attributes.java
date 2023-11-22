package io.opentelemetry.api.common;

import j$.util.function.BiConsumer;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface Attributes {
    Map<AttributeKey<?>, Object> asMap();

    void forEach(BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer);

    @Nullable
    <T> T get(AttributeKey<T> attributeKey);

    boolean isEmpty();

    int size();

    AttributesBuilder toBuilder();

    /* renamed from: io.opentelemetry.api.common.Attributes$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static Attributes empty() {
            return ArrayBackedAttributes.EMPTY;
        }

        public static <T> Attributes of(AttributeKey<T> attributeKey, T t) {
            if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
                return empty();
            }
            return new ArrayBackedAttributes(new Object[]{attributeKey, t});
        }

        public static <T, U> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u) {
            if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
                return of(attributeKey2, u);
            }
            if (attributeKey2 == null || attributeKey2.getKey().isEmpty() || u == null) {
                return of(attributeKey, t);
            }
            if (attributeKey.getKey().equals(attributeKey2.getKey())) {
                return of(attributeKey2, u);
            }
            if (attributeKey.getKey().compareTo(attributeKey2.getKey()) > 0) {
                return new ArrayBackedAttributes(new Object[]{attributeKey2, u, attributeKey, t});
            }
            return new ArrayBackedAttributes(new Object[]{attributeKey, t, attributeKey2, u});
        }

        public static <T, U, V> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v) {
            return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v);
        }

        public static <T, U, V, W> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w) {
            return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w);
        }

        public static <T, U, V, W, X> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w, AttributeKey<X> attributeKey5, X x) {
            return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w, attributeKey5, x);
        }

        public static <T, U, V, W, X, Y> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w, AttributeKey<X> attributeKey5, X x, AttributeKey<Y> attributeKey6, Y y) {
            return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w, attributeKey5, x, attributeKey6, y);
        }

        public static AttributesBuilder builder() {
            return new ArrayBackedAttributesBuilder();
        }
    }
}
