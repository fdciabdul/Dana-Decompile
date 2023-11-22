package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/paging/OffsettingListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "p0", "p1", "", "p2", "", "getAuthRequestContext", "(IILjava/lang/Object;)V", "PlaceComponentResult", "(II)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/recyclerview/widget/ListUpdateCallback;", "BuiltInFictitiousFunctionClassFactory", "I"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
final class OffsettingListUpdateCallback implements ListUpdateCallback {
    private final int BuiltInFictitiousFunctionClassFactory;
    private final ListUpdateCallback PlaceComponentResult;

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void PlaceComponentResult(int p0, int p1) {
        this.PlaceComponentResult.PlaceComponentResult(p0 + this.BuiltInFictitiousFunctionClassFactory, p1);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0 + this.BuiltInFictitiousFunctionClassFactory, p1);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void getAuthRequestContext(int p0, int p1) {
        ListUpdateCallback listUpdateCallback = this.PlaceComponentResult;
        int i = this.BuiltInFictitiousFunctionClassFactory;
        listUpdateCallback.getAuthRequestContext(p0 + i, p1 + i);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void getAuthRequestContext(int p0, int p1, Object p2) {
        this.PlaceComponentResult.getAuthRequestContext(p0 + this.BuiltInFictitiousFunctionClassFactory, p1, p2);
    }
}
