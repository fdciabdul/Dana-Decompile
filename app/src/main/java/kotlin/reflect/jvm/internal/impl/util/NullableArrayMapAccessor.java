package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner;

/* loaded from: classes.dex */
public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    @Override // kotlin.properties.ReadOnlyProperty
    public final /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue((AbstractArrayMapOwner) ((AbstractArrayMapOwner) obj), (KProperty<?>) kProperty);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NullableArrayMapAccessor(KClass<? extends K> kClass, int i) {
        super(kClass, i);
        Intrinsics.checkNotNullParameter(kClass, "");
    }

    public final T getValue(AbstractArrayMapOwner<K, V> abstractArrayMapOwner, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(abstractArrayMapOwner, "");
        Intrinsics.checkNotNullParameter(kProperty, "");
        return extractValue(abstractArrayMapOwner);
    }
}
