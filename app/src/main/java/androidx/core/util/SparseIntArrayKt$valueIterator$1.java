package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/core/util/SparseIntArrayKt$valueIterator$1;", "Lkotlin/collections/IntIterator;", "", "hasNext", "()Z", "", "nextInt", "()I", "MyBillsEntityDataFactory", "I", "PlaceComponentResult"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SparseIntArrayKt$valueIterator$1 extends IntIterator {
    final /* synthetic */ SparseIntArray KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int PlaceComponentResult;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.PlaceComponentResult < this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        SparseIntArray sparseIntArray = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.PlaceComponentResult;
        this.PlaceComponentResult = i + 1;
        return sparseIntArray.valueAt(i);
    }
}
