package io.opentelemetry.api.common;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ImmutableKeyValuePairs;
import j$.util.Comparator;
import j$.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ArrayBackedAttributes extends ImmutableKeyValuePairs<AttributeKey<?>, Object> implements Attributes {
    private static final Comparator<AttributeKey<?>> KEY_COMPARATOR_FOR_CONSTRUCTION = Comparator.CC.comparing(new Function() { // from class: io.opentelemetry.api.common.ArrayBackedAttributes$$ExternalSyntheticLambda0
        @Override // j$.util.function.Function
        /* renamed from: andThen */
        public final /* synthetic */ Function mo3169andThen(Function function) {
            return Function.CC.getAuthRequestContext(this, function);
        }

        @Override // j$.util.function.Function
        public final Object apply(Object obj) {
            return ((AttributeKey) obj).getKey();
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function compose(Function function) {
            return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
        }
    });
    static final Attributes EMPTY = Attributes.CC.builder().build();

    private ArrayBackedAttributes(Object[] objArr, java.util.Comparator<AttributeKey<?>> comparator) {
        super(objArr, comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBackedAttributes(Object[] objArr) {
        super(objArr);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public final AttributesBuilder toBuilder() {
        return new ArrayBackedAttributesBuilder(new ArrayList(data()));
    }

    @Override // io.opentelemetry.api.common.Attributes
    @Nullable
    public final <T> T get(AttributeKey<T> attributeKey) {
        return (T) super.get((ArrayBackedAttributes) attributeKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Attributes sortAndFilterToAttributes(Object... objArr) {
        for (int i = 0; i < objArr.length; i += 2) {
            AttributeKey attributeKey = (AttributeKey) objArr[i];
            if (attributeKey != null && attributeKey.getKey().isEmpty()) {
                objArr[i] = null;
            }
        }
        return new ArrayBackedAttributes(objArr, KEY_COMPARATOR_FOR_CONSTRUCTION);
    }
}
