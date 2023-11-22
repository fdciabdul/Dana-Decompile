package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {
    private final RecyclerView.Adapter BuiltInFictitiousFunctionClassFactory;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.BuiltInFictitiousFunctionClassFactory = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void PlaceComponentResult(int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory.notifyItemRangeRemoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void getAuthRequestContext(int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void getAuthRequestContext(int i, int i2, Object obj) {
        this.BuiltInFictitiousFunctionClassFactory.notifyItemRangeChanged(i, i2, obj);
    }
}
