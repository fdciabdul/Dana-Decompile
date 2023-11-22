package androidx.collection;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0006*\u00028\u00008\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\n\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/collection/SparseArrayKt$valueIterator$1;", "", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class SparseArrayKt$valueIterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    final /* synthetic */ SparseArrayCompat BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArrayKt$valueIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.BuiltInFictitiousFunctionClassFactory = sparseArrayCompat;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 < this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
    }

    @Override // java.util.Iterator
    public final T next() {
        SparseArrayCompat sparseArrayCompat = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
        return (T) sparseArrayCompat.lookAheadTest(i);
    }
}
