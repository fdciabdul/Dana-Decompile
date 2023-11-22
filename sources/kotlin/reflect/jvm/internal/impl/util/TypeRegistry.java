package kotlin.reflect.jvm.internal.impl.util;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public abstract class TypeRegistry<K, V> {
    private final ConcurrentHashMap<KClass<? extends K>, Integer> idPerType = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public abstract <T extends K> int customComputeIfAbsent(ConcurrentHashMap<KClass<? extends K>, Integer> concurrentHashMap, KClass<T> kClass, Function1<? super KClass<? extends K>, Integer> function1);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        return new NullableArrayMapAccessor<>(kClass, getId(kClass));
    }

    public final <T extends K> int getId(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        return customComputeIfAbsent(this.idPerType, kClass, new Function1<KClass<? extends K>, Integer>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.TypeRegistry$getId$1
            final /* synthetic */ TypeRegistry<K, V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final Integer invoke(KClass<? extends K> kClass2) {
                AtomicInteger atomicInteger;
                Intrinsics.checkNotNullParameter(kClass2, "");
                atomicInteger = ((TypeRegistry) this.this$0).idCounter;
                return Integer.valueOf(atomicInteger.getAndIncrement());
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Integer invoke(Object obj) {
                return invoke((KClass) ((KClass) obj));
            }
        });
    }

    public final Collection<Integer> getIndices() {
        Collection<Integer> values = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(values, "");
        return values;
    }
}
