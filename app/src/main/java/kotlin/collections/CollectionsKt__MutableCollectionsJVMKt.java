package kotlin.collections;

import com.alibaba.griver.video.base.BasePlayer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0006\u0010\n\u001a'\u0010\f\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\f\u0010\u0007\u001a=\u0010\f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0010\u001a<\u0010\f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0011j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0012H\u0087\b¢\u0006\u0004\b\f\u0010\u0014\u001a9\u0010\u0015\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0011j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0012¢\u0006\u0004\b\u0015\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "", "value", "", BasePlayer.MODE_FILL, "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "(Ljava/util/List;)V", "Ljava/util/Random;", "random", "(Ljava/util/List;Ljava/util/Random;)V", "", "sort", "Lkotlin/Function2;", "", "comparison", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/List;Ljava/util/Comparator;)V", "sortWith"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    private static final <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    private static final <T> void sort(List<T> list, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function2, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    private static final <T> void fill(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "");
        Collections.fill(list, t);
    }

    private static final <T> void shuffle(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        Collections.shuffle(list);
    }

    private static final <T> void shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(random, "");
        Collections.shuffle(list, random);
    }
}
