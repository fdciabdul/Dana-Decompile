package androidx.collection;

import j$.util.Iterator;
import j$.util.Map;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class MapCollections<K, V> {
    MapCollections<K, V>.ValuesCollection BuiltInFictitiousFunctionClassFactory;
    MapCollections<K, V>.EntrySet KClassImpl$Data$declaredNonStaticMembers$2;
    MapCollections<K, V>.KeySet getAuthRequestContext;

    protected abstract V BuiltInFictitiousFunctionClassFactory(int i, V v);

    protected abstract void BuiltInFictitiousFunctionClassFactory(K k, V v);

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(int i);

    protected abstract int MyBillsEntityDataFactory(Object obj);

    protected abstract Object MyBillsEntityDataFactory(int i, int i2);

    protected abstract Map<K, V> MyBillsEntityDataFactory();

    protected abstract int PlaceComponentResult();

    protected abstract int PlaceComponentResult(Object obj);

    protected abstract void getAuthRequestContext();

    /* loaded from: classes.dex */
    final class ArrayIterator<T> implements Iterator<T>, j$.util.Iterator {
        boolean BuiltInFictitiousFunctionClassFactory = false;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        final int getAuthRequestContext;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        ArrayIterator(int i) {
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = MapCollections.this.PlaceComponentResult();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.MyBillsEntityDataFactory < this.PlaceComponentResult;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) MapCollections.this.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
            this.MyBillsEntityDataFactory++;
            this.BuiltInFictitiousFunctionClassFactory = true;
            return t;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                throw new IllegalStateException();
            }
            int i = this.MyBillsEntityDataFactory - 1;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult--;
            this.BuiltInFictitiousFunctionClassFactory = false;
            MapCollections.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    /* loaded from: classes.dex */
    final class MapIterator implements java.util.Iterator<Map.Entry<K, V>>, Map.Entry<K, V>, j$.util.Iterator, Map.Entry {
        int BuiltInFictitiousFunctionClassFactory;
        boolean getAuthRequestContext = false;
        int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        MapIterator() {
            this.BuiltInFictitiousFunctionClassFactory = MapCollections.this.PlaceComponentResult() - 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 < this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.getAuthRequestContext) {
                throw new IllegalStateException();
            }
            MapCollections.this.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2--;
            this.BuiltInFictitiousFunctionClassFactory--;
            this.getAuthRequestContext = false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (!this.getAuthRequestContext) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) MapCollections.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0);
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (!this.getAuthRequestContext) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) MapCollections.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 1);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (!this.getAuthRequestContext) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) MapCollections.this.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, (int) v);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.getAuthRequestContext) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return ContainerHelpers.getAuthRequestContext(entry.getKey(), MapCollections.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0)) && ContainerHelpers.getAuthRequestContext(entry.getValue(), MapCollections.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 1));
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.getAuthRequestContext) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object MyBillsEntityDataFactory = MapCollections.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0);
            Object MyBillsEntityDataFactory2 = MapCollections.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 1);
            return (MyBillsEntityDataFactory == null ? 0 : MyBillsEntityDataFactory.hashCode()) ^ (MyBillsEntityDataFactory2 != null ? MyBillsEntityDataFactory2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append("=");
            sb.append(getValue());
            return sb.toString();
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            this.getAuthRequestContext = true;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class EntrySet implements Set<Map.Entry<K, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final /* synthetic */ boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            return BuiltInFictitiousFunctionClassFactory();
        }

        private static boolean BuiltInFictitiousFunctionClassFactory() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int PlaceComponentResult = MapCollections.this.PlaceComponentResult();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.BuiltInFictitiousFunctionClassFactory((MapCollections) entry.getKey(), (K) entry.getValue());
            }
            return PlaceComponentResult != MapCollections.this.PlaceComponentResult();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            MapCollections.this.getAuthRequestContext();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int PlaceComponentResult = MapCollections.this.PlaceComponentResult(entry.getKey());
                if (PlaceComponentResult < 0) {
                    return false;
                }
                return ContainerHelpers.getAuthRequestContext(MapCollections.this.MyBillsEntityDataFactory(PlaceComponentResult, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return MapCollections.this.PlaceComponentResult() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return MapCollections.this.PlaceComponentResult();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return MapCollections.MyBillsEntityDataFactory(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int i = 0;
            for (int PlaceComponentResult = MapCollections.this.PlaceComponentResult() - 1; PlaceComponentResult >= 0; PlaceComponentResult--) {
                Object MyBillsEntityDataFactory = MapCollections.this.MyBillsEntityDataFactory(PlaceComponentResult, 0);
                Object MyBillsEntityDataFactory2 = MapCollections.this.MyBillsEntityDataFactory(PlaceComponentResult, 1);
                i += (MyBillsEntityDataFactory == null ? 0 : MyBillsEntityDataFactory.hashCode()) ^ (MyBillsEntityDataFactory2 == null ? 0 : MyBillsEntityDataFactory2.hashCode());
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class KeySet implements Set<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            MapCollections.this.getAuthRequestContext();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return MapCollections.this.PlaceComponentResult(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            return MapCollections.getAuthRequestContext(MapCollections.this.MyBillsEntityDataFactory(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return MapCollections.this.PlaceComponentResult() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            int PlaceComponentResult = MapCollections.this.PlaceComponentResult(obj);
            if (PlaceComponentResult >= 0) {
                MapCollections.this.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            return MapCollections.MyBillsEntityDataFactory(MapCollections.this.MyBillsEntityDataFactory(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            return MapCollections.PlaceComponentResult(MapCollections.this.MyBillsEntityDataFactory(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return MapCollections.this.PlaceComponentResult();
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            return MapCollections.this.MyBillsEntityDataFactory(0);
        }

        @Override // java.util.Set, java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.getAuthRequestContext(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            return MapCollections.MyBillsEntityDataFactory(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int i = 0;
            for (int PlaceComponentResult = MapCollections.this.PlaceComponentResult() - 1; PlaceComponentResult >= 0; PlaceComponentResult--) {
                Object MyBillsEntityDataFactory = MapCollections.this.MyBillsEntityDataFactory(PlaceComponentResult, 0);
                i += MyBillsEntityDataFactory == null ? 0 : MyBillsEntityDataFactory.hashCode();
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ValuesCollection implements Collection<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ValuesCollection() {
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            MapCollections.this.getAuthRequestContext();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return MapCollections.this.MyBillsEntityDataFactory(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return MapCollections.this.PlaceComponentResult() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final java.util.Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            int MyBillsEntityDataFactory = MapCollections.this.MyBillsEntityDataFactory(obj);
            if (MyBillsEntityDataFactory >= 0) {
                MapCollections.this.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            int PlaceComponentResult = MapCollections.this.PlaceComponentResult();
            int i = 0;
            boolean z = false;
            while (i < PlaceComponentResult) {
                if (collection.contains(MapCollections.this.MyBillsEntityDataFactory(i, 1))) {
                    MapCollections.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
                    i--;
                    PlaceComponentResult--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            int PlaceComponentResult = MapCollections.this.PlaceComponentResult();
            int i = 0;
            boolean z = false;
            while (i < PlaceComponentResult) {
                if (!collection.contains(MapCollections.this.MyBillsEntityDataFactory(i, 1))) {
                    MapCollections.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
                    i--;
                    PlaceComponentResult--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return MapCollections.this.PlaceComponentResult();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            return MapCollections.this.MyBillsEntityDataFactory(1);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.getAuthRequestContext(tArr, 1);
        }
    }

    public static <K, V> boolean getAuthRequestContext(java.util.Map<K, V> map, Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean MyBillsEntityDataFactory(java.util.Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean PlaceComponentResult(java.util.Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] MyBillsEntityDataFactory(int i) {
        int PlaceComponentResult = PlaceComponentResult();
        Object[] objArr = new Object[PlaceComponentResult];
        for (int i2 = 0; i2 < PlaceComponentResult; i2++) {
            objArr[i2] = MyBillsEntityDataFactory(i2, i);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] getAuthRequestContext(T[] tArr, int i) {
        int PlaceComponentResult = PlaceComponentResult();
        if (tArr.length < PlaceComponentResult) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), PlaceComponentResult));
        }
        for (int i2 = 0; i2 < PlaceComponentResult; i2++) {
            tArr[i2] = MyBillsEntityDataFactory(i2, i);
        }
        if (tArr.length > PlaceComponentResult) {
            tArr[PlaceComponentResult] = null;
        }
        return tArr;
    }

    public static <T> boolean MyBillsEntityDataFactory(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
