package id.dana.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class EdgeDecorator extends RecyclerView.ItemDecoration {
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final int getAuthRequestContext;

    public EdgeDecorator(int i, int i2, int i3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = i2;
        this.getAuthRequestContext = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        super.getItemOffsets(rect, view, recyclerView, state);
        if (state.BuiltInFictitiousFunctionClassFactory) {
            i = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i = state.scheduleImpl;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        if (childAdapterPosition == 0) {
            rect.set(this.KClassImpl$Data$declaredNonStaticMembers$2, view.getPaddingTop(), this.getAuthRequestContext, view.getPaddingBottom());
        } else if (i > 0 && childAdapterPosition == i - 1) {
            rect.set(this.MyBillsEntityDataFactory, view.getPaddingTop(), this.KClassImpl$Data$declaredNonStaticMembers$2, view.getPaddingBottom());
        } else {
            rect.set(this.MyBillsEntityDataFactory, view.getPaddingTop(), this.getAuthRequestContext, view.getPaddingBottom());
        }
    }
}
