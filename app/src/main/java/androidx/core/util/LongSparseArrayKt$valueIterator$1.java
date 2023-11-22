package androidx.core.util;

import android.util.LongSparseArray;
import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0006*\u00028\u00008\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\n\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/core/util/LongSparseArrayKt$valueIterator$1;", "", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "", "MyBillsEntityDataFactory", "I", "PlaceComponentResult"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class LongSparseArrayKt$valueIterator$1<T> implements Iterator<T>, KMappedMarker, j$.util.Iterator {
    final /* synthetic */ LongSparseArray<T> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int PlaceComponentResult;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(j$.util.function.Consumer consumer) {
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

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.PlaceComponentResult < this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Override // java.util.Iterator
    public final T next() {
        LongSparseArray<T> longSparseArray = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.PlaceComponentResult;
        this.PlaceComponentResult = i + 1;
        return longSparseArray.valueAt(i);
    }
}
