package j$.util.concurrent;

import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.google.common.base.Ascii;
import id.dana.cashier.view.InputCardNumberView;
import j$.util.Collection;
import j$.util.Iterator;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, Serializable, ConcurrentMap<K, V> {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int MAX_RESIZERS = 65535;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final int RESIZE_STAMP_SHIFT = 16;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final Unsafe U;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView entrySet;
    private transient KeySetView keySet;
    private volatile transient Node[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node[] table;
    private volatile transient int transferIndex;
    private transient ValuesView values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class BaseIterator extends Traverser {
        Node BuiltInFictitiousFunctionClassFactory;
        final ConcurrentHashMap PlaceComponentResult;

        BaseIterator(Node[] nodeArr, int i, int i2, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, 0, i2);
            this.PlaceComponentResult = concurrentHashMap;
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }

        public final boolean hasMoreElements() {
            return this.lookAheadTest != null;
        }

        public final boolean hasNext() {
            return this.lookAheadTest != null;
        }

        public final void remove() {
            Node node = this.BuiltInFictitiousFunctionClassFactory;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.PlaceComponentResult.replaceNode(node.KClassImpl$Data$declaredNonStaticMembers$2, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class CollectionView implements Collection, Serializable {
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMap map;

        CollectionView(ConcurrentHashMap concurrentHashMap) {
            this.map = concurrentHashMap;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection
        public final boolean containsAll(Collection collection) {
            if (collection != this) {
                for (Object obj : collection) {
                    if (obj == null || !contains(obj)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator iterator();

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long sumCount = this.map.sumCount();
            if (sumCount < 0) {
                sumCount = 0;
            }
            if (sumCount <= 2147483639) {
                int i = (int) sumCount;
                Object[] objArr = new Object[i];
                int i2 = 0;
                Iterator it = iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (i2 == i) {
                        if (i >= 2147483639) {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                        int i3 = i < 1073741819 ? (i >>> 1) + 1 + i : 2147483639;
                        objArr = Arrays.copyOf(objArr, i3);
                        i = i3;
                    }
                    objArr[i2] = next;
                    i2++;
                }
                return i2 != i ? Arrays.copyOf(objArr, i2) : objArr;
            }
            throw new OutOfMemoryError("Required array size too large");
        }

        @Override // java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            long sumCount = this.map.sumCount();
            if (sumCount < 0) {
                sumCount = 0;
            }
            if (sumCount <= 2147483639) {
                int i = (int) sumCount;
                Object[] objArr2 = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                int length = objArr2.length;
                int i2 = 0;
                Iterator it = iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (i2 == length) {
                        if (length >= 2147483639) {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                        int i3 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                        objArr2 = Arrays.copyOf(objArr2, i3);
                        length = i3;
                    }
                    objArr2[i2] = next;
                    i2++;
                }
                if (objArr != objArr2 || i2 >= length) {
                    return i2 != length ? Arrays.copyOf(objArr2, i2) : objArr2;
                }
                objArr2[i2] = null;
                return objArr2;
            }
            throw new OutOfMemoryError("Required array size too large");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(InputCardNumberView.DIVIDER);
                }
            }
            sb.append(']');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CounterCell {
        volatile long PlaceComponentResult;

        CounterCell(long j) {
            this.PlaceComponentResult = j;
        }
    }

    /* loaded from: classes.dex */
    final class EntryIterator extends BaseIterator implements Iterator, j$.util.Iterator {
        EntryIterator(Node[] nodeArr, int i, int i2, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, concurrentHashMap);
        }

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public final Object next() {
            Node node = this.lookAheadTest;
            if (node != null) {
                Object obj = node.KClassImpl$Data$declaredNonStaticMembers$2;
                Object obj2 = node.BuiltInFictitiousFunctionClassFactory;
                this.BuiltInFictitiousFunctionClassFactory = node;
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                return new MapEntry(obj, obj2, this.PlaceComponentResult);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes.dex */
    final class EntrySetView extends CollectionView implements Set, j$.util.Collection {
        private static final long serialVersionUID = 2249069246763182397L;

        EntrySetView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            return this.map.putVal(entry.getKey(), entry.getValue(), false) == null;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            java.util.Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (this.map.putVal(entry.getKey(), entry.getValue(), false) == null) {
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            V v;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (v = this.map.get(key)) == null || (value = entry.getValue()) == null || (value != v && !value.equals(v))) ? false : true;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            Node[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return;
                }
                consumer.accept(new MapEntry(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory, this.map));
            }
        }

        @Override // java.lang.Iterable
        public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            Node[] nodeArr = this.map.table;
            int i = 0;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                        break;
                    }
                    i += NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
                }
            }
            return i;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, length, length, concurrentHashMap);
        }

        @Override // java.util.Collection, j$.util.Collection
        public final /* synthetic */ Stream parallelStream() {
            return Collection.CC.MyBillsEntityDataFactory(this);
        }

        @Override // java.util.Collection
        public final /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.MyBillsEntityDataFactory(Collection.CC.MyBillsEntityDataFactory(this));
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.map.remove(key, value);
        }

        @Override // j$.util.Collection
        public final /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
        }

        @Override // java.util.Collection
        public final /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Collection, java.util.List, j$.util.List
        public final Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long sumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntrySpliterator(nodeArr, length, 0, length, sumCount >= 0 ? sumCount : 0L, concurrentHashMap);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public final /* synthetic */ Stream stream() {
            return Collection.CC.PlaceComponentResult(this);
        }

        @Override // java.util.Collection
        public final /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.MyBillsEntityDataFactory(Collection.CC.PlaceComponentResult(this));
        }

        @Override // java.util.Collection
        public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Collection.CC.MyBillsEntityDataFactory(this, IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class EntrySpliterator extends Traverser implements Spliterator {
        long BuiltInFictitiousFunctionClassFactory;
        final ConcurrentHashMap getAuthRequestContext;

        EntrySpliterator(Node[] nodeArr, int i, int i2, int i3, long j, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3);
            this.getAuthRequestContext = concurrentHashMap;
            this.BuiltInFictitiousFunctionClassFactory = j;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            Node NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                return false;
            }
            consumer.accept(new MapEntry(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext));
            return true;
        }

        @Override // j$.util.Spliterator
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator moveToNextValue() {
            int i = this.scheduleImpl;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.GetContactSyncConfig;
            int i4 = this.getErrorConfigVersion;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
            long j = this.BuiltInFictitiousFunctionClassFactory >>> 1;
            this.BuiltInFictitiousFunctionClassFactory = j;
            return new EntrySpliterator(nodeArr, i4, i3, i2, j, this.getAuthRequestContext);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return;
                }
                consumer.accept(new MapEntry(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ForwardingNode extends Node {
        final Node[] PlaceComponentResult;

        ForwardingNode(Node[] nodeArr) {
            super(-1, null, null, null);
            this.PlaceComponentResult = nodeArr;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        final Node MyBillsEntityDataFactory(int i, Object obj) {
            Node tabAt;
            Object obj2;
            Node[] nodeArr = this.PlaceComponentResult;
            while (obj != null && nodeArr != null) {
                int length = nodeArr.length;
                if (length == 0 || (tabAt = ConcurrentHashMap.tabAt(nodeArr, (length - 1) & i)) == null) {
                    return null;
                }
                do {
                    int i2 = tabAt.getAuthRequestContext;
                    if (i2 == i && ((obj2 = tabAt.KClassImpl$Data$declaredNonStaticMembers$2) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return tabAt;
                    }
                    if (i2 >= 0) {
                        tabAt = tabAt.MyBillsEntityDataFactory;
                    } else if (!(tabAt instanceof ForwardingNode)) {
                        return tabAt.MyBillsEntityDataFactory(i, obj);
                    } else {
                        nodeArr = ((ForwardingNode) tabAt).PlaceComponentResult;
                    }
                } while (tabAt != null);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class KeyIterator extends BaseIterator implements java.util.Iterator, Enumeration, j$.util.Iterator {
        public final /* synthetic */ int MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ KeyIterator(Node[] nodeArr, int i, int i2, ConcurrentHashMap concurrentHashMap, int i3) {
            super(nodeArr, i, i2, concurrentHashMap);
            this.MyBillsEntityDataFactory = i3;
        }

        @Override // j$.util.Iterator
        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            int i = this.MyBillsEntityDataFactory;
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            int i = this.MyBillsEntityDataFactory;
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Iterator
        public final Object next() {
            Node node;
            Object obj;
            if (this.MyBillsEntityDataFactory != 0) {
                node = this.lookAheadTest;
                if (node == null) {
                    throw new NoSuchElementException();
                }
                obj = node.BuiltInFictitiousFunctionClassFactory;
            } else {
                node = this.lookAheadTest;
                if (node == null) {
                    throw new NoSuchElementException();
                }
                obj = node.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            this.BuiltInFictitiousFunctionClassFactory = node;
            NetworkUserEntityData$$ExternalSyntheticLambda0();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return this.MyBillsEntityDataFactory != 0 ? next() : next();
        }
    }

    /* loaded from: classes.dex */
    public final class KeySetView extends CollectionView implements Set, j$.util.Collection {
        private static final long serialVersionUID = 7249069246763182397L;

        KeySetView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            Node[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return;
                }
                consumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        @Override // java.lang.Iterable
        public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            java.util.Iterator it = iterator();
            int i = 0;
            while (((BaseIterator) it).hasNext()) {
                i += ((KeyIterator) it).next().hashCode();
            }
            return i;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, length, concurrentHashMap, 0);
        }

        @Override // java.util.Collection, j$.util.Collection
        public final /* synthetic */ Stream parallelStream() {
            return Collection.CC.MyBillsEntityDataFactory(this);
        }

        @Override // java.util.Collection
        public final /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.MyBillsEntityDataFactory(Collection.CC.MyBillsEntityDataFactory(this));
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        @Override // j$.util.Collection
        public final /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
        }

        @Override // java.util.Collection
        public final /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Collection, java.util.List, j$.util.List
        public final Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long sumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeySpliterator(nodeArr, length, 0, length, sumCount < 0 ? 0L : sumCount, 0);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public final /* synthetic */ Stream stream() {
            return Collection.CC.PlaceComponentResult(this);
        }

        @Override // java.util.Collection
        public final /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.MyBillsEntityDataFactory(Collection.CC.PlaceComponentResult(this));
        }

        @Override // java.util.Collection
        public final /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return Collection.CC.MyBillsEntityDataFactory(this, IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class KeySpliterator extends Traverser implements Spliterator {
        public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
        long getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ KeySpliterator(Node[] nodeArr, int i, int i2, int i3, long j, int i4) {
            super(nodeArr, i, i2, i3);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
            this.getAuthRequestContext = j;
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? 4352 : 4353;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? this.getAuthRequestContext : this.getAuthRequestContext;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return false;
                }
                consumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory);
                return true;
            }
            Node NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda02 == null) {
                return false;
            }
            consumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda02.KClassImpl$Data$declaredNonStaticMembers$2);
            return true;
        }

        @Override // j$.util.Spliterator
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator moveToNextValue() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                int i = this.scheduleImpl;
                int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i3 = (i + i2) >>> 1;
                if (i3 <= i) {
                    return null;
                }
                Node[] nodeArr = this.GetContactSyncConfig;
                int i4 = this.getErrorConfigVersion;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
                long j = this.getAuthRequestContext >>> 1;
                this.getAuthRequestContext = j;
                return new KeySpliterator(nodeArr, i4, i3, i2, j, 1);
            }
            int i5 = this.scheduleImpl;
            int i6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i7 = (i5 + i6) >>> 1;
            if (i7 > i5) {
                Node[] nodeArr2 = this.GetContactSyncConfig;
                int i8 = this.getErrorConfigVersion;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i7;
                long j2 = this.getAuthRequestContext >>> 1;
                this.getAuthRequestContext = j2;
                return new KeySpliterator(nodeArr2, i8, i7, i6, j2, 0);
            }
            return null;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 != 0 ? Objects.getAuthRequestContext(this) : Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                while (true) {
                    Node NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                        return;
                    }
                    consumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory);
                }
            } else {
                while (true) {
                    Node NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda02 == null) {
                        return;
                    }
                    consumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda02.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class MapEntry implements Map.Entry {
        Object BuiltInFictitiousFunctionClassFactory;
        final Object MyBillsEntityDataFactory;
        final ConcurrentHashMap PlaceComponentResult;

        MapEntry(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
            this.MyBillsEntityDataFactory = obj;
            this.BuiltInFictitiousFunctionClassFactory = obj2;
            this.PlaceComponentResult = concurrentHashMap;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.MyBillsEntityDataFactory) || key.equals(obj2)) && (value == (obj3 = this.BuiltInFictitiousFunctionClassFactory) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode() ^ this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object obj2 = this.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = obj;
            this.PlaceComponentResult.put(this.MyBillsEntityDataFactory, obj);
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.MyBillsEntityDataFactory);
            sb.append("=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Node implements Map.Entry {
        volatile Object BuiltInFictitiousFunctionClassFactory;
        final Object KClassImpl$Data$declaredNonStaticMembers$2;
        volatile Node MyBillsEntityDataFactory;
        final int getAuthRequestContext;

        Node(int i, Object obj, Object obj2, Node node) {
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
            this.BuiltInFictitiousFunctionClassFactory = obj2;
            this.MyBillsEntityDataFactory = node;
        }

        Node MyBillsEntityDataFactory(int i, Object obj) {
            Object obj2;
            if (obj != null) {
                Node node = this;
                do {
                    if (node.getAuthRequestContext == i && ((obj2 = node.KClassImpl$Data$declaredNonStaticMembers$2) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return node;
                    }
                    node = node.MyBillsEntityDataFactory;
                } while (node != null);
                return null;
            }
            return null;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.KClassImpl$Data$declaredNonStaticMembers$2) || key.equals(obj2)) && (value == (obj3 = this.BuiltInFictitiousFunctionClassFactory) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() ^ this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ReservationNode extends Node {
        ReservationNode() {
            super(-3, null, null, null);
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        final Node MyBillsEntityDataFactory(int i, Object obj) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    final class Segment extends ReentrantLock {
        private static final long serialVersionUID = 2249069246763182397L;

        Segment() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class TableStack {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        Node[] MyBillsEntityDataFactory;
        TableStack PlaceComponentResult;

        TableStack() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Traverser {
        TableStack DatabaseTableConfigUtil;
        Node[] GetContactSyncConfig;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        TableStack NetworkUserEntityData$$ExternalSyntheticLambda1;
        final int getErrorConfigVersion;
        Node lookAheadTest = null;
        int moveToNextValue;
        int scheduleImpl;

        Traverser(Node[] nodeArr, int i, int i2, int i3) {
            this.GetContactSyncConfig = nodeArr;
            this.getErrorConfigVersion = i;
            this.moveToNextValue = i2;
            this.scheduleImpl = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
        }

        final Node NetworkUserEntityData$$ExternalSyntheticLambda0() {
            Node[] nodeArr;
            int length;
            int i;
            TableStack tableStack;
            Node node = this.lookAheadTest;
            if (node != null) {
                node = node.MyBillsEntityDataFactory;
            }
            while (node == null) {
                if (this.scheduleImpl >= this.NetworkUserEntityData$$ExternalSyntheticLambda0 || (nodeArr = this.GetContactSyncConfig) == null || (length = nodeArr.length) <= (i = this.moveToNextValue) || i < 0) {
                    this.lookAheadTest = null;
                    return null;
                }
                Node tabAt = ConcurrentHashMap.tabAt(nodeArr, i);
                if (tabAt == null || tabAt.getAuthRequestContext >= 0) {
                    node = tabAt;
                } else if (tabAt instanceof ForwardingNode) {
                    this.GetContactSyncConfig = ((ForwardingNode) tabAt).PlaceComponentResult;
                    TableStack tableStack2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (tableStack2 != null) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = tableStack2.PlaceComponentResult;
                    } else {
                        tableStack2 = new TableStack();
                    }
                    tableStack2.MyBillsEntityDataFactory = nodeArr;
                    tableStack2.KClassImpl$Data$declaredNonStaticMembers$2 = length;
                    tableStack2.BuiltInFictitiousFunctionClassFactory = i;
                    tableStack2.PlaceComponentResult = this.DatabaseTableConfigUtil;
                    this.DatabaseTableConfigUtil = tableStack2;
                    node = null;
                } else {
                    node = tabAt instanceof TreeBin ? ((TreeBin) tabAt).PlaceComponentResult : null;
                }
                if (this.DatabaseTableConfigUtil != null) {
                    while (true) {
                        tableStack = this.DatabaseTableConfigUtil;
                        if (tableStack == null) {
                            break;
                        }
                        int i2 = this.moveToNextValue;
                        int i3 = tableStack.KClassImpl$Data$declaredNonStaticMembers$2;
                        int i4 = i2 + i3;
                        this.moveToNextValue = i4;
                        if (i4 < length) {
                            break;
                        }
                        this.moveToNextValue = tableStack.BuiltInFictitiousFunctionClassFactory;
                        this.GetContactSyncConfig = tableStack.MyBillsEntityDataFactory;
                        tableStack.MyBillsEntityDataFactory = null;
                        TableStack tableStack3 = tableStack.PlaceComponentResult;
                        tableStack.PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        this.DatabaseTableConfigUtil = tableStack3;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = tableStack;
                        length = i3;
                    }
                    if (tableStack == null) {
                        int i5 = this.moveToNextValue + this.getErrorConfigVersion;
                        this.moveToNextValue = i5;
                        if (i5 >= length) {
                            int i6 = this.scheduleImpl + 1;
                            this.scheduleImpl = i6;
                            this.moveToNextValue = i6;
                        }
                    }
                } else {
                    int i7 = i + this.getErrorConfigVersion;
                    this.moveToNextValue = i7;
                    if (i7 >= length) {
                        int i62 = this.scheduleImpl + 1;
                        this.scheduleImpl = i62;
                        this.moveToNextValue = i62;
                    }
                }
            }
            this.lookAheadTest = node;
            return node;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class TreeNode extends Node {
        TreeNode PlaceComponentResult;
        boolean getErrorConfigVersion;
        TreeNode lookAheadTest;
        TreeNode moveToNextValue;
        TreeNode scheduleImpl;

        TreeNode(int i, Object obj, Object obj2, TreeNode treeNode, TreeNode treeNode2) {
            super(i, obj, obj2, treeNode);
            this.scheduleImpl = treeNode2;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        final Node MyBillsEntityDataFactory(int i, Object obj) {
            return MyBillsEntityDataFactory(i, obj, null);
        }

        final TreeNode MyBillsEntityDataFactory(int i, Object obj, Class cls) {
            int compareComparables;
            if (obj != null) {
                TreeNode treeNode = this;
                do {
                    TreeNode treeNode2 = treeNode.PlaceComponentResult;
                    TreeNode treeNode3 = treeNode.lookAheadTest;
                    int i2 = treeNode.getAuthRequestContext;
                    if (i2 <= i) {
                        if (i2 >= i) {
                            Object obj2 = treeNode.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                                return treeNode;
                            }
                            if (treeNode2 != null) {
                                if (treeNode3 != null) {
                                    if ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) {
                                        TreeNode MyBillsEntityDataFactory = treeNode3.MyBillsEntityDataFactory(i, obj, cls);
                                        if (MyBillsEntityDataFactory != null) {
                                            return MyBillsEntityDataFactory;
                                        }
                                    } else if (compareComparables >= 0) {
                                        treeNode2 = treeNode3;
                                    }
                                }
                            }
                        }
                        treeNode = treeNode3;
                    }
                    treeNode = treeNode2;
                } while (treeNode != null);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    final class ValuesView extends CollectionView implements j$.util.Collection {
        private static final long serialVersionUID = 2249069246763182397L;

        ValuesView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            Node[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return;
                }
                consumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory);
            }
        }

        @Override // java.lang.Iterable
        public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final java.util.Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, length, concurrentHashMap, 1);
        }

        @Override // java.util.Collection, j$.util.Collection
        public final /* synthetic */ Stream parallelStream() {
            return Collection.CC.MyBillsEntityDataFactory(this);
        }

        @Override // java.util.Collection
        public final /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.MyBillsEntityDataFactory(Collection.CC.MyBillsEntityDataFactory(this));
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            BaseIterator baseIterator;
            if (obj != null) {
                java.util.Iterator it = iterator();
                do {
                    baseIterator = (BaseIterator) it;
                    if (!baseIterator.hasNext()) {
                        return false;
                    }
                } while (!obj.equals(((KeyIterator) it).next()));
                baseIterator.remove();
                return true;
            }
            return false;
        }

        @Override // j$.util.Collection
        public final /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
        }

        @Override // java.util.Collection
        public final /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return Collection.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, Predicate.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection, java.util.List, j$.util.List
        public final Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long sumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeySpliterator(nodeArr, length, 0, length, sumCount < 0 ? 0L : sumCount, 1);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.BuiltInFictitiousFunctionClassFactory(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public final /* synthetic */ Stream stream() {
            return Collection.CC.PlaceComponentResult(this);
        }

        @Override // java.util.Collection
        public final /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.MyBillsEntityDataFactory(Collection.CC.PlaceComponentResult(this));
        }

        @Override // java.util.Collection
        public final /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return Collection.CC.MyBillsEntityDataFactory(this, IntFunction.VivifiedWrapper.MyBillsEntityDataFactory(intFunction));
        }
    }

    static {
        Unsafe unsafe;
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            unsafe = DesugarUnsafe.getAuthRequestContext;
            U = unsafe;
            SIZECTL = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            BASECOUNT = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            CELLSBUSY = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            CELLVALUE = unsafe.objectFieldOffset(CounterCell.class.getDeclaredField("PlaceComponentResult"));
            ABASE = unsafe.arrayBaseOffset(Node[].class);
            int arrayIndexScale = unsafe.arrayIndexScale(Node[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        double d = (i < i2 ? i2 : i) / f;
        Double.isNaN(d);
        long j = (long) (d + 1.0d);
        this.sizeCtl = j >= ConvertUtils.GB ? 1073741824 : tableSizeFor((int) j);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r1.compareAndSwapLong(r11, r3, r5, r9) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addCount(long r12, int r14) {
        /*
            r11 = this;
            j$.util.concurrent.ConcurrentHashMap$CounterCell[] r0 = r11.counterCells
            if (r0 != 0) goto L14
            sun.misc.Unsafe r1 = j$.util.concurrent.ConcurrentHashMap.U
            long r3 = j$.util.concurrent.ConcurrentHashMap.BASECOUNT
            long r5 = r11.baseCount
            long r9 = r5 + r12
            r2 = r11
            r7 = r9
            boolean r1 = r1.compareAndSwapLong(r2, r3, r5, r7)
            if (r1 != 0) goto L39
        L14:
            r1 = 1
            if (r0 == 0) goto L98
            int r2 = r0.length
            int r2 = r2 - r1
            if (r2 < 0) goto L98
            int r3 = j$.util.concurrent.ThreadLocalRandom.getProbe()
            r2 = r2 & r3
            r4 = r0[r2]
            if (r4 == 0) goto L98
            sun.misc.Unsafe r3 = j$.util.concurrent.ConcurrentHashMap.U
            long r5 = j$.util.concurrent.ConcurrentHashMap.CELLVALUE
            long r7 = r4.PlaceComponentResult
            long r9 = r7 + r12
            boolean r0 = r3.compareAndSwapLong(r4, r5, r7, r9)
            if (r0 == 0) goto L97
            if (r14 > r1) goto L35
            return
        L35:
            long r9 = r11.sumCount()
        L39:
            if (r14 < 0) goto L96
        L3b:
            int r4 = r11.sizeCtl
            long r12 = (long) r4
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L96
            j$.util.concurrent.ConcurrentHashMap$Node[] r12 = r11.table
            if (r12 == 0) goto L96
            int r13 = r12.length
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 >= r14) goto L96
            int r13 = java.lang.Integer.numberOfLeadingZeros(r13)
            r14 = 32768(0x8000, float:4.5918E-41)
            r13 = r13 | r14
            if (r4 >= 0) goto L7d
            int r14 = j$.util.concurrent.ConcurrentHashMap.RESIZE_STAMP_SHIFT
            int r14 = r4 >>> r14
            if (r14 != r13) goto L96
            int r14 = r13 + 1
            if (r4 == r14) goto L96
            int r14 = j$.util.concurrent.ConcurrentHashMap.MAX_RESIZERS
            int r13 = r13 + r14
            if (r4 == r13) goto L96
            j$.util.concurrent.ConcurrentHashMap$Node[] r13 = r11.nextTable
            if (r13 == 0) goto L96
            int r14 = r11.transferIndex
            if (r14 <= 0) goto L96
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.U
            long r2 = j$.util.concurrent.ConcurrentHashMap.SIZECTL
            int r5 = r4 + 1
            r1 = r11
            boolean r14 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r14 == 0) goto L91
            r11.transfer(r12, r13)
            goto L91
        L7d:
            sun.misc.Unsafe r0 = j$.util.concurrent.ConcurrentHashMap.U
            long r2 = j$.util.concurrent.ConcurrentHashMap.SIZECTL
            int r14 = j$.util.concurrent.ConcurrentHashMap.RESIZE_STAMP_SHIFT
            int r13 = r13 << r14
            int r5 = r13 + 2
            r1 = r11
            boolean r13 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r13 == 0) goto L91
            r13 = 0
            r11.transfer(r12, r13)
        L91:
            long r9 = r11.sumCount()
            goto L3b
        L96:
            return
        L97:
            r1 = r0
        L98:
            r11.fullAddCount(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    static final boolean casTabAt(Node[] nodeArr, int i, Node node) {
        return ConcurrentHashMap$$ExternalSyntheticBackportWithForwarding0.getAuthRequestContext(U, nodeArr, ABASE + (i << ASHIFT), node);
    }

    static Class comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (obj instanceof Comparable) {
            Class<?> cls = obj.getClass();
            if (cls == String.class) {
                return cls;
            }
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces != null) {
                for (Type type : genericInterfaces) {
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                            return cls;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    static int compareComparables(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0097, code lost:
    
        if (r24.counterCells != r7) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0099, code lost:
    
        r1 = new j$.util.concurrent.ConcurrentHashMap.CounterCell[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009e, code lost:
    
        if (r2 >= r8) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a7, code lost:
    
        r24.counterCells = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x005b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void fullAddCount(long r25, boolean r27) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.fullAddCount(long, boolean):void");
    }

    private final Node[] initTable() {
        while (true) {
            Node[] nodeArr = this.table;
            if (nodeArr != null && nodeArr.length != 0) {
                return nodeArr;
            }
            int i = this.sizeCtl;
            if (i < 0) {
                Thread.yield();
            } else if (U.compareAndSwapInt(this, SIZECTL, i, -1)) {
                try {
                    Node[] nodeArr2 = this.table;
                    if (nodeArr2 == null || nodeArr2.length == 0) {
                        int i2 = i > 0 ? i : 16;
                        Node[] nodeArr3 = new Node[i2];
                        this.table = nodeArr3;
                        i = i2 - (i2 >>> 2);
                        nodeArr2 = nodeArr3;
                    }
                    this.sizeCtl = i;
                    return nodeArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i;
                    throw th;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j;
        int tableSizeFor;
        boolean z;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j2 = 0;
        long j3 = 0;
        Node node = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j = 1;
            if (readObject == null || readObject2 == null) {
                break;
            }
            j3++;
            node = new Node(spread(readObject.hashCode()), readObject, readObject2, node);
        }
        if (j3 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j3 >= 536870912) {
            tableSizeFor = 1073741824;
        } else {
            int i = (int) j3;
            tableSizeFor = tableSizeFor(i + (i >>> 1) + 1);
        }
        Node[] nodeArr = new Node[tableSizeFor];
        while (node != null) {
            Node node2 = node.MyBillsEntityDataFactory;
            int i2 = node.getAuthRequestContext;
            int i3 = (tableSizeFor - 1) & i2;
            Node tabAt = tabAt(nodeArr, i3);
            if (tabAt == null) {
                z = true;
            } else {
                Object obj2 = node.KClassImpl$Data$declaredNonStaticMembers$2;
                if (tabAt.getAuthRequestContext >= 0) {
                    int i4 = 0;
                    for (Node node3 = tabAt; node3 != null; node3 = node3.MyBillsEntityDataFactory) {
                        if (node3.getAuthRequestContext == i2 && ((obj = node3.KClassImpl$Data$declaredNonStaticMembers$2) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        }
                        i4++;
                    }
                    z = true;
                    if (z && i4 >= 8) {
                        j2 += j;
                        node.MyBillsEntityDataFactory = tabAt;
                        Node node4 = node;
                        TreeNode treeNode = null;
                        TreeNode treeNode2 = null;
                        while (node4 != null) {
                            TreeNode treeNode3 = new TreeNode(node4.getAuthRequestContext, node4.KClassImpl$Data$declaredNonStaticMembers$2, node4.BuiltInFictitiousFunctionClassFactory, null, null);
                            treeNode3.moveToNextValue = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.MyBillsEntityDataFactory = treeNode3;
                            }
                            node4 = node4.MyBillsEntityDataFactory;
                            treeNode2 = treeNode3;
                        }
                        setTabAt(nodeArr, i3, new TreeBin(treeNode));
                    }
                } else if (((TreeBin) tabAt).MyBillsEntityDataFactory(i2, obj2, node.BuiltInFictitiousFunctionClassFactory) == null) {
                    j2 += j;
                }
                z = false;
            }
            if (z) {
                j2++;
                node.MyBillsEntityDataFactory = tabAt;
                setTabAt(nodeArr, i3, node);
            }
            j = 1;
            node = node2;
        }
        this.table = nodeArr;
        this.sizeCtl = tableSizeFor - (tableSizeFor >>> 2);
        this.baseCount = j2;
    }

    static final void setTabAt(Node[] nodeArr, int i, Node node) {
        U.putObjectVolatile(nodeArr, (i << ASHIFT) + ABASE, node);
    }

    static final int spread(int i) {
        return (i ^ (i >>> 16)) & Integer.MAX_VALUE;
    }

    static final Node tabAt(Node[] nodeArr, int i) {
        return (Node) U.getObjectVolatile(nodeArr, (i << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        if (i7 >= 1073741824) {
            return 1073741824;
        }
        return i7 + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15, types: [j$.util.concurrent.ConcurrentHashMap$Node] */
    /* JADX WARN: Type inference failed for: r15v17, types: [j$.util.concurrent.ConcurrentHashMap$Node] */
    /* JADX WARN: Type inference failed for: r5v17, types: [j$.util.concurrent.ConcurrentHashMap$Node] */
    /* JADX WARN: Type inference failed for: r5v22, types: [j$.util.concurrent.ConcurrentHashMap$Node] */
    private final void transfer(Node[] nodeArr, Node[] nodeArr2) {
        Node[] nodeArr3;
        ConcurrentHashMap<K, V> concurrentHashMap;
        Node[] nodeArr4;
        int i;
        int i2;
        ForwardingNode forwardingNode;
        ConcurrentHashMap<K, V> concurrentHashMap2;
        int i3;
        TreeNode treeNode;
        TreeNode treeNode2;
        ConcurrentHashMap<K, V> concurrentHashMap3 = this;
        int length = nodeArr.length;
        int i4 = NCPU;
        int i5 = i4 > 1 ? (length >>> 3) / i4 : length;
        int i6 = i5 < 16 ? 16 : i5;
        if (nodeArr2 == null) {
            try {
                Node[] nodeArr5 = new Node[length << 1];
                concurrentHashMap3.nextTable = nodeArr5;
                concurrentHashMap3.transferIndex = length;
                nodeArr3 = nodeArr5;
            } catch (Throwable unused) {
                concurrentHashMap3.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            nodeArr3 = nodeArr2;
        }
        int length2 = nodeArr3.length;
        ForwardingNode forwardingNode2 = new ForwardingNode(nodeArr3);
        Node[] nodeArr6 = nodeArr;
        ConcurrentHashMap<K, V> concurrentHashMap4 = concurrentHashMap3;
        int i7 = 0;
        int i8 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            if (z) {
                int i9 = i8 - 1;
                if (i9 >= i7 || z2) {
                    concurrentHashMap = concurrentHashMap4;
                    nodeArr4 = nodeArr6;
                    i7 = i7;
                    i8 = i9;
                } else {
                    int i10 = concurrentHashMap4.transferIndex;
                    if (i10 <= 0) {
                        concurrentHashMap = concurrentHashMap4;
                        nodeArr4 = nodeArr6;
                        i8 = -1;
                    } else {
                        Unsafe unsafe = U;
                        long j = TRANSFERINDEX;
                        int i11 = i10 > i6 ? i10 - i6 : 0;
                        concurrentHashMap = concurrentHashMap4;
                        nodeArr4 = nodeArr6;
                        int i12 = i7;
                        if (unsafe.compareAndSwapInt(this, j, i10, i11)) {
                            i8 = i10 - 1;
                            i7 = i11;
                        } else {
                            nodeArr6 = nodeArr4;
                            i7 = i12;
                            i8 = i9;
                            concurrentHashMap4 = concurrentHashMap;
                        }
                    }
                }
                nodeArr6 = nodeArr4;
                concurrentHashMap4 = concurrentHashMap;
                z = false;
            } else {
                ConcurrentHashMap<K, V> concurrentHashMap5 = concurrentHashMap4;
                Node[] nodeArr7 = nodeArr6;
                int i13 = i7;
                TreeNode treeNode3 = null;
                if (i8 < 0 || i8 >= length || (i3 = i8 + length) >= length2) {
                    i = i6;
                    i2 = length2;
                    forwardingNode = forwardingNode2;
                    if (z2) {
                        this.nextTable = null;
                        this.table = nodeArr3;
                        this.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    concurrentHashMap2 = this;
                    Unsafe unsafe2 = U;
                    long j2 = SIZECTL;
                    int i14 = concurrentHashMap2.sizeCtl;
                    int i15 = i8;
                    if (!unsafe2.compareAndSwapInt(this, j2, i14, i14 - 1)) {
                        concurrentHashMap4 = concurrentHashMap2;
                        nodeArr6 = nodeArr7;
                        i8 = i15;
                    } else if (i14 - 2 != ((Integer.numberOfLeadingZeros(length) | 32768) << RESIZE_STAMP_SHIFT)) {
                        return;
                    } else {
                        i8 = length;
                        concurrentHashMap4 = concurrentHashMap2;
                        nodeArr6 = nodeArr7;
                        z = true;
                        z2 = true;
                    }
                } else {
                    Node tabAt = tabAt(nodeArr7, i8);
                    if (tabAt == null) {
                        z = casTabAt(nodeArr7, i8, forwardingNode2);
                        concurrentHashMap2 = concurrentHashMap3;
                        i = i6;
                        i2 = length2;
                        forwardingNode = forwardingNode2;
                        nodeArr6 = nodeArr7;
                        concurrentHashMap4 = concurrentHashMap5;
                    } else {
                        int i16 = tabAt.getAuthRequestContext;
                        if (i16 == -1) {
                            concurrentHashMap2 = concurrentHashMap3;
                            i = i6;
                            i2 = length2;
                            forwardingNode = forwardingNode2;
                            nodeArr6 = nodeArr7;
                            concurrentHashMap4 = concurrentHashMap5;
                            z = true;
                        } else {
                            synchronized (tabAt) {
                                if (tabAt(nodeArr7, i8) == tabAt) {
                                    if (i16 >= 0) {
                                        int i17 = i16 & length;
                                        TreeNode treeNode4 = tabAt;
                                        for (TreeNode treeNode5 = tabAt.MyBillsEntityDataFactory; treeNode5 != null; treeNode5 = treeNode5.MyBillsEntityDataFactory) {
                                            int i18 = treeNode5.getAuthRequestContext & length;
                                            if (i18 != i17) {
                                                treeNode4 = treeNode5;
                                                i17 = i18;
                                            }
                                        }
                                        if (i17 == 0) {
                                            treeNode = null;
                                            treeNode3 = treeNode4;
                                        } else {
                                            treeNode = treeNode4;
                                        }
                                        Node node = tabAt;
                                        while (node != treeNode4) {
                                            int i19 = node.getAuthRequestContext;
                                            int i20 = i6;
                                            Object obj = node.KClassImpl$Data$declaredNonStaticMembers$2;
                                            int i21 = length2;
                                            Object obj2 = node.BuiltInFictitiousFunctionClassFactory;
                                            if ((i19 & length) == 0) {
                                                treeNode2 = treeNode4;
                                                treeNode3 = new Node(i19, obj, obj2, treeNode3);
                                            } else {
                                                treeNode2 = treeNode4;
                                                treeNode = new Node(i19, obj, obj2, treeNode);
                                            }
                                            node = node.MyBillsEntityDataFactory;
                                            i6 = i20;
                                            length2 = i21;
                                            treeNode4 = treeNode2;
                                        }
                                        i = i6;
                                        i2 = length2;
                                        setTabAt(nodeArr3, i8, treeNode3);
                                        setTabAt(nodeArr3, i3, treeNode);
                                        setTabAt(nodeArr7, i8, forwardingNode2);
                                        forwardingNode = forwardingNode2;
                                    } else {
                                        i = i6;
                                        i2 = length2;
                                        if (tabAt instanceof TreeBin) {
                                            TreeBin treeBin = (TreeBin) tabAt;
                                            TreeNode treeNode6 = null;
                                            TreeNode treeNode7 = null;
                                            Node node2 = treeBin.PlaceComponentResult;
                                            int i22 = 0;
                                            int i23 = 0;
                                            TreeNode treeNode8 = null;
                                            while (node2 != null) {
                                                TreeBin treeBin2 = treeBin;
                                                int i24 = node2.getAuthRequestContext;
                                                ForwardingNode forwardingNode3 = forwardingNode2;
                                                TreeNode treeNode9 = new TreeNode(i24, node2.KClassImpl$Data$declaredNonStaticMembers$2, node2.BuiltInFictitiousFunctionClassFactory, null, null);
                                                if ((i24 & length) == 0) {
                                                    treeNode9.moveToNextValue = treeNode7;
                                                    if (treeNode7 == null) {
                                                        treeNode3 = treeNode9;
                                                    } else {
                                                        treeNode7.MyBillsEntityDataFactory = treeNode9;
                                                    }
                                                    i22++;
                                                    treeNode7 = treeNode9;
                                                } else {
                                                    treeNode9.moveToNextValue = treeNode6;
                                                    if (treeNode6 == null) {
                                                        treeNode8 = treeNode9;
                                                    } else {
                                                        treeNode6.MyBillsEntityDataFactory = treeNode9;
                                                    }
                                                    i23++;
                                                    treeNode6 = treeNode9;
                                                }
                                                node2 = node2.MyBillsEntityDataFactory;
                                                treeBin = treeBin2;
                                                forwardingNode2 = forwardingNode3;
                                            }
                                            TreeBin treeBin3 = treeBin;
                                            ForwardingNode forwardingNode4 = forwardingNode2;
                                            Node untreeify = i22 <= 6 ? untreeify(treeNode3) : i23 != 0 ? new TreeBin(treeNode3) : treeBin3;
                                            Node untreeify2 = i23 <= 6 ? untreeify(treeNode8) : i22 != 0 ? new TreeBin(treeNode8) : treeBin3;
                                            setTabAt(nodeArr3, i8, untreeify);
                                            setTabAt(nodeArr3, i3, untreeify2);
                                            forwardingNode = forwardingNode4;
                                            setTabAt(nodeArr, i8, forwardingNode);
                                            nodeArr7 = nodeArr;
                                        }
                                    }
                                    z = true;
                                } else {
                                    i = i6;
                                    i2 = length2;
                                }
                                forwardingNode = forwardingNode2;
                            }
                            concurrentHashMap4 = this;
                            concurrentHashMap2 = concurrentHashMap4;
                            nodeArr6 = nodeArr7;
                        }
                    }
                }
                forwardingNode2 = forwardingNode;
                concurrentHashMap3 = concurrentHashMap2;
                i7 = i13;
                i6 = i;
                length2 = i2;
            }
        }
    }

    private final void treeifyBin(Node[] nodeArr, int i) {
        int length = nodeArr.length;
        if (length < 64) {
            tryPresize(length << 1);
            return;
        }
        Node tabAt = tabAt(nodeArr, i);
        if (tabAt == null || tabAt.getAuthRequestContext < 0) {
            return;
        }
        synchronized (tabAt) {
            if (tabAt(nodeArr, i) == tabAt) {
                TreeNode treeNode = null;
                Node node = tabAt;
                TreeNode treeNode2 = null;
                while (node != null) {
                    TreeNode treeNode3 = new TreeNode(node.getAuthRequestContext, node.KClassImpl$Data$declaredNonStaticMembers$2, node.BuiltInFictitiousFunctionClassFactory, null, null);
                    treeNode3.moveToNextValue = treeNode2;
                    if (treeNode2 == null) {
                        treeNode = treeNode3;
                    } else {
                        treeNode2.MyBillsEntityDataFactory = treeNode3;
                    }
                    node = node.MyBillsEntityDataFactory;
                    treeNode2 = treeNode3;
                }
                setTabAt(nodeArr, i, new TreeBin(treeNode));
            }
        }
    }

    private final void tryPresize(int i) {
        int length;
        Node[] nodeArr;
        int tableSizeFor = i >= 536870912 ? 1073741824 : tableSizeFor(i + (i >>> 1) + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                return;
            }
            Node[] nodeArr2 = this.table;
            if (nodeArr2 == null || (length = nodeArr2.length) == 0) {
                int i3 = i2 > tableSizeFor ? i2 : tableSizeFor;
                if (U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                    try {
                        if (this.table == nodeArr2) {
                            this.table = new Node[i3];
                            i2 = i3 - (i3 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i2;
                    }
                } else {
                    continue;
                }
            } else if (tableSizeFor <= i2 || length >= 1073741824) {
                return;
            } else {
                if (nodeArr2 == this.table) {
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(length) | 32768;
                    if (i2 < 0) {
                        if ((i2 >>> RESIZE_STAMP_SHIFT) != numberOfLeadingZeros || i2 == numberOfLeadingZeros + 1 || i2 == numberOfLeadingZeros + MAX_RESIZERS || (nodeArr = this.nextTable) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (U.compareAndSwapInt(this, SIZECTL, i2, i2 + 1)) {
                            transfer(nodeArr2, nodeArr);
                        }
                    } else if (U.compareAndSwapInt(this, SIZECTL, i2, (numberOfLeadingZeros << RESIZE_STAMP_SHIFT) + 2)) {
                        transfer(nodeArr2, null);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [j$.util.concurrent.ConcurrentHashMap$Node] */
    static Node untreeify(TreeNode treeNode) {
        Node node = null;
        Node node2 = null;
        for (TreeNode treeNode2 = treeNode; treeNode2 != null; treeNode2 = treeNode2.MyBillsEntityDataFactory) {
            Node node3 = new Node(treeNode2.getAuthRequestContext, treeNode2.KClassImpl$Data$declaredNonStaticMembers$2, treeNode2.BuiltInFictitiousFunctionClassFactory, null);
            if (node2 == null) {
                node = node3;
            } else {
                node2.MyBillsEntityDataFactory = node3;
            }
            node2 = node3;
        }
        return node;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Segment[] segmentArr = new Segment[16];
        for (int i = 0; i < 16; i++) {
            segmentArr[i] = new Segment();
        }
        objectOutputStream.putFields().put("segments", segmentArr);
        objectOutputStream.putFields().put("segmentShift", 28);
        objectOutputStream.putFields().put("segmentMask", 15);
        objectOutputStream.writeFields();
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    break;
                }
                objectOutputStream.writeObject(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                objectOutputStream.writeObject(NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Node tabAt;
        Node[] nodeArr = this.table;
        long j = 0;
        loop0: while (true) {
            int i = 0;
            while (nodeArr != null && i < nodeArr.length) {
                tabAt = tabAt(nodeArr, i);
                if (tabAt == null) {
                    i++;
                } else {
                    int i2 = tabAt.getAuthRequestContext;
                    if (i2 == -1) {
                        break;
                    }
                    synchronized (tabAt) {
                        if (tabAt(nodeArr, i) == tabAt) {
                            for (Node node = i2 >= 0 ? tabAt : tabAt instanceof TreeBin ? ((TreeBin) tabAt).PlaceComponentResult : null; node != null; node = node.MyBillsEntityDataFactory) {
                                j--;
                            }
                            setTabAt(nodeArr, i, null);
                            i++;
                        }
                    }
                }
            }
            nodeArr = helpTransfer(nodeArr, tabAt);
        }
        if (j != 0) {
            addCount(j, -1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
    
        r8 = r15.apply(r14, r4.BuiltInFictitiousFunctionClassFactory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007c, code lost:
    
        if (r8 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007e, code lost:
    
        r4.BuiltInFictitiousFunctionClassFactory = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0081, code lost:
    
        r3 = r4.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
    
        if (r9 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
    
        r9.MyBillsEntityDataFactory = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0088, code lost:
    
        setTabAt(r2, r6, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
    
        r3 = -1;
     */
    @Override // j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object compute(java.lang.Object r14, j$.util.function.BiFunction r15) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.compute(java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        TreeNode MyBillsEntityDataFactory;
        Object obj2;
        Object obj3;
        if (obj != null) {
            if (function != null) {
                int spread = spread(obj.hashCode());
                Node[] nodeArr = this.table;
                Object obj4 = null;
                int i = 0;
                while (true) {
                    if (nodeArr != null) {
                        int length = nodeArr.length;
                        if (length != 0) {
                            int i2 = (length - 1) & spread;
                            Node tabAt = tabAt(nodeArr, i2);
                            boolean z = true;
                            if (tabAt == null) {
                                ReservationNode reservationNode = new ReservationNode();
                                synchronized (reservationNode) {
                                    if (casTabAt(nodeArr, i2, reservationNode)) {
                                        try {
                                            Object apply = function.apply(obj);
                                            setTabAt(nodeArr, i2, apply != null ? new Node(spread, obj, apply, null) : null);
                                            obj4 = apply;
                                            i = 1;
                                        } catch (Throwable th) {
                                            setTabAt(nodeArr, i2, null);
                                            throw th;
                                        }
                                    }
                                }
                                if (i != 0) {
                                    break;
                                }
                            } else {
                                int i3 = tabAt.getAuthRequestContext;
                                if (i3 == -1) {
                                    nodeArr = helpTransfer(nodeArr, tabAt);
                                } else {
                                    synchronized (tabAt) {
                                        int i4 = 2;
                                        if (tabAt(nodeArr, i2) == tabAt) {
                                            if (i3 >= 0) {
                                                Node node = tabAt;
                                                i4 = 1;
                                                while (true) {
                                                    if (node.getAuthRequestContext != spread || ((obj3 = node.KClassImpl$Data$declaredNonStaticMembers$2) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                        Node node2 = node.MyBillsEntityDataFactory;
                                                        if (node2 == null) {
                                                            obj4 = function.apply(obj);
                                                            if (obj4 != null) {
                                                                node.MyBillsEntityDataFactory = new Node(spread, obj, obj4, null);
                                                            } else {
                                                                obj2 = obj4;
                                                            }
                                                        } else {
                                                            i4++;
                                                            node = node2;
                                                        }
                                                    }
                                                }
                                                obj2 = node.BuiltInFictitiousFunctionClassFactory;
                                                obj4 = obj2;
                                                z = false;
                                            } else if (tabAt instanceof TreeBin) {
                                                TreeBin treeBin = (TreeBin) tabAt;
                                                TreeNode treeNode = treeBin.lookAheadTest;
                                                if (treeNode == null || (MyBillsEntityDataFactory = treeNode.MyBillsEntityDataFactory(spread, obj, null)) == null) {
                                                    obj4 = function.apply(obj);
                                                    if (obj4 != null) {
                                                        treeBin.MyBillsEntityDataFactory(spread, obj, obj4);
                                                    }
                                                } else {
                                                    obj4 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                                                }
                                                i = 2;
                                            }
                                            i = i4;
                                        }
                                        z = false;
                                    }
                                    if (i != 0) {
                                        if (i >= 8) {
                                            treeifyBin(nodeArr, i2);
                                        }
                                        if (!z) {
                                            return obj4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    nodeArr = initTable();
                }
                if (obj4 != null) {
                    addCount(1L, i);
                }
                return obj4;
            }
            throw null;
        }
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        r5 = r15.apply(r14, r3.BuiltInFictitiousFunctionClassFactory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r5 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        r3.BuiltInFictitiousFunctionClassFactory = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        r3 = r3.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        if (r8 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        r8.MyBillsEntityDataFactory = r3;
     */
    @Override // j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object computeIfPresent(java.lang.Object r14, j$.util.function.BiFunction r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto Laa
            if (r15 == 0) goto Laa
            int r1 = r14.hashCode()
            int r1 = spread(r1)
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r13.table
            r3 = 0
            r5 = r0
            r4 = 0
        L12:
            if (r2 == 0) goto La4
            int r6 = r2.length
            if (r6 == 0) goto La4
            int r6 = r6 + (-1)
            r6 = r6 & r1
            j$.util.concurrent.ConcurrentHashMap$Node r7 = tabAt(r2, r6)
            if (r7 != 0) goto L22
            goto L9a
        L22:
            int r8 = r7.getAuthRequestContext
            r9 = -1
            if (r8 != r9) goto L2c
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r13.helpTransfer(r2, r7)
            goto L12
        L2c:
            monitor-enter(r7)
            j$.util.concurrent.ConcurrentHashMap$Node r10 = tabAt(r2, r6)     // Catch: java.lang.Throwable -> La1
            r11 = 2
            if (r10 != r7) goto L97
            if (r8 < 0) goto L68
            r3 = 1
            r8 = r0
            r3 = r7
            r11 = 1
        L3a:
            int r10 = r3.getAuthRequestContext     // Catch: java.lang.Throwable -> La1
            if (r10 != r1) goto L5c
            java.lang.Object r10 = r3.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> La1
            if (r10 == r14) goto L4a
            if (r10 == 0) goto L5c
            boolean r10 = r14.equals(r10)     // Catch: java.lang.Throwable -> La1
            if (r10 == 0) goto L5c
        L4a:
            java.lang.Object r5 = r3.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> La1
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> La1
            if (r5 == 0) goto L55
            r3.BuiltInFictitiousFunctionClassFactory = r5     // Catch: java.lang.Throwable -> La1
            goto L60
        L55:
            j$.util.concurrent.ConcurrentHashMap$Node r3 = r3.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto L90
            r8.MyBillsEntityDataFactory = r3     // Catch: java.lang.Throwable -> La1
            goto L93
        L5c:
            j$.util.concurrent.ConcurrentHashMap$Node r8 = r3.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> La1
            if (r8 != 0) goto L62
        L60:
            r3 = r11
            goto L97
        L62:
            int r11 = r11 + 1
            r12 = r8
            r8 = r3
            r3 = r12
            goto L3a
        L68:
            boolean r8 = r7 instanceof j$.util.concurrent.ConcurrentHashMap.TreeBin
            if (r8 == 0) goto L97
            r3 = r7
            j$.util.concurrent.ConcurrentHashMap$TreeBin r3 = (j$.util.concurrent.ConcurrentHashMap.TreeBin) r3     // Catch: java.lang.Throwable -> La1
            j$.util.concurrent.ConcurrentHashMap$TreeNode r8 = r3.lookAheadTest     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto L96
            j$.util.concurrent.ConcurrentHashMap$TreeNode r8 = r8.MyBillsEntityDataFactory(r1, r14, r0)     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto L96
            java.lang.Object r5 = r8.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> La1
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> La1
            if (r5 == 0) goto L84
            r8.BuiltInFictitiousFunctionClassFactory = r5     // Catch: java.lang.Throwable -> La1
            goto L96
        L84:
            boolean r4 = r3.MyBillsEntityDataFactory(r8)     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L93
            j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r3.PlaceComponentResult     // Catch: java.lang.Throwable -> La1
            j$.util.concurrent.ConcurrentHashMap$Node r3 = untreeify(r3)     // Catch: java.lang.Throwable -> La1
        L90:
            setTabAt(r2, r6, r3)     // Catch: java.lang.Throwable -> La1
        L93:
            r3 = r11
            r4 = -1
            goto L97
        L96:
            r3 = 2
        L97:
            monitor-exit(r7)
            if (r3 == 0) goto L12
        L9a:
            if (r4 == 0) goto La0
            long r14 = (long) r4
            r13.addCount(r14, r3)
        La0:
            return r5
        La1:
            r14 = move-exception
            monitor-exit(r7)
            throw r14
        La4:
            j$.util.concurrent.ConcurrentHashMap$Node[] r2 = r13.initTable()
            goto L12
        Laa:
            goto Lac
        Lab:
            throw r0
        Lac:
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    break;
                }
                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView entrySetView = this.entrySet;
        if (entrySetView == null) {
            EntrySetView entrySetView2 = new EntrySetView(this);
            this.entrySet = entrySetView2;
            return entrySetView2;
        }
        return entrySetView;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        V value;
        V v;
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                Node[] nodeArr = this.table;
                int length = nodeArr == null ? 0 : nodeArr.length;
                Traverser traverser = new Traverser(nodeArr, length, 0, length);
                while (true) {
                    Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                        for (Map.Entry<K, V> entry : map.entrySet()) {
                            K key = entry.getKey();
                            if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                                return false;
                            }
                        }
                        return true;
                    }
                    Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
                    Object obj3 = map.get(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                        break;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        Node[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                return;
            }
            biConsumer.accept(NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.getAuthRequestContext(biConsumer));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
    
        return (V) r1.BuiltInFictitiousFunctionClassFactory;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            int r0 = spread(r0)
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = r4.table
            r2 = 0
            if (r1 == 0) goto L4e
            int r3 = r1.length
            if (r3 <= 0) goto L4e
            int r3 = r3 + (-1)
            r3 = r3 & r0
            j$.util.concurrent.ConcurrentHashMap$Node r1 = tabAt(r1, r3)
            if (r1 == 0) goto L4e
            int r3 = r1.getAuthRequestContext
            if (r3 != r0) goto L2c
            java.lang.Object r3 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            if (r3 == r5) goto L29
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L29:
            java.lang.Object r5 = r1.BuiltInFictitiousFunctionClassFactory
            return r5
        L2c:
            if (r3 >= 0) goto L37
            j$.util.concurrent.ConcurrentHashMap$Node r5 = r1.MyBillsEntityDataFactory(r0, r5)
            if (r5 == 0) goto L36
            java.lang.Object r2 = r5.BuiltInFictitiousFunctionClassFactory
        L36:
            return r2
        L37:
            j$.util.concurrent.ConcurrentHashMap$Node r1 = r1.MyBillsEntityDataFactory
            if (r1 == 0) goto L4e
            int r3 = r1.getAuthRequestContext
            if (r3 != r0) goto L37
            java.lang.Object r3 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            if (r3 == r5) goto L4b
            if (r3 == 0) goto L37
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L37
        L4b:
            java.lang.Object r5 = r1.BuiltInFictitiousFunctionClassFactory
            return r5
        L4e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        V v = get(obj);
        return v != null ? v : obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Node[] nodeArr = this.table;
        int i = 0;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    break;
                }
                i += NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory.hashCode() ^ NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            }
        }
        return i;
    }

    final Node[] helpTransfer(Node[] nodeArr, Node node) {
        Node[] nodeArr2;
        int i;
        if (!(node instanceof ForwardingNode) || (nodeArr2 = ((ForwardingNode) node).PlaceComponentResult) == null) {
            return this.table;
        }
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(nodeArr.length) | 32768;
        while (true) {
            if (nodeArr2 != this.nextTable || this.table != nodeArr || (i = this.sizeCtl) >= 0 || (i >>> RESIZE_STAMP_SHIFT) != numberOfLeadingZeros || i == numberOfLeadingZeros + 1 || i == MAX_RESIZERS + numberOfLeadingZeros || this.transferIndex <= 0) {
                break;
            } else if (U.compareAndSwapInt(this, SIZECTL, i, i + 1)) {
                transfer(nodeArr, nodeArr2);
                break;
            }
        }
        return nodeArr2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        KeySetView keySetView = this.keySet;
        if (keySetView == null) {
            KeySetView keySetView2 = new KeySetView(this);
            this.keySet = keySetView2;
            return keySetView2;
        }
        return keySetView;
    }

    @Override // j$.util.Map
    public final Object merge(Object obj, Object obj2, j$.util.function.BiFunction biFunction) {
        int i;
        Object obj3;
        Object obj4 = obj2;
        if (obj != null) {
            if (obj4 != null) {
                if (biFunction != null) {
                    int spread = spread(obj.hashCode());
                    Node[] nodeArr = this.table;
                    int i2 = 0;
                    Object obj5 = null;
                    int i3 = 0;
                    while (true) {
                        if (nodeArr != null) {
                            int length = nodeArr.length;
                            if (length != 0) {
                                int i4 = (length - 1) & spread;
                                Node tabAt = tabAt(nodeArr, i4);
                                i = 1;
                                if (tabAt != null) {
                                    int i5 = tabAt.getAuthRequestContext;
                                    if (i5 == -1) {
                                        nodeArr = helpTransfer(nodeArr, tabAt);
                                    } else {
                                        synchronized (tabAt) {
                                            if (tabAt(nodeArr, i4) == tabAt) {
                                                if (i5 >= 0) {
                                                    Node node = null;
                                                    Node node2 = tabAt;
                                                    int i6 = 1;
                                                    while (true) {
                                                        if (node2.getAuthRequestContext != spread || ((obj3 = node2.KClassImpl$Data$declaredNonStaticMembers$2) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                            Node node3 = node2.MyBillsEntityDataFactory;
                                                            if (node3 == null) {
                                                                node2.MyBillsEntityDataFactory = new Node(spread, obj, obj4, null);
                                                                i2 = i6;
                                                                i3 = 1;
                                                                obj5 = obj4;
                                                                break;
                                                            }
                                                            i6++;
                                                            node = node2;
                                                            node2 = node3;
                                                        }
                                                    }
                                                    Object apply = biFunction.apply(node2.BuiltInFictitiousFunctionClassFactory, obj4);
                                                    if (apply != null) {
                                                        node2.BuiltInFictitiousFunctionClassFactory = apply;
                                                        i2 = i6;
                                                        obj5 = apply;
                                                    } else {
                                                        Node node4 = node2.MyBillsEntityDataFactory;
                                                        if (node != null) {
                                                            node.MyBillsEntityDataFactory = node4;
                                                        } else {
                                                            setTabAt(nodeArr, i4, node4);
                                                        }
                                                        i2 = i6;
                                                        obj5 = apply;
                                                        i3 = -1;
                                                    }
                                                } else if (tabAt instanceof TreeBin) {
                                                    i2 = 2;
                                                    TreeBin treeBin = (TreeBin) tabAt;
                                                    TreeNode treeNode = treeBin.lookAheadTest;
                                                    TreeNode MyBillsEntityDataFactory = treeNode == null ? null : treeNode.MyBillsEntityDataFactory(spread, obj, null);
                                                    Object apply2 = MyBillsEntityDataFactory == null ? obj4 : biFunction.apply(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, obj4);
                                                    if (apply2 != null) {
                                                        if (MyBillsEntityDataFactory != null) {
                                                            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = apply2;
                                                        } else {
                                                            treeBin.MyBillsEntityDataFactory(spread, obj, apply2);
                                                            obj5 = apply2;
                                                            i3 = 1;
                                                        }
                                                    } else if (MyBillsEntityDataFactory != null) {
                                                        if (treeBin.MyBillsEntityDataFactory(MyBillsEntityDataFactory)) {
                                                            setTabAt(nodeArr, i4, untreeify(treeBin.PlaceComponentResult));
                                                        }
                                                        obj5 = apply2;
                                                        i3 = -1;
                                                    }
                                                    obj5 = apply2;
                                                }
                                            }
                                        }
                                        if (i2 != 0) {
                                            if (i2 >= 8) {
                                                treeifyBin(nodeArr, i4);
                                            }
                                            i = i3;
                                            obj4 = obj5;
                                        }
                                    }
                                } else if (casTabAt(nodeArr, i4, new Node(spread, obj, obj4, null))) {
                                    break;
                                }
                            }
                        }
                        nodeArr = initTable();
                    }
                    if (i != 0) {
                        addCount(i, i2);
                    }
                    return obj4;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return (V) putVal(k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        tryPresize(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k, V v) {
        return (V) putVal(k, v, true);
    }

    final Object putVal(Object obj, Object obj2, boolean z) {
        Object obj3;
        TreeNode MyBillsEntityDataFactory;
        Object obj4;
        if (obj != null) {
            if (obj2 != null) {
                int spread = spread(obj.hashCode());
                int i = 0;
                Node[] nodeArr = this.table;
                while (true) {
                    if (nodeArr != null) {
                        int length = nodeArr.length;
                        if (length != 0) {
                            int i2 = (length - 1) & spread;
                            Node tabAt = tabAt(nodeArr, i2);
                            if (tabAt != null) {
                                int i3 = tabAt.getAuthRequestContext;
                                if (i3 == -1) {
                                    nodeArr = helpTransfer(nodeArr, tabAt);
                                } else {
                                    synchronized (tabAt) {
                                        int i4 = 2;
                                        if (tabAt(nodeArr, i2) == tabAt) {
                                            if (i3 >= 0) {
                                                i = 1;
                                                MyBillsEntityDataFactory = tabAt;
                                                while (true) {
                                                    if (MyBillsEntityDataFactory.getAuthRequestContext != spread || ((obj4 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) != obj && (obj4 == null || !obj.equals(obj4)))) {
                                                        Node node = MyBillsEntityDataFactory.MyBillsEntityDataFactory;
                                                        if (node == null) {
                                                            MyBillsEntityDataFactory.MyBillsEntityDataFactory = new Node(spread, obj, obj2, null);
                                                            break;
                                                        }
                                                        i++;
                                                        MyBillsEntityDataFactory = node;
                                                    }
                                                }
                                                obj3 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                                                if (!z) {
                                                    i4 = i;
                                                    MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = obj2;
                                                    i = i4;
                                                }
                                            } else if (tabAt instanceof TreeBin) {
                                                MyBillsEntityDataFactory = ((TreeBin) tabAt).MyBillsEntityDataFactory(spread, obj, obj2);
                                                if (MyBillsEntityDataFactory != null) {
                                                    obj3 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                                                    if (z) {
                                                        i = 2;
                                                    }
                                                    MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = obj2;
                                                    i = i4;
                                                } else {
                                                    i = 2;
                                                }
                                            }
                                        }
                                        obj3 = null;
                                    }
                                    if (i != 0) {
                                        if (i >= 8) {
                                            treeifyBin(nodeArr, i2);
                                        }
                                        if (obj3 != null) {
                                            return obj3;
                                        }
                                    }
                                }
                            } else if (casTabAt(nodeArr, i2, new Node(spread, obj, obj2, null))) {
                                break;
                            }
                        }
                    }
                    nodeArr = initTable();
                }
                addCount(1L, i);
                return null;
            }
            throw null;
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) replaceNode(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                return replaceNode(obj, obj2, null);
            }
            throw null;
        }
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(K k, V v, V v2) {
        if (k == null || v == null || v2 == null) {
            throw null;
        }
        return replaceNode(k, v2, v) != null;
    }

    @Override // j$.util.Map
    public final void replaceAll(j$.util.function.BiFunction biFunction) {
        Node[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                return;
            }
            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
            Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
            while (replaceNode(obj2, biFunction.apply(obj2, obj), obj) == null && (obj = get(obj2)) != null) {
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.getAuthRequestContext(biFunction));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        r8 = r5.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r14 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        if (r14 == r8) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        if (r8 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        if (r14.equals(r8) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        if (r13 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        r5.BuiltInFictitiousFunctionClassFactory = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
    
        if (r7 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
    
        r7.MyBillsEntityDataFactory = r5.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
    
        r5 = r5.MyBillsEntityDataFactory;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.Object replaceNode(java.lang.Object r12, java.lang.Object r13, java.lang.Object r14) {
        /*
            r11 = this;
            int r0 = r12.hashCode()
            int r0 = spread(r0)
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = r11.table
        La:
            r2 = 0
            if (r1 == 0) goto Lac
            int r3 = r1.length
            if (r3 == 0) goto Lac
            int r3 = r3 + (-1)
            r3 = r3 & r0
            j$.util.concurrent.ConcurrentHashMap$Node r4 = tabAt(r1, r3)
            if (r4 == 0) goto Lac
            int r5 = r4.getAuthRequestContext
            r6 = -1
            if (r5 != r6) goto L23
            j$.util.concurrent.ConcurrentHashMap$Node[] r1 = r11.helpTransfer(r1, r4)
            goto La
        L23:
            r7 = 0
            monitor-enter(r4)
            j$.util.concurrent.ConcurrentHashMap$Node r8 = tabAt(r1, r3)     // Catch: java.lang.Throwable -> La9
            if (r8 != r4) goto L9b
            if (r5 < 0) goto L64
            r7 = r2
            r5 = r4
        L2f:
            int r8 = r5.getAuthRequestContext     // Catch: java.lang.Throwable -> La9
            if (r8 != r0) goto L5c
            java.lang.Object r8 = r5.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> La9
            if (r8 == r12) goto L3f
            if (r8 == 0) goto L5c
            boolean r8 = r12.equals(r8)     // Catch: java.lang.Throwable -> La9
            if (r8 == 0) goto L5c
        L3f:
            java.lang.Object r8 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> La9
            if (r14 == 0) goto L4d
            if (r14 == r8) goto L4d
            if (r8 == 0) goto L98
            boolean r9 = r14.equals(r8)     // Catch: java.lang.Throwable -> La9
            if (r9 == 0) goto L98
        L4d:
            if (r13 == 0) goto L52
            r5.BuiltInFictitiousFunctionClassFactory = r13     // Catch: java.lang.Throwable -> La9
            goto L99
        L52:
            if (r7 == 0) goto L59
            j$.util.concurrent.ConcurrentHashMap$Node r3 = r5.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> La9
            r7.MyBillsEntityDataFactory = r3     // Catch: java.lang.Throwable -> La9
            goto L99
        L59:
            j$.util.concurrent.ConcurrentHashMap$Node r5 = r5.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> La9
            goto L94
        L5c:
            j$.util.concurrent.ConcurrentHashMap$Node r7 = r5.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> La9
            if (r7 == 0) goto L98
            r10 = r7
            r7 = r5
            r5 = r10
            goto L2f
        L64:
            boolean r5 = r4 instanceof j$.util.concurrent.ConcurrentHashMap.TreeBin     // Catch: java.lang.Throwable -> La9
            if (r5 == 0) goto L9b
            r5 = r4
            j$.util.concurrent.ConcurrentHashMap$TreeBin r5 = (j$.util.concurrent.ConcurrentHashMap.TreeBin) r5     // Catch: java.lang.Throwable -> La9
            j$.util.concurrent.ConcurrentHashMap$TreeNode r7 = r5.lookAheadTest     // Catch: java.lang.Throwable -> La9
            if (r7 == 0) goto L98
            j$.util.concurrent.ConcurrentHashMap$TreeNode r7 = r7.MyBillsEntityDataFactory(r0, r12, r2)     // Catch: java.lang.Throwable -> La9
            if (r7 == 0) goto L98
            java.lang.Object r8 = r7.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> La9
            if (r14 == 0) goto L83
            if (r14 == r8) goto L83
            if (r8 == 0) goto L98
            boolean r9 = r14.equals(r8)     // Catch: java.lang.Throwable -> La9
            if (r9 == 0) goto L98
        L83:
            if (r13 == 0) goto L88
            r7.BuiltInFictitiousFunctionClassFactory = r13     // Catch: java.lang.Throwable -> La9
            goto L99
        L88:
            boolean r7 = r5.MyBillsEntityDataFactory(r7)     // Catch: java.lang.Throwable -> La9
            if (r7 == 0) goto L99
            j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r5.PlaceComponentResult     // Catch: java.lang.Throwable -> La9
            j$.util.concurrent.ConcurrentHashMap$Node r5 = untreeify(r5)     // Catch: java.lang.Throwable -> La9
        L94:
            setTabAt(r1, r3, r5)     // Catch: java.lang.Throwable -> La9
            goto L99
        L98:
            r8 = r2
        L99:
            r7 = 1
            goto L9c
        L9b:
            r8 = r2
        L9c:
            monitor-exit(r4)
            if (r7 == 0) goto La
            if (r8 == 0) goto Lac
            if (r13 != 0) goto La8
            r12 = -1
            r11.addCount(r12, r6)
        La8:
            return r8
        La9:
            r12 = move-exception
            monitor-exit(r4)
            throw r12
        Lac:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.replaceNode(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long sumCount = sumCount();
        if (sumCount < 0) {
            return 0;
        }
        if (sumCount > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) sumCount;
    }

    final long sumCount() {
        CounterCell[] counterCellArr = this.counterCells;
        long j = this.baseCount;
        if (counterCellArr != null) {
            for (CounterCell counterCell : counterCellArr) {
                if (counterCell != null) {
                    j += counterCell.PlaceComponentResult;
                }
            }
        }
        return j;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        Node[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            while (true) {
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                NetworkUserEntityData$$ExternalSyntheticLambda0 = traverser.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    break;
                }
                sb.append(',');
                sb.append(InputCardNumberView.DIVIDER);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Collection<V> values() {
        ValuesView valuesView = this.values;
        if (valuesView == null) {
            ValuesView valuesView2 = new ValuesView(this);
            this.values = valuesView2;
            return valuesView2;
        }
        return valuesView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class TreeBin extends Node {
        private static final Unsafe DatabaseTableConfigUtil;
        private static final long GetContactSyncConfig;
        volatile Thread NetworkUserEntityData$$ExternalSyntheticLambda0;
        volatile TreeNode PlaceComponentResult;
        TreeNode lookAheadTest;
        volatile int moveToNextValue;
        public static final byte[] scheduleImpl = {4, -20, -33, -123, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int getErrorConfigVersion = 143;

        static {
            Unsafe unsafe;
            try {
                unsafe = DesugarUnsafe.getAuthRequestContext;
                DatabaseTableConfigUtil = unsafe;
                GetContactSyncConfig = unsafe.objectFieldOffset(TreeBin.class.getDeclaredField("moveToNextValue"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TreeBin(TreeNode treeNode) {
            super(-2, null, null, null);
            int compareComparables;
            int KClassImpl$Data$declaredNonStaticMembers$2;
            this.PlaceComponentResult = treeNode;
            TreeNode treeNode2 = null;
            while (treeNode != null) {
                TreeNode treeNode3 = (TreeNode) treeNode.MyBillsEntityDataFactory;
                treeNode.lookAheadTest = null;
                treeNode.PlaceComponentResult = null;
                if (treeNode2 == null) {
                    treeNode.scheduleImpl = null;
                    treeNode.getErrorConfigVersion = false;
                } else {
                    Object obj = treeNode.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i = treeNode.getAuthRequestContext;
                    Class cls = null;
                    TreeNode treeNode4 = treeNode2;
                    while (true) {
                        Object obj2 = treeNode4.KClassImpl$Data$declaredNonStaticMembers$2;
                        int i2 = treeNode4.getAuthRequestContext;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i2 > i ? -1 : i2 < i ? 1 : ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) ? KClassImpl$Data$declaredNonStaticMembers$2(obj, obj2) : compareComparables;
                        TreeNode treeNode5 = KClassImpl$Data$declaredNonStaticMembers$2 <= 0 ? treeNode4.PlaceComponentResult : treeNode4.lookAheadTest;
                        if (treeNode5 == null) {
                            break;
                        }
                        treeNode4 = treeNode5;
                    }
                    treeNode.scheduleImpl = treeNode4;
                    if (KClassImpl$Data$declaredNonStaticMembers$2 <= 0) {
                        treeNode4.PlaceComponentResult = treeNode;
                    } else {
                        treeNode4.lookAheadTest = treeNode;
                    }
                    treeNode = KClassImpl$Data$declaredNonStaticMembers$2(treeNode2, treeNode);
                }
                treeNode2 = treeNode;
                treeNode = treeNode3;
            }
            this.lookAheadTest = treeNode2;
        }

        private static TreeNode BuiltInFictitiousFunctionClassFactory(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3 = treeNode2.lookAheadTest;
            if (treeNode3 != null) {
                TreeNode treeNode4 = treeNode3.PlaceComponentResult;
                treeNode2.lookAheadTest = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.scheduleImpl = treeNode2;
                }
                TreeNode treeNode5 = treeNode2.scheduleImpl;
                treeNode3.scheduleImpl = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.getErrorConfigVersion = false;
                    treeNode = treeNode3;
                } else if (treeNode5.PlaceComponentResult == treeNode2) {
                    treeNode5.PlaceComponentResult = treeNode3;
                } else {
                    treeNode5.lookAheadTest = treeNode3;
                }
                treeNode3.PlaceComponentResult = treeNode2;
                treeNode2.scheduleImpl = treeNode3;
            }
            return treeNode;
        }

        private static int KClassImpl$Data$declaredNonStaticMembers$2(Object obj, Object obj2) {
            int compareTo;
            if (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) {
                try {
                    Object[] objArr = {obj};
                    byte b = scheduleImpl[15];
                    Object[] objArr2 = new Object[1];
                    a(b, (byte) (b - 1), (byte) (-scheduleImpl[5]), objArr2);
                    Class<?> cls = Class.forName((String) objArr2[0]);
                    byte b2 = scheduleImpl[15];
                    Object[] objArr3 = new Object[1];
                    a(b2, b2, (byte) (getErrorConfigVersion & 58), objArr3);
                    int intValue = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
                    try {
                        Object[] objArr4 = {obj2};
                        byte b3 = scheduleImpl[15];
                        Object[] objArr5 = new Object[1];
                        a(b3, (byte) (b3 - 1), (byte) (-scheduleImpl[5]), objArr5);
                        Class<?> cls2 = Class.forName((String) objArr5[0]);
                        byte b4 = scheduleImpl[15];
                        Object[] objArr6 = new Object[1];
                        a(b4, b4, (byte) (getErrorConfigVersion & 58), objArr6);
                        return intValue <= ((Integer) cls2.getMethod((String) objArr6[0], Object.class).invoke(null, objArr4)).intValue() ? -1 : 1;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            return compareTo;
        }

        private static TreeNode KClassImpl$Data$declaredNonStaticMembers$2(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3;
            treeNode2.getErrorConfigVersion = true;
            while (true) {
                TreeNode treeNode4 = treeNode2.scheduleImpl;
                if (treeNode4 == null) {
                    treeNode2.getErrorConfigVersion = false;
                    return treeNode2;
                } else if (!treeNode4.getErrorConfigVersion || (treeNode3 = treeNode4.scheduleImpl) == null) {
                    break;
                } else {
                    TreeNode treeNode5 = treeNode3.PlaceComponentResult;
                    if (treeNode4 == treeNode5) {
                        treeNode5 = treeNode3.lookAheadTest;
                        if (treeNode5 == null || !treeNode5.getErrorConfigVersion) {
                            if (treeNode2 == treeNode4.lookAheadTest) {
                                treeNode = BuiltInFictitiousFunctionClassFactory(treeNode, treeNode4);
                                TreeNode treeNode6 = treeNode4.scheduleImpl;
                                treeNode3 = treeNode6 == null ? null : treeNode6.scheduleImpl;
                                treeNode4 = treeNode6;
                                treeNode2 = treeNode4;
                            }
                            if (treeNode4 != null) {
                                treeNode4.getErrorConfigVersion = false;
                                if (treeNode3 != null) {
                                    treeNode3.getErrorConfigVersion = true;
                                    treeNode = PlaceComponentResult(treeNode, treeNode3);
                                }
                            }
                        } else {
                            treeNode5.getErrorConfigVersion = false;
                            treeNode4.getErrorConfigVersion = false;
                            treeNode3.getErrorConfigVersion = true;
                            treeNode2 = treeNode3;
                        }
                    } else if (treeNode5 == null || !treeNode5.getErrorConfigVersion) {
                        if (treeNode2 == treeNode4.PlaceComponentResult) {
                            treeNode = PlaceComponentResult(treeNode, treeNode4);
                            TreeNode treeNode7 = treeNode4.scheduleImpl;
                            treeNode3 = treeNode7 == null ? null : treeNode7.scheduleImpl;
                            treeNode4 = treeNode7;
                            treeNode2 = treeNode4;
                        }
                        if (treeNode4 != null) {
                            treeNode4.getErrorConfigVersion = false;
                            if (treeNode3 != null) {
                                treeNode3.getErrorConfigVersion = true;
                                treeNode = BuiltInFictitiousFunctionClassFactory(treeNode, treeNode3);
                            }
                        }
                    } else {
                        treeNode5.getErrorConfigVersion = false;
                        treeNode4.getErrorConfigVersion = false;
                        treeNode3.getErrorConfigVersion = true;
                        treeNode2 = treeNode3;
                    }
                }
            }
            return treeNode;
        }

        private static TreeNode PlaceComponentResult(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3 = treeNode2.PlaceComponentResult;
            if (treeNode3 != null) {
                TreeNode treeNode4 = treeNode3.lookAheadTest;
                treeNode2.PlaceComponentResult = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.scheduleImpl = treeNode2;
                }
                TreeNode treeNode5 = treeNode2.scheduleImpl;
                treeNode3.scheduleImpl = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.getErrorConfigVersion = false;
                    treeNode = treeNode3;
                } else if (treeNode5.lookAheadTest == treeNode2) {
                    treeNode5.lookAheadTest = treeNode3;
                } else {
                    treeNode5.PlaceComponentResult = treeNode3;
                }
                treeNode3.lookAheadTest = treeNode2;
                treeNode2.scheduleImpl = treeNode3;
            }
            return treeNode;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = 106 - r7
                byte[] r0 = j$.util.concurrent.ConcurrentHashMap.TreeBin.scheduleImpl
                int r8 = r8 * 3
                int r8 = 46 - r8
                int r6 = r6 * 3
                int r6 = r6 + 13
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L32
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r6) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r4 = r0[r8]
                int r3 = r3 + 1
                r5 = r9
                r9 = r8
                r8 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L32:
                int r7 = r7 + r8
                int r7 = r7 + 2
                int r8 = r9 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.TreeBin.a(int, byte, byte, java.lang.Object[]):void");
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        final Node MyBillsEntityDataFactory(int i, Object obj) {
            Object obj2;
            Thread thread;
            Thread thread2;
            TreeNode treeNode = null;
            if (obj != null) {
                Node node = this.PlaceComponentResult;
                while (node != null) {
                    int i2 = this.moveToNextValue;
                    if ((i2 & 3) == 0) {
                        Unsafe unsafe = DatabaseTableConfigUtil;
                        long j = GetContactSyncConfig;
                        if (unsafe.compareAndSwapInt(this, j, i2, i2 + 4)) {
                            try {
                                TreeNode treeNode2 = this.lookAheadTest;
                                if (treeNode2 != null) {
                                    treeNode = treeNode2.MyBillsEntityDataFactory(i, obj, null);
                                }
                                if (DesugarUnsafe.KClassImpl$Data$declaredNonStaticMembers$2(unsafe, this, j) == 6 && (thread2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
                                    LockSupport.unpark(thread2);
                                }
                                return treeNode;
                            } catch (Throwable th) {
                                if (DesugarUnsafe.KClassImpl$Data$declaredNonStaticMembers$2(DatabaseTableConfigUtil, this, GetContactSyncConfig) == 6 && (thread = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
                                    LockSupport.unpark(thread);
                                }
                                throw th;
                            }
                        }
                    } else if (node.getAuthRequestContext == i && ((obj2 = node.KClassImpl$Data$declaredNonStaticMembers$2) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return node;
                    } else {
                        node = node.MyBillsEntityDataFactory;
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
        
            return r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a1, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final j$.util.concurrent.ConcurrentHashMap.TreeNode MyBillsEntityDataFactory(int r16, java.lang.Object r17, java.lang.Object r18) {
            /*
                r15 = this;
                r1 = r15
                r0 = r16
                r4 = r17
                j$.util.concurrent.ConcurrentHashMap$TreeNode r2 = r1.lookAheadTest
                r8 = 0
                r9 = 0
                r10 = r2
                r2 = r8
                r3 = 0
            Lc:
                if (r10 != 0) goto L22
                j$.util.concurrent.ConcurrentHashMap$TreeNode r9 = new j$.util.concurrent.ConcurrentHashMap$TreeNode
                r6 = 0
                r7 = 0
                r2 = r9
                r3 = r16
                r4 = r17
                r5 = r18
                r2.<init>(r3, r4, r5, r6, r7)
                r1.lookAheadTest = r9
                r1.PlaceComponentResult = r9
                goto La1
            L22:
                int r5 = r10.getAuthRequestContext
                r11 = 1
                if (r5 <= r0) goto L2a
                r5 = -1
                r12 = -1
                goto L67
            L2a:
                if (r5 >= r0) goto L2e
                r12 = 1
                goto L67
            L2e:
                java.lang.Object r5 = r10.KClassImpl$Data$declaredNonStaticMembers$2
                if (r5 == r4) goto La9
                if (r5 == 0) goto L3a
                boolean r6 = r4.equals(r5)
                if (r6 != 0) goto La9
            L3a:
                if (r2 != 0) goto L42
                java.lang.Class r2 = j$.util.concurrent.ConcurrentHashMap.comparableClassFor(r17)
                if (r2 == 0) goto L48
            L42:
                int r6 = j$.util.concurrent.ConcurrentHashMap.compareComparables(r2, r4, r5)
                if (r6 != 0) goto L66
            L48:
                if (r3 != 0) goto L60
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r10.PlaceComponentResult
                if (r3 == 0) goto L54
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r3.MyBillsEntityDataFactory(r0, r4, r2)
                if (r3 != 0) goto L5e
            L54:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r10.lookAheadTest
                if (r3 == 0) goto L5f
                j$.util.concurrent.ConcurrentHashMap$TreeNode r3 = r3.MyBillsEntityDataFactory(r0, r4, r2)
                if (r3 == 0) goto L5f
            L5e:
                return r3
            L5f:
                r3 = 1
            L60:
                int r5 = KClassImpl$Data$declaredNonStaticMembers$2(r4, r5)
                r12 = r5
                goto L67
            L66:
                r12 = r6
            L67:
                if (r12 > 0) goto L6c
                j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r10.PlaceComponentResult
                goto L6e
            L6c:
                j$.util.concurrent.ConcurrentHashMap$TreeNode r5 = r10.lookAheadTest
            L6e:
                if (r5 != 0) goto La6
                j$.util.concurrent.ConcurrentHashMap$TreeNode r13 = r1.PlaceComponentResult
                j$.util.concurrent.ConcurrentHashMap$TreeNode r14 = new j$.util.concurrent.ConcurrentHashMap$TreeNode
                r2 = r14
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r13
                r7 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                r1.PlaceComponentResult = r14
                if (r13 == 0) goto L86
                r13.moveToNextValue = r14
            L86:
                if (r12 > 0) goto L8b
                r10.PlaceComponentResult = r14
                goto L8d
            L8b:
                r10.lookAheadTest = r14
            L8d:
                boolean r0 = r10.getErrorConfigVersion
                if (r0 != 0) goto L94
                r14.getErrorConfigVersion = r11
                goto La1
            L94:
                r15.BuiltInFictitiousFunctionClassFactory()
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = r1.lookAheadTest     // Catch: java.lang.Throwable -> La2
                j$.util.concurrent.ConcurrentHashMap$TreeNode r0 = KClassImpl$Data$declaredNonStaticMembers$2(r0, r14)     // Catch: java.lang.Throwable -> La2
                r1.lookAheadTest = r0     // Catch: java.lang.Throwable -> La2
                r1.moveToNextValue = r9
            La1:
                return r8
            La2:
                r0 = move-exception
                r1.moveToNextValue = r9
                throw r0
            La6:
                r10 = r5
                goto Lc
            La9:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.TreeBin.MyBillsEntityDataFactory(int, java.lang.Object, java.lang.Object):j$.util.concurrent.ConcurrentHashMap$TreeNode");
        }

        private final void BuiltInFictitiousFunctionClassFactory() {
            if (DatabaseTableConfigUtil.compareAndSwapInt(this, GetContactSyncConfig, 0, 1)) {
                return;
            }
            boolean z = false;
            while (true) {
                int i = this.moveToNextValue;
                if ((i & (-3)) == 0) {
                    if (DatabaseTableConfigUtil.compareAndSwapInt(this, GetContactSyncConfig, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (DatabaseTableConfigUtil.compareAndSwapInt(this, GetContactSyncConfig, i, i | 2)) {
                        try {
                            byte b = scheduleImpl[15];
                            byte b2 = (byte) (b - 1);
                            Object[] objArr = new Object[1];
                            a(b, b2, b2, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b3 = (byte) (scheduleImpl[15] - 1);
                            byte b4 = scheduleImpl[8];
                            Object[] objArr2 = new Object[1];
                            a(b3, b4, (byte) (b4 << 1), objArr2);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                            z = true;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        continue;
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:152:0x018a A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:21:0x002e, B:25:0x0037, B:28:0x003d, B:30:0x004b, B:38:0x0063, B:40:0x0069, B:41:0x006b, B:56:0x008c, B:63:0x009d, B:59:0x0094, B:61:0x0098, B:62:0x009b, B:64:0x00a3, B:150:0x0186, B:152:0x018a, B:154:0x018e, B:156:0x0192, B:160:0x019b, B:157:0x0195, B:159:0x0199, B:70:0x00ae, B:72:0x00b2, B:73:0x00b7, B:75:0x00bb, B:76:0x00bf, B:78:0x00c3, B:80:0x00c7, B:82:0x00cb, B:85:0x00d9, B:87:0x00dd, B:89:0x00e3, B:96:0x00f1, B:108:0x0110, B:110:0x0116, B:107:0x010e, B:112:0x011a, B:99:0x00f7, B:100:0x00f9, B:103:0x0105, B:92:0x00e9, B:149:0x0183, B:114:0x0124, B:116:0x0128, B:119:0x0136, B:122:0x013d, B:124:0x0143, B:131:0x0150, B:143:0x016f, B:145:0x0175, B:142:0x016d, B:147:0x0179, B:134:0x0156, B:135:0x0158, B:138:0x0164, B:127:0x0149, B:44:0x0075, B:46:0x0079, B:47:0x007c, B:31:0x0050, B:33:0x0056, B:35:0x005a, B:36:0x005d, B:37:0x005f), top: B:167:0x002e }] */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0192 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:21:0x002e, B:25:0x0037, B:28:0x003d, B:30:0x004b, B:38:0x0063, B:40:0x0069, B:41:0x006b, B:56:0x008c, B:63:0x009d, B:59:0x0094, B:61:0x0098, B:62:0x009b, B:64:0x00a3, B:150:0x0186, B:152:0x018a, B:154:0x018e, B:156:0x0192, B:160:0x019b, B:157:0x0195, B:159:0x0199, B:70:0x00ae, B:72:0x00b2, B:73:0x00b7, B:75:0x00bb, B:76:0x00bf, B:78:0x00c3, B:80:0x00c7, B:82:0x00cb, B:85:0x00d9, B:87:0x00dd, B:89:0x00e3, B:96:0x00f1, B:108:0x0110, B:110:0x0116, B:107:0x010e, B:112:0x011a, B:99:0x00f7, B:100:0x00f9, B:103:0x0105, B:92:0x00e9, B:149:0x0183, B:114:0x0124, B:116:0x0128, B:119:0x0136, B:122:0x013d, B:124:0x0143, B:131:0x0150, B:143:0x016f, B:145:0x0175, B:142:0x016d, B:147:0x0179, B:134:0x0156, B:135:0x0158, B:138:0x0164, B:127:0x0149, B:44:0x0075, B:46:0x0079, B:47:0x007c, B:31:0x0050, B:33:0x0056, B:35:0x005a, B:36:0x005d, B:37:0x005f), top: B:167:0x002e }] */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0195 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:21:0x002e, B:25:0x0037, B:28:0x003d, B:30:0x004b, B:38:0x0063, B:40:0x0069, B:41:0x006b, B:56:0x008c, B:63:0x009d, B:59:0x0094, B:61:0x0098, B:62:0x009b, B:64:0x00a3, B:150:0x0186, B:152:0x018a, B:154:0x018e, B:156:0x0192, B:160:0x019b, B:157:0x0195, B:159:0x0199, B:70:0x00ae, B:72:0x00b2, B:73:0x00b7, B:75:0x00bb, B:76:0x00bf, B:78:0x00c3, B:80:0x00c7, B:82:0x00cb, B:85:0x00d9, B:87:0x00dd, B:89:0x00e3, B:96:0x00f1, B:108:0x0110, B:110:0x0116, B:107:0x010e, B:112:0x011a, B:99:0x00f7, B:100:0x00f9, B:103:0x0105, B:92:0x00e9, B:149:0x0183, B:114:0x0124, B:116:0x0128, B:119:0x0136, B:122:0x013d, B:124:0x0143, B:131:0x0150, B:143:0x016f, B:145:0x0175, B:142:0x016d, B:147:0x0179, B:134:0x0156, B:135:0x0158, B:138:0x0164, B:127:0x0149, B:44:0x0075, B:46:0x0079, B:47:0x007c, B:31:0x0050, B:33:0x0056, B:35:0x005a, B:36:0x005d, B:37:0x005f), top: B:167:0x002e }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x008c A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:21:0x002e, B:25:0x0037, B:28:0x003d, B:30:0x004b, B:38:0x0063, B:40:0x0069, B:41:0x006b, B:56:0x008c, B:63:0x009d, B:59:0x0094, B:61:0x0098, B:62:0x009b, B:64:0x00a3, B:150:0x0186, B:152:0x018a, B:154:0x018e, B:156:0x0192, B:160:0x019b, B:157:0x0195, B:159:0x0199, B:70:0x00ae, B:72:0x00b2, B:73:0x00b7, B:75:0x00bb, B:76:0x00bf, B:78:0x00c3, B:80:0x00c7, B:82:0x00cb, B:85:0x00d9, B:87:0x00dd, B:89:0x00e3, B:96:0x00f1, B:108:0x0110, B:110:0x0116, B:107:0x010e, B:112:0x011a, B:99:0x00f7, B:100:0x00f9, B:103:0x0105, B:92:0x00e9, B:149:0x0183, B:114:0x0124, B:116:0x0128, B:119:0x0136, B:122:0x013d, B:124:0x0143, B:131:0x0150, B:143:0x016f, B:145:0x0175, B:142:0x016d, B:147:0x0179, B:134:0x0156, B:135:0x0158, B:138:0x0164, B:127:0x0149, B:44:0x0075, B:46:0x0079, B:47:0x007c, B:31:0x0050, B:33:0x0056, B:35:0x005a, B:36:0x005d, B:37:0x005f), top: B:167:0x002e }] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00a9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final boolean MyBillsEntityDataFactory(j$.util.concurrent.ConcurrentHashMap.TreeNode r12) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.TreeBin.MyBillsEntityDataFactory(j$.util.concurrent.ConcurrentHashMap$TreeNode):boolean");
        }
    }
}
