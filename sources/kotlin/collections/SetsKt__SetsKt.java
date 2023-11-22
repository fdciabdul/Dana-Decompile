package kotlin.collections;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\u001aU\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001f\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u001f\u0010\u0007\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\u000b\u001a\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\f¢\u0006\u0004\b\r\u0010\u000e\u001a&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\fH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a7\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\f2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0015\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0016j\b\u0012\u0004\u0012\u00028\u0000`\u0017\"\u0004\b\u0000\u0010\fH\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a7\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0016j\b\u0012\u0004\u0012\u00028\u0000`\u0017\"\u0004\b\u0000\u0010\f2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\fH\u0086\b¢\u0006\u0004\b\u001b\u0010\u000e\u001a-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\f2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\fH\u0086\b¢\u0006\u0004\b\u001d\u0010\u000e\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\f2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013\"\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001a'\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\f*\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b \u0010!\u001a5\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\f*\u00020\u001e2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0013\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b \u0010\u001c\u001a%\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\bH\u0000¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\f*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0086\b¢\u0006\u0004\b$\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"E", "", "capacity", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "buildSet", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Set;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Set;", "T", "emptySet", "()Ljava/util/Set;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "hashSetOf", "()Ljava/util/HashSet;", "", "elements", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "linkedSetOf", "()Ljava/util/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "", LottieParams.KEY_ELEMENT_ID, "setOfNotNull", "(Ljava/lang/Object;)Ljava/util/Set;", "optimizeReadOnlySet", "(Ljava/util/Set;)Ljava/util/Set;", "orEmpty"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static final <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> setOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return tArr.length > 0 ? ArraysKt.toSet(tArr) : SetsKt.emptySet();
    }

    private static final <T> Set<T> setOf() {
        return SetsKt.emptySet();
    }

    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return (Set) ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return (HashSet) ArraysKt.toCollection(tArr, new HashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return (LinkedHashSet) ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> setOfNotNull(T t) {
        return t != null ? SetsKt.setOf(t) : SetsKt.emptySet();
    }

    public static final <T> Set<T> setOfNotNull(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return (Set) ArraysKt.filterNotNullTo(tArr, new LinkedHashSet());
    }

    private static final <E> Set<E> buildSet(Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Set createSetBuilder = SetsKt.createSetBuilder();
        function1.invoke(createSetBuilder);
        return SetsKt.build(createSetBuilder);
    }

    private static final <E> Set<E> buildSet(int i, Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Set createSetBuilder = SetsKt.createSetBuilder(i);
        function1.invoke(createSetBuilder);
        return SetsKt.build(createSetBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Set<T> orEmpty(Set<? extends T> set) {
        return set == 0 ? SetsKt.emptySet() : set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "");
        int size = set.size();
        if (size != 0) {
            return size == 1 ? SetsKt.setOf(set.iterator().next()) : set;
        }
        return SetsKt.emptySet();
    }
}
