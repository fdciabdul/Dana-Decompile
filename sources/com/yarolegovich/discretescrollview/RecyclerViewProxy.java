package com.yarolegovich.discretescrollview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public class RecyclerViewProxy {
    RecyclerView.LayoutManager getAuthRequestContext;

    public RecyclerViewProxy(RecyclerView.LayoutManager layoutManager) {
        this.getAuthRequestContext = layoutManager;
    }

    public static void MyBillsEntityDataFactory(View view, RecyclerView.Recycler recycler) {
        recycler.PlaceComponentResult(view);
    }
}
