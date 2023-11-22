package androidx.core.util;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/core/util/SparseArrayKt$keyIterator$1;", "Lkotlin/collections/IntIterator;", "", "hasNext", "()Z", "", "nextInt", "()I", "getAuthRequestContext", "I", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SparseArrayKt$keyIterator$1 extends IntIterator {
    final /* synthetic */ SparseArray<T> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.MyBillsEntityDataFactory < this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        SparseArray<T> sparseArray = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = i + 1;
        return sparseArray.keyAt(i);
    }
}
