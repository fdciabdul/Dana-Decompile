package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\n\u0010\u0001\u001a\u0006*\u00028\u00008\u00002\n\u0010\u0002\u001a\u0006*\u00028\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes.dex */
public final class ComparisonsKt__ComparisonsKt$compareByDescending$1<T> implements Comparator {
    final /* synthetic */ Function1<T, Comparable<?>> $$selector;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$compareByDescending$1(Function1<? super T, ? extends Comparable<?>> function1) {
        this.$$selector = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Function1<T, Comparable<?>> function1 = this.$$selector;
        return ComparisonsKt.compareValues(function1.invoke(t2), function1.invoke(t));
    }
}
