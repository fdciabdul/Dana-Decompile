package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/core/util/SparseBooleanArrayKt$valueIterator$1;", "Lkotlin/collections/BooleanIterator;", "", "hasNext", "()Z", "nextBoolean", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SparseBooleanArrayKt$valueIterator$1 extends BooleanIterator {
    final /* synthetic */ SparseBooleanArray BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int getAuthRequestContext;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.getAuthRequestContext < this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Override // kotlin.collections.BooleanIterator
    public final boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.getAuthRequestContext;
        this.getAuthRequestContext = i + 1;
        return sparseBooleanArray.valueAt(i);
    }
}
