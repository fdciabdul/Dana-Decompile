package j$.util;

import j$.util.Collection;
import j$.util.List;
import j$.util.Map;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Consumer$$ExternalSyntheticLambda0;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class DesugarCollections {
    private static final Field BuiltInFictitiousFunctionClassFactory;
    public static final Class KClassImpl$Data$declaredNonStaticMembers$2;
    static final Class MyBillsEntityDataFactory;
    private static final Field PlaceComponentResult;
    private static final Constructor getAuthRequestContext;
    private static final Constructor getErrorConfigVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class SynchronizedMap implements java.util.Map, Serializable, Map {
        private static final long serialVersionUID = 1978198479659022715L;
        private transient Set entrySet;
        private transient Set keySet;
        private final java.util.Map m;
        final Object mutex = this;
        private transient java.util.Collection values;

        SynchronizedMap(java.util.Map map) {
            this.m = map;
        }

        private static Set instantiateSet(Set set, Object obj) {
            if (DesugarCollections.getErrorConfigVersion == null) {
                return Collections.synchronizedSet(set);
            }
            try {
                return (Set) DesugarCollections.getErrorConfigVersion.newInstance(set, obj);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new Error("Unable to instantiate a synchronized list.", e);
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        @Override // java.util.Map
        public final void clear() {
            synchronized (this.mutex) {
                this.m.clear();
            }
        }

        @Override // j$.util.Map
        public final Object compute(Object obj, BiFunction biFunction) {
            Object KClassImpl$Data$declaredNonStaticMembers$2;
            synchronized (this.mutex) {
                KClassImpl$Data$declaredNonStaticMembers$2 = Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.m, obj, biFunction);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // java.util.Map
        public final /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
            return compute(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
        }

        @Override // j$.util.Map
        public final Object computeIfAbsent(Object obj, Function function) {
            Object BuiltInFictitiousFunctionClassFactory;
            synchronized (this.mutex) {
                BuiltInFictitiousFunctionClassFactory = Map.EL.BuiltInFictitiousFunctionClassFactory(this.m, obj, function);
            }
            return BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Map
        public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
            return computeIfAbsent(obj, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
        }

        @Override // j$.util.Map
        public final Object computeIfPresent(Object obj, BiFunction biFunction) {
            Object computeIfPresent;
            synchronized (this.mutex) {
                java.util.Map map = this.m;
                computeIfPresent = map instanceof Map ? ((Map) map).computeIfPresent(obj, biFunction) : map instanceof ConcurrentMap ? ConcurrentMap.CC.BuiltInFictitiousFunctionClassFactory((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : Map.CC.getAuthRequestContext(map, obj, biFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
            return computeIfPresent(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
        }

        @Override // java.util.Map
        public final boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = this.m.containsKey(obj);
            }
            return containsKey;
        }

        @Override // java.util.Map
        public final boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = this.m.containsValue(obj);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public final Set entrySet() {
            Set set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = instantiateSet(this.m.entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Map
        public final boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.m.equals(obj);
            }
            return equals;
        }

        @Override // j$.util.Map
        public final void forEach(BiConsumer biConsumer) {
            synchronized (this.mutex) {
                Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.m, biConsumer);
            }
        }

        @Override // java.util.Map
        public final /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
            forEach(BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
        }

        @Override // java.util.Map
        public final Object get(Object obj) {
            Object obj2;
            synchronized (this.mutex) {
                obj2 = this.m.get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map, j$.util.Map
        public final Object getOrDefault(Object obj, Object obj2) {
            Object KClassImpl$Data$declaredNonStaticMembers$2;
            synchronized (this.mutex) {
                KClassImpl$Data$declaredNonStaticMembers$2 = Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.m, obj, obj2);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // java.util.Map
        public final int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.m.hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public final boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.m.isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public final Set keySet() {
            Set set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = instantiateSet(this.m.keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // j$.util.Map
        public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
            Object BuiltInFictitiousFunctionClassFactory;
            synchronized (this.mutex) {
                BuiltInFictitiousFunctionClassFactory = Map.EL.BuiltInFictitiousFunctionClassFactory(this.m, obj, obj2, biFunction);
            }
            return BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Map
        public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
            return merge(obj, obj2, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
        }

        @Override // java.util.Map
        public final Object put(Object obj, Object obj2) {
            Object put;
            synchronized (this.mutex) {
                put = this.m.put(obj, obj2);
            }
            return put;
        }

        @Override // java.util.Map
        public final void putAll(java.util.Map map) {
            synchronized (this.mutex) {
                this.m.putAll(map);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public final Object putIfAbsent(Object obj, Object obj2) {
            Object PlaceComponentResult;
            synchronized (this.mutex) {
                PlaceComponentResult = Map.EL.PlaceComponentResult(this.m, obj, obj2);
            }
            return PlaceComponentResult;
        }

        @Override // java.util.Map
        public final Object remove(Object obj) {
            Object remove;
            synchronized (this.mutex) {
                remove = this.m.remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map, j$.util.Map
        public final boolean remove(Object obj, Object obj2) {
            boolean BuiltInFictitiousFunctionClassFactory;
            synchronized (this.mutex) {
                BuiltInFictitiousFunctionClassFactory = Map.EL.BuiltInFictitiousFunctionClassFactory(this.m, obj, obj2);
            }
            return BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Map, j$.util.Map
        public final Object replace(Object obj, Object obj2) {
            Object replace;
            synchronized (this.mutex) {
                java.util.Map map = this.m;
                replace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.KClassImpl$Data$declaredNonStaticMembers$2(map, obj, obj2);
            }
            return replace;
        }

        @Override // java.util.Map, j$.util.Map
        public final boolean replace(Object obj, Object obj2, Object obj3) {
            boolean replace;
            synchronized (this.mutex) {
                java.util.Map map = this.m;
                replace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.MyBillsEntityDataFactory(map, obj, obj2, obj3);
            }
            return replace;
        }

        @Override // j$.util.Map
        public final void replaceAll(BiFunction biFunction) {
            synchronized (this.mutex) {
                java.util.Map map = this.m;
                if (map instanceof Map) {
                    ((Map) map).replaceAll(biFunction);
                } else if (map instanceof java.util.concurrent.ConcurrentMap) {
                    ConcurrentMap.EL.KClassImpl$Data$declaredNonStaticMembers$2(r1, new Consumer$$ExternalSyntheticLambda0(1, (java.util.concurrent.ConcurrentMap) map, biFunction));
                } else {
                    Map.CC.MyBillsEntityDataFactory(map, biFunction);
                }
            }
        }

        @Override // java.util.Map
        public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
            replaceAll(BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
        }

        @Override // java.util.Map
        public final int size() {
            int size;
            synchronized (this.mutex) {
                size = this.m.size();
            }
            return size;
        }

        public final String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.m.toString();
            }
            return obj;
        }

        @Override // java.util.Map
        public final java.util.Collection values() {
            java.util.Collection collection;
            java.util.Collection collection2;
            synchronized (this.mutex) {
                if (this.values == null) {
                    java.util.Collection values = this.m.values();
                    Object obj = this.mutex;
                    if (DesugarCollections.getAuthRequestContext == null) {
                        collection2 = Collections.synchronizedCollection(values);
                    } else {
                        try {
                            collection2 = (java.util.Collection) DesugarCollections.getAuthRequestContext.newInstance(values, obj);
                        } catch (IllegalAccessException e) {
                            e = e;
                            throw new Error("Unable to instantiate a synchronized list.", e);
                        } catch (InstantiationException e2) {
                            e = e2;
                            throw new Error("Unable to instantiate a synchronized list.", e);
                        } catch (InvocationTargetException e3) {
                            e = e3;
                            throw new Error("Unable to instantiate a synchronized list.", e);
                        }
                    }
                    this.values = collection2;
                }
                collection = this.values;
            }
            return collection;
        }
    }

    static {
        Field field;
        Field field2;
        Constructor<?> constructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        KClassImpl$Data$declaredNonStaticMembers$2 = cls;
        MyBillsEntityDataFactory = Collections.synchronizedList(new LinkedList()).getClass();
        Constructor<?> constructor2 = null;
        try {
            field = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        PlaceComponentResult = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        BuiltInFictitiousFunctionClassFactory = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(Set.class, Object.class);
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        getErrorConfigVersion = constructor;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls.getDeclaredConstructor(java.util.Collection.class, Object.class);
        } catch (NoSuchMethodException unused4) {
        }
        getAuthRequestContext = constructor2;
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Iterable iterable, Consumer consumer) {
        Field field = PlaceComponentResult;
        if (field == null) {
            try {
                Collection.EL.getAuthRequestContext((java.util.Collection) BuiltInFictitiousFunctionClassFactory.get(iterable), consumer);
                return;
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", e);
            }
        }
        try {
            synchronized (field.get(iterable)) {
                Collection.EL.getAuthRequestContext((java.util.Collection) BuiltInFictitiousFunctionClassFactory.get(iterable), consumer);
            }
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized collection forEach.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(java.util.List list, UnaryOperator unaryOperator) {
        Field field = PlaceComponentResult;
        if (field == null) {
            try {
                List.EL.MyBillsEntityDataFactory((java.util.List) BuiltInFictitiousFunctionClassFactory.get(list), unaryOperator);
                return;
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized list replaceAll fall-back.", e);
            }
        }
        try {
            synchronized (field.get(list)) {
                List.EL.MyBillsEntityDataFactory((java.util.List) BuiltInFictitiousFunctionClassFactory.get(list), unaryOperator);
            }
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized list replaceAll.", e2);
        }
    }

    public static <K, V> java.util.Map<K, V> MyBillsEntityDataFactory(java.util.Map<K, V> map) {
        return new SynchronizedMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(java.util.List list, java.util.Comparator comparator) {
        Field field = PlaceComponentResult;
        if (field == null) {
            try {
                List.EL.PlaceComponentResult((java.util.List) BuiltInFictitiousFunctionClassFactory.get(list), comparator);
                return;
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e);
            }
        }
        try {
            synchronized (field.get(list)) {
                List.EL.PlaceComponentResult((java.util.List) BuiltInFictitiousFunctionClassFactory.get(list), comparator);
            }
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized list sort.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean PlaceComponentResult(java.util.Collection collection, Predicate predicate) {
        boolean BuiltInFictitiousFunctionClassFactory2;
        Field field = PlaceComponentResult;
        if (field == null) {
            try {
                return Collection.EL.BuiltInFictitiousFunctionClassFactory((java.util.Collection) BuiltInFictitiousFunctionClassFactory.get(collection), predicate);
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e);
            }
        }
        try {
            synchronized (field.get(collection)) {
                BuiltInFictitiousFunctionClassFactory2 = Collection.EL.BuiltInFictitiousFunctionClassFactory((java.util.Collection) BuiltInFictitiousFunctionClassFactory.get(collection), predicate);
            }
            return BuiltInFictitiousFunctionClassFactory2;
        } catch (IllegalAccessException e2) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e2);
        }
    }
}
