package id.dana.common;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class OverlapDecoration extends RecyclerView.ItemDecoration {
    private int MyBillsEntityDataFactory;

    public OverlapDecoration(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            return;
        }
        rect.set(0, this.MyBillsEntityDataFactory, 0, 0);
    }
}
