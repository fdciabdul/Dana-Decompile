package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001aC\u0010\n\u001a\u00028\u0000\"\u0010\b\u0000\u0010\b*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0014\u001a\u00020\u0012\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0019*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a?\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u001f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001dj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001e¢\u0006\u0004\b\u001b\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"R", "", "Ljava/lang/Class;", "klass", "", "filterIsInstance", "(Ljava/lang/Iterable;Ljava/lang/Class;)Ljava/util/List;", "", "C", FirebaseAnalytics.Param.DESTINATION, "filterIsInstanceTo", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "T", "", "", "reverse", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "sumOfBigDecimal", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "", "Ljava/util/SortedSet;", "toSortedSet", "(Ljava/lang/Iterable;)Ljava/util/SortedSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/SortedSet;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> cls) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(cls, "");
        return (List) CollectionsKt.filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C c, Class<R> cls) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(c, "");
        Intrinsics.checkNotNullParameter(cls, "");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> void reverse(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        Collections.reverse(list);
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        return (SortedSet) CollectionsKt.toCollection(iterable, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        return (SortedSet) CollectionsKt.toCollection(iterable, new TreeSet(comparator));
    }

    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> iterable, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(function1.invoke((T) it.next()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> iterable, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(function1.invoke((T) it.next()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }
}
