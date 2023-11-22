package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "array", "", "iterator", "([Ljava/lang/Object;)Ljava/util/Iterator;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> iterator(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return new ArrayIterator(tArr);
    }
}
