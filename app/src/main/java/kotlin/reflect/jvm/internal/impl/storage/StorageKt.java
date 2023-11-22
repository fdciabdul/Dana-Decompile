package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> notNullLazyValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(notNullLazyValue, "");
        Intrinsics.checkNotNullParameter(kProperty, "");
        return notNullLazyValue.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> nullableLazyValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(nullableLazyValue, "");
        Intrinsics.checkNotNullParameter(kProperty, "");
        return nullableLazyValue.invoke();
    }
}
