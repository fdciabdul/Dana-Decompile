package kotlin.reflect.jvm.internal.impl.types;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* loaded from: classes.dex */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> implements Iterable<TypeAttribute<?>>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private static final TypeAttributes Empty = new TypeAttributes(CollectionsKt.emptyList());

    public /* synthetic */ TypeAttributes(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> list) {
        for (TypeAttribute<?> typeAttribute : list) {
            registerComponent(typeAttribute.getKey(), typeAttribute);
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public final <T extends TypeAttribute<?>> int customComputeIfAbsent(ConcurrentHashMap<KClass<? extends TypeAttribute<?>>, Integer> concurrentHashMap, KClass<T> kClass, Function1<? super KClass<? extends TypeAttribute<?>>, Integer> function1) {
            int intValue;
            Intrinsics.checkNotNullParameter(concurrentHashMap, "");
            Intrinsics.checkNotNullParameter(kClass, "");
            Intrinsics.checkNotNullParameter(function1, "");
            Integer num = concurrentHashMap.get(kClass);
            if (num == null) {
                synchronized (concurrentHashMap) {
                    Integer num2 = concurrentHashMap.get(kClass);
                    if (num2 == null) {
                        Integer invoke = function1.invoke(kClass);
                        concurrentHashMap.putIfAbsent(kClass, Integer.valueOf(invoke.intValue()));
                        num2 = invoke;
                    }
                    Intrinsics.checkNotNullExpressionValue(num2, "");
                    intValue = num2.intValue();
                }
                return intValue;
            }
            return num.intValue();
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.Empty;
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> list) {
            Intrinsics.checkNotNullParameter(list, "");
            if (list.isEmpty()) {
                return getEmpty();
            }
            return new TypeAttributes(list, null);
        }
    }

    private TypeAttributes(TypeAttribute<?> typeAttribute) {
        this(CollectionsKt.listOf(typeAttribute));
    }

    public final boolean contains(TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "");
        return getArrayMap().get(Companion.getId(typeAttribute.getKey())) != null;
    }

    public final TypeAttributes plus(TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "");
        if (contains(typeAttribute)) {
            return this;
        }
        if (isEmpty()) {
            return new TypeAttributes(typeAttribute);
        }
        return Companion.create(CollectionsKt.plus((Collection<? extends TypeAttribute<?>>) CollectionsKt.toList(this), typeAttribute));
    }

    public final TypeAttributes remove(TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "");
        if (isEmpty()) {
            return this;
        }
        ArrayMap<TypeAttribute<?>> arrayMap = getArrayMap();
        ArrayList arrayList = new ArrayList();
        for (TypeAttribute<?> typeAttribute2 : arrayMap) {
            if ((!Intrinsics.areEqual(typeAttribute2, typeAttribute)) != false) {
                arrayList.add(typeAttribute2);
            }
        }
        ArrayList arrayList2 = arrayList;
        return arrayList2.size() == getArrayMap().getSize() ? this : Companion.create(arrayList2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public final TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    public final TypeAttributes intersect(TypeAttributes typeAttributes) {
        Object intersect;
        Intrinsics.checkNotNullParameter(typeAttributes, "");
        if (isEmpty() && typeAttributes.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = Companion.getIndices().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            TypeAttribute<?> typeAttribute = getArrayMap().get(intValue);
            TypeAttribute<?> typeAttribute2 = typeAttributes.getArrayMap().get(intValue);
            if (typeAttribute == null) {
                intersect = typeAttribute2 != null ? typeAttribute2.intersect(typeAttribute) : null;
            } else {
                intersect = typeAttribute.intersect(typeAttribute2);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, intersect);
        }
        return Companion.create(arrayList);
    }

    public final TypeAttributes add(TypeAttributes typeAttributes) {
        Object add;
        Intrinsics.checkNotNullParameter(typeAttributes, "");
        if (isEmpty() && typeAttributes.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = Companion.getIndices().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            TypeAttribute<?> typeAttribute = getArrayMap().get(intValue);
            TypeAttribute<?> typeAttribute2 = typeAttributes.getArrayMap().get(intValue);
            if (typeAttribute == null) {
                add = typeAttribute2 != null ? typeAttribute2.add(typeAttribute) : null;
            } else {
                add = typeAttribute.add(typeAttribute2);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, add);
        }
        return Companion.create(arrayList);
    }
}
