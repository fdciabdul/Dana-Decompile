package j$.util;

import j$.util.Spliterators;
import j$.util.function.UnaryOperator;
import java.util.Arrays;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public interface List<E> extends Collection {

    /* renamed from: j$.util.List$-EL  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class EL {
        public static Spliterator BuiltInFictitiousFunctionClassFactory(java.util.List list) {
            return list instanceof List ? ((List) list).spliterator() : new Spliterators.IteratorSpliterator(16, list);
        }

        public static void MyBillsEntityDataFactory(java.util.List list, UnaryOperator unaryOperator) {
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else if (DesugarCollections.MyBillsEntityDataFactory.isInstance(list)) {
                DesugarCollections.KClassImpl$Data$declaredNonStaticMembers$2(list, unaryOperator);
            } else {
                ListIterator<E> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.set((E) unaryOperator.apply(listIterator.next()));
                }
            }
        }

        public static void PlaceComponentResult(java.util.List list, java.util.Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
            } else if (DesugarCollections.MyBillsEntityDataFactory.isInstance(list)) {
                DesugarCollections.PlaceComponentResult(list, comparator);
            } else {
                Object[] array = list.toArray();
                Arrays.sort(array, comparator);
                ListIterator<E> listIterator = list.listIterator();
                for (Object obj : array) {
                    listIterator.next();
                    listIterator.set(obj);
                }
            }
        }
    }

    void replaceAll(UnaryOperator<E> unaryOperator);

    void sort(java.util.Comparator<? super E> comparator);

    @Override // java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection
    Spliterator<E> spliterator();
}
