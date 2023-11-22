package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\n¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "", "Lkotlin/Function1;", "", "operation", "forEach", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "iterator", "(Ljava/util/Iterator;)Ljava/util/Iterator;", "Lkotlin/collections/IndexedValue;", "withIndex"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterator<T> iterator(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "");
        return it;
    }

    public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "");
        return new IndexingIterator(it);
    }

    public static final <T> void forEach(Iterator<? extends T> it, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(it, "");
        Intrinsics.checkNotNullParameter(function1, "");
        while (it.hasNext()) {
            function1.invoke((T) it.next());
        }
    }
}
