package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\u0006\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0000¢\u0006\u0004\b\u0003\u0010\b\u001a3\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"T", "", "", "convertToSetForSetOperation", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "(Ljava/lang/Iterable;)Ljava/util/Collection;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Ljava/util/Collection;", "source", "convertToSetForSetOperationWith", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Collection;", "", "safeToConvertToSet", "(Ljava/util/Collection;)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BrittleContainsOptimizationKt {
    public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(iterable2, "");
        if (!(iterable instanceof Set)) {
            if (iterable instanceof Collection) {
                if (!(iterable2 instanceof Collection) || ((Collection) iterable2).size() >= 2) {
                    Collection<T> collection = (Collection) iterable;
                    return safeToConvertToSet(collection) ? CollectionsKt.toHashSet(iterable) : collection;
                }
            } else {
                iterable = CollectionSystemProperties.brittleContainsOptimizationEnabled ? CollectionsKt.toHashSet(iterable) : CollectionsKt.toList(iterable);
            }
        }
        return (Collection) iterable;
    }

    public static final <T> Collection<T> convertToSetForSetOperation(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        if (!(iterable instanceof Set)) {
            if (iterable instanceof Collection) {
                Collection<T> collection = (Collection) iterable;
                return safeToConvertToSet(collection) ? CollectionsKt.toHashSet(iterable) : collection;
            }
            iterable = CollectionSystemProperties.brittleContainsOptimizationEnabled ? CollectionsKt.toHashSet(iterable) : CollectionsKt.toList(iterable);
        }
        return (Collection) iterable;
    }

    private static final <T> boolean safeToConvertToSet(Collection<? extends T> collection) {
        return CollectionSystemProperties.brittleContainsOptimizationEnabled && collection.size() > 2 && (collection instanceof ArrayList);
    }

    public static final <T> Collection<T> convertToSetForSetOperation(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return CollectionSystemProperties.brittleContainsOptimizationEnabled ? SequencesKt.toHashSet(sequence) : SequencesKt.toList(sequence);
    }

    public static final <T> Collection<T> convertToSetForSetOperation(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return CollectionSystemProperties.brittleContainsOptimizationEnabled ? ArraysKt.toHashSet(tArr) : ArraysKt.asList(tArr);
    }
}
