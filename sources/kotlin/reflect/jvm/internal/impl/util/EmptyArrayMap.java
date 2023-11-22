package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class EmptyArrayMap extends ArrayMap {
    public static final EmptyArrayMap INSTANCE = new EmptyArrayMap();

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final Void get(int i) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final int getSize() {
        return 0;
    }

    private EmptyArrayMap() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final void set(int i, Void r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public final Iterator iterator() {
        return new EmptyArrayMap$iterator$1();
    }
}
