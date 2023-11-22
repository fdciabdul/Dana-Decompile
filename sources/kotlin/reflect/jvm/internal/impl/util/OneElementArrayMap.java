package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;
    private final T value;

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final int getSize() {
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneElementArrayMap(T t, int i) {
        super(null);
        Intrinsics.checkNotNullParameter(t, "");
        this.value = t;
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final void set(int i, T t) {
        Intrinsics.checkNotNullParameter(t, "");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final T get(int i) {
        if (i == this.index) {
            return this.value;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new OneElementArrayMap$iterator$1(this);
    }
}
