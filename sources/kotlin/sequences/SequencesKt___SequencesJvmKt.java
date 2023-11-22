package kotlin.sequences;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aC\u0010\t\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u001a\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0019¢\u0006\u0004\b\u0016\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"R", "Lkotlin/sequences/Sequence;", "Ljava/lang/Class;", "klass", "filterIsInstance", "(Lkotlin/sequences/Sequence;Ljava/lang/Class;)Lkotlin/sequences/Sequence;", "", "C", FirebaseAnalytics.Param.DESTINATION, "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "T", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "sumOfBigDecimal", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "", "Ljava/util/SortedSet;", "toSortedSet", "(Lkotlin/sequences/Sequence;)Ljava/util/SortedSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/util/SortedSet;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public static final <R> Sequence<R> filterIsInstance(Sequence<?> sequence, final Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(cls, "");
        return SequencesKt.filter(sequence, new Function1<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesJvmKt$filterIsInstance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(cls.isInstance(obj));
            }
        });
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> sequence, C c, Class<R> cls) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(c, "");
        Intrinsics.checkNotNullParameter(cls, "");
        for (Object obj : sequence) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        return (SortedSet) SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }

    private static final <T> BigDecimal sumOfBigDecimal(Sequence<? extends T> sequence, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(function1.invoke((T) it.next()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(Sequence<? extends T> sequence, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(function1.invoke((T) it.next()));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }
}
