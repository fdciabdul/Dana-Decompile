package j$.util;

import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public interface Map<K, V> {

    /* renamed from: j$.util.Map$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        public static Object BuiltInFictitiousFunctionClassFactory(java.util.Map map, Object obj, BiFunction biFunction) {
            Object obj2 = map.get(obj);
            Object apply = biFunction.apply(obj, obj2);
            if (apply != null) {
                map.put(obj, apply);
                return apply;
            } else if (obj2 != null || map.containsKey(obj)) {
                map.remove(obj);
                return null;
            } else {
                return null;
            }
        }

        public static Object BuiltInFictitiousFunctionClassFactory(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return (obj3 != null || map.containsKey(obj)) ? obj3 : obj2;
        }

        public static Object KClassImpl$Data$declaredNonStaticMembers$2(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return (obj3 != null || map.containsKey(obj)) ? map.put(obj, obj2) : obj3;
        }

        public static Object MyBillsEntityDataFactory(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return obj3 == null ? map.put(obj, obj2) : obj3;
        }

        public static void MyBillsEntityDataFactory(java.util.Map map, BiFunction biFunction) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                try {
                    try {
                        entry.setValue((V) biFunction.apply(entry.getKey(), entry.getValue()));
                    } catch (IllegalStateException e) {
                        throw new ConcurrentModificationException(e);
                    }
                } catch (IllegalStateException e2) {
                    throw new ConcurrentModificationException(e2);
                }
            }
        }

        public static boolean MyBillsEntityDataFactory(java.util.Map map, Object obj, Object obj2, Object obj3) {
            Object obj4 = map.get(obj);
            if (Objects.MyBillsEntityDataFactory(obj4, obj2)) {
                if (obj4 != null || map.containsKey(obj)) {
                    map.put(obj, obj3);
                    return true;
                }
                return false;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object PlaceComponentResult(java.util.Map map, Object obj, Function function) {
            Object apply;
            Object obj2 = map.get(obj);
            if (obj2 != null || (apply = function.apply(obj)) == null) {
                return obj2;
            }
            map.put(obj, apply);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object PlaceComponentResult(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
            Object obj3 = map.get(obj);
            if (obj3 != null) {
                obj2 = biFunction.apply(obj3, obj2);
            }
            if (obj2 == null) {
                map.remove(obj);
            } else {
                map.put(obj, obj2);
            }
            return obj2;
        }

        public static boolean PlaceComponentResult(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            if (Objects.MyBillsEntityDataFactory(obj3, obj2)) {
                if (obj3 != null || map.containsKey(obj)) {
                    map.remove(obj);
                    return true;
                }
                return false;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object getAuthRequestContext(java.util.Map map, Object obj, BiFunction biFunction) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Object apply = biFunction.apply(obj, obj2);
                if (apply != null) {
                    map.put(obj, apply);
                    return apply;
                }
                map.remove(obj);
                return null;
            }
            return null;
        }

        public static void getAuthRequestContext(java.util.Map map, BiConsumer biConsumer) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                try {
                    biConsumer.accept(entry.getKey(), entry.getValue());
                } catch (IllegalStateException e) {
                    throw new ConcurrentModificationException(e);
                }
            }
        }
    }

    /* renamed from: j$.util.Map$-EL  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(java.util.Map map, Object obj, Function function) {
            return map instanceof Map ? ((Map) map).computeIfAbsent(obj, function) : map instanceof ConcurrentMap ? ConcurrentMap.CC.MyBillsEntityDataFactory((java.util.concurrent.ConcurrentMap) map, obj, function) : CC.PlaceComponentResult(map, obj, function);
        }

        public static /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
            return map instanceof Map ? ((Map) map).merge(obj, obj2, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.PlaceComponentResult((java.util.concurrent.ConcurrentMap) map, obj, obj2, biFunction) : CC.PlaceComponentResult(map, obj, obj2, biFunction);
        }

        public static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).remove(obj, obj2) : CC.PlaceComponentResult(map, obj, obj2);
        }

        public static /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(java.util.Map map, Object obj, BiFunction biFunction) {
            return map instanceof Map ? ((Map) map).compute(obj, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.PlaceComponentResult((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : CC.BuiltInFictitiousFunctionClassFactory(map, obj, biFunction);
        }

        public static /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).getOrDefault(obj, obj2) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.PlaceComponentResult((java.util.concurrent.ConcurrentMap) map, obj, obj2) : CC.BuiltInFictitiousFunctionClassFactory(map, obj, obj2);
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(java.util.Map map, BiConsumer biConsumer) {
            if (map instanceof Map) {
                ((Map) map).forEach(biConsumer);
            } else if (map instanceof java.util.concurrent.ConcurrentMap) {
                ConcurrentMap.CC.getAuthRequestContext((java.util.concurrent.ConcurrentMap) map, biConsumer);
            } else {
                CC.getAuthRequestContext(map, biConsumer);
            }
        }

        public static /* synthetic */ Object PlaceComponentResult(java.util.Map map, Object obj, Object obj2) {
            return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : CC.MyBillsEntityDataFactory(map, obj, obj2);
        }
    }

    /* loaded from: classes.dex */
    public interface Entry<K, V> {
    }

    V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction);

    V computeIfAbsent(K k, Function<? super K, ? extends V> function);

    V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction);

    void forEach(BiConsumer<? super K, ? super V> biConsumer);

    V getOrDefault(Object obj, V v);

    V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction);

    V putIfAbsent(K k, V v);

    boolean remove(Object obj, Object obj2);

    V replace(K k, V v);

    boolean replace(K k, V v, V v2);

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction);
}
