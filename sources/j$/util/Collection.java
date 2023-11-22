package j$.util;

import j$.lang.Iterable;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public interface Collection extends Iterable {

    /* renamed from: j$.util.Collection$-CC */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC<E> {
        public static boolean KClassImpl$Data$declaredNonStaticMembers$2(java.util.Collection collection, Predicate predicate) {
            if (DesugarCollections.KClassImpl$Data$declaredNonStaticMembers$2.isInstance(collection)) {
                return DesugarCollections.PlaceComponentResult(collection, predicate);
            }
            boolean z = false;
            java.util.Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static Stream MyBillsEntityDataFactory(java.util.Collection collection) {
            return StreamSupport.PlaceComponentResult(EL.PlaceComponentResult(collection), true);
        }

        public static Object[] MyBillsEntityDataFactory(java.util.Collection collection, IntFunction intFunction) {
            return collection.toArray((Object[]) intFunction.MyBillsEntityDataFactory(0));
        }

        public static Stream PlaceComponentResult(java.util.Collection collection) {
            return StreamSupport.PlaceComponentResult(EL.PlaceComponentResult(collection), false);
        }
    }

    /* renamed from: j$.util.Collection$-EL */
    /* loaded from: classes.dex */
    public final /* synthetic */ class EL {
        public static /* synthetic */ Stream BuiltInFictitiousFunctionClassFactory(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).parallelStream() : CC.MyBillsEntityDataFactory(collection);
        }

        public static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(java.util.Collection collection, Predicate predicate) {
            return collection instanceof Collection ? ((Collection) collection).removeIf(predicate) : CC.KClassImpl$Data$declaredNonStaticMembers$2(collection, predicate);
        }

        public static Spliterator PlaceComponentResult(java.util.Collection collection) {
            if (collection instanceof Collection) {
                return ((Collection) collection).spliterator();
            }
            if (collection instanceof LinkedHashSet) {
                return new Spliterators.IteratorSpliterator(17, (LinkedHashSet) collection);
            }
            if (!(collection instanceof SortedSet)) {
                return collection instanceof Set ? new Spliterators.IteratorSpliterator(1, (Set) collection) : collection instanceof java.util.List ? new Spliterators.IteratorSpliterator(16, (java.util.List) collection) : new Spliterators.IteratorSpliterator(0, collection);
            }
            final SortedSet sortedSet = (SortedSet) collection;
            return new Spliterators.IteratorSpliterator(sortedSet) { // from class: j$.util.SortedSet$1
                @Override // j$.util.Spliterators.IteratorSpliterator, j$.util.Spliterator
                public final java.util.Comparator getAuthRequestContext() {
                    return sortedSet.comparator();
                }
            };
        }

        public static /* synthetic */ Stream getAuthRequestContext(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).stream() : CC.PlaceComponentResult(collection);
        }

        public static void getAuthRequestContext(java.util.Collection collection, Consumer consumer) {
            if (collection instanceof Collection) {
                ((Collection) collection).forEach(consumer);
                return;
            }
            java.util.Iterator it = collection.iterator();
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }
    }

    @Override // j$.lang.Iterable
    void forEach(Consumer consumer);

    Stream parallelStream();

    boolean removeIf(Predicate predicate);

    Spliterator spliterator();

    Stream stream();
}
