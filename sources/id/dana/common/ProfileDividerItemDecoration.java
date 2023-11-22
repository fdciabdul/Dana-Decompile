package id.dana.common;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class ProfileDividerItemDecoration extends androidx.recyclerview.widget.DividerItemDecoration {
    public ProfileDividerItemDecoration(Context context) {
        super(context, 0);
    }

    @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        }
    }
}
