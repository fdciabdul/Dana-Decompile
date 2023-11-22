package kotlin;

import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\f¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "other", "", "compareTo", "(Ljava/lang/Comparable;Ljava/lang/Object;)I"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CompareToKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> int compareTo(Comparable<? super T> comparable, T t) {
        Intrinsics.checkNotNullParameter(comparable, "");
        return comparable.compareTo(t);
    }
}
