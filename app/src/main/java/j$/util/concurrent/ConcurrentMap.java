package j$.util.concurrent;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Map;

/* loaded from: classes.dex */
public interface ConcurrentMap<K, V> extends Map<K, V> {

    /* renamed from: j$.util.concurrent.ConcurrentMap$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        public static Object BuiltInFictitiousFunctionClassFactory(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, BiFunction biFunction) {
            while (true) {
                Object obj2 = concurrentMap.get(obj);
                if (obj2 == null) {
                    return obj2;
                }
                Object apply = biFunction.apply(obj, obj2);
                if (apply != null) {
                    if (concurrentMap.replace(obj, obj2, apply)) {
                        return apply;
                    }
                } else if (concurrentMap.remove(obj, obj2)) {
                    return null;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object MyBillsEntityDataFactory(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Function function) {
            Object apply;
            Object obj2 = concurrentMap.get(obj);
            return (obj2 == null && (apply = function.apply(obj)) != null && (obj2 = concurrentMap.putIfAbsent(obj, apply)) == null) ? apply : obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object PlaceComponentResult(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, BiFunction biFunction) {
            Object apply;
            while (true) {
                Object obj2 = concurrentMap.get(obj);
                do {
                    apply = biFunction.apply(obj, obj2);
                    if (apply == null) {
                        if ((obj2 == null && !concurrentMap.containsKey(obj)) || concurrentMap.remove(obj, obj2)) {
                            return null;
                        }
                    } else if (obj2 == null) {
                        obj2 = concurrentMap.putIfAbsent(obj, apply);
                    } else if (concurrentMap.replace(obj, obj2, apply)) {
                        return apply;
                    }
                } while (obj2 != null);
                return apply;
            }
        }

        public static Object PlaceComponentResult(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Object obj2) {
            Object obj3 = concurrentMap.get(obj);
            return obj3 != null ? obj3 : obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object PlaceComponentResult(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Object obj2, BiFunction biFunction) {
            while (true) {
                Object obj3 = concurrentMap.get(obj);
                while (obj3 == null) {
                    obj3 = concurrentMap.putIfAbsent(obj, obj2);
                    if (obj3 == null) {
                        return obj2;
                    }
                }
                Object apply = biFunction.apply(obj3, obj2);
                if (apply != null) {
                    if (concurrentMap.replace(obj, obj3, apply)) {
                        return apply;
                    }
                } else if (concurrentMap.remove(obj, obj3)) {
                    return null;
                }
            }
        }

        public static void getAuthRequestContext(java.util.concurrent.ConcurrentMap concurrentMap, BiConsumer biConsumer) {
            for (Map.Entry<K, V> entry : concurrentMap.entrySet()) {
                try {
                    biConsumer.accept(entry.getKey(), entry.getValue());
                } catch (IllegalStateException unused) {
                }
            }
        }
    }

    /* renamed from: j$.util.concurrent.ConcurrentMap$-EL  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(java.util.concurrent.ConcurrentMap concurrentMap, BiConsumer biConsumer) {
            if (concurrentMap instanceof ConcurrentMap) {
                ((ConcurrentMap) concurrentMap).forEach(biConsumer);
            } else {
                CC.getAuthRequestContext(concurrentMap, biConsumer);
            }
        }

        public static /* synthetic */ Object MyBillsEntityDataFactory(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Function function) {
            return concurrentMap instanceof ConcurrentMap ? ((ConcurrentMap) concurrentMap).computeIfAbsent(obj, function) : CC.MyBillsEntityDataFactory(concurrentMap, obj, function);
        }
    }

    @Override // j$.util.Map
    V computeIfAbsent(K k, Function<? super K, ? extends V> function);

    @Override // j$.util.Map
    void forEach(BiConsumer<? super K, ? super V> biConsumer);
}
