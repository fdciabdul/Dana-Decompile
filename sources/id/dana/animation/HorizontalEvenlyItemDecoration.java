package id.dana.animation;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class HorizontalEvenlyItemDecoration extends RecyclerView.ItemDecoration {
    private final int PlaceComponentResult = 8;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = this.PlaceComponentResult;
        rect.right = this.PlaceComponentResult;
        rect.bottom = this.PlaceComponentResult;
    }
}
