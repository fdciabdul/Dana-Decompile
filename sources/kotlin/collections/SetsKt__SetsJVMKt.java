package kotlin.collections;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aH\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u001f\u0010\u000b\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\u0080\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a@\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u001f\u0010\u000b\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\nH\u0080\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000e\u001a\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a-\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u0004\b\u0000\u0010\u00122\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016\"\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aI\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u0004\b\u0000\u0010\u00122\u001a\u0010\u001d\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001bj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001c2\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016\"\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"E", "", "builder", "", "build", "(Ljava/util/Set;)Ljava/util/Set;", "", "capacity", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildSetInternal", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Set;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Set;", "createSetBuilder", "()Ljava/util/Set;", "(I)Ljava/util/Set;", "T", LottieParams.KEY_ELEMENT_ID, "setOf", "(Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "Ljava/util/TreeSet;", "sortedSetOf", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes.dex */
public class SetsKt__SetsJVMKt {
    public static final <T> Set<T> setOf(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(singleton, "");
        return singleton;
    }

    private static final <E> Set<E> buildSetInternal(Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Set createSetBuilder = SetsKt.createSetBuilder();
        function1.invoke(createSetBuilder);
        return SetsKt.build(createSetBuilder);
    }

    private static final <E> Set<E> buildSetInternal(int i, Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Set createSetBuilder = SetsKt.createSetBuilder(i);
        function1.invoke(createSetBuilder);
        return SetsKt.build(createSetBuilder);
    }

    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static final <E> Set<E> createSetBuilder(int i) {
        return new SetBuilder(i);
    }

    public static final <E> Set<E> build(Set<E> set) {
        Intrinsics.checkNotNullParameter(set, "");
        return ((SetBuilder) set).build();
    }

    public static final <T> TreeSet<T> sortedSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return (TreeSet) ArraysKt.toCollection(tArr, new TreeSet());
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(tArr, "");
        return (TreeSet) ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }
}
