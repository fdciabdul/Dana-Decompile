package kotlin.comparisons;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a[\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u000026\u0010\t\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00010\b\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001¢\u0006\u0004\b\u0006\u0010\n\u001aa\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00052\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\r\u001aE\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0007\u001aa\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00052\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a/\u0010\u0012\u001a\u00020\u0011\"\f\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aC\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u000026\u0010\t\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00010\b\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0016\u001a_\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00052\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0017\u001aG\u0010\u0018\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002 \u0010\t\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00010\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0016\u001a-\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a4\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001a\u001aG\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0005\"\b\b\u0000\u0010\u0000*\u00020\u001c2\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u001b\u0010\u001d\u001a4\u0010\u001e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\b¢\u0006\u0004\b\u001e\u0010\u001a\u001aG\u0010\u001e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0005\"\b\b\u0000\u0010\u0000*\u00020\u001c2\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u001e\u0010\u001d\u001a-\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001f\u0010\u001a\u001a7\u0010 \u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005¢\u0006\u0004\b \u0010\u001d\u001aV\u0010!\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0086\u0004¢\u0006\u0004\b!\u0010\"\u001aY\u0010#\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u001a\b\u0004\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010\r\u001au\u0010#\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00052\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001aY\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u001a\b\u0004\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010\r\u001au\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00052\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010$\u001a{\u0010*\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052<\b\u0004\u0010)\u001a6\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110&H\u0086\bø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001aV\u0010,\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u001a\u0010\f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005H\u0086\u0004¢\u0006\u0004\b,\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "Lkotlin/Function1;", "", "selector", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "compareBy", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "", "selectors", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", DiskFormatter.KB, "comparator", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "compareByDescending", "a", "b", "", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "()Ljava/util/Comparator;", "nullsFirst", "", "(Ljava/util/Comparator;)Ljava/util/Comparator;", "nullsLast", "reverseOrder", "reversed", "then", "(Ljava/util/Comparator;Ljava/util/Comparator;)Ljava/util/Comparator;", "thenBy", "(Ljava/util/Comparator;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "thenByDescending", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comparison", "thenComparator", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function2;)Ljava/util/Comparator;", "thenDescending"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes.dex */
public class ComparisonsKt__ComparisonsKt {
    public static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "");
        if (!(function1Arr.length > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, function1Arr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int compareValues = ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
            if (compareValues != 0) {
                return compareValues;
            }
        }
        return 0;
    }

    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        return ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
    }

    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return comparator.compare((K) function1.invoke(t), (K) function1.invoke(t2));
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "");
        if (!(function1Arr.length > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compareValuesByImpl$ComparisonsKt__ComparisonsKt;
                compareValuesByImpl$ComparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, function1Arr);
                return compareValuesByImpl$ComparisonsKt__ComparisonsKt;
            }
        };
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        return new ComparisonsKt__ComparisonsKt$compareBy$2(function1);
    }

    private static final <T, K> Comparator<T> compareBy(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$3
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function12 = function1;
                return comparator2.compare(function12.invoke(t), function12.invoke(t2));
            }
        };
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        return new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1);
    }

    private static final <T, K> Comparator<T> compareByDescending(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function12 = function1;
                return comparator2.compare(function12.invoke(t2), function12.invoke(t));
            }
        };
    }

    private static final <T> Comparator<T> thenBy(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare == 0) {
                    Function1<T, Comparable<?>> function12 = function1;
                    return ComparisonsKt.compareValues(function12.invoke(t), function12.invoke(t2));
                }
                return compare;
            }
        };
    }

    private static final <T, K> Comparator<T> thenBy(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(comparator2, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenBy$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare == 0) {
                    Comparator<? super K> comparator3 = comparator2;
                    Function1<T, K> function12 = function1;
                    return comparator3.compare(function12.invoke(t), function12.invoke(t2));
                }
                return compare;
            }
        };
    }

    private static final <T> Comparator<T> thenByDescending(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare == 0) {
                    Function1<T, Comparable<?>> function12 = function1;
                    return ComparisonsKt.compareValues(function12.invoke(t2), function12.invoke(t));
                }
                return compare;
            }
        };
    }

    private static final <T, K> Comparator<T> thenByDescending(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(comparator2, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenByDescending$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare == 0) {
                    Comparator<? super K> comparator3 = comparator2;
                    Function1<T, K> function12 = function1;
                    return comparator3.compare(function12.invoke(t2), function12.invoke(t));
                }
                return compare;
            }
        };
    }

    private static final <T> Comparator<T> thenComparator(final Comparator<T> comparator, final Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(function2, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenComparator$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare == 0 ? function2.invoke(t, t2).intValue() : compare;
            }
        };
    }

    public static final <T> Comparator<T> then(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(comparator2, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$then$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare == 0 ? comparator2.compare(t, t2) : compare;
            }
        };
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(comparator2, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare == 0 ? comparator2.compare(t2, t) : compare;
            }
        };
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$nullsFirst$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                if (t == t2) {
                    return 0;
                }
                if (t == null) {
                    return -1;
                }
                if (t2 == null) {
                    return 1;
                }
                return comparator.compare(t, t2);
            }
        };
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$nullsLast$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                if (t == t2) {
                    return 0;
                }
                if (t == null) {
                    return 1;
                }
                if (t2 == null) {
                    return -1;
                }
                return comparator.compare(t, t2);
            }
        };
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return NaturalOrderComparator.INSTANCE;
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return ReverseOrderComparator.INSTANCE;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return comparator instanceof ReversedComparator ? ((ReversedComparator) comparator).getComparator() : Intrinsics.areEqual(comparator, NaturalOrderComparator.INSTANCE) ? ReverseOrderComparator.INSTANCE : Intrinsics.areEqual(comparator, ReverseOrderComparator.INSTANCE) ? NaturalOrderComparator.INSTANCE : new ReversedComparator(comparator);
    }
}
