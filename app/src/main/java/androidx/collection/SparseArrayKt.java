package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "", "MyBillsEntityDataFactory", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class SparseArrayKt {
    public static final <T> Iterator<T> MyBillsEntityDataFactory(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
