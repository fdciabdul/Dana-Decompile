package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0007\u0010\b\u001ai\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u0014\u0010\u0006\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000f¢\u0006\u0004\b\u0014\u0010\u0016\u001a=\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000f¢\u0006\u0004\b\u0014\u0010\u0018\u001a-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u001f\u0010 \u001aE\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\"\u001a)\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u0004¢\u0006\u0004\b$\u0010 \u001a)\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004¢\u0006\u0004\b%\u0010 \u001a7\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0001¢\u0006\u0004\b'\u0010(\u001a(\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b)\u0010 \u001a#\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b*\u0010 \u001a+\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b*\u0010-\u001aG\u00100\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000/\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010/0.\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0\u0004¢\u0006\u0004\b0\u00101\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "Lkotlin/Function0;", "", "iterator", "Lkotlin/sequences/Sequence;", "Sequence", "(Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "emptySequence", "()Lkotlin/sequences/Sequence;", "C", "R", "source", "Lkotlin/Function2;", "", "transform", "Lkotlin/Function1;", "flatMapIndexed", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "", "nextFunction", "generateSequence", "seedFunction", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "", "elements", "sequenceOf", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;", "constrainOnce", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "flatten$SequencesKt__SequencesKt", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "", "flattenSequenceOfIterable", "flatten", "defaultValue", "ifEmpty", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "orEmpty", "shuffled", "Lkotlin/random/Random;", "random", "(Lkotlin/sequences/Sequence;Lkotlin/random/Random;)Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", "unzip", "(Lkotlin/sequences/Sequence;)Lkotlin/Pair;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<T> iterator() {
                return function0.invoke();
            }
        };
    }

    public static final <T> Sequence<T> asSequence(final Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "");
        return SequencesKt.constrainOnce(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<T> iterator() {
                return it;
            }
        });
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return tArr.length == 0 ? SequencesKt.emptySequence() : ArraysKt.asSequence(tArr);
    }

    public static final <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> sequence) {
        return sequence == 0 ? SequencesKt.emptySequence() : sequence;
    }

    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(function0, "");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$ifEmpty$1(sequence, function0, null));
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1<Sequence<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Sequence) ((Sequence) obj));
            }

            public final Iterator<T> invoke(Sequence<? extends T> sequence2) {
                Intrinsics.checkNotNullParameter(sequence2, "");
                return (Iterator<? extends T>) sequence2.iterator();
            }
        });
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1<Iterable<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Iterable) ((Iterable) obj));
            }

            public final Iterator<T> invoke(Iterable<? extends T> iterable) {
                Intrinsics.checkNotNullParameter(iterable, "");
                return (Iterator<? extends T>) iterable.iterator();
            }
        });
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1);
        }
        return new FlatteningSequence(sequence, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$3
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T t) {
                return t;
            }
        }, function1);
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return SequencesKt.shuffled(sequence, Random.INSTANCE);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence, Random random) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(random, "");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$shuffled$1(sequence, random, null));
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$flatMapIndexed$1(sequence, function2, function1, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return !(sequence instanceof ConstrainedOnceSequence) ? new ConstrainedOnceSequence(sequence) : sequence;
    }

    public static final <T> Sequence<T> generateSequence(final Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return SequencesKt.constrainOnce(new GeneratorSequence(function0, new Function1<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(T t) {
                Intrinsics.checkNotNullParameter(t, "");
                return function0.invoke();
            }
        }));
    }

    public static final <T> Sequence<T> generateSequence(final T t, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        if (t == null) {
            return EmptySequence.INSTANCE;
        }
        return new GeneratorSequence(new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return t;
            }
        }, function1);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new GeneratorSequence(function0, function1);
    }
}
