package id.dana.utils;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes3.dex */
public class CustomLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }
}
