package kotlin.collections;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0007\u001a4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\u0002¢\u0006\u0004\b\u0003\u0010\t\u001a4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u000b\u001a.\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\f\u0010\u0004\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\r\u0010\u0004\u001a6\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\r\u0010\u0007\u001a4\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\u0002¢\u0006\u0004\b\r\u0010\t\u001a4\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000b\u001a.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000e\u0010\u0004"}, d2 = {"T", "", LottieParams.KEY_ELEMENT_ID, "minus", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "(Ljava/util/Set;Ljava/lang/Iterable;)Ljava/util/Set;", "Lkotlin/sequences/Sequence;", "(Ljava/util/Set;Lkotlin/sequences/Sequence;)Ljava/util/Set;", "minusElement", "plus", "plusElement"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes.dex */
public class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static final <T> Set<T> minus(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(tArr, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt.removeAll(linkedHashSet, tArr);
        return linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Set<? extends T> set2 = set;
        Collection<?> convertToSetForSetOperationWith = BrittleContainsOptimizationKt.convertToSetForSetOperationWith(iterable, set2);
        if (convertToSetForSetOperationWith.isEmpty()) {
            return CollectionsKt.toSet(set2);
        }
        if (convertToSetForSetOperationWith instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set2) {
                if (!convertToSetForSetOperationWith.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(convertToSetForSetOperationWith);
        return linkedHashSet2;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt.removeAll(linkedHashSet, sequence);
        return linkedHashSet;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "");
        return SetsKt.minus(set, t);
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(tArr, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, tArr);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> iterable) {
        int size;
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Integer collectionSizeOrNull = CollectionsKt.collectionSizeOrNull(iterable);
        if (collectionSizeOrNull != null) {
            size = set.size() + collectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(set.size() * 2));
        linkedHashSet.addAll(set);
        CollectionsKt.addAll(linkedHashSet, sequence);
        return linkedHashSet;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "");
        return SetsKt.plus(set, t);
    }
}
