package kotlin.ranges;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aB\u0010\r\u001a\u00020\u0000\"\b\b\u0000\u0010\b*\u00020\u0007\"\u0018\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\t*\b\u0012\u0004\u0012\u00028\u00000\n*\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0086\n¢\u0006\u0004\b\r\u0010\u000e\u001a2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000f*\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0015\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014*\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0017"}, d2 = {"", "isPositive", "", "step", "", "checkStepIsPositive", "(ZLjava/lang/Number;)V", "", "T", "", "Lkotlin/ranges/ClosedRange;", "R", LottieParams.KEY_ELEMENT_ID, "contains", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "", "that", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(DD)Lkotlin/ranges/ClosedFloatingPointRange;", "", "(FF)Lkotlin/ranges/ClosedFloatingPointRange;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
class RangesKt__RangesKt {
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(t2, "");
        return new ComparableRange(t, t2);
    }

    public static final ClosedFloatingPointRange<Double> rangeTo(double d, double d2) {
        return new ClosedDoubleRange(d, d2);
    }

    public static final ClosedFloatingPointRange<Float> rangeTo(float f, float f2) {
        return new ClosedFloatRange(f, f2);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lkotlin/ranges/ClosedRange<TT;>;>(TR;TT;)Z */
    private static final boolean contains(Iterable iterable, Object obj) {
        Intrinsics.checkNotNullParameter(iterable, "");
        return obj != null && ((ClosedRange) iterable).contains((Comparable) obj);
    }

    public static final void checkStepIsPositive(boolean z, Number number) {
        Intrinsics.checkNotNullParameter(number, "");
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Step must be positive, was: ");
        sb.append(number);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }
}
