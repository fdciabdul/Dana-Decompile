package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/collection/SparseArrayKt$keyIterator$1;", "Lkotlin/collections/IntIterator;", "", "hasNext", "()Z", "", "nextInt", "()I", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class SparseArrayKt$keyIterator$1 extends IntIterator {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ SparseArrayCompat PlaceComponentResult;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.BuiltInFictitiousFunctionClassFactory < this.PlaceComponentResult.MyBillsEntityDataFactory();
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        SparseArrayCompat sparseArrayCompat = this.PlaceComponentResult;
        int i = this.BuiltInFictitiousFunctionClassFactory;
        this.BuiltInFictitiousFunctionClassFactory = i + 1;
        return sparseArrayCompat.PlaceComponentResult(i);
    }
}
