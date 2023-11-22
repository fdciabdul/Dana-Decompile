package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    public Entry<K, V> KClassImpl$Data$declaredNonStaticMembers$2;
    public Entry<K, V> getAuthRequestContext;
    public WeakHashMap<SupportRemove<K, V>, Boolean> BuiltInFictitiousFunctionClassFactory = new WeakHashMap<>();
    public int MyBillsEntityDataFactory = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface SupportRemove<K, V> {
        void a_(Entry<K, V> entry);
    }

    protected Entry<K, V> PlaceComponentResult(K k) {
        Entry<K, V> entry = this.KClassImpl$Data$declaredNonStaticMembers$2;
        while (entry != null && !entry.PlaceComponentResult.equals(k)) {
            entry = entry.MyBillsEntityDataFactory;
        }
        return entry;
    }

    public V BuiltInFictitiousFunctionClassFactory(K k, V v) {
        Entry<K, V> PlaceComponentResult = PlaceComponentResult(k);
        if (PlaceComponentResult != null) {
            return PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        }
        MyBillsEntityDataFactory(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Entry<K, V> MyBillsEntityDataFactory(K k, V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        this.MyBillsEntityDataFactory++;
        Entry<K, V> entry2 = this.getAuthRequestContext;
        if (entry2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = entry;
            this.getAuthRequestContext = entry;
            return entry;
        }
        entry2.MyBillsEntityDataFactory = entry;
        entry.getAuthRequestContext = this.getAuthRequestContext;
        this.getAuthRequestContext = entry;
        return entry;
    }

    public V KClassImpl$Data$declaredNonStaticMembers$2(K k) {
        Entry<K, V> PlaceComponentResult = PlaceComponentResult(k);
        if (PlaceComponentResult == null) {
            return null;
        }
        this.MyBillsEntityDataFactory--;
        if (!this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            Iterator<SupportRemove<K, V>> it = this.BuiltInFictitiousFunctionClassFactory.keySet().iterator();
            while (it.hasNext()) {
                it.next().a_(PlaceComponentResult);
            }
        }
        if (PlaceComponentResult.getAuthRequestContext != null) {
            PlaceComponentResult.getAuthRequestContext.MyBillsEntityDataFactory = PlaceComponentResult.MyBillsEntityDataFactory;
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.MyBillsEntityDataFactory;
        }
        if (PlaceComponentResult.MyBillsEntityDataFactory != null) {
            PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext = PlaceComponentResult.getAuthRequestContext;
        } else {
            this.getAuthRequestContext = PlaceComponentResult.getAuthRequestContext;
        }
        PlaceComponentResult.MyBillsEntityDataFactory = null;
        PlaceComponentResult.getAuthRequestContext = null;
        return PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
        this.BuiltInFictitiousFunctionClassFactory.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SafeIterableMap) {
            SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
            if (this.MyBillsEntityDataFactory != safeIterableMap.MyBillsEntityDataFactory) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        Entry<K, V> BuiltInFictitiousFunctionClassFactory;
        Entry<K, V> PlaceComponentResult;

        abstract Entry<K, V> KClassImpl$Data$declaredNonStaticMembers$2(Entry<K, V> entry);

        abstract Entry<K, V> MyBillsEntityDataFactory(Entry<K, V> entry);

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.BuiltInFictitiousFunctionClassFactory = entry2;
            this.PlaceComponentResult = entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.PlaceComponentResult != null;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void a_(Entry<K, V> entry) {
            Entry<K, V> entry2 = null;
            if (this.BuiltInFictitiousFunctionClassFactory == entry && entry == this.PlaceComponentResult) {
                this.PlaceComponentResult = null;
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
            Entry<K, V> entry3 = this.BuiltInFictitiousFunctionClassFactory;
            if (entry3 == entry) {
                this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory(entry3);
            }
            Entry<K, V> entry4 = this.PlaceComponentResult;
            if (entry4 == entry) {
                Entry<K, V> entry5 = this.BuiltInFictitiousFunctionClassFactory;
                if (entry4 != entry5 && entry5 != null) {
                    entry2 = KClassImpl$Data$declaredNonStaticMembers$2(entry4);
                }
                this.PlaceComponentResult = entry2;
            }
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            Entry<K, V> entry = this.PlaceComponentResult;
            Entry<K, V> entry2 = this.BuiltInFictitiousFunctionClassFactory;
            this.PlaceComponentResult = (entry == entry2 || entry2 == null) ? null : KClassImpl$Data$declaredNonStaticMembers$2(entry);
            return entry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        final Entry<K, V> KClassImpl$Data$declaredNonStaticMembers$2(Entry<K, V> entry) {
            return entry.MyBillsEntityDataFactory;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        final Entry<K, V> MyBillsEntityDataFactory(Entry<K, V> entry) {
            return entry.getAuthRequestContext;
        }
    }

    /* loaded from: classes.dex */
    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        final Entry<K, V> KClassImpl$Data$declaredNonStaticMembers$2(Entry<K, V> entry) {
            return entry.getAuthRequestContext;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        final Entry<K, V> MyBillsEntityDataFactory(Entry<K, V> entry) {
            return entry.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes.dex */
    public class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        private Entry<K, V> BuiltInFictitiousFunctionClassFactory;
        private boolean MyBillsEntityDataFactory = true;

        public IteratorWithAdditions() {
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void a_(Entry<K, V> entry) {
            Entry<K, V> entry2 = this.BuiltInFictitiousFunctionClassFactory;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.getAuthRequestContext;
                this.BuiltInFictitiousFunctionClassFactory = entry3;
                this.MyBillsEntityDataFactory = entry3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.MyBillsEntityDataFactory) {
                return SafeIterableMap.this.KClassImpl$Data$declaredNonStaticMembers$2 != null;
            }
            Entry<K, V> entry = this.BuiltInFictitiousFunctionClassFactory;
            return (entry == null || entry.MyBillsEntityDataFactory == null) ? false : true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            if (this.MyBillsEntityDataFactory) {
                this.MyBillsEntityDataFactory = false;
                this.BuiltInFictitiousFunctionClassFactory = SafeIterableMap.this.KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                Entry<K, V> entry = this.BuiltInFictitiousFunctionClassFactory;
                this.BuiltInFictitiousFunctionClassFactory = entry != null ? entry.MyBillsEntityDataFactory : null;
            }
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        final V BuiltInFictitiousFunctionClassFactory;
        Entry<K, V> MyBillsEntityDataFactory;
        final K PlaceComponentResult;
        public Entry<K, V> getAuthRequestContext;

        Entry(K k, V v) {
            this.PlaceComponentResult = k;
            this.BuiltInFictitiousFunctionClassFactory = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.PlaceComponentResult;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult);
            sb.append("=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            return sb.toString();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                return this.PlaceComponentResult.equals(entry.PlaceComponentResult) && this.BuiltInFictitiousFunctionClassFactory.equals(entry.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.PlaceComponentResult.hashCode() ^ this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }
    }
}
