package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\t\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/core/util/LongSparseArrayKt$keyIterator$1;", "Lkotlin/collections/LongIterator;", "", "hasNext", "()Z", "", "nextLong", "()J", "", "PlaceComponentResult", "I"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {
    final /* synthetic */ LongSparseArray<T> KClassImpl$Data$declaredNonStaticMembers$2;
    public int PlaceComponentResult;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.PlaceComponentResult < this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Override // kotlin.collections.LongIterator
    public final long nextLong() {
        LongSparseArray<T> longSparseArray = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.PlaceComponentResult;
        this.PlaceComponentResult = i + 1;
        return longSparseArray.keyAt(i);
    }
}
