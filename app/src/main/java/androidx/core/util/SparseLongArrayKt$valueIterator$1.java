package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/core/util/SparseLongArrayKt$valueIterator$1;", "Lkotlin/collections/LongIterator;", "", "hasNext", "()Z", "", "nextLong", "()J", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SparseLongArrayKt$valueIterator$1 extends LongIterator {
    final /* synthetic */ SparseLongArray BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.MyBillsEntityDataFactory < this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Override // kotlin.collections.LongIterator
    public final long nextLong() {
        SparseLongArray sparseLongArray = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = i + 1;
        return sparseLongArray.valueAt(i);
    }
}
