package androidx.collection;

import androidx.collection.MapCollections;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V>, j$.util.Map {
    MapCollections<K, V> BuiltInFictitiousFunctionClassFactory;

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.BuiltInFictitiousFunctionClassFactory((java.util.Map) this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.PlaceComponentResult((java.util.Map) this, obj, function);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.getAuthRequestContext(this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.PlaceComponentResult(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.MyBillsEntityDataFactory(this, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    /* renamed from: androidx.collection.ArrayMap$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends MapCollections<K, V> {
        AnonymousClass1() {
        }

        @Override // androidx.collection.MapCollections
        protected final int PlaceComponentResult() {
            return ArrayMap.this.getErrorConfigVersion;
        }

        @Override // androidx.collection.MapCollections
        protected final Object MyBillsEntityDataFactory(int i, int i2) {
            return ArrayMap.this.moveToNextValue[(i << 1) + i2];
        }

        @Override // androidx.collection.MapCollections
        protected final int PlaceComponentResult(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            return obj == null ? arrayMap.PlaceComponentResult() : arrayMap.KClassImpl$Data$declaredNonStaticMembers$2(obj, obj.hashCode());
        }

        @Override // androidx.collection.MapCollections
        protected final int MyBillsEntityDataFactory(Object obj) {
            return ArrayMap.this.BuiltInFictitiousFunctionClassFactory(obj);
        }

        @Override // androidx.collection.MapCollections
        protected final java.util.Map<K, V> MyBillsEntityDataFactory() {
            return ArrayMap.this;
        }

        @Override // androidx.collection.MapCollections
        protected final void BuiltInFictitiousFunctionClassFactory(K k, V v) {
            ArrayMap.this.put(k, v);
        }

        @Override // androidx.collection.MapCollections
        protected final V BuiltInFictitiousFunctionClassFactory(int i, V v) {
            return ArrayMap.this.KClassImpl$Data$declaredNonStaticMembers$2(i, (int) v);
        }

        @Override // androidx.collection.MapCollections
        protected final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            ArrayMap.this.MyBillsEntityDataFactory(i);
        }

        @Override // androidx.collection.MapCollections
        protected final void getAuthRequestContext() {
            ArrayMap.this.clear();
        }
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        PlaceComponentResult(this.getErrorConfigVersion + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Collection<?> collection) {
        return MapCollections.PlaceComponentResult(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new AnonymousClass1();
        }
        MapCollections<K, V> mapCollections = this.BuiltInFictitiousFunctionClassFactory;
        if (mapCollections.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            mapCollections.KClassImpl$Data$declaredNonStaticMembers$2 = new MapCollections.EntrySet();
        }
        return mapCollections.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new AnonymousClass1();
        }
        MapCollections<K, V> mapCollections = this.BuiltInFictitiousFunctionClassFactory;
        if (mapCollections.getAuthRequestContext == null) {
            mapCollections.getAuthRequestContext = new MapCollections.KeySet();
        }
        return mapCollections.getAuthRequestContext;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new AnonymousClass1();
        }
        MapCollections<K, V> mapCollections = this.BuiltInFictitiousFunctionClassFactory;
        if (mapCollections.BuiltInFictitiousFunctionClassFactory == null) {
            mapCollections.BuiltInFictitiousFunctionClassFactory = new MapCollections.ValuesCollection();
        }
        return mapCollections.BuiltInFictitiousFunctionClassFactory;
    }
}
