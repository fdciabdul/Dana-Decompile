package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {
    protected abstract ArrayMap<V> getArrayMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract TypeRegistry<K, V> getTypeRegistry();

    protected abstract void registerComponent(KClass<? extends K> kClass, V v);

    /* loaded from: classes.dex */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {

        /* renamed from: id  reason: collision with root package name */
        private final int f8264id;
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(KClass<? extends K> kClass, int i) {
            Intrinsics.checkNotNullParameter(kClass, "");
            this.key = kClass;
            this.f8264id = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v2, types: [T extends V, java.lang.Object] */
        public final T extractValue(AbstractArrayMapOwner<K, V> abstractArrayMapOwner) {
            Intrinsics.checkNotNullParameter(abstractArrayMapOwner, "");
            return abstractArrayMapOwner.getArrayMap().get(this.f8264id);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public final boolean isEmpty() {
        return getArrayMap().getSize() == 0;
    }
}
