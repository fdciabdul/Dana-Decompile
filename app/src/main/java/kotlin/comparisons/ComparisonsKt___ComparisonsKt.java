package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aG\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u0007\u0010\t\u001aK\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n\"\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u0007\u0010\f\u001aG\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\r\u0010\b\u001a?\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\r\u0010\t\u001aK\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n\"\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0004j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\r\u0010\f"}, d2 = {"T", "a", "b", "c", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxOf", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "", "other", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes.dex */
public class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public static final <T> T maxOf(T t, T t2, T t3, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return (T) ComparisonsKt.maxOf(t, ComparisonsKt.maxOf(t2, t3, comparator), comparator);
    }

    public static final <T> T maxOf(T t, T t2, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return comparator.compare(t, t2) < 0 ? t2 : t;
    }

    public static final <T> T maxOf(T t, T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        for (T t2 : tArr) {
            if (comparator.compare(t, t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    public static final <T> T minOf(T t, T t2, T t3, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return (T) ComparisonsKt.minOf(t, ComparisonsKt.minOf(t2, t3, comparator), comparator);
    }

    public static final <T> T minOf(T t, T t2, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "");
        return comparator.compare(t, t2) > 0 ? t2 : t;
    }

    public static final <T> T minOf(T t, T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        for (T t2 : tArr) {
            if (comparator.compare(t, t2) > 0) {
                t = t2;
            }
        }
        return t;
    }
}
