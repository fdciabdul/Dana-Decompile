package id.dana.richview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public abstract class EndlessOnScrollListener extends RecyclerView.OnScrollListener {
    private int BuiltInFictitiousFunctionClassFactory;
    private boolean getAuthRequestContext;

    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return true;
    }

    public abstract int MyBillsEntityDataFactory();

    public abstract void getAuthRequestContext();

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager == null || !KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        int itemCount = linearLayoutManager.getItemCount();
        int childCount = recyclerView.getChildCount();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (this.getAuthRequestContext && itemCount > this.BuiltInFictitiousFunctionClassFactory) {
            this.BuiltInFictitiousFunctionClassFactory = itemCount;
            this.getAuthRequestContext = false;
        }
        if (this.getAuthRequestContext || !PlaceComponentResult(childCount, itemCount, findFirstVisibleItemPosition)) {
            return;
        }
        this.getAuthRequestContext = true;
        getAuthRequestContext();
    }

    private boolean PlaceComponentResult(int i, int i2, int i3) {
        return i2 - i <= i3 + MyBillsEntityDataFactory();
    }
}
